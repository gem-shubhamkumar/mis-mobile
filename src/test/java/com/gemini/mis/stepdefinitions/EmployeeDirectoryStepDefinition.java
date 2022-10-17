package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.EmployeeDirectoryPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class EmployeeDirectoryStepDefinition {
    @Steps
    EmployeeDirectoryPage empDir;
    //verify page downloaded successfully
    @Then("^Verify the employee directory page is downloaded$")
    public void verifyDownloaded(){
        empDir.verifyPageDownloaded();
    }
    //verify mail link
    @Then("^Verify mail link is able to click$")
    public void verifyMailBox(){
        empDir.mailClick();
    }
    //profile window visibility
    @Then("^Verify Profile window is visible$")
    public void verifyProfile(){
        empDir.verifyProfileWindow();
    }
}
