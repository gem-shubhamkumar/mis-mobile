package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class CommonSelectors {
    public static org.openqa.selenium.By myElement(String text){
        return By.xpath("//*[text()='"+text+"']");
    }
    public static By sideNavigation(String sideNav)
    {

        return By.xpath("//span[contains(text(),'"+sideNav+"')]");
    }
    public static By elementOnLandingPage= By.xpath("//a[text()='Change AD Password']");
}
