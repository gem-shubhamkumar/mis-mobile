package com.gemini.mis.pages;

import com.gemini.mis.implementations.FeedbackImplementation;
import com.gemini.mis.implementations.LNSAImplementation;

import com.gemini.mis.selectors.LNSASelectors;
import net.thucydides.core.annotations.Step;


import java.text.ParseException;


public class LNSAPage {

    LNSAImplementation lnsaImplementation;

    FeedbackImplementation feedbackImplementation;


    @Step
    public void verifyApplyLNSATabOpen() {

        lnsaImplementation.verifyApplyLNSATabOpen();

    }

    @Step

    public void verifyPreviousDateData() throws ParseException {
        lnsaImplementation.verifyPreviousDateData();


    }

    @Step

    public void verifyNextDateData() throws ParseException {
        lnsaImplementation.verifyNextDateData();

    }

    @Step

    public void clickWeekCheckBox() {
        lnsaImplementation.clickWeekCheckbox();
    }

    @Step

    public void verifyWeekActive() {
        lnsaImplementation.verifyWeekActive();

    }

    @Step

    public void enterReason(String reason) {
        lnsaImplementation.enterReason(reason);
    }

    @Step

    public void verifyViewRequestStatusTabOpen() {
        lnsaImplementation.verifyViewRequestStatusTabOpen();
    }

    @Step

    public void clickRow(String row) {
        lnsaImplementation.clickRow(row);


    }

    @Step
    public void verifyOrder(String row, String order) {
        lnsaImplementation.verifyOrder(row, order);

    }



    public void clickStatusButton() {
        feedbackImplementation.clickOn(LNSASelectors.statusButton);
    }

    public void clickCloseButton() {
        feedbackImplementation.clickOn(LNSASelectors.closeModal);
    }
}

