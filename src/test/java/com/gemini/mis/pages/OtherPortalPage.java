package com.gemini.mis.pages;

import com.gemini.mis.implementations.LoginFunctionImplementation;
import com.gemini.mis.implementations.OtherPortalsImplementation;
import net.thucydides.core.annotations.Step;

public class OtherPortalPage {

    OtherPortalsImplementation otherPortalImplement;
    LoginFunctionImplementation loginFunctionImplement;

    //Validate hyperlink
    @Step("Click on other portals hyperlink and validate that the hyperlink is able to open the web page")
    public void validateOtherPortal(String subsScreen) {
        otherPortalImplement.validateOtherPortal(subsScreen);
    }

    //verify the text "No record Found"
    @Step("Verify if there is no record found text found")
    public void noRecordFoundWhileSearch(String Value) {
        otherPortalImplement.noRecordFoundWhileSearch(Value);
    }

    //all the generic button of MIS
    @Step("Click on required button")
    public void clickOnButton(String buttonName) {
        otherPortalImplement.clickOnButton(buttonName);
    }

    // validate number of entries present
    @Step("Click and validate selection of a new entry number in entry drop down")
    public void selectNoOfEntry() {
        otherPortalImplement.selectNoOfEntry();
    }

    // validate search functionality
    @Step("Verify search is working as expected")
    public void verifySearch(String value) {
        otherPortalImplement.verifySearch(value);
    }

    //launch My MIS application
    @Step("Launch My MIS application ")
    public void launchPage() {
        loginFunctionImplement.launchPage();

    }

    //Verify if user is able to see the login message
    @Step("verify login message")
    public void verifyLoginMsg() {
        loginFunctionImplement.verifyLoginMsg();
    }

    //enter username and password
    @Step("enter username for login")
    public void enterUsername(String username) {
        loginFunctionImplement.enterUsername(username);
    }

    //enter username and password
    @Step("enter password for login")
    public void enterPassword(String password) {
        loginFunctionImplement.enterPassword(password);
    }

    //click button functionality
    @Step("Click on button for login")
    public void clickButton(String buttonName) {
        loginFunctionImplement.clickButton(buttonName);
    }

    //navigation to main screen and sub screen tab
    @Step("Navigate to parent tab and child tab")
    public void navigateToTab(String parentTabName, String childTabName) {
        otherPortalImplement.navigateToTab(parentTabName, childTabName);
    }

    //navigate to main tab
    @Step("Navigate to main tab")
    public void navigateToTab(String parentTabName) {
        otherPortalImplement.navigateToTab(parentTabName);
    }
}
