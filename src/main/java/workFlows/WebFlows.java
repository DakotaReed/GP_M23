package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Close ChatIFrame")
    public static void closeChatIFrame(WebElement closeButton) {
        UIActions.click(closeButton);
    }

    @Step("Business Flow: Search on Site")
    public static void searchOnSite(String textForSearch) {
        UIActions.click(hubSpot_Home.btn_search);
        UIActions.updateText(hubSpot_Home.txt_search, textForSearch);
        UIActions.sendKeyboardButton(hubSpot_Home.txt_search, Keys.ENTER);
    }

    @Step("Business Flow: Search Com or Blog")
    public static void choiceSearchComOrBlog(WebElement element) {
        UIActions.click(element);
    }


    @Step("Business Flow: Find All Links in Element")
    public static List<WebElement> findAllLinksInContainer(WebElement container) {
        return container.findElements(By.tagName("a"));
    }

    @Step("Business Flow: Overview of All Products")
    public static void overviewOfAllProducts() {
        UIActions.mouseHover(hubSpot_Home.btn_SoftWare);
        UIActions.click(hubSpot_SoftWareMenu.link_overviewOfAll);
    }

    @Step("Business Flow: Looking For All Products(Platforms)")
    public static void lookingForProducts() {
        UIActions.click(hubSpot_AllProducts.btn_upOrDownArrow);
    }

    @Step("Business Flow: Find Last Platform")
    public static void findLastPlatform() {
        wait.until(ExpectedConditions.visibilityOfAllElements(hubSpot_AllProducts.list_allPlatforms));
        for (int i=0; i<hubSpot_AllProducts.list_allPlatforms.size(); i++) {
            lastPlatform = hubSpot_AllProducts.list_allPlatforms.get(hubSpot_AllProducts.list_allPlatforms.size() - 1);
        }
    }

    @Step("Business Flow: Choice Platform")
    public static void choicePlatform(String platformName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(hubSpot_AllProducts.list_allPlatforms));
        for (int i=0; i<hubSpot_AllProducts.list_allPlatforms.size(); i++) {
            UIActions.getText(hubSpot_AllProducts.list_allPlatforms.get(i));
            if (textOfElement.equalsIgnoreCase(platformName)) {
                indexOfElement = i;
                UIActions.click(hubSpot_AllProducts.list_allPlatforms.get(i));
                break;
            }
        }
    }

    @Step("Business Flow: Getting Area Text of Product")
    public static void getTextAreaOfProduct(int indexOfProduct) {
        for (int i=0; i<hubSpot_AllProducts.list_areasTextOfProduct.size(); i++) {
            UIActions.getText(hubSpot_AllProducts.list_areasTextOfProduct.get(indexOfProduct));
            break; }
    }

}
