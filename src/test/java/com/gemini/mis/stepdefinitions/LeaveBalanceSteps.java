package com.gemini.mis.stepdefinitions;


import com.gemini.mis.pages.AccountPortalPage;
import com.gemini.mis.pages.LeaveBalancePage;
import com.gemini.mis.pages.NavBarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class LeaveBalanceSteps extends PageObject {
    @Steps
    AccountPortalPage accountPage;
    @Steps
    LeaveBalancePage leavePages;
    @Steps
    NavBarPage navPages;


    @Then("^Click on \"(.*?)\" parent tab $")
    public void clickOnParentTab(String parentTab){
        accountPage.navigateToTab(parentTab);
    }

    @Then("^Verify leave history window closes$")
    public void VerifyIsLeaveWindowCloses(){
        leavePages.verifyLeaveHistoryWindowCloses();
    }

    @And("^Verify \"(.*?)\" is visible on the current screen$")
    public void verifyIsElementVisible(String elName){
        leavePages.verifyIsVisibleOnTheCurrentScreen(elName);
    }

    @Then("^Verify number of records ar same as displayed on leave card$")
    public void verifyNumberOfRecordsArSameAsDisplayedOnLeaveCard() {
        leavePages.verifyNumberOfRecordsAreSame();
    }

    @Then("^Click on \"(.*?)\" parent tab$")
    public void clickOnTab(String ParentTabName) {
        waitABit(3000);
        accountPage.navigateToTab(ParentTabName);
    }

    @Then("^Navigate to \"(.*?)\" link$")
    public void navigateToLink(String linkName){
        navPages.clickOnLink(linkName);
    }
}
