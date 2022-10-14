package com.gemini.mis.pages;

import com.gemini.mis.implementations.EmployeeDirectoryImplementation;
import net.thucydides.core.annotations.Step;

public class EmployeeDirectoryPage {
EmployeeDirectoryImplementation employeeDrImplement;
    //Validate page download
    @Step("Verify that page is downloaded successfully")
    public void verifyPageDownloaded(){
   employeeDrImplement.verifyPageDownloaded();
    }
    //Open mail
    @Step("CLick on any element and open mail")
    public void mailClick(){

    employeeDrImplement.mailClick();
    }
    //Verify profile window
    @Step("CLick on the user name and verify profile window should open")
    public void  verifyProfileWindow(){
   employeeDrImplement.verifyProfileWindow();
}
}
