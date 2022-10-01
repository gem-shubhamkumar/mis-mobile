package com.gemini.mis.pages;

import com.gemini.mis.selectors.EmployeeDirectoryPOM;
import com.gemini.mis.selectors.GenericFunctionPOM;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EmployeeDirectoryPages extends PageObject {
@Step("Verify that page is downloaded successfully")
    public void VerifyPageDownloaded(){
    waitABit(3000);
        Boolean isHeadingVisible=$(By.xpath(GenericFunctionPOM.genericPath.replace("VAR","Employee Directory"))).isVisible();
    Boolean isElementsVisible=$(EmployeeDirectoryPOM.firstRow).isVisible();
    if (isHeadingVisible && isElementsVisible){
        Assert.assertTrue("the page is loaded successfully",true);
    }else{
        Assert.fail("the was not page loaded successfully");
    }
    }
    @Step("CLick on any element and open mail")
public void MailClick(){

    $(EmployeeDirectoryPOM.firstRow).click();
$(EmployeeDirectoryPOM.mailBox).isClickable();
Assert.assertTrue("The mail is visible/ clickable", true);
}
@Step("CLick on the user name and verify profile window should open")
    public void  VerifyProfileWindow(){
    waitABit(2000);
String employeeName=$(EmployeeDirectoryPOM.firstEmployeeName).getText();
    $(EmployeeDirectoryPOM.firstEmployeeName).click();
    waitABit(1000);
    Boolean isProfileVisible=$(EmployeeDirectoryPOM.ProfileWindow).isVisible();

    if(employeeName.equals("Aakash Gupta") && isProfileVisible){
        Assert.assertTrue("We are able to se the profile window",true);
    }else{
        Assert.fail("We are unable to locate the profile window");
    }
}
}
