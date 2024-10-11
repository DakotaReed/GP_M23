package sanity;

import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.MobileFlows;

@Listeners(utilities.ListenersAuto.class)
public class APIDemos_Mobile extends CommonOps {

    @Test(description = "Test 01: Verify 'Hello World' is Displayed")
    @Description("Verify 'Hello World'  is Displayed")
    public void Test01_VerifyHelloWorldDisplayed() {
        MobileFlows.goToWebView();
        Verifications.verifyHelloWorldIsDisplayed(APIDemos_WebViews.staticTxt_WebViewPage);
    }

    @Test(description = "Test 02: Verify Serviceability of AddButton")
    @Description("Verify Serviceability of button 'AddButton' (using SoftAssert)")
    public void Test02_VerifyServiceabilityOfAddButton() {
        MobileFlows.goToAddButton();
        Verifications.verifyServiceabilityOfAddButton();
    }

    @Test(description = "Test 03: Verify Text on Pick Contact Button", dataProvider = "data-provider-buttonsNumbersAndNames", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Text on Pick Contact Button (using DDT)")
    public void Test03_VerifyPickButtonText(String numberOfButton, String expectedText) {
        MobileFlows.goToPickContact();
        MobileFlows.convertStringToInt(numberOfButton);
        MobileActions.getText(APIDemos_PickContact.list_AllPickButtons.get(indexOfElement));
        Verifications.verifyPickButtonText(textOfElement, expectedText);
    }

    @Test(description = "Test 04: Verify Screen Orientation PORTRAIT")
    @Description("Verify Screen Orientation PORTRAIT (including rotation of screen)")
    public void Test04_VerifyScreenOrientationPORT() {
        Verifications.verifyScreenOrientationPORT();
    }

    @Test(description = "Test 05: Verify Device NOT Locked")
    @Description("Verify Device NOT Locked (including locking and unlocking)")
    public void Test05_VerifyDeviceNotLocked() {
        Verifications.verifyDeviceNotLocked();
    }

}
