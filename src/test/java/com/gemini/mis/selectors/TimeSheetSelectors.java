package com.gemini.mis.selectors;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TimeSheetSelectors extends PageObject {

    public By btnSave = By.xpath("//input[@value='Save']");
    public By pleaseNotePopup = By.xpath("//div[contains(@class,'sweet-alert')]//h2[text()='Please note']");
    public By pleaseNoteMessage = By.xpath("//p[contains(@class,'text')]");
    public By btnPreviousWeek = By.xpath("//input[@id='btnPreviousWeek']");
    public By txtSelectedWeek = By.xpath("//label[contains(@id,'SelectedWeek')]");
    public By btnNextWeek = By.xpath("//input[@id='btnNextWeek']");
    public By timesheetStatus = By.xpath("//div[@id='dvTimeSheetStatus']");
    public By txtTimesheetLine1 = By.xpath("(//div[@id='dvTimeSheetStatus']//strong)[1]");
    public By txtTimesheetLine2 = By.xpath("(//div[@id='dvTimeSheetStatus']//strong)[2]");
    public By btnCopyFromWeek = By.xpath("//input[@id='btnCopyFromWeek']");
    public By dialogCopyFromWeek = By.xpath("//div[contains(@id,'CopyFromWeek')]//div[@class='modal-content']");
    public By yearDropdown = By.xpath("//select[contains(@class,'validation-required') and @id='yearCopyFrom']");
    public By weekDropdown = By.xpath("//select[contains(@class,'validation-required') and @id='weekCopyFrom']");
    public By btnCopyCFW = By.xpath("//button[@id='btnCopy']");
    public By emptyDropdownError = By.xpath("//select[contains(@class,'error-validation')]");
    public By btnCloseCFW = By.xpath("(//button[contains(text(),'Close')])[2]");
    public By btnCrossCloseCFW = By.xpath("(//button[@class='close'])[2]");
    public By btnAddNewTemplate = By.xpath("//input[@id='btnAddNewTemplate']");
    public By dialogAddTaskTemplate = By.xpath("//div[contains(@id,'myAddTaskTemplateModal')]//div[@class='modal-content']");
    public By txtTemplateName = By.xpath("//input[contains(@class,'validation-required') and @id='txtTemplateName']");
    public By txtTemplateDescription = By.xpath("//input[contains(@class,'validation-required') and @id='txtTemplateDescription']");
    public By teamNameDropdown = By.xpath("//select[contains(@class,'validation-required') and @id='ddlTeam']");
    public By taskTypeDropdown = By.xpath("//select[contains(@class,'validation-required') and @id='ddlTaskType']");
    public By btnSaveANT = By.xpath("//button[contains(text(),'Save')]");
    public By txtTemplateData1 = By.xpath("(//tr//td)[1]");
    public By emptyFieldError = By.xpath("//input[contains(@class,'error-validation')]");
    public By btnCloseANT = By.xpath("(//button[contains(text(),'Close')])[1]");
    public By btnCrossCloseANT = By.xpath("(//button[@class='close'])[1]");
    public By txtTemplateNameEdit = By.xpath("//input[contains(@class,'validation-required') and @id='txtTemplateNameEdit']");
    public By txtTemplateDescriptionEdit = By.xpath("//input[contains(@class,'validation-required') and @id='txtTemplateDescriptionEdit']");
    public By teamNameDropdownEdit = By.xpath("//select[contains(@class,'validation-required') and @id='ddlTeamEdit']");
    public By taskTypeDropdownEdit = By.xpath("//select[contains(@class,'validation-required') and @id='ddlTaskTypeEdit']");
    public String xpath_btnEditTaskTemplate = "//td[text()='VAR']//following-sibling::td[@class=' text-left']//button[contains(@onclick,'edit')]";
    public By dialogEditTaskTemplate = By.xpath("//div[contains(@id,'myEditTaskTemplateModal')]//div[@class='modal-content']");
    public By btnUpdate = By.xpath("//button[@id='btnUpdateTaskTemplate']");
    public By btnCloseEdit = By.xpath("(//button[contains(text(),'Close')])[2]");
    public By btnCrossEdit = By.xpath("(//button[@class='close'])[2]");
    public String xpath_btnDeleteTaskTemplate = "//td[text()='VAR']//following-sibling::td[@class=' text-left']//button[contains(@onClick,'deleteTask')]";

}
