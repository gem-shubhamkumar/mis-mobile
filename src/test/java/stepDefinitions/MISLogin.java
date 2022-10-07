package stepDefinitions;

import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.CommonSelectors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.gemini.mis.selectors.LocatorLoginPage;

import static net.serenitybdd.core.Serenity.getDriver;

public class MISLogin {

    LoginPage steps;

    @Given("User verifies logo and login page message")
    public void userVerifiesLogoAndLoginPageMessage() {
        steps.isElementExist(LocatorLoginPage.logoOnLoginPage);
        steps.isElementExist(LocatorLoginPage.loginPageMsg);
    }

    @Then("User clicks on Login via SSO")
    public void userClicksOnLoginViaSSO() {
        steps.Wait(2000);
        steps.click(CommonSelectors.myElement("Login via SSO"));
    }

    @And("User verifies new Window of Microsoft Login")
    public void userVerifiesNewWindowOfMicrosoftLogin() {
        steps.Wait(1000);
        steps.changeFocusToNewTab();
        steps.WaitTillElementIsVisible(LocatorLoginPage.logoOnNewWindow);
        steps.Wait(500);
        steps.isElementExist(CommonSelectors.myElement("Sign in"));
        getDriver().quit();

    }

    @And("User Clicks on Forgot password")
    public void userClicksOnForgotPassword(){
        steps.Wait(2000);
        steps.WaitTillElementIsVisible(CommonSelectors.myElement("Forgot Password?"));
        steps.click(CommonSelectors.myElement("Forgot Password?"));
        steps.Wait(500);
    }

    @Then("User is navigated to Reset Password page")
    public void userIsNavigatedToResetPasswordPage()  {
        steps.WaitTillElementIsVisible(LocatorLoginPage.buttonType("Reset Password"));


    }
    @And("User verifies Success message {string}")
    public void userVerifiesSuccessMessage(String text) {
        steps.WaitTillElementIsVisible(CommonSelectors.myElement(text));
    }

    @Then("User closes the Popup by clicking Ok {string} and again verifies Reset Password Page")
    public void userClosesThePopupByClickingOkAndAgainVerifiesResetPasswordPage(String text) {
        steps.click(CommonSelectors.myElement(text));

    }

    @And("User clicks on Reset Password")
    public void userClicksOnResetPassword() {
        steps.click(LocatorLoginPage.buttonType("Reset Password"));

    }

    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {

        steps.click(CommonSelectors.myElement("Sign In"));
    }


}
