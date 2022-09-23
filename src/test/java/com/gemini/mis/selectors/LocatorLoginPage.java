package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class LocatorLoginPage {

    public static org.openqa.selenium.By inputField(String inp){
        return By.xpath("//input[@type='"+inp+"']");
    }
    public static org.openqa.selenium.By elementOnLandingPage= By.xpath("//a[text()='Change AD Password']");

    public static org.openqa.selenium.By element(String text){
        return By.xpath("//*[text()='"+text+"']");
    }
    public static org.openqa.selenium.By logo= By.xpath("//img[@src='/img/GeminiLogo-Small-Black.png']");
}
