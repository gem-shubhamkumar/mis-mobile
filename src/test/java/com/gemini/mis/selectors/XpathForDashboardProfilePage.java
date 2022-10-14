package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class XpathForDashboardProfilePage {

    public static By editPencil= By.xpath("//button[@id='btnUpdateProfile']");

    public static By myElement(String text){

        return By.xpath("//*[text()='"+text+"']");
    }

    public static By lunchBtn=By.xpath("//button[@id='btnApplyLunch']");

    public static By myInput(String inp){

        return By.xpath("//input[@id='"+inp+"']");
    }

    public static By closeProfilePopup = By.xpath("//div[@id='mypopupUpdateProfile']/div/div/div/button/span");
    public static By updateBtn= By.xpath("//div[@class='form-group']/button[@id='btnUpdate']");
    public static By closeBtn= By.xpath("//button[@id='btnCloseLunch']");
    public static By okBtn =By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
    public static By updateAddressBtn=By.xpath("//div[@class='text-right']/button[@id='btnUpdateAdd']");
    public static By updatePasswordBtn=By.xpath("//button[@id='btnChangePassword']");
    public static By fromDateInCalendar=By.xpath("//div[@id='fromDate']/div/span[@class=' input-group-btn']/button[@class='btn default']");
    public static By tillDateInCalendar=By.xpath("//div[@id='tillDate']/div/span[@class=' input-group-btn']/button[@class='btn default']");

    public static By changeMonthBtn(String inp) {

        return By.xpath("//th[@class='"+inp+"']");
    }

    public static By selectFromDate(String inp){

        return By.xpath("//tbody/tr[*]/td[text()='"+inp+"']");
    }
    public static By locationDropdown=By.xpath("//span[@id='select2-location-container']");
    public static By addBtn=By.xpath("//button[@id='BtnsaveDateforLunch']");
    public static String userCard = "//div[@class='widget-user-stat']";
    public static By location(String Loc){

        return By.xpath("//select[@id='location']/*[text()='"+Loc+"']");
    }

}
