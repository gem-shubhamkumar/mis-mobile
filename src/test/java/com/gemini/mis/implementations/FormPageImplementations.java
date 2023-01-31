package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForLoginPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormPageImplementations extends PageObject {

    static final Logger log = LoggerFactory.getLogger("SampleLogger");
    CommonFunctions genFunc;


    public void navigateTabs(String parentTab, String childTab) {
        waitABit(3000);
        // added by shubham.kumar
//        clickOn(find(By.xpath("//button[contains(@class,'hamburger')]")));
        if (genFunc.getDriverType().equalsIgnoreCase("Appium")) {
            // clicks on hamburger-menu button
            clickOn(find(By.xpath("//button[contains(@class,'hamburger')]")));
        }

        if (isElementFound(XpathForLoginPage.sideNavigation(parentTab))) {
            waitABit(1000);
            click(XpathForLoginPage.sideNavigation(parentTab));
            waitABit(3000);
            if (isElementFound(XpathForLoginPage.sideNavigation(childTab))) {
                click(XpathForLoginPage.sideNavigation(childTab));
            } else
                Assert.fail("Child element is not found");
        } else
            Assert.fail("Parent element not found");
        log.info("Parent element not found");
    }


    public boolean isElementFound(By loc) {
        waitABit(1500);
        boolean isFound;
        try {
            $(loc);
            isFound = true;
        } catch (Exception e) {
            isFound = false;
        }
        return isFound;
    }

    public void click(By Loc) {
        WebElementFacade element = $(Loc);
        if (element.isDisplayed()) {
            element.click();
            Assert.assertTrue("Successfully clicked on Element ", true);
        } else {
            Assert.fail("Unable to click on Element");
            log.info("Unable to click on Element");

        }
    }

    public void close() {

        getDriver().quit();
    }

    public void scroll(By element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement ele = $(element);
        js.executeScript("arguments[0].scrollIntoView(true)", ele);
    }

    public void upload(By Location, String fileLoc) {
        WebElement uploadFile = getDriver().findElement(Location);
        uploadFile.sendKeys(fileLoc);
    }
}
