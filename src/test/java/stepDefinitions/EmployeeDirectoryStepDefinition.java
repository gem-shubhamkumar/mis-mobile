package stepDefinitions;

import com.gemini.mis.pages.EmployeeDirectoryPages;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class EmployeeDirectoryStepDefinition extends PageObject {
    @Steps
    EmployeeDirectoryPages empDir;

    @Then("^Verify the employee directory page is downloaded$")
    public void VerifyDownloaded(){
        empDir.VerifyPageDownloaded();
    }
    @Then("^Verify mail link is able to click$")
    public void VerifyMailBox(){
        empDir.MailClick();
    }
    @Then("^Verify Profile window is visible$")
    public void VerifyProfile(){
        empDir.VerifyProfileWindow();
    }
}
