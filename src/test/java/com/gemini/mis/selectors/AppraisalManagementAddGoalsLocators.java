package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class AppraisalManagementAddGoalsLocators {
    public static By addGoalTabs(String tabName){
        return By.xpath("//span[@class='nav-link-in' and text()='"+tabName+"']");
    }
    public static By btnAddGoal=By.xpath("//button[contains(text(),'Add/Update Goals')]");
    public static By tabDelivery =By.xpath("//span[contains(text(),'Delivery')]");
    public static By btnCloseAddGoal =By.xpath("(//button[contains(text(),'Close')])[6]");
    public static By dropdownFinancialYear =By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    public static By listFinancialYear = By.xpath("//ul[@role='tree']/li");
    public static By validationMyGoalPage =By.xpath("//div[@class='card-block']/h5");
    public static By linkOfKRAsAndKPIs = By.xpath("//a[@id='linkKRAKPIMapping']");
    public static By btnAddKPIAndKRA=By.xpath("//button[contains(text(),'Add New KRA/KPI Mapping')]");
    public static By dropdownGoalType =By.xpath("//select[@id='userGoalName']");
    public static By textFieldKRA = By.xpath("//input[@placeholder='Enter KRA']");
    public static By btnAddKPI =By.xpath("//a[@id='btnUserAddNewKPI']");
    public static By textFieldAddKPI =By.xpath("//input[@placeholder='KPI description']");
    public static By btnCrossBtn =By.xpath("//button[@Value='X']");
    public static By btnGoalSubmit = By.xpath("//button[@id='btnUserSaveGoals']");




}
