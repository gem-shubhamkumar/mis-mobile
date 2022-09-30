package com.gemini.mis.pages;

import com.gemini.mis.selectors.GenericSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

//Functions specific to MIS
public class GenericFunc extends PageObject{

    //declarations
    private final GenericSelectors gs = new GenericSelectors();
    private final CommonFunc cf = new CommonFunc();
    private final static Logger log = Logger.getLogger(GenericFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

    public void launchMISBeta() {
        getDriver().navigate().to("https://mymis.geminisolutions.com/");
        if ($(gs.geminiLogo).isDisplayed() && $(gs.loginMsg).isDisplayed() && $(gs.loginForm).isDisplayed()) {
            log.info("Navigation to MIS beta successful");
        } else {
            Assert.fail("Navigation to MIS beta failed");
        }
    }

    public void loginToMIS(String Username, String Password) {
        $(gs.txtUsername).type(Username);
        $(gs.txtPassword).type(Password);
        $(gs.btnSignIn).click();
        waitForLoaderToDisappear();
        if ($(gs.geminiLogo).isDisplayed() && $(gs.sidebarToggle).isDisplayed() && $(gs.sidebarList).isDisplayed() && $(gs.btnChangePW).isDisplayed() && $(gs.btnuser).isDisplayed()) {
            log.info("Login to MIS successful");
        } else {
            Assert.fail("Login to MIS failed");
        }
    }

    public void waitForLoaderToDisappear() {
        $(gs.loader).waitUntilNotVisible();
    }

    public void optUserMenuAction(String Action) {
        $(gs.btnuser).waitUntilVisible().click();
        if($(gs.dropdownMenu).isDisplayed()) {
            log.info("Dropdown menu is displayed");
            if(cf.validateText(Action, "equals", "Logout")) {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='" + Action + "']")).click();
                if ($(gs.geminiLogo).isDisplayed() && $(gs.loginMsg).isDisplayed() && $(gs.loginForm).isDisplayed()) {
                    log.info("Logout from MIS successful");
                } else {
                    Assert.fail("Logout from MIS failed");
                }
            }else {
                $(By.xpath("//div[contains(@class,'dropdown-menu')]//a[text()='"+Action+"']")).click();
                String[] actionWords = Action.split(" ");
                if (cf.validateText(textContentOf(gs.dialogWindowHeader), "contains", actionWords[0])) {
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
            waitABit(1000);
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
        int cols = getDriver().findElements(gs.tableHeads).size();
        String[] tableHeads = new String[cols];
        for(int i=0; i<cols; i++) {
            tableHeads[i] = getDriver().findElement(By.xpath("(//table//th)["+(i+1)+"]")).getText();
        }
        return tableHeads;
    }

    public void verifyNoTableData() {
        if ($(gs.tableData).getText().equalsIgnoreCase("No data available in table")) {
            log.info("No data found in the table");
        }else {
            log.info("Following data is present in the table:\n" + $(gs.tableData).getText());
        }
    }

    public void searchText(String Text) {
        if($(gs.txtSearch).isDisplayed()) {
            log.info("Search box displayed");
            $(gs.txtSearch).typeAndEnter(Text);
            Boolean matchFound = getDriver().findElement(By.xpath("(//tbody//td[text()='"+Text+"'])[1]")).isDisplayed();
            Boolean noMatchFound = getDriver().findElement(By.xpath("//tbody//td[text()='No matching records found']")).isDisplayed();
            if(matchFound) {
                log.info("Search successful. Searched item displayed in first row.");
            }else if(noMatchFound) {
                log.info("Invalid search. Searched item not displayed.");
            }else {
                Assert.fail("Search failed.");
            }
        }else {
            Assert.fail("Search box not displayed");
        }
    }

    public void verifyAndAcceptSuccessPopup() {
        waitForLoaderToDisappear();
        if($(gs.successPopup).isDisplayed()) {
            log.info("Success popup displayed");
            waitABit(1000);
            if($(gs.successIcon).isDisplayed() && $(gs.successMessage).isDisplayed() && $(gs.btnOk).isDisplayed()) {
                log.info("All required elements displayed in success popup");
                $(gs.btnOk).click();
                waitABit(1000);
                if(!($(gs.successPopup).isDisplayed())) {
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
        waitForLoaderToDisappear();
        if($(gs.warningPopup).isDisplayed()) {
            log.info("Warning popup displayed");
            waitABit(1000);
            if($(gs.warningIcon).isDisplayed() && $(gs.warningMessage).isDisplayed() && $(gs.btnOk).isDisplayed()) {
                log.info("All required elements displayed in warning popup");
                $(gs.btnOk).click();
                waitABit(1000);
                if(!($(gs.warningPopup).isDisplayed())) {
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
        if (!$(gs.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if($(gs.warningIcon).isDisplayed() && $(gs.confirmationMessage).isDisplayed() && $(gs.btnNo).isDisplayed() && $(gs.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(gs.btnYes).click();
                waitABit(1000);
                if(!($(gs.confirmationPopup).isDisplayed())) {
                    log.info("Confirmation popup accepted");
                }else {
                    Assert.fail("Confirmation popup not accepted");
                }
            }else {
                Assert.fail("All required elements not displayed in confirmation popup");
            }
        } else {
            Assert.fail("Confirmation popup not displayed");
        }
    }

    public void verifyAndRejectConfirmation() {
        if (!$(gs.confirmationPopup).isDisplayed()) {
            log.info("Confirmation popup displayed");
            waitABit(1000);
            if($(gs.warningIcon).isDisplayed() && $(gs.confirmationMessage).isDisplayed() && $(gs.btnNo).isDisplayed() && $(gs.btnYes).isDisplayed()) {
                log.info("All required elements displayed in confirmation popup");
                $(gs.btnNo).click();
                waitABit(1000);
                if(!($(gs.confirmationPopup).isDisplayed())) {
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

