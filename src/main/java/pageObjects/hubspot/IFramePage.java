package pageObjects.hubspot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFramePage {

//    @FindBy(css = "iframe[title='chat widget']")
    @FindBy(css = "iframe[id='hubspot-conversations-iframe']")
    public WebElement iFrame_HubBotChat;

    @FindBy(css = "button[aria-label*='Dismiss']")
    public WebElement btn_closeChatMiddleOpening;

    @FindBy(css = "button[aria-label='Close live chat']")
    public WebElement btn_closeChatAfterAutoOpen;

}
