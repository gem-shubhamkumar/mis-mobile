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

}
