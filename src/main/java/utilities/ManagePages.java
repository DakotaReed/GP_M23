package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.apidemos.*;
import pageObjects.hubspot.*;
import pageObjects.toDoList.MainPage;
import pageObjects.toDoList.RightMenu;

public class ManagePages extends Base {

    public static void initHubSpot() {
        hubSpot_iFrame = PageFactory.initElements(driver, IFramePage.class);
        hubSpot_Home = PageFactory.initElements(driver, HomePage.class);
        hubSpot_SectionSearch = PageFactory.initElements(driver, SectionSearchPage.class);
        hubSpot_AllProducts = PageFactory.initElements(driver, AllProductsPage.class);
        hubSpot_ResourcesMenu = PageFactory.initElements(driver, ResourcesPage.class);
        hubSpot_SoftWareMenu = PageFactory.initElements(driver, SoftWarePage.class);
        hubSpot_Pricing = PageFactory.initElements(driver, PricingPage.class);
    }

    public static void initAPIDemos() {
        APIDemos_StartPage = new StartPage(mobileDriver);
        APIDemos_Views = new ViewsPage(mobileDriver);
        APIDemos_WebViews = new WebViewPage(mobileDriver);
        APIDemos_Buttons = new DefaultLayoutAnimations(mobileDriver);
        APIDemos_PickContact = new PickContact(mobileDriver);
    }

    public static void initToDoList() {
        ToDoList_MainPage = PageFactory.initElements(driver, MainPage.class);
        ToDoList_RightMenu = PageFactory.initElements(driver, RightMenu.class);
    }

}
