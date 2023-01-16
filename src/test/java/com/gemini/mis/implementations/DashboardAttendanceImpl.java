package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.DashboardAttendanceSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardAttendanceImpl extends PageObject {

    //declarations
    private final DashboardAttendanceSelectors ds = new DashboardAttendanceSelectors();
    private final CommonFunctions cf = new CommonFunctions();
    private final static Logger log = LoggerFactory.getLogger("SampleLogger");
    /*-----------------------------------------------------------------------------------------------------------*/

    /*----------------------------FUNCTIONS SPECIFIC TO DASHBOARD ATTENDANCE CARD--------------------------------*/

    public void scrollToCard(String Card) {
        WebElement element = getDriver().findElement(By.xpath("//section[@id='" + Card + "']"));
        cf.scrollToElement(element);
        waitABit(3000);
    }

    public void selectMonthFromDropdown(WebElement Element, String MMMMYYYY) {
        Element.click();
        if (Element.getAttribute("aria-expanded").equals("true")) {
            log.info("Month dropdown menu opened successfully");
            WebElement dropdownItem = getDriver().findElement(By.xpath("//li[@role='treeitem' and text()='" + MMMMYYYY + "']"));
            if (dropdownItem.isDisplayed()) {
                log.info("Required month exists in dropdown menu");
                dropdownItem.click();
                waitABit(5000);
            } else {
                Assert.fail("Required month does not exist in dropdown menu");
            }
        } else {
            Assert.fail("Month dropdown menu not opened");
        }
    }

    public void selectAndVerifyAttendanceMonth(String MMMMYYYY) throws Exception {
        scrollToCard("HealthInsurance");
        selectMonthFromDropdown($(ds.txtAttendanceMonth), "July 2022");
        String[] date = $(ds.txtFirstDate_Attendance).getText().split("\\(");
        String[] actDate = cf.formatDate("dd MMM yyyy", date[0]);
        String[] expDate = cf.formatDate("MMM yyyy", MMMMYYYY);
        if (cf.validateText(actDate[1] + actDate[5], "equals", expDate[1] + expDate[5])) {
            log.info("Required month selected successfully");
        } else {
            Assert.fail("Required month not selected");
        }
    }

    /*----------------------------------------FUNCTIONS COMMON TO MIS--------------------------------------------*/

    public void launchMISBeta() {
        WebDriver driver = getDriver();
        driver.navigate().to("https://mymis.geminisolutions.com/");
        if ($(ds.geminiLogo).isDisplayed() && $(ds.loginMsg).isDisplayed() && $(ds.loginForm).isDisplayed()) {
            log.info("Navigation to MIS beta successful");
        } else {
            Assert.fail("Navigation to MIS beta failed");
        }
    }

    public void loginToMIS(String Username, String Password) {
        $(ds.txtUsername).type(Username);
        $(ds.txtPassword).type(Password);
        waitABit(9000);
        $(ds.btnSignIn).click();
        try {
            waitForLoaderToDisappear();
        } catch (Exception e) {

        }
        waitABit(12000);
        if ($(ds.geminiLogo).isDisplayed() && $(ds.sidebarToggle).isDisplayed() && $(ds.sidebarList).isDisplayed() && $(ds.btnChangePW).isDisplayed() && $(ds.btnuser).isDisplayed()) {
            log.info("Login to MIS successful");
        } else {
            Assert.fail("Login to MIS failed");
        }
    }

    public void waitForLoaderToDisappear() {
        $(ds.loader).waitUntilNotVisible();
    }

    public void optUserMenuAction(String Action) {
        $(ds.btnuser).waitUntilVisible().click();
        // if($(ds.dropdownMenu).isDisplayed())
        if ($(By.xpath("//*[@aria-labelledby=\"dd-user-menu\"]")).isDisplayed()) {
            log.info("Dropdown menu is displayed");
            if (cf.validateText(Action, "equals", "Logout")) {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='" + Action + "']")).click();
                if ($(ds.geminiLogo).isDisplayed() && $(ds.loginMsg).isDisplayed() && $(ds.loginForm).isDisplayed()) {
                    log.info("Logout from MIS successful");
                } else {
                    Assert.fail("Logout from MIS failed");
                }
            } else {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='" + Action + "']")).click();
                waitABit(1000);
                String actionWord = Action.substring(0, 4);
                if ($(By.xpath("//div[@class='modal fade in' and contains(@id,'" + actionWord + "')])")).isDisplayed()) {
                    log.info(Action + " dialog window opened successfully");
                } else {
                    Assert.fail(Action + " dialog window not opened");
                }
            }
        } else {
            Assert.fail("Dropdown menu is not displayed");
        }
    }

    public void navigateToPage(String PageOption) {
        waitABit(1000);
        WebElementFacade Page = $(By.xpath("//ul[@class='side-menu-list']//span[text()='" + PageOption + "']"));
        waitForLoaderToDisappear();
        if (Page.isDisplayed()) {
            log.info(PageOption + " is displayed in side menu list");
            Page.click();
        } else {
            Assert.fail(PageOption + " is not displayed in side menu list");
        }
    }

    public void navigateToPage(String PageOption, String ModuleOption) {
        waitABit(1000);
        WebElementFacade Module = $(By.xpath("//ul[@class='side-menu-list']//span[text()='" + ModuleOption + "']"));
        if (Module.isDisplayed()) {
            log.info(ModuleOption + " is displayed in side menu list");
            Module.click();
            //waitABit(1000);
            WebElementFacade Page = $(By.xpath("//ul[@class='side-menu-list']//span[text()='" + PageOption + "']"));
            waitForLoaderToDisappear();
            if (Page.isDisplayed()) {
                log.info(PageOption + " is displayed in side menu list");
                Page.click();
            } else {
                Assert.fail(PageOption + " is not displayed in side menu list");
            }
        } else {
            Assert.fail(ModuleOption + " is not displayed in side menu list");
        }
    }

    public void verifyPage(String Page, String PageType) {
        //PageType can be "Main" or "Sub"
        waitForLoaderToDisappear();
        String identifier = "";
        String title = "";
        if (StringUtils.equalsIgnoreCase(PageType, "Main")) {
            if (StringUtils.equalsIgnoreCase(Page, "DashboardAttendance")) {
                identifier = "profileContainer";
            }
            if (StringUtils.equalsIgnoreCase(Page, "Employee Directory")) {
                identifier = "EmployeeDirectory";
            }
            if (StringUtils.equalsIgnoreCase(Page, "Organization Structure")) {
                identifier = "orgStructure";
            }
            WebElementFacade myPage = $(By.xpath("(//div[contains(@id,'" + identifier + "')])[1]"));
            if (myPage.isDisplayed()) {
                log.info(Page + " is opened successfully");
            } else {
                Assert.fail(Page + " is not opened");
            }
        } else if (PageType.equalsIgnoreCase("Sub")) {
            if (StringUtils.equalsIgnoreCase(Page, "Configure Timesheet")) {
                title = "Manage Projects";
            }
            if (StringUtils.equalsIgnoreCase(Page, "Create Timesheet")) {
                title = "Create TimeSheet";
            }
            if (StringUtils.equalsIgnoreCase(Page, "Manage Task Template")) {
                title = "Manage Task Templates";
            }
            WebElementFacade myPage = $(By.xpath("//h5[text()='" + title + "']"));
            if (myPage.isDisplayed()) {
                log.info(Page + " is opened successfully");
            } else {
                Assert.fail(Page + " is not opened");
            }
        } else {
            Assert.fail("Page type is not defined. Valid types: Main & Sub");
        }
    }

    public String[] getTableHeads() {
        int cols = getDriver().findElements(ds.tableHeads).size();
        String[] tableHeads = new String[cols];
        for (int i = 0; i < cols; i++) {
            tableHeads[i] = getDriver().findElement(By.xpath("(//table//th)[" + (i + 1) + "]")).getText();
        }
        return tableHeads;
    }

    public void verifyTableData() {
        if ($(ds.tableData).getText().equalsIgnoreCase("No data available in table")) {
            log.info("No data found in the table");
        } else {
            log.info("Following data is present in the table:\n" + $(ds.tableData).getText());
        }
    }

    public void searchTextForNoRecords(String Text) {
        WebElementFacade searchBox = $(ds.txtSearch);
        if (searchBox.isDisplayed()) {
            log.info("Search box displayed");
            searchBox.typeAndEnter(Text);
            if ($(ds.tableData).getText().equalsIgnoreCase("No data available in table")) {
                log.info("Can't perform search.No records present");
            } else {
                Assert.fail("Search failed.");
            }
        } else {
            Assert.fail("Search box not displayed");
        }
    }

    public void searchTextForNonMatchingRecords(String Text) {
        WebElementFacade searchBox = $(ds.txtSearch);
        if (searchBox.isDisplayed()) {
            log.info("Search box displayed");
            searchBox.typeAndEnter(Text);
            if (getDriver().findElement(By.xpath("//tbody//td[text()='No matching records found']")).isDisplayed()) {
                log.info("Invalid search. Searched item not displayed.");
            } else {
                Assert.fail("Search failed.");
            }
        } else {
            Assert.fail("Search box not displayed");
        }
    }

    public void searchTextForMatchingRecords(String Text) {
        WebElementFacade searchBox = $(ds.txtSearch);
        if (searchBox.isDisplayed()) {
            log.info("Search box displayed");
            searchBox.typeAndEnter(Text);
            if (getDriver().findElement(By.xpath("(//tbody//td[text()='" + Text + "'])[1]")).isDisplayed()) {
                log.info("Search successful. Searched item displayed in first row.");
            } else {
                Assert.fail("Search failed.");
            }
        } else {
            Assert.fail("Search box not displayed");
        }
    }

    public void verifyAndAcceptSuccessPopup() {
        waitABit(1000);
        WebElement success = getDriver().findElement(ds.successPopup);
        if ($(ds.successPopup).isDisplayed()) {
            log.info("Success popup displayed");
            waitABit(1000);
            if ($(ds.successIcon).isDisplayed() && $(ds.successMessage).isDisplayed() && $(ds.btnOk).isDisplayed()) {
                log.info("All required elements displayed in success popup");
                $(ds.btnOk).click();
                waitABit(1000);
                if (!($(ds.successPopup).isDisplayed())) {
                    log.info("Success popup accepted");
                } else {
                    Assert.fail("Success popup not accepted");
                }
            } else {
                Assert.fail("All required elements not displayed in success popup");
            }
        } else {
            Assert.fail("Success popup not displayed");
        }
    }

    public void verifyAndAcceptWarningPopup() {
        waitABit(1000);
        WebElement warning = getDriver().findElement(ds.warningPopup);
        if ($(ds.warningPopup).isPresent()) {
            log.info("Warning popup displayed");
            waitABit(1000);
            if ($(ds.warningIcon).isDisplayed() && $(ds.warningMessage).isDisplayed() && $(ds.btnOk).isDisplayed()) {
                log.info("All required elements displayed in warning popup");
                $(ds.btnOk).click();
                waitABit(1000);
                if (!($(ds.warningPopup).isDisplayed())) {
                    log.info("Warning popup accepted");
                } else {
                    Assert.fail("Warning popup not accepted");
                }
            } else {
                Assert.fail("All required elements not displayed in warning popup");
            }
        } else {
            Assert.fail("Warning popup not displayed");
        }
    }

    public void verifyAndAcceptConfirmation() {
        waitABit(1000);
        if ($(ds.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if ($(ds.warningIcon).isDisplayed() && $(ds.confirmationMessage).isDisplayed() && $(ds.btnNo).isDisplayed() && $(ds.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(ds.btnYes).click();
                waitABit(1000);
                verifyAndAcceptSuccessPopup();
            } else {
                Assert.fail("All required elements not displayed in confirmation popup");
            }
        } else {
            Assert.fail("Confirmation popup not displayed");
        }
    }

    public void verifyAndRejectConfirmation() {
        waitABit(1000);
        if ($(ds.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if ($(ds.warningIcon).isDisplayed() && $(ds.confirmationMessage).isDisplayed() && $(ds.btnNo).isDisplayed() && $(ds.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(ds.btnNo).click();
                waitABit(1000);
                if (!($(ds.confirmationPopup).isDisplayed())) {
                    log.info("Confirmation popup rejected");
                } else {
                    Assert.fail("Confirmation popup not rejected");
                }
            } else {
                Assert.fail("All required elements not displayed in confirmation popup");
            }
        } else {
            Assert.fail("Confirmation popup not displayed");
        }
    }

}
