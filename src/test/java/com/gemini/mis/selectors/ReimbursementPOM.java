package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class ReimbursementPOM {
    public static String dropdown="(//*[contains(@class,'select2 ')])[VAR]";
    public static String drpDownElement= "//li[text()='VAR']";
    public static By fileUpload=By.xpath("//input[@id='file']");
    public static By fileUploadText=By.xpath("//td[contains(@class,'image ')]");
    public static By selectDropDown=By.xpath("//*[contains(@id,'txtReimbCategory')]");
    public static String typeInValue="//input[@placeholder='TYPE']";
    public static By drpDownValue=By.xpath("//option[text()='Telephone & Internet Expense']");
    public static By rembuirsmentAmount=By.xpath("//input[@id='txtReimbursementAmount']");
    public static By currentYear=By.xpath("//label//span[@id='cntYear']");
    public static By NextYear=By.xpath("//label//span[@id='nxtYear']");
    public static By typeDropDownMainScreen=By.xpath("//select//option[text()='Monthly']");
    public static By yearDropDownMainScreen=By.xpath("//select//option[text()='2022 - 2023']");
    public static By listOfColumns=By.xpath("//th[@aria-controls='tblReimbursementList']");
    public static By totalAmountValue=By.xpath("(//th[@class='text-right']//label)[1]");
    public static By tableInfo=By.xpath("//div[@class='dataTables_info']");
    public static String totalAmountValuetext="(//td[@class=' text-right'])[VAR]";
    public static By requestTypeElment=By.xpath("(//*[text()='Monthly'])[3]");
    public static By cancelButton=By.xpath("(//button[contains(@onclick,'cancelReimbursementRequest')])[2]");
    public static String actionButton="(//button[contains(@onclick,'getFormToView')])[VAR]";
    public static By actionWindow=By.xpath("//*[text()='Reimbursement Form']");
    public static String canceledElements="(//*[contains(@onclick,'showReimbursementRemarksPopup')])[VAR]";
    public static By DateInput=By.xpath("//input[contains(@id,'txtDate')]");
    public static String copyClipboard = "//div[@id='datatables_buttons_info']/h2";
}
