package extensions;

import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Verifications extends CommonOps {

//--------  HubSpot  --------
    @Step("Verify x_Axis and y_Axis Elements: 'Search' (SoftAssertion)")
    public static void verifyX_axisY_AxisSearch(int x_axisOfElem, int expectedX_Axis, int y_axisOfElem, int expectedY_Axis) {
        softAssertAxis.assertEquals(x_axisOfElem, expectedX_Axis);
        softAssertAxis.assertEquals(y_axisOfElem, expectedY_Axis);
        softAssertAxis.assertAll();
    }

    @Step("Verify Search Header Title")
    public static void verifySearchHeaderTitle(String textForSearch, String actualTitle) {
        assertEquals(actualTitle, textForSearch);
    }

    @Step("Verify Amount of Search Results")
    public  static void verifyAmountOfSearchResults (int actualAmount, int expectedAmount_OR_NULL) {
        assertTrue(actualAmount == expectedAmount_OR_NULL || actualAmount == 0);
    }

    @Step("Verify Displaying and Enabling of Elements (SoftAssertion)")
    public static void verifyDisplAndEnablOfElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
            softAssert.assertTrue(element.isEnabled());
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertAll();}
    }

    @Step("Verify Same y_Axis Elements")
    public static void verifySameY_axis(int y_axisOfElem1, int y_axisOfElem2_OR_expected) {
        assertEquals(y_axisOfElem1, y_axisOfElem2_OR_expected);
    }

    @Step("Verify Platform Name")
    public static void verifyPlatformName(String platformName, String expectedName) {
        assertTrue(platformName.contains(expectedName));
    }

    @Step("Verify Platform Area Text")
    public static void verifyPlatformText(String platformText, String expectedText) {
        assertEquals(platformText, expectedText);
    }

    @Step("Verify Image Element Visually")
    public static void verifyVisualImageElement(String expectedImageName) {
        wait.until(ExpectedConditions.visibilityOf(hubSpot_Home.btn_search));
        try {
            screen.find(getData("ImageRepo") + expectedImageName + ".png");
        } catch (FindFailed e) {
            System.out.println("Error comparing Image File: " + e);
            fail("Error comparing Image File: " + e);
        }
    }

    @Step("Verify Present Year Included in Copyright")
    public static void verifyPresentYearInCopyright(String textCopyrightRow, String presentYear) {
        assertTrue(textCopyrightRow.contains(presentYear));
    }

//--------  APIDemos  --------
    @Step("Verify 'Hello World' is Displayed")
    public static void verifyHelloWorldIsDisplayed(AndroidElement element) {
        assertTrue(element.isDisplayed());
    }

    @Step("Counting and Verify Amount of All Buttons (SoftAssertion) included AddButton")
    public static void verifyAmountOfButtons(int expectedAmount) {
        softAssert.assertTrue(APIDemos_Buttons.list_AllButtons.size() == expectedAmount);
    }

    @Step("Verify Serviceability of AddButton (SoftAssertion) by Counting All Buttons After Each Addition")
    public static void verifyServiceabilityOfAddButton() {
        for (int i=0; i<5; i++) {
            MobileActions.tap(APIDemos_Buttons.btn_AddNewButton);
            verifyAmountOfButtons(i+2);
        }
        softAssert.assertAll();
    }

    @Step("Verify Pick Contact Buttons Text")
    public static void verifyPickButtonText(String buttonText, String expectedText) {
        assertEquals(buttonText, expectedText);
    }

    @Step("Verify Screen Orientation PORTRAIT (including rotation of screen)")
    public static void verifyScreenOrientationPORT() {
        if (mobileDriver.getOrientation().toString().equalsIgnoreCase("portrait")) {
            MobileActions.setOrientationLAND();
        } else {}
        MobileActions.setOrientationPORT();
        assertTrue(!mobileDriver.getOrientation().equals("Landscape"));
    }

    @Step("Verify Device NOT Locked (including locking and unlocking)")
    public static void verifyDeviceNotLocked() {
        if (mobileDriver.isDeviceLocked()) {
        } else {
            MobileActions.lockingDevice();
        }
        MobileActions.unlockingDevice();
        assertFalse(mobileDriver.isDeviceLocked());

    }

//--------  Students List  --------
    @Step("Verify Status Code")
    public static void verifyStatusCode(int actualCode, int expectedCode) {
        assertEquals(actualCode, expectedCode);
    }

//--------  TodoList  --------
    @Step("Verify Present Date in Header")
    public static void verifyPresentDate(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Mount of Tasks")
    public static void verifyAmountOfTasks(int actual, int expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Name of Tasks")
    public static void verifyNameOfTasks(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Task Completed by Checking 'completed' in Class Name")
    public static void verifyTaskCompleted(String className) {
        assertTrue(className.contains("completed"));
    }

    @Step("Verify 'completed' Included in ClassName (SoftAssertion)")
    public static void verifyCompletedInClassName() {
        softAssert.assertTrue(textOfElement.contains("completed"));
    }

    @Step("Verify All Tasks Completed (using SoftAssertion) by Checking 'completed' in Class Name")
    public static void verifyAllTasksCompleted() {
        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_MainPage.list_tasks));
        for (WebElement task : ToDoList_MainPage.list_tasks) {
            UIActions.getClassName(task);
            verifyCompletedInClassName();
        }
        softAssert.assertAll();
    }

    @Step("Verify 'completed' NOT Included in ClassName (SoftAssertion)")
    public static void verifyNoCompletedInClassName() {
        softAssert.assertFalse(textOfElement.contains("completed"));
    }

    @Step("Verify All Tasks NOT Completed (using SoftAssertion) by Lacking 'completed' in Class Name")
    public static void verifyAllTasksNoCompleted() {
        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_MainPage.list_tasks));
        for (WebElement task : ToDoList_MainPage.list_tasks) {
            UIActions.getClassName(task);
            verifyNoCompletedInClassName();
        }
        softAssert.assertAll();
    }

}
