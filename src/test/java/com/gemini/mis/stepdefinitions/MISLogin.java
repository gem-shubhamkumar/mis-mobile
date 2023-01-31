package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.FormsPage;
import com.gemini.mis.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.gemini.mis.selectors.XpathForLoginPage;
import net.thucydides.core.annotations.Steps;


public class MISLogin {

    @Steps
    LoginPage steps;
    @Steps
    FormsPage form;

    @Given("User opens MIS Beta page {string}")
    public void userOpensMisBetaPage(String url)  {
        steps.navigateApplication(url);
    }
    @Given("User clicks on tab {string} and {string}")
    public void userClicksOnTabAnd(String parentTabName, String childTabName) {
        steps.customWait(3000);
        form.navigateParentAndChildTab(parentTabName, childTabName);
        steps.customWait(5000);
    }


    @Then("User enters Username as {string}")
    public void userEntersUsernameAs(String username) {
        steps.enterValues(XpathForLoginPage.inputField("text"),username);

    }

    @And("User enters Password as {string}")
    public void userEntersPasswordAs(String password) {
        steps.enterValues(XpathForLoginPage.inputField("password"),password);

    }

    @Given("User clicks on sign in")
    public void userClicksOnSignIn() {
        steps.customWait(4000);
        steps.waitTillElementIsVisible(XpathForLoginPage.inputField("button"));
        steps.click(XpathForLoginPage.inputField("button"));
    }

    @Then("User Verifies Landing Page")
    public void userVerifiesLandingPage() {

        steps.waitTillElementIsVisible(XpathForLoginPage.elementOnLandingPage);
    }

    @Given("User verifies logo and login page message")
    public void userVerifiesLogoAndLoginPageMessage() {
        steps.isElementExist(XpathForLoginPage.logoOnLoginPage);
//        added by shubham.kumar
//        steps.isElementExist(XpathForLoginPage.loginPageMsg);
    }

    @Then("User clicks on Login via SSO")
    public void userClicksOnLoginViaSSO() {
        steps.customWait(2000);
        steps.click(XpathForLoginPage.myElement("Login via SSO"));
    }

    @And("User verifies new Window of Microsoft Login")
    public void userVerifiesNewWindowOfMicrosoftLogin() {
        steps.customWait(1000);
        steps.changeFocusToNewTab();
        steps.waitTillElementIsVisible(XpathForLoginPage.logoOnNewWindow);
        steps.customWait(500);
        steps.isElementExist(XpathForLoginPage.myElement("Sign in"));
        form.closeApplication();

    }

    @And("User Clicks on Forgot password")
    public void userClicksOnForgotPassword(){
        steps.customWait(2000);
        steps.waitTillElementIsVisible(XpathForLoginPage.myElement("Forgot Password?"));
        steps.click(XpathForLoginPage.myElement("Forgot Password?"));
        steps.customWait(500);
    }

    @Then("User is navigated to Reset Password page")
    public void userIsNavigatedToResetPasswordPage()  {
        steps.waitTillElementIsVisible(XpathForLoginPage.buttonType("Reset Password"));


    }
    @And("User verifies Success message {string}")
    public void userVerifiesSuccessMessage(String text) {
        steps.waitTillElementIsVisible(XpathForLoginPage.myElement(text));
    }

    @Then("User closes the Popup by clicking Ok {string} and again verifies Reset Password Page")
    public void userClosesThePopupByClickingOkAndAgainVerifiesResetPasswordPage(String text) {
        steps.click(XpathForLoginPage.myElement(text));

    }

    @And("User clicks on Reset Password")
    public void userClicksOnResetPassword() {
        steps.click(XpathForLoginPage.buttonType("Reset Password"));

    }

    @And("User clicks on sign in button")
    public void userClicksOnSignInButton() {

        steps.click(XpathForLoginPage.myElement("Sign In"));
    }


}
