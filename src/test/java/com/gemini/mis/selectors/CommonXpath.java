package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class CommonXpath {
    public static By sideNav(String sideNav)
    {
        return By.xpath("//span[contains(text(),\""+sideNav+"\")]");
    }
    public static By dateOnCalendar(String date)
    {
        return By.xpath("//td[contains(text(),\""+date+"\")]");
    }
    public static By nextCal = By.xpath("//th[@class='next']");



    public static By JDButton= By.xpath("(//button[contains(@onclick,'viewDocumentInPopup')])[1]");
    public static By JDWindow=By.xpath("//embed[@id='objViewPdf']");
    public static String JDRole="(//td[text()='VAR'])[1]";
    public static By RefralButton=By.xpath("(//button[@title='Refer'])[1]");
    public static By JdNameRefer=By.xpath("//input[@id='refereeName']");
    public static By JDEmail=By.xpath("//input[@id='refereeID']");


}
