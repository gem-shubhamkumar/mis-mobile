package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class ReimbursementPOM {
    public static By dropdown(String VAR) {
        return By.xpath("(//*[contains(@class,'select2 ')])["+VAR+"]");
    }
    public static By drpDownElement ( String VAR){
       return By.xpath("//li[text()='"+VAR+"']");
    }
    public static By fileUpload=By.xpath("//input[@id='file']");
    public static By fileUploadText=By.xpath("//td[contains(@class,'image ')]");
    public static By selectDropDown=By.xpath("//*[contains(@id,'txtReimbCategory')]");
    public static By typeInValue(String TYPE )
    {
        return By.xpath("//input[@placeholder='"+TYPE+"']");
    }
    public static By drpDownValue=By.xpath("//option[text()='Telephone & Internet Expense']");
    public static By reimbursementAmount =By.xpath("//input[@id='txtReimbursementAmount']");
    public static By currentYear=By.xpath("//label//span[@id='cntYear']");
    public static By NextYear=By.xpath("//label//span[@id='nxtYear']");
    public static By typeDropDownMainScreen=By.xpath("//select//option[text()='Monthly']");
    public static By yearDropDownMainScreen=By.xpath("//select//option[text()='2022 - 2023']");
    public static By listOfColumns=By.xpath("//th[@aria-controls='tblReimbursementList']");
    public static By totalAmountValue(String VAR){
        return By.xpath("(//th[@class='text-right']//label)["+VAR+"]");
    }
    public static By tableInfo=By.xpath("//div[@class='dataTables_info']");
    public static By  totalAmountValueText=By.xpath("(//td[@class=' text-right'])");

    public static By requestTypeElement (String VAR){
        return By.xpath("(//*[text()='Monthly'])["+VAR+"]");
    }
    public static By cancelButton(String VAR){
        return By.xpath("(//button[contains(@onclick,'cancelReimbursementRequest')])["+VAR+"]");}
    public static By actionButton (String VAR){
        return  By.xpath("(//button[contains(@onclick,'getFormToView')])["+VAR+"]");
    }
    public static By actionWindow=By.xpath("//*[text()='Reimbursement Form']");
    public static By canceledElements(String VAR){
        return By.xpath("(//*[contains(@onclick,'showReimbursementRemarksPopup')])["+VAR+"]");
    }
    public static By dateInput=By.xpath("//input[contains(@id,'txtDate')]");
    public static By copyClipboard =By.xpath( "//div[@id='datatables_buttons_info']/h2");
}
