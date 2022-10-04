package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.LNSASelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FeedbackPage extends PageObject {


    @Step
    public void verifySubmitFeedbackTabOpen() {
        String heading = $(By.tagName("h5")).getText();

        Assert.assertTrue(StringUtils.equals(heading, "Submit Feedback"));
    }

    @Step
    public void enterFeedback(String value) {
        $(By.id("feedback")).type(value);
    }

    @Step
    public void verifyData( String data, String tab) {
        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback" : {
                 tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
                    break;
            }
            case "LNSA" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblLnsaStatusGrid")));
                    break;
            }
        }
        for (WebElement row: tableRow
        ) {
            if(row.getText().contains(data)) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) Assert.assertTrue("Record found", true);
        else Assert.fail("Record not found");
    }

    @Step("Verify No matching records found")
    public void verifyData(String tab) {
        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
                break;
            }
            case "LNSA" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblLnsaStatusGrid")));
                break;
            }
        }
        for (WebElement row: tableRow
        ) {
            if(row.getText().contains("No matching records found")) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) Assert.assertTrue("Record not found", true);
        else Assert.fail("Record found");
    }

    @Step
    public void searchData(String dataToBeSearch) {
        $(By.xpath(FeedbackSelectors.search)).type(dataToBeSearch);
    }

    @Step
    public void clickRow() {
        if($(By.xpath(FeedbackSelectors.sortRow)).getAttribute("aria-sort") == null){
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();
        }
        else {
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();

        }

    }
    @Step
    public void verifyOrder(String order) {
        Assert.assertEquals($(By.xpath(FeedbackSelectors.sortRow)).getAttribute("aria-sort"), order);
    }
    @Step
    private int totalRow() {
        return getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback"))).size();

    }

    @Step
    public void hoverOverView() {

        moveTo(By.xpath(FeedbackSelectors.viewButton.replace("size", Integer.toString(totalRow()))));
    }

    @Step
    public void tooltipText(String text) {
        Assert.assertEquals($(By.xpath(FeedbackSelectors.tooltip)).getText(), text);
    }

    @Step
    public void verifyMessage(String message) {
        Assert.assertTrue($(By.id("feedbackMessage")).isDisabled());
        Assert.assertEquals($(By.id("feedbackMessage")).getAttribute("value"), message);
        waitFor(ExpectedConditions.presenceOfElementLocated(By.xpath(CommonSelectors.sideNav)));
    }

    @Step
    public void veifyExportOptions() {
        getDriver().switchTo().activeElement();
        Assert.assertTrue($(By.xpath(FeedbackSelectors.exportOptions)).isPresent());
    }


    @Step
    public void verifyPrintTab() {
        List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());

        getDriver().switchTo().window(browserTabs.get(1));
        System.out.println(getTitle());
        Assert.assertTrue(getTitle().contains("Gemini"));
        withAction().sendKeys(Keys.TAB).build().perform();
        withAction().sendKeys(Keys.ENTER).build().perform();
        getDriver().switchTo().window(browserTabs.get(0));
    }

    @Step
    public void verifyCopy() {
        getDriver().switchTo().defaultContent();
        Assert.assertEquals($(By.xpath(FeedbackSelectors.copyClipboard)).getText(), "Copy to clipboard");
    }

    @Step
    public void clickButton(String buttonName) {
        waitABit(3000);
        switch(buttonName) {
            case "Sign In": {
                $(By.xpath(CommonSelectors.homePageXpath.replace("name", "btnLogin"))).waitUntilPresent().click();
                break;
            }

            case "update" : {
                $(By.xpath(MySkillsLocators.genericButton.replace("ids", "btnUpdateSkills"))).waitUntilPresent().click();
                break;
            }

            case "Provide Feedback": {
                $(By.xpath(FeedbackSelectors.provideFeedbackButton)).waitUntilPresent().click();
                break;
            }
            case "Submit": {
                $(By.xpath(FeedbackSelectors.submitButton)).waitUntilPresent().click();
                break;
            }

            case "next" :
            case "Previous" : {
                while(!$(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).getAttribute("class").contains("disabled")) {
                    $(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).waitUntilPresent().click();
                }
                break;
            }

            case "View" : {
                $(By.xpath(FeedbackSelectors.viewButton.replace("size", Integer.toString(totalRow())))).waitUntilPresent().click();
                break;
            }

            case "Copy" :
            case "Print" :
            case "PDF" :
            case "Excel" :
            case "Export" : {
                $(By.xpath(FeedbackSelectors.export.replace("name", buttonName))).waitUntilPresent().click();
                break;
            }

            case "previous date" : {
                $(By.id("btnPreviousMonth")).waitUntilPresent().click();
                break;
            }

            case "next date" : {
                $(By.id("btnNextMonth")).waitUntilPresent().click();
                break;
            }

            case "Close" : {
                $(By.xpath(LNSASelectors.closeModal)).waitUntilPresent().click();
                break;
            }
            case "Submit Reason": {
                $(By.xpath(FeedbackSelectors.submitButton.replace("2", "3"))).waitUntilPresent().click();
                break;
            }
            case "status": {
                $(By.xpath(LNSASelectors.statusButton)).waitUntilPresent().click();
                break;
            }

            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }
    @Step
    public void clickButton(String buttonName, String cardName) {
        waitABit(1000);
        switch(buttonName) {
            case "Maximize": {
                $(By.xpath(CommonSelectors.cardToggleMaximize.replace("card", cardName))).waitUntilPresent().click();
                break;

            }
            case "Minimize" : {
                String xpath = CommonSelectors.cardToggleMinimize.replace("card", cardName);
                xpath = xpath.replace("buttonName", buttonName);
                $(By.xpath(xpath)).waitUntilPresent().click();
                break;
            }


            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }

    @Step
    public void verifyCardMinimized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.collapsedCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not minimized");

    }
    @Step
    public void verifyCardMaximized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.fullScreenCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not maximized");

    }

    @Step
    public void verifyForError(String inputType) {
        switch (inputType) {
            case "skill": {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "ddlSkillTypeEdit"))).isPresent());
                break;
            }

            case "experience" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "expinMonthsEdit");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Submit Feedback" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "feedback");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Reason" : {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "txtLnsaReason"))).isPresent());
                break;
            }
            case "remarks" : {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "remarks"))).isPresent());
                break;
            }
            default: {
                Assert.fail("Input " + inputType + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute, String tab) {
        switch (tab) {
            case "Feedback" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblFeedback_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            case "LNSA" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblLnsaStatusGrid_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            default: {
                Assert.fail("Tab " + tab + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute) {
        String xpath = CommonSelectors.select.replace("attribute", attribute);
        xpath = xpath.replace("value", id);

        selectFromDropdown($(By.xpath(xpath)).getElement(), value);
    }

    @Step
    public void verifyRows(int number) {
        int tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback"))).size();
        Assert.assertTrue(number == tableRow || tableRow < number);
    }

}
