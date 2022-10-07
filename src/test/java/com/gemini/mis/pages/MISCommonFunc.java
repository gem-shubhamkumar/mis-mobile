package com.gemini.mis.pages;

import com.gemini.mis.selectors.MISCommonSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

//Functions specific to MIS
public class MISCommonFunc extends PageObject{

    //declarations
    private final MISCommonSelectors mcs = new MISCommonSelectors();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(MISCommonFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

    public void launchMISBeta() {
        getDriver().navigate().to("https://mymis.geminisolutions.com/");
        if ($(mcs.geminiLogo).isDisplayed() && $(mcs.loginMsg).isDisplayed() && $(mcs.loginForm).isDisplayed()) {
            log.info("Navigation to MIS beta successful");
        } else {
            Assert.fail("Navigation to MIS beta failed");
        }
    }

    public void loginToMIS(String Username, String Password) {
        $(mcs.txtUsername).type(Username);
        $(mcs.txtPassword).type(Password);
        $(mcs.btnSignIn).click();
        waitForLoaderToDisappear();
        if ($(mcs.geminiLogo).isDisplayed() && $(mcs.sidebarToggle).isDisplayed() && $(mcs.sidebarList).isDisplayed()
           && $(mcs.btnChangePW).isDisplayed() && $(mcs.btnuser).isDisplayed()) {
            log.info("Login to MIS successful");
        } else {
            Assert.fail("Login to MIS failed");
        }
    }

    public void waitForLoaderToDisappear() {
        $(mcs.loader).waitUntilNotVisible();
    }

    public void optUserMenuAction(String Action) {
        $(mcs.btnuser).waitUntilVisible().click();
        if($(mcs.dropdownMenu).isDisplayed()) {
            log.info("Dropdown menu is displayed");
            if(cf.validateText(Action, "equals", "Logout")) {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='" + Action + "']")).click();
                if ($(mcs.geminiLogo).isDisplayed() && $(mcs.loginMsg).isDisplayed() && $(mcs.loginForm).isDisplayed()) {
                    log.info("Logout from MIS successful");
                } else {
                    Assert.fail("Logout from MIS failed");
                }
            }else {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='"+Action+"']")).click();
                String[] actionWords = Action.split(" ");
                if (cf.validateText(textContentOf(mcs.dialogWindowHeader), "contains", actionWords[0])) {
                    log.info(Action + " dialog window opened successfully");
                } else {
                    Assert.fail(Action + " dialog window not opened");
                }
            }
        }else {
            Assert.fail("Dropdown menu is not displayed");
        }
    }

    public void navigateToPage(String PageOption) {
        waitABit(1000);
        WebElementFacade Page = $(By.xpath("//ul[@class='side-menu-list']//span[text()='"+PageOption+"']"));
        waitForLoaderToDisappear();
        if(Page.isDisplayed()) {
            log.info(PageOption + " is displayed in side menu list");
            Page.click();
        }else {
            Assert.fail(PageOption + " is not displayed in side menu list");
        }
    }

    public  void navigateToPage(String PageOption, String ModuleOption) {
        waitABit(1000);
        WebElementFacade Module = $(By.xpath("//ul[@class='side-menu-list']//span[text()='"+ModuleOption+"']"));
        if(Module.isDisplayed()) {
            log.info(ModuleOption + " is displayed in side menu list");
            Module.click();
            //waitABit(1000);
            WebElementFacade Page = $(By.xpath("//ul[@class='side-menu-list']//span[text()='"+PageOption+"']"));
            waitForLoaderToDisappear();
            if(Page.isDisplayed()) {
                log.info(PageOption + " is displayed in side menu list");
                Page.click();
            }else {
                Assert.fail(PageOption + " is not displayed in side menu list");
            }
        }else {
            Assert.fail(ModuleOption + " is not displayed in side menu list");
        }
    }

    public void verifyPage(String Page, String PageType) {
    //PageType can be "Main" or "Sub"
        waitForLoaderToDisappear();
        String identifier = "";
        String title = "";
        if(PageType.equalsIgnoreCase("Main")) {
            if (Page.equals("Dashboard")) {
                identifier = "profileContainer";
            }
            if (Page.equals("Employee Directory")) {
                identifier = "EmployeeDirectory";
            }
            if (Page.equals("Organization Structure")) {
                identifier = "orgStructure";
            }
            WebElement myPage = $(By.xpath("(//div[contains(@id,'" + identifier + "')])[1]"));
            if (myPage.isDisplayed()) {
                log.info(Page + " is opened successfully");
            } else {
                Assert.fail(Page + " is not opened");
            }
        }else if(PageType.equalsIgnoreCase("Sub")) {
            if(Page.equals("Configure Timesheet")) {
                title = "Manage Projects";
            }
            if(Page.equals("Create Timesheet")) {
                title = "Create TimeSheet";
            }
            if(Page.equals("Manage Task Template")) {
                title = "Manage Task Templates";
            }
            WebElement myPage = $(By.xpath("//h5[text()='"+title+"']"));
            if(myPage.isDisplayed()) {
                log.info(Page + " is opened successfully");
            }else {
                Assert.fail(Page + " is not opened");
            }
        }else {
            Assert.fail("Page type is not defined. Valid types: Main & Sub");
        }
    }

    public String[] getTableHeads() {
        int cols = getDriver().findElements(mcs.tableHeads).size();
        String[] tableHeads = new String[cols];
        for(int i=0; i<cols; i++) {
            tableHeads[i] = getDriver().findElement(By.xpath("(//table//th)["+(i+1)+"]")).getText();
        }
        return tableHeads;
    }

    public void verifyTableData() {
        if ($(mcs.tableData).getText().equalsIgnoreCase("No data available in table")) {
            log.info("No data found in the table");
        }else {
            log.info("Following data is present in the table:\n" + $(mcs.tableData).getText());
        }
    }

    public void searchTextForNoRecords(String Text) {
        if($(mcs.txtSearch).isDisplayed()) {
            log.info("Search box displayed");
            $(mcs.txtSearch).typeAndEnter(Text);
            if($(mcs.tableData).getText().equalsIgnoreCase("No data available in table")) {
                log.info("Can't perform search.No records present");
            }else {
                Assert.fail("Search failed.");
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    public void searchTextForNonMatchingRecords(String Text) {
        if($(mcs.txtSearch).isDisplayed()) {
            log.info("Search box displayed");
            $(mcs.txtSearch).typeAndEnter(Text);
            if (getDriver().findElement(By.xpath("//tbody//td[text()='No matching records found']")).isDisplayed()) {
                log.info("Invalid search. Searched item not displayed.");
            }else {
                Assert.fail("Search failed.");
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    public void searchTextForMatchingRecords(String Text) {
        if($(mcs.txtSearch).isDisplayed()) {
            log.info("Search box displayed");
            $(mcs.txtSearch).typeAndEnter(Text);
            if (getDriver().findElement(By.xpath("(//tbody//td[text()='" + Text + "'])[1]")).isDisplayed()) {
                log.info("Search successful. Searched item displayed in first row.");
            }else {
                Assert.fail("Search failed.");
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    public void verifyAndAcceptSuccessPopup() {
        waitABit(1000);
        WebElement success = getDriver().findElement(mcs.successPopup);
        if($(mcs.successPopup).isDisplayed()) {
            log.info("Success popup displayed");
            waitABit(1000);
            if($(mcs.successIcon).isDisplayed() && $(mcs.successMessage).isDisplayed() && $(mcs.btnOk).isDisplayed()) {
                log.info("All required elements displayed in success popup");
                $(mcs.btnOk).click();
                waitABit(1000);
                if(!($(mcs.successPopup).isDisplayed())) {
                    log.info("Success popup accepted");
                }else {
                    Assert.fail("Success popup not accepted");
                }
            }else {
                Assert.fail("All required elements not displayed in success popup");
            }
        }else {
            Assert.fail("Success popup not displayed");
        }
    }

    public void verifyAndAcceptWarningPopup() {
        waitABit(1000);
        WebElement warning = getDriver().findElement(mcs.warningPopup);
        if($(mcs.warningPopup).isPresent()) {
            log.info("Warning popup displayed");
            waitABit(1000);
            if($(mcs.warningIcon).isDisplayed() && $(mcs.warningMessage).isDisplayed() && $(mcs.btnOk).isDisplayed()) {
                log.info("All required elements displayed in warning popup");
                $(mcs.btnOk).click();
                waitABit(1000);
                if(!($(mcs.warningPopup).isDisplayed())) {
                    log.info("Warning popup accepted");
                }else {
                    Assert.fail("Warning popup not accepted");
                }
            }else {
                Assert.fail("All required elements not displayed in warning popup");
            }
        }else {
            Assert.fail("Warning popup not displayed");
        }
    }

    public void verifyAndAcceptConfirmation() {
        waitABit(1000);
        if ($(mcs.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if($(mcs.warningIcon).isDisplayed() && $(mcs.confirmationMessage).isDisplayed() && $(mcs.btnNo).isDisplayed() && $(mcs.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(mcs.btnYes).click();
                waitABit(1000);
                verifyAndAcceptSuccessPopup();
            }else {
                Assert.fail("All required elements not displayed in confirmation popup");
            }
        } else {
            Assert.fail("Confirmation popup not displayed");
        }
    }

    public void verifyAndRejectConfirmation() {
        waitABit(1000);
        if ($(mcs.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if($(mcs.warningIcon).isDisplayed() && $(mcs.confirmationMessage).isDisplayed() && $(mcs.btnNo).isDisplayed() && $(mcs.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(mcs.btnNo).click();
                waitABit(1000);
                if(!($(mcs.confirmationPopup).isDisplayed())) {
                    log.info("Confirmation popup rejected");
                }else {
                    Assert.fail("Confirmation popup not rejected");
                }
            }else {
                Assert.fail("All required elements not displayed in confirmation popup");
            }
        } else {
            Assert.fail("Confirmation popup not displayed");
        }
    }

}

