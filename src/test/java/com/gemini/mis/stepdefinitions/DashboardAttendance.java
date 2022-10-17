package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.DashboardAttendancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class DashboardAttendance {

    @Steps
    DashboardAttendancePage dashAtd;
    /*------------------------------------------------------------------------------------------------------------*/

    /*-----------------------------------------DASHBOARD ATTENDANCE CARD------------------------------------------*/

    @And("^Open attendance of \"(.*?)\"$")
    public void OpenAttendance(String MMMMYYYY) throws Exception {
        dashAtd.selectAndVerifyAttendanceMonth(MMMMYYYY);
    }

    /*---------------------------------------------MIS BETA COMMONS-----------------------------------------------*/

    @Given("Navigate to MIS Beta Application")
    public void launchMISBeta() {
        dashAtd.launchMISBeta();
    }

    @And("^Login to MIS with credentials \"(.*?)\" \"(.*?)\"$")
    public void loginToMIS(String Username, String Password) {
        dashAtd.loginToMIS(Username, Password);
    }

    @Then("Logout from MIS")
    public void logoutFromMIS() {
        dashAtd.optUserMenuAction("Logout");
    }

    @Then("^Open a settings page \"(.*?)\"$")
    public void openASettingsPage(String Page) {
        dashAtd.optUserMenuAction(Page);
    }

    @When("^Open \"(.*?)\" page")
    public void openAModule(String PageOption) {
        dashAtd.navigateToPage(PageOption);
    }

    @When("^Open \"(.*?)\" page of \"(.*?)\" module$")
    public void openAModulePage(String PageOption, String ModuleOption) {
        dashAtd.navigateToPage(PageOption, ModuleOption);
    }

    @And("^Verify \"(.*?)\" page of type \"(.*?)\"$")
    public void verifyPage(String Page, String PageType) {
        dashAtd.verifyPage(Page, PageType);
    }

    @And("Verify and accept success popup")
    public void verifyAndAcceptSuccess() {
        dashAtd.verifyAndAcceptSuccessPopup();
    }

    @Then("Verify and accept warning popup")
    public void verifyAndAcceptWarning() {
        dashAtd.verifyAndAcceptWarningPopup();
    }

    @Then("Verify and accept confirmation popup")
    public void verifyAndAcceptConfirmation() {
        dashAtd.verifyAndAcceptConfirmation();
    }

    @Then("Verify and reject confirmation popup")
    public void verifyAndRejectConfirmation() {
        dashAtd.verifyAndRejectConfirmation();
    }

}
