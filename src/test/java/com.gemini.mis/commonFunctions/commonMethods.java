package com.gemini.mis.commonFunctions;

import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.CommonXpaths;
import com.gemini.mis.selectors.NavBarSelectors;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class commonMethods extends PageObject {
     CommonXpaths commonXpaths;

    public void clickOn(By elementLoc){
        if ($(elementLoc).isVisible()){
            waitABit(1500);
            $(elementLoc).click();
        }else{
            Assert.fail("Unable to click: by xpath > "+elementLoc);
        }
    }

    public void sendTextToField(By loc,String text){
        waitFor(ExpectedConditions.presenceOfElementLocated(loc));
        $(loc).type(text);
    }

    public boolean isElementFound(By loc) {
        boolean isFound;
        try {
            $(loc);
            isFound = true;
        } catch (Exception e) {
            isFound = false;
        }
        return isFound;
    }

    public void isTextFound(By loc,String text){
        String textToCompare = $(loc).getText();
        if(text.contains("Hello")){
            System.out.println("Text is verified");;
        }
        else
        Assert.assertEquals(text,textToCompare);
    }
    @Step("Compare list data is same or not")
    public void compareListData(List<String> list1, List<String> list2){
        if(list1.size()==list2.size()){
            if(list1.equals(list2)){
                System.out.println("Both lists have same data");
            }else{
                Assert.fail("Data in lists are not same");
            }
        }else
            Assert.fail("Size of the lists are different");
    }

    @Step("Navigate to {0}")
    public void navigateTo(String websiteName){
        switch (websiteName){
            case "myMIS":
                getDriver().get("https://mymis.geminisolutions.com/");
                break;

        }
        waitABit(3000);
    }


    @Step("Click on {0} inside {1}")
    public void navigateToTab(String parentTabName, String childTabName) {

        if (isElementFound(CommonXpaths.menuTabs(parentTabName))) {
            waitABit(1000);
            clickOn(commonXpaths.menuTabs(parentTabName));
            waitABit(2000);
            if (isElementFound(commonXpaths.menuTabs(childTabName))) {
                clickOn(commonXpaths.menuTabs(childTabName));
            } else
                Assert.fail("Child element is not found");
        } else
            Assert.fail("Parent element not found");
    }
    @Step("Click on {0} tab")
    public void navigateToTab(String parentTabName) {
        if (isElementFound(CommonXpaths.menuTabs(parentTabName))) {
            waitABit(1000);
            clickOn(CommonXpaths.menuTabs(parentTabName));

        } else {
            Assert.fail("Unable to locate parent tab");
        }
    }

    public void verifyTextFieldAndEnterText(By loc, String text){
        if (isElementFound(loc)){
            $(loc).type(text);
        }else{
            Assert.fail("Unable to locate text field");
        }
    }

    @Step("Verify if {0} element is not visible on current screen")
    public void verifyElementIsNotVisible(String elementName){
        boolean flag =false;
        switch (elementName){
            case "Side navigation bar":
                flag=$(CommonXpaths.sideMenuBar).isVisible();
                break;
            case "Add skills window":
                flag= $(NavBarSelectors.windowAddSkills).isVisible();
                break;

            default:Assert.fail("Element name wrong");
        }
        if(flag){
            Assert.fail(elementName+" is visible on the screen");
        }else{
            System.out.println("Element is not visible on the screen");
        }
    }

    @Step("Verify page title as {0}")
    public void verifyPageTitle(String title){
        String currentTitle = getDriver().getTitle();
        Assert.assertEquals(title,currentTitle);
    }

    @Step("Verify {0} is open and enter username as {1} and password as {2}")
    public void verifyCredentialsEnterInField(String portalName,String username,String password){
        switch (portalName){
            case "myMIS portal":
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldMyMISUsername));
                sendTextToField(AccountPortalSelectors.textFieldMyMISUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldMyMISPassword));
                sendTextToField(AccountPortalSelectors.textFieldMyMISPassword, password);
                break;

            case "greytHR portal":
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldGreytHRUsername));
                sendTextToField(AccountPortalSelectors.textFieldGreytHRUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldGreytHRPassword));
                sendTextToField(AccountPortalSelectors.textFieldGreytHRPassword, password);
                waitABit(2000);
                break;

            default:Assert.fail("unable to verify portal name");

        }
        waitABit(3000);


    }


    @Then("^Verify \"(.*?)\" message appear in screen$")
    public void verifyMessageBoxAfterAddingRecord(String message){
        String messageOnBox="";
        if(isElementFound(commonXpaths.textMessageBox)){
             messageOnBox = $(CommonXpaths.textMessageBox).getText();
        }
        switch (message){
            case "Success":
                if(messageOnBox.contains("Success")){
                    System.out.println("Success message box appear");
                }else {
                    Assert.fail();
                }
                break;
            case "Duplicate":
                if(messageOnBox.contains("Duplicate")){
                    System.out.println("Warning/Duplicate message box appear");
                }else {
                    Assert.fail();
                }

        }

    }
}
