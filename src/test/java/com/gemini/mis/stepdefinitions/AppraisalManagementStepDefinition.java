package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.AppraisalManagementAddGoalsPages;
import com.gemini.mis.selectors.AppraisalManagementAddGoalsLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;


public class AppraisalManagementStepDefinition extends PageObject {

    @Steps
    AppraisalManagementAddGoalsPages goalPages;

    AppraisalManagementAddGoalsLocators myGoalSelectors;

    int numberOfPages;

    @And("^Verify Add goal window opens$")
    public void verifyAddGoalWindow(){
        goalPages.isElementVisible(myGoalSelectors.tabDelivery,"delivery tab");
    }

    @And("^Verify that \"(.*?)\" text is present on the current page$")
    public void verifyTextOnCurrentPage(String text){
        goalPages.verifyTextPresent(text);
    }

    @Then("Is AddOrUpdateGoals displayed")
    public void isAddOrUpdateGoals(){
        goalPages.isAddOrUpdateGoals();
    }

    @Then("^Verify \"(.*?)\" Message$")
    public void verifyMessage(String message){
        goalPages.verifyMessage(message);
    }

    @Then("^click on \"(.*?)\" option in add new KPI row$")
    public void addOrRemoveKPIRow(String optionName){
        goalPages.addOrRemoveKPIRow(optionName);
    }

    @And("verify KPI row added")
    public void verifyKPIAdded(){
      goalPages.verifyKPIAdded();
    }

    @And("verify KPI row removed")
    public void verifyKPIRemoved(){
       goalPages.verifyKPIRemoved();
        }

    @And("^Enter \"(.*?)\" in \"(.*?)\" text field$")
    public void verifyTextFieldAndEnterText(String textToType,String fieldName){
        goalPages.enterTextInField(textToType,fieldName);
    }

    @Then("^Select \"(.*?)\" from the rows dropdown$")
    public void clickFromRowDropDown(String numOfRows){
        goalPages.clickFromRowDropDown(numOfRows);
    }

    @And("^Verify \"(.*?)\" is visible on the current screen$")
    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        goalPages.verifyIsVisibleOnTheCurrentScreen(eleName);
    }

    @And("^Click on \"(.*?)\" button$")
    public void clickOnBtn(String eleName){
        goalPages.clickOnElement(eleName);
    }

    @Then("verify number of rows from lower left")
    public void verifyNumberOfRows(){
        goalPages.verifyNumberOfRows();
    }

    @Then("^Click on \"(.*?)\" Sub Tab inside \"(.*?)\" tab$")
    public void clickOnSubTab(String subTab,String menuTab){
        goalPages.navigateToTab(menuTab,subTab);
    }

    @And("Verify add goal window is closed")
    public void verifyAddGoalWindowIsClosed() {
        goalPages.verifyElementIsNotVisible("Delivery tab");
    }

    @Then("verify number of pages in lower right corner")
    public void verifyNumberOfPages(){
       numberOfPages =  goalPages.verifyNumberOfPages();
    }

    @Then("click on next to check navigation and verify")
    public void verifyNextPrevButtons(){
        goalPages.verifyNextPrevButtons(numberOfPages);
    }

    @And("^Verify all elements are available in dropdown$")
    public void verifyVerifyAllElementsAreAvailableInDropdown() {
        goalPages.verifyFinancialYearDropdown();
    }

    @Then("^Choose current financial year$")
    public void chooseCurrentFinancialYear() {
        goalPages.chooseCurrentFinancialYearAs("Mar 2022");
    }

    @Then("^Verify link is open on the same tab$")
    public void verifyLinkIsOpenOnTheSameTab() {
        goalPages.verifyLinkOpenOnSameTab();
    }

    @And("^verify \"(.*?)\" option clickable and present$")
    public void verifyAllFourOptions(String optionName){
        goalPages.verifyAllFourOptions(optionName);
    }

    @And("click on sorting button on first")
    public void clickOnSortingButton(){
        goalPages.clickOnSortingButton();
    }

    @Then("verify sorting performed")
    public void verifySortingisDone(){
        goalPages.verifySortingisDone();
    }

    @Then("^Select \"(.*?)\" from Goal type dropdown$")
    public void selectCreativeFromGoalTypeDropdown(String optionName) {
        goalPages.selectFormGoalTypeDropdown(optionName);
    }

    @Then("^Verify Warning popup appear which says \"(.*?)\"$")
    public void verifyWarningPopupAppearWhichSays(String message) {
       goalPages.verifyWarningPopupAppearWhichSays(message);
    }

    @Then("^Verify Success pop appears which says \"(.*?)\"$")
    public void verifySuccessPopAppearsWhichSays(String message) {
       goalPages.verifySuccessPopAppearsWhichSays(message);
    }

    @Then("^Verify Add Goals tab opens$")
    public void verifyAddGoalsTabOpens() {
        goalPages.verifyTab();
    }

    @When("^User selects \"(.*?)\" in KPI$")
    public void userSelectsInKPI(String value) {
        goalPages.selectKPI(value);
    }

    @Then("^Fill a field in \"(.*?)\" tag$")
    public void fillAField(String tabName){
        goalPages.fillAField(tabName);
    }

    @Then("^User Clicks on \"(.*?)\" button$")
    public void userClicksAddButton(String button) {
            goalPages.userClicksAddButton(button);
    }

    @Then("^verify \"(.*?)\" and \"(.*?)\" present$")
    public void verifyProjectAndGoalDescription(String projName, String desc){
        goalPages.verifyProjectAndGoalDescription(projName,desc);
    }

    @And("^clicks on submit button \"(.*?)\"$")
    public void clicksOnSubmit(String remarkString){
        goalPages.clickOnSubmit(remarkString);
    }

    @Then("verify error in submission")
    public void errorInSubmission(){
       goalPages.areErrorsInSubmission();
    }

    @Then("^search \"(.*?)\" in search input$")
    public void inputSearch(String searchInput){
        goalPages.searchOnPage(searchInput);
    }

    @And("^verify \"(.*?)\" in the search results$")
    public void verifySearchResult(String projName){
        goalPages.verifySearchResult(projName);
    }

    @And("^enters \"(.*?)\" value in project$")
    public void enterProject(String value) {
        goalPages.enterValue(value);
    }

    @And("^click on \"(.*?)\" button on popup$")
    public void clickOnButtonOnPopup(String btnName){
        goalPages.clickOnButtonOnPopup(btnName);
    }

    @Then("verify submitted successfully")
    public void verifyUpdatedSuccessfully(){
        //yet to complete
    }

    @And("^enters \"(.*?)\" value in goal description$")
    public void enterGoal(String goal) {
        goalPages.enterGoal(goal);
    }

    @Then("^User clicks on \"(.*?)\" nav tab$")
    public void userClicksOnNavTab(String tab) {
        goalPages.clickTab(tab);
    }

    @And("^selects \"(.*?)\" in Primary Skill$")
    public void selectPrimary(String value) {
        goalPages.selectSkill(value);
    }

    @And("verify warning and click ok")
    public void verifyWarningClickOk(){
       goalPages.verifyWarningClickOk();
    }
}
