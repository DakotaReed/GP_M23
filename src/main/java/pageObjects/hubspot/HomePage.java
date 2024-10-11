package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(linkText = "Decline")
    public WebElement btn_declineCookies;

    @FindBy(id = "hubspot-messages-iframe-container")
    public WebElement div_iFrameContainer;

    @FindBy(css = "li.hsg-nav__group-item.hsg-nav__group-item--search")
    public WebElement btn_search;

    @FindBy(css = "input[data-id='hsg-nav__search-input']")
    public WebElement txt_search;

    @FindBy(css = "li.hsg-nav__group-item.hsg-nav__group-item--order-3.hsg-nav__group-item--has-dropdown>div>button>span")
    public WebElement btn_Resources;

//    @FindBy(css = "a[data-ga_nav_tree_text='Pricing']")
    @FindBy(css = "a.ga_nav_link.hsg-nav__link.hsg-nav__link-active ")
    public WebElement btn_Pricing;

    @FindBy(css = "li.hsg-nav__group-item.hsg-nav__group-item--order-1.hsg-nav__group-item--has-dropdown")
    public WebElement btn_SoftWare;

    @FindBy(css = "div.hsg-footer__logo>p")
    public WebElement static_CopyrightRow;
}
