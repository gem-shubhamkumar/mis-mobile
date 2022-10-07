package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class LoginPage extends PageObject {

    CommonFunctions utils;

    @Step("Navigating to MIS Beta Homepage")
    public void navigateApplication(String url) throws Exception {
        utils.launchUrl(url);
        utils.maximizeBrowser();
    }

   @Step("Enter Username and Password")
    public void enterValues(By Loc,String enterKey){
       $(Loc).sendKeys(enterKey);
       assertTrue("Successfully Entered Key", true);


    }

    @Step("Wait for an Element")
     public void Wait(long sec){

         waitABit(sec);
    }

   @Step("Click on Element")
    public void click(By Loc) {

       $(Loc).click();
       assertTrue("Successfully clicked on Element ", true);

   }

  @Step("Wait Till myElement is visible")
  public void WaitTillElementIsVisible(By element){

      waitFor(ExpectedConditions.visibilityOfElementLocated(element));

  }

  @Step("Verify that myElement is displayed")
    public void isElementExist(By Loc){
      WebElementFacade element = $(Loc);
      if (element.isDisplayed()) {
          assertTrue("Element is present on Webpage", true);
      } else {
          Assert.fail("Element is not present on Webpage");
      }
  }


  @Step("Verify focus is changed to new tab opened")
  public void changeFocusToNewTab(){
      Set wnd = getDriver().getWindowHandles();
      Iterator i = wnd.iterator();
      String popwnd = String.valueOf(i.next());
      String prntw = String.valueOf(i.next());
      getDriver().switchTo().window(prntw);

  }


}
