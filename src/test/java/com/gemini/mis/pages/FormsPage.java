package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.CommonSelectors;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class FormsPage extends PageObject {
    CommonFunctions utils;


    @Step("Navigate to tabs")
    public void NavigateParentAndChildTab(String parentTab,String childTab){
        if (isElementFound(CommonSelectors.sideNavigation(parentTab))) {
            waitABit(1000);
            click(CommonSelectors.sideNavigation(parentTab));
            waitABit(3000);
            if (isElementFound(CommonSelectors.sideNavigation(childTab))) {
                click(CommonSelectors.sideNavigation(childTab));
            } else
                Assert.fail("Child element is not found");
        } else
            Assert.fail("Parent element not found");
    }


    @Step("Close the application")
    public void closeApplication(){

        getDriver().quit();
    }

    @Step("Scroll to element")
    public void scroll(By element){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        WebElement ele = $(element);
        js.executeScript("arguments[0].scrollIntoView(true)", ele);


    }
    @Step("Download and Delete a file")
    public void isFileDownloaded(String downloadPath, String fileName){
        utils.isFileDownloaded(downloadPath,fileName);
    }
    @Step("Upload File")
    public void uploadFile(By Location,String fileLoc) throws InterruptedException {
        WebElement upload_file = getDriver().findElement(Location);
        upload_file.sendKeys(fileLoc);
    }

    @Step("Hover Over")
    public void hoverOver(By element) throws Exception {
       utils.hover((WebElement) element);

    }


    public boolean isElementFound(By loc) {
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
        $(Loc).click();
        assertTrue("Successfully clicked on Element ", true);
    }}
