package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.DashboardReferralPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class DashboardReferralStepDefinition  {
    @Steps
    DashboardReferralPage DRPage;

    //Verify page downloaded
    @Then("^Verify that dashboard page is downloaded and JD window is visible$")

    public void verifyJDWindow(){

        DRPage.verifyJdButton();
    }
    //Verify red warring
    @Then("^Create a referral and verify the red error warnings$")
    public void redErrorWarning(){

        DRPage.validateRedWarnings();
    }
    //Validate referral creation
    @Then("^Create a referral by filling all the details with \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and validate is a success$")
    public void validateReferralCreation(String filePath,String name, String email,String mobileNo,String type){
        DRPage.createReferral(filePath,name,email,mobileNo,type);

    }
    //validate resume popup
    @Then("^Validate resume popup in my referral card$")
    public void validateResumePopup(){

        DRPage.verifyResumePopup();
    }
    //Validate wrong email warning
    @Then("^Validate Wrong email popup$")
    public void verifyWrongEMailPopup(){

        DRPage.wrongEmail();
    }
    //Validate wrong format
    @Then("^Validate Wrong format \"(.*?)\" upload popup$")
    public void verifyWrongUploadPopup(String filePath){

        DRPage.warningWrongFormat(filePath);
    }
    // Validate FAQ Pdf
    @Then("^validate and Click on FAQ pdf$")
    public void verifyFAQPdf(){

        DRPage.fAQPdfView();
    }
   // Validate manual PDF
    @Then("^validate and Click on Manual pdf$")
    public void verifyManualPdf(){
        DRPage.manualPdfView();
    }

}
