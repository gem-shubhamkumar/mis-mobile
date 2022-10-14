package com.gemini.mis.implementations;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class LoginPageImplementations extends PageObject {

    static final Logger log = LoggerFactory.getLogger("SampleLogger");



    public void launchApplication(String url){
        getDriver().get(url);
        getDriver().manage().window().maximize();
        if (getDriver().getTitle().equals("Gemini MIS")) {
            assertTrue("Successfully launched application", true);
        } else {
            Assert.fail("Unable to launch application");
            log.info("Unable to launch application");
        }

    }

   public void typeValue(By Loc, String enterKey){
       WebElementFacade element = $(Loc);
       if(element.isDisplayed()) {
           $(Loc).sendKeys(enterKey);
           assertTrue("Successfully Entered value", true);
       }
       else {
           Assert.fail("Unable to enter value");
           log.info("Unable to enter value");
       }
   }

   public void customWait(long sec){

        waitABit(sec);
   }


   public void isElementExists(By Loc){
       WebElementFacade element = $(Loc);
       if (element.isDisplayed()) {
           assertTrue("Element is present on Webpage", true);
       } else {
           Assert.fail("Element is not present on Webpage");
          log.info("Element is not present on Webpage");
       }
   }

  public void waitTillElementPresence(By element){

        waitFor(ExpectedConditions.visibilityOfElementLocated(element));
  }

 public void changeFocus(){
     Set wnd = getDriver().getWindowHandles();
     Iterator i = wnd.iterator();
     String popwnd = String.valueOf(i.next());
     String prntw = String.valueOf(i.next());
     getDriver().switchTo().window(prntw);
 }
}
