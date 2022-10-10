package com.gemini.mis.pages;

import com.gemini.mis.selectors.GenericFunctionPOM;
import com.gemini.mis.selectors.ReimbursementPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ReimbursementPages extends PageObject {

    GenericFunctionPages_Siddhanshi genFun;
    //selecting the value from drop down
    @Step("Click on type drop down and type in the value")
    public void typeDropdown(String type){
        $(By.xpath(ReimbursementPOM.dropdown.replace("VAR","2"))).click();
       $(By.xpath(ReimbursementPOM.drpDownElement.replace("VAR",type))).click();
        Assert.assertTrue(true);
            }
            //selecting the value from drop down
    @Step("Click on Month Year  drop down and type in the value")
    public void monthYearDropdown(String month){
        $(By.xpath(ReimbursementPOM.dropdown.replace("VAR","4"))).click();
        $(By.xpath(ReimbursementPOM.drpDownElement.replace("VAR",month))).click();
        Assert.assertTrue(true);
    }
    //selecting the file upload
    @Step("Click on browse button and upload the file in png format")
    public void browseAndUpload(String fileName, String filePath){

        WebElementFacade inputLogo= $(ReimbursementPOM.fileUpload);
      //  inputLogo.click();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", inputLogo);
        inputLogo.sendKeys(filePath);
       // inputLogo.sendKeys(Keys.ENTER);
        String fileNameAfterPublish=$(ReimbursementPOM.fileUploadText).getText();
        if (fileNameAfterPublish.contains(fileName)){
            Assert.assertTrue(true);
        }else{
            Assert.fail("The file did not get uploaded");
        }
    }
    //validating after upload the file details filling for submit functionality
    @Step("After you upload the file fill in the details and click on submit")
    public void fillTheDetails(String description, String billNo, String date,String rembuirsmenetAmount, String amount){
        // After selecting the image we have some details to fill
        $(ReimbursementPOM.selectDropDown).click();
        //values like description, bill no. ,date , amount needed to be filled
        $(ReimbursementPOM.drpDownValue).click();
        //type description
        WebElementFacade typeDes=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Description")));
        clickOn(typeDes);
        typeInto(typeDes,description);
         // type bill no.
        WebElementFacade typeBill=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Bill No.")));
        clickOn(typeBill);
        typeInto(typeBill,billNo);
        // type date
//
        WebElementFacade typeDate=  find(ReimbursementPOM.DateInput);
        typeDate.sendKeys(date);
        //type amount
        WebElementFacade typeAmount=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Amount")));
        clickOn(typeAmount);
        typeInto(typeAmount,amount);
         //reimbursement amount
        WebElementFacade reimbursment=$(ReimbursementPOM.rembuirsmentAmount);
        clickOn(reimbursment);
        typeInto(reimbursment,rembuirsmenetAmount);
        //click on submit button
        genFun.ClickOnButton("Submit");
        Boolean verifySubmit=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Reimbursement request has been submitted successfully"))).isVisible();
        String verifyDescription = $(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE", "Description"))).getText();
        String VerifyReimbursementAmount = $(ReimbursementPOM.rembuirsmentAmount).getText();

       if(verifyDescription.contains(description) && VerifyReimbursementAmount.contains(rembuirsmenetAmount) && verifySubmit){

           Assert.assertTrue("We are able to add the new request successfully",true);
        }else{
            Assert.fail("We are unable to fill the details and submit the file");
        }
    }
    //select mains screen type drop down value
    @Step("Click on type drop down and select the value")
    public void typeDropdownMainScreen(){
        waitABit(9000);
        $(By.xpath(ReimbursementPOM.dropdown.replace("VAR","1"))).click();
        $(ReimbursementPOM.typeDropDownMainScreen).click();
        Assert.assertTrue(true);
    }
    //selecting the value from drop down
    @Step("Click on Month Year drop down and select the value")
    public void monthYearDropdownMainScreen(){
        waitABit(6000);
        $(By.xpath(ReimbursementPOM.dropdown.replace("VAR","2"))).click();
        $(ReimbursementPOM.yearDropDownMainScreen).click();
        Assert.assertTrue(true);
    }
    @Step("Validate the financial year chosen matches with current quarters")
    public void validateFinancialYear(){
        String Selectedyear=$(ReimbursementPOM.yearDropDownMainScreen).getText();
        String nextYear=$(ReimbursementPOM.NextYear).getText();
        String currentYear=$(ReimbursementPOM.currentYear).getText();
        if(Selectedyear.contains(nextYear) && Selectedyear.contains(currentYear)){
            Assert.assertTrue("The selected financial year is correct",true);
        }else{
            Assert.fail("The financial year selected is not correct");
        }
    }
    @Step("Check if previous and next page button visible")
    public void ButtonVisibility(String buttonName){
        Boolean isButtonVisible=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR",buttonName))).isVisible();
        if (isButtonVisible){
            Assert.assertTrue("The "+buttonName+" button is visible ",true);
        }else{
            Assert.fail("The "+buttonName+" button is not visible ");
        }

    }
    @Step("Find the no. of Columns and print there name")
    public void ColumnNames(){
       // ArrayList<String> ColumnsNameArr=new ArrayList<String>();
        List<WebElement> columns=getDriver().findElements(ReimbursementPOM.listOfColumns);
        int ColumnCount=columns.size()-2;
        for(WebElement we: columns){
            String ColumnsNames=we.getText();
//ColumnsNameArr.add(ColumnsNames);
            System.out.println(ColumnsNames);
        }

if(ColumnCount==7){
Assert.assertTrue("The no. of columns fetched are correct",true);
    }else {
}Assert.fail("The no. of elements fetched are not correct");
    }

    @Step("Verify warning comes when you upload incorrect size file")
    public void VerifyWaringPopUp(String filePath){
        WebElementFacade inputLogo= $(ReimbursementPOM.fileUpload);
        // inputLogo.click();
        inputLogo.sendKeys(filePath);
        // inputLogo.sendKeys(Keys.ENTER);
        Boolean verifySubmit=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Kindly add image with less than 1 MB size"))).isVisible();

        if (verifySubmit){
            Assert.assertTrue("Yes we are able to see the warning popup",true);
        }else{
            Assert.fail("We are unable to warning message");
        }
    }

    @Step("After you upload the file fill in the details and click on save draft ")
    public void fillTheDetailsSaveDraft(String description, String billNo, String date,String rembuirsmenetAmount, String amount){
        // After selecting the image we have some details to fill
        $(ReimbursementPOM.selectDropDown).click();
        //values like description, bill no. ,date , amount needed to be filled
        $(ReimbursementPOM.drpDownValue).click();
        //type description
        WebElementFacade typeDes=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Description")));
        clickOn(typeDes);
        typeInto(typeDes,description);
        // type bill no.
        WebElementFacade typeBill=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Bill No.")));
        clickOn(typeBill);
        typeInto(typeBill,billNo);
        // type date
//        WebElementFacade typeDate=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Date")));
//        clickOn(typeDate);
      //  $(By.xpath("//td[contains(@class,'today ')]")).click();
      WebElementFacade typeDate=  find(ReimbursementPOM.DateInput);
      typeDate.sendKeys(date);
        //type amount
        WebElementFacade typeAmount=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Amount")));
        clickOn(typeAmount);
        typeInto(typeAmount,amount);
        //reimbursement amount
        WebElementFacade reimbursment=$(ReimbursementPOM.rembuirsmentAmount);
        clickOn(reimbursment);
        typeInto(reimbursment,rembuirsmenetAmount);
        //click on submit button
        genFun.ClickOnButton("Save as draft");
        Boolean verifySubmit=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Reimbursement request has been drafted successfully."))).isVisible();
        String verifyDescription = $(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE", "Description"))).getText();
        String VerifyReimbursementAmount = $(ReimbursementPOM.rembuirsmentAmount).getText();

        if(verifyDescription.contains(description) && VerifyReimbursementAmount.contains(rembuirsmenetAmount) && verifySubmit){

            Assert.assertTrue("We are able to save a draft successfully",true);
        }else{
            Assert.fail("We are not able to save a draft successfully");
        }
    }
    @Step("After Clicking on save draft verify that a popup for more than one reimbursement in a month is prohibited ")
    public void VerifyWarning(String description, String billNo, String date,String rembuirsmenetAmount, String amount){
        // After selecting the image we have some details to fill
        $(ReimbursementPOM.selectDropDown).click();
        //values like description, bill no. ,date , amount needed to be filled
        $(ReimbursementPOM.drpDownValue).click();
        //type description
        WebElementFacade typeDes=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Description")));
        clickOn(typeDes);
        typeInto(typeDes,description);
        // type bill no.
        WebElementFacade typeBill=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Bill No.")));
        clickOn(typeBill);
        typeInto(typeBill,billNo);
        // type date
//        WebElementFacade typeDate=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Date")));
//        clickOn(typeDate);
//        $(By.xpath("//td[contains(@class,'today ')]")).click();
        WebElementFacade typeDate=$(ReimbursementPOM.DateInput);
        clickOn(typeDate);
        typeDate.sendKeys(date);
        //type amount
        WebElementFacade typeAmount=$(By.xpath(ReimbursementPOM.typeInValue.replace("TYPE","Amount")));
        clickOn(typeAmount);
        typeInto(typeAmount,amount);
        //reimbursement amount
        WebElementFacade reimbursment=$(ReimbursementPOM.rembuirsmentAmount);
        clickOn(reimbursment);
        typeInto(reimbursment,rembuirsmenetAmount);
        //click on submit button
        genFun.ClickOnButton("Save as draft");
        Boolean verifySubmit=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","You can not raise more than one request in a month for reimbursement type monthly."))).isVisible();


        if(verifySubmit){

            Assert.assertTrue("We are able to catch the warning ",true);
        }else{
            Assert.fail("The warning was not visible");
        }
    }

@Step("Total amount visible should be correct")
    public void VerifyTotalAmount(){
        String Totalamount1= $(By.xpath(ReimbursementPOM.totalAmountValuetext.replace("VAR","1"))).getText();
        String  Totalamount2= $(By.xpath(ReimbursementPOM.totalAmountValuetext.replace("VAR","7"))).getText();
        double T1= Double.parseDouble(Totalamount1);
        double T2= Double.parseDouble(Totalamount2);
        double totalAmount=T1+T2;
        String FetchedTotalAmount=$(ReimbursementPOM.totalAmountValue).getText();
double s=Double.parseDouble(FetchedTotalAmount);
        if (totalAmount==s){
            Assert.assertTrue("The total amount visible is correct ",true);
        }else{
            Assert.fail("The total amount visible is not correct");
        }

}
@Step("Click on action button and verify it takes you to reimbursement form page")
    public void VerifyActionButton(){

        $(ReimbursementPOM.requestTypeElment).click();
        $(By.xpath(ReimbursementPOM.actionButton.replace("VAR","5"))).click();
        waitABit(3000);
       Boolean verifyWindow= $(ReimbursementPOM.actionWindow).isVisible();
       String VerifyText=$(ReimbursementPOM.actionWindow).getText();
       if (verifyWindow && VerifyText.contains("Reimbursement Form")){
           Assert.assertTrue("We are able to move to the action window",true);
       }
       else{
           Assert.fail("We are unable to move to action window");
       }
}

@Step("Click on back and verify you are able to go back ")
    public void verifyBackFunctionality(){

genFun.ClickOnButton("Back");

Boolean VerifyBackFunctionality=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Reimbursement Request"))).isVisible();
if(VerifyBackFunctionality){
    Assert.assertTrue("We are able go back",true);
}else{
    Assert.fail("We are unable to go back");
}
}

@Step("Click on cancel button and verify the element is showing also cancelled")
    public void CancelButtonFunctionality(){
        waitABit(2000);
    $(ReimbursementPOM.requestTypeElment).click();
    waitABit(3000);
    $(ReimbursementPOM.cancelButton).click();
    waitABit(2000);
    $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Yes"))).click();
    String CanceledElement=$(By.xpath(ReimbursementPOM.canceledElements.replace("VAR",""))).getText();
    if(CanceledElement.contains("Cancelled")){
        Assert.assertTrue("The reimbursement has been cancelled successfully",true);
    }else{
        Assert.fail("we were unable to cancel the reimbursement ");
    }

}
@Step("Validate Export functionality")
    public void ValidateExport(String FilePath) throws IOException {

        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Export"))).click();
        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","PDF"))).click();
//genFun.getLAstModifiedFile(FilePath);
waitABit(9000);
    PDDocument document = PDDocument.load(genFun.getLAstModifiedFile(FilePath));
    //Instantiate PDFTextStripper class
    PDFTextStripper pdfStripper = new PDFTextStripper();
    //Retrieving text from PDF document
    String text = pdfStripper.getText(document);
    System.out.println(text);
    //Closing the document
    if (text.contains("Cancelled")){
        Assert.assertTrue("The pdf which is downloaded is correct",true);
    }else{
        Assert.fail("The pdf which is downloaded is not correct");
    }
    document.close();

}

@Step("verify we are to move to print tab")
public void VerifyPrint(){
    String mainWindow=getDriver().getWindowHandle();
String mainWindowTittle=getDriver().getCurrentUrl();
    $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Export"))).click();
    $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Print"))).click();
    waitABit(3000);

    //List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());

    Set<String> windows =getDriver().getWindowHandles();
    Iterator<String> l1=windows.iterator();
    while(l1.hasNext())
    {
        String childWindow=l1.next();
        if(!mainWindow.equalsIgnoreCase(childWindow)){
            //switching to child window
            getDriver().switchTo().window(childWindow);
waitABit(3000);
String childWindowTittle=getDriver().getCurrentUrl();
            if (!childWindowTittle.equalsIgnoreCase(mainWindowTittle)){
                Assert.assertTrue("we are able to print",true);
break;
            }else {
                Assert.fail("we are not able to print");
            }
}
}}

    public void verifyCopy() {
        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Export"))).click();
        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Copy"))).click();
        getDriver().switchTo().defaultContent();
        Assert.assertEquals($(By.xpath(ReimbursementPOM.copyClipboard)).getText(), "Copy to clipboard");
    }
}
