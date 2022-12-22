package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.DashboardAttendancePage;
import com.gemini.mis.pages.TimeSheetPage;
import com.gemini.mis.selectors.DashboardAttendanceSelectors;
import com.gemini.mis.selectors.TimeSheetSelectors;
import io.cucumber.java.en.And;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeSheet extends PageObject {

    @Steps
    DashboardAttendancePage dashAtd;

    @Steps
    TimeSheetPage time;

    //declarations
    private final TimeSheetSelectors ts = new TimeSheetSelectors();
    private final DashboardAttendanceSelectors ds = new DashboardAttendanceSelectors();
    private final static Logger log = LoggerFactory.getLogger("SampleLogger");
    /*----------------------------------------------------------------------------------------------------------*/

    /*---------------------------------------------CONFIGURE TIMESHEET------------------------------------------*/

    @And("Verify table for configure Timesheet page")
    public void verifyCFTTableData() {
        time.verifyCFTTableHeads();
        dashAtd.verifyTableData();
    }

    @And("Verify timesheet status")
    public void verifyTimesheetStatus() {
        time.verifyTimesheetStatus();
    }

    @And("Verify all tabs and active tab")
    public void verifyTabsAndActiveTab() {
        time.verifyCFTTabs();
        time.verifyActiveCFTTab();
    }

    @And("^Perform search for \"(.*?)\" using search box when no records are displayed$")
    public void performSearchForNoRecords(String Text) {
        dashAtd.searchTextForNoRecords(Text);
    }

    @And("^Perform invalid search for \"(.*?)\" using search box when records are displayed$")
    public void performInvalidSearch(String Text) {
        dashAtd.searchTextForNonMatchingRecords(Text);
    }

    @And("^Perform valid search for \"(.*?)\" using search box when records are displayed$")
    public void performValidSearch(String Text) {
        dashAtd.searchTextForMatchingRecords(Text);
    }

    @And("Click on save button")
    public void clickSave() {
        time.clickSave();
    }

    @And("Verify and accept please note popup")
    public void verifyAndAcceptNote() {
        time.verifyAndAcceptPleaseNotePopup();
    }

    /*----------------------------------------------CREATE TIMESHEET--------------------------------------------*/

    @And("Verify table for create Timesheet page")
    public void verifyCTTableData() {
        time.verifyCTTableHeads();
        time.verifyCTTableData();
    }

    @And("Open previous and next week")
    public void openPreNextWeek() {
        time.openPreNextWeek("Previous");
        time.openPreNextWeek("Next");
        time.openPreNextWeek("Next");
    }

    @And("^Copy timesheet from week \"(.*?)\" of year \"(.*?)\"$")
    public void copyFromWeek(String Week, String Year) {
        time.clickCopyFromWeek();
        time.verifyCopyTemplate(Week, Year);
        time.closeCFWDialogBox();
    }

    /*-------------------------------------------Manage Task Template-------------------------------------------*/

    @And("Verify table for manage task template page")
    public void verifyMTTTableData() {
        time.verifyMTTTableHeads();
        dashAtd.verifyTableData();
    }

    @And("^Add a new invalid task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewInvalidTemplate(String Name, String Description, String Team, String Task) {
        waitABit(4000);
        time.clickAddNewTemplate();
        time.AddInvalidTemplate(Name, Description, Team, Task);
    }

    @And("^Add a new duplicate task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewDuplicateTemplate(String Name, String Description, String Team, String Task) {
        time.clickAddNewTemplate();
        time.AddDuplicateTemplate(Name, Description, Team, Task);
    }

    @And("^Add a new valid task template with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void addNewValidTemplate(String Name, String Description, String Team, String Task) {
        WebElementFacade searchBox = $(ds.txtSearch);
        if(searchBox.isDisplayed()) {
            log.info("Search box displayed");
            searchBox.typeAndEnter(Name);
            if($(ts.txtTemplateData1).getText().equals(Name)) {
                log.info("Searched item present");
                time.clickDeleteTemplate(Name);
                dashAtd.verifyAndAcceptConfirmation();
                time.clickAddNewTemplate();
                time.AddValidTemplate(Name, Description, Team, Task);
            }else {
                time.clickAddNewTemplate();
                time.AddValidTemplate(Name, Description, Team, Task);
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    @And("^Edit a task template \"(.*?)\" with \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
    public void editTemplate(String txtUniqueIdentifier, String Name, String Description, String Team, String Task) {
        time.clickEditTemplate(txtUniqueIdentifier);
        time.verifyEditTemplate(Name, Description, Team, Task);
    }

    @And("^Click on Delete button for a task template \"(.*?)\"$")
    public void deleteTemplate(String txtUniqueIdentifier) {
        time.clickDeleteTemplate(txtUniqueIdentifier);
    }

}
