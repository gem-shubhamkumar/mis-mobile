package com.gemini.mis.pages;


import com.gemini.mis.implementations.DashboardPageImplementations;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashboardProfilePage {

    DashboardPageImplementations dashboard;


   @Step("Select all and delete")
    public void selectElementAndDelete(By ele){
      dashboard.selectAllAndDelete(ele);


   }
   @Step("Validate highlighted box")
    public void validateHighlightedField(By Loc){
      dashboard.verifyHighlightedField(Loc);
   }


}
