package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForApplyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.List;

public class LeaveManagementApplyPage extends PageObject
{
    CommonFunctions genFunc;

    @Step("Launch MIS Beta site")
    public void launchSite()
    {
        genFunc.launchSite();
    }

    @Step
    public void typeIntoElement(String text, String fieldName)
    {
     genFunc.typeIntoElement(text,fieldName);
    }

    @Step
    public void clickOnButton(String btnName)
    {
        genFunc.clickOnBtn(btnName);
    }

    @Step
    public void verifyPage(String pageName)
    {
        waitABit(10000);
        String url="";
        if(pageName.equals("Dashboard Page"))
        {
            url = "https://mymis.geminisolutions.com/Dashboard/Index";
        }
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Step
    public void clickOnSideNavigationOption(String tabName)
    {
        genFunc.clickOn(XpathForApplyTab.sideNav(tabName));
    }


    @Step("Verify dropdown options after clicking on Side Navigation tabs")
    public void sideNavOptions(String options)
    {
        boolean isPresent = false;
        String option[] = options.split(",");
        for(int i=0;i<option.length;i++)
        {
            WebElementFacade elementFacade = find(XpathForApplyTab.dropdownOptions(String.valueOf(i+1)));
            if(!elementFacade.getText().equals(option[i]))
            {
                isPresent = false;
                break;
            }
            else
            {
                isPresent = true;
            }
        }
        if(isPresent)
        {
            Assert.assertTrue("Dropdown options present",true);
        }
        else
        {
            Assert.assertFalse("Dropdown options not present",false);
        }

    }

    @Step
    public void verifyTab(String tabName)
    {
        genFunc.verifyTab(tabName);
    }

    @Step
    public void verifyDefaultTab(String tab)
    {
        genFunc.verifyDefaultTab(tab);
    }

    @Step("Verify field is auto populated by default")
    public void verifyAutoPopulated(String fieldName)
    {
        genFunc.autoPopulate(fieldName);
    }

    @Step
    public void verifyMandatoryFields(String fields)
    {
        genFunc.verifyMandatoryFields(fields);

    }

    @Step
    public void selectDate(String date, String calendarName) {
    }

    @Step
    public void clickOnSubTab(String childTab, String parentTab)
    {
        genFunc.navigateToTab(parentTab,childTab);
    }

    @Step("Click on Tab")
    public void clickOnTab(String tabName)
    {
        genFunc.navigateToTab(tabName);
    }
}
