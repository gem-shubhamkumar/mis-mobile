package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    CommonFunctions utils;

    @Step("Navigating to MIS Beta Homepage")
    public void navigateApplication(String url) {

        utils.navigateToWebsite(url);
    }

    @Step("Enter Username and Password")
    public void enterValues(By Loc,String enterKey){

        utils.enterValue(Loc,enterKey);
    }

    @Step("Wait for an Element")
     public void Wait(long sec){
            utils.Wait(sec);
    }

   @Step("Click on Element")
    public void click(By Loc) {
        utils.click(Loc);
   }

  @Step("Wait Till myElement is visible")
  public void WaitTillElementIsVisible(By element){

        utils.WaitTillElementVisible(element);
  }
  @Step("Verify that myElement is displayed")
    public void isElementExist(By Loc){

        utils.isElementExist(Loc);
   }

  @Step("Verify focus is changed to new tab opened")
  public void changeFocusToNewTab(){
        utils.changeFocus();
  }
  @Step("Verify element is clickable and click")
    public void isElementClickable(By Loc) throws InterruptedException {
        utils.isElementClickable(Loc);
  }
}
