package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class MySkillsLocators {

    public static By cardNames = By.xpath("//h3[@class='panel-title']");
    public static By tableDiv = By.xpath("//div[@id='tblSkillSet']/table/tbody/tr/td/div");
    public static By okButton = By.xpath("//button[text()='OK']");

    public static By skillName (String skill) {
        return By.xpath("//div[@id='tblSkillSet']/table/tbody/tr/td/a[text()='" + skill + "']");
    }

    public static By modalTitle (String title) {
        return By.xpath("//h4[text()='" + title + "']");
    }


    public static By genericButton (String id) {
        return By.xpath("//button[@id='" + id + "']");
    }
    public static By errorType (String id) {
        return By.xpath("//*[contains(@class, 'error-validation') and @id='" + id + "']");
    }
    public static By tableRow (String id) {
        return By.xpath("//div[@id='" + id + "']/table/tbody/tr");
    }

    public static By loginMsg = By.xpath("//div[@class='loginMsgDiv']");

    public static By homePageXpath (String name) {
        return By.xpath("//*[@id='" + name + "']");
    }
    public static By dashboardElements (String attribute) {
        return By.xpath("//div[@id='" + attribute + "']");
    }

    public static By collapsedCard = By.xpath("//section[contains(@class, 'panel-collapsed')]/header/h3");

    public static By fullScreenCard = By.xpath("//section[contains(@class, 'panel-expanded')]/header/h3");


    public static By sideNav (String tabName) {
        return By.xpath("//span[@class='lbl' and text()='" + tabName + "']");
    }
    public static By viewStatusRequestTab = By.xpath("(//span[@class='lbl' and text()='View Request Status'])[2]");

    public static By paginationButtons (String buttonName) {
        return By.xpath("//li[contains(@class, 'paginate_button " + buttonName + "')]");
    }

    public static By select (String attribute, String value) {
        return By.xpath("//select[@" + attribute + "='" + value + "']");
    }

    public static By userAvatar = By.xpath("//img[@id='user-avatar']");
}
