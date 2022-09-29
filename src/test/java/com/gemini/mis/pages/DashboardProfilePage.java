package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardProfilePage extends PageObject {
    CommonFunctions utils;

   @Step("Select all and delete")
    public void selectElementAndDelete(By ele){

       utils.selectAndDelete(ele);
   }
   @Step("Validate highlighted box")
    public void validateHighlightedField(By Loc){

       utils.validateHighlightedField(Loc);
   }


}
