package stepDefinitions;

import com.gemini.mis.pages.LeaveManagementPage;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ht.Le;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeaveManagementSteps extends PageObject
{


    @Steps
    LeaveManagementPage LeaveManagementTab;

    @Managed
    WebDriver driver;
    @Steps
    LeaveManagementPage ApplyPage;
    @Given("^User is logged into MIS$")
    public void userIsLoggedIn()
    {
        ApplyPage.launchSite();
        ApplyPage.typeIntoElement("jasleen.multani","username");
        ApplyPage.typeIntoElement("Gemini@123","password");
        waitABit(3000);
        ApplyPage.clickOnButton("Sign in");

    }

    @Then("Click on {string} button for Comp off Tab")
    public void clickOnButtonForCompOffTab(String btnName)
    {
        ApplyPage.clickOnButton("Submit Comp Off");
    }

    @Given("^User is on MIS Beta login page$")
    public void misBetaLoginPage()
    {
        LeaveManagementTab.launchSite();
    }

    @Then("Enter {string} in {string} textbox")
    public void enterText(String text,String fieldName)
    {
        LeaveManagementTab.typeIntoElement(text,fieldName);
    }

    @Then("Click on {string} button")
    public void clickOnSignInButton(String btnName)
    {
        waitABit(3000);
        LeaveManagementTab.clickOnButton(btnName);
    }

    @When("User is on MIS Home Page")
    public void userIsOnMISHomePage()
    {
        LeaveManagementTab.verifyPage("Dashboard Page");
    }

    @When("Click on {string} tab")
    public void clickOnTab(String tabName)
    {
        LeaveManagementTab.clickOnSideNavigationOption(tabName);
    }

    @And("Verify {string} display")
    public void verifyDisplay(String options)
    {
        LeaveManagementTab.sideNavOptions(options);
    }

    @And("Verify {string} opens successfully")
    public void verifyOpenSuccessfully(String tabName)
    {
        waitABit(5000);
        LeaveManagementTab.verifyTabDisplays(tabName);
    }

    @And("Verify {string} displays by default")
    public void verifyDisplaysByDefault(String tab)
    {
        LeaveManagementTab.verifyDefaultTab(tab);
    }

    @Then("Verify {string} fields are auto populated")
    public void verifyFieldsAreAutoPopulated(String fieldName)
    {
        LeaveManagementTab.verifyAutoPopulated(fieldName);
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
                LeaveManagementTab.verifyMandatoryFields(field[i]);
            }
        }
        else {
            LeaveManagementTab.verifyMandatoryFields(fields);
        }
    }

    @Then("Select {string} from {string} Calendar")
    public void selectFromCalendar(String date, String calendarName)
    {
        LeaveManagementTab.selectDate(date,calendarName);
    }

    @And("Verify {string} is selected successfully")
    public void verifyIsSelectedSuccessfully(String date)
    {
    }

    @When("Click on {string} sub tab of {string} tab")
    public void clickOnSubTabOfTab(String childTab, String parentTab)
    {
        LeaveManagementTab.clickOnSubTab(childTab,parentTab);
    }

    @Then("Click on {string} Tab")
    public void clickOntab(String tabName)
    {
        LeaveManagementTab.clickOnTab(tabName);
    }

    @Then("Select {string} From date and {string} till Leave dates from Calendar")
    public void selectFromDateAndTillLeaveDatesFromCalendar(String fromDate, String tillDate)
    {
        LeaveManagementTab.selectFromDate(XpathForLeaveManagementTab.calendarBtn("leaveFromDate"), fromDate);
        LeaveManagementTab.selectTillDate(XpathForLeaveManagementTab.calendarBtn("leaveTillDate"),tillDate);
    }

    @And("Verify {string} tooltip text")
    public void verifyTooltipText(String labelText)
    {
        LeaveManagementTab.verifyTooltip(labelText);
    }

    @Then("Click on {string} info icon")
    public void clickOnInfoIcon(String labelText)
    {
        LeaveManagementTab.clickOnButton(labelText);
    }

    @When("Click on {string} checkbox")
    public void clickOnCheckbox(String leaveType)
    {
        LeaveManagementTab.clickOnButton(leaveType);
    }

    @And("Verify {string} half day options are available")
    public void verifyHalfDayOptionsAreAvailable(String leaveOptions)
    {
        LeaveManagementTab.halfDayOptions(leaveOptions);
    }

    @And("Select {string} from Leave Type dropdown")
    public void selectFromLeaveTypeDropdown(String leaveType)
    {
        waitABit(5000);
        LeaveManagementTab.selectLeaveType(leaveType);
    }

    @And("Enter reason {string} for leave")
    public void enterReasonForLeave(String enterReason)
    {
        if(enterReason.equals("sick leave"))
        {
            LeaveManagementTab.enterText(XpathForLeaveManagementTab.textArea("leaveReason"),enterReason);
        }
        else if(enterReason.equals("WFH leave"))
        {
            LeaveManagementTab.enterText(XpathForLeaveManagementTab.textArea("WFHReason"),enterReason);
        }
    }

    @And("Verify Leave is submitted and {string} appears")
    public void verifyLeaveIsSubmitted(String message)
    {
        LeaveManagementTab.verifyPopup(message);
    }

    @And("choose {string} as Availability")
    public void chooseAsAvailability(String availabilityType)
    {
        LeaveManagementTab.availabilityType(availabilityType);
    }


    /// WORK FROM HOME
    @And("Verify {string} displays")
    public void verifyDisplays(String tabName)
    {
        LeaveManagementTab.verifyTabIsActive(tabName);
    }

    @Then("Select date from {string} date dropdown")
    public void selectDateFromDateDropdown(String tab)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        if(tab.equals("Work From Home"))
        LeaveManagementTab.selectDateFromDropdown(tomorrow, XpathForLeaveManagementTab.dropdown("WorkFromHomeDate"));
     }


    @Then("Click on Submit button for Leave Tab")
    public void clickOnButtonForLeaveTab()
    {
        LeaveManagementTab.clickOnButton("Submit Leave");
    }

    @Then("Click on Submit button for WFH")
    public void clickOnButtonForWFH()
    {
        LeaveManagementTab.clickOnButton("Submit WFH");
    }

    @Then("Click on Submit button for Comp off Tab")
    public void clickOnSubmitButtonForCompOffTab()
    {
        LeaveManagementTab.clickOnButton("Submit Comp off");
    }

    @Then("Select date from date dropdown")
    public void selectDateFromDateDropdown()
    {
        LeaveManagementTab.selectDateForCompOff();
    }

    @Then("Enter {string} as reason")
    public void enterAsReason(String reason)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.textArea("CompOffReason"),reason);
    }

    @Then("Click on Submit button for Out of Duty Tab")
    public void clickOnSubmitButtonForOutOfDutyTourTab()
    {
        LeaveManagementTab.clickOnButton("Submit Out of Duty/Tour");
    }

    @Then("Select {string} From date and {string} till Leave dates for Out Duty Tour")
    public void selectFromDateAndTillLeaveDatesForOutDutyTour(String fromDate, String tillDate)
    {
        LeaveManagementTab.selectFromDate(XpathForLeaveManagementTab.calendarBtn("outingFromDatePicker"), fromDate);
        LeaveManagementTab.selectTillDate(XpathForLeaveManagementTab.calendarBtn("outingTillDatePicker"),tillDate);
    }


    @And("Select {string} from Type dropdown")
    public void selectFromTypeDropdown(String dropdownVal)
    {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("outingType"));
        LeaveManagementTab.selectFromDropdown(elementFacade,dropdownVal);
    }

    @Then("Click on Submit button for LWP tab")
    public void clickOnSubmitButtonForLWPTab()
    {
        LeaveManagementTab.clickOnButton("Submit LWP");
    }


    @Then("Verify {string} fields is present")
    public void verifyFieldsIsPresent(String element)
    {
        LeaveManagementTab.verifyElement(element);
    }

    @And("Click {string} dropdown")
    public void clickDropdown(String dropdownName)
    {
        LeaveManagementTab.clickOnButton(dropdownName);
    }

    @Then("Enter {string} Invalid Date range")
    public void enterInvalidDateRange(String text)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("2"),text);
    }

    @And("Verify {string} message displays")
    public void verifyMessageDisplays(String message)
    {
        LeaveManagementTab.verifyMessageFor("Invalid Search Result",message);
    }

    @Then("Enter {string} Valid Date range")
    public void enterValidDateRange(String text)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("2"),text);
    }

    @And("Verify {string} text displays")
    public void verifyTextDisplays(String message)
    {
        LeaveManagementTab.verifyMessageFor("Valid Search Result",message);

    }

    @Then("Verify {string} is selected")
    public void verifyIsSelected(String text)
    {
        waitABit(10000);
        LeaveManagementTab.verifyDateSelected(text);
    }


    @Then("Verify {string} options are displayed")
    public void verifyOptionsAreDisplayed(String options)
    {
        String[] optionArray = options.split(",");
        for(int i=0;i<optionArray.length;i++)
        {
            LeaveManagementTab.verifyElement(optionArray[i]);
        }
    }

    @And("Verify Print page appears")
    public void verifyPrintPageAppears()
    {
        LeaveManagementTab.verifyPageOpens();
    }

    @And("Verify {string} popup appears")
    public void verifyPopupAppears(String popUpText)
    {
        LeaveManagementTab.verifyElement(popUpText);
    }

    @And("Verify excel file is downloaded for {string} Tab")
    public void verifyExcelFileIsDownloaded(String tab)
    {
        switch (tab)
        {
            case "Leave":
            LeaveManagementTab.verifyFile("Excel",tab);
            break;
            case "WFH":
            LeaveManagementTab.verifyFile("Excel WFH",tab);
            break;
            case "Comp Off":
            LeaveManagementTab.verifyFile("Excel Comp Off", tab);
            break;
            case "Out Duty/Tour":
            LeaveManagementTab.verifyFile("Excel Out Duty/Tour", tab);
            break;
            case "Change Request":
            LeaveManagementTab.verifyFile("Excel Change Request", tab);
            break;
        }

    }

    @And("Verify pdf file is downloaded for {string} Tab")
    public void verifyPdfFileIsDownloaded(String tab)
    {
        switch (tab) {
            case "Leave":
                LeaveManagementTab.verifyFile("Pdf", tab);
                break;
            case "Comp Off":
                LeaveManagementTab.verifyFile("Pdf Comp Off", tab);
                break;
            case "WFH":
                LeaveManagementTab.verifyFile("Pdf WFH", tab);
                break;
            case "Out Duty/Tour":
                LeaveManagementTab.verifyFile("Pdf Out Duty/Tour", tab);
                break;
            case "Change Request":
                LeaveManagementTab.verifyFile("Pdf Change Request", tab);
                break;
        }
    }

    @Then("Select {string} as Number of entries for {string} tab")
    public void selectAsNumberOfEntries(String number,String tab)
    {
        WebElementFacade elementFacade = null;
        switch (tab)
        {
            case "Leave":
                elementFacade = find(XpathforPolicyTab.lengthPage("tblLeaveHistory_length"));
                break;
            case "WFH":
                elementFacade = find(XpathforPolicyTab.lengthPage("tblWFHHistory_length"));
                break;
            case "Comp Off":
            elementFacade = find(XpathforPolicyTab.lengthPage("tblCompOffHistory_length"));
            break;
        }
        LeaveManagementTab.selectFromDropdown(elementFacade,number);
    }

    @Then("Verify {string} leave Period is filtered")
    public void verifyLeavePeriodIsFiltered(String searchText)
    {
        LeaveManagementTab.verifyLeavePeriod(searchText);
    }

    @Then("Sort {string} columns and verify sorting")
    public void sortColumns(String columns)
    {
        if(columns.contains(","))
        {
            String[] col = columns.split(",");
            for(int i=0;i<col.length;i++) {
                LeaveManagementTab.clickOnButton(col[i]);
                LeaveManagementTab.verifyColumnIsSorted(col[i]);
            }
        }
    }

    @Then("Click on {string} button if there is more than one page")
    public void clickOnButtonIfThereIsMoreThanOnePage(String btn)
    {
        List<WebElementFacade> list = findAll(XpathForLeaveManagementTab.pages);
        if(list.size()>=4)
        {
            LeaveManagementTab.clickOnButton(btn);
        }
    }

    @And("Verify Records are present on Page")
    public void verifyRecordsArePresentOnNextPage()
    {
        waitABit(5000);
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        if(noOfRecords.size()>0)
        {
            Assert.assertTrue("Number of Records verified",true);
        }
        else
        {
            Assert.fail("Number of Records not verified");
        }
    }

    @And("Verify Leave is cancelled and {string} appears")
    public void verifyLeaveIsCancelledAndAppears(String message)
    {
        LeaveManagementTab.verifyPopup(message);
    }

    @Then("Verify {string} Popup appears")
    public void verifyPopupAppear(String message)
    {
        LeaveManagementTab.verifyPopup(message);
    }

    @Then("Enter {string} {string} Date range in WFH")
    public void enterValidDateRangeInWFH(String text, String type)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("3"),text);
    }


    @When("User Enters {string} period in search box for {string} tab")
    public void userEntersPeriodInSearchBoxForTab(String text, String tabName)
    {
        LeaveManagementTab.typeText(text,tabName);
    }

    @Then("Verify {string} Period is filtered for {string} tab")
    public void verifyPeriodIsFilteredForTab(String textFiltered, String tabName)
    {
        LeaveManagementTab.verifyResult(textFiltered,tabName);
    }

    @Then("Enter {string} {string} Date range in Comp Off")
    public void enterValidDateRangeInCompOff(String text, String type)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("3"),text);
    }

    @And("Verify details of Comp Off request for {string}")
    public void verifyDetailsOfCompOffRequest(String text)
    {
        LeaveManagementTab.verifyDetailsForDate(text);
    }


    @Then("Verify {string} Date for {string} tab")
    public void verifyDateForTab(String inputField, String tabName)
    {
        LeaveManagementTab.verifyDetailsForDate(tabName);

    }

    @Then("Verify {string} Window appears")
    public void verifyWindowAppears(String title)
    {
        LeaveManagementTab.verifyTabDisplays(title);
    }

    @And("Verify {string} date")
    public void verifyDate(String date)
    {
        LeaveManagementTab.verifyOutingDate(date);
    }

    @And("Verify Detail Window closes")
    public void verifyDetailWindowCloses()
    {
        LeaveManagementTab.verifyTabDisplays("Leave History");
    }

    @Then("Enter {string} {string} Date range in Out Duty")
    public void enterValidDateRangeInOutDuty(String text,String type)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("3"),text);
    }

    @Then("Enter {string} {string} Date range in Change Request")
    public void enterDateRangeInChangeRequest(String text,String type)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("3"),text);
    }
}
