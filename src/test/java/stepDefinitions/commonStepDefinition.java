package stepDefinitions;

import com.gemini.mis.pages.LeaveManagementPage;
import com.gemini.mis.selectors.CommonXpath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class commonStepDefinition extends PageObject
{

    @Managed
    WebDriver driver;
    @Steps
    LeaveManagementPage ApplyPage;
    @Given("^User is logged into MIS$")
    public void userIsLoggedIn()
    {
        ApplyPage.launchSite();
        ApplyPage.typeIntoElement("jasleen.multani","username");
        ApplyPage.typeIntoElement("Gemini@1234","password");
        waitABit(3000);
        ApplyPage.clickOnButton("Sign in");

    }

    @Then("Click on {string} button for Comp off Tab")
    public void clickOnButtonForCompOffTab(String btnName)
    {
        ApplyPage.clickOnButton("Submit Comp Off");
    }


}
