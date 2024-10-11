package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.util.Calendar;
import java.util.List;

public class UIActions extends CommonOps {

//--------HubSpot--------
    @Step("Change Window Size")
    public static void changeWindowSize(int width, int height) {
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    @Step("Click on Element")
    public static void click(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Getting x_Axis of Element")
    public static int getX_AxisOfElement(WebElement element) {
        return element.getLocation().getX();
    }

    @Step("Getting y_Axis of Element")
    public static int getY_AxisOfElement(WebElement element) {
        return element.getLocation().getY();
    }

    @Step("Mouse Hover")
    public static void mouseHover(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    @Step("Getting Value")
    public static void getValue(WebElement element) {
        textOfElement = element.getAttribute("value");
    }

    @Step("Updating Text")
    public static void updateText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

//    @Step("Updating text as human")
//    public static void updateTextAsHuman(WebElement elem, String text) {
//        wait.until(ExpectedConditions.visibilityOf(elem));
//        for (char ch : text.toCharArray()) {
//            Uninterruptibles.sleepUninterruptibly(400, TimeUnit.MILLISECONDS);
//            elem.sendKeys(ch + "");
//        }
//    }

    @Step("Clicking KeyBoard Button")
    public static void sendKeyboardButton(WebElement element, Keys value) {
        element.sendKeys(value);
    }

    @Step("Getting List Size")
    public static void getListSize(List<WebElement> list) {
        listSize = list.size();
    }

    @Step("Getting Text")
    public static void getText(WebElement element) {
        textOfElement = element.getText();
    }

    @Step("Getting Present Year")
    public static void getPresentYear() {
        presentYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    }

//--------ToDoList--------
    @Step("Double Click")
    public static void doubleClick(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        actions.doubleClick(element).build().perform();
    }

    @Step("Clearing Input Area")
    public static void clearingInputArea(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    @Step("Getting ClassName")
    public static void getClassName(WebElement element) {
        textOfElement = element.getAttribute("class");
    }

}
