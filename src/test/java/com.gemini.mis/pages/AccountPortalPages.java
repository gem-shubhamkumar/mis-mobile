package com.gemini.mis.pages;

import com.gemini.mis.commonFunctions.CommonFunctions;
import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.CommonXpaths;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;



public class AccountPortalPages extends PageObject {


    CommonXpaths commonXpaths;

    CommonFunctions commonMethod;
    
    
    @Step("Verify  elements on greytHR landing page are visible")
    public void verifyGreytHrlandingPageEle(){
        waitABit(3000);
            String[] array = {"Payslip","IT Declaration","POI","Track"};
            List<WebElement> listItems = getDriver().findElements(AccountPortalSelectors.listLandingPageElements);
            List<String> compareItemText = new ArrayList<>();
            for(String names :array){
                compareItemText.add(names);
            }
            List<String> list =new ArrayList<>();

            for(WebElement ele : listItems){
                list.add(ele.getText());
            }
            System.out.println(list);
            System.out.println(compareItemText);
            if(list.equals(compareItemText)){
                System.out.println("All element are present");
            }else{
                Assert.fail("All elements are not present");
            }
        }

    @Step("Verify elements are visible after clicking on View my info link")
    public void verifyEleAreAvailableOnViewMyInfo(){
        String[] array = {"Personal","Accounts & Statutory","Family","Employment & Job","Assets"};
        List<WebElement> listItems = getDriver().findElements(AccountPortalSelectors.listViewMyInfo);
        List<String> compareItemText = new ArrayList<>();
        for(String names :array){
            compareItemText.add(names);
        }
        List<String> list =new ArrayList<>();

        for(WebElement ele : listItems){
            list.add(ele.getText());
        }
        System.out.println(list);
        System.out.println(compareItemText);
        if(list.equals(compareItemText)){
            System.out.println("All element are present");
        }else{
            Assert.fail("All elements are not present");
        }
    }

    @Step("Click on {0}")
    public void clickOnElement(String eleName){
        waitABit(1500);
        switch(eleName){
            case "sign in button":
               clickOn(AccountPortalSelectors.btnSignIn);
                break;
            case "Log in button":
                clickOn(AccountPortalSelectors.btnLogIn);
                break;
            case "View My Info link":
               clickOn(AccountPortalSelectors.linkViewMyInfo);
                break;
            case "Accounts & Statutory":
               clickOn(AccountPortalSelectors.linkAccountAndStatutory);
                break;
            case "Settings link":
               clickOn(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
               clickOn(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "CL leave balance link":
               clickOn(CommonXpaths.linkNumberOfLeave("CL"));
                break;
            case "WFH":
               clickOn(CommonXpaths.linkNumberOfLeave("WFH"));
                break;
            case "Close button":
               clickOn(LeaveBalanceSelectors.btnLeaveHistoryClose);
                break;
            case "Gemini logo":
               clickOn(NavBarSelectors.logoGemini);
                break;
            case "Menu button":
               clickOn(CommonXpaths.btnMenu);
                break;
            case "Change AD password button":
               clickOn(NavBarSelectors.btnChangeADpassword);
                break;
            case "Profile button":
                waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.btnProfileMenu));
               clickOn(NavBarSelectors.btnProfileMenu);
                break;
            case "Skills option":
               clickOn(NavBarSelectors.optionsSkills);
                break;
            case "Save button":
               clickOn(NavBarSelectors.btnAddSkillSave);
                break;
            case "Add skill close button":
               clickOn(CommonXpaths.btnClose);
                break;
            case "Logout button":
               clickOn(CommonXpaths.btnLogout);
                break;
            case "Dashboard setting button":
               clickOn(NavBarSelectors.btnDashboardSetting);
                break;
            case "Update button":
               clickOn(NavBarSelectors.btnUpdate);
                break;

            default:Assert.fail("button not found, not added in switch cases");
        }
        waitABit(1000);
    }



