package stepDefinitions;

import com.gemini.mis.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.gemini.mis.selectors.LocatorLoginPage;

import static net.serenitybdd.core.Serenity.getDriver;

public class MISLogin {

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

    @Then("User Verifies all elements of Login Page")
    public void user_verifies_all_elements_of_login_page() {
        steps.isElementExist(LocatorLoginPage.logo);
        steps.isElementExist(LocatorLoginPage.elementOnLoginPage("Forgot Password?"));
        steps.isElementExist(LocatorLoginPage.elementOnLoginPage("Login via SSO"));
        steps.isElementExist(LocatorLoginPage.elementOnLoginPage("Sign In"));
        steps.isElementExist(LocatorLoginPage.loginPageMsg);
    }
    @Given("User clicks on sign in")
    public void user_clicks_on_sign_in() {
        steps.Wait(1000);
        steps.click(LocatorLoginPage.inputField("button"));
    }
    @Then("User Verifies Landing Page")
    public void user_verifies_landing_page() {
        steps.WaitTillElementIsVisible(LocatorLoginPage.elementOnLandingPage);
    }

    @And("User verifies error message for {string}")
    public void userVerifiesErrorMessageOf(String error_text) {
        steps.Wait(1000);
        steps.isElementExist(LocatorLoginPage.elementOnLoginPage(error_text));
    }
}
