package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class MISPOM {

    public static By screenNavigation(String SCREENNAME) {
        return By.xpath("//*[text()='" + SCREENNAME + "']");
    }

    public static By loginMsg = By.xpath("//div[@class='loginMsgDiv']");

    public static String homePageXpath = "//input[@id='name']";

    public static By genericButton(String ids) {
        return By.xpath("//button[@id='" + ids + "']");
    }

    public static By buttonPath(String BUTTONNAME) {

        return By.xpath("//button[text()='" + BUTTONNAME + "']");
    }

    public static By genericPath(String VAR) {
        return By.xpath("//*[text()='" + VAR + "']");
    }

    public static By entriesNo = By.xpath("//select[contains(@name,'length')]");

    public static By optionOfEntry(String VAR) {
        return By.xpath("//select[contains(@name,'length')]//option[@Value='" + VAR + "']");
    }

    public static By searchBox = By.xpath("//input[@placeholder='Search']");
    public static By saveButton = By.xpath("//button[@id='btnAddReferral']");
}
