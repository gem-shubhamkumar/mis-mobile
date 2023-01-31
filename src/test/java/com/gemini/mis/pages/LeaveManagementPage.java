package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.implementations.LeaveImplementation;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.*;

import java.util.Date;

public class LeaveManagementPage {

    LeaveImplementation implementation;

    @Step("Launch MIS Beta site")
    public void launchSite() {
        implementation.launchSite();
    }

    @Step
    public void typeIntoElement(String text, String fieldName) {
        implementation.type(text, fieldName);
    }

    @Step
    public void verifyPage(String pageName) {
        implementation.verifySuccessfulLogin(pageName);
    }

    @Step
    public void clickOnSideNavigationOption(String tabName) {
        implementation.clickOnTab(tabName);
    }

    @Step
    public void verifyTabDisplays(String actualHeading) {
        implementation.verifyTabDisplays(actualHeading);
    }

    @Step("Verify field is auto populated by default")
    public void verifyAutoPopulated(String fieldName) {
        implementation.verifyAutoPopulated(fieldName);
    }

    @Step
    public void navigateToSubTab(String childTab, String parentTab) throws InterruptedException {
        implementation.navigateToTab(childTab, parentTab);
    }

    @Step("Click on Tab")
    public void navigateToTab(String tabName) {
        implementation.navigateToTab(tabName);
    }

    @Step
    public void selectTillDate(By loc, String tillDate) {
        implementation.selectTillDate(loc, tillDate);
    }

    @Step
    public void selectFromDate(By loc, String fromDate) {
        implementation.selectFromDate(loc, fromDate);
    }

    @Step
    public void verifyTooltip(String labelText) {
        implementation.verifyTooltip(labelText);
    }

    @Step
    public void halfDayOptions(String leaveOptions) {
        implementation.halfDayOptions(leaveOptions);
    }

    @Step
    public void selectLeaveType(String leaveType) {
        implementation.selectLeaveType(leaveType);
    }

    @Step
    public void enterText(By loc, String enterReason) {
        implementation.enterText(loc, enterReason);
    }

    @Step
    public void verifyPopup(String popupText) {
        implementation.verifyPopup(popupText);
    }

    @Step
    public void availabilityType(String availabilityType) {
        implementation.availabilityType(availabilityType);
    }

    @Step
    public void verifyTabIsActive(String tabName) {
        implementation.verifyTabIsActive(tabName);
    }

    @Step("Select date for comp off")
    public void selectDateForCompOff() {
        implementation.selectDateForCompOff();
    }

    @Step
    public void verifyMessageFor(String resultInput, String message) {
        implementation.verifyMessageFor(resultInput, message);
    }

    public void verifyDateSelected(String text) {
        implementation.verifyDateSelected(text);
    }

    @Step("Verify Print Page opens")
    public void verifyPageOpens() {
        implementation.verifyPageOpens();
    }

    @Step
    public void verifyFile(String dir, String fileName) {
        implementation.isFileDownload(dir, fileName);
    }

    @Step
    public void verifyResult(String textFiltered, String tabName) {
        implementation.verifyResult(textFiltered, tabName);
    }

    @Step
    public void verifyOutingDate(String date) {
        implementation.verifyOutingDate(date);
    }

    @Step("Click on Button")
    public void clickOnButton(By loc) {
        implementation.clickOn(loc);
    }

    @Step
    public void clickOnLoginButton() {
        implementation.clickOnLoginButton();
    }

    @Step
    public void verifyMandatoryTextBoxField(String fields) {
        implementation.mandatoryTextField(fields);
    }

    @Step
    public void verifyMandatoryDropdown(String field) throws InterruptedException {
        if (field.contains(",")) {
            String[] fields = field.split(",");
            for (int i = 0; i < fields.length; i++) {
                implementation.mandatoryDropdown(fields[i]);
            }
        } else {
            implementation.mandatoryDropdown(field);
        }
    }

    @Step("Click on {0} button")
    public void clickOnBtn(String btnName, By btn) {
        implementation.clickOn(btn);
    }

    @Step
    public void verifyMandatoryCalendar(String fields) {
        if (fields.contains(",")) {
            String[] field = fields.split(",");
            for (int i = 0; i < field.length; i++) {
                implementation.mandatoryCalendar(field[i]);
            }
        } else {
            implementation.mandatoryCalendar(fields);
        }
    }

    @Step
    public void typeIntoTextBox(String text, String fieldName) {
        implementation.typeIntoTextBox(text, fieldName);
    }

    @Step
    public void verifyDateRange(By loc) {
        implementation.verifyElement(loc);
    }

    @Step
    public void verifyExportOptions(By loc) {
        implementation.verifyElement(loc);
    }

    @Step("Verify column gets sorted")
    public void verifyColumnSort(By column) {
        implementation.verifyColumnIsSorted(column);
    }

    @Step("Sort {0} columns and verify sort")
    public void sortAndVerify(String columns) {
        implementation.sortAndVerify(columns);
    }

    @Step("Click on {0} button")
    public void clickOnExpandButton(String btnName, By loc) {
        implementation.clickOn(loc);
    }

    @Step("Verify Details box appears")
    public void verifyDetailBox() {
        implementation.verifyElement(XpathForLeaveManagementTab.detailBox);
    }

    @Step
    public void numberOfEntries(String number, String tab) {
        implementation.numEntries(number, tab);
    }

    @Step
    public void verifyRecords() {
        implementation.verifyRecords();
    }

    public void verifyDataIsPresent() {
        implementation.verifyData();
    }

    @Step("Enter Text")
    public void enterPeriod(String text, String tabName) {
        implementation.enterPeriod(text, tabName);
    }

    @Step
    public void selectDate(String tab) {
        implementation.selectDate(tab);
    }

    @Step
    public void verifyText() {
        implementation.verifyText();
    }

    @Step("Verify tab displays by default")
    public void verifyDefault(String tab) {
        implementation.verifyDefault(tab);
    }

    @Step
    public void selectType(String dropdownVal) {
        implementation.selectType(dropdownVal);
    }

    @Step("Sort columns and verify sorting")
    public void sortCol(String columns) {
        implementation.sortCols(columns);
    }

    @Step
    public void navigateAllPages(String tabName) {
        implementation.navigateToAllPages(tabName);
    }

    @Step
    public void clickOnPreviousPage(String tabName) {
        implementation.clickOnPrevPage(tabName);
    }
}
