package com.gemini.mis.implementations;

import com.gemini.mis.selectors.LNSASelectors;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

 public class LNSAImplementation extends PageObject {

     FeedbackImplementation feedbackImplementation;

     private final static Logger log = LoggerFactory.getLogger(LNSAImplementation.class.getName());
    
    public void verifyApplyLNSATabOpen() {
        String actualHeading = $(By.tagName("h5")).getText();

        boolean equal = StringUtils.equals(actualHeading, "Apply LNSA");

        if(equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Heading: Apply LNSA but Actual Heading is: " + actualHeading);
            log.info("Expected Heading: Apply LNSA but Actual Heading is: " + actualHeading);
        }
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

        boolean equal = nowDate.compareTo(endDate) > 0;

        if(equal) Assert.assertTrue(true);
        else {
            Assert.fail("Today Date is: "+ nowDate + " and expected date is: " + endDate);
            log.info("Today Date is: "+ nowDate + " and expected date is: " + endDate);

        }
    }

    
    public void verifyNextDateData() throws ParseException {
        // added by shubham.kumar
        waitABit(5000);
//        waitABit(1500);
        String date = $(By.id("endDate")).getText();
        date = date.replaceAll(" ", "-");
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");

        Date endDate = format.parse(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        Date nowDate = format.parse(dtf.format(now));

        boolean equal = nowDate.compareTo(endDate) < 0;

        if(equal) Assert.assertTrue(true);
        else {
            Assert.fail("Today Date is: "+ nowDate + " and expected date is: " + endDate);
            log.info("Today Date is: "+ nowDate + " and expected date is: " + endDate);

        }
    }

    



    public void clickWeekCheckbox() {
        feedbackImplementation.clickOn(LNSASelectors.week);

    }


     public void verifyWeekActive() {
         List<WebElement> days = getDriver().findElements(LNSASelectors.activeDays);
         boolean flag = true;
         for (WebElement day: days
         ) {
             if(StringUtils.contains(day.getAttribute("class"), "lnsaApplied")) {
                 flag = false;
             }
         }
         if(flag) Assert.assertTrue(true);
         else {
             Assert.fail("Week is not active");
             log.info("Week is not active");
         }
     }

    
    public void enterReason(String reason) {
        typeInto($(By.id("txtLnsaReason")), reason);

    }

    
    public void verifyViewRequestStatusTabOpen() {
        String actualHeading = $(LNSASelectors.LNSARequest).getText();

        boolean equal = StringUtils.equals(actualHeading, "LNSA Request");

        if(equal) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Heading: LNSA Request but Actual Heading is: " + actualHeading);
            log.info("Expected Heading: LNSA Request but Actual Heading is: " + actualHeading);
        }

    }


    
    public void clickRow(String row) {
        List<WebElement> rows = getDriver().findElements(LNSASelectors.sortRowLNSA);

        for (WebElement r: rows
        ) {
            if(r.getText().equals(row)) {
                if($(r).getAttribute("aria-sort") == null){
                    feedbackImplementation.clickOn(r);
                    feedbackImplementation.clickOn(r);
                }
                else {
                    feedbackImplementation.clickOn(r);

                }
            }
        }
    }

    
    public void verifyOrder(String row, String order) {
        List<WebElement> rows = getDriver().findElements(LNSASelectors.sortRowLNSA);
        boolean flag = false;
        String actualSortOrder = "";

        for (WebElement r: rows
        ) {
            if(r.getText().equals(row)) {
                 actualSortOrder = $(r).getAttribute("aria-sort");
                flag = StringUtils.equals(actualSortOrder, order);
                if(flag) break;
            }

        }
        if(flag) Assert.assertTrue(true);
        else {
            Assert.fail("Expected Sort Order: " + order + " but Actual Sort Order is: " + actualSortOrder);
            log.info("Expected Sort Order: " + order + " but Actual Sort Order is: " + actualSortOrder);
        }
    }
    
}
