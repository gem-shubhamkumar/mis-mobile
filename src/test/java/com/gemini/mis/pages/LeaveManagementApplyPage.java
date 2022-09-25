package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForApplyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

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
        waitABit(30000);
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

    @Step
    public void selectTillDate(String tillDate)
    {
        genFunc.selectDate(XpathForApplyTab.calendarBtn("leaveTillDate"),tillDate);
    }

    @Step
    public void selectFromDate(String fromDate)
    {
        genFunc.selectDate(XpathForApplyTab.calendarBtn("leaveFromDate"),fromDate);
    }

    @Step
    public void verifyTooltip(String labelText)
    {
        if(isElementVisible(XpathForApplyTab.labelText(labelText)))
        {
            WebElementFacade elementFacade = find(XpathForApplyTab.tooltip);
            genFunc.clickOn(XpathForApplyTab.tooltip);
            if(elementFacade.getAttribute("aria-describedby").contains("popover"))
            {
                String tooltipText = elementFacade.getText();
                if(tooltipText.equals("For ML total days will be considered as total working days"))
                {
                    Assert.assertTrue("Tootlip verified",true);
                }
                else
                {
                    Assert.assertFalse("Unable to verify tooltip",false);
                }
            }
            else
            {
                Assert.assertFalse("Unable to verify tooltip",false);
            }
        }
    }

    @Step
    public void halfDayOptions(String leaveOptions)
    {
        String[] halfDayOption = leaveOptions.split(",");
        String firstHalf = textOf(XpathForApplyTab.halfDayOptions("isFirstHalfLeave"));
        String secondHalf =textOf(XpathForApplyTab.halfDayOptions("isSecondHalfLeave"));

        if(firstHalf.equals(halfDayOption[0]) && secondHalf.equals(halfDayOption[1]))
        {
            Assert.assertTrue("Half day options verified",true);
        }
        else
        {
            Assert.assertFalse("Unable to verify half day options",false);
        }
    }

    @Step
    public void selectLeaveType(String leaveType)
    {
        leaveType = "1 "+leaveType;
        WebElementFacade elementFacade = find(XpathForApplyTab.dropdown("leaveType"));
        genFunc.selectFromDropdown(elementFacade,leaveType);
    }

    @Step
    public void enterReason(String enterReason)
    {
        if(genFunc.isElementFoundInGivenTime(XpathForApplyTab.textArea("leaveReason")))
        {
            WebElementFacade elementFacade= find(XpathForApplyTab.textArea("leaveReason"));
            typeInto(elementFacade,enterReason);
        }
        else
        {
            Assert.assertFalse("Unable to type",false);
        }
    }

    @Step
    public void verifyPopup(String popupText)
    {
        if(genFunc.isElementFoundInGivenTime(XpathForApplyTab.successAlertPopup("p")))
        {
            String popUpText = textOf(XpathForApplyTab.successAlertPopup("p"));
            if(popUpText.equals(popupText))
            {
                Assert.assertTrue("Popup verified",true);
                clickOnButton("OK");
            }
            else
            {
                Assert.assertFalse("Unable to verify popUp",false);
            }
        }
    }

    @Step
    public void availabilityType(String availabilityType)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        if(availabilityType.equals("Mobile"))
        {
            clickOnButton("Mobile");
        }
        else
        {
            clickOnButton("Email");
        }
    }


}
