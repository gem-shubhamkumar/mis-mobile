package com.gemini.mis.pages;

import com.gemini.mis.implementations.FeedbackImplementation;
import com.gemini.mis.implementations.MySkillsImplementation;

import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;

public class MySkillsPage {

    MySkillsImplementation skillsImplementation;

    FeedbackImplementation feedbackImplementation;


    @Step("Verify if {0} card is present")
    public void verifyIfCardIsPresent(String cardName) {

         skillsImplementation.verifyIfCardIsPresent(cardName);



     }
     @Step
     public void verifyCardNotEmpty() {
        skillsImplementation.verifyCardNotEmpty();
    }

    @Step("Click on skill {0}")
    public void clickASkill(String skill) {
        skillsImplementation.clickASkill(skill);
    }

    @Step
    public void enterValue(String value) {
        skillsImplementation.enterValue(value);

    }
    @Step
    public void verifyData(String skill, String type, String experience) {
        skillsImplementation.verifyData(skill, type, experience);

    }

    @Step
    public void verifySuccessMessage(String message) {
        skillsImplementation.verifySuccessMessage(message);

    }

    @Step
    public void verifyModal(String modalTitle) {
        skillsImplementation.verifyModalOpen(modalTitle);

    }


    @Step
    public void verifyLoginMsg() {
        skillsImplementation.verifyLoginMsg();

    }


    @Step
    public void enterUsername(String username) {
        skillsImplementation.enterUsername(username);
    }

    @Step
    public void enterPassword(String password) {
        skillsImplementation.enterPassword(password);

    }

    @Step
    public void verifyDashboard() {
        skillsImplementation.verifyDashboard();

    }

    public void clickSignInButton() {
        skillsImplementation.clickSignInButton();

    }


    public void launchUrl(String url) {
        skillsImplementation.launchUrl(url);
    }

    public void clickOnUpdateButton() {
        feedbackImplementation.clickOn(MySkillsLocators.homePageXpath("btnUpdateSkills"));
    }

}
