package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.CommonXpath;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class CommonFunctions extends PageObject {

    public void launchSite(String url , String expectedTitle, String passDes , String failDes) {
        getDriver().get(url);
        if (getDriver().getTitle().equals(expectedTitle)) {
            Assert.assertTrue(passDes, true);
        } else {
            Assert.fail(failDes);
        }
    }
    public boolean isElementFoundInGivenTime(By webelement) {
        boolean exists = false;
        try {
            isElementVisible(webelement);
            exists = true;
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

    public void verifyDefaultTab(String tab) {
        List<WebElementFacade> elementFacadeList = findAll(XpathForLeaveManagementTab.tab);
        if (elementFacadeList.get(0).getAttribute("class").contains("active") &&
                elementFacadeList.get(0).getText().equals(tab)) {
            Assert.assertTrue("Default Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify default tab", false);
        }
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
                if (childTabName.equals("View Request Status") && parentTabName.equals("LNSA")) {
                    String xpath = "(" + CommonXpath.sideNav(childTabName);
                    xpath = xpath + ")[2]";
                    WebElementFacade elementFacade = find(By.xpath(xpath));
                    elementFacade.click();
                } else {
                    clickOn(CommonXpath.sideNav(childTabName));
                }
            }
            else{
                Assert.assertFalse("Unable to locate child tab",false);
            }
        }
        else {
            Assert.assertFalse("Unable to locate parent tab",false);
        }
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
    public void focusElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].focus();", element);
    }


}
