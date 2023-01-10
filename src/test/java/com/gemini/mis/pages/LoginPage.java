package com.gemini.mis.pages;

import com.gemini.mis.implementations.FormPageImplementations;
import com.gemini.mis.implementations.LoginPageImplementations;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;


public class LoginPage {

    LoginPageImplementations login;
    FormPageImplementations forms;

    @Step("Navigating to MIS Beta Homepage")
    public void navigateApplication(String url) {

        login.launchApplication(url);
    }

   @Step("Enter Username and Password")
    public void enterValues(By Loc,String enterKey){

        login.typeValue(Loc,enterKey);
          }

    @Step("customWait for an Element")
     public void customWait(long sec){

        login.customWait(sec);
    }

   @Step("Click on Element")
    public void click(By Loc) {

        forms.click(Loc);
   }

  @Step("customWait Till myElement is visible")
  public void waitTillElementIsVisible(By element){
        login.waitTillElementPresence(element);

  }

  @Step("Verify that myElement is displayed")
    public void isElementExist(By Loc){

        login.isElementExists(Loc);
  }


  @Step("Verify focus is changed to new tab opened")
  public void changeFocusToNewTab(){
      login.changeFocus();

  }
  @Step("Delete already applied dates")
    public void deleteDatesInLunch(){
        login.deleteLunchDates();
  }


}
