package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FeedbackImplementation extends PageObject {

    private final static Logger log = LoggerFactory.getLogger(FeedbackImplementation.class.getName());

    CommonFunctions cf;


    public void verifySubmitFeedbackTabOpen() {
        waitABit(1500);
        String actualHeading = $(By.tagName("h5")).getText();

        boolean equal = StringUtils.equals(actualHeading, "Submit Feedback");

        if (equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Heading: Submit Feedback but Actual Heading is: " + actualHeading);
            log.info("Expected Heading: Submit Feedback but Actual Heading is: " + actualHeading);
        }

    }


    public void enterFeedback(String value) {
        typeInto($(By.id("feedback")), value);

    }


    public void verifyData(String data, String tab) {
        waitABit(1000);
        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback": {
                tableRow = getDriver().findElements(FeedbackSelectors.tableRow("tblFeedback"));
                break;
            }
            case "LNSA": {
                tableRow = getDriver().findElements(FeedbackSelectors.tableRow("tblLnsaStatusGrid"));
                break;
            }
        }
        for (WebElement row : tableRow
        ) {
            if (StringUtils.contains(row.getText(), data)) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) Assert.assertTrue("Record found", true);
        else {
            Assert.fail("Record not found");
            log.info("Record not found");
        }
    }


    public void verifyData(String tab) {

        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback": {
                tableRow = getDriver().findElements(FeedbackSelectors.tableRow("tblFeedback"));
                break;
            }
            case "LNSA": {
                tableRow = getDriver().findElements(FeedbackSelectors.tableRow("tblLnsaStatusGrid"));
                break;
            }
        }
        for (WebElement row : tableRow
        ) {
            if (StringUtils.contains(row.getText(), "No matching records found")) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) Assert.assertTrue("Record not found", true);
        else {
            Assert.fail("Record found");
            log.info("Record found");
        }

    }


    public void searchData(String dataToBeSearch) {
        typeInto($(FeedbackSelectors.search), dataToBeSearch);

    }


    public void clickRow() {
        if ($(FeedbackSelectors.sortRow).getAttribute("aria-sort") == null) {

            clickOn(FeedbackSelectors.sortRow);
            clickOn(FeedbackSelectors.sortRow);

        } else {
            clickOn(FeedbackSelectors.sortRow);

        }
    }


    public void verifyOrder(String order) {
        String actualSortOrder = $(FeedbackSelectors.sortRow).getAttribute("aria-sort");
        boolean sort = StringUtils.equals(actualSortOrder, order);
        if (sort) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Sort Order: " + order + " but Actual Sort Order is: " + actualSortOrder);
            log.info("Expected Sort Order: " + order + " but Actual Sort Order is: " + actualSortOrder);
        }
    }


    public int getTotalRow() {
        return getDriver().findElements(FeedbackSelectors.tableRow("tblFeedback")).size();

    }


    public void hoverOver() {
        moveTo(FeedbackSelectors.viewButton(Integer.toString(getTotalRow())));

    }


    public void tooltipText(String text) {
        String actualText = $(FeedbackSelectors.tooltip).getText();
        boolean equal = StringUtils.equals(actualText, text);
        if (equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Tooltip Text: " + text + " but Actual Tooltip Text is: " + actualText);
            log.info("Expected Tooltip Text: " + text + " but Actual Tooltip Text is: " + actualText);
        }

    }


    public void verifyMessage(String message) {
        boolean disbale = $(By.id("feedbackMessage")).isDisabled();
        if (disbale) Assert.assertTrue(true);
        else {
            Assert.fail("Feedback textarea is not disabled");
            log.info("Feedback textarea is not disabled");
        }

    }


    public void verifyExportOptions() {
        getDriver().switchTo().activeElement();
        boolean present = $(FeedbackSelectors.exportOptions).isPresent();
        if (present) Assert.assertTrue(true);
        else {
            Assert.fail("Export Options are not present");
            log.info("Export Options are not present");

        }

    }


    public void verifyPrintTab() {
        waitABit(2000);
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(1));
        System.out.println(getTitle());
        Assert.assertTrue(StringUtils.contains(getTitle(), "Gemini"));
        getDriver().switchTo().window(browserTabs.get(2));
        waitABit(3000);
        getDriver().close();
        getDriver().switchTo().window(parentWindowHandle);
    }


    public void verifyCopy() {

        String actualText = $(FeedbackSelectors.copyClipboard).getText();
        boolean equal = StringUtils.equals(actualText, "Copy to clipboard");
        if (equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Text: Copy to clipboard but Actual Tooltip Text is: " + actualText);
            log.info("Expected Text: Copy to clipboard but Actual Tooltip Text is: " + actualText);
        }

    }

    public static String parentWindowHandle;

    public void clickOn(By elementName) {
        parentWindowHandle = getDriver().getWindowHandle();
        WebElementFacade element = find(elementName);
        waitABit(3000);
        if (element.isDisplayed()) {
            element.click();
            Assert.assertTrue("Clicked on button successfully", true);
        } else {
            Assert.fail("Unable to click on button: " + element);
            log.info("Unable to click on button: " + element);
        }
    }

    public void clickButton(String buttonName) {
        if (StringUtils.equals("Submit", buttonName)) {
            waitABit(3000);
            clickOn(FeedbackSelectors.submitButton("2"));
        } else if (StringUtils.equals("previous date", buttonName))
            if (!StringUtils.equals($(By.id("btnPreviousMonth")).getAttribute("disabled"), "disabled"))
                clickOn(By.id("btnPreviousMonth"));
            else if (StringUtils.equals("next date", buttonName))
                if (!StringUtils.equals($(By.id("btnNextMonth")).getAttribute("disabled"), "disabled"))
                    clickOn(By.id("btnNextMonth"));
                else if (StringUtils.equals("Submit Reason", buttonName))
                    clickOn(FeedbackSelectors.submitButton("3"));
                else {
                    Assert.fail("Button " + buttonName + " not found");
                    log.info("Button " + buttonName + " not found");
                }

    }


    public void verifyCardMinimized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(MySkillsLocators.collapsedCard);

        for (WebElement card : cards
        ) {
            if (card.getText().equals(cardName)) flag = 1;
        }

        if (flag == 1) Assert.assertTrue(true);
        else {
            Assert.fail("Card " + cardName + " is not minimized");
            log.info("Card " + cardName + " is not minimized");

        }
    }


    public void verifyCardMaximized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(MySkillsLocators.fullScreenCard);

        for (WebElement card : cards
        ) {
            if (card.getText().equals(cardName)) flag = 1;
        }

        if (flag == 1) Assert.assertTrue(true);
        else {
            Assert.fail("Card " + cardName + " is not maximized");
            log.info("Card " + cardName + " is not maximized");

        }
    }


    public void verifyError(String inputType) {
        if (StringUtils.equals("skill", inputType))
            Assert.assertTrue($(MySkillsLocators.errorType("ddlSkillTypeEdit")).isPresent());
        else if (StringUtils.equals("experience", inputType))
            Assert.assertTrue($(MySkillsLocators.errorType("expinMonthsEdit")).isPresent());
        else if (StringUtils.equals("Submit Feedback", inputType))
            Assert.assertTrue($(MySkillsLocators.errorType("feedback")).isPresent());
        else if (StringUtils.equals("Reason", inputType))
            Assert.assertTrue($(MySkillsLocators.errorType("txtLnsaReason")).isPresent());
        else if (StringUtils.equals("remarks", inputType))
            Assert.assertTrue($(MySkillsLocators.errorType("remarks")).isPresent());
        else {
            Assert.fail("Input " + inputType + " not found");
            log.info("Input " + inputType + " not found");

        }

    }


    public void selectValue(String id, String value, String attribute, String tab) {
        switch (tab) {
            case "Feedback": {
                By xpath = MySkillsLocators.select(attribute, "tblFeedback_length");
                selectFromDropdown($(xpath).getElement(), value);
                break;
            }
            case "LNSA": {
                By xpath = MySkillsLocators.select(attribute, "tblLnsaStatusGrid_length");

                selectFromDropdown($(xpath).getElement(), value);
                break;
            }
            case "": {
                By xpath = MySkillsLocators.select(attribute, id);

                selectFromDropdown($(xpath).getElement(), value);
                break;

            }
            default: {
                Assert.fail("Tab " + tab + " not found");
                log.info("Tab " + tab + " not found");

            }
        }
    }


    public void verifyRows(int number) {
        int tableRow = getDriver().findElements(FeedbackSelectors.tableRow("tblFeedback")).size();
        boolean equal = number == tableRow || tableRow < number;
        if (equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Rows: " + number + " but Actual Tooltip Text is: " + tableRow);
            log.info("Expected Rows: " + number + " but Actual Tooltip Text is: " + tableRow);

        }

    }


    public void navigateToTab(String childTabName, String parentTabName) {
        waitABit(3000);
        if ($(MySkillsLocators.sideNav(parentTabName)).isPresent()) {

            // added by shubham.kumar
            if (cf.getDriverType().equalsIgnoreCase("Appium")) {
                // clicks on hamburger-menu button
                clickOn(By.xpath("//button[contains(@class,'hamburger')]"));
            }

            clickOn(MySkillsLocators.sideNav(parentTabName));

            waitABit(2000);
            if ($(MySkillsLocators.sideNav(childTabName)).isPresent()) {
                if (StringUtils.equals("View Request Status", childTabName)) {
                    clickOn(MySkillsLocators.viewStatusRequestTab);

                } else {
                    clickOn(MySkillsLocators.sideNav(childTabName));
                }
            } else {
                Assert.fail("Unable to locate child tab: " + childTabName);
                log.info("Unable to locate child tab: " + childTabName);
            }

        } else {
            Assert.fail("Unable to locate parent tab: " + parentTabName);
        }
    }


    public void navigateToTab(String parentTabName) {
        waitABit(3000);
        if ($(MySkillsLocators.sideNav(parentTabName)).isPresent()) {
            clickOn(MySkillsLocators.sideNav(parentTabName));

        } else {
            Assert.fail("Unable to locate parent tab: " + parentTabName);
            log.info("Unable to locate parent tab: " + parentTabName);
        }
    }

}
