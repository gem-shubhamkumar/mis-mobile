package stepDefinitions;

import com.gemini.mis.pages.LeaveManagementApplyPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.devtools.v85.page.Page;

public class LeaveManagementApplySteps extends PageObject
{


    @Steps
    LeaveManagementApplyPage ApplyPage;

    @Given("^User is on MIS Beta login page$")
    public void misBetaLoginPage()
    {
        ApplyPage.launchSite();
    }

    @Then("Enter {string} in {string} textbox")
    public void enterText(String text,String fieldName)
    {
        ApplyPage.typeIntoElement(text,fieldName);
    }

    @And("Click on {string} button")
    public void clickOnSignInButton(String btnName)
    {
        waitABit(3000);
        ApplyPage.clickOnButton(btnName);
    }

    @When("User is on MIS Home Page")
    public void userIsOnMISHomePage()
    {
        ApplyPage.verifyPage("Dashboard Page");
    }

    @Then("Click on {string} tab")
    public void clickOnTab(String tabName)
    {
        ApplyPage.clickOnSideNavigationOption(tabName);
    }

    @And("Verify {string} display")
    public void verifyDisplay(String options)
    {
        ApplyPage.sideNavOptions(options);
    }

    @And("Verify {string} opens successfully")
    public void verifyOpenSuccessfully(String tabName)
    {
        ApplyPage.verifyTab(tabName);
    }

    @And("Verify {string} displays by default")
    public void verifyDisplaysByDefault(String tab)
    {
        ApplyPage.verifyDefaultTab(tab);
    }

    @Then("Verify {string} fields are auto populated")
    public void verifyFieldsAreAutoPopulated(String fieldName)
    {
        ApplyPage.verifyAutoPopulated(fieldName);
    }

    @Then("Verify {string} fields are highlighted in red")
    public void verifyFieldsAreHighlightedInRed(String fields)
    {
        waitABit(5000);
        if(fields.contains(","))
        {
            String[] field = fields.split(",");
            for(int i=0;i<field.length;i++)
            {
                ApplyPage.verifyMandatoryFields(field[i]);
            }
        }
        else {
            ApplyPage.verifyMandatoryFields(fields);
        }
    }

    @Then("Select {string} from {string} Calendar")
    public void selectFromCalendar(String date, String calendarName)
    {
        ApplyPage.selectDate(date,calendarName);
    }

    @And("Verify {string} is selected successfully")
    public void verifyIsSelectedSuccessfully(String date)
    {
    }

    @Then("Click on {string} sub tab of {string} tab")
    public void clickOnSubTabOfTab(String childTab, String parentTab)
    {
        ApplyPage.clickOnSubTab(childTab,parentTab);
    }

    @Then("Click on {string} Tab")
    public void clickOntab(String tabName)
    {
        ApplyPage.clickOnTab(tabName);
    }
}
