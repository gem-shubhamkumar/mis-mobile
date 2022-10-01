package com.gemini.mis.pages;

import com.gemini.mis.selectors.DashboardReferralPOM;
import com.gemini.mis.selectors.GenericFunctionPOM;
import com.gemini.mis.selectors.ReimbursementPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DashboardReferralPage extends PageObject {
    GenericFunctionPages_Siddhanshi genFun;
@Step("Click on JD button and verify window is visible or not")
    public void VerifyJdButton() {
    waitABit(7000);
        Boolean isReferralCard=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Referral"))).isVisible();
        Boolean isMyReferralCard=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","My Referral"))).isVisible();
   String JDRole=$(By.xpath(DashboardReferralPOM.JDRole.replace("VAR","DevOps"))).getText();
    WebElementFacade JD=find(DashboardReferralPOM.JDWindow);
    $(DashboardReferralPOM.JDButton).click();
    waitABit(2000);
   JavascriptExecutor executor = (JavascriptExecutor)getDriver();
executor.executeScript("arguments[0].focus();", JD);
       String JDPdf=JD.getAttribute("src");
    waitABit(5000);

        Boolean isJDWindow=$(DashboardReferralPOM.JDWindow).isVisible();

        if(isJDWindow && isReferralCard && isMyReferralCard && JDPdf.contains(JDRole)){
            Assert.assertTrue("Dashboard page loaded properly and JD window pop successful",true);
        }else{
            Assert.fail("Dashboard page loaded properly and JD window pop up unsuccessful");
        }
    }
    @Step("Create a refal and verify if some values are left blank it gives warning")
    public void ValidateRedWarnings(){
    waitABit(2000);
    $(DashboardReferralPOM.RefralButton).click();
//    WebElementFacade referralWindow=find(DashboardReferralPOM.referralWindow);
//        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//        executor.executeScript("arguments[0].focus();",referralWindow );
        waitABit(3000);
    $(DashboardReferralPOM.JdNameRefer).click();
        $(DashboardReferralPOM.JdNameRefer).type("Saloni Pacholi");
        $(DashboardReferralPOM.JDEmail).click();
        $(DashboardReferralPOM.JDEmail).type("saloni.pacholi14@gmial.com");
        genFun.ClickOnButton("Save");
        String errorValidation=$(DashboardReferralPOM.JDContactNo).getAttribute("class");
        if (errorValidation.contains("error")){
            Assert.assertTrue("The red lining warning are visible to show the error",true);
        }else{
            Assert.fail("We are unable to detect the warning");
        }

    }
    @Step("Create a proper referral and verify it's save ")
    public void CreateReferral(String filePath,String name, String email,String mobileNo,String type){
        waitABit(2000);
        $(DashboardReferralPOM.RefralButton).click();
        waitABit(2000);
        $(DashboardReferralPOM.JdNameRefer).click();
        $(DashboardReferralPOM.JdNameRefer).type(name);
        $(DashboardReferralPOM.JDEmail).click();
        $(DashboardReferralPOM.JDEmail).type(email);
        $(DashboardReferralPOM.JDContactNo).click();
        $(DashboardReferralPOM.JDContactNo).type(mobileNo);
        $(DashboardReferralPOM.relationshipDropDown).click();
        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR",type))).click();
        waitABit(2000);
        WebElementFacade inputLogo= $(DashboardReferralPOM.fileUpload);
       // inputLogo.click();
        inputLogo.sendKeys(filePath);
        waitABit(1500);
        genFun.ClickOnButton("Save");
        Boolean verifySuccess=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Referred successfully"))).isVisible();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("window.scrollBy(0,300)");
        String verifyReferral=$(DashboardReferralPOM.viewResume).getText();
        if (verifySuccess && verifyReferral.contains(name)){
            Assert.assertTrue("We are able to create a referral successfully",true);
        }else{
            Assert.fail("Referral creation Unsuccessful");
        }

    }

    @Step("verify on clicking on any name in MyReferral the resume of that person will pop")
    public void VerifyResumePopup(){
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
        }


    }
    @Step("Verify wrong email popup")
    public void WrongEmail(){
        waitABit(2000);
        $(DashboardReferralPOM.RefralButton).click();
        $(DashboardReferralPOM.JdNameRefer).click();
        $(DashboardReferralPOM.JdNameRefer).type("Saloni Pacholi");
        $(DashboardReferralPOM.JDEmail).click();
        $(DashboardReferralPOM.JDEmail).type("saloni.pachol");
        $(DashboardReferralPOM.JDContactNo).click();
        genFun.ClickOnButton("Save");
        Boolean ErrorMessage=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","You have entered an invalid email address!"))).isVisible();
if (ErrorMessage){
    Assert.assertTrue("The email warning is working as expected",true);
}else {
    Assert.fail("The email warning is not working as expected");
}
    }
    @Step("Warning when uploading in jpg or png format")
    public void WarningWrongFormat(String filePath){
        waitABit(2000);
        $(DashboardReferralPOM.RefralButton).click();
        WebElementFacade inputLogo= $(DashboardReferralPOM.fileUpload);
        inputLogo.sendKeys(filePath);
        waitABit(9000);
        //genFun.ClickOnButton("Save");
        Boolean ErrorMessage=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Invalid file selected. Supported extensions are .doc,.docx,.pdf,.PDF"))).isVisible();
        if (ErrorMessage){
            Assert.assertTrue("The upload format warning is working as expected",true);
        }else {
            Assert.fail("The upload format warning is not working as expected");
        }
    }
    @Step("Verify FAQ pdf view is visible")
    public void FAQPdfView(){
    $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","FAQ"))).click();
        WebElementFacade FAQ=find(DashboardReferralPOM.JDWindow);
        Boolean FAQVisibility=FAQ.isVisible();
        waitABit(2000);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", FAQ);
        String FAQPdf=FAQ.getAttribute("src");

        if (FAQVisibility && FAQPdf.contains("FAQ"))
        {
            Assert.assertTrue("the FAQ pdf is visible",true);
        }else{
            Assert.fail("the FAQ pdf is not visible");
        }
    }


    @Step("Verify Manual pdf view is visible")
    public void ManualPdfView(){
        $(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Manual"))).click();
        WebElementFacade Manual=find(DashboardReferralPOM.JDWindow);
        Boolean ManualVisibility=Manual.isVisible();
        waitABit(2000);
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", Manual);
        String ManualPdf=Manual.getAttribute("src");

        if (ManualVisibility && ManualPdf.contains("Manual"))
        {
            Assert.assertTrue("the Manual pdf is visible",true);
        }else{
            Assert.fail("the Manual pdf is not visible");
        }
    }
}