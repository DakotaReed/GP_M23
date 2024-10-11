package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SectionSearchPage {

    @FindBy(css = "input.hsg-search__modal-input")
    public WebElement staticInput_SearchHeaderTitle;

    @FindBy(css = "section.hsg-search__results>div>div>div")
    public List<WebElement> list_searchResults;

    @FindBy(css = "a#modalClose")
    public WebElement btn_closeSearch;

    @FindBy(id = "blog")
    public WebElement radioBtn_blog;

}
