package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.implementations.LeaveManagementImplementation;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class LeaveManagementPage extends PageObject
{

    LeaveManagementImplementation implementation;
    CommonFunctions genFunc;
    @Step("Launch MIS Beta site")
    public void launchSite()
    {
        implementation.launchSite();
    }

    @Step
    public void typeIntoElement(String text, String fieldName)
    {
        implementation.type(text,fieldName);
    }

    @Step
    public void clickOnButton(String btnName)
    {
      implementation.clickOn(btnName);
    }

    @Step
    public void verifyPage(String pageName)
    {
      implementation.verifyPage(pageName);
    }

    @Step
    public void clickOnSideNavigationOption(String tabName)
    {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.sideNav(tabName));
        clickOn(elementFacade);
    }


    @Step("Verify dropdown options after clicking on Side Navigation tabs")
    public void sideNavOptions(String options)
    {
     implementation.sideNavOptions(options);
    }

    @Step
    public void verifyTabDisplays(String tabName)
    {
    implementation.verifyTabDisplays(tabName);
     }

    @Step
    public void verifyTab(String tab)
    {
        implementation.verifyTab(tab);
    }

    @Step("Verify field is auto populated by default")
    public void verifyAutoPopulated(String fieldName)
    {
        implementation.verifyAutoPopulated(fieldName);
    }

    @Step
    public void verifyMandatoryFields(String fields)
    {
     implementation.verifyMandatoryFields(fields);
    }


    @Step
    public void clickOnSubTab(String childTab, String parentTab)
    {
        implementation.clickOnSubTab(childTab,parentTab);
    }

    @Step("Click on Tab")
    public void clickOnTab(String tabName)
    {
     implementation.clickOnTab(tabName);
    }

    @Step
    public void selectTillDate(By loc,String tillDate)
    {
    implementation.selectTillDate(loc,tillDate);
    }

    @Step
    public void selectFromDate(By loc,String fromDate)
    {
        implementation.selectFromDate(loc,fromDate);
    }

    @Step
    public void verifyTooltip(String labelText)
    {
        implementation.verifyTooltip(labelText);
    }

    @Step
    public void halfDayOptions(String leaveOptions)
    {
    implementation.halfDayOptions(leaveOptions);
    }

    @Step
    public void selectLeaveType(String leaveType)
    {
     implementation.selectLeaveType(leaveType);
    }

    @Step
    public void enterText(By loc, String enterReason)
    {
        implementation.enterText(loc,enterReason);
    }

    @Step
    public void verifyPopup(String popupText)
    {
        implementation.verifyPopup(popupText);
    }

    @Step
    public void availabilityType(String availabilityType)
    {
        implementation.availabilityType(availabilityType);
    }



    @Step
    public void verifyTabIsActive(String tabName) {
        implementation.verifyTabIsActive(tabName);
    }

    @Step("Select Date from Dropdown")
    public void selectDateFromDropdown(Date date, By loc)
    {
        implementation.selectDateFromDropdown(date,loc);
    }


    @Step("Select date for comp off")
    public void selectDateForCompOff()
    {
        implementation.selectDateForCompOff();
    }

    @Step
    public void verifyElement(String element)
    {
        implementation.verifyElement(element);
    }

    @Step
    public void verifyMessageFor(String resultInput, String message)
    {
        implementation.verifyMessageFor(resultInput,message);
    }

    public void verifyDateSelected(String text)
    {
     implementation.verifyDateSelected(text);
    }

    @Step("Verify Print Page opens")
    public void verifyPageOpens()
    {
        implementation.verifyPageOpens();
    }

    @Step
    public void verifyLeavePeriod(String searchText)
    {
        implementation.verifyLeavePeriod(searchText);
    }

    @Step
    public void verifyColumnIsSorted(String column) {
       implementation.verifyColumnIsSorted(column);
    }

    @Step
    public void verifyFile(String fileType, String tab)
    {
        verifyFile(fileType,tab);
    }

    @Step
    public void typeText(String text, String tabName)
    {
        implementation.typeText(text,tabName);
    }

    @Step
    public void verifyResult(String textFiltered, String tabName)
    {
        implementation.verifyResult(textFiltered,tabName);
    }

    @Step
    public void verifyDetailsForDate(String text)
    {
        implementation.verifyDetailsForDate(text);
    }

    @Step
    public void verifyOutingDate(String date)  {
      implementation.verifyOutingDate(date);
    }
}
