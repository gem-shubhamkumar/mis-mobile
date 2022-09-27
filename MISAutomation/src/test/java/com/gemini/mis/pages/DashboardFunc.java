package com.gemini.mis.pages;

import com.gemini.mis.selectors.DashboardSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.ParseException;
import java.util.logging.Logger;

public class DashboardFunc extends PageObject {

    //declarations
    private final DashboardSelectors ds = new DashboardSelectors();
    private final GenericFunc gf = new GenericFunc();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(GenericFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

    public void scrollToCard(String Card) {
        WebElement element = getDriver().findElement(By.xpath("//section[@id='"+Card+"']"));
        cf.scrollToElement(element);
        waitABit(3000);
    }

    public void selectMonthFromDropdown(WebElement Element, String MMMMYYYY) {
        Element.click();
        if(Element.getAttribute("aria-expanded").equals("true")) {
            log.info("Month dropdown menu opened successfully");
            WebElement dropdownItem = getDriver().findElement(By.xpath("//li[@role='treeitem' and text()='"+MMMMYYYY+"']"));
            if(dropdownItem.isDisplayed()) {
                log.info("Required month exists in dropdown menu");
                dropdownItem.click();
                gf.waitForLoaderToDisappear();
            }else {
                Assert.fail("Required month does not exist in dropdown menu");
            }
        }else {
            Assert.fail("Month dropdown menu not opened");
        }
    }

    public void selectAndVerifyAttendanceMonth(String MMMMYYYY) throws ParseException {
        scrollToCard("HealthInsurance");
        selectMonthFromDropdown($(ds.txtAttendenceMonth), "July 2022");
        String[] date = $(ds.txtFirstDate_Attendence).getText().split("\\(");
        String[] act_date = cf.formatDate("dd MMM yyyy", date[0]);
        String[] exp_date = cf.formatDate("MMM yyyy", MMMMYYYY);
        if(cf.validateText(act_date[1]+act_date[5], "equals", exp_date[1]+exp_date[5])) {
            log.info("Required month selected successfully");
        }else {
            Assert.fail("Required month not selected");
        }
    }

}
