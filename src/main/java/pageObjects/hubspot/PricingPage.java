package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PricingPage {

//    @FindBy(css = "a[data-tab-id='products']")
//    public WebElement link_ProductsAndPlans;
//
//    @FindBy(css = "a[data-tab-id='bundle']")
//    public WebElement link_Bundles;

    @FindBy(css = "div[class='display-flex align-center']")
    public List<WebElement> versionsToBuy;

}
