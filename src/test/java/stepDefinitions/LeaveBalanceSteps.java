package stepDefinitions;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.pages.LeaveBalancePages;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class LeaveBalanceSteps extends PageObject {

    @Steps
    commonMethods commonFunction;

    @Steps
    LeaveBalancePages leavePages;

    @Then("^Click on \"(.*?)\" tab$")
    public void clickOnParentTabOnly(String parentTab){
        commonFunction.navigateToTab(parentTab);
    }

    @Then("^Verify leave history window closes$")
    public void verifyLeaveHistoryWindowCloses() {

        if(!$(LeaveBalanceSelectors.btnLeaveHistoryClose).isVisible()){
            System.out.println("Leave window closes successfully");
        }else{
            Assert.fail("Leave window is open");
        }
    }

    @And("^Verify \"(.*?)\" is visible on the current screen$")
    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        switch (eleName){
            case "Leave history window":
                $(LeaveBalanceSelectors.gridLeaveHistory).isVisible();
                break;
        }
    }

    @Then("^Verify number of records ar same as displayed on leave card$")
    public void verifyNumberOfRecordsArSameAsDisplayedOnLeaveCard() {
        leavePages.verifyNumberOfRecordsAreSame();
    }
}
