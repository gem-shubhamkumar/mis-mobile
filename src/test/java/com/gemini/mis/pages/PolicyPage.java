package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForApplyTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class PolicyPage extends PageObject
{

    @Step
    public void verifyDateForAllPages() {
        List<WebElementFacade> pages = findAll(XpathforPolicyTab.noOfPages);
        int noOfPages = pages.size();
        while (noOfPages>0) {
            WebElementFacade elementFacade = find(XpathforPolicyTab.pagination("tblActivePolicy_next"));
            if (!elementFacade.getAttribute("class").contains("disabled")) {
                elementFacade.click();
                List<WebElementFacade> list = findAll(XpathforPolicyTab.policyData);
                if (list.size() == 0) {
                    Assert.fail("No data found");
                }
            }
            noOfPages=noOfPages-1;
        }
    }

    @Step("Verify number of records displayed")
    public void verifyDefaultRecords()
    {
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        if(String.valueOf(noOfRecords.size()).equals("10"))
        {
            Assert.assertTrue("Number of records verified successfully",true);
        }
        else
        {
            Assert.fail("Number of records displayed by default are incorrect");
        }
    }

    public void selectNumberOfEntry(String noOfEntry)
    {
        WebElementFacade elementFacade=find(XpathforPolicyTab.lengthPage);
        selectFromDropdown(elementFacade,noOfEntry);
    }

    @Step("Verify number of records change")
    public void verifyChangeOfRecords(String number)
    {
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        int num = noOfRecords.size();
        if(num<=Integer.valueOf(number))
        {
            Assert.assertTrue("Number of records verified successfully",true);
        }
        else
        {
            Assert.fail("Number of records did not change");
        }

    }

    @Step
    public void enterText(By loc, String text)
    {
     if(isElementVisible(loc))
     {
         WebElementFacade elementFacade = find(loc);
         typeInto(elementFacade,text);
     }
    }

    @Step
    public void resultPolicy(String text)
    {
       if(text.equals(textOf(XpathforPolicyTab.noOfRows)))
       {
           Assert.assertTrue("Policy verified successfully",true);
       }
       else
       {
           Assert.fail("Policy not filtered successfully");
       }
    }

    @Step
    public void verifyInvalidPolicy(String message)
    {
       String text = textOf(XpathforPolicyTab.invalidPolicy);
       if(!text.equals(message))
       {
           Assert.fail("Invalid Policy returns result");
       }
    }

    @Step
    public void verifyPolicyPage(String policyName)
    {
        if(isElementVisible(XpathforPolicyTab.policyPage))
        {
            policyName = "Policy: "+policyName;
            if(policyName.equals(textOf(XpathforPolicyTab.pageElement("h4"))))
            {
                Assert.assertTrue("Policy Page opens successfully",true);
            }
            else
            {
                Assert.fail("Policy page does not open");
            }
        }
    }
}
