package pageObjects.toDoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class RightMenu {

    @FindBy(css = "div[class*='content']")
    public WebElement div_contentRightMenu;

    @FindBy(css = "div[class*='statusWrapper']>button[class*='filterButton']")
    public List<WebElement> list_btnsStatus;

}
