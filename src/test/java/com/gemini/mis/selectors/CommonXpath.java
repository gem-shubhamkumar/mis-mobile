package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class CommonXpath {
    public static By sideNav(String sideNav)
    {
        return By.xpath("//span[contains(text(),\""+sideNav+"\")]");
    }

}
