package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.DashboardAttendanceSelectors;
import com.gemini.mis.selectors.TimeSheetSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.util.Calendar;

public class TimeSheetImpl extends PageObject {

    //declarations
    private final TimeSheetSelectors ts = new TimeSheetSelectors();
    private final DashboardAttendanceSelectors ds = new DashboardAttendanceSelectors();
    private final DashboardAttendanceImpl dashImpl = new DashboardAttendanceImpl();
    private final CommonFunctions cf = new CommonFunctions();
    private final static Logger log = LoggerFactory.getLogger("SampleLogger");
    /*-----------------------------------------------------------------------------------------------------------*/

    /*--------------------------------FUNCTIONS SPECIFIC TO CONFIGURE TIMESHEET----------------------------------*/

    public void verifyCFTTableHeads() {
        String[] actHeads = dashImpl.getTableHeads();
        String[] expHeads = {"#", "Project Name", "Parent Project", "Role"};
        if(Arrays.equals(dashImpl.getTableHeads(), expHeads)) {
            log.info("Table headings are as expected: " + Arrays.toString(actHeads));
        }else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(actHeads) + " Expected: " + Arrays.toString(expHeads));
        }
    }

    public void verifyCFTTabs() {
        String[] expTabs = {"Assigned Projects"};
        int actTabsCount = getDriver().findElements(By.xpath("//li[@class='nav-item']//span")).size();
        String[] actTabs = new String[actTabsCount-1];
        for(int i=0; i<actTabsCount-1; i++) {
            actTabs[i] = getDriver().findElement(By.xpath("(//li[@class='nav-item']//span)["+(i+1)+"]")).getText();
        }

        if(Arrays.equals(actTabs, expTabs)) {
            log.info("Tabs in configure timesheet page are as expected: " + Arrays.toString(actTabs));
        }else {
            Assert.fail("Tabs in configure timesheet page are not as expected. Actual: " + Arrays.toString(actTabs) + " Expected: " + Arrays.toString(expTabs));
        }
    }

    public void verifyActiveCFTTab() {
        String expActiveTab = "Assigned Projects";
        String actActiveTab = $(By.xpath("//a[@class='nav-link active']//span")).getText();

        if(StringUtils.equalsIgnoreCase(actActiveTab, expActiveTab)) {
            log.info("Active tab in configure timesheet page is as expected: " + actActiveTab);
        }else {
            Assert.fail("Active tab in configure timesheet page is not as expected. Actual: " + actActiveTab + " Expected: " + expActiveTab);
        }
    }

    public void clickSave() {
        if($(ts.btnSave).isDisplayed()) {
            log.info("Save button present");
            $(ts.btnSave).click();
        }else {
            Assert.fail("Save button not present");
        }
    }

    /*---------------------------------FUNCTIONS SPECIFIC TO CREATE TIMESHEET------------------------------------*/

    public void verifyAndAcceptPleaseNotePopup() {
        if($(ts.pleaseNotePopup).isDisplayed()) {
            log.info("Please note popup displayed");
            waitABit(1000);
            if($(ts.pleaseNoteMessage).isDisplayed() && $(ds.btnOk).isDisplayed()) {
                log.info("All required elements displayed in please note popup");
                $(ds.btnOk).click();
                waitABit(1000);
                if(!($(ts.pleaseNotePopup).isDisplayed())) {
                    log.info("Please note popup accepted");
                }else {
                    Assert.fail("Please note popup not accepted");
                }
            }else {
                Assert.fail("All required elements not displayed in please note popup");
            }
        }else {
            Assert.fail("Please note popup not displayed");
        }
    }

    public void verifyCTTableHeads() {
        int cols = getDriver().findElements(By.xpath("//thead//td")).size();
        String[] actHeads = new String[cols];
        for(int i=0; i<cols; i++){
            actHeads[i] = $(By.xpath("(//thead//td)["+(i+1)+"]")).getText();
        }
        String[] expHeads = {"Date", "Day"};
        if(Arrays.equals(actHeads, expHeads)) {
            log.info("Table headings are as expected: " + Arrays.toString(actHeads));
        }else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(actHeads) + " Expected: " + Arrays.toString(expHeads));
        }
    }

    public void verifyCTTableData() {
        WebElementFacade tableData = $(By.xpath("//tbody//td"));
        if (tableData.getText().equalsIgnoreCase("Please configure timesheet first to fill your timesheet.")) {
            log.info("No data found in the table");
        }else {
            log.info("Following data is present in the table:\n" + tableData.getText());
        }
    }

    public void openPreNextWeek(String Option) {
        String txtSelectedWeek = $(ts.txtSelectedWeek).getText();
        switch (Option) {
            case "Previous":
                WebElementFacade btnPreviousWeek = $(ts.btnPreviousWeek);
                if(btnPreviousWeek.isDisplayed()) {
                    log.info("Previous week button is displayed");
                    btnPreviousWeek.click();
                    waitABit(1000);
                    String txtSelectedWeekUpdated = $(ts.txtSelectedWeek).getText();
                    if(!StringUtils.equalsIgnoreCase(txtSelectedWeekUpdated, txtSelectedWeek)) {
                        log.info("Previous week opened successfully");
                    }else {
                        Assert.fail("Previous week not opened");
                    }
                }else {
                    Assert.fail("Previous week button is not displayed");
                }
                break;
            case "Next":
                WebElementFacade btnNextWeek = $(ts.btnNextWeek);
                if(btnNextWeek.isDisplayed()) {
                    log.info("Next week button is displayed");
                    Calendar calendar = Calendar.getInstance();
                    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
                    if(!StringUtils.containsIgnoreCase(txtSelectedWeek, "# "+weekOfYear)) {
                        btnNextWeek.click();
                        waitABit(1000);
                        String txtSelectedWeekUpdated = $(ts.txtSelectedWeek).getText();
                        if (!StringUtils.equalsIgnoreCase(txtSelectedWeekUpdated, txtSelectedWeek)) {
                            log.info("Next week opened successfully");
                        } else {
                            Assert.fail("Next week not opened");
                        }
                    }else {
                        btnNextWeek.click();
                    }
                }else {
                    Assert.fail("Next week button is not displayed");
                }
                break;
        }
    }

    public void verifyTimesheetStatus() {
        if($(ts.timesheetStatus).isDisplayed()) {
            log.info("Timesheet status displayed");
            if($(ts.txtTimesheetLine1).containsText("Total time logged") && $(ts.txtTimesheetLine2).containsText("Status")) {
                log.info("Timesheet status contains total time logged and status");
            }else {
                Assert.fail("Timesheet status do not contain total time logged and status");
            }
        }else {
            Assert.fail("Timesheet status not displayed");
        }
    }

    public void clickCopyFromWeek() {
        if($(ts.btnCopyFromWeek).isDisplayed()){
            log.info("Copy from week button displayed");
            $(ts.btnCopyFromWeek).click();
            waitABit(1000);
            if($(ts.dialogCopyFromWeek).isDisplayed()) {
                log.info("Copy from week button clicked successfully. Copy from week dialog box displayed");
                if($(ts.yearDropdown).isDisplayed() && $(ts.weekDropdown).isDisplayed()) {
                    log.info("Mandatory dropdown fields displayed in Copy from week dialog box.");
                }else {
                    Assert.fail("Mandatory dropdown fields not displayed in Copy from week dialog box.");
                }
            }else {
                Assert.fail("Copy from week button not clicked. Copy from week dialog box not displayed");
            }
        }else {
            Assert.fail("Copy from week button not displayed");
        }
    }

    public void verifyCopyTemplate(String Year, String Week) {
        if ($(ts.btnCopyCFW).isDisplayed()) {
            log.info("Copy button displayed");
            Select yearDropdown = new Select($(ts.yearDropdown));
            String[] yearOptions = cf.listOptionsInSelectDropdown($(ts.yearDropdown));
            Select weekDropdown = new Select($(ts.yearDropdown));
            String[] weekOptions = cf.listOptionsInSelectDropdown($(ts.weekDropdown));
            if (Arrays.asList(yearOptions).contains(Year) && Arrays.asList(weekOptions).contains(Week)) {
                yearDropdown.selectByVisibleText(Year);
                weekDropdown.selectByVisibleText(Week);
                $(ts.btnCopyCFW).click();
                dashImpl.verifyAndAcceptSuccessPopup();
            }else if(!Arrays.asList(yearOptions).contains(Year) && Arrays.asList(weekOptions).contains(Week)) {
                weekDropdown.selectByVisibleText(Week);
                $(ts.btnCopyCFW).click();
                if(getDriver().findElements(ts.emptyDropdownError).size()==1) {
                    log.info("One empty dropdown errored out");
                }else {
                    Assert.fail("One empty dropdown not errored out");
                }
            }else if(Arrays.asList(yearOptions).contains(Year) && !Arrays.asList(weekOptions).contains(Week)) {
                yearDropdown.selectByVisibleText(Year);
                $(ts.btnCopyCFW).click();
                if(getDriver().findElements(ts.emptyDropdownError).size()==1) {
                    log.info("One empty dropdown errored out");
                }else {
                    Assert.fail("One empty dropdown not errored out");
                }
            }else {
                $(ts.btnCopyCFW).click();
                if(getDriver().findElements(ts.emptyDropdownError).size()==2) {
                    log.info("Two empty dropdowns errored out");
                }else {
                    Assert.fail("Two empty dropdowns not errored out");
                }
            }
        } else {
            Assert.fail("Copy button not displayed");
        }
    }

    public void closeCFWDialogBox () {
        if ($(ts.btnCloseCFW).isDisplayed()) {
            log.info("Close button displayed");
            $(ts.btnCloseCFW).click();
            waitABit(1000);
            if (!$(ts.dialogCopyFromWeek).isDisplayed()) {
                log.info("Copy from week dialog box closed successfully.");
            } else {
                Assert.fail("Copy from week dialog box not closed");
            }
        } else {
            Assert.fail("Close button not displayed");
        }
    }

    public void crossCloseCFWDialogBox () {
        if ($(ts.btnCrossCloseCFW).isDisplayed()) {
            log.info("Cross button displayed");
            $(ts.btnCrossCloseCFW).click();
            waitABit(1000);
            if (!$(ts.dialogCopyFromWeek).isDisplayed()) {
                log.info("Copy from week dialog box closed successfully.");
            } else {
                Assert.fail("Copy from week dialog box not closed");
            }
        } else {
            Assert.fail("Cross button not displayed");
        }
    }

    /*-----------------------------FUNCTIONS SPECIFIC TO MANAGE TASK TEMPLATE------------------------------------*/

    public void verifyMTTTableHeads() {
        String[] actHeads = dashImpl.getTableHeads();
        String[] expHeads = {"Template Name", "Description", "Team Name", "Task Type", "Task Sub Detail 1", "Task Sub Detail 2", "Action"};
        if (Arrays.equals(dashImpl.getTableHeads(), expHeads)) {
            log.info("Table headings are as expected: " + Arrays.toString(actHeads));
        } else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(actHeads) + " Expected: " + Arrays.toString(expHeads));
        }
    }

    public void clickAddNewTemplate() {
        if($(ts.btnAddNewTemplate).isDisplayed()){
            log.info("Add new template button displayed");
            $(ts.btnAddNewTemplate).click();
            waitABit(1000);
            if($(ts.dialogAddTaskTemplate).isDisplayed()) {
                log.info("Add new template button clicked successfully. Add task template dialog box displayed");
                if($(ts.txtTemplateName).isDisplayed() && $(ts.txtTemplateDescription).isDisplayed() &&
                        $(ts.teamNameDropdown).isDisplayed() && $(ts.taskTypeDropdown).isDisplayed()) {
                    log.info("Mandatory fields displayed in add task template dialog box.");
                }else {
                    Assert.fail("Mandatory fields not displayed in add task template dialog box.");
                }
            }else {
                Assert.fail("Add new template button not clicked. Add task template dialog box not displayed");
            }
        }else {
            Assert.fail("Add new template button not displayed");
        }
    }

    public void AddValidTemplate(String Name, String Description, String Team, String Task) {
        if ($(ts.btnSaveANT).isDisplayed()) {
            log.info("Save button displayed");
            ($(ts.txtTemplateName)).sendKeys(Name);
            ($(ts.txtTemplateDescription)).sendKeys(Description);
            Select teamNameDropdown = new Select($(ts.teamNameDropdown));
            String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdown));
            if (Arrays.asList(teamNameOptions).contains(Team)) {
                teamNameDropdown.selectByVisibleText(Team);
                waitABit(1000);
                Select taskTypeDropdown = new Select($(ts.taskTypeDropdown));
                String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdown));
                if (Arrays.asList(taskTypeOptions).contains(Task)) {
                    taskTypeDropdown.selectByVisibleText(Task);
                    $(ts.btnSaveANT).click();
                    dashImpl.verifyAndAcceptSuccessPopup();
                } else {
                    Assert.fail("Invalid task type");
                }
            } else {
                Assert.fail("Invalid team name");
            }
        }else {
            Assert.fail("Save button not displayed");
        }
    }

    public void AddDuplicateTemplate(String Name, String Description, String Team, String Task) {
        if ($(ts.btnSaveANT).isDisplayed()) {
            log.info("Save button displayed");
            ($(ts.txtTemplateName)).sendKeys(Name);
            ($(ts.txtTemplateDescription)).sendKeys(Description);
            Select teamNameDropdown = new Select($(ts.teamNameDropdown));
            String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdown));
            if (Arrays.asList(teamNameOptions).contains(Team)) {
                teamNameDropdown.selectByVisibleText(Team);
                waitABit(1000);
                Select taskTypeDropdown = new Select($(ts.taskTypeDropdown));
                String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdown));
                if (Arrays.asList(taskTypeOptions).contains(Task)) {
                    taskTypeDropdown.selectByVisibleText(Task);
                    $(ts.btnSaveANT).click();
                    dashImpl.verifyAndAcceptWarningPopup();
                    closeANTDialogBox();
                } else {
                    Assert.fail("Invalid task type");
                }
            } else {
                Assert.fail("Invalid team name");
            }
        }else {
            Assert.fail("Save button not displayed");
        }
    }

    public void AddInvalidTemplate(String Name, String Description, String Team, String Task) {
        if ($(ts.btnSaveANT).isDisplayed()) {
            log.info("Save button displayed");
            ($(ts.txtTemplateName)).sendKeys(Name);
            ($(ts.txtTemplateDescription)).sendKeys(Description);
            Select teamNameDropdown = new Select($(ts.teamNameDropdown));
            String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdown));
            if(!$(ts.txtTemplateName).getAttribute("value").equals("") && !$(ts.txtTemplateDescription).getAttribute("value").equals("")) {
                if(Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdown));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdown));
                    if(!Arrays.asList(taskTypeOptions).contains(Task)) {
                        $(ts.btnSaveANT).click();
                        if(getDriver().findElements(ts.emptyDropdownError).size()==1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        }else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                        closeANTDialogBox();
                    }
                }else {
                    $(ts.btnSaveANT).click();
                    if (getDriver().findElements(ts.emptyDropdownError).size() == 2) {
                        log.info("Team name invalid, two empty dropdowns errored out");
                    } else {
                        Assert.fail("Team name invalid but two empty dropdowns not errored out");
                    }
                    closeANTDialogBox();
                }
            }else if(!$(ts.txtTemplateName).getAttribute("value").equals("") ^ !$(ts.txtTemplateDescription).getAttribute("value").equals("")) {
                if(Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdown));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdown));
                    if(Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnSaveANT).click();
                    }else {
                        $(ts.btnSaveANT).click();
                        if(getDriver().findElements(ts.emptyDropdownError).size()==1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        }else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                    }
                }else {
                    $(ts.btnSaveANT).click();
                    if (getDriver().findElements(ts.emptyDropdownError).size() == 2) {
                        log.info("Team name invalid, two empty dropdowns errored out");
                    } else {
                        Assert.fail("Team name invalid but two empty dropdowns not errored out");
                    }
                }
                if(getDriver().findElements(ts.emptyFieldError).size()==1) {
                    log.info("One empty field errored out");
                }else {
                    Assert.fail("One empty field errored out");
                }
                closeANTDialogBox();
            }else {
                if(Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdown));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdown));
                    if(Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnSaveANT).click();
                    }else {
                        $(ts.btnSaveANT).click();
                        if(getDriver().findElements(ts.emptyDropdownError).size()==1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        }else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                    }
                }else {
                    $(ts.btnSaveANT).click();
                    if (getDriver().findElements(ts.emptyDropdownError).size() == 2) {
                        log.info("Team name invalid, two empty dropdowns errored out");
                    } else {
                        Assert.fail("Team name invalid but two empty dropdowns not errored out");
                    }
                }
                if(getDriver().findElements(ts.emptyFieldError).size()==2) {
                    log.info("Two empty fields errored out");
                }else {
                    Assert.fail("Two empty fields errored out");
                }
                closeANTDialogBox();
            }
        } else {
            Assert.fail("Save button not displayed");
        }
    }

    public void closeANTDialogBox() {
        if ($(ts.btnCloseANT).isDisplayed()) {
            log.info("Close button displayed");
            $(ts.btnCloseANT).click();
            waitABit(1000);
            if (!$(ts.dialogAddTaskTemplate).isDisplayed()) {
                log.info("Add task template dialog box closed successfully.");
            } else {
                Assert.fail("Add task template dialog box not closed");
            }
        } else {
            Assert.fail("Close button not displayed");
        }
    }

    public void crossCloseANTDialogBox() {
        if ($(ts.btnCrossCloseANT).isDisplayed()) {
            log.info("Cross button displayed");
            $(ts.btnCrossCloseCFW).click();
            waitABit(1000);
            if (!$(ts.dialogAddTaskTemplate).isDisplayed()) {
                log.info("Add task template dialog box closed successfully.");
            } else {
                Assert.fail("Add task template dialog box not closed");
            }
        } else {
            Assert.fail("Cross button not displayed");
        }
    }

    public void clickEditTemplate(String txtUniqueIdentifier) {
        waitABit(1000);
        By btnEditTaskTemplate = By.xpath(ts.xpathBtnEditTaskTemplate.replace("VAR", txtUniqueIdentifier));
        if($(btnEditTaskTemplate).isDisplayed()){
            log.info("Edit task template button displayed");
            $(btnEditTaskTemplate).click();
            waitABit(1000);
            if($(ts.dialogEditTaskTemplate).isDisplayed()) {
                log.info("Edit task template button clicked successfully. Edit task template dialog box displayed");
                if($(ts.txtTemplateNameEdit).isDisplayed() && $(ts.txtTemplateDescriptionEdit).isDisplayed() &&
                        $(ts.teamNameDropdownEdit).isDisplayed() && $(ts.taskTypeDropdownEdit).isDisplayed()) {
                    log.info("Mandatory fields displayed in edit task template dialog box.");
                    if(!$(ts.txtTemplateNameEdit).getAttribute("value").equals("") && !$(ts.txtTemplateNameEdit).getAttribute("value").equals("")
                            && !$(ts.txtTemplateNameEdit).getAttribute("value").equals("") && !$(ts.txtTemplateNameEdit).getAttribute("value").equals("")) {
                        log.info("All fields are auto-populated");
                    }else {
                        Assert.fail("All fields are not auto-populated");
                    }
                }else {
                    Assert.fail("Mandatory fields not displayed in edit task template dialog box.");
                }
            }else {
                Assert.fail("Edit task template button not clicked. Edit task template dialog box not displayed");
            }
        }else {
            Assert.fail("Edit task template button not displayed");
        }
    }

    public void EditTemplate(String Name, String Description, String Team, String Task) {
        if ($(ts.btnUpdate).isDisplayed()) {
            log.info("Update button displayed");
            if(!Name.equals("") && !Description.equals("")) {
                ($(ts.txtTemplateNameEdit)).clear();
                ($(ts.txtTemplateNameEdit)).sendKeys(Name);
                ($(ts.txtTemplateDescriptionEdit)).clear();
                ($(ts.txtTemplateDescriptionEdit)).sendKeys(Description);
                Select teamNameDropdown = new Select($(ts.teamNameDropdownEdit));
                String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdownEdit));
                if (Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        if (getDriver().findElements(ts.emptyDropdownError).size() == 1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        } else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                        closeEditDialogBox();
                    }
                } else {
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    }
                }
            }else if(Name.equals("") && !Description.equals("")) {
                ($(ts.txtTemplateDescriptionEdit)).clear();
                ($(ts.txtTemplateDescriptionEdit)).sendKeys(Description);
                Select teamNameDropdown = new Select($(ts.teamNameDropdownEdit));
                String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdownEdit));
                if (Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        if (getDriver().findElements(ts.emptyDropdownError).size() == 1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        } else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                        closeEditDialogBox();
                    }
                } else {
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    }
                }
            }else if(!Name.equals("") && Description.equals("")) {
                ($(ts.txtTemplateNameEdit)).clear();
                ($(ts.txtTemplateNameEdit)).sendKeys(Name);
                Select teamNameDropdown = new Select($(ts.teamNameDropdownEdit));
                String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdownEdit));
                if (Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        if (getDriver().findElements(ts.emptyDropdownError).size() == 1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        } else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                        closeEditDialogBox();
                    }
                } else {
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    }
                }
            }else {
                Select teamNameDropdown = new Select($(ts.teamNameDropdownEdit));
                String[] teamNameOptions = cf.listOptionsInSelectDropdown($(ts.teamNameDropdownEdit));
                if (Arrays.asList(teamNameOptions).contains(Team)) {
                    teamNameDropdown.selectByVisibleText(Team);
                    waitABit(1000);
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        if (getDriver().findElements(ts.emptyDropdownError).size() == 1) {
                            log.info("Task type invalid, one empty dropdown errored out");
                        } else {
                            Assert.fail("Task type invalid but empty dropdown not errored out");
                        }
                        closeEditDialogBox();
                    }
                } else {
                    Select taskTypeDropdown = new Select($(ts.taskTypeDropdownEdit));
                    String[] taskTypeOptions = cf.listOptionsInSelectDropdown($(ts.taskTypeDropdownEdit));
                    if (Arrays.asList(taskTypeOptions).contains(Task)) {
                        taskTypeDropdown.selectByVisibleText(Task);
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        dashImpl.verifyAndAcceptWarningPopup();
                        closeEditDialogBox();
                    }
                }
            }
        } else {
            Assert.fail("Update button not displayed");
        }
    }

    public void closeEditDialogBox() {
        if ($(ts.btnCloseEdit).isDisplayed()) {
            log.info("Close button displayed");
            $(ts.btnCloseEdit).click();
            waitABit(1000);
            if (!$(ts.dialogEditTaskTemplate).isDisplayed()) {
                log.info("Edit task template dialog box closed successfully.");
            } else {
                Assert.fail("Edit task template dialog box not closed");
            }
        } else {
            Assert.fail("Close button not displayed");
        }
    }

    public void crossCloseEditDialogBox() {
        if ($(ts.btnCrossEdit).isDisplayed()) {
            log.info("Cross button displayed");
            $(ts.btnCrossEdit).click();
            waitABit(1000);
            if (!$(ts.dialogEditTaskTemplate).isDisplayed()) {
                log.info("Edit task template dialog box closed successfully.");
            } else {
                Assert.fail("Edit task template dialog box not closed");
            }
        } else {
            Assert.fail("Cross button not displayed");
        }
    }

    public void clickDeleteTemplate(String txtUniqueIdentifier) {
        WebElementFacade btnDeleteTaskTemplate = find(By.xpath(ts.xpathBtnDeleteTaskTemplate.replace("VAR",txtUniqueIdentifier)));
        if (btnDeleteTaskTemplate.isDisplayed()) {
            log.info("Delete button displayed");
            btnDeleteTaskTemplate.click();
        } else {
            Assert.fail("Delete button not displayed");
        }
    }

}
