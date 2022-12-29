package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.LeaveManagementPage;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LeaveManagementSteps
{
    @Steps
    LeaveManagementPage LeaveManagementTab;

    @Given("^User is logged into MIS$")
    public void userIsLoggedIn()
    {
        LeaveManagementTab.launchSite();
        LeaveManagementTab.typeIntoElement("jasleen.multani","username");
        LeaveManagementTab.typeIntoElement("Gemini@123","password");
        LeaveManagementTab.clickOnLoginButton();
    }

    @Then("Enter {string} in {string} textbox")
    public void enterText(String text,String fieldName)
    {
        LeaveManagementTab.typeIntoElement(text,fieldName);
    }

    @Then("Click on {string} button")
    public void clickButton(String btnName)
    {
        LeaveManagementTab.clickOnBtn(btnName,XpathForLeaveManagementTab.exportBtn("2"));
    }

    @When("User is on MIS Home Page")
    public void userIsOnMISHomePage()
    {
        LeaveManagementTab.verifyPage("Dashboard Page");
    }

    @When("Click on {string} tab")
    public void selectTab(String tabName)
    {
        LeaveManagementTab.clickOnSideNavigationOption(tabName);
    }

    @And("Verify {string} of {string} tab")
    public void verifyTabDisplays(String actualHeading,String tabName)
    {
        LeaveManagementTab.verifyTabDisplays(actualHeading);
    }

    @And("Verify {string} displays by default")
    public void verifyDisplaysByDefault(String tab)
    {
        LeaveManagementTab.verifyDefault(tab);
     }

    @Then("Verify {string} fields are auto populated")
    public void verifyFieldsAreAutoPopulated(String fieldName)
    {
        LeaveManagementTab.verifyAutoPopulated(fieldName);
    }

    @When("User clicks on {string} sub tab of {string} tab in MIS")
    public void clickOnSubTabOfTab(String childTab, String parentTab) throws InterruptedException
    {
        LeaveManagementTab.navigateToSubTab(childTab,parentTab);
    }

    @When("User clicks on {string} Tab")
    public void clickOnTab(String tabName)
    {
        LeaveManagementTab.navigateToTab(tabName);
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
        LeaveManagementTab.clickOnBtn(labelText, XpathForLeaveManagementTab.tooltip);
    }

    @When("Click on {string} checkbox")
    public void clickOnCheckbox(String leaveType)
    {
        LeaveManagementTab.clickOnBtn(leaveType,XpathForLeaveManagementTab.textBox("isLeaveHalfDay"));
    }

    @And("Verify {string} half day options are available")
    public void verifyHalfDayOptionsAreAvailable(String leaveOptions)
    {
        LeaveManagementTab.halfDayOptions(leaveOptions);
    }

    @And("Select {string} from Leave Type dropdown")
    public void selectFromLeaveTypeDropdown(String leaveType)
    {
        LeaveManagementTab.selectLeaveType(leaveType);
    }

    @And("Enter reason {string} for leave")
    public void enterReasonForLeave(String enterReason)
    {
        enterReason = enterReason.replaceAll(" ","");
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.textArea(enterReason),enterReason);
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


    @And("Verify {string} displays")
    public void verifyDisplays(String tabName)
    {
        LeaveManagementTab.verifyTabIsActive(tabName);
    }

    @Then("Select date from {string} date dropdown")
    public void selectDateFromDateDropdown(String tab)
    {
        LeaveManagementTab.selectDate(tab);
     }


    @Then("Click on Submit button for Leave Tab")
    public void clickOnButtonForLeaveTab()
    {
        LeaveManagementTab.clickOnBtn("Submit",XpathForLeaveManagementTab.submitBtn("1"));
    }
    @Then("User clicks on Submit button for Comp off Tab")
    public void clickOnSubmitButtonForCompOffTab()
    {
        LeaveManagementTab.clickOnButton(XpathForLeaveManagementTab.submitBtn("3"));
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
        LeaveManagementTab.clickOnBtn("Submit",XpathForLeaveManagementTab.submitBtn("5"));
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
        LeaveManagementTab.selectType(dropdownVal);
    }

    @Then("Click on Submit button for LWP tab")
    public void clickOnSubmitButtonForLWPTab()
    {
        LeaveManagementTab.clickOnBtn("Submit",XpathForLeaveManagementTab.submitBtn("4"));
    }



    @And("Click {string} dropdown")
    public void clickDropdown(String dropdownName)
    {
        LeaveManagementTab.clickOnBtn(dropdownName,XpathForLeaveManagementTab.dateRange);
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
        LeaveManagementTab.verifyDateSelected(text);
    }


    @Then("Verify {string} options are displayed")
    public void verifyOptionsAreDisplayed(String options)
    {
        String[] optionArray = options.split(",");
        for(int i=0;i<optionArray.length;i++)
        {
            LeaveManagementTab.verifyExportOptions(XpathForLeaveManagementTab.exportOptions(optionArray[i]));
        }
    }

    @And("Verify Print page appears")
    public void verifyPrintPageAppears()
    {
        LeaveManagementTab.verifyPageOpens();
    }

    @Then("Select {string} as Number of entries for {string} tab")
    public void selectAsNumberOfEntries(String number,String tab)
    {
        LeaveManagementTab.numberOfEntries(number,tab);
    }

    @Then("Sort {string} columns and verify sorting")
    public void sortColumns(String columns)
    {
        LeaveManagementTab.sortCol(columns);
     }

    @And("Verify Records are present on Page")
    public void verifyRecordsArePresentOnNextPage()
    {
        LeaveManagementTab.verifyRecords();
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

    @Then("Enter {string} {string} Date range")
    public void enterValidDateRange(String text, String type)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("3"),text);
    }


    @When("User Enters {string} period in search box for {string} tab")
    public void userEntersPeriodInSearchBoxForTab(String text, String tabName)
    {
      LeaveManagementTab.enterPeriod(text,tabName);
    }

    @Then("Verify {string} Period is filtered for {string} tab")
    public void verifyPeriodIsFilteredForTab(String textFiltered, String tabName)
    {
        LeaveManagementTab.verifyResult(textFiltered,tabName);
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

    @Then("Verify {string} text box is mandatory field")
    public void verifyFieldsAreMandatory(String field)
    {
        LeaveManagementTab.verifyMandatoryTextBoxField(field);
    }

    @Then("Verify {string} dropdown is mandatory field")
    public void verifyDropdownIsMandatoryFieldFor(String field) throws InterruptedException
    {
        LeaveManagementTab.verifyMandatoryDropdown(field);
    }

    @Then("Verify {string} calendar is mandatory field")
    public void verifyCalendarIsMandatoryField(String field)
    {
        LeaveManagementTab.verifyMandatoryCalendar(field);
    }

    @Then("Enter {string} in {string} text box")
    public void enterInTextBox(String text, String fieldName)
    {
        LeaveManagementTab.typeIntoTextBox(text,fieldName);
    }

    @Then("Verify Date Range field is present")
    public void verifyDateRangeFieldIsPresent()
    {
        LeaveManagementTab.verifyDateRange(XpathForLeaveManagementTab.dateRange);
    }

    @When("Click on {string} export option")
    public void clickOnExportOption(String btnName)
    {
        LeaveManagementTab.clickOnBtn(btnName,XpathForLeaveManagementTab.exportOptions(btnName));
    }

    @And("Verify {string} file is downloaded")
    public void verifyFileIsDownloaded(String fileName)
    {
         String username = System.getProperty("user.name");   //fetch system username
        String downloadPath = "C:\\Users\\"+username+"\\Downloads\\";
        LeaveManagementTab.verifyFile(downloadPath,fileName);
    }

    @Then("Sort {string} Columns and verify Sort")
    public void sortColumnsAndVerifySort(String columns)
    {
        LeaveManagementTab.sortAndVerify(columns);
    }

    @And("Click on Expand Comp Off button")
    public void clickOnExpandCompOffButton()
    {
        LeaveManagementTab.clickOnExpandButton("Expand Comp Off",XpathForLeaveManagementTab.expandBtn("11"));
    }

    @And("Verify details box appears")
    public void verifyDetailsBoxAppears()
    {
        LeaveManagementTab.verifyDetailBox();
    }

    @Then("Enter {string} Invalid Date range for Leave Tab")
    public void enterInvalidDateRangeForLeaveTab(String text)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("2"),text);
    }

    @Then("Enter {string} Valid Date range for Leave Tab")
    public void enterValidDateRangeForLeaveTab(String text)
    {
        LeaveManagementTab.enterText(XpathForLeaveManagementTab.searchBox("2"),text);
    }

    @When("Click on {string} button on Leave tab")
    public void clickOnButtonOnLeaveTab(String btnName)
    {
        LeaveManagementTab.clickOnExpandButton(btnName,XpathForLeaveManagementTab.exportBtn("1"));
    }

    @Then("Click on Next button for {string} tab")
    public void clickOnNextButtonForTab(String tabName)
    {
        LeaveManagementTab.navigateAllPages(tabName);
    }
    @Then("Click on Previous button for {string} tab")
    public void clickOnPreviousButtonForTab(String tabName)
    {
        LeaveManagementTab.clickOnPreviousPage(tabName);
     }

    @And("Click on Expand Leave button")
    public void clickOnExpandLeaveButton()
    {
        LeaveManagementTab.clickOnExpandButton("Expand Leave",XpathForLeaveManagementTab.expandBtn("1"));
    }

    @When("Click on Cancel button")
    public void clickOnCancelButton()
    {
        LeaveManagementTab.clickOnButton(XpathForLeaveManagementTab.cancelBtn);
    }

    @And("Click on Yes button")
    public void clickOnYesButton()
    {
        LeaveManagementTab.clickOnButton(XpathForLeaveManagementTab.button("confirm btn btn-lg btn-danger"));
    }

    @And("Click on Expand Button")
    public void clickOnExpandButton()
    {
        LeaveManagementTab.clickOnExpandButton("Expand Leave",XpathForLeaveManagementTab.expandBtn("11"));
    }

    @And("Click on View Out Duty button")
    public void clickOnViewOutDutyButton()
    {
        LeaveManagementTab.clickOnButton(XpathForLeaveManagementTab.viewBtn);
    }

    @And("Verify data is present")
    public void verifyDataIsPresent()
    {
        LeaveManagementTab.verifyDataIsPresent();
    }

    @Then("Click on Submit button for WFH tab")
    public void clickOnSubmitButtonForWFHTab()
    {
        LeaveManagementTab.clickOnBtn("WFH",XpathForLeaveManagementTab.submitBtn("2"));
    }

    @And("Verify Copied to Clipboard text appears")
    public void verifyTextAppears()
    {
        LeaveManagementTab.verifyText();
    }
}

