package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class XpathforPolicyTab
{
    public static By textBox(String nameOfElement)
    {
        return By.xpath("//input[@type=\""+nameOfElement+"\"]");
    }

    public static By pagination(String className)
    {
        return By.xpath("//li[@id=\""+className+"\"]");
    }
    public static By pageElement(String tag)
    {
        return By.xpath("//div[@class='modal-header']/"+tag+"");
    }
    public static By lengthPage(String className)
    {
      return By.xpath("//select[@name=\""+className+"\"]");
    }

    public static By policyData = By.xpath("//td[@tabindex='0']");

    public static By noOfPages = By.xpath("//li[@class='paginate_button ']");
    public static By noOfRows = By.xpath("//td[@tabindex='0']");
    public static By invalidPolicy = By.xpath("//td[@class='dataTables_empty']");
    public static By policyPage = By.xpath("//div[@class='modal-content']");
    public static By viewBtn = By.xpath("//button[@class='btn btn-sm teal']");
}
