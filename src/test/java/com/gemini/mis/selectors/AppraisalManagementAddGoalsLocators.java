package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class AppraisalManagementAddGoalsLocators {
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
    public static By exportButton = By.xpath("//*[@id=\"tblSelfGoalList_wrapper\"]/div[2]/a");
    public static By warningText = By.xpath("/html/body/div[14]/p");
    public static By warningOk = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
    public static By popupOkButton = By.xpath("/html/body/div[13]/div[7]/div/button");
    public static By printButton = By.xpath("//a[@class='dt-button buttons-print']");
    public static By excelExport = By.xpath("//a[@class='dt-button buttons-excel buttons-html5']");
    public static By copyExport = By.xpath("//a[@class='dt-button buttons-copy buttons-html5']");
    public static By pdfExport =  By.xpath("//a[@class='dt-button buttons-pdf buttons-html5']");
    public static By isAddOrUpdateGoals = By.xpath("//*[@id=\"tabMyGoal\"]/section/div/div/div[1]/div[2]/button");
    public static By addedRowXpath = By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div/input");
    public static By removedKPIRow = By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div/input");
    public static By numOfRowsDropDown = By.name("tblSelfGoalList_length");
    public static By sortingButtonOnCols = By.xpath("//*[@id=\"tblSelfGoalList\"]/thead/tr/th[1]");
    public static By firstTextAfterSorting = By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[1]/td[1]");
    public static By KPIZero = By.xpath("//*[@id='ddlDelivery0']");
    public static By projectNameKPI = By.id("txtProject0");
    public static By goalDesc = By.id("txtGoalDescription0");
    public static By engineeringTab = By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[2]/a/span");
    public static By deliveryTab = By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[1]/a/span");
    public static By creativeTab = By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[4]/a/span");
    public static By behaviouralTab = By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[3]/a/span");
    public static By expandGoal = By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[5]/td[1]");
    public static By deleteButtonAfterExpand = By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[6]/td/ul/li[4]/span[2]/div/button");
    public static By tblGoalListNext = By.id("tblSelfGoalList_next");
    public static By tblGoalListPrev = By.id("tblSelfGoalList_previous");
    public static By tblGoalListInfo =By.id("tblSelfGoalList_info");
    public static By numberOfPages = By.xpath("//*[@id=\"tblSelfGoalList_paginate\"]/ul/li[2]");
    public static By deleteKPIButton = By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div[4]/a");
    public static By addKPIButton = By.id("btnAddPro7");
    public static By searchQueryResultOne = By.xpath("//tr[@role='row']/td[4]");
    public static By searchQueryResultTwo = By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr/td");
    public static By tableItems = By.xpath("//table[@id='tblSelfGoalList']/tbody/tr");
    public static By tableRowText(int i) {
       return By.xpath("//table[@id='tblSelfGoalList']/tbody/tr["+i+"]/td[1]");
    }
    public static By tableColText(int i){
        return By.xpath("//table[@id='tblSelfGoalList']/tbody/tr["+i+"]/td[1]");
    }
    public static By boxRemark = By.id("remarks");
    public static By delivery13 = By.id("ddlDelivery13");
    public static By delivery11 = By.id("ddlDelivery11");
    public static By project13 = By.id("txtProject13");
    public static By project11 = By.id("txtProject11");
    public static By desc13 = By.id("txtGoalDescription13");
    public static By desc11 = By.id("txtGoalDescription11");
    public static By goalNameInTable = By.xpath("//table[@id='tblSelfGoalList']/tbody/tr[@class='child']/td/ul/li[1]/span[2]");
    public static By goalDescInTable = By.xpath("//table[@id='tblSelfGoalList']/tbody/tr[@class='child']/td/ul/li[2]/span[2]");
    public static By deleteSubmitButtonWithRemark = By.xpath("//*[@id=\"modalDeleteGoal\"]/div/div/div[3]/button[1]");
    public static By deleteGoal = By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[1]/td[7]/div/button");
    public static By saveGoal = By.id("btnSaveGoal");
    public static By saveGoalDraft = By.xpath("//button[@class='confirm btn btn-lg btn-danger']");
    public static By saveGoalDraftConfirm = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");
    public static By closeButtonOnGoal = By.xpath("(//button[contains(text(), 'Close')])[6]");
    public static By draftButtonGoal = By.xpath("(//button[contains(text(), 'Draft')])[2]");
    public static By addUpdateGoal = By.xpath("//button[text()='Add/Update Goals']");
    public static By successMessage = By.xpath("/html/body/div[14]/p");
    public static By successOkay = By.xpath("/html/body/div[14]/div[7]/div/button");
}
