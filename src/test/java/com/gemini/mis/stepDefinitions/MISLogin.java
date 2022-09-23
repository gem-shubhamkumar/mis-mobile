package com.gemini.mis.stepDefinitions;

import com.gemini.mis.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.LocatorLoginPage;

public class MISLogin {

    LoginPage steps;

    @Given("User opens MIS Beta page")
    public void user_opens_mis_beta_page()  {
        steps.navigateApplication("https://mymis.geminisolutions.com/");

    }
    @Then("User enters Username as {string}")
    public void user_enters_username_as(String username) {
       steps.enterValues(LocatorLoginPage.inputField("text"),username);

    }
    @And("User enters Password as {string}")
    public void user_enters_password_as(String password) {
        steps.enterValues(LocatorLoginPage.inputField("password"),password);

    }
   /* @Given("User verifies Logo")
    public void user_verifies_logo() {
      steps.isElementExist(LocatorLoginPage.logo);

    }*/

    @Then("User Verifies all elements of Login Page")
    public void user_verifies_all_elements_of_login_page() {
        steps.isElementExist(LocatorLoginPage.logo);
        steps.isElementExist(LocatorLoginPage.element("Forgot Password?"));
        steps.isElementExist(LocatorLoginPage.element("Login via SSO"));
        steps.isElementExist(LocatorLoginPage.element("Sign In"));

    }
    @Then("User Login clicks on sign in")
    public void user_login_clicks_on_sign_in()  {
        steps.Wait(1000);
        steps.click(LocatorLoginPage.inputField("button"));
        steps.WaitTillElementIsVisible(LocatorLoginPage.elementOnLandingPage);


    }

}
