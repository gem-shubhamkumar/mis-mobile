package com.gemini.mis.stepdefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.FeedbackPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class FeedbackSteps {

    @Steps
    CommonFunctions commonFunctions;

    @Steps
    FeedbackPage feedbackPage;

    @When("^User Clicks on \"(.*?)\" tab of \"(.*?)\" tab$")
    public void userClicksOnTab(String childTab, String parentTab) {
        feedbackPage.navigateToTab(childTab, parentTab);
    }

    @Then("^Verify Submit Feedback tab opens$")
    public void verifySubmitFeedbackTabOpen() {
        feedbackPage.verifySubmitFeedbackTabOpen();
    }

    @When("^User enters feedback \"(.*?)\"$")
    public void userEntersFeedback(String value) {
        feedbackPage.enterFeedback(value);
    }

    @And("^Verify data \"(.*?)\" is added in \"(.*?)\" tab$")
    public void verifyFeedbackDataIsAdded(String data, String tab) {
        feedbackPage.verifyData(data, tab);
    }

    @When("^User searches the \"(.*?)\" in search field$")
    public void userSearchesTheInSearchField(String dataToBeSearch) {
        feedbackPage.searchData(dataToBeSearch);
    }

    @Then("^\"(.*?)\" data should appear in \"(.*?)\" tab$")
    public void dataShouldAppear(String data, String tab) {
        feedbackPage.verifyData(data, tab);
    }

    @Then("^Data should not appear in \"(.*?)\" tab$")
    public void dataShouldNotAppear(String tab) {
        feedbackPage.verifyData(tab);
    }

    @When("^User selects \"(.*?)\" of rows to show for \"(.*?)\" tab$")
    public void userSelectsOfRowsToShowForTab(String number, String tab) {
        feedbackPage.selectValue("id", number, "name", tab);
    }

    @Then("^Verify total rows are (\\d+)$")
    public void verifyTotalRowsAre(int number) {
        feedbackPage.verifyRows(number);
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
    public void verifyFileDownloaded(String fileName) {
        commonFunctions.isFileDownloaded("C:\\Users\\si.porwal\\Downloads", fileName);
    }

    @And("^Verify print tab is open$")
    public void verifyPrintTabIsOpen() {
        feedbackPage.verifyPrintTab();
    }

    @And("^Verify data is copied$")
    public void verifyDataIsCopiedForFeedback() {
        feedbackPage.verifyCopy();
    }

    @Then("^Click on Provide Feedback button$")
    public void clickOnProvideFeedbackButton() {
        feedbackPage.clickOnProvideFeedbackButton();
    }

    @Then("^Click on Export Options \"(.*?)\" button$")
    public void clickOnExportOptionsButton(String button) {
        feedbackPage.clickExportButtons(button);
    }

    @Then("^Click on \"(.*?)\" button for pagination$")
    public void clockOnButtonForPagination(String button) {
        feedbackPage.clickPaginationButtons(button);
    }


    @Then("^Click on View button$")
    public void clickOnViewButton() {
        feedbackPage.clickOnViewButton();
    }
}
