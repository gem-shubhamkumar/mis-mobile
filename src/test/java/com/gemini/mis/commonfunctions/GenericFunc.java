package com.gemini.mis.pages;

import com.gemini.mis.selectors.GenericSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefinitions.Dashboard;

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
        waitABit(2000);
        $(gs.btnuser).click();
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

    public  void verifyPage(String Page, String PageType) {
    //PageType can be "Main" or "Sub"
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
            WebElement myPage = $(By.xpath("(//div[conatins(@id,'" + identifier + "')])[1]"));
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
}
