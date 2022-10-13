package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class NavBarSelectors {
    public static By optionsDropdown(String optionName){
        return By.xpath("//option[contains(text(),'"+optionName+"')]");
    }
    public static By listMenu (String optionName){
        return By.xpath("//a[@class='dropdown-item' and contains(text(),'"+optionName+"')]");
    }
    public static By tableEmployeeDirectory=By.xpath("//div[@class='col-sm-12']/table");
    public static By logoGemini = By.xpath("//img[@class='hidden-md-down']");
    public static By btnChangeADpassword = By.xpath("//a[contains(text(),'Change AD Password')]");
    public static By btnProfileMenu = By.xpath("//button[@id='dd-user-menu']");
    public static By menuListProfile = By.xpath("//div[@class='dropdown-menu dropdown-menu-right']");
    public static By textMenuListItems = By.xpath("//a[@class='dropdown-item']");
    public static By optionsSkills = By.xpath("//a[@id='skills']");
    public static By listTechnologyDropdown = By.xpath("//ul[@class='select2-results__options']/li");
    public static By dropdownTechnology = By.xpath("//span[@id='select2-ddlSkills-container']");
    public static By windowAddSkills =By.xpath("//div[@id='skillsdiv']");
    public static By dropDownProficiency =By.xpath("(//select[@class='form-control select-validate validation-required'])[1]");
    public static By dropDownSkillType =By.xpath("(//select[@class='form-control select-validate validation-required'])[2]");
    public static By btnAddSkillSave= By.xpath("//button[@id='btnSaveSkills']");
    public static By textFieldExperience =By.xpath("//input[@id='expinMonths']");
    public static By listMySkillCard = By.xpath("//div[@id='tblSkillSet']/table/tbody/tr/td/a");
    public static By btnDashboardSetting =By.xpath("//a[@id='dashBoardSettings']");
    public static By textDashboardTable =By.xpath("//table[@id='dashBoardSettingGrid']/tbody/tr/td[contains(text(),'Skills')]");
    public static By checkboxTable = By.xpath("//tbody[@id='divdashboardvisit']/tr/td/input[@type='checkbox']");
    public static By btnUpdate =By.xpath("//button[@id='btnSaveSetting']");
    public static By headingsDashboardCards= By.xpath("//header[@class='box-typical-header panel-heading']/h3");





}
