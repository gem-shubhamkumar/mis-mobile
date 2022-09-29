package stepDefinitions;

import com.gemini.mis.pages.GenericFunctionPages_Siddhanshi;
import com.gemini.mis.pages.ReimbursementPages;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

import java.io.IOException;

public class ReimbursementStepDefinition extends PageObject {
   @Steps
    GenericFunctionPages_Siddhanshi genFun;
    ReimbursementPages ReimbursePage;

@Then("^Click on \"(.*?)\", \"(.*?)\", \"(.*?)\" and select the drop down value for the current month$")
public void ClickOnNewRequest(String ButtonName,String type,String month){

    genFun.ClickOnButton(ButtonName);
    ReimbursePage.typeDropdown(type);
    ReimbursePage.monthYearDropdown(month);
}
@Then("^Upload the file with \"(.*?)\", \"(.*?)\" and validate \"(.*?)\", \"(.*?)\", \"(.*?)\",\"(.*?)\",\"(.*?)\" after filling the details$")
public void UploadandvalidateNewRequest(String FileName,String FilePath,String Description, String BillNo, String Date, String RembuirsmenetAmount, String Amount){
   ReimbursePage.browseAndUpload(FileName,FilePath);
   ReimbursePage.fillTheDetails(Description,BillNo,Date,RembuirsmenetAmount,Amount);
}

    @Then("^Change and validate entries on page$")
    public void changeAndValidateEntriesOnPage() {
    genFun.SelectNoOfEntry();
    }

    @Then("^Select Drop Down values for current financial year and validate$")
    public void selectDropDownValuesForCurrentFinancialYearAndValidate() {
    ReimbursePage.typeDropdownMainScreen();
    ReimbursePage.monthYearDropdownMainScreen();
    ReimbursePage.validateFinancialYear();
    }

    @Then("^Verify No. of Columns and print name of columns$")
    public void verifyNoOfColumnsAndPrintNameOfColumns() {
    ReimbursePage.ColumnNames();
    }
    @Then("Validate you are able to search {string} value successfully")
    public void SearchFilter(String value) {
        genFun.VerifySearch(value);
    }

    @Then("^Validate you are able to search \"(.*?)\" value and validate no records found successfully$")
    public void SearchNoRecordsFound(String value) {
        genFun.NoRecordFoundWhileSearch(value);
    }

    @Then("^Verify warning after file upload of \"(.*?)\", \"(.*?)\", \"(.*?)\" is visible$")
    public void verifyWarningAfterFileUploadOfIsVisible(String FilePath,String type,String month) {
    genFun.ClickOnButton("New Request");
        ReimbursePage.typeDropdown(type);
        ReimbursePage.monthYearDropdown(month);
        ReimbursePage.VerifyWaringPopUp(FilePath);
    }
    @Then("^verify Warning \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" for more than one reimbursement in a month$")
    public void Warning(String ButtonName, String FileName,String FilePath,String type,String month){
        genFun.ClickOnButton(ButtonName);
        ReimbursePage.typeDropdown(type);
        ReimbursePage.monthYearDropdown(month);
        ReimbursePage.browseAndUpload(FileName,FilePath);

    }
    @Then("^Verify \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" save draft reimbursement for same month$")
    public void saveDraftWarning(String description, String billNo, String date,String rembuirsmenetAmount, String amount){
        ReimbursePage.VerifyWarning(description,billNo,date,rembuirsmenetAmount,amount);
    }
    @Then("^Verify total amount in the UI is correct$")
    public void totalAmount(){
    ReimbursePage.VerifyTotalAmount();

    }
    @Then("^Validate action button visibility$")
    public void verifyActionBtn(){
    ReimbursePage.VerifyActionButton();
    }
    @Then("^Validate that we are able to navigate back to main page of reimbursement$")
    public void ValidateBackFunctionality(){
        ReimbursePage.VerifyActionButton();
    ReimbursePage.verifyBackFunctionality();
    }
    @Then("^Validate cancel button functionality$")
    public void CancelButtonFunctionality(){
    ReimbursePage.CancelButtonFunctionality();
    }
    @Then("^PDF \"(.*?)\" export validation$")
    public void ValidationFOrExport(String FilePath) throws IOException {
    ReimbursePage.ValidateExport(FilePath);

    }
    @Then("^Validate \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and click on save draft$")
    public void ClickDraftValidation(String description, String billNo, String date,String rembuirsmenetAmount, String amount, String filePath, String fileName){
    ReimbursePage.browseAndUpload(filePath,fileName);
    ReimbursePage.fillTheDetailsSaveDraft(description,billNo,date,rembuirsmenetAmount,amount);
    }
    @Then("Verify we are able to print")
    public void print(){
    ReimbursePage.VerifyPrint();
    }


}
