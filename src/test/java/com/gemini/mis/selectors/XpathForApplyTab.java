package com.gemini.mis.selectors;

import org.openqa.selenium.By;
public class XpathForApplyTab
{
    public static By textBox(String nameOfElement)
    {
        return By.xpath("//input[@id=\""+nameOfElement+"\"]");
    }
    public static By dropdown(String nameOfElement)
    {
        return By.xpath("//select[@id=\""+nameOfElement+"\"]");
    }
    public static By sideNav(String sideNav)
    {
        return By.xpath("//span[contains(text(),\""+sideNav+"\")]");
    }

    public static By dropdownOptions(String num)
    {
        return By.xpath("(//li[@class='magenta with-sub opened']/ul/li/a/span)["+num+"]");
    }
    public static By inputItem(String type)
    {
        return By.xpath("//input[@placeholder=\""+type+"\"]");
    }
    public static By textArea(String id)
    {
        return By.xpath("//textarea[@id=\""+id+"\"]");
    }
    public static By successAlertPopup(String tag)
    {
        return By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/"+tag+"");
    }
    public static By calendarBtn(String id)
    {
        return By.xpath("//div[@id=\""+id+"\"]/div/span");
    }
    public static By labelText(String text)
    {
        return By.xpath("//label[contains(text(),\""+text+"\")]");
    }
    public static By halfDayOptions(String halfDayOption)
    {
        return By.xpath("//input[@id=\""+halfDayOption+"\"]/parent::label");
    }
    public static By btnType(String btnName)
    {
        return By.xpath("//button[contains(text(),\""+btnName+"\")]");
    }
    public static By isTabActive(String tabName)
    {
        return By.xpath("//span[contains(text(),\""+tabName+"\")]/parent::a");
    }
    public static By heading = By.xpath("//h5");
    public static By tab = By.xpath("//a[@role='tab']/span");
    public static By submitBtn = By.xpath("//input[@value='Submit']");

    public static By tooltip = By.xpath("//a[@data-trigger='hover']");

}
