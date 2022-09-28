package com.gemini.mis.commonfunctions;

import com.gemini.mis.pages.FeedbackPage;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.LNSASelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFunctions extends PageObject {

    FeedbackPage feedbackPage;

    @Step
    public void navigateToTab(String childTabName, String parentTabName) {

        if ($(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).isPresent()) {
            waitABit(1000);
            $(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).click();
            waitABit(2000);

            if ($(By.xpath(CommonSelectors.sideNav.replace("tabName", childTabName))).isPresent()) {
                if(childTabName.equals("View Request Status") && parentTabName.equals("LNSA")) {
                    String xpath = "(" + CommonSelectors.sideNav;
                    xpath = xpath + ")[2]";
                    $(By.xpath(xpath.replace("tabName", childTabName))).click();

                }
                else
                $(By.xpath(CommonSelectors.sideNav.replace("tabName", childTabName))).click();
            }

            else{
                Assert.fail("Unable to locate child tab");
            }

        }

        else {
            Assert.fail("Unable to locate parent tab");
        }
    }

    public void navigateToTab(String parentTabName){
        if ($(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).isPresent()) {
             waitABit(1000);
            $(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).click();

    } else {
             Assert.assertFalse("Unable to locate parent tab",false);
         }
    }


    @Step
    public void clickButton(String buttonName) {
        waitABit(1000);
        switch(buttonName) {
            case "Sign In": {
                $(By.xpath(CommonSelectors.homePageXpath.replace("name", "btnLogin"))).waitUntilPresent().click();
                break;
            }

            case "update" : {
                $(By.xpath(MySkillsLocators.genericButton.replace("ids", "btnUpdateSkills"))).waitUntilPresent().click();
                break;
            }

            case "Provide Feedback": {
                $(By.xpath(FeedbackSelectors.provideFeedbackButton)).waitUntilPresent().click();
                break;
            }
            case "Submit": {
                $(By.xpath(FeedbackSelectors.submitButton)).waitUntilPresent().click();
                break;
            }

            case "next" :
            case "Previous" : {
                while(!$(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).getAttribute("class").contains("disabled")) {
                    $(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).waitUntilPresent().click();
                }
                break;
            }

            case "View" : {
                $(By.xpath(FeedbackSelectors.viewButton.replace("size", Integer.toString(feedbackPage.totalRow())))).waitUntilPresent().click();
                break;
            }

            case "Copy" :
            case "Print" :
            case "PDF" :
            case "Excel" :
            case "Export" : {
                $(By.xpath(FeedbackSelectors.export.replace("name", buttonName))).waitUntilPresent().click();
                break;
            }

            case "previous date" : {
                $(By.id("btnPreviousMonth")).waitUntilPresent().click();
                break;
            }

            case "next date" : {
                $(By.id("btnNextMonth")).waitUntilPresent().click();
                break;
            }

            case "Close" : {
                $(By.xpath(LNSASelectors.closeModal)).waitUntilPresent().click();
                break;
            }
            case "Submit Reason": {
                $(By.xpath(FeedbackSelectors.submitButton.replace("2", "3"))).waitUntilPresent().click();
                break;
            }
            case "status": {
                $(By.xpath(LNSASelectors.statusButton)).waitUntilPresent().click();
                break;
            }

            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }
    @Step
    public void clickButton(String buttonName, String cardName) {
        waitABit(1000);
        switch(buttonName) {
            case "Maximize": {
                $(By.xpath(CommonSelectors.cardToggleMaximize.replace("card", cardName))).waitUntilPresent().click();
                break;

            }
            case "Minimize" : {
                String xpath = CommonSelectors.cardToggleMinimize.replace("card", cardName);
                xpath = xpath.replace("buttonName", buttonName);
                $(By.xpath(xpath)).waitUntilPresent().click();
                break;
            }


            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }

    @Step
    public void verifyCardMinimized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.collapsedCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not minimized");

    }
    @Step
    public void verifyCardMaximized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.fullScreenCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not maximized");

    }

    @Step
    public void verifyForError(String inputType) {
        switch (inputType) {
            case "skill": {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "ddlSkillTypeEdit"))).isPresent());
                break;
            }

            case "experience" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "expinMonthsEdit");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Submit Feedback" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "feedback");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Reason" : {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "txtLnsaReason"))).isPresent());
                break;
            }
            default: {
                Assert.fail("Input " + inputType + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute, String tab) {
        switch (tab) {
            case "Feedback" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblFeedback_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            case "LNSA" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblLnsaStatusGrid_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            default: {
                Assert.fail("Tab " + tab + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute) {
        String xpath = CommonSelectors.select.replace("attribute", attribute);
        xpath = xpath.replace("value", id);

        selectFromDropdown($(By.xpath(xpath)).getElement(), value);
    }

    @Step
    public void verifyRows(int number) {
        int tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback"))).size();
        Assert.assertTrue(number == tableRow || tableRow < number);
    }
}


