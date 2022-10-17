package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.OtherPortalPage;
import com.gemini.mis.pages.ReimbursementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MISStepDefinition  {
    @Steps
    OtherPortalPage otherPortalImplement;
    @Steps
    ReimbursementPage reimbursementImplement;

    //Launching my mis portal

    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void verifyApplicationOpensSuccessfully() {
        otherPortalImplement.launchPage();
        otherPortalImplement.verifyLoginMsg();

    }
    //login MIS
    @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {
        otherPortalImplement.enterUsername(username);
        otherPortalImplement.enterPassword(password);
        otherPortalImplement.clickButton("Sign In");
    }

    //button click
    @And("^Clicks \"(.*?)\" Button$")
    public void clicksButton(String buttonName) {

        otherPortalImplement.clickButton(buttonName);
    }
    //Navigate to only main tab
   @Then("^Click on main screen \"(.*?)\" tab$")
    public void navigateToTab(String parentTabName){

       otherPortalImplement.navigateToTab(parentTabName);
   }
   // Screen navigation
    @Then("^Click on \"(.*?)\" tab of \"(.*?)\" tab$")
    public void navigateToMainScreenAndSubScreen(String parentTabName, String childTabName){
        otherPortalImplement.navigateToTab(parentTabName,childTabName);


    }
    //Verify if button is visible
    @Then("Verify if Button is visible")
    public void verifyIfButtonIsVisible() {
        reimbursementImplement.buttonVisibility("Previous");
        reimbursementImplement.buttonVisibility("Next");
    }



}
