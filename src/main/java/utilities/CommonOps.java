package utilities;

import extensions.UIActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workFlows.ElectronFlows;
import workFlows.WebFlows;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.Method;

public class CommonOps extends Base {

    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else
            throw new RuntimeException("Invalid browser type");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(getData("URL"));
        ManagePages.initHubSpot();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", getData("reportDirectory"));
        dc.setCapability("reportFormat", getData("reportFormat"));
        dc.setCapability("testName", getData("testName"));
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        dc.setCapability("appWaitDuration", 10000);
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("LocalHost")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server. See details: "+e);
        }
        ManagePages.initAPIDemos();
        mobileDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, 5);
        touchAction = new TouchAction(mobileDriver);
//        multiAction = new MultiTouchAction(mobileDriver);
    }

    public static void initAPI() {
        RestAssured.baseURI = getData("UrlAPI");
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriver"));
        opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc = new DesiredCapabilities();
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 2);
        actions = new Actions(driver);
        ManagePages.initToDoList();
    }

    @BeforeClass(groups = "sanity")
    public void startSession() {
        if (getData("PlatformNameOfTest").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserType"));
        else if (getData("PlatformNameOfTest").equalsIgnoreCase("mobile"))
            initMobile();
        else if (getData("PlatformNameOfTest").equalsIgnoreCase("api"))
            initAPI();
        else if (getData("PlatformNameOfTest").equalsIgnoreCase("electron"))
            initElectron();
        else
            throw new RuntimeException("Invalid platform");
        softAssert = new SoftAssert();
        softAssertAxis = new SoftAssert();
        screen = new Screen();
        if (getData("PlatformNameOfTest").equalsIgnoreCase("web"))
            if (driver.getCurrentUrl().equals("https://www.hubspot.com/"))
                UIActions.click(hubSpot_Home.btn_declineCookies);
    }

    @AfterClass(groups = "sanity")
    public void closeSession() {
        if (!getData("PlatformNameOfTest").equalsIgnoreCase("api")) {
            if (!getData("PlatformNameOfTest").equalsIgnoreCase("mobile")) {
                driver.quit();
            } else
                mobileDriver.quit();
        }
    }

    @BeforeMethod(groups = "sanity")
    public void beforeMethod(Method method) {
        if (!getData("PlatformNameOfTest").equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.startRecord(method.getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            if (getData("PlatformNameOfTest").equalsIgnoreCase("electron"))
                if (getData("ElectronAppPath").contains("Todolist")) {
                    if (ToDoList_RightMenu.div_contentRightMenu.isDisplayed()) {
                    } else
                        UIActions.click(ToDoList_MainPage.btn_rightMenu);
                    wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_RightMenu.list_btnsStatus));
                    UIActions.click(ToDoList_RightMenu.list_btnsStatus.get(0));
                    if (ElectronFlows.getAmountOfTasks() > 0) {
                        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_MainPage.list_tasks));
                        for (int i=0; i < listSize; i++)
                            ElectronFlows.deleteTask(0);
                    }
                }

            if (getData("PlatformNameOfTest").equalsIgnoreCase("mobile"))
                if (getData("testName").equalsIgnoreCase("APIDemos"))
                    mobileDriver.launchApp();

            if (getData("PlatformNameOfTest").equalsIgnoreCase("web")) {
                driver.manage().window().maximize();
                driver.get(getData("URL"));
                wait.until(ExpectedConditions.visibilityOf(hubSpot_Home.div_iFrameContainer));
                int elementWidth = hubSpot_Home.div_iFrameContainer.getSize().getWidth();
                int elementHeight = hubSpot_Home.div_iFrameContainer.getSize().getHeight();
                if (elementWidth == 100 && elementHeight == 96) {
                } else if (elementWidth == 0 && elementHeight == 0) {
                } else if (elementWidth == 420 && elementHeight == 674) {
                    driver.switchTo().frame(hubSpot_iFrame.iFrame_HubBotChat);
                    WebFlows.closeChatIFrame(hubSpot_iFrame.btn_closeChatAfterAutoOpen);
                    driver.switchTo().defaultContent();
                } else {
                    driver.switchTo().frame(hubSpot_iFrame.iFrame_HubBotChat);
                    WebFlows.closeChatIFrame(hubSpot_iFrame.btn_closeChatMiddleOpening);
                    driver.switchTo().defaultContent();
                }
            }
        }
    }

}