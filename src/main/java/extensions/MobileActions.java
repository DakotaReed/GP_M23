package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.offset.PointOption.point;

public class MobileActions extends CommonOps {

    @Step("Tap on Element")
    public static void tap(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        touchAction.tap(new TapOptions().withElement(ElementOption.element(element))).perform();
    }

    @Step("Set orientation Landscape")
    public static void setOrientationLAND() {
        mobileDriver.rotate(ScreenOrientation.LANDSCAPE);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Set orientation Portrait")
    public static void setOrientationPORT() {
        mobileDriver.rotate(ScreenOrientation.PORTRAIT);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Lock Device")
    public static void lockingDevice() {
        mobileDriver.lockDevice();
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
    }

    @Step("Unlock Device")
    public static void unlockingDevice() {
        mobileDriver.unlockDevice();
        Uninterruptibles.sleepUninterruptibly(2000, TimeUnit.MILLISECONDS);
    }

    @Step("Getting Text")
    public static void getText(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        textOfElement = element.getText();
    }

    @Step("Updating text")
    public static void updateText(MobileElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Send Keyboard Enter")
    public static void sendKeyboardEnter(MobileElement element) {
        mobileDriver.executeScript("seetest:client.deviceAction(\"Enter\")");
    }

    @Step("Switch to Context")
    public static void switchToContext(String context) {
        mobileDriver.context(context);
    }

    @Step("Swipe")
    public static void swipe(Direction dir) {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        System.out.println("swipeScreen(): '" + dir + "'");
        final int ANIMATION_TIME = 200; // ms
        final int PRESS_TIME = 200; // ms
        int edgeBorder = 10;
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = mobileDriver.manage().window().getSize();
        pointOptionStart = point(dims.width / 2, dims.height / 2);
        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): '" + dir + "' NOT supported");
        }
        try {
            new TouchAction(mobileDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;        }
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e)
        {}
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }

}
