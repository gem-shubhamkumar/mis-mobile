package com.gemini.mis.selectors;


import org.openqa.selenium.By;

public class ApplyToAnyCardLocators {

    //Apply to any card locators
    public static By cardNames = By.xpath("//h3[@class='panel-title']");


    //Common Locators
    public static By loginMsg = By.xpath("//div[@class='loginMsgDiv']");

    public static By homePageXpath = By.xpath("//input[@id='name']");

    public static By logo = By.xpath("//img[@id='GemLogo']");
    public static By designation = By.xpath("//div[@id='designation']");

    public static By credInputField(String fieldName) {
        return By.name(fieldName);
    }

    public static By cardToggleMinimize(String cardName) {
//        return By.xpath("//h3[text()='" + cardName + "']//parent::header/div/ul/li/a[@data-title='Minimize']");
        return By.xpath("(//h3[text()='" + cardName + "']//parent::header/div/ul/li)[1]/a");

    }

    public static By cardToggleMaximize(String cardName) {
        return By.xpath("(//h3[text()='" + cardName + "']//parent::header/div/ul/li)[2]/a");
    }

    ;

    public static By collapsedCard = By.xpath("//section[contains(@class, 'panel-collapsed')]/header/h3");
    public static By maximizedCard = By.xpath("//section[contains(@class, 'panel-expanded')]/header/h3");

    public By fullScreenCard = By.xpath("//section[contains(@class, 'panel-expanded')]/header/h3");

    public static By menuTabs(String tabName) {
        return By.xpath("//span[contains(text(),'" + tabName + "')]");
    }

    public By sideMenuBar = By.xpath("//div[@class='jspPane']/ul");

    public static By textMessageBox = By.xpath("//p[@class='lead text-muted ']");

    public static By btnOk = By.xpath("//button[text()='OK']");
}



