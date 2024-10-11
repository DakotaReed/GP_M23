package sanity;

import io.qameta.allure.Description;
import extensions.UIActions;
import extensions.Verifications;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ExecutionData;
import workFlows.WebFlows;

//@Listeners(utilities.ListenersAuto.class)
public class HubSpot_Web extends CommonOps {

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_DESIGN, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 01: Verify x_Axis and y_Axis of 'SearchIcon'")
    @Description("Verify Same x_Axis and y_Axis of Element 'Search' MAXSIZE window (using SoftAssert)")
    public void Test01_verifyX_axisY_AxisSearch() {
        Verifications.verifyX_axisY_AxisSearch(UIActions.getX_AxisOfElement(hubSpot_Home.btn_search), Integer.parseInt(getData("x_AxisOfElementSearchMAX")), UIActions.getY_AxisOfElement(hubSpot_Home.btn_search), Integer.parseInt(getData("y_AxisOfElementSearch")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_DESIGN, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 02: Verify Same y_Axis of 'SearchIcon'", dataProvider = "data-provider-resolutions", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Same y_Axis of Element 'Search' OTHER_SIZE window (using DDT)")
    public void Test02_verifyY_AxisSearch(String width, String height) {
        UIActions.changeWindowSize(Integer.parseInt(width), Integer.parseInt(height));
        Verifications.verifySameY_axis(UIActions.getY_AxisOfElement(hubSpot_Home.btn_search), Integer.parseInt(getData("y_AxisOfElementSearch")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 03: Verify Search Input Header Title", dataProvider = "data-provider-textForSearch", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Search Input Header Title (using DDT)")
    public void Test03_verifySearchHeaderTitle(String textForSearch) {
        WebFlows.searchOnSite(textForSearch);
        UIActions.getValue(hubSpot_SectionSearch.staticInput_SearchHeaderTitle);
        UIActions.click(hubSpot_SectionSearch.btn_closeSearch);
        Verifications.verifySearchHeaderTitle(textOfElement, textForSearch);
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 04: Verify Amount of Search Results COM", dataProvider = "data-provider-textForSearch", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Amount of Search Results ON COM (using DDT)")
    public void Test04_verifyAmountOfSearchResults(String textForSearch) {
        WebFlows.searchOnSite(textForSearch);
        UIActions.getListSize(hubSpot_SectionSearch.list_searchResults);
        UIActions.click(hubSpot_SectionSearch.btn_closeSearch);
        Verifications.verifyAmountOfSearchResults(listSize, Integer.parseInt(getData("ResultsListSearch")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_AMOUNT, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 05: Verify Amount of Search Results BLOG", dataProvider = "data-provider-textForSearch", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Amount of Search Results ON BLOG (using DDT)")
    public void Test05_verifyAmountOfSearchResults(String textForSearch) {
        WebFlows.searchOnSite(textForSearch);
        WebFlows.choiceSearchComOrBlog(hubSpot_SectionSearch.radioBtn_blog);
        UIActions.getListSize(hubSpot_SectionSearch.list_searchResults);
        UIActions.click(hubSpot_SectionSearch.btn_closeSearch);
        Verifications.verifyAmountOfSearchResults(listSize, Integer.parseInt(getData("ResultsListSearch")));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_ACTIVITY, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 06: Verify Displaying and Enabling of Links")
    @Description("Verify Displaying and Enabling of Links 'Resources Menu' (using SoftAssert)")
    public void Test06_verifyDisplayingAndEnablingOfLinks () {
        UIActions.mouseHover(hubSpot_Home.btn_Resources);
        Verifications.verifyDisplAndEnablOfElements(WebFlows.findAllLinksInContainer(hubSpot_ResourcesMenu.container_Resources));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_DESIGN, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 07: Verify Same y_Axis 'Professional', 'Enterprise'")
    @Description("Verify same y_axis of 'Professional', 'Enterprise' MAXSIZE window")
    public void Test07_verifySameY_axisProductsAndBundles() {
        UIActions.click(hubSpot_Home.btn_Pricing);
        Verifications.verifySameY_axis(UIActions.getY_AxisOfElement(hubSpot_Pricing.versionsToBuy.get(0)), UIActions.getY_AxisOfElement(hubSpot_Pricing.versionsToBuy.get(1)));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 08: Verify Last Platform Name")
    @Description("Verify Last Platform Name 'FREE'")
    public void Test08_verifyPlatformName() {
        WebFlows.overviewOfAllProducts();
        WebFlows.lookingForProducts();
        WebFlows.findLastPlatform();
        UIActions.getText(lastPlatform);
        Verifications.verifyPlatformName(textOfElement, getData("LastPlatformName"));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 09: Verify Platform Area Text")
    @Description("Verify Platform Area Text")
    public void Test09_verifyPlatformAreaText() {
        WebFlows.overviewOfAllProducts();
        WebFlows.lookingForProducts();
        WebFlows.choicePlatform("Customer Service");
        WebFlows.getTextAreaOfProduct(indexOfElement);
        Verifications.verifyPlatformText(textOfElement, getData("AreaTextPlatform"));
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_CONFORMITY, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 10: Verify Element Visually (Image)")
    @Description("Verify Element Visually (using Sikuli Tool)")
    public void Test10_verifySearchIcon() {
        Verifications.verifyVisualImageElement("SearchIcon");
    }

    @ExecutionData(name = ExecutionData.Testers.DAKOTA, category = ExecutionData.Category.SANITY_COPYRIGHT, company = "Thanks to ATID College")
    @Test(groups = "sanity", description = "Test 11: Verify Present Year Included in Copyright")
    @Description("Verify Present Year Included in Copyright")
    public void Test11_verifyPresentYearIncludedInCopyright() {
        UIActions.getText(hubSpot_Home.static_CopyrightRow);
        UIActions.getPresentYear();
        Verifications.verifyPresentYearInCopyright(textOfElement, presentYear);
    }

}
