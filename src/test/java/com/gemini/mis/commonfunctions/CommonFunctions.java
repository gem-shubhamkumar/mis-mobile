package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.ApplyToAnyLocators;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import net.serenitybdd.core.pages.PageObject;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonFunctions extends PageObject {



    public void click(By locator)  {

            $(locator).waitUntilPresent().click();

        }

        public WebElement getElement (By locator) {
            return $(locator);
        }


        public void click(WebElement element)  {

            if(element.isDisplayed()) {
                element.click();
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
            case "skill":
                ApplyToAnyLocators MySkillsLocators;
            {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "ddlSkillTypeEdit"))).isPresent());
                break;
            }

            case "experience" : {
                String xpath = MySkillsLocators.errorType.replace("select", "input");
                xpath = xpath.replace("ids", "expinMonthsEdit");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Submit Feedback" : {
                String xpath = MySkillsLocators.errorType.replace("select", "textarea");
                xpath = xpath.replace("ids", "feedback");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
        }
    }


        public Boolean isPresent(By locator) {
            return $(locator).isPresent();
        }

        public void typeText(By locator, String string) {
            $(locator).type(string);
        }

        public String getText(By locator) {
            return $(locator).getText();
        }

        public List<WebElement> getMultipleElements(By locator) {
            return getDriver().findElements(locator);
        }


        public void pressEnter() {
            withAction().sendKeys(Keys.ENTER).build().perform();
        }

        public void launchUrl(String url) {
            getDriver().get(url);
        }

        public void customWait(long seconds) {

        waitABit(seconds);
        }

        public void switchToActiveElement() {

        getDriver().switchTo().activeElement();
        }

        public void clearField(By id) {
            getElement(id).sendKeys(Keys.BACK_SPACE);

        }
}