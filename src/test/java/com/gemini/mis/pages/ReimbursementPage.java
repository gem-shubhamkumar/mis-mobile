package com.gemini.mis.pages;

import com.gemini.mis.implementations.ReimbursementImplementation;
import net.thucydides.core.annotations.Step;

import java.io.IOException;

public class ReimbursementPage {

   // OtherPortalsImplementation genFun;
    ReimbursementImplementation reimbursementImplement;
    //selecting the value from drop down
    @Step("Click on type drop down and type in the value")
    public void typeDropdown(String type){
        reimbursementImplement.typeDropdown(type);
            }
            //selecting the value from drop down
    @Step("Click on Month Year  drop down and type in the value")
    public void monthYearDropdown(String month){
        reimbursementImplement.monthYearDropdown(month);
    }
    //selecting the file upload
    @Step("Click on browse button and upload the file in png format")
    public void browseAndUpload(String fileName, String filePath){

       reimbursementImplement.browseAndUpload(fileName, filePath);
    }
    //validating after upload the file details filling for submit functionality
    @Step("Validate a new reimbursement is submitted successfully")
    public void validateSubmitFunctionality(String description, String reimbursementAmount){

        reimbursementImplement.validateSubmitFunctionality(description, reimbursementAmount);
    }
    //select mains screen type drop down value
    @Step("Click on type drop down and select the value")
    public void typeDropdownMainScreen(){

       reimbursementImplement.typeDropdownMainScreen();
    }
    //selecting the value from drop down
    @Step("Click on Month Year drop down and select the value")
    public void monthYearDropdownMainScreen(){
       reimbursementImplement.monthYearDropdownMainScreen();
    }
    //verify financial year quarter mentioned in mIS is correct
    @Step("Validate the financial year chosen matches with current quarters")
    public void validateFinancialYear(){
       reimbursementImplement.validateFinancialYear();
    }
    //next page button visibility
    @Step("Check if previous and next page button visible")
    public void buttonVisibility(String buttonName){
       reimbursementImplement.buttonVisibility(buttonName);

    }
    //Get no. of columns and names of columns
    @Step("Find the no. of Columns and print there name")
    public void columnNames(){
      reimbursementImplement.columnNames();
    }

    //Verify incorrect file size warning popup
    @Step("Verify warning comes when you upload incorrect size file")
    public void verifyWaringPopUp(String filePath){
       reimbursementImplement.verifyWaringPopUp(filePath);
    }
    //Invalid extension warning
    @Step("Verify Invalid Extension warning while upload file")
    public void verifyInvalidExtension(String filePath){
        reimbursementImplement.verifyInvalidExtension(filePath);
    }

    //Validate save draft functionality
    @Step("After filling all the details Click on save draft and validate Draft creation")
    public void validateDraftCreation(String description,String reimbursementAmount){

       reimbursementImplement.validateDraftCreation(description, reimbursementAmount);
    }
    //fill all the details before applying reimbursement
    @Step("Fill all the required details ")
    public void fillDetails(String description, String billNo, String date,String reimbursementAmount, String amount){
      reimbursementImplement.fillDetails(description, billNo, date, reimbursementAmount, amount);
    }
    //verify warning for same month reimbursement
    @Step("Verify after save draft you can not apply a reimbursement for more than one month ")
    public void verifyReimbursementForSameMonth(){
        
       reimbursementImplement.verifyReimbursementForSameMonth();
    }
    //calculate the total amount visible
    @Step("Total amount visible should be correct")
    public void verifyTotalAmount(){
       reimbursementImplement.verifyTotalAmount();
    }
    //Verify action windows open
    @Step("Click on action button and verify it takes you to reimbursement form page")
    public void verifyActionButton(String elementNo,String actionButtonNo){

        reimbursementImplement.verifyActionButton(elementNo, actionButtonNo);
    }
    //verify we are able to navigate to main reimbursement page with help of back button
    @Step("Click on back and verify you are able to go back ")
    public void verifyBackFunctionality(){

    reimbursementImplement.verifyBackFunctionality();
    }
    //verify cancel button functionality
    @Step("Click on cancel button and verify the element is showing also cancelled")
    public void cancelButtonFunctionality(String cancelButtonNo, String noOfElement ){
      reimbursementImplement.cancelButtonFunctionality(cancelButtonNo, noOfElement);

    }
    //validate export functionality
    @Step("Validate Export functionality")
    public void validateExport() throws IOException {

      reimbursementImplement.validateExport();

    }
    //verify we are able to print
    @Step("verify we are to move to print tab")
    public void verifyPrint(){
    reimbursementImplement.verifyPrint();

    }

    //validate that clicking on copy button you are bale to see the popup of "copy to clipboard"
    @Step("Verify that you are able to validate copy function")
    public void verifyCopy() {
        reimbursementImplement.verifyCopy();
    }
    }
