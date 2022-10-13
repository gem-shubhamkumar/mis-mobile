package com.gemini.mis.implementations;

import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

public class PolicyImplementation extends PageObject
{
    Logger log = LoggerFactory.getLogger("SampleLogger");

    //This function is to verify date for all pages
    public void verifyDateForAllPages() {
        List<WebElementFacade> pages = findAll(XpathforPolicyTab.noOfPages);
        int noOfPages = pages.size();
        while (noOfPages>0) {
            WebElementFacade elementFacade = find(XpathforPolicyTab.pagination("tblActivePolicy_next"));
            if (!elementFacade.getAttribute("class").contains("disabled")) {
                elementFacade.click();
                List<WebElementFacade> list = findAll(XpathforPolicyTab.policyData);
                if (list.size() == 0) {
                    Assert.fail("No data.json found");
                    log.info("No data.json found");
                }
            }
            noOfPages=noOfPages-1;
        }
    }

    //This function is used to verify number of records
    public void verifyDefaultRecords()
    {
        waitABit(5000);
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        if(noOfRecords.size()>=10)
        {
            Assert.assertTrue("Number of records verified successfully",true);
        }
        else
        {
            Assert.fail("Number of records displayed by default are incorrect");
            log.info("Number of records displayed by default are incorrect");
        }
    }

    //This function is used to verify change in number of records on selecting different value
    public void verifyChangeOfRecords()
    {
        waitABit(5000);
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        int num = noOfRecords.size();
        if(num>=10)
        {
            Assert.assertTrue("Number of records verified successfully",true);
        }
        else
        {
            Assert.fail("Number of records did not change");
            log.info("Number of records did not change");
        }
    }

    //This function is used to enter text
    public void enterText(By loc, String text)
    {
        if(isElementVisible(loc))
        {
            WebElementFacade elementFacade = find(loc);
            typeInto(elementFacade,text);
        }
        else
        {
            Assert.fail("Unable to type");
            log.info("Unable to type");
        }
    }

    //This function is used to verify result policy
    public void resultPolicy(String text)
    {
        if(text.equals(textOf(XpathforPolicyTab.noOfRows)))
        {
            Assert.assertTrue("Policy verified successfully",true);
        }
        else
        {
            Assert.fail("Policy not filtered successfully");
            log.info("Policy filtered successfully");
        }
    }

    public void verifyInvalidPolicy(String message)
    {
        String text = textOf(XpathforPolicyTab.invalidPolicy);
        if(!text.equals(message))
        {
            Assert.fail("Invalid Policy returns result");
            log.info("Invalid Policy returns result");
        }
    }

    //This function verifies heading
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
                log.info("Policy page does not open");
            }
        }
    }

    public void clickOnBtn(String btnName,By loc)
    {
        WebElementFacade elementFacade = find(loc);
        if(elementFacade.isDisplayed())
        {
            elementFacade.click();
        }
        else
        {
            Assert.fail("Unable to Click");
            log.info("Unable to Click");
        }
    }

    public void selectNumberOfEntry(By loc, String noOfEntry)
    {
        WebElementFacade elementFacade=find(loc);
        selectFromDropdown(elementFacade,noOfEntry);
    }
}
