package com.gemini.mis.stepdefinitions;


import com.gemini.mis.pages.DashboardProfilePage;
import com.gemini.mis.pages.FormsPage;
import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.XpathForDashboardProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MISDashboardProfile extends PageObject {

    @Steps
    LoginPage steps;
    @Steps
    DashboardProfilePage mySteps;
    @Steps
    FormsPage forms;

    @Then("User clicks on edit button")
    public void userClicksOnEditButton() {
        steps.customWait(2000);
        steps.isElementExist(XpathForDashboardProfilePage.editPencil);
        steps.waitTillElementIsVisible(XpathForDashboardProfilePage.editPencil);
        steps.customWait(2000);
        steps.click(XpathForDashboardProfilePage.editPencil);
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String text) {
        steps.customWait(3000);
       // getDriver().switchTo().alert().getText().equals(text);
       steps.isElementExist(XpathForDashboardProfilePage.myElement(text));

    }

    @Then("User verifies element {string} and element Two {string} and Update Details")
    public void userVerifiesElementAndElementTwoAndUpdateDetails(String ele1, String ele2) {
        WebElementFacade element=$(XpathForDashboardProfilePage.updateBtn);
        if(element.isDisplayed()){
            steps.click(XpathForDashboardProfilePage.updateBtn);
            steps.isElementExist(XpathForDashboardProfilePage.myElement(ele1));
            steps.customWait(1000);
            steps.click(XpathForDashboardProfilePage.okBtn);
        }
        else {
            steps.isElementExist(XpathForDashboardProfilePage.myElement(ele2));

        }
    }

    @And("User clicks on Update details {string} and verifies {string}")
    public void userClicksOnUpdateDetailsAndVerifies(String ele2,String field) {
        WebElementFacade element=$(XpathForDashboardProfilePage.updateBtn);
        if(element.isDisplayed()){
            steps.customWait(1000);
            steps.click(XpathForDashboardProfilePage.updateBtn);
            mySteps.validateHighlightedField(XpathForDashboardProfilePage.myInput(field));
            steps.customWait(1000);
        }
        else {
            steps.customWait(1000);
            steps.isElementExist(XpathForDashboardProfilePage.myElement(ele2));

        }
    }


    @Then("User closes appeared popup")
    public void userClosesAppearedPopup() {
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.okBtn);
    }
    @And("User closes the pop up")
    public void userClosesThePopUp() {
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.closeProfilePopup);

    }

    @Then("User clicks on field {string}")
    public void userClicksOnField(String text) {
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.myElement(text));
    }
    @And("User clicks on Update Btn")
    public void userClicksOnUpdateBtn() {
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.updateAddressBtn);
    }


    @And("User edits value {string} as {string}")
    public void userEditsValueAs(String value, String value1) {
        steps.click(XpathForDashboardProfilePage.myInput(value));
        mySteps.selectElementAndDelete(XpathForDashboardProfilePage.myInput(value));
        steps.enterValues(XpathForDashboardProfilePage.myInput(value),value1);
    }
    @And("User deletes value {string}")
    public void userDeletesValue(String value) {
        steps.click(XpathForDashboardProfilePage.myInput(value));
        mySteps.selectElementAndDelete(XpathForDashboardProfilePage.myInput(value));

    }

    @And("User clicks on Update Password Btn")
    public void userClicksOnUpdatePasswordBtn() {
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.updatePasswordBtn);

    }

    @Then("User verifies SignIn page")
    public void userVerifiesSignInPage() {
        steps.customWait(5000);
        steps.isElementExist(XpathForDashboardProfilePage.myElement("Sign In"));

    }

    @Then("User verifies blank field {string}")
    public void UserVerifiesBlankField(String field) {
        mySteps.validateHighlightedField(XpathForDashboardProfilePage.myInput(field));
        steps.customWait(1000);
    }


    @Given("User clicks on Lunch Btn")
    public void userClicksOnLunchBtn() {
        steps.customWait(1000);
        steps.isElementExist(XpathForDashboardProfilePage.lunchBtn);
        steps.waitTillElementIsVisible(XpathForDashboardProfilePage.lunchBtn);
        steps.customWait(1000);
        steps.click(XpathForDashboardProfilePage.lunchBtn);
    }
    @Then("User clicks on To Date Calendar Selects Date {string}")
    public void userClicksOnToDateCalendarSelectsMonthAndDate(String value1) {
        steps.click(XpathForDashboardProfilePage.tillDateInCalendar);
        steps.click(XpathForDashboardProfilePage.changeMonthBtn("next"));
        steps.click(XpathForDashboardProfilePage.selectFromDate(value1));
        steps.customWait(500);
    }
    @And("User clicks on FromDate Calendar Selects Date {string}")
    public void userClicksOnFromDateCalendarSelectsDate(String value1) {
        steps.click(XpathForDashboardProfilePage.fromDateInCalendar);
        steps.click(XpathForDashboardProfilePage.changeMonthBtn("next"));
        steps.click(XpathForDashboardProfilePage.selectFromDate(value1));
        steps.customWait(500);
    }

    @Then("User Selects location from dropdown {string}")
    public void userSelectsLocationFromDropdown(String Loc) {
        steps.click(XpathForDashboardProfilePage.locationDropdown);
        steps.click(XpathForDashboardProfilePage.location(Loc));
        steps.click(XpathForDashboardProfilePage.locationDropdown);
        steps.customWait(500);
    }

    @Then("User Clicks On Add Btn")
    public void userClicksOnAddBtn() {
        steps.click(XpathForDashboardProfilePage.addBtn);
        steps.customWait(1000);
    }

    @Then("User closes the lunch pop up")
    public void userClosesTheLunchPopUp() {
        steps.click(XpathForDashboardProfilePage.closeBtn);
    }


    @And("Verify file is downloaded {string}")
    public void verifyFileIsDownloaded(String fileName) {
    String path="C:\\Users\\" +System.getenv("Username")+ "\\Downloads";
       forms.isFileDownloaded(path,fileName);
    }

    @Then("User clicks on download card button")
    public void userClicksOnDownloadCardButton() {
        waitABit(6000);
        $(By.id("btnConvert")).waitUntilPresent().click();

    }

    @When("User card is present in dashboard")
    public void userCardIsPresentInDashboard() {
     steps.customWait(1000);
     Assert.assertTrue($(By.xpath(XpathForDashboardProfilePage.userCard)).isPresent());
    }

    @And("Delete already applied dates")
    public void deleteAlreadyAppliedDates(){
        steps.deleteDatesInLunch();
    }
}