    @Step("Verify new tab is open in window handle as page heading {0}")
    public void verifyNewWindowTabIsOpen(String newTabPageHeading){
        waitABit(2000);
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(1));
        if(browserTabs.size()==2){
            Assert.assertTrue(getTitle().contains(newTabPageHeading));
        }else{
            Assert.fail("Only one tab is open");
        }
    }

    @Step("Verify {0} on current page")
    public void verifyElementOnCurrentPage(String eleName){
        switch (eleName){
            case "Gemini logo":
                isElementFound(AccountPortalSelectors.logoGemini);
                break;
            case "greytHR logo":
                isElementFound(AccountPortalSelectors.logoGreytHR);
                break;
            case "greytHR username text field":
                isElementFound(AccountPortalSelectors.textFieldGreytHRUsername);
                break;
            case "gerytHR password text field":
                isElementFound(AccountPortalSelectors.textFieldGreytHRPassword);
                break;
            case "Settings link":
                isElementFound(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
                isElementFound(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "Profile card":
                isElementFound(LeaveBalanceSelectors.cardProfile);
                break;
            case "Leave balance card":
                isElementFound(LeaveBalanceSelectors.cardLeaveBalance);
                break;
            case "Leave history window":
                isElementFound(LeaveBalanceSelectors.gridLeaveHistory);
                break;
            case "Employee directory table":
                isElementFound(NavBarSelectors.tableEmployeeDirectory);
                break;
            case "Side navigation bar":
                isElementFound(CommonXpaths.sideMenuBar);
                break;


            default: Assert.fail("failed to locate element with "+eleName);
        }
    }

    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        switch (text){
            case "Hello there!":
                isTextFound(AccountPortalSelectors.textHelloThere,text);
                break;
            case "Priyanshu":
                text="Hi "+text;
                isTextFound(AccountPortalSelectors.textUsername,text);
                break;
            case "Yes Bank":
                isTextFound(AccountPortalSelectors.textBankNAme,text);
                break;
            case "Username and password is required.":
                isTextFound(AccountPortalSelectors.textIncorrectCredentials,text);
                break;


            default:Assert.fail("Failed to find text : "+text);


        }
    }

    @Step("Verify header elements are present on view login history page")
    public void verifyHeaderElementsArePresent(){
        for(int i=1;i<4;i++){
            if(isElementFound(AccountPortalSelectors.elementsLoginDetails(i))){
                System.out.println($(AccountPortalSelectors.elementsLoginDetails(i)).getText()+" element is found successfully");
            }else {
                Assert.fail("Unable to locate element "+$(AccountPortalSelectors.elementsLoginDetails(i)).getText());
            }
        }

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

    @Step("Verify user landed on myMIS portal")
    public void verifyLandingToMyMIS(){
        if(getDriver().getTitle().equals("greytHR")){
            getDriver().close();
            if(getDriver().getTitle().equals("myMIS")){
                System.out.println("successfully navigated to myMIS portal page/tab");
            }else{
                Assert.fail("failed to navigate MIS portal ");
            }
        }else{
            Assert.fail("failed to navigate greytHR portal");
        }


    }

///////////////////////////////////////////////////MIS COMMON///////////////////////////


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
            System.out.println("Text is verified");
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
            System.out.println("PASS : Element is not visible on the screen");
        }
    }

    @Step("Verify page title as {0}")
    public void verifyPageTitle(String title){
        String currentTitle = commonMethod.getTitle();
        Assert.assertEquals(title,currentTitle);
    }




    @Then("^Verify \"(.*?)\" message appear in screen$")
    public void verifyMessageBoxAfterAddingRecord(String message){
        String messageOnBox="";
        boolean flag= false;
        if(isElementFound(commonXpaths.textMessageBox)){
            messageOnBox = $(CommonXpaths.textMessageBox).getText();
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
            waitFor(ExpectedConditions.presenceOfElementLocated(CommonXpaths.btnOk));
            clickOn(CommonXpaths.btnOk);
        }else{
            Assert.fail("Warning / Success box does not appear");
        }

    }




}



