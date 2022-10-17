package com.gemini.mis.implementations;

import com.gemini.mis.selectors.MISPOM;
import com.gemini.mis.selectors.ReimbursementPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class ReimbursementImplementation extends PageObject{

    static final Logger logger = LoggerFactory.getLogger("SampleLogger");

        OtherPortalsImplementation genFun;

        //selecting the value from drop down
        public void typeDropdown(String type){
            $(ReimbursementPOM.dropdown("2")).click();
            WebElementFacade dropDown=find(ReimbursementPOM.drpDownElement(type));
            if(dropDown.isVisible()){
                clickOn(dropDown);
            }else {
            Assert.fail("User is unable to select the option from drop down");
            logger.info("User is unable to select the option from drop down");
            }


        }
        //selecting the value from drop down
        public void monthYearDropdown(String month){
            $(ReimbursementPOM.dropdown("4")).click();
            WebElementFacade dropDown=find(ReimbursementPOM.drpDownElement(month));
            if(dropDown.isVisible()){
                clickOn(dropDown);
            }else {
                Assert.fail("User is unable to select the option from drop down");
                logger.info("User is unable to select the option from drop down");
            }

        }
        //selecting the file upload

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
               logger.info("The file did not get uploaded");
            }
        }
        //validating after upload the file details filling for submit functionality

        public void validateSubmitFunctionality(String description, String reimbursementAmount){
            //click on submit button
            genFun.clickOnButton("Submit");
            boolean verifySubmit=$(MISPOM.genericPath("Reimbursement request has been submitted successfully")).isVisible();
            String verifyDescription = $(ReimbursementPOM.typeInValue( "Description")).getText();
            String VerifyReimbursementAmount = $(ReimbursementPOM.reimbursementAmount).getText();

            if(verifyDescription.contains(description) && VerifyReimbursementAmount.contains(reimbursementAmount) && verifySubmit){

                Assert.assertTrue("User is able to add the new request successfully",true);
            }else{
                Assert.fail("User is unable to fill the details and submit the file");
               logger.info("User is unable to fill the details and submit the file");
            }
        }
        //select mains screen type drop down value

        public void typeDropdownMainScreen(){
            waitABit(9000);
            $(ReimbursementPOM.dropdown("1")).click();
            WebElementFacade dropDown= find(ReimbursementPOM.typeDropDownMainScreen);
            if(dropDown.isVisible()){
                clickOn(dropDown);
            }else {
                Assert.fail("User is unable to select the option from drop down");
                logger.info("User is unable to select the option from drop down");
            }

        }
        //selecting the value from drop down

        public void monthYearDropdownMainScreen(){
            waitABit(6000);
            $(ReimbursementPOM.dropdown("2")).click();
            WebElementFacade dropDown= find(ReimbursementPOM.typeDropDownMainScreen);
            if(dropDown.isVisible()){
                clickOn(dropDown);
            }else {
                Assert.fail("User is unable to select the option from drop down");
                logger.info("User is unable to select the option from drop down");
            }
        }
        //verify financial year quarter mentioned in mIS is correct

        public void validateFinancialYear(){
            String selectedYear=$(ReimbursementPOM.yearDropDownMainScreen).getText();
            String nextYear=$(ReimbursementPOM.NextYear).getText();
            String currentYear=$(ReimbursementPOM.currentYear).getText();
            if(selectedYear.contains(nextYear) && selectedYear.contains(currentYear)){
                Assert.assertTrue("The selected financial year is correct",true);
            }else{
                Assert.fail("The financial year selected is not correct");
                logger.info("The financial year selected is not correct");
            }
        }

        //next page button visibility
        public void buttonVisibility(String buttonName){

            boolean isButtonVisible=$(MISPOM.genericPath(buttonName)).isVisible();
            if (isButtonVisible){
                Assert.assertTrue("The "+buttonName+" button is visible ",true);
            }else{
                Assert.fail("The "+buttonName+" button is not visible ");
                logger.info("The "+buttonName+" button is not visible ");
            }

        }
        //Get no. of columns and names of columns

        public void columnNames(){
            // ArrayList<String> ColumnsNameArr=new ArrayList<String>();
            List<WebElement> columns=getDriver().findElements(ReimbursementPOM.listOfColumns);
            int ColumnCount=columns.size()-2;
            for(WebElement we: columns){
                String ColumnsNames=we.getText();
                //ColumnsNameArr.add(ColumnsNames);
               logger.info(ColumnsNames);
            }
            if(ColumnCount==7){
                Assert.assertTrue("The no. of columns fetched are correct",true);
            }else {
                Assert.fail("The no. of elements fetched are not correct");
                logger.info("The no. of elements fetched are not correct");
            }
        }

        //Verify incorrect file size warning popup

        public void verifyWaringPopUp(String filePath){
            WebElementFacade inputLogo= $(ReimbursementPOM.fileUpload);
            // inputLogo.click();
            inputLogo.sendKeys(filePath);
            // inputLogo.sendKeys(Keys.ENTER);
            boolean verifySubmit=$(MISPOM.genericPath("Kindly add image with less than 1 MB size")).isVisible();

            if (verifySubmit){
                Assert.assertTrue("User is able to see the warning popup",true);
            }else{
                Assert.fail("User is unable to warning message");
               logger.info("User is unable to warning message");
            }
        }
        //Invalid extension warning

        public void verifyInvalidExtension(String filePath){
            //upload file
            WebElementFacade inputLogo= $(ReimbursementPOM.fileUpload);

            inputLogo.sendKeys(filePath);
            boolean isExtensionWarningVisible=$(MISPOM.genericPath("Invalid image extension. Please select only- .jpg/.png ")).isVisible();
            if (isExtensionWarningVisible){
                Assert.assertTrue("Yes we are able to see the warning popup",true);
            }else{
                Assert.fail("User is unable to warning message");
                logger.info("User is unable to warning message");
            }
        }

        //Validate save draft functionality

        public void validateDraftCreation(String description,String reimbursementAmount){
            //click on save draft button
            genFun.clickOnButton("Save as draft");
            //Verify if the details are visible
            boolean verifySubmit=$(MISPOM.genericPath("Reimbursement request has been drafted successfully.")).isVisible();
            String verifyDescription = $(ReimbursementPOM.typeInValue( "Description")).getText();
            String VerifyReimbursementAmount = $(ReimbursementPOM.reimbursementAmount).getText();

            if(verifyDescription.contains(description) && VerifyReimbursementAmount.contains(reimbursementAmount) && verifySubmit){

                Assert.assertTrue("User is able to save a draft successfully",true);
            }else{
                Assert.fail("User is not able to save a draft successfully");
                logger.info("User is not able to save a draft successfully");
            }
        }
        //fill all the details before applying reimbursement

        public void fillDetails(String description, String billNo, String date,String reimbursementAmount, String amount){
            // After selecting the image we have some details to fill
            $(ReimbursementPOM.selectDropDown).click();
            //values like description, bill no. ,date , amount needed to be filled
            $(ReimbursementPOM.drpDownValue).click();
            //type description
            WebElementFacade typeDes=$(ReimbursementPOM.typeInValue("Description"));
            clickOn(typeDes);
            typeInto(typeDes,description);
            // type bill no.
            WebElementFacade typeBill=$(ReimbursementPOM.typeInValue("Bill No."));
            clickOn(typeBill);
            typeInto(typeBill,billNo);
            // type date
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("document.getElementById('txtDate1').value='"+date+"'");
            //type amount
            WebElementFacade typeAmount=$(ReimbursementPOM.typeInValue("Amount"));
            clickOn(typeAmount);
            typeInto(typeAmount,amount);
            //reimbursement amount
            WebElementFacade reimbursement=$(ReimbursementPOM.reimbursementAmount);
            clickOn(reimbursement);
            typeInto(reimbursement,reimbursementAmount);
        }

        //verify warning for same month reimbursement
        public void verifyReimbursementForSameMonth(){
            //click on submit button
            genFun.clickOnButton("Save as draft");
            boolean verifySubmit=$(MISPOM.genericPath("You can not raise more than one request in a month for reimbursement type monthly.")).isVisible();

            if(verifySubmit){
                Assert.assertTrue("User is able to catch the warning ",true);
            }else{
                Assert.fail("The warning was not visible");
                logger.info("The warning was not visible");
            }
        }
        //calculate the total amount visible

        public void verifyTotalAmount(){
            double totalAmountAdditionElements=0.00;
            List<WebElement> totalAmount=getDriver().findElements(ReimbursementPOM.totalAmountValueText);
            for(WebElement amount:totalAmount){
                String temp=amount.getText();
                double totalDouble=Double.parseDouble(temp);
                totalAmountAdditionElements=totalAmountAdditionElements+totalDouble;
            }
            String FetchedTotalAmount=$(ReimbursementPOM.totalAmountValue("2")).getText();
            String FetchedTotalPageAmount=$(ReimbursementPOM.totalAmountValue("4")).getText();
            String FetchedTotalApprovedAmount=$(ReimbursementPOM.totalAmountValue("6")).getText();
            double s1=Double.parseDouble(FetchedTotalAmount);
            double s2=Double.parseDouble(FetchedTotalPageAmount);
            double s3=Double.parseDouble(FetchedTotalApprovedAmount);
            double totalAmountAdditionUi=s1+s2+s3;
            if (totalAmountAdditionElements==totalAmountAdditionUi){
                Assert.assertTrue("The total amount visible is correct ",true);
            }else{
                Assert.fail("The total amount visible is not correct");
                logger.info("The total amount visible is not correct");
            }

        }
        //Verify action windows open

        public void verifyActionButton(String elementNo,String actionButtonNo){

            $(ReimbursementPOM.requestTypeElement(elementNo)).click();
            $(ReimbursementPOM.actionButton(actionButtonNo)).click();
            waitABit(3000);
            boolean verifyWindow= $(ReimbursementPOM.actionWindow).isVisible();
            String VerifyText=$(ReimbursementPOM.actionWindow).getText();
            if (verifyWindow && VerifyText.contains("Reimbursement Form")){
                Assert.assertTrue("User is able to move to the action window",true);
            }
            else{
                Assert.fail("User is unable to move to action window");
                logger.info("User is unable to move to action window");
            }
        }
        //verify we are able to navigate to main reimbursement page with help of back button

        public void verifyBackFunctionality(){

            genFun.clickOnButton("Back");

            boolean VerifyBackFunctionality=$(MISPOM.genericPath("Reimbursement Request")).isVisible();
            if(VerifyBackFunctionality){
                Assert.assertTrue("User is able go back",true);
            }else{
                Assert.fail("User is unable to go back");
                logger.info("User is unable to go back");
            }
        }
        //verify cancel button functionality

        public void cancelButtonFunctionality(String cancelButtonNo, String noOfElement ){
            waitABit(2000);
            $(ReimbursementPOM.requestTypeElement(noOfElement)).click();
            waitABit(3000);
            $(ReimbursementPOM.cancelButton(cancelButtonNo)).click();
            waitABit(2000);
            $(MISPOM.genericPath("Yes")).click();
            String CanceledElement=$(ReimbursementPOM.canceledElements(noOfElement)).getText();
            if(CanceledElement.contains("Cancelled")){
                Assert.assertTrue("The reimbursement has been cancelled successfully",true);
            }else{
                Assert.fail("User is unable to cancel the reimbursement ");
                logger.info("User is unable to cancel the reimbursement ");
            }

        }
        //validate export functionality

        public void validateExport() throws IOException {

            $(MISPOM.genericPath("Export")).click();
            $(MISPOM.genericPath("PDF")).click();
            //genFun.getLAstModifiedFile(FilePath);
            waitABit(9000);
            PDDocument document = PDDocument.load(genFun.getLAstModifiedFile());
            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);
           logger.info(text);
            //Closing the document
            if (text.contains("Cancelled")){
                Assert.assertTrue("The pdf which is downloaded is correct",true);
            }else{
                Assert.fail("The pdf which is downloaded is not correct");
                logger.info("The pdf which is downloaded is not correct");
            }
            document.close();

        }
        //verify we are able to print

        public void verifyPrint(){
            String mainWindow=getDriver().getWindowHandle();
            String mainWindowTittle=getDriver().getCurrentUrl();
            $(MISPOM.genericPath("Export")).click();
            $(MISPOM.genericPath("Print")).click();
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
                        Assert.assertTrue("User is able to print",true);
                        break;
                    }else {
                        Assert.fail("User is not able to print");
                       logger.info("User is not able to print");
                    }
                }
            }}

        //validate that clicking on copy button you are bale to see the popup of "copy to clipboard"
        public void verifyCopy() {
            waitABit(2000);
            $(MISPOM.genericPath("Export")).click();
            $(MISPOM.genericPath("Copy")).click();
            getDriver().switchTo().defaultContent();
            if($(ReimbursementPOM.copyClipboard).getText().equalsIgnoreCase("Copy to clipboard")){
                Assert.assertTrue("The copy functionality is working properly",true);
            }else{
                Assert.fail("Copy functionality not working properly");
                logger.info("Copy functionality not working properly");
            }
        }
    }


