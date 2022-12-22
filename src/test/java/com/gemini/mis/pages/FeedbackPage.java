package com.gemini.mis.pages;

import com.gemini.mis.implementations.FeedbackImplementation;

import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;


public class FeedbackPage {

    FeedbackImplementation feedbackImplementation;

    @Step
    public void verifySubmitFeedbackTabOpen() {

        feedbackImplementation.verifySubmitFeedbackTabOpen();

    }

    @Step
    public void enterFeedback(String value) {
        feedbackImplementation.enterFeedback(value);
    }

    @Step("Verify No matching records found")
    public void verifyData( String data, String tab) {
        feedbackImplementation.verifyData(data, tab);

    }

    @Step
    public void verifyData(String tab) {
        feedbackImplementation.verifyData(tab);

    }

    @Step
    public void searchData(String dataToBeSearch) {
        feedbackImplementation.searchData(dataToBeSearch);
    }


    @Step
    public void clickRow() {
        feedbackImplementation.clickRow();

    }

    @Step
    public void verifyOrder(String order) {
        feedbackImplementation.verifyOrder(order);
    }


    private int totalRow() {
        return feedbackImplementation.getTotalRow();
    }

    @Step
    public void hoverOverView() {
        feedbackImplementation.hoverOver();

    }

    @Step
    public void tooltipText(String text) {
        feedbackImplementation.tooltipText(text);
    }

    @Step
    public void verifyMessage(String message) {
        feedbackImplementation.verifyMessage(message);
    }

    @Step
    public void veifyExportOptions() {
        feedbackImplementation.verifyExportOptions();
    }


    @Step
    public void verifyPrintTab() {
        feedbackImplementation.verifyPrintTab();
    }

    @Step
    public void verifyCopy() {
        feedbackImplementation.verifyCopy();
    }

    @Step
    public void clickButton(String buttonName) {
        feedbackImplementation.clickButton(buttonName);

    }

    @Step
    public void verifyCardMinimized(String cardName) {
        feedbackImplementation.verifyCardMinimized(cardName);


    }

    @Step
    public void verifyCardMaximized(String cardName) {
        feedbackImplementation.verifyCardMaximized(cardName);


    }

    @Step
    public void verifyForError(String inputType) {
        feedbackImplementation.verifyError(inputType);

    }

    @Step
    public void selectValue(String id, String value, String attribute, String tab) {
        feedbackImplementation.selectValue(id, value, attribute, tab);

    }


    @Step
    public void verifyRows(int number) {
        feedbackImplementation.verifyRows(number);

    }

    @Step
    public void navigateToTab(String childTabName, String parentTabName) {
        feedbackImplementation.navigateToTab(childTabName, parentTabName);

    }

    @Step
    public void navigateToTab(String parentTabName){
        feedbackImplementation.navigateToTab(parentTabName);

    }

    public void clickOnProvideFeedbackButton() {
        feedbackImplementation.clickOn(FeedbackSelectors.provideFeedbackButton);
    }

    public void clickExportButtons(String button) {
        feedbackImplementation.clickOn(FeedbackSelectors.export(button));
    }

    public void clickPaginationButtons(String button) {
        feedbackImplementation.clickOn(MySkillsLocators.paginationButtons(button));
    }

    public void clickOnViewButton() {
        feedbackImplementation.clickOn(FeedbackSelectors.viewButton(Integer.toString(feedbackImplementation.getTotalRow())));
    }
}
