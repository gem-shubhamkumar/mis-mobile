package com.gemini.mis.pages;

import com.gemini.mis.implementations.ApplyToAnyCardImplementation;
import net.thucydides.core.annotations.Step;


public class ApplyToAnyCardPages {

    ApplyToAnyCardImplementation applyToAnyCardImplementation;

    @Step("Step to login into the website")
    public void launchURL(String s){
        applyToAnyCardImplementation.launchURL(s);
    }

    @Step("Verify login messaage")
    public void verifyLoginMsg() {
        applyToAnyCardImplementation.veirfyLoginMsg();
    }

    @Step("Enter username into respective input field")
    public void enterUsername(String username) {
        applyToAnyCardImplementation.enterUsername(username);
    }

    @Step("Enter password into respective input field")
    public void enterPassword(String password) {
        applyToAnyCardImplementation.enterPassword(password);
    }

    @Step("Click on the button")
    public void clickButton(String buttonName) {
        applyToAnyCardImplementation.clickButton(buttonName);
    }

    @Step("Clikc on maximize or minimize button on specified card")
    public void clickButton(String buttonName, String cardName) {
       applyToAnyCardImplementation.clickButton(buttonName,cardName);
    }

    @Step("Verify that dashboard is present and logo is present")
    public void verifyDashboard() {
        applyToAnyCardImplementation.verifyDashboard();
    }

    @Step("Verify if {0} card is minimized")
    public void verifyCardMinimized(String cardName) {
    applyToAnyCardImplementation.verifyCardMinimized(cardName);
    }

    @Step("Verify if {0} card is maximized")
    public void verifyCardMaximized(String cardName) {
       applyToAnyCardImplementation.verifyCardMaximized(cardName);
    }


     @Step("Verify if {0} card is present")
    public void verifyIfCardIsPresent(String cardName) {
         applyToAnyCardImplementation.verifyIfCardPresent(cardName);
     }
}
