package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MySkillsImplementation extends PageObject {

    FeedbackImplementation feedbackImplementation;
    CommonFunctions genFunc;

    private final static Logger log = LoggerFactory.getLogger(LNSAImplementation.class.getName());

    public void verifyIfCardIsPresent(String cardName) {
        int flag = 0;

//        waitABit(1000);
        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(MySkillsLocators.cardNames));

        List<WebElement> cards = getDriver().findElements(MySkillsLocators.cardNames);

        for (WebElement card : cards
        ) {
            if (card.getText().equals(cardName)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            Assert.fail("Card " + cardName + " is not present");
            log.info("Card " + cardName + " is not present");


        } else
            Assert.assertTrue(true);
    }

    public void verifyCardNotEmpty() {
        boolean present = $(MySkillsLocators.tableDiv).isPresent();
        if (!present) Assert.assertTrue(true);
        else {
            Assert.fail("Card is empty");
            log.info("Card is empty");
        }

    }


    public void clickASkill(String skill) {
        feedbackImplementation.clickOn(MySkillsLocators.skillName(skill));

    }


    public void enterValue(String value) {
        $(By.id("expinMonthsEdit")).sendKeys(Keys.CONTROL + "A");

        $(By.id("expinMonthsEdit")).sendKeys(Keys.BACK_SPACE);
        typeInto($(By.id("expinMonthsEdit")), value);
    }


    public void verifyData(String skill, String type, String experience) {
        // added by shubham.kumar
        if (!genFunc.getDriverType().equalsIgnoreCase("Appium")) {
            withAction().sendKeys(Keys.ENTER).build().perform();
        }
        int flag = 0;
        List<WebElement> tableRow = getDriver().findElements(MySkillsLocators.tableRow("tblSkillSet"));
        for (WebElement row : tableRow) {
            if (StringUtils.contains(row.getText(), skill) && StringUtils.contains(row.getText(), type) && StringUtils.contains(row.getText(), experience)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) Assert.assertTrue("Record updated Successfully", true);
        else {
            Assert.fail("Record was not updated Successfully");
            log.info("Record was not updated Successfully");
        }
    }


    public void verifySuccessMessage(String message) {
        waitABit(2000);
        getDriver().switchTo().activeElement();
        String actualMessage = find(By.tagName("h2")).getText();
        boolean equal = StringUtils.equals(message, actualMessage);
        if (equal) {
            Assert.assertTrue(true);
            feedbackImplementation.clickOn(MySkillsLocators.okButton);
        } else {
            Assert.fail("Expected Message: " + message + " but Actual Message: " + actualMessage);
            log.info("Expected Message: " + message + " but Actual Message: " + actualMessage);
        }

    }


    public void verifyModalOpen(String modalTitle) {
        getDriver().switchTo().activeElement();
        boolean modalOpened = $(MySkillsLocators.modalTitle(modalTitle)).isPresent();
        if (modalOpened) Assert.assertTrue(true);
        else {
            Assert.fail("Modal not opened");
            log.info("Modal not opened");
        }

    }


    public void verifyLoginMsg() {
        String loginMsg = $(MySkillsLocators.loginMsg).getText();
        boolean contains = StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions.");
        if (contains) Assert.assertTrue(true);
        else {
            Assert.fail("Login Screen is not open");
            log.info("Login Screen is not open");
        }
    }


    public void enterUsername(String username) {
        typeInto($(MySkillsLocators.homePageXpath("username")), username);

    }


    public void enterPassword(String password) {
        typeInto($(MySkillsLocators.homePageXpath("password")), password);

    }


    public void verifyDashboard() {
        waitFor(ExpectedConditions.presenceOfElementLocated(MySkillsLocators.dashboardElements("employeeCode"))).isDisplayed();
        waitFor(ExpectedConditions.presenceOfElementLocated(MySkillsLocators.dashboardElements("userLocation"))).isDisplayed();

        if ($(MySkillsLocators.dashboardElements("employeeCode")).isVisible() && $(MySkillsLocators.dashboardElements("userLocation")).isVisible())
            Assert.assertTrue(true);
        else {
            Assert.fail("Employee Code  or Location is not present");
            log.info("Employee Code  or Location is not present");

        }

    }

    public void launchUrl(String url) {
        getDriver().get(url);
    }

    public void clickSignInButton() {
        waitFor(ExpectedConditions.presenceOfElementLocated(MySkillsLocators.userAvatar));
        feedbackImplementation.clickOn(MySkillsLocators.homePageXpath("btnLogin"));
    }
}
