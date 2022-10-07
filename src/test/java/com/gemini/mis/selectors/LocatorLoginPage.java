package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class LocatorLoginPage {

    public static org.openqa.selenium.By inputField(String inp){
        return By.xpath("//input[@type='"+inp+"']");
    }
    public static org.openqa.selenium.By loginPageMsg=By.xpath("//div[@class='loginMsgDiv']");
    public static org.openqa.selenium.By logoOnLoginPage = By.xpath("//img[@src='/img/GeminiLogo-Small-Black.png']");
    public static org.openqa.selenium.By logoOnNewWindow=By.xpath("//img[@class='logo']");
    public static org.openqa.selenium.By buttonType(String inp){
        return By.xpath("//input[@value='"+inp+"']");
    }
}
