package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoftWarePage {

    @FindBy(css = "a.ga_nav_link.hsg-nav__box-link.nav-software-platform")
    public WebElement link_overviewOfAll;

}
