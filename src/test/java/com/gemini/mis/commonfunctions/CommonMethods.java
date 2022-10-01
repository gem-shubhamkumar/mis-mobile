package com.gemini.mis.commonfunctions;

import com.gemini.mis.selectors.AppraisalManagementAddGoalsLocators;
import com.gemini.mis.selectors.CommonSelectors;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CommonMethods extends PageObject {

    CommonSelectors commonXpaths;

    public void click(By locator)  {

        $(locator).waitUntilPresent().click();

    }

    public WebElement getElement (By locator) {
        return $(locator);
    }


    public void click(WebElement element)  {

        if(element.isDisplayed()) {
            element.click();
        }

    }

    public Boolean isPresent(By locator) {
        return $(locator).isPresent();
    }

    public void typeText(By locator, String string) {
        $(locator).type(string);
    }

    public String getText(By locator) {
        return $(locator).getText();
    }

    public List<WebElement> getMultipleElements(By locator) {
        return getDriver().findElements(locator);
    }


    public void pressEnter() {
        withAction().sendKeys(Keys.ENTER).build().perform();
    }

    public void launchUrl(String url) {
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public void customWait(long seconds) {
        waitABit(seconds);
    }

    public void switchToActiveElement() {
        getDriver().switchTo().activeElement();
    }

    public void clearField(By id) {
        getElement(id).sendKeys(Keys.BACK_SPACE);
    }
    public void clickOn(By elementLoc){
        if ($(elementLoc).isVisible()){
            waitABit(1500);
            $(elementLoc).click();
        }else{
            Assert.fail("Unable to click: by xpath > "+elementLoc);
        }
    }

    public void isElementVisible(By loc,String elementName){
        if($(loc).isVisible()){
            System.out.println(elementName+ "is visible on the current page");
        }else{
            Assert.fail(elementName+" isn not visible on the current page");
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




    @Step("Click on {0} inside {1}")
    public void navigateToTab(String parentTabName, String childTabName) {

        if (isElementFound(commonXpaths.menuTabs(parentTabName))) {
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
        if (isElementFound(commonXpaths.menuTabs(parentTabName))) {
            waitABit(1000);
            clickOn(commonXpaths.menuTabs(parentTabName));

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
                flag=$(commonXpaths.sideMenuBar).isVisible();
                break;
            case "Delivery tab":
                flag=$(AppraisalManagementAddGoalsLocators.tabDelivery).isVisible();
                break;
            case "Add KPI description text field":
                flag=$(AppraisalManagementAddGoalsLocators.textFieldAddKPI).isVisible();
                break;


            default:Assert.fail("Element name wrong");
        }
        if(flag){
            Assert.fail(elementName+" is visible on the screen");
        }else{
            System.out.println("PASS : Element is not visible on the screen");
        }
    }

    @Step("Verify page title as {0}")
    public void verifyPageTitle(String title){
        String currentTitle = getDriver().getTitle();
        Assert.assertEquals(title,currentTitle);
    }




    @Then("^Verify \"(.*?)\" message appear in screen$")
    public void verifyMessageBoxAfterAddingRecord(String message){
        String messageOnBox="";
        boolean flag= false;
        if(isElementFound(commonXpaths.textMessageBox)){
            messageOnBox = $(commonXpaths.textMessageBox).getText();
        }
        switch (message){
            case "Success":
                if(messageOnBox.contains("successfully")){
                    flag=true;
                    System.out.println("Success message box appear");
                }else {
                    Assert.fail();
                }
                break;
            case "Duplicate":
                if(messageOnBox.contains("Duplicate")){
                    flag=true;
                    System.out.println("Warning/Duplicate message box appear");
                }else {
                    Assert.fail();
                }
                break;
        }
        if(flag) {
            waitFor(ExpectedConditions.presenceOfElementLocated(commonXpaths.btnOk));
            clickOn(commonXpaths.btnOk);
        }else{
            Assert.fail("Warning / Success box does not appear");
        }

    }
}


