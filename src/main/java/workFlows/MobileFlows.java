package workFlows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Go to WebView Page")
    public static void goToWebView() {
        MobileActions.tap(APIDemos_StartPage.btn_Views);
        MobileActions.swipe(MobileActions.Direction.UP);
        MobileActions.swipe(MobileActions.Direction.UP);
        MobileActions.swipe(MobileActions.Direction.UP);
        MobileActions.tap(APIDemos_Views.btn_WebView);
    }

    @Step("Move to Adding Buttons (DefaultLayoutAnimations)")
    public static void goToAddButton() {
        MobileActions.tap(APIDemos_StartPage.btn_Animation);
        MobileActions.tap(APIDemos_Buttons.btn_DefLayAnim);
    }

    @Step("Move to Pick Contact Buttons")
    public static void goToPickContact() {
        MobileActions.tap(APIDemos_StartPage.btn_Content);
        MobileActions.tap(APIDemos_PickContact.btn_Provider);
        MobileActions.tap(APIDemos_PickContact.btn_PickContact);
    }

    @Step("Convert String to Int")
    public static void convertStringToInt(String text) {
        indexOfElement = Integer.parseInt(text)-1;
    }

}
