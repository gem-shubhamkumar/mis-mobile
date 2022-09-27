package stepDefinitions;

import com.gemini.mis.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.gemini.mis.selectors.LocatorLoginPage;

import static net.serenitybdd.core.Serenity.getDriver;

public class MISLogin {

    LoginPage steps;
    private String text;

    @Given("User opens MIS Beta page {string}")
    public void user_opens_mis_beta_page(String url)  {
        steps.navigateApplication(url);

    }
    @Given("User verifies logo and login page message")
    public void userVerifiesLogoAndLoginPageMessage() {
        steps.isElementExist(LocatorLoginPage.logoOnLoginPage);
        steps.isElementExist(LocatorLoginPage.loginPageMsg);
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
        steps.Wait(1000);
        steps.WaitTillElementIsVisible(LocatorLoginPage.inputField("button"));
        steps.click(LocatorLoginPage.inputField("button"));
    }
    @Then("User Verifies Landing Page")
    public void user_verifies_landing_page() {
        steps.WaitTillElementIsVisible(LocatorLoginPage.elementOnLandingPage);

    }


    @Then("User clicks on Login via SSO")
    public void userClicksOnLoginViaSSO() {
        steps.Wait(1000);
        steps.click(LocatorLoginPage.myElement("Login via SSO"));
    }
    @And("User clicks on element {string}")
    public void userClicksOnElement(String element) {

    }
    @And("User verifies new Window of Microsoft Login")
    public void userVerifiesNewWindowOfMicrosoftLogin() {
        steps.changeFocusToNewTab();
        steps.WaitTillElementIsVisible(LocatorLoginPage.logoOnNewWindow);
        steps.isElementExist(LocatorLoginPage.myElement("Sign in"));
        getDriver().quit();
    }

    @And("User Clicks on Forgot password")
    public void userClicksOnForgotPassword(){
        steps.Wait(2000);
        steps.WaitTillElementIsVisible(LocatorLoginPage.myElement("Forgot Password?"));
        steps.click(LocatorLoginPage.myElement("Forgot Password?"));
        steps.Wait(500);
    }

    @Then("User is navigated to Reset Password page")
    public void userIsNavigatedToResetPasswordPage()  {
        steps.WaitTillElementIsVisible(LocatorLoginPage.buttonType("Reset Password"));
        steps.click(LocatorLoginPage.buttonType("Reset Password"));

    }
    @And("User verifies Success message {string}")
    public void userVerifiesSuccessMessage(String text) {
        steps.WaitTillElementIsVisible(LocatorLoginPage.myElement(text));
    }

    @Then("User closes the Popup by clicking Ok {string} and again verifies Reset Password Page")
    public void userClosesThePopupByClickingOkAndAgainVerifiesResetPasswordPage(String text) {
        steps.click(LocatorLoginPage.myElement(text));
        steps.WaitTillElementIsVisible(LocatorLoginPage.buttonType("Reset Password"));
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String text) {
        steps.Wait(1000);
        steps.isElementExist(LocatorLoginPage.myElement(text));

    }

    @And("User clicks on Reset Password")
    public void userClicksOnResetPassword() {
        steps.click(LocatorLoginPage.buttonType("Reset Password"));

    }

    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {
        steps.click(LocatorLoginPage.myElement("Sign In"));
    }
}
