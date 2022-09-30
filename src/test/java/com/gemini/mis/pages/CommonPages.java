package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonMethods;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.ApplyToAnyLocators;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonPages {

    CommonMethods commonMethods = new CommonMethods();
    public void launchURL(String s) {
        commonMethods.launchUrl(s);
    }

    public void verifyLoginMsg() {
        String loginMsg = commonMethods.getText(By.xpath(CommonSelectors.loginMsg));
        Assert.assertTrue(StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions."));
    }


    public void enterUsername(String username) {
        commonMethods.typeText(By.xpath(CommonSelectors.homePageXpath.replace("name", "username")), username);
    }

    public void enterPassword(String password) {
        commonMethods.typeText(By.xpath(CommonSelectors.homePageXpath.replace("name", "password")), password);

    }

    public void clickButton(String buttonName) {
        commonMethods.customWait(1000);
        switch(buttonName) {
            case "Sign In": {
                commonMethods.click(By.xpath(CommonSelectors.homePageXpath.replace("name", "btnLogin")));
                break;
            }

            case "update" : {
                commonMethods.click(By.xpath(ApplyToAnyLocators.genericButton.replace("ids", "btnUpdateSkills")));
                break;
            }

            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }

    public void clickButton(String buttonName, String cardName) {
        commonMethods.customWait(1000);
        switch(buttonName) {
            case "Maximize": {
                commonMethods.click(By.xpath(CommonSelectors.cardToggleMaximize.replace("card", cardName)));
                break;

            }
            case "Minimize" : {
                String xpath = CommonSelectors.cardToggleMinimize.replace("card", cardName);
                xpath = xpath.replace("buttonName", buttonName);
                commonMethods.click(By.xpath(xpath));
                break;
            }
            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }

    public void verifyDashboard() {
        commonMethods.customWait(3000);
        Assert.assertTrue(commonMethods.isPresent(By.xpath(CommonSelectors.designation)));
        Assert.assertTrue(commonMethods.isPresent(By.xpath(CommonSelectors.logo)));

    }

    public void verifyCardMinimized(String cardName) {
        int flag = 0;
        List<WebElement> cards = commonMethods.getMultipleElements(By.xpath(CommonSelectors.collapsedCard));

        for (WebElement card: cards
             ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not minimized");

    }

    public void verifyCardMaximized(String cardName) {
        int flag = 0;
        List<WebElement> cards = commonMethods.getMultipleElements(By.xpath(CommonSelectors.fullScreenCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not maximized");

    }
}
