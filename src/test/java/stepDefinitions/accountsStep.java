package stepDefinitions;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.pages.AccountPortalPages;
import com.gemini.mis.selectors.accountPageSelectors;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class accountsStep {

    @Steps
    commonMethods commonfunction;

    @Steps
    AccountPortalPages accountPages;

    @Given("^Navigate to \"(.*?)\"$")
    public void launchURL(String websiteName){
        commonfunction.navigateTo(websiteName);
    }
    @And("^Click on \"(.*?)\"$")
    public void clickBtn(String eleName){
        accountPages.clickOnElement(eleName);
    }
    @And("^Verify login is successful$")
    public void verifyLogInToMyMIS(){
        commonfunction.isElementFound(accountPageSelectors.btnChangeADPassword);
    }
    @Then("^Click on \"(.*?)\" sub-tab inside \"(.*?)\" tab$")
    public void navigateToSubTab(String subTab,String menuTab){
        commonfunction.navigateToChildTab(subTab,menuTab);
    }
     @But("^Verify new tab is open \"(.*?)\" as page heading$")
    public void verifyNewTabOpened(String newTabHeading){
         accountPages.verifyNewWindowTabIsOpen(newTabHeading);
     }
     @When("^On new tab : \"(.*?)\"$")
    public void verifyPageTitle(String currentPageTitle){
        commonfunction.verifyPageTitle(currentPageTitle);
     }
     @Then("^Verify \"(.*?)\" is present on the page$")
    public void verifyPageElementOnCurrentPage(String eleName){
         accountPages.verifyElementOnCurrentPage(eleName);
     }
     @And("^Verify \"(.*?)\" text is present on the current page$")
    public void verifyTextOnCurrentPage(String text){
         accountPages.verifyTextPresent(text);
     }
     @Then("^Enter credentials to \"(.*?)\" using username as \"(.*?)\" and password as \"(.*?)\"$")
    public void enterCredentials(String portalName,String username,String password){
        commonfunction.verifyCredentialsEnterInField(portalName,username,password);
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

}


