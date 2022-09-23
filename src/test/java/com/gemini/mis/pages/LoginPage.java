package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.LocatorLoginPage;
import net.serenitybdd.screenplay.waits.Wait;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

  @Step("Wait Till element is visible")
  public void WaitTillElementIsVisible(By element){
        utils.WaitTillElementVisible(element);
  }
  @Step("Verify that element is displayed")
    public void isElementExist(By Loc){
        utils.isElementExist(Loc);
  }

}
