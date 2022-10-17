package com.gemini.mis.implementations;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPageImplementations extends PageObject {

    static final Logger log = LoggerFactory.getLogger("SampleLogger");



    public void selectAllAndDelete(By ele){
        waitABit(1500);
        $(ele).sendKeys(Keys.CONTROL, "A");
        $(ele).sendKeys(Keys.DELETE);
    }

    public void verifyHighlightedField(By Loc){
        waitABit(1500);
        String fun = $(Loc).getAttribute("class");
        if (fun.contains("error-validation")) {
            Assert.assertTrue("Error box highlighted is present", true);
        } else {
            Assert.fail("Error box highlighted is not present");
            log.info("Error box highlighted is not present");
        }
    }

}
