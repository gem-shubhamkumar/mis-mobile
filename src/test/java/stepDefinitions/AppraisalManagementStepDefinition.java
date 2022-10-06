package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFucntions;
import com.gemini.mis.pages.AppraisalManagementAddGoalsPages;
import com.gemini.mis.selectors.AppraisalManagementAddGoalsLocators;
import com.gemini.mis.selectors.CommonSelectors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AppraisalManagementStepDefinition extends PageObject {

    @Steps
    AppraisalManagementAddGoalsPages goalPages;

    @Steps
    CommonFucntions commonFunctions;

    AppraisalManagementAddGoalsLocators myGoalSelectors;

    String deleteButtonXpath;
    int numberOfPages;


    @And("^Verify Add goal window opens$")
    public void verifyAddGoalWindow(){
        commonFunctions.isElementVisible(myGoalSelectors.tabDelivery,"delivery tab");
    }

    @And("^Verify \"(.*?)\" text is present on the current page$")
    public void verifyTextOnCurrentPage(String text){
        goalPages.verifyTextPresent(text);
    }



    @Then("Is AddOrUpdateGoals displayed")
    public void isAddOrUpdateGoals(){
        $(By.xpath("//*[@id=\"tabMyGoal\"]/section/div/div/div[1]/div[2]/button")).isClickable();
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
        boolean isRowAdded = $(By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div/input")).isDisplayed();
        System.out.println(isRowAdded);
        Assert.assertTrue("Row added successfully",true);

    }

    @And("verify KPI row removed")
    public void verifyKPIRemoved(){
        boolean isRowAdded = $(By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div/input")).isVisible();
        Assert.assertFalse("Row Removed successfully", false);
    }

    @And("^Enter \"(.*?)\" in \"(.*?)\" text field$")
    public void verifyTextFieldAndEnterText(String textToType,String fieldName){
        goalPages.enterTextInField(textToType,fieldName);
    }

    @Then("^Select \"(.*?)\" from the rows dropdown$")
    public void clickFromRowDropDown(String numOfRows){
        selectFromDropdown($(By.name("tblSelfGoalList_length")),numOfRows);
    }
    @And("^Verify \"(.*?)\" is visible on the current screen$")
    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        switch (eleName){
            case "Add KPI description text field":
                $(AppraisalManagementAddGoalsLocators.textFieldAddKPI).isVisible();
                break;


            default:
                Assert.fail("Element name not added in switch cases");
        }
    }

    @And("^Click on \"(.*?)\"$")
    public void clickBtn(String eleName){
        goalPages.clickOnElement(eleName);
    }

    @Then("verify number of rows from lower left")
    public void verifyNumberOfRows(){
        goalPages.verifyNumberOfRows();
    }

    @Then("^Click \"(.*?)\" sub-tab inside \"(.*?)\" tab$")
    public void clickSubTab(String subTab,String menuTab){
        commonFunctions.navigateToTab(menuTab,subTab);
    }

    @And("Verify add goal window is closed")
    public void verifyAddGoalWindowIsClosed() {
        commonFunctions.verifyElementIsNotVisible("Delivery tab");
    }

    @Then("verify number of pages in lower right corner")
    public void verifyNumberOfPages(){
       numberOfPages =  goalPages.verifyNumberOfPages();
        System.out.println(numberOfPages);
    }

    @Then("click on next to check navigation and verify")
    public void verifyNextPrevButtons(){
        System.out.println(numberOfPages);
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

        switch (optionName){
            case "Print":
                $(By.xpath("//a[@class='dt-button buttons-print']")).isDisplayed();
                $(By.xpath("//a[@class='dt-button buttons-print']")).isClickable() ;
                Assert.assertTrue("Print option clickable and displayed",true);
                break;

            case "Excel":
                $(By.xpath("//a[@class='dt-button buttons-excel buttons-html5']")).isDisplayed();
                $(By.xpath("//a[@class='dt-button buttons-excel buttons-html5']")).isClickable() ;
                Assert.assertTrue("Excel option clickable and displayed",true);
                break;
            case "PDF":
                $(By.xpath("//a[@class='dt-button buttons-pdf buttons-html5']")).isDisplayed();
                $(By.xpath("//a[@class='dt-button buttons-pdf buttons-html5']")).isClickable() ;
                Assert.assertTrue("PDF option clickable and displayed",true);
                break;
            case "Copy":
                $(By.xpath("//a[@class='dt-button buttons-copy buttons-html5']")).isDisplayed();
                $(By.xpath("//a[@class='dt-button buttons-copy buttons-html5']")).isClickable() ;
                Assert.assertTrue("Copy option clickable and displayed",true);
                break;
            default:
                Assert.fail("Options are not present");

        }




    }

    @And("click on sorting button on first")
    public void clickOnSortingButton(){
        $(By.xpath("//*[@id=\"tblSelfGoalList\"]/thead/tr/th[1]")).click();
        Assert.assertTrue("Clicked on sorting icon",true);
    }

    @Then("verify sorting performed")
    public void verifySortingisDone(){
        String firstText = $(By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[1]/td[1]")).getText();
        Assert.assertFalse("Sorting button working fine", firstText.equals("Engineering"));
    }

    @Then("^Select \"(.*?)\" from Goal type dropdown$")
    public void selectCreativeFromGoalTypeDropdown(String optionName) {
        goalPages.selectFormGoalTypeDropdown(optionName);
    }

    @Then("^Verify Warning popup appear which says \"(.*?)\"$")
    public void verifyWarningPopupAppearWhichSays(String message) {
        commonFunctions.isTextFound(CommonSelectors.textMessageBox,message);
        waitABit(1000);
        commonFunctions.clickOn(CommonSelectors.btnOk);
    }

    @Then("^Verify Success pop appears which says \"(.*?)\"$")
    public void verifySuccessPopAppearsWhichSays(String message) {
        commonFunctions.isTextFound(CommonSelectors.textMessageBox,message);
        waitABit(1000);
        commonFunctions.clickOn(CommonSelectors.btnOk);
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

    @Then("^User clicks on \"(.*?)\" button$")
    public void userClicksAddButton(String button) {
        if(button.equals("delete"))
            if($(By.xpath(deleteButtonXpath)).isDisplayed()){
                clickOn($(By.xpath(deleteButtonXpath)));
<<<<<<< HEAD
//            clickOn($());
=======
>>>>>>> 46652873f568d748e4980e143582ff8b9ddb23b9
               Assert.assertTrue("clicked on delete button ", true);
            }
            else{
                clickOn($(By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[5]/td[1]")));
                clickOn($(By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[6]/td/ul/li[4]/span[2]/div/button")));
            }
        else
            goalPages.clickButton(button);
    }

    @Then("^verify \"(.*?)\" and \"(.*?)\" present$")
    public void verifyProjectAndGoalDescription(String projName, String desc){
        deleteButtonXpath  =  goalPages.verifyProjectAndGoalDescription(projName,desc);
<<<<<<< HEAD
//        goalPages.verifyProjectAndGoalDescription(projName, desc);
//        System.out.println(deleteButtonXpath);
=======
        System.out.println(deleteButtonXpath);
>>>>>>> 46652873f568d748e4980e143582ff8b9ddb23b9
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
        switch (btnName){
            case "Yes":
                clickOn($(By.xpath("/html/body/div[13]/div[7]/div/button")));
                break;
        }
    }

    @Then("verify submitted successfully")
    public void verifyUpdatedSuccessfully(){

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
        $(By.xpath("/html/body/div[14]/p")).getText().equals("Kindly select Primary Skill in Engineering tab");
        Assert.assertTrue("Warning displayed!! kindly select primary skill in engineering tab",true);
        $(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
    }



}
