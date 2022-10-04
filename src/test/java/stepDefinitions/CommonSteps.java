package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.pages.FeedbackPage;
import com.gemini.mis.pages.MySkillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CommonSteps {

    @Steps
    CommonPage commonPages;

    @Steps
    MySkillsPage skillsPages;

    @Steps
    CommonFunctions commonFunctions;

    @Steps
    FeedbackPage feedbackPage;

    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() throws Exception {
        commonFunctions.launchUrl("https://mymis.geminisolutions.com/");
        commonPages.verifyLoginMsg();

    }

    @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {
        commonPages.enterUsername(username);
        commonPages.enterPassword(password);
        feedbackPage.clickButton("Sign In");
    }

    @Then("^Verify Dashboard page opens$")
    public void verifyDashboardPageOpen() {
        commonPages.verifyDashboard();
    }

    @Then("^Click on \"(.*?)\" button$")
    public void clickOnButton(String buttonName) {
        feedbackPage.clickButton(buttonName);
    }


    @When("^\"(.*?)\" card is present in dashboard$")
    public void cardIsPresentInDashboard(String cardName) {
        skillsPages.verifyIfCardIsPresent(cardName);
    }



}
