package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

    public void verifyData( String data) {
        int flag = 0;
        List<WebElement> tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
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

    public void verifyData() {
        int flag = 0;
        List<WebElement> tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
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

    public void searchData(String dataToBeSearch) {
        $(By.xpath(FeedbackSelectors.search)).type(dataToBeSearch);
    }

    public void syncWithLatestPage() {

    }
}
