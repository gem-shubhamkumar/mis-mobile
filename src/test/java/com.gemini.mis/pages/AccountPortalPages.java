package com.gemini.mis.pages;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.selectors.accountPageSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;



public class AccountPortalPages extends PageObject {
    @Steps
    commonMethods commonfunctions;
    
    
    @Step("Verify  elements on greytHR landing page are visible")
    public void verifyGreytHrlandingPageEle(){
            String[] array = {"Payslip","IT Declaration","POI","Track"};
            List<WebElement> listItems = getDriver().findElements(accountPageSelectors.listLandingPageElements);
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
        List<WebElement> listItems = getDriver().findElements(accountPageSelectors.listViewMyInfo);
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
        switch(eleName){
            case "sign in button":
                commonfunctions.clickOn(accountPageSelectors.btnSignIn);
                break;
            case "Log in button":
                commonfunctions. clickOn(accountPageSelectors.btnLogIn);
                break;
            case "View My Info link":
                commonfunctions.clickOn(accountPageSelectors.linkViewMyInfo);
                break;
            case "Accounts & Statutory":
                commonfunctions.clickOn(accountPageSelectors.linkAccountAndStatutory);
                break;
            case "Settings link":
                commonfunctions.clickOn(accountPageSelectors.linkSettings);
                break;
            case "View login history link":
                commonfunctions.clickOn(accountPageSelectors.linkViewLoginHistory);
                break;

            default:Assert.fail("button not found");
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
                commonfunctions.isElementFound(accountPageSelectors.logoGemini);
                break;
            case "greytHR logo":
                commonfunctions.isElementFound(accountPageSelectors.logoGreytHR);
                break;
            case "greytHR username text field":
                commonfunctions.isElementFound(accountPageSelectors.textFieldGreytHRUsername);
                break;
            case "gerytHR password text field":
                commonfunctions.isElementFound(accountPageSelectors.textFieldGreytHRPassword);
                break;
            case "Settings link":
                commonfunctions.isElementFound(accountPageSelectors.linkSettings);
                break;
            case "View login history link":
                commonfunctions.isElementFound(accountPageSelectors.linkViewLoginHistory);
                break;

            default: Assert.fail("failed to locate element with "+eleName);
        }
    }

    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        switch (text){
            case "Hello there!":
                commonfunctions.isTextFound(accountPageSelectors.textHelloThere,text);
                break;
            case "Priyanshu":
                text="Hi "+text;
                commonfunctions.isTextFound(accountPageSelectors.textUsername,text);
                break;
            case "Yes Bank":
                commonfunctions.isTextFound(accountPageSelectors.textBankNAme,text);
                break;
            case "Username and password is required.":
                commonfunctions.isTextFound(accountPageSelectors.textIncorrectCredentials,text);
                break;


            default:Assert.fail("Failed to find text : "+text);

        }
    }

    @Step("Verify header elements are present on view login history page")
    public void verifyHeaderElementsArePresent(){
        for(int i=1;i<4;i++){
            if(commonfunctions.isElementFound(accountPageSelectors.elementsLoginDetails(i))){
                System.out.println($(accountPageSelectors.elementsLoginDetails(i)).getText()+" element is found successfully");
            }else {
                Assert.fail("Unable to locate element "+$(accountPageSelectors.elementsLoginDetails(i)).getText());
            }
        }

    }








}



