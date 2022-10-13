package com.gemini.mis.pages;

import com.gemini.mis.implementations.DashboardAttendanceImpl;
import net.thucydides.core.annotations.Step;

public class DashboardAttendancePage {

    //declarations
    private final DashboardAttendanceImpl dashAtdImpl = new DashboardAttendanceImpl();
    /*-----------------------------------------------------------------------------------------------------------*/

    /*----------------------------FUNCTIONS SPECIFIC TO DASHBOARD ATTENDANCE CARD--------------------------------*/

    @Step
    public void selectAndVerifyAttendanceMonth(String MMMMYYYY) throws Exception {
        dashAtdImpl.selectAndVerifyAttendanceMonth(MMMMYYYY);
    }

    /*----------------------------------------FUNCTIONS COMMON TO MIS--------------------------------------------*/

    @Step
    public void launchMISBeta() {
        dashAtdImpl.launchMISBeta();
    }

    @Step
    public void loginToMIS(String Username, String Password) {
        dashAtdImpl.loginToMIS(Username, Password);
    }

    @Step
    public void optUserMenuAction(String Action) {
        dashAtdImpl.optUserMenuAction(Action);
    }

    @Step
    public void navigateToPage(String PageOption) {
        dashAtdImpl.navigateToPage(PageOption);
    }

    @Step
    public void navigateToPage(String PageOption, String ModuleOption) {
        dashAtdImpl.navigateToPage(PageOption, ModuleOption);
    }

    @Step
    public void verifyPage(String Page, String PageType) {
        //PageType can be "Main" or "Sub"
        dashAtdImpl.verifyPage(Page, PageType);
    }

    @Step
    public void verifyTableData() {
        dashAtdImpl.verifyTableData();
    }

    @Step
    public void searchTextForNoRecords(String Text) {
        dashAtdImpl.searchTextForNoRecords(Text);
    }

    @Step
    public void searchTextForNonMatchingRecords(String Text) {
        dashAtdImpl.searchTextForNonMatchingRecords(Text);
    }

    @Step
    public void searchTextForMatchingRecords(String Text) {
        dashAtdImpl.searchTextForMatchingRecords(Text);
    }

    @Step
    public void verifyAndAcceptSuccessPopup() {
        dashAtdImpl.verifyAndAcceptSuccessPopup();
    }

    @Step
    public void verifyAndAcceptWarningPopup() {
        dashAtdImpl.verifyAndAcceptWarningPopup();
    }

    @Step
    public void verifyAndAcceptConfirmation() {
        dashAtdImpl.verifyAndAcceptConfirmation();
    }

    @Step
    public void verifyAndRejectConfirmation() {
        dashAtdImpl.verifyAndRejectConfirmation();
    }

}