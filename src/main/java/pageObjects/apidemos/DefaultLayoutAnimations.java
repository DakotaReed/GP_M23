package pageObjects.apidemos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DefaultLayoutAnimations {

    private AppiumDriver mobileDriver;

    public DefaultLayoutAnimations(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Default Layout Animations']")
    public AndroidElement btn_DefLayAnim;

    @AndroidFindBy(xpath = "//*[@id='addNewButton']")
    public AndroidElement btn_AddNewButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button']")
    public List<AndroidElement> list_AllButtons;

}
