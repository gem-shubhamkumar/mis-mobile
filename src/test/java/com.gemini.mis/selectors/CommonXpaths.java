package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class CommonXpaths {
    public static By menuTabs(String tabName){
        return By.xpath("//span[contains(text(),'"+tabName+"')]");
    }
    public static By linkNumberOfLeave(String leaveType){
        return By.xpath("//table[@class='tbl-typical text-left']/tbody/tr/td[text()='"+leaveType+"']//following-sibling::td/a");
    }

    public static By sideMenuBar= By.xpath("//div[@class='jspPane']/ul");
    public static By btnMenu =By.xpath("//button[@id='show-hide-sidebar-toggle']");
    public static By textMessageBox =By.xpath("//p[@class='lead text-muted ']");
    public static By btnOk = By.xpath("//button[text()='OK']");
    public static By btnLogout =By.xpath("(//a[@class='dropdown-item']/span)[4]");
    public static By btnClose =By.xpath("//button[@id='btnskillsClose']");


}
