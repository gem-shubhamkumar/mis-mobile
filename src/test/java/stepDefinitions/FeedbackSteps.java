package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.pages.FeedbackPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FeedbackSteps {

    @Steps
    CommonPage commonPages;

    @Steps
    CommonFunctions commonFunctions;

    @Steps
    FeedbackPage feedbackPage;

    @When("^User Clicks on \"(.*?)\" tab of \"(.*?)\" tab$")
    public void userClicksOnTab(String childTab, String parentTab) {
        commonFunctions.navigateToTab(childTab, parentTab);
    }

    @Then("^Verify Submit Feedback tab opens$")
    public void verifySubmitFeedbackTabOpen() {
        feedbackPage.verifySubmitFeedbackTabOpen();
    }

    @When("^User enters feedback \"(.*?)\"$")
    public void userEntersFeedback(String value) {
        feedbackPage.enterFeedback(value);
    }

    @And("^Verify feedback data \"(.*?)\" is added$")
    public void verifyFeedbackDataIsAdded(String data) {
        feedbackPage.verifyData(data);
    }

    @When("^User searches the feedback \"(.*?)\" in search field$")
    public void userSearchesTheFeedbackInSearchField(String dataToBeSearch) {
        feedbackPage.searchData(dataToBeSearch);
    }

    @Then("^\"(.*?)\" data should appear$")
    public void dataShouldAppear(String data) {
        feedbackPage.verifyData(data);
    }

    @Then("^Data should not appear$")
    public void dataShouldNotAppear() {
        feedbackPage.verifyData();
    }

    @Then("^Sync with latest page$")
    public void syncWithLatestPage() {
        feedbackPage.syncWithLatestPage();
    }
}
