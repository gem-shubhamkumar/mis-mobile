package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.OtherPortalPage;
import com.gemini.mis.pages.ReimbursementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ReimbursementStepDefinition {
    @Steps
    OtherPortalPage otherPortalImplement;
    @Steps
    ReimbursementPage ReimbursePage;

    //current month selection
    @Then("^Click on \"(.*?)\", \"(.*?)\", \"(.*?)\" and select the drop down value for the current month$")
    public void clickOnNewRequest(String ButtonName,String type,String month){

    otherPortalImplement.clickOnButton(ButtonName);
    ReimbursePage.typeDropdown(type);
    ReimbursePage.monthYearDropdown(month);
}
    //Upload Validation
    @Then("^Upload the file with \"(.*?)\", \"(.*?)\" and validate \"(.*?)\", \"(.*?)\", \"(.*?)\",\"(.*?)\",\"(.*?)\" after filling the details$")
    public void uploadAndValidateNewRequest(String FileName,String FilePath,String description, String billNo, String date, String reimbursementAmount, String amount){
    ReimbursePage.browseAndUpload(FileName,FilePath);
    ReimbursePage.fillDetails(description,billNo,date,reimbursementAmount,amount);
    ReimbursePage.validateSubmitFunctionality(description,reimbursementAmount);
}
    //Validate Ui entries
    @Then("^Change and validate entries on page$")
    public void changeAndValidateEntriesOnPage() {
        otherPortalImplement.selectNoOfEntry();
    }
    // verify current financial year mentioned
    @Then("^Select Drop Down values for current financial year and validate$")
    public void selectDropDownValuesForCurrentFinancialYearAndValidate() {
    ReimbursePage.typeDropdownMainScreen();
    ReimbursePage.monthYearDropdownMainScreen();
    ReimbursePage.validateFinancialYear();
    }
    // verify column names
    @Then("^Verify No. of Columns and print name of columns$")
    public void verifyNoOfColumnsAndPrintNameOfColumns() {
    ReimbursePage.columnNames();
    }
    //validate search filter
    @Then("Validate you are able to search {string} value successfully")
    public void searchFilter(String value) {
        otherPortalImplement.verifySearch(value);
    }
    //validate search filter for no records
    @Then("^Validate you are able to search \"(.*?)\" value and validate no records found successfully$")
    public void searchNoRecordsFound(String value) {
        otherPortalImplement.noRecordFoundWhileSearch(value);
    }
    //verify warning for incorrect file size
    @Then("^Verify warning after file upload of \"(.*?)\", \"(.*?)\", \"(.*?)\" is visible$")
    public void verifyWarningAfterFileUploadOfIsVisible(String FilePath,String type,String month) {
        otherPortalImplement.clickOnButton("New Request");
        ReimbursePage.typeDropdown(type);
        ReimbursePage.monthYearDropdown(month);
        ReimbursePage.verifyWaringPopUp(FilePath);
    }
    //fill the details to verify warning
    @Then("^verify Warning \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" for more than one reimbursement in a month$")
    public void warning(String ButtonName, String FileName,String FilePath,String type,String month){
        otherPortalImplement.clickOnButton(ButtonName);
        ReimbursePage.typeDropdown(type);
        ReimbursePage.monthYearDropdown(month);
        ReimbursePage.browseAndUpload(FileName,FilePath);

    }
    //validate we are unable to create draft for the same month
    @Then("^Verify \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" save draft reimbursement for same month$")
    public void saveDraftWarning(String description, String billNo, String date,String reimbursementAmount, String amount){
        ReimbursePage.fillDetails(description,billNo,date,reimbursementAmount,amount);
        ReimbursePage.verifyReimbursementForSameMonth();
    }
    // validate total amount with Ui
    @Then("^Verify total amount in the UI is correct$")
    public void totalAmount(){
    ReimbursePage.verifyTotalAmount();

    }
    //Action button functionality
    @Then("^Validate action button for \"(.*?)\", \"(.*?)\" visibility$")
    public void verifyActionBtn(String elementNo,String actionButtonNo){
    ReimbursePage.verifyActionButton(elementNo,actionButtonNo);
    }
    //Validate we are able to navigate back to main reimbursement page
    @Then("^Validate that we are able to navigate back to main page of reimbursement$")
    public void validateBackFunctionality(){

    ReimbursePage.verifyBackFunctionality();
    }
    //Cancel button functionality
    @Then("^Validate cancel button for \"(.*?)\", \"(.*?)\" functionality$")
    public void cancelButtonFunctionality(String cancelButtonNo, String noOfElement){
    ReimbursePage.cancelButtonFunctionality(cancelButtonNo,noOfElement);
    }
    //Export pdf validation
    @Then("^PDF export validation$")
    public void validationFOrExport() throws IOException {
    ReimbursePage.validateExport();

    }
    //Save draft functionality
    @Then("^Validate \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and click on save draft$")
    public void clickDraftValidation(String description, String billNo, String date,String reimbursementAmount, String amount, String filePath, String fileName){
    ReimbursePage.browseAndUpload(filePath,fileName);
        ReimbursePage.fillDetails(description,billNo,date,reimbursementAmount,amount);
        ReimbursePage.validateDraftCreation(description,reimbursementAmount);

    }
    //print functionality
    @Then("^Verify we are able to print$")
    public void print(){
    ReimbursePage.verifyPrint();
    }

    //Copy button Functionality
    @And("^Verify data is copied for reimbursement page$")
    public void verifyDataIsCopied() {
        ReimbursePage.verifyCopy();
    }

    //Warning wrong extension file upload
    @Then("^Verify wrong extension warning after file upload of \"(.*?)\", \"(.*?)\", \"(.*?)\" is visible$")
    public void verifyWrongExtensionWarning(String FilePath,String type,String month) {
        otherPortalImplement.clickOnButton("New Request");
        ReimbursePage.typeDropdown(type);
        ReimbursePage.monthYearDropdown(month);
        ReimbursePage.verifyInvalidExtension(FilePath);
    }

}
