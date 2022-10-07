package com.gemini.mis.pages;

import com.gemini.mis.selectors.MISCommonSelectors;
import com.gemini.mis.selectors.TimeSheetSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Logger;

public class TimeSheetFunc extends PageObject {

    //declarations
    private final TimeSheetSelectors ts = new TimeSheetSelectors();
    private final MISCommonSelectors mcs = new MISCommonSelectors();
    private final MISCommonFunc mcf = new MISCommonFunc();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(MISCommonFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

    /*----------------------------------------------CONFIGURE TIMESHEET-------------------------------------------*/

    public void verifyCFTTableHeads() {
        String[] act_Heads = mcf.getTableHeads();
        String[] exp_Heads = {"#", "Project Name", "Parent Project", "Role"};
        if(Arrays.equals(mcf.getTableHeads(), exp_Heads)) {
            log.info("Table headings are as expected: " + Arrays.toString(act_Heads));
        }else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(act_Heads) + " Expected: " + Arrays.toString(exp_Heads));
        }
    }

    public void verifyCFTTabs() {
        String[] exp_Tabs = {"Assigned Projects"};
        int act_TabsCount = getDriver().findElements(By.xpath("//li[@class='nav-item']//span")).size();
        String[] act_Tabs = new String[act_TabsCount-1];
        for(int i=0; i<act_TabsCount-1; i++) {
            act_Tabs[i] = getDriver().findElement(By.xpath("(//li[@class='nav-item']//span)["+(i+1)+"]")).getText();
        }

        if(Arrays.equals(act_Tabs, exp_Tabs)) {
            log.info("Tabs in configure timesheet page are as expected: " + Arrays.toString(act_Tabs));
        }else {
            Assert.fail("Tabs in configure timesheet page are not as expected. Actual: " + Arrays.toString(act_Tabs) + " Expected: " + Arrays.toString(exp_Tabs));
        }
    }

    public void verifyActiveCFTTab() {
        String exp_ActiveTab = "Assigned Projects";
        String act_ActiveTab = $(By.xpath("//a[@class='nav-link active']//span")).getText();

        if(act_ActiveTab.equals(exp_ActiveTab)) {
            log.info("Active tab in configure timesheet page is as expected: " + act_ActiveTab);
        }else {
            Assert.fail("Active tab in configure timesheet page is not as expected. Actual: " + act_ActiveTab + " Expected: " + exp_ActiveTab);
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

    /*----------------------------------------------CREATE TIMESHEET-------------------------------------------*/

    public void verifyAndAcceptPleaseNotePopup() {
        if($(ts.pleaseNotePopup).isDisplayed()) {
            log.info("Please note popup displayed");
            waitABit(1000);
            if($(ts.pleaseNoteMessage).isDisplayed() && $(mcs.btnOk).isDisplayed()) {
                log.info("All required elements displayed in please note popup");
                $(mcs.btnOk).click();
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
        String[] act_Heads = new String[cols];
        for(int i=0; i<cols; i++){
            act_Heads[i] = $(By.xpath("(//thead//td)["+(i+1)+"]")).getText();
        }
        String[] exp_Heads = {"Date", "Day"};
        if(Arrays.equals(mcf.getTableHeads(), exp_Heads)) {
            log.info("Table headings are as expected: " + Arrays.toString(act_Heads));
        }else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(act_Heads) + " Expected: " + Arrays.toString(exp_Heads));
        }
    }

    public void verifyCTTableData() {
        WebElement tableData = $(By.xpath("//tbody//td"));
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
                if($(ts.btnPreviousWeek).isDisplayed()) {
                    log.info("Previous week button is displayed");
                    $(ts.btnPreviousWeek).click();
                    waitABit(1000);
                    String txtSelectedWeekUpdated = $(ts.txtSelectedWeek).getText();
                    if(!txtSelectedWeekUpdated.equals(txtSelectedWeek)) {
                        log.info("Previous week opened successfully");
                    }else {
                        Assert.fail("Previous week not opened");
                    }
                }else {
                    Assert.fail("Previous week button is not displayed");
                }
                break;
            case "Next":
                if($(ts.btnNextWeek).isDisplayed()) {
                    log.info("Next week button is displayed");
                    Calendar calendar = Calendar.getInstance();
                    int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
                    if(!txtSelectedWeek.contains("# "+weekOfYear)) {
                        $(ts.btnNextWeek).click();
                        waitABit(1000);
                        String txtSelectedWeekUpdated = $(ts.txtSelectedWeek).getText();
                        if (!txtSelectedWeekUpdated.equals(txtSelectedWeek)) {
                            log.info("Next week opened successfully");
                        } else {
                            Assert.fail("Next week not opened");
                        }
                    }else {
                        $(ts.btnNextWeek).click();
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

    public void verifyCopyTemplate(String Year, String Week) throws Exception {
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
                mcf.verifyAndAcceptSuccessPopup();
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

    /*----------------------------------------------Manage Task Template-------------------------------------------*/

    public void verifyMTTTableHeads() {
        String[] act_Heads = mcf.getTableHeads();
        String[] exp_Heads = {"Template Name", "Description", "Team Name", "Task Type", "Task Sub Detail 1", "Task Sub Detail 2", "Action"};
        if (Arrays.equals(mcf.getTableHeads(), exp_Heads)) {
            log.info("Table headings are as expected: " + Arrays.toString(act_Heads));
        } else {
            Assert.fail("Table headings are not as expected. Actual: " + Arrays.toString(act_Heads) + " Expected: " + Arrays.toString(exp_Heads));
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

    public void AddValidTemplate(String Name, String Description, String Team, String Task) throws Exception {
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
                    mcf.verifyAndAcceptSuccessPopup();
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

    public void AddDuplicateTemplate(String Name, String Description, String Team, String Task) throws Exception {
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
                    mcf.verifyAndAcceptWarningPopup();
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

    public void AddInvalidTemplate(String Name, String Description, String Team, String Task) throws Exception {
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

    public void clickEditTemplate(String txtUniqueIdentifier) throws Exception {
        cf.maximizeBrowser();
        By btnEditTaskTemplate = By.xpath(ts.xpath_btnEditTaskTemplate.replace("VAR", txtUniqueIdentifier));
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
                        log.info("All fields are autopopulated");
                    }else {
                        Assert.fail("All fields are not autopopulated");
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

    public void verifyEditTemplate(String Name, String Description, String Team, String Task) throws Exception {
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
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
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
                        mcf.verifyAndAcceptSuccessPopup();
                    } else {
                        $(ts.btnUpdate).click();
                        mcf.verifyAndAcceptWarningPopup();
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

    public void clickDeleteTemplate(String txtUniqueIdentifier) throws Exception {
        cf.maximizeBrowser();
        WebElementFacade btnDeleteTaskTemplate = find(By.xpath(ts.xpath_btnDeleteTaskTemplate.replace("VAR",txtUniqueIdentifier)));
        if (btnDeleteTaskTemplate.isDisplayed()) {
            log.info("Delete button displayed");
            btnDeleteTaskTemplate.click();
        } else {
            Assert.fail("Delete button not displayed");
        }
    }

}
