package com.gemini.mis.pages;

import com.gemini.mis.implementations.AccountPortalImplementation;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import java.util.List;

public class AccountPortalPage extends PageObject {


    AccountPortalImplementation accountImp;

    @Step("User login to my MIS beta successfully")
    public void userLoginToMIS(){
        accountImp.userLoginToMIS();
    }

     //Verify all elements by there heading on greyT HR landing page
    @Step("Verify  elements on greytHR landing page are visible")
    public void verifyLandingPageElementOnGreyTHR(){
        accountImp.verifyGreytHrlandingPageEle();
    }

        //Verify all the element which appear after clicking on View info hyperlink on greyH TR landing page
    @Step("Verify elements are visible after clicking on View my info link")
    public void verifyElementOnViewInfo(){
        accountImp.verifyEleAreAvailableOnViewMyInfo();
    }

      //click on a button
    @Step("Click on {0}")
    public void clickOnElement(String eleName){
        accountImp.clickOnElement(eleName);
    }

      //verify new window tab open in window handles
    @Step("Verify new tab is open in window handle as page heading {0}")
    public void verifyNewWindowTabIsOpen(String heading){
        accountImp.verifyNewWindowTabIsOpen(heading);
    }

       //verify a particular element on currently opened page
    @Step("Verify {0} on current page")
    public void verifyElementOnCurrentPage(String eleName){
        accountImp.verifyElementOnCurrentPage(eleName);
    }

      //Verify a particular text on currently opened page
    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        accountImp.verifyTextPresent(text);
    }

       //Verify all elements are present on login history page on greyT HR landing page
    @Step("Verify header elements are present on view login history page")
    public void verifyHeaderElementsArePresent(){
        accountImp.verifyHeaderElementsArePresent();
    }

       //login  to portals
    @Step("Verify {0} is open and enter username as {1} and password as {2}")
    public void verifyCredentialsEnterInField(String portalName,String username,String password){
        accountImp. verifyCredentialsEnterInField( portalName, username, password);
    }

    @Step("Verify user landed on myMIS portal")
    public void verifyLandingToMyMIS(){
        accountImp.verifyLandingToMyMIS();
    }

///////////////////////////////////////////////////MIS COMMON////////////////////////////////////////////////////////////

    @Step("Compare list data is same or not")
    public void compareListData(List<String> list1, List<String> list2){
        accountImp.compareListData(list1, list2);
    }

    @Step("Click on {0} inside {1}")
    public void navigateToTab(String childTabName, String parentTabName){
        accountImp.navigateToTab(childTabName,parentTabName);
    }

    @Step("Click on {0} tab")
    public void navigateToTab(String parentTabName){
        accountImp.navigateToTab(parentTabName);
    }

    @Step("Verify if {0} element is not visible on current screen")
    public void verifyElementIsNotVisible(String elementName){
        accountImp.verifyElementIsNotVisible(elementName);
    }

    @Step("Verify page title as {0}")
    public void verifyPageTitle(String title){
        accountImp.verifyPageTitle(title);
    }

    @Step("verify appeared message box")
    public void verifyMessageBoxAfterAddingRecord(String message){
        accountImp.verifyMessageBoxAfterAddingRecord(message);
    }
    @Step("click on login button")
    public void hitLogin(){
        accountImp.hitLogin();
    }





}



