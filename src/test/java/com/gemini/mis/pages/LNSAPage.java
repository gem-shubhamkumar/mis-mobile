package com.gemini.mis.pages;

import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.LNSASelectors;
import com.gemini.mis.selectors.LNSASelectors;
import com.sun.org.apache.xpath.internal.operations.Bool;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class LNSAPage extends PageObject {

    @Step
    public void verifyApplyLNSATabOpen() {
        String heading = $(By.tagName("h5")).getText();

        Assert.assertEquals(heading, "Apply LNSA");
    }

    public void verifyPreviousDateData() throws ParseException {
        waitABit(1500);
        String date = $(By.id("endDate")).getText();
        date = date.replaceAll(" ", "-");
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

        Date endDate = format.parse(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = format.parse(dtf.format(now));

        Assert.assertTrue(nowDate.compareTo(endDate) > 0);



    }

    public void verifyNextDateData() throws ParseException {
        waitABit(1500);
        String date = $(By.id("endDate")).getText();
        date = date.replaceAll(" ", "-");
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

        Date endDate = format.parse(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = format.parse(dtf.format(now));

        Assert.assertTrue(nowDate.compareTo(endDate) < 0);
    }

    public void clickWeekCheckBox() {
        $(By.xpath(LNSASelectors.week)).waitUntilPresent().click();
    }

    public void verifyWeekActive() {
        List<WebElement> days = getDriver().findElements(By.xpath(LNSASelectors.activeDays));
        Boolean flag = false;

        for (WebElement day: days
             ) {
            if(day.getAttribute("class").contains("active") || day.getAttribute("class").contains("empty")) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    public void verifyWarningPopup() {

    }

    public void enterReason(String reason) {
        $(By.id("txtLnsaReason")).type(reason);
    }

    public void verifyViewRequestStatusTabOpen() {
        String heading = $(By.xpath(LNSASelectors.LNSARequest)).getText();

        Assert.assertEquals(heading, "LNSA Request");
    }

    public void clickRow(String row) {

        List<WebElement> rows = getDriver().findElements(By.xpath(LNSASelectors.sortRowLNSA));

        for (WebElement r: rows
             ) {
            if(r.getText().equals(row)) {
                if($(r).getAttribute("aria-sort") == null){
                    $(r).waitUntilPresent().click();
                    $(r).waitUntilPresent().click();
                }
                else {
                    $(r).waitUntilPresent().click();

                }
            }
        }


    }

    public void verifyOrder(String row, String order) {
        List<WebElement> rows = getDriver().findElements(By.xpath(LNSASelectors.sortRowLNSA));

        for (WebElement r: rows
        ) {
            if(r.getText().equals(row)) {
                Assert.assertEquals($(r).getAttribute("aria-sort"), order);
            }
                else {

                }
            }
        }

    }

