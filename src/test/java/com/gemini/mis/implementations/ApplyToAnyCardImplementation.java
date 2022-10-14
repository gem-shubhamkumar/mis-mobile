package com.gemini.mis.implementations;

import com.gemini.mis.selectors.ApplyToAnyCardLocators;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApplyToAnyCardImplementation extends PageObject {
    ApplyToAnyCardLocators applyToAnyCardLocators;

    private static Logger LOGGER = LoggerFactory.getLogger(ApplyToAnyCardImplementation.class);

    public void launchURL(String s){
        waitABit(5000);
        getDriver().navigate().to(s);
        LOGGER.info("Navigated to-{}",s);
        getDriver().manage().window().maximize();
        LOGGER.info("Maximized browser");
    }

    public void clickButton(String buttonName){
        waitABit(3000);
        switch(buttonName) {
            case "Sign In": {
                clickOn($(applyToAnyCardLocators.credInputField("submit")));
                LOGGER.info("Clicked on sign in button");
                break;
            }
            default:
                Assert.fail("Button " + buttonName + " not found");
        }
    }



    public void clickButton(String buttonName, String cardName){
        waitABit(3000);
        switch (buttonName){
            case "Maximize": {
                clickOn($(applyToAnyCardLocators.cardToggleMaximize(cardName)));
                LOGGER.info("Clicked on {} Button on {} card",buttonName,cardName);
                break;

            }
            case "Minimize" : {
                clickOn($(applyToAnyCardLocators.cardToggleMinimize(cardName)));
                LOGGER.info("Clicked on {} Button on {} card",buttonName,cardName);
                break;
            }
            default:
                Assert.fail("Button " + buttonName + " not found");
                LOGGER.error("Button {} not found",buttonName);
        }
    }

    public void veirfyLoginMsg(){
        waitABit(2000);
        String loginMsg = $(ApplyToAnyCardLocators.loginMsg);
        LOGGER.info("verifying login message");
        Assert.assertTrue(StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions."));
        LOGGER.info("Login message verified");
    }

    public void enterUsername(String username){
        $(applyToAnyCardLocators.credInputField("username")).sendKeys(username);
        LOGGER.info("Entered {} as username",username);
    }

    public void enterPassword(String password){
        $(applyToAnyCardLocators.credInputField("password")).sendKeys(password);
        LOGGER.info("Entered {} as password",password);
    }

    public void verifyDashboard(){
        waitABit(5000);
        LOGGER.info("Verifying dashboard....");
        Assert.assertTrue($(ApplyToAnyCardLocators.designation).isPresent());
        Assert.assertTrue($(ApplyToAnyCardLocators.logo).isPresent());
        LOGGER.info("Logo is present on the dashboard");
    }

    public void verifyCardMinimized(String cardName){
        waitABit(3000);
        LOGGER.info("Verifying card minimized");
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(ApplyToAnyCardLocators.collapsedCard);
        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)){
                flag = 1;
                LOGGER.info("Card {} is minimized.",cardName);

            }
        }
        if(flag == 1) Assert.assertTrue(true);
        else{
            Assert.fail("Card " + cardName + " is not minimized");
        }
    }

    public void verifyCardMaximized(String cardName){
        waitABit(5000);
        LOGGER.info("Verifying card {} maximized",cardName);
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(ApplyToAnyCardLocators.maximizedCard);
        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }
        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not maximized");
    }

    public void verifyIfCardPresent(String cardName){
        waitABit(5000);
        LOGGER.info("verifying presence of card {}",cardName);
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(ApplyToAnyCardLocators.cardNames);
        for (WebElement card : cards
        ) {
            if (card.getText().equals(cardName)) {
                flag = 1;
                LOGGER.info("Card {} is present",cardName);
                break;
            }
        }
        if(flag == 0){
            Assert.fail("Card " + cardName + " is not present");
        LOGGER.warn("Card {} is not present",cardName);
        }
        else
            Assert.assertTrue(true);
    }

}
