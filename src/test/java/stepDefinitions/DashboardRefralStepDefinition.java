package stepDefinitions;

import com.gemini.mis.pages.DashboardReferralPage;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class DashboardRefralStepDefinition extends PageObject {
    @Steps
    DashboardReferralPage DRPage;

    @Then("^Verify that dashboard page is downloaded and JD window is visible$")

    public void VerifyJDWindow(){
        DRPage.VerifyJdButton();
    }
    @Then("^Create a referral and verify the red error warnings$")
    public void RedErrorWarning(){
        DRPage.ValidateRedWarnings();
    }

    @Then("^Create a referral by filling all the details with \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\", \"(.*?)\" and validate is a success$")
    public void ValidateReferralCreation(String filePath,String name, String email,String mobileNo,String type){
        DRPage.CreateReferral(filePath,name,email,mobileNo,type);

    }

    @Then("^Validate resume popup in my referral card$")
    public void ValidateResumePopup(){
        DRPage.VerifyResumePopup();
    }
    @Then("^Validate Wrong email popup$")
    public void VerifyWrongEMailPopup(){
        DRPage.WrongEmail();
    }
    @Then("^Validate Wrong format \"(.*?)\" upload popup$")
    public void VerifyWrongUploadPopup(String filePath){
        DRPage.WarningWrongFormat(filePath);
    }
    @Then("^validate and Click on FAQ pdf$")
    public void VerifyFAQPdf(){
        DRPage.FAQPdfView();
    }
    @Then("^validate and Click on Manual pdf$")
    public void VerifyManualPdf(){
        DRPage.ManualPdfView();
    }

}
