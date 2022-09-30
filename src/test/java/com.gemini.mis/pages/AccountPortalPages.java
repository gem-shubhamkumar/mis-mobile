package com.gemini.mis.pages;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.CommonXpaths;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;



public class AccountPortalPages extends PageObject {
    @Steps
    commonMethods commonfunctions;
    
    
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
        };
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
                commonfunctions.clickOn(AccountPortalSelectors.btnSignIn);
                break;
            case "Log in button":
                commonfunctions. clickOn(AccountPortalSelectors.btnLogIn);
                break;
            case "View My Info link":
                commonfunctions.clickOn(AccountPortalSelectors.linkViewMyInfo);
                break;
            case "Accounts & Statutory":
                commonfunctions.clickOn(AccountPortalSelectors.linkAccountAndStatutory);
                break;
            case "Settings link":
                commonfunctions.clickOn(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
                commonfunctions.clickOn(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "CL leave balance link":
                commonfunctions.clickOn(CommonXpaths.linkNumberOfLeave("CL"));
                break;
            case "WFH":
                commonfunctions.clickOn(CommonXpaths.linkNumberOfLeave("WFH"));
                break;
            case "Close button":
                commonfunctions.clickOn(LeaveBalanceSelectors.btnLeaveHistoryClose);
                break;
            case "Gemini logo":
                commonfunctions.clickOn(NavBarSelectors.logoGemini);
                break;
            case "Menu button":
                commonfunctions.clickOn(CommonXpaths.btnMenu);
                break;
            case "Change AD password button":
                commonfunctions.clickOn(NavBarSelectors.btnChangeADpassword);
                break;
            case "Profile button":
                waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.btnProfileMenu));
                commonfunctions.clickOn(NavBarSelectors.btnProfileMenu);
                break;
            case "Skills option":
                commonfunctions.clickOn(NavBarSelectors.optionsSkills);
                break;
            case "Save button":
                commonfunctions.clickOn(NavBarSelectors.btnAddSkillSave);
                break;
            case "Add skill close button":
                commonfunctions.clickOn(CommonXpaths.btnClose);
                break;
            case "Logout button":
                commonfunctions.clickOn(CommonXpaths.btnLogout);
                break;
            case "Dashboard setting button":
                commonfunctions.clickOn(NavBarSelectors.btnDashboardSetting);
                break;
            case "Update button":
                commonfunctions.clickOn(NavBarSelectors.btnUpdate);
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
                commonfunctions.isElementFound(AccountPortalSelectors.logoGemini);
                break;
            case "greytHR logo":
                commonfunctions.isElementFound(AccountPortalSelectors.logoGreytHR);
                break;
            case "greytHR username text field":
                commonfunctions.isElementFound(AccountPortalSelectors.textFieldGreytHRUsername);
                break;
            case "gerytHR password text field":
                commonfunctions.isElementFound(AccountPortalSelectors.textFieldGreytHRPassword);
                break;
            case "Settings link":
                commonfunctions.isElementFound(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
                commonfunctions.isElementFound(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "Profile card":
                commonfunctions.isElementFound(LeaveBalanceSelectors.cardProfile);
                break;
            case "Leave balance card":
                commonfunctions.isElementFound(LeaveBalanceSelectors.cardLeaveBalance);
                break;
            case "Leave history window":
                commonfunctions.isElementFound(LeaveBalanceSelectors.gridLeaveHistory);
                break;
            case "Employee directory table":
                commonfunctions.isElementFound(NavBarSelectors.tableEmployeeDirectory);
                break;
            case "Side navigation bar":
                commonfunctions.isElementFound(CommonXpaths.sideMenuBar);
                break;


            default: Assert.fail("failed to locate element with "+eleName);
        }
    }

    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        switch (text){
            case "Hello there!":
                commonfunctions.isTextFound(AccountPortalSelectors.textHelloThere,text);
                break;
            case "Priyanshu":
                text="Hi "+text;
                commonfunctions.isTextFound(AccountPortalSelectors.textUsername,text);
                break;
            case "Yes Bank":
                commonfunctions.isTextFound(AccountPortalSelectors.textBankNAme,text);
                break;
            case "Username and password is required.":
                commonfunctions.isTextFound(AccountPortalSelectors.textIncorrectCredentials,text);
                break;


            default:Assert.fail("Failed to find text : "+text);

        }
    }

    @Step("Verify header elements are present on view login history page")
    public void verifyHeaderElementsArePresent(){
        for(int i=1;i<4;i++){
            if(commonfunctions.isElementFound(AccountPortalSelectors.elementsLoginDetails(i))){
                System.out.println($(AccountPortalSelectors.elementsLoginDetails(i)).getText()+" element is found successfully");
            }else {
                Assert.fail("Unable to locate element "+$(AccountPortalSelectors.elementsLoginDetails(i)).getText());
            }
        }

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








}



