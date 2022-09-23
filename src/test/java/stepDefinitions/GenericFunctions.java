package stepDefinitions;

import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.selectors.GenericFunctionPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class GenericFunctions extends PageObject {
    @Steps
    CommonPage commonPages;
    //Launching my mis portal
    @Given("^Launch my MIS application$")
    public void launchPage(){
        getDriver().get("https://mymis.geminisolutions.com");
    }


    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() {
        commonPages.launchPage();
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

    @Then("^Click on \"(.*?)\" button$")
    public void clickOnButton(String buttonName) {
        commonPages.clickButton(buttonName);
    }

}
