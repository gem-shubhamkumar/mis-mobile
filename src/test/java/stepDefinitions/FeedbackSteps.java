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

    @When("^User selects \"(.*?)\" of rows to show$")
    public void userSelectsOfRowsToShow(String number) {
        commonPages.selectValue("tblFeedback_length", number, "name");
    }

    @Then("^Verify total rows are (\\d+)$")
    public void verifyTotalRowsAre(int number) {
        commonPages.verifyRows(number);
    }

    @When("^User clicks on Feedback row$")
    public void userClicksOnRow() {
        feedbackPage.clickRow();
    }

    @Then("^Verify data is in \"(.*?)\" order$")
    public void verifyDataIsInOrder(String order) {
        feedbackPage.verifyOrder(order);
    }

    @When("^User hovers over last View Action button$")
    public void userHoversOverLastViewActionButton() {
        feedbackPage.hoverOverView();
    }

    @Then("^Verify the \"(.*?)\" tooltip text$")
    public void verifyTheTooltipText(String text) {
        feedbackPage.tooltipText(text);
    }

    @Then("^Verify message \"(.*?)\" is present$")
    public void verifyMessageIsPresent(String message) {
        feedbackPage.verifyMessage(message);
    }

    @And("^Verify export options open$")
    public void verifyExportOptionsOpen() {
        feedbackPage.veifyExportOptions();
    }

    @And("^Verify \"(.*?)\" file is downloaded$")
    public void verifyFileDownloaded(String fileType) {
        feedbackPage.verifyFileDownloaded(fileType);
    }

    @And("^Verify print tab is open$")
    public void verifyPrintTabIsOpen() {
        feedbackPage.verifyPrintTab();
    }

    @And("^Verify data is copied$")
    public void verifyDataIsCopied() {
        feedbackPage.verifyCopy();
    }
}
