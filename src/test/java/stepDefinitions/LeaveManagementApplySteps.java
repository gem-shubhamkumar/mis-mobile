package stepDefinitions;

import com.beust.ah.A;
import com.gemini.mis.pages.LeaveManagementApplyPage;
import com.gemini.mis.selectors.XpathForApplyTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.devtools.v85.page.Page;

import java.util.Calendar;
import java.util.Date;

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

    @Then("Click on {string} button")
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

    @When("Click on {string} tab")
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

    @When("Click on {string} sub tab of {string} tab")
    public void clickOnSubTabOfTab(String childTab, String parentTab)
    {
        ApplyPage.clickOnSubTab(childTab,parentTab);
    }

    @Then("Click on {string} Tab")
    public void clickOntab(String tabName)
    {
        ApplyPage.clickOnTab(tabName);
    }

    @Then("Select {string} From date and {string} till Leave dates from Calendar")
    public void selectFromDateAndTillLeaveDatesFromCalendar(String fromDate, String tillDate)
    {
        ApplyPage.selectFromDate(fromDate);
        ApplyPage.selectTillDate(tillDate);
    }

    @And("Verify {string} tooltip text")
    public void verifyTooltipText(String labelText)
    {
        ApplyPage.verifyTooltip(labelText);
    }

    @Then("Click on {string} info icon")
    public void clickOnInfoIcon(String labelText)
    {
        ApplyPage.clickOnButton(labelText);
    }

    @When("Click on {string} checkbox")
    public void clickOnCheckbox(String leaveType)
    {
        ApplyPage.clickOnButton(leaveType);
    }

    @And("Verify {string} half day options are available")
    public void verifyHalfDayOptionsAreAvailable(String leaveOptions)
    {
        ApplyPage.halfDayOptions(leaveOptions);
    }

    @And("Select {string} from Leave Type dropdown")
    public void selectFromLeaveTypeDropdown(String leaveType)
    {
        waitABit(5000);
        ApplyPage.selectLeaveType(leaveType);
    }

    @And("Enter reason {string} for leave")
    public void enterReasonForLeave(String enterReason)
    {
        if(enterReason.equals("sick leave"))
        {
            ApplyPage.enterReason(XpathForApplyTab.textArea("leaveReason"),enterReason);
        }
        else if(enterReason.equals("WFH leave"))
        {
            ApplyPage.enterReason(XpathForApplyTab.textArea("WFHReason"),enterReason);
        }
    }

    @And("Verify Leave is submitted and {string} appears")
    public void verifyLeaveIsSubmitted(String message)
    {
        ApplyPage.verifyPopup(message);
    }

    @And("choose {string} as Availability")
    public void chooseAsAvailability(String availabilityType)
    {
        ApplyPage.availabilityType(availabilityType);
    }


    /// WORK FROM HOME
    @And("Verify {string} displays")
    public void verifyDisplays(String tabName)
    {
        ApplyPage.verifyTabIsActive(tabName);
    }

    @Then("Select date from date dropdown")
    public void selectDateFromDateDropdown()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        ApplyPage.selectDateFromDropdown(tomorrow, XpathForApplyTab.dropdown("WorkFromHomeDate"));

    }


}
