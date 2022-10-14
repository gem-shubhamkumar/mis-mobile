package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class XpathForFormPage {

      public static By elementAfterScroll(String elementScrolled){

        return By.xpath("//ul[@id='select2-formDepartment-results']/*[text()='"+elementScrolled+"']");
    }

    public static By select(){

        return By.xpath("//select[@name='tblActiveForm_length']");

    }
    public static By selectValue(String value){

        return By.xpath(" //select[@name='tblActiveForm_length']/*[text()='"+value+"']");
    }
    public static By searchBox=By.xpath("//input[@type='search']");
    public static By eyeBtn=By.xpath("//button[@data-target='#mypopupViewDocModal']");
    public static By downloadBtn=By.xpath("//button[@data-toggle='tooltip']");
    public static By uploadBtn=By.xpath("//*[text()='Upload Form']");
    public static By chooseFile=By.xpath("//input[@type='file']");

    public static By formType(String formTye){

        return By.xpath("//ul[@class='select2-results__options']/*[text()='"+formTye+"']");
    }
    public static By deactivateBtn=By.xpath("//button[@class='btn btn-sm btn-success']");
    public static By confirmYes=By.xpath("//button[@class='confirm btn btn-lg btn-danger']");
    public static By departmentContainer=By.xpath("//span[@id='select2-formDepartment-container']");
    public static By formsType=By.xpath("//span[@class='select2-selection__rendered']");
    public static By saveBtn=By.xpath("//button[@id='btnSaveForm']");
}
