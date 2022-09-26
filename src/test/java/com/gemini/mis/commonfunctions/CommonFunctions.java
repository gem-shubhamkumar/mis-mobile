package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.CommonXpath;
import com.gemini.mis.selectors.XpathForApplyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CommonFunctions extends PageObject {

    public void launchSite() {
        getDriver().get("https://mymis.geminisolutions.com/");
        if (getDriver().getTitle().equals("Gemini MIS")) {
            Assert.assertTrue("Successfully launched application", true);
        } else {
            Assert.assertFalse("Unable to launch application", false);
        }
    }

    public void typeIntoElement(String text, String fieldName) {
        WebElementFacade elementFacade = null;
        switch (fieldName) {
            case "username":
                elementFacade = find(XpathForApplyTab.textBox("username"));
                break;
            case "Reason":
                elementFacade = find(XpathForApplyTab.textArea("outingReason"));
                break;
            case "Primary contact number":
                elementFacade =find(XpathForApplyTab.textBox("outingContactNumber"));
                break;
            case "password":
                elementFacade = find(XpathForApplyTab.textBox("password"));
                break;
        }
        if (elementFacade.isEnabled()) {
            typeInto(elementFacade, text);
            Assert.assertTrue("Text entered successfully", true);
        } else {
            Assert.assertEquals("Unable to enter text", false);
        }
    }

    public void clickOnBtn(String btnName) {
        boolean elementPresent = false;
        By tab = null;
        switch (btnName) {
            case "Sign in":
                tab = XpathForApplyTab.textBox("btnLogin");
                break;
            case "Submit Comp off":
                tab = XpathForApplyTab.submitBtn("3");
                break;
            case "Submit LWP":
                tab = XpathForApplyTab.submitBtn("4");
                break;
            case "Submit Out of Duty/Tour":
                tab = XpathForApplyTab.submitBtn("5");
                break;
            case "Submit Leave":
                tab = XpathForApplyTab.submitBtn("1");
                break;
            case "Submit WFH":
                tab = XpathForApplyTab.submitBtn("2");
                break;
            case "Total working days":
                tab = XpathForApplyTab.tooltip;
                break;
            case "Leave for half day":
                tab = XpathForApplyTab.textBox("isLeaveHalfDay");
                break;
            case "OK":
                tab = XpathForApplyTab.btnType("OK");
                break;
            case "Mobile":
                tab = XpathForApplyTab.textBox("avilableOnMobile");
                break;
            case "Email":
                tab = XpathForApplyTab.textBox("avilableOnEmail");
                break;
            default:
                elementPresent = false;
        }
        if (isElementFoundInGivenTime(tab)) {
            Assert.assertTrue("Verified button: " + tab + "is present on screen", isElementFoundInGivenTime(tab));
            WebElementFacade elementFacade = find(tab);
            elementFacade.click();
        } else {
            Assert.assertFalse("Unable to find button", !isElementFoundInGivenTime(tab));
        }
    }

    public boolean isElementFoundInGivenTime(By webelement) {
        boolean exists = false;
        try {
            isElementVisible(webelement);
            exists = true;
            //   find(webelement);
        } catch (NoSuchElementException e) {
            // nothing to do.
        }
        return exists;
    }

    public void clickOn(By elementName) {
        WebElementFacade element = find(elementName);
        if (element.isDisplayed()) {
            element.click();
            Assert.assertTrue("Clicked on button successfully", true);
        } else {
            Assert.assertFalse("Unable to click on button", false);
        }
    }

    public void verifyTab(String tabName) {
        waitABit(5000);
        String expectedHeading = "";
        switch (tabName) {
            case "Apply":
                expectedHeading = "Apply Leave/ WFH / Comp Off / Out Duty / Change Request";
                break;
        }
        WebElementFacade elementFacade = find(XpathForApplyTab.heading);
        if (elementFacade.getText().equals(expectedHeading)) {
            Assert.assertTrue("Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify tab", false);
        }
    }

    public void verifyDefaultTab(String tab) {
        List<WebElementFacade> elementFacadeList = findAll(XpathForApplyTab.tab);
        if (elementFacadeList.get(0).getAttribute("class").contains("active") &&
                elementFacadeList.get(0).getText().equals(tab)) {
            Assert.assertTrue("Default Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify default tab", false);
        }
    }


    public void verifyMandatoryFields(String fields) {
        WebElementFacade elementFacade = null;
        switch (fields) {
            case "Outing From":
                elementFacade = find(XpathForApplyTab.inputItem("Outing From"));
                break;
            case "LWP Change Request From":
                elementFacade = find(XpathForApplyTab.dropdown("fromDt"));
                break;
            case "Type of Leave":
                elementFacade = find(XpathForApplyTab.dropdown("legitimateType"));
                break;
            case "Reason for Request":
                elementFacade = find(XpathForApplyTab.textArea("legitimateReason"));
                break;
            case "Outing Till":
                elementFacade = find(XpathForApplyTab.inputItem("Outing Till"));
                break;
            case "Type":
                elementFacade = find(XpathForApplyTab.dropdown("outingType"));
                break;
            case "Primary Contact number":
                elementFacade = find(XpathForApplyTab.textBox("outingContactNumber"));
                break;
            case "Reason for outing":
                elementFacade = find(XpathForApplyTab.textArea("outingReason"));
                break;
            case "From":
                elementFacade = find(XpathForApplyTab.inputItem("Leave From"));
                break;
            case "Till":
                elementFacade = find(XpathForApplyTab.inputItem("Leave Till"));
                break;
            case "Reason":
                elementFacade = find(XpathForApplyTab.textArea("leaveReason"));
                break;
            case "WFH Reason":
                elementFacade = find(XpathForApplyTab.textArea("WFHReason"));
                break;
            case "Comp Off Reason":
                elementFacade = find(XpathForApplyTab.textArea("CompOffReason"));
                break;
            case "Date":
                elementFacade = find(XpathForApplyTab.dropdown("WorkFromHomeDate"));
                break;
        }
        if (elementFacade.getAttribute("class").contains("error-validation")) {
            Assert.assertTrue("Field is mandatory", true);
        } else {
            Assert.fail("Fields is not mandatory");
        }
    }

    public boolean isAbleToSubmit()
    {
        boolean isAbleToSubmit = false;
        String popupText ="";
        WebElementFacade elementFacade = find(XpathForApplyTab.successAlertPopup("h2"));
        if(elementFacade.isEnabled())
        {
            popupText = textOf(XpathForApplyTab.successAlertPopup("p"));
            if(popupText.equals("Leave Applied successfully"))
            {
               isAbleToSubmit = true;
            }
        }
        return isAbleToSubmit;
    }
    public void navigateToTab(String parentTabName, String childTabName)

    {
        // verification for Parent tab
        if (isElementFoundInGivenTime(CommonXpath.sideNav(parentTabName)))
        {
            waitABit(1000);
            //clicks on parent tab
            clickOn(CommonXpath.sideNav(parentTabName));
            waitABit(2000);
            //verifies sub tab available
            if (isElementFoundInGivenTime(CommonXpath.sideNav(childTabName))) {
                clickOn(CommonXpath.sideNav(childTabName));}

            else{
                Assert.assertFalse("Unable to locate child tab",false);}

        }

        else {
            Assert.assertFalse("Unable to locate parent tab",false);}
    }


    public void navigateToTab(String parentTabName){
        // verification for Parent tab
        if (isElementFoundInGivenTime(CommonXpath.sideNav(parentTabName)))
        {
            waitABit(1000);
            //clicks on parent tab
            clickOn(CommonXpath.sideNav(parentTabName));

        }
        else {
            Assert.assertFalse("Unable to locate parent tab",false);}
    }


    public void selectDate(By loc, String dateValue) {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            String date = dateValue.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (elementFacade.getText().equals(date)) {
                    if (elementFacade.getAttribute("class").contains("disabled"))
                    {
                        continue;
                    } else {
                        elementFacade.click();
                        break;
                    }
                }
            }
        }
        else
        {
            Assert.assertFalse("Unable to click on calendar",false);
        }
    }
}
