package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
    public int totalRow() {
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
    }

    @Step
    public void veifyExportOptions() {
        getDriver().switchTo().activeElement();
        Assert.assertTrue($(By.xpath(FeedbackSelectors.exportOptions)).isPresent());
    }


    @Step
    public void verifyPrintTab(){
        String mainWindow=getDriver().getWindowHandle();
        String mainWindowTittle=getDriver().getCurrentUrl();

        Set<String> windows =getDriver().getWindowHandles();
        Iterator<String> l1=windows.iterator();
        while(l1.hasNext())
        {
            String childWindow=l1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                getDriver().switchTo().window(childWindow);
                waitABit(3000);
                String childWindowTittle=getDriver().getCurrentUrl();
                if (!childWindowTittle.equalsIgnoreCase(mainWindowTittle)){
                    Assert.assertTrue("we are able to print",true);
                    break;
                }else {
                    Assert.fail("we are not able to print");
                }
            }
        }}



    @Step
    public void verifyCopy() {
        getDriver().switchTo().defaultContent();
        Assert.assertEquals($(By.xpath(FeedbackSelectors.copyClipboard)).getText(), "Copy to clipboard");
    }
}
