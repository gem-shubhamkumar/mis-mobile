package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class DashboardReferralPOM {

    public static By jdButton= By.xpath("(//button[contains(@onclick,'viewDocumentInPopup')])[1]");
    public static By jdWindow=By.xpath("//embed[@id='objViewPdf']");
    public static String jdRole="(//td[text()='VAR'])[1]";
    public static By referralButton =By.xpath("(//button[@title='Refer'])[1]");
    public static By jdNameRefer=By.xpath("//input[@id='refereeName']");
    public static By jdEmail=By.xpath("//input[@id='refereeID']");
    public static By jdContactNo=By.xpath("//input[@id='contact']");
    public static By relationshipDropDown=By.xpath("//select[@id='relationName']");
    public static By viewResume=By.xpath("(//*[contains(@onclick,'viewResumeInPopup')])[1]");
    //public static By referralWindow=By.xpath("(//div[@class='modal-content']//div[contains(@class,'container margin-top')])[2]");
    public static By fileUpload=By.xpath("//input[@type='file']");

}
