package com.gemini.mis.pages;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class DashboardProfilePage extends PageObject {


   @Step("Select all and delete")
    public void selectElementAndDelete(By ele){
       getDriver().findElement(ele).sendKeys(Keys.CONTROL, "A");
       getDriver().findElement(ele).sendKeys(Keys.DELETE);


   }
   @Step("Validate highlighted box")
    public void validateHighlightedField(By Loc){
       String fun = $(Loc).getAttribute("class");
       if (fun.contains("error-validation")) {
           Assert.assertTrue("Error box highlighted is present", true);
       } else {
           Assert.fail("Fail");
       }
   }


}
