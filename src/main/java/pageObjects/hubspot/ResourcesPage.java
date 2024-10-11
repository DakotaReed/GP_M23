package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResourcesPage {

    @FindBy(css = "ul#hsg-nav-submenu-3")
    public WebElement container_Resources;

}
