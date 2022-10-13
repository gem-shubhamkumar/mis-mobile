package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.PolicyPage;
import com.gemini.mis.selectors.XpathforPolicyTab;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class PolicySteps
{

    @Steps
    PolicyPage PolicyPage;

    @Then("Verify Data is present on all pages")
    public void verifyData()
    {
        PolicyPage.verifyDateForAllPages();
    }

    @And("Verify number of records displayed by default")
    public void verifyNumberOfRecordsDisplayedByDefault()
    {
        PolicyPage.verifyDefaultRecords();
    }

    @Then("Select {string} as number of entries")
    public void selectAsNumberOfEntries(String noOfEntry)
    {
        PolicyPage.selectNumberOfEntry(XpathforPolicyTab.lengthPage("tblActivePolicy_length"),noOfEntry);
    }

    @And("Verify number of records displayed changes")
    public void verifyNumberOfRecordsDisplayedChanges()
    {
        PolicyPage.verifyChangeOfRecords();
    }

    @When("User Enters {string} policy in search box")
    public void userEntersPolicyInSearchBox(String policyName)
    {
        PolicyPage.enterText(XpathforPolicyTab.textBox("search"),policyName);
    }

    @Then("Verify {string} policy is filtered")
    public void verifyPolicyIsFilteredSuccessfully(String policyName)
    {
        PolicyPage.resultPolicy(policyName);
    }

    @Then("Verify {string} displays for Invalid Policy")
    public void verifyDisplaysForInvalidPolicy(String policyName)
    {
        PolicyPage.verifyInvalidPolicy(policyName);
    }

    @Then("Verify {string} page opens")
    public void verifyPageOpens(String policyName)
    {
        PolicyPage.verifyPolicyPage(policyName);
    }

    @Then("Click on {string} button on Policy Page")
    public void clickOnButtonOnPolicyPage(String btnName)
    {
        PolicyPage.clickOnButton(btnName,XpathforPolicyTab.viewBtn);
    }

    @And("Click on {string} button of Policy page")
    public void clickOnButtonOfPolicyPage(String btnName)
    {
        PolicyPage.clickOnButton(btnName,XpathforPolicyTab.pageElement("button"));
    }
}
