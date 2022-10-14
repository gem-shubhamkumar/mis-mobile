package com.gemini.mis.implementations;

import com.gemini.mis.selectors.DashboardReferralPOM;
import com.gemini.mis.selectors.MISPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardReferralImplementation extends PageObject {
    static final Logger logger = LoggerFactory.getLogger("SampleLogger");


    OtherPortalsImplementation genFun ;
    //verify all the buttons are visible on page load
    public void verifyJdButton() {
        waitABit(7000);
        Boolean isReferralCard=$(MISPOM.genericPath("Referral")).isVisible();
        Boolean isMyReferralCard=$(MISPOM.genericPath("My Referral")).isVisible();
        String jdRole=$(By.xpath(DashboardReferralPOM.jdRole.replace("VAR","DevOps"))).getText();
        WebElementFacade jd=find(DashboardReferralPOM.jdWindow);
        $(DashboardReferralPOM.jdButton).click();
        waitABit(2000);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", jd);
        String JDPdf=jd.getAttribute("src");
        waitABit(5000);

        Boolean isJDWindow=$(DashboardReferralPOM.jdWindow).isVisible();

        if(isJDWindow && isReferralCard && isMyReferralCard && JDPdf.contains(jdRole)){
            Assert.assertTrue("Dashboard page loaded properly and JD window pop successful",true);
        }else{
            Assert.fail("Dashboard page loaded properly and JD window pop up unsuccessful");
            logger.info("Dashboard page loaded properly and JD window pop up unsuccessful");
        }
    }
    //validate red warning when you keep filed empty
    public void validateRedWarnings(){
        waitABit(2000);
        $(DashboardReferralPOM.referralButton).click();
//       WebElementFacade referralWindow=find(DashboardReferralPOM.referralWindow);
//        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//        executor.executeScript("arguments[0].focus();",referralWindow );
        waitABit(3000);
        $(DashboardReferralPOM.jdNameRefer).click();
        $(DashboardReferralPOM.jdNameRefer).type("Saloni Pacholi");
        $(DashboardReferralPOM.jdEmail).click();
        $(DashboardReferralPOM.jdEmail).type("saloni.pacholi14@gmial.com");
        genFun.clickOnButton("Save");
        String errorValidation=$(DashboardReferralPOM.jdContactNo).getAttribute("class");
        if (errorValidation.contains("error")){
            Assert.assertTrue("The red lining warning are visible to show the error",true);
        }else{
            Assert.fail("User is unable to detect the warning");
            logger.info("User is unable to detect the warning");
        }

    }
    //Verify referral creation
    public void createReferral(String filePath,String name, String email,String mobileNo,String type){
        waitABit(2000);
        $(DashboardReferralPOM.referralButton).click();
        waitABit(2000);
        $(DashboardReferralPOM.jdNameRefer).click();
        $(DashboardReferralPOM.jdNameRefer).type(name);
        $(DashboardReferralPOM.jdEmail).click();
        $(DashboardReferralPOM.jdEmail).type(email);
        $(DashboardReferralPOM.jdContactNo).click();
        $(DashboardReferralPOM.jdContactNo).type(mobileNo);
        WebElementFacade dropDown= find(DashboardReferralPOM.relationshipDropDown);
        clickOn(dropDown);
        $(MISPOM.genericPath(type)).click();
        waitABit(2000);
        WebElementFacade inputLogo= $(DashboardReferralPOM.fileUpload);
        // inputLogo.click();
        inputLogo.sendKeys(filePath);
        waitABit(2000);
        genFun.clickOnButton("Save");
        boolean verifySuccess=$(MISPOM.genericPath("Referred successfully")).isVisible();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("window.scrollBy(0,300)");
        waitABit(3000);
        String verifyReferral=$(DashboardReferralPOM.viewResume).getText();
        if (verifySuccess && verifyReferral.contains(name)){
            Assert.assertTrue("User is able to create a referral successfully",true);
        }else{
            Assert.fail("Referral creation Unsuccessful");
            logger.info("Referral creation Unsuccessful");
        }

    }
    //Resume pop while you click on the name of the person
    public void verifyResumePopup(){
        waitABit(2000);
        WebElementFacade resume=find(DashboardReferralPOM.viewResume);
        String verifyReferral=resume.getText();
        clickOn(resume);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", resume);
        String verifyResume=resume.getAttribute("onclick");
        if(verifyResume.contains(verifyReferral)){
            Assert.assertTrue("The resume popup works as expected",true);
        }else{
            Assert.fail("The resume pop is not working properly");
            logger.info("The resume pop is not working properly");
        }


    }
    //Wrong email warning
    public void wrongEmail(){

        waitABit(2000);
        $(DashboardReferralPOM.referralButton).click();
        waitABit(1000);
        $(DashboardReferralPOM.jdNameRefer).click();
      //  waitABit(2000);
        $(DashboardReferralPOM.jdNameRefer).type("Saloni Pacholi");
        $(DashboardReferralPOM.jdEmail).click();
        $(DashboardReferralPOM.jdEmail).type("saloni.pachol");
        $(DashboardReferralPOM.jdContactNo).click();
        genFun.clickOnButton("Save");
        boolean ErrorMessage=$(MISPOM.genericPath("You have entered an invalid email address!")).isVisible();
        if (ErrorMessage){
            Assert.assertTrue("The email warning is working as expected",true);
        }else {
            Assert.fail("The email warning is not working as expected");
            logger.info("The email warning is not working as expected");
        }
    }
    //Warning file upload format
    public void warningWrongFormat(String filePath){
        waitABit(2000);
        $(DashboardReferralPOM.referralButton).click();
        WebElementFacade inputLogo= $(DashboardReferralPOM.fileUpload);
        inputLogo.sendKeys(filePath);
        waitABit(9000);
        //genFun.ClickOnButton("Save");
        boolean ErrorMessage=$(MISPOM.genericPath("Invalid file selected. Supported extensions are .doc,.docx,.pdf,.PDF")).isVisible();
        if (ErrorMessage){
            Assert.assertTrue("The upload format warning is working as expected",true);
        }else {
            Assert.fail("The upload format warning is not working as expected");
            logger.info("The upload format warning is not working as expected");

        }
    }
    //FAQ pdf visibility
    public void fAQPdfView(){
        waitABit(2000);
        $(MISPOM.genericPath("FAQ")).click();
        WebElementFacade FAQ=find(DashboardReferralPOM.jdWindow);
        boolean FAQVisibility=FAQ.isVisible();
        waitABit(2000);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", FAQ);
        String FAQPdf=FAQ.getAttribute("src");

        if (FAQVisibility && FAQPdf.contains("FAQ"))
        {
            Assert.assertTrue("the FAQ pdf is visible",true);
        }else{
            Assert.fail("the FAQ pdf is not visible");
            logger.info("the FAQ pdf is not visible");
        }
    }
    //Pdf visibility
    public void manualPdfView(){
        waitABit(3000);
        $(MISPOM.genericPath("Manual")).click();
        WebElementFacade Manual=find(DashboardReferralPOM.jdWindow);
        boolean ManualVisibility=Manual.isVisible();
        waitABit(2000);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", Manual);
        String ManualPdf=Manual.getAttribute("src");

        if (ManualVisibility && ManualPdf.contains("Manual"))
        {
            Assert.assertTrue("the Manual pdf is visible",true);
        }else{
            Assert.fail("the Manual pdf is not visible");
           logger.info("the Manual pdf is not visible");
        }
    }
}
