package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.AccountPortalPages;
import com.gemini.mis.selectors.AccountPortalSelectors;
import io.cucumber.java.en.*;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class AccountPortalSteps extends PageObject {

    CommonFunctions commonMethod;

    @Steps
    AccountPortalPages accountPages;

    @Given("^Navigate to \"(.*?)\"$")
    public void launchURL(String websiteName){
        accountPages.navigateTo(websiteName);
    }
    @And("^Click on \"(.*?)\"$")
    public void clickBtn(String eleName){
        accountPages.clickOnElement(eleName);
    }
    @And("^Verify login is successful$")
    public void verifyLogInToMyMIS(){
        accountPages.isElementFound(AccountPortalSelectors.btnChangeADPassword);
    }
    @Then("^Click \"(.*?)\" sub-tab inside \"(.*?)\" tab$")
    public void clickSubTab(String subTab,String menuTab){
        commonMethod.navigateToTab(menuTab,subTab);
    }
     @But("^Verify new tab is open \"(.*?)\" as page heading$")
    public void verifyNewTabOpened(String newTabHeading){
         accountPages.verifyNewWindowTabIsOpen(newTabHeading);
     }
     @When("^On new tab : \"(.*?)\"$")
    public void verifyPageTitle(String currentPageTitle){
        accountPages.verifyPageTitle(currentPageTitle);
     }
     @Then("^Verify \"(.*?)\" is present on the current page$")
    public void verifyPageElementOnCurrentPage(String eleName){
         waitABit(1500);
         accountPages.verifyElementOnCurrentPage(eleName);
     }
     @And("^Verify \"(.*?)\" text is present on the current page$")
    public void verifyTextOnCurrentPage(String text){
         accountPages.verifyTextPresent(text);
     }
     @Then("^Enter credentials to \"(.*?)\" using username as \"(.*?)\" and password as \"(.*?)\"$")
    public void enterCredentials(String portalName,String username,String password){
        accountPages.verifyCredentialsEnterInField(portalName,username,password);
     }
     @Then("^Verify View My Info options are present$")
    public void verifyViewMyInfoListIsAvailable(){
      accountPages.verifyEleAreAvailableOnViewMyInfo();
     }
    @Then("Verify all element on greytHR landing page are visible")
    public void verifyElementOnGreytHRlandingPage() {
     accountPages.verifyGreytHrlandingPageEle();
    }
    @Then("^Verify all elements are present on view login history page$")
    public void verifyViewLoginHistoryPageEle(){
        accountPages.verifyHeaderElementsArePresent();
    }
    @And("^Close GreytHR portal tab and verify landed to myMis tab$")
    public void verifyUserLandedToMisPortal(){
         accountPages.verifyLandingToMyMIS();
    }


}


