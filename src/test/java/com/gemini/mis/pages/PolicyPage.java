package com.gemini.mis.pages;

import com.gemini.mis.implementations.PolicyImplementation;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;


public class PolicyPage
{
    PolicyImplementation policy;

    @Step
    public void verifyDateForAllPages() {
        policy.verifyDateForAllPages();
   }

    @Step("Verify number of records displayed")
    public void verifyDefaultRecords()
    {
     policy.verifyDefaultRecords();
    }

    public void selectNumberOfEntry(By loc,String noOfEntry)
    {
        policy.selectNumberOfEntry(loc,noOfEntry);
    }

    @Step("Verify number of records change")
    public void verifyChangeOfRecords()
    {
     policy.verifyChangeOfRecords();
    }

    @Step
    public void enterText(By loc, String text)
    {
        policy.enterText(loc,text);
    }

    @Step
    public void resultPolicy(String text)
    {
     policy.resultPolicy(text);
    }

    @Step
    public void verifyInvalidPolicy(String message)
    {
      policy.verifyInvalidPolicy(message);
    }

    @Step
    public void verifyPolicyPage(String policyName)
    {
        policy.verifyPolicyPage(policyName);
    }

    @Step
    public void clickOnButton(String btnName,By loc)
    {
        policy.clickOnBtn(btnName,loc);
    }
}
