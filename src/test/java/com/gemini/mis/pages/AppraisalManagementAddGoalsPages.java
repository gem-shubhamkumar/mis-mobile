package com.gemini.mis.pages;

import com.gemini.mis.implementations.AppraisalManagementPageImplementation;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class AppraisalManagementAddGoalsPages extends PageObject {

    AppraisalManagementPageImplementation appraisalManagementPageImplementation;

    String deleteButtonXpath;

    @Step("verify four elements are available in financial year dropdown")
    public void verifyFinancialYearDropdown(){
        appraisalManagementPageImplementation.verifyFinancialYearDropdown();
    }


    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        appraisalManagementPageImplementation.verifyTextPresent(text);
    }



    @Step("Fill data in the fields")
    public void fillDataInFields(String fieldName){
       appraisalManagementPageImplementation.fillDataInFields(fieldName);
    }


    @Step("Fill data in a field according to tab name")
    public void fillAField(String tabName){
       appraisalManagementPageImplementation.fillAField(tabName);
    }

    @Step("Enter {0} in {1} text field")
    public void enterTextInField(String textToEnter, String fieldName){
       appraisalManagementPageImplementation.enterTextInField(textToEnter,fieldName);
    }


    @Step("Click on {0}")
    public void clickOnElement(String eleName){
        waitABit(1500);
        appraisalManagementPageImplementation.clickOnElements(eleName);
        waitABit(1000);
    }

    @Step("Choose current financial yeas as {0} from dropdown")
    public void chooseCurrentFinancialYearAs(String year){
        appraisalManagementPageImplementation.chooseCurrentFinancialYearAs(year);
            }

    @Step("Step to verify tab")
    public void verifyTab() {
        appraisalManagementPageImplementation.verifyTab();
    }

    @Step("Select a KPI")
    public void selectKPI(String value) {
        appraisalManagementPageImplementation.selectKPI(value);
    }

    @Step("Enter kra value")
    public void enterValue(String value) {
        appraisalManagementPageImplementation.enterValue(value);
    }

    @Step("Enter goal value")
    public void enterGoal(String goal) {
        appraisalManagementPageImplementation.enterGoal(goal);
    }

    @Step("Click on tab")
    public void clickTab(String tab) {appraisalManagementPageImplementation.clickTab(tab);}



    @Step("Step to verify the message")
    public void verifyMessage(String message){
        appraisalManagementPageImplementation.verifyMessage(message);
    }

    @Step("Select skill")
    public void selectSkill(String value) {
        appraisalManagementPageImplementation.selectSkill(value);
    }

    @Step("click on button")
    public void clickButton(String button) {
        appraisalManagementPageImplementation.clickButton(button);
    }

    @Step("click on submit after deleting goal")
    public void clickOnSubmit(String remarkString){
       appraisalManagementPageImplementation.clickOnSubmit(remarkString);
    }

    @Step("Search on the add goal page")
    public void searchOnPage(String searchInput){
        appraisalManagementPageImplementation.searchOnPage(searchInput);
    }

    @Step("Error!! when empty remark")
    public void areErrorsInSubmission(){
        appraisalManagementPageImplementation.areErrorsInSubmission();
    }

    @Step("Verify Search result")
    public void verifySearchResult(String projName){
      appraisalManagementPageImplementation.verifySearchResult(projName);
    }

    public void userClicksAddButton(String button){
        appraisalManagementPageImplementation.userClicksAddButton(button);
    }

    public void verifyElementIsNotVisible(String elemName){
        appraisalManagementPageImplementation.verifyElementIsNotVisible(elemName);
    }

    public void navigateToTab(String menuTab,String subTab){
        appraisalManagementPageImplementation.navigateToTab(menuTab,subTab);
    }



    @Step("Step to watch out the project name and description")
    public void verifyProjectAndGoalDescription(String projName,String desc){
        deleteButtonXpath =  appraisalManagementPageImplementation.verifyProjectAndGoalDescription(projName,desc);
    }

    @Step("Verify current page title is not as gemini page title")
    public void verifyLinkOpenOnSameTab(){
        appraisalManagementPageImplementation.verifyLinkOpenOnSameTab();
    }

    @Step("Select {0} from dropdown ou of four options available")
    public void selectFormGoalTypeDropdown(String optionName){
       appraisalManagementPageImplementation.selectFormGoalTypeDropdown(optionName);
    }


    @Step("Click add or delete kpi row")
    public void addOrRemoveKPIRow(String optionName){
       appraisalManagementPageImplementation.addOrRemoveKPIRow(optionName);
    }

    @Step("Verify number of rows from lower left")
    public void verifyNumberOfRows(){
       appraisalManagementPageImplementation.verifyNumberOfRows();
    }

    @Step("Verify number of pages")
    public int verifyNumberOfPages(){
        return appraisalManagementPageImplementation.verifyNumberOfPages();
    }

    @Step("Verify functionality of next and prev buttons")
    public void verifyNextPrevButtons(int numOfPages){
        appraisalManagementPageImplementation.verifyNextPrevButtons(numOfPages);
    }


    @Step
    public void verifyWarningPopupAppearWhichSays(String message){
        appraisalManagementPageImplementation.verifyWarningPopupAppearWhichSays(message);
    }

    @Step
    public void verifySuccessPopAppearsWhichSays(String message){
        appraisalManagementPageImplementation.verifySuccessPopAppearsWhichSays(message);
    }

    @Step("Verify warning and click ok")
    public void verifyWarningClickOk(){
        appraisalManagementPageImplementation.verifyWarningClickOk();
    }

    @Step("Click on button on popup")
    public void clickOnButtonOnPopup(String btnName){
        appraisalManagementPageImplementation.clickOnButtonOnPopup(btnName);
    }

    @Step("Verify all 4 export options present")
    public void verifyAllFourOptions(String optionName){
        appraisalManagementPageImplementation.verifyAllFourOptions(optionName);
    }

    @Step
    public void isElementVisible(By loc,String elementName){
        appraisalManagementPageImplementation.isElementVisible(loc,elementName);
    }

    @Step("check if add or update goals displayed")
    public void isAddOrUpdateGoals(){
        appraisalManagementPageImplementation.isAddOrUpdateGoals();
    }

    @Step("Verify is row added")
    public void verifyKPIAdded(){
        appraisalManagementPageImplementation.verifyKPIAdded();
    }

    @Step("Verify KPI row removed")
    public void verifyKPIRemoved(){
        appraisalManagementPageImplementation.verifyKPIRemoved();
    }

    @Step("click on number of rows from dropdown")
    public void clickFromRowDropDown(String numOfRows){
        appraisalManagementPageImplementation.clickFromRowDropDown(numOfRows);
    }

    @Step("verify {0} visible on the current screen")
    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        appraisalManagementPageImplementation.verifyIsVisibleOnTheCurrentScreen(eleName);
    }

    @Step("Click on the sorting button")
    public void clickOnSortingButton(){
        appraisalManagementPageImplementation.clickOnSortingButton();
    }

    @Step("Verify sorting is done")
    public void verifySortingisDone() {
        appraisalManagementPageImplementation.verifySortingisDone();
    }


}







