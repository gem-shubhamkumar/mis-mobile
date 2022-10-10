package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.*;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.LocatorLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class CommonSteps {

    @Steps
    CommonPages commonPages;

    @Steps
    LoginPage steps;

    @Steps
    ApplyToAnyCardPages skillsPages;

    @Steps
    CommonFunctions commonFunctions;

    @Steps
    FeedbackPage feedbackPage;

    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() throws Exception {
        commonFunctions.launchUrl("https://mymis.geminisolutions.com/");
        commonPages.verifyLoginMsg();
    }

    @Given("User opens MIS Beta page {string}")
    public void user_opens_mis_beta_page (String url) throws Exception {
        steps.navigateApplication(url);
        }

        @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
        public void enterUsername(String username, String password){
            commonPages.enterUsername(username);
            commonPages.enterPassword(password);
            feedbackPage.clickButton("Sign In");
        }


        @Then("User enters Username as {string}")
        public void user_enters_username_as (String username){
            steps.enterValues(LocatorLoginPage.inputField("text"), username);

        }

        @And("User enters Password as {string}")
        public void user_enters_password_as(String password){
            steps.enterValues(LocatorLoginPage.inputField("password"), password);

        }

        @Given("User clicks on sign in")
        public void user_clicks_on_sign_in () {
            steps.Wait(2000);
            steps.WaitTillElementIsVisible(LocatorLoginPage.inputField("button"));
            steps.click(LocatorLoginPage.inputField("button"));
        }
        @Then("^Click on \"(.*?)\" button$")
        public void clickOnButton(String buttonName){
            feedbackPage.clickButton(buttonName);
        }

        @When("^\"(.*?)\" card is present in dashboard$")
        public void cardIsPresentInDashboard(String cardName){
            skillsPages.verifyIfCardIsPresent(cardName);
        }


        @Then("User Verifies Landing Page")
        public void user_verifies_landing_page () {
            steps.WaitTillElementIsVisible(CommonSelectors.elementOnLandingPage);
        }
    }