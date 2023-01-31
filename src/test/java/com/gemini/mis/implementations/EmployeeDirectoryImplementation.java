package com.gemini.mis.implementations;

import com.gemini.mis.selectors.EmployeeDirectoryPOM;
import com.gemini.mis.selectors.MISPOM;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDirectoryImplementation extends PageObject {

    static final Logger logger = LoggerFactory.getLogger("SampleLogger");

    //Validate page download
    public void verifyPageDownloaded() {

        waitABit(9000);

        // added by shubham.kumar
        Boolean isHeadingVisible = $$(MISPOM.genericPath("Employee Directory")).get(1).isVisible();


//            Boolean isHeadingVisible=$(MISPOM.genericPath("Employee Directory")).isVisible();
        Boolean isElementsVisible = $(EmployeeDirectoryPOM.firstRow).isVisible();
        if (isHeadingVisible && isElementsVisible) {
            Assert.assertTrue("the page is loaded successfully", true);
        } else {
            Assert.fail("the was not page loaded successfully");
            logger.info("the was not page loaded successfully");
        }
    }
    //Open mail

    public void mailClick() {
        waitABit(7000);
        WebElementFacade firstRow = find(EmployeeDirectoryPOM.firstRow);
        //waitFor(firstRow);
        clickOn(firstRow);
        boolean mailCheck = $(EmployeeDirectoryPOM.mailBox).isClickable();
        if (mailCheck) {
            Assert.assertTrue("The mail is visible/ clickable", true);
        } else {
            Assert.fail("The mail is not visible/clickable");
            logger.info("The mail is not visible/clickable");
        }
    }
    //Verify profile window

    public void verifyProfileWindow() {
        waitABit(5000);
        String employeeName = $(EmployeeDirectoryPOM.firstRow).getText();
        $(EmployeeDirectoryPOM.firstRow).click();
        waitABit(1000);
        Boolean isProfileVisible = $(EmployeeDirectoryPOM.ProfileWindow).isVisible();

        if (employeeName.equals("Aakash Gupta") && isProfileVisible) {
            Assert.assertTrue("We are able to se the profile window", true);
        } else {
            Assert.fail("We are unable to locate the profile window");
            logger.info("We are unable to locate the profile window");
        }
    }
}


