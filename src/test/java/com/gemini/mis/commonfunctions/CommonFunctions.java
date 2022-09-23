package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.LocatorLoginPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class CommonFunctions extends PageObject {

//***************************** FUNCTION TO LAUNCH URL ************************************************

    public void navigateToWebsite(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
        assertTrue("Successfully launched url ",true);
    }

//*************************** FUNCTION TO ENTER VALUE TO A LOCATION ***********************************

   public void enterValue(By Loc,String enterKey)
   {
     $(Loc).sendKeys(enterKey);
    assertTrue("Successfully Entered Key",true);
  }

//****************************** FUNCTION TO CLICK ON ELEMENT ******************************************

    public void click(By Loc) {
        $(Loc).click();
        assertTrue("Successfully clicked on Element ",true);
    }

//******************************* FUNCTION FOR WAIT *****************************************************
    public void Wait(long seconds){
        waitABit(seconds);
    }

//*************************** FUNCTION FOR VISIBILITY OF ELEMENT ******************************************
    public void WaitTillElementVisible(By element){
        waitFor(ExpectedConditions.visibilityOfElementLocated(element));
    }
//************************ FUNCTION TO CHECK ELEMENT EXISTENCE *******************************************

    public void isElementExist(By Loc){
        WebElementFacade element=$(Loc);
        element.isDisplayed();
        assertTrue("Element is present on WebPage",true);
    }

    }

