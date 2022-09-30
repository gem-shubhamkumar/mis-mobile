package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.LocatorFormPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CommonFunctions extends PageObject {

//***************************** FUNCTION TO LAUNCH URL ************************************************

    public void navigateToWebsite(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        assertTrue("Successfully launched url ", true);
    }

//*************************** FUNCTION TO ENTER VALUE TO A LOCATION ***********************************

    public void enterValue(By Loc, String enterKey) {
        $(Loc).sendKeys(enterKey);
        assertTrue("Successfully Entered Key", true);

    }

//****************************** FUNCTION TO CLICK ON ELEMENT ******************************************

    public void click(By Loc) {
        $(Loc).click();
        assertTrue("Successfully clicked on Element ", true);

    }

    //******************************* FUNCTION FOR WAIT *****************************************************
    public void Wait(long seconds) {

        waitABit(seconds);
    }

//*************************** FUNCTION FOR VISIBILITY OF ELEMENT ******************************************

    public void WaitTillElementVisible(By element) {

        waitFor(ExpectedConditions.visibilityOfElementLocated(element));
    }

//************************ FUNCTION TO CHECK ELEMENT EXISTENCE *******************************************

    public void isElementExist(By Loc) {
        WebElementFacade element = $(Loc);
        if (element.isDisplayed()) {
            assertTrue("Element is present on Webpage", true);
        } else {
            Assert.fail("Element is not present on Webpage");
        }
    }

//************************* FUNCTION TO CHANGE FOCUS TO NEW TAB *******************************************

    public void changeFocus() {
        Set wnd = getDriver().getWindowHandles();
        Iterator i = wnd.iterator();
        //String popwnd = String.valueOf(i.next());
        String prntw = String.valueOf(i.next());
        getDriver().switchTo().window(prntw);
    }

//******************************** FUNCTION TO CHECK IF ELEMENT IS CLICKABLE ***********************************
    public void IsElementvisible(By Loc) {
        WebElementFacade element = $(Loc);
        if (element.isVisible()) {
            assertTrue("Element is clickable", true);
        } else {
            Assert.fail("Element can not be clicked");
        }


    }

//************************************* FUNCTION TO SELECT ALL AND DELETE ****************************************

    public void selectAndDelete(By element) {
        getDriver().findElement(element).sendKeys(Keys.CONTROL, "A");
        getDriver().findElement(element).sendKeys(Keys.DELETE);
    }

    //******************************** FUNCTION TO VALIDATE EMPTY HIGHLIGHTED FIELD ************************************
    public void validateHighlightedField(By loc) {
        String fun = $(loc).getAttribute("class");
        if (fun.contains("error-validation")) {
            Assert.assertTrue("Error box highlighted is present", true);
        } else {
            Assert.fail("Fail");
        }
    }
//******************************* FUNCTION FOR PARENT AND CHILD TAB NAVIGATION **************************************

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

    public void navigateToTab(String parentTabName, String childTabName) {

        if (isElementFound(LocatorFormPage.sideNavigation(parentTabName))) {
            waitABit(1000);
            click(LocatorFormPage.sideNavigation(parentTabName));
            waitABit(3000);
            if (isElementFound(LocatorFormPage.sideNavigation(childTabName))) {
                click(LocatorFormPage.sideNavigation(childTabName));
            } else
                Assert.fail("Child element is not found");
        } else
            Assert.fail("Parent element not found");
    }
//************************************************ FUNCTION TO CLOSE APPLICATION *************************************
    public void closeApplication(){
        getDriver().quit();
    }
//********************************************** FUNCTION TO SCROLL**************************************************

public void scrollToElement(By Element) {
    JavascriptExecutor js = (JavascriptExecutor)getDriver();
    WebElement ele = $(Element);
    js.executeScript("arguments[0].scrollIntoView(true)", ele);
}

//********************************************** FUNCTION TO DOWNLOAD FILE ******************************************
public boolean isFileDownloaded(String downloadPath, String fileName) {
    File folder = new File(downloadPath);
    File[] folderContent = folder.listFiles();

    for (int i = 0; i < folderContent.length; i++) {
        if (folderContent[i].getName().equals(fileName)) {
            folderContent[i].delete(); // File has been found, it can now be deleted:
            return true;
        }
    }
    return false;
}

//************************************** FUNCTION TO UPLOAD FILE ***************************************************
public void uploadFile(By Location,String fileLoc) throws InterruptedException {
    WebElement upload_file = getDriver().findElement(Location);
    upload_file.sendKeys(fileLoc);
}

//*********************************************FUNCTION TO HOVER OVER ***********************************************
    public void hoverOver(By Element){
        moveTo(Element);
    }



}

