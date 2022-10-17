package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.OtherPortalPage;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class OtherPortalStepDefinition  {
@Steps
OtherPortalPage Pages;

    //validation of other portal navigation
    @Then("^Verify If other Portal is able to navigate \"(.*?)\" to the required location$")

   public void validationForHyperlink(String subsScreen){

        Pages.validateOtherPortal(subsScreen);
    }
}
