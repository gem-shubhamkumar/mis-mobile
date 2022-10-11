package com.gemini.mis.pages;

import com.gemini.mis.implementations.PolicyImplementation;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class PolicyPage extends PageObject
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
        WebElementFacade elementFacade=find(loc);
        selectFromDropdown(elementFacade,noOfEntry);
    }

    @Step("Verify number of records change")
    public void verifyChangeOfRecords(String number)
    {
     policy.verifyChangeOfRecords(number);
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
}
