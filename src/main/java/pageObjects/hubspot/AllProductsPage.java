package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AllProductsPage {

    @FindBy(id = "down-arrow")
    public WebElement btn_upOrDownArrow;

    @FindBy(css = "ul.tab-list>li")
    public List<WebElement> list_allPlatforms;

    @FindBy(css = "div.gs-products-b-card--description")
    public List<WebElement> list_areasTextOfProduct;

}
