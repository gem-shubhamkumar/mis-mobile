package stepDefinitions;


import com.gemini.mis.commonFunctions.CommonFunctions;
import com.gemini.mis.pages.AccountPortalPages;
import com.gemini.mis.pages.LeaveBalancePages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class LeaveBalanceSteps extends PageObject {

     AccountPortalPages accountPage;

    @Steps
    LeaveBalancePages leavePages;

    @Steps
    CommonFunctions commonMethods;

    @Then("^Click on \"(.*?)\" tab inside \"(.*?)\" $")
    public void clickOnParentTab(String parentTab){
        accountPage.navigateToTab(parentTab);
    }

    @Then("^Verify leave history window closes$")
    public void VerifyIsLeaveWindowCloses(){
        leavePages.verifyLeaveHistoryWindowCloses();
    }

    @And("^Verify \"(.*?)\" is visible on the current screen$")
    public void verifyIsElementVisible(String elName){
        leavePages.verifyIsVisibleOnTheCurrentScreen(elName);
    }

    @Then("^Verify number of records ar same as displayed on leave card$")
    public void verifyNumberOfRecordsArSameAsDisplayedOnLeaveCard() {
        leavePages.verifyNumberOfRecordsAreSame();
    }

    @Then("^Click on \"(.*?)\" parent tab$")
    public void clickOnTab(String ParentTabName) {
        commonMethods.navigateToTab(ParentTabName);
    }
}
