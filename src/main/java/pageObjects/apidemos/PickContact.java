package pageObjects.apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PickContact {

    private AppiumDriver mobileDriver;

    public PickContact(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Provider']")
    public AndroidElement btn_Provider;

    @AndroidFindBy(xpath = "//*[@text='Pick Contact']")
    public AndroidElement btn_PickContact;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button']")
    public List<AndroidElement> list_AllPickButtons;

}
