package com.gemini.mis.selectors;

import org.openqa.selenium.By;


public class CommonSelectors {

    public static String loginMsg = "//div[@class='loginMsgDiv']";

    public static String homePageXpath = "//input[@id='name']";

    public static String logo = "//img[@id='GemLogo']";
    public static String designation = "//div[@id='designation']";

    public static String cardToggleMinimize = "//h3[text()='card']//parent::header/div/ul/li/a[@data-title='buttonName']";

    public static String cardToggleMaximize = "(//h3[text()='card']//parent::header/div/ul/li)[2]/a";

    public static String collapsedCard = "//section[contains(@class, 'panel-collapsed')]/header/h3";

    public static String fullScreenCard = "//section[contains(@class, 'panel-expanded')]/header/h3";

    public static By menuTabs(String tabName) {
        return By.xpath("//span[contains(text(),'" + tabName + "')]");
    }

    public static By linkNumberOfLeave(String leaveType) {
        return By.xpath("//table[@class='tbl-typical text-left']/tbody/tr/td[text()='" + leaveType + "']//following-sibling::td/a");
    }

    public static By sideMenuBar = By.xpath("//div[@class='jspPane']/ul");
    public static By btnMenu = By.xpath("//button[@id='show-hide-sidebar-toggle']");
    public static By textMessageBox = By.xpath("//p[@class='lead text-muted ']");
    public static By btnOk = By.xpath("//button[text()='OK']");
    public static By btnLogout = By.xpath("(//a[@class='dropdown-item']/span)[4]");
    public static By btnClose = By.xpath("//button[@id='btnskillsClose']");

    public static org.openqa.selenium.By myElement(String text) {
        return By.xpath("//*[text()='" + text + "']");
    }

    public static By sideNavigation(String sideNav) {

        return By.xpath("//span[contains(text(),'" + sideNav + "')]");
    }

    public static By elementOnLandingPage = By.xpath("//a[text()='Change AD Password']");

}



