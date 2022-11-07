package com.gemini.mis.pages;

import com.gemini.mis.implementations.TimeSheetImpl;
import net.thucydides.core.annotations.Step;

public class TimeSheetPage {

    //declarations
    private final TimeSheetImpl timeImpl = new TimeSheetImpl();
    /*-----------------------------------------------------------------------------------------------------------*/

    /*--------------------------------FUNCTIONS SPECIFIC TO CONFIGURE TIMESHEET----------------------------------*/

    @Step
    public void verifyCFTTableHeads() {
        timeImpl.verifyCFTTableHeads();
    }

    @Step
    public void verifyCFTTabs() {
        timeImpl.verifyCFTTabs();
    }

    @Step
    public void verifyActiveCFTTab() {
        timeImpl.verifyActiveCFTTab();
    }

    @Step
    public void clickSave() {
        timeImpl.clickSave();
    }

    /*---------------------------------FUNCTIONS SPECIFIC TO CREATE TIMESHEET------------------------------------*/

    @Step
    public void verifyAndAcceptPleaseNotePopup() {
        timeImpl.verifyAndAcceptPleaseNotePopup();
    }

    @Step
    public void verifyCTTableHeads() {
        timeImpl.verifyCTTableHeads();
    }

    @Step
    public void verifyCTTableData() {
        timeImpl.verifyCTTableData();
    }

    @Step
    public void openPreNextWeek(String Option) {
        timeImpl.openPreNextWeek(Option);
    }

    @Step
    public void verifyTimesheetStatus() {
        timeImpl.verifyTimesheetStatus();
    }

    @Step
    public void clickCopyFromWeek() {
        timeImpl.clickCopyFromWeek();
    }

    @Step
    public void verifyCopyTemplate(String Year, String Week) {
        timeImpl.verifyCopyTemplate(Year, Week);
    }

    @Step
    public void closeCFWDialogBox () {
        timeImpl.closeCFWDialogBox();
    }

    @Step
    public void crossCloseCFWDialogBox () {
        timeImpl.crossCloseCFWDialogBox();
    }

    /*-----------------------------FUNCTIONS SPECIFIC TO MANAGE TASK TEMPLATE------------------------------------*/

    @Step
    public void verifyMTTTableHeads() {
        timeImpl.verifyMTTTableHeads();
    }

    @Step
    public void clickAddNewTemplate() {
        timeImpl.clickAddNewTemplate();
    }

    @Step
    public void AddValidTemplate(String Name, String Description, String Team, String Task) {
        timeImpl.AddValidTemplate(Name,Description,Team, Task);
    }

    @Step
    public void AddDuplicateTemplate(String Name, String Description, String Team, String Task) {
        timeImpl.AddDuplicateTemplate(Name,Description,Team, Task);
    }

    @Step
    public void AddInvalidTemplate(String Name, String Description, String Team, String Task) {
        timeImpl.AddInvalidTemplate(Name,Description,Team, Task);
    }

    @Step
    public void closeANTDialogBox() {
        timeImpl.closeANTDialogBox();
    }

    @Step
    public void crossCloseANTDialogBox() {
        timeImpl.crossCloseANTDialogBox();
    }

    @Step
    public void clickEditTemplate(String txtUniqueIdentifier) {
        timeImpl.clickEditTemplate(txtUniqueIdentifier);
    }

    @Step
    public void EditTemplate(String Name, String Description, String Team, String Task) {
        timeImpl.EditTemplate(Name, Description, Team, Task);
    }

    @Step
    public void closeEditDialogBox() {
        timeImpl.closeEditDialogBox();
    }

    @Step
    public void crossCloseEditDialogBox() {
        timeImpl.crossCloseEditDialogBox();
    }

    @Step
    public void clickDeleteTemplate(String txtUniqueIdentifier) {
        timeImpl.clickDeleteTemplate(txtUniqueIdentifier);
    }

}
