package stepDefinitions;

import com.gemini.mis.pages.DashboardProfilePage;
import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.LocatorDashboardProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MISDashboardProfile extends PageObject {

    LoginPage steps;
    DashboardProfilePage mySteps;

    @Then("User clicks on edit button")
    public void userClicksOnEditButton() {
        steps.Wait(2000);
        steps.isElementExist(LocatorDashboardProfilePage.editPencil);
        steps.WaitTillElementIsVisible(LocatorDashboardProfilePage.editPencil);
        steps.Wait(2000);
        steps.click(LocatorDashboardProfilePage.editPencil);
    }
    @Then("User verifies element {string}")
    public void userVerifiesElement(String text) {
        steps.Wait(1000);
        steps.isElementExist(LocatorDashboardProfilePage.myElement(text));

    }

    @Then("User verifies element {string} and element Two {string} and Update Details")
    public void userVerifiesElementAndElementTwoAndUpdateDetails(String ele1, String ele2) {
        WebElementFacade element=$(LocatorDashboardProfilePage.updateBtn);
        if(element.isDisplayed()){
            steps.click(LocatorDashboardProfilePage.updateBtn);
            steps.isElementExist(LocatorDashboardProfilePage.myElement(ele1));
            steps.Wait(1000);
            steps.click(LocatorDashboardProfilePage.okBtn);
        }
        else {
            steps.isElementExist(LocatorDashboardProfilePage.myElement(ele2));

        }
    }

    @And("User clicks on Update details {string} and verifies {string}")
    public void userClicksOnUpdateDetailsAndVerifies(String ele2,String field) {
        WebElementFacade element=$(LocatorDashboardProfilePage.updateBtn);
        if(element.isDisplayed()){
            steps.Wait(1000);
            steps.click(LocatorDashboardProfilePage.updateBtn);
            mySteps.validateHighlightedField(LocatorDashboardProfilePage.myInput(field));
            steps.Wait(1000);
        }
        else {
            steps.Wait(1000);
            steps.isElementExist(LocatorDashboardProfilePage.myElement(ele2));

        }
    }


    @Then("User closes appeared popup")
    public void userClosesAppearedPopup() {
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.okBtn);
    }
    @And("User closes the pop up")
    public void userClosesThePopUp() {
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.closeProfilePopup);

    }

    @Then("User clicks on field {string}")
    public void userClicksOnField(String text) {
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.myElement(text));
    }
    @And("User clicks on Update Btn")
    public void userClicksOnUpdateBtn() {
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.updateAddressBtn);
    }


    @And("User edits value {string} as {string}")
    public void userEditsValueAs(String value, String value1) {
        steps.click(LocatorDashboardProfilePage.myInput(value));
        mySteps.selectElementAndDelete(LocatorDashboardProfilePage.myInput(value));
        steps.enterValues(LocatorDashboardProfilePage.myInput(value),value1);
    }
    @And("User deletes value {string}")
    public void userDeletesValue(String value) {
        steps.click(LocatorDashboardProfilePage.myInput(value));
        mySteps.selectElementAndDelete(LocatorDashboardProfilePage.myInput(value));

    }

    @And("User clicks on Update Password Btn")
    public void userClicksOnUpdatePasswordBtn() {
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.updatePasswordBtn);

    }

    @Then("User verifies SignIn page")
    public void userVerifiesSignInPage() {
        steps.Wait(5000);
        steps.isElementExist(LocatorDashboardProfilePage.myElement("Sign In"));

    }

    @Then("User verifies blank field {string}")
    public void UserVerifiesBlankField(String field) {
        mySteps.validateHighlightedField(LocatorDashboardProfilePage.myInput(field));
        steps.Wait(1000);
    }


    @Given("User clicks on Lunch Btn")
    public void userClicksOnLunchBtn() {
        steps.Wait(1000);
        steps.isElementExist(LocatorDashboardProfilePage.lunchBtn);
        steps.WaitTillElementIsVisible(LocatorDashboardProfilePage.lunchBtn);
        steps.Wait(1000);
        steps.click(LocatorDashboardProfilePage.lunchBtn);
    }
    @Then("User clicks on To Date Calendar Selects Date {string}")
    public void userClicksOnToDateCalendarSelectsMonthAndDate(String value1) {
        steps.click(LocatorDashboardProfilePage.tillDateInCalendar);
        steps.click(LocatorDashboardProfilePage.changeMonthBtn("next"));
        steps.click(LocatorDashboardProfilePage.selectFromDate(value1));
        steps.Wait(500);
    }
    @And("User clicks on FromDate Calendar Selects Date {string}")
    public void userClicksOnFromDateCalendarSelectsDate(String value1) {
        steps.click(LocatorDashboardProfilePage.fromDateInCalendar);
        steps.click(LocatorDashboardProfilePage.changeMonthBtn("next"));
        steps.click(LocatorDashboardProfilePage.selectFromDate(value1));
        steps.Wait(500);
    }

    @Then("User Selects location from dropdown")
    public void userSelectsLocationFromDropdown() {
        steps.click(LocatorDashboardProfilePage.locationDropdown);
        getDriver().findElement(By.xpath("//select[@id='location']/*[text()='Austin, Texas']")).click();
        steps.click(LocatorDashboardProfilePage.locationDropdown);
        steps.Wait(500);
    }

    @Then("User Clicks On Add Btn")
    public void userClicksOnAddBtn() {
        steps.click(LocatorDashboardProfilePage.addBtn);
        steps.Wait(1000);
    }

    @Then("User closes the lunch pop up")
    public void userClosesTheLunchPopUp() {
        steps.click(LocatorDashboardProfilePage.closeBtn);
    }


}






