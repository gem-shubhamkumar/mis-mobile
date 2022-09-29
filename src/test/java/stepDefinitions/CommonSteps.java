package stepDefinitions;

import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.LocatorLoginPage;
import com.gemini.mis.selectors.LocatorDashboardProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonSteps
{
    LoginPage steps;

    @Given("User opens MIS Beta page {string}")
    public void user_opens_mis_beta_page(String url)  {
        steps.navigateApplication(url);
    }
    @Then("User enters Username as {string}")
    public void user_enters_username_as(String username) {
        steps.enterValues(LocatorLoginPage.inputField("text"),username);

    }
    @And("User enters Password as {string}")
    public void user_enters_password_as(String password) {
        steps.enterValues(LocatorLoginPage.inputField("password"),password);

    }
    @Given("User clicks on sign in")
    public void user_clicks_on_sign_in() {
        steps.Wait(2000);
        steps.WaitTillElementIsVisible(LocatorLoginPage.inputField("button"));
        steps.click(LocatorLoginPage.inputField("button"));
    }

    @Then("User Verifies Landing Page")
    public void user_verifies_landing_page() {
        steps.WaitTillElementIsVisible(LocatorDashboardProfilePage.elementOnLandingPage);
        //steps.Wait(5000);

}}
