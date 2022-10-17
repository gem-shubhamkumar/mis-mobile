package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.ApplyToAnyCardPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ApplyToAnyCardStepDefinition {

    @Steps
    ApplyToAnyCardPages applyToAnyCardPages;


    @Given("^Verify beta-mis is open and loaded successfully.$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() {

        applyToAnyCardPages.launchURL("https://mymis.geminisolutions.com/");
    }

    @Then("^Verify beta-mis Dashboard page opens$")
    public void verifyDashboardPageOpen() {
        applyToAnyCardPages.verifyDashboard();
    }

    @When("^check \"(.*?)\" card is present in dashboard$")
    public void cardIsPresentInDashboard(String cardName) {
        applyToAnyCardPages.verifyIfCardIsPresent(cardName);
    }

    @When("^For User to login into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {

        applyToAnyCardPages.enterUsername(username);
        applyToAnyCardPages.enterPassword(password);
        applyToAnyCardPages.clickButton("Sign In");
    }

    @Then("^User clicks on \"(.*?)\" button on \"(.*?)\" card on dashboard$")
    public void userClicksOnButton(String buttonName, String cardName) {
        applyToAnyCardPages.clickButton(buttonName, cardName);
    }

    @And("^Verify that \"(.*?)\" card is minimized on dashboard$")
    public void verifyThatCardIsMinimized(String cardName) {
        applyToAnyCardPages.verifyCardMinimized(cardName);
    }

    @And("^Verify that \"(.*?)\" card is maximized on dashboard$")
    public void verifyThatCardIsMaximized(String cardName) {
        applyToAnyCardPages.verifyCardMaximized(cardName);
    }

}
