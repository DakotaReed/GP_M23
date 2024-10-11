package utilities;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.apidemos.*;
import pageObjects.hubspot.*;
import pageObjects.toDoList.MainPage;
import pageObjects.toDoList.RightMenu;
import java.time.LocalDate;
import java.util.List;

//    allure serve allure-results
public class Base {

//--------General--------
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static SoftAssert softAssertAxis;
    protected static Screen screen;
    protected static DesiredCapabilities dc;
    protected static int listSize;
    protected static String textOfElement;
    protected static int indexOfElement;
    protected static String presentYear;
    protected static LocalDate localDate;
    protected static String presentDate;

//--------Web--------
    protected static WebDriver driver;
    protected static WebElement lastPlatform;

//--------Mobile--------
    protected static AndroidDriver<AndroidElement> mobileDriver;
    protected static TouchAction touchAction;
    protected static MultiTouchAction multiAction;

//--------Rest API--------
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params;
    protected static List<String> allStudentsEmail;
    protected static List<String> allStudentsId;
    protected static String idOfStudent;
    protected static String email;

//--------Electron--------
    protected static ChromeOptions opt;

//--------Page Objects - Web--------
    protected static IFramePage hubSpot_iFrame;
    protected static HomePage hubSpot_Home;
    protected static SectionSearchPage hubSpot_SectionSearch;
    protected static PricingPage hubSpot_Pricing;
    protected static AllProductsPage hubSpot_AllProducts;
    protected static ResourcesPage hubSpot_ResourcesMenu;
    protected static SoftWarePage hubSpot_SoftWareMenu;

//--------Page Objects - Mobile--------
    protected static StartPage APIDemos_StartPage;
    protected static ViewsPage APIDemos_Views;
    protected static WebViewPage APIDemos_WebViews;
    protected static DefaultLayoutAnimations APIDemos_Buttons;
    protected static PickContact APIDemos_PickContact;

//--------Page Objects - Electron--------

    protected static MainPage ToDoList_MainPage;
    protected static RightMenu ToDoList_RightMenu;

}
