package stepDefinitions;

import com.gemini.mis.pages.CommonPages;
import com.gemini.mis.pages.ApplyToAnyCardPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonSteps {

    @Steps
    CommonPages commonPages;

    @Steps
    ApplyToAnyCardPages skillsPages;

    @Given("^Verify beta-mis is open and loaded successfully.$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() {
        commonPages.launchURL("https://mymis.geminisolutions.com/");
        commonPages.verifyLoginMsg();

    }

    @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {
        commonPages.enterUsername(username);
        commonPages.enterPassword(password);
        commonPages.clickButton("Sign In");
    }


    @And("^Clicks \"(.*?)\" Button$")
    public void clicksButton(String buttonName) {
        commonPages.clickButton(buttonName);
    }

    @Then("^Verify Dashboard page opens$")
    public void verifyDashboardPageOpen() {
        commonPages.verifyDashboard();
    }

    @Then("^Click on \"(.*?)\" button$")
    public void clickOnButton(String buttonName) {
        commonPages.clickButton(buttonName);
    }

    @When("^\"(.*?)\" card is present in dashboard$")
    public void cardIsPresentInDashboard(String cardName) {
        skillsPages.verifyIfCardIsPresent(cardName);
    }


}
