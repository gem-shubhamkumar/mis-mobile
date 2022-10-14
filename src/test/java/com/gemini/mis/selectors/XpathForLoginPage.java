package com.gemini.mis.selectors;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class XpathForLoginPage extends PageObject {


    public static By inputField(String inp){

        return By.xpath("//input[@type='"+inp+"']");
    }

    public static By myElement(String text){

        return By.xpath("//*[text()='"+text+"']");
        }

    public static By sideNavigation(String sideNav)
        {

            return By.xpath("//span[contains(text(),'"+sideNav+"')]");
        }

    public static By buttonType(String inp){

        return By.xpath("//input[@value='"+inp+"']");
    }

    public static By elementOnLandingPage= By.xpath("//a[text()='Change AD Password']");
    public static By loginPageMsg=By.xpath("//div[@class='loginMsgDiv']");
    public static By logoOnLoginPage = By.xpath("//img[@src='/img/GeminiLogo-Small-Black.png']");
    public static By logoOnNewWindow=By.xpath("//img[@class='logo']");
}
