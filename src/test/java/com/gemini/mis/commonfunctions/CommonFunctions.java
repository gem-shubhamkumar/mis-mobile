package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.LocatorDashboardProfilePage;
import com.gemini.mis.selectors.LocatorLoginPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

import static net.serenitybdd.core.Serenity.getDriver;
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

   public void changeFocus(){
       Set wnd = getDriver().getWindowHandles();
       Iterator i = wnd.iterator();
       String popwnd = String.valueOf(i.next());
       String prntw = String.valueOf(i.next());
       getDriver().switchTo().window(prntw);
   }

 //******************************** FUNCTION TO CHECK IF ELEMENT IS CLICKABLE ***********************************
    public void isElementClickable(By Loc)  {
        WebElementFacade element=$(Loc);
        if(element.isClickable()){
            assertTrue("Element is clickable",true);
        }
        else{
            Assert.fail("Element can not be clicked");
        }
    }

//************************************* FUNCTION TO SELECT ALL AND DELETE ****************************************

    public void selectAndDelete(By element){
        getDriver().findElement(element).sendKeys(Keys.CONTROL,"A");
        getDriver().findElement(element).sendKeys(Keys.DELETE);
    }

//******************************** FUNCTION TO VALIDATE EMPTY HIGHLIGHTED FIELD ************************************
   public void validateHighlightedField(By loc){
       String fun=$(loc).getAttribute("class");
       //System.out.println(fun);
       if(fun.contains("error-validation")){
          Assert.assertTrue("Error box highlighted is present",true);
       }
       else{
           Assert.fail("Fail");
       }
   }
}

