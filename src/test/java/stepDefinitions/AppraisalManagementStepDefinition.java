package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppraisalManagementStepDefinition {
    @When("^\"(.*?)\" is present in the dashboard$")
    public void isScreenPresent(String query) {

    }

    @Then("^User clicks on \"(.*?)\" dropdown and clicks \"(.*?)\"$")
    public void isPresentThenClick(String param_1, String param_2) {

    }

    @And("^Verify page opens with title \"(.*?)\" upon clicking \"(.*?)\"$")
    public void verifyPageOpens(String param_1, String param_2){

    }

    @Then("^\"(.*?)\" dropdown is present$")
    public void isDropDownPresent(String query){

    }

    @And("^Select \"(.*?)\"$")
    public void selectElement(String elemName){

    }

    @And("^Click on goal type and select an options from goal type dropdown$")
    public void selectGoalAndClickOnDropdown(){

    }

    @Then("^Click on \"(.*?)\" and enter some text$")
    public void clickAndInput(String elem){

    }

    @And("Click on KPI Button and Add 2 KPI Fields")
    public void clickOnKPIAndAddFields(){

    }

    @Then("Verify the KPI Fields added")
    public void verifyKPIAdded(){

    }
    @And("Remove 1 empty KPI Field")
    public void removeEmptyKPIField(){

    }

    @Then("Verify empty KPI Removed")
    public void isKPIRemoved(){

    }

    @Then("^Verify link of \"(.*?)\" is clickable$")
    public void checkLinkClickable(String linkText){

    }

    @Then("^Click on \"(.*?)\" on KPI/KRA$")
    public void clickOnButtonOnKPIKRA(String buttonName){

    }

    @And("Verify KPI Submitted successfully")
    public void verifySuccessFullSubmission(){

    }





}
