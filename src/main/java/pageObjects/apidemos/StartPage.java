package pageObjects.apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private AppiumDriver mobileDriver;

    public StartPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Views']")
    public AndroidElement btn_Views;

    @AndroidFindBy(xpath = "//*[@text='Animation']")
    public AndroidElement btn_Animation;

    @AndroidFindBy(xpath = "//*[@text='Content']")
    public AndroidElement btn_Content;

}
