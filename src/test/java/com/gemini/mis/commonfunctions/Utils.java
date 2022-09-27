package com.gemini.mis.commonfunctions;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils extends PageObject {

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


