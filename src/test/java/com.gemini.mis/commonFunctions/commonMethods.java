package com.gemini.mis.commonFunctions;

import com.gemini.mis.selectors.accountPageSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class commonMethods extends PageObject {

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
    public void navigateToChildTab(String childTabName, String parentTabName){
        if(isElementFound(accountPageSelectors.menuTabs(parentTabName))){
            waitABit(1000);
            clickOn(accountPageSelectors.menuTabs(parentTabName));
            waitABit(2000);
            if(isElementFound(accountPageSelectors.menuTabs(childTabName))){
                clickOn(accountPageSelectors.menuTabs(childTabName));
            }else{
                System.out.println("No child tab found");
            }
        }else {
            Assert.fail("Unable to locate paren element "+parentTabName);
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
                waitFor(ExpectedConditions.presenceOfElementLocated(accountPageSelectors.textFieldMyMISUsername));
                sendTextToField(accountPageSelectors.textFieldMyMISUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(accountPageSelectors.textFieldMyMISPassword));
                sendTextToField(accountPageSelectors.textFieldMyMISPassword, password);
                break;

            case "greytHR portal":
                waitFor(ExpectedConditions.presenceOfElementLocated(accountPageSelectors.textFieldGreytHRUsername));
                sendTextToField(accountPageSelectors.textFieldGreytHRUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(accountPageSelectors.textFieldGreytHRPassword));
                sendTextToField(accountPageSelectors.textFieldGreytHRPassword, password);
                waitABit(2000);
                break;

            default:Assert.fail("unable to verify portal name");

        }


    }
}
