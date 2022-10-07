package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFucntions;
import com.gemini.mis.selectors.AppraisalManagementAddGoalsLocators;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppraisalManagementAddGoalsPages extends PageObject {

    @Steps
    CommonFucntions commonFunction;

    @Step("verify four elements are available in financial year dropdown")
    public void verifyFinancialYearDropdown(){
        List<WebElement> listItems = getDriver().findElements(AppraisalManagementAddGoalsLocators.listFinancialYear);
        if(listItems.size()==4){
            System.out.println("PASS : 4 items are present");
        }else{
            Assert.fail("Number of items are "+listItems.size()+" not 4");
        }
    }


    @Step("Verify {0} text is present in current page")
    public void verifyTextPresent(String text){
        switch (text){
            case "Add My Goal/Team Goal":
                commonFunction.isTextFound(AppraisalManagementAddGoalsLocators.validationMyGoalPage,text);
                break;


            default:Assert.fail("Failed to find text : "+text);

        }
    }



    @Step("Fill data in the fields")
    public void fillDataInFields(String fieldName){
        switch (fieldName){
            case "projectName":
                $(By.id("txtProject0")).sendKeys("DEMO PROJECT");
                break;
            case "goalDescription":
                $(By.id("txtGoalDescription0")).sendKeys("DEMO Description");
                break;
        }
    }


    @Step("Fill data in a field according to tab name")
    public void fillAField(String tabName){
        switch (tabName){
            case "Behavioural":
                selectFromDropdown($(By.id("ddlDelivery13")),"behaviouralKPI");
                $(By.id("txtProject13")).sendKeys("DemoProjectBehavioural");
                $(By.id("txtGoalDescription13")).sendKeys("DemoProjectBehavioural");
                break;
            case "Creative":

                selectFromDropdown($(By.id("ddlDelivery11")),"Demo");
                $(By.id("txtProject11")).sendKeys("DemoProjectCreative");
                $(By.id("txtGoalDescription11")).sendKeys("DemoProjectCreative");
                break;
        }
    }

    @Step("Enter {0} in {1} text field")
    public void enterTextInField(String textToEnter, String fieldName){
        switch (fieldName){
            case "KRA":
                commonFunction.verifyTextFieldAndEnterText(AppraisalManagementAddGoalsLocators.textFieldKRA,textToEnter);
                break;
            case "KPI description":
                commonFunction.verifyTextFieldAndEnterText(AppraisalManagementAddGoalsLocators.textFieldAddKPI,textToEnter);
                break;

            default:Assert.fail("field not added in switch cases");
        }
    }


    @Step("Click on {0}")
    public void clickOnElement(String eleName){
        waitABit(1500);
        switch(eleName){
            case "Add/Update goal button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnAddGoal);
                break;
            case "Close add goal button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnCloseAddGoal);
                break;
            case "Financial year dropdown":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.dropdownFinancialYear);
                break;
            case "List of KRAs and KPIs link":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.linkOfKRAsAndKPIs);
                break;
            case "Add KPI/KRA button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnAddKPIAndKRA);
                waitABit(1000);
                break;
            case "Add KPI button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnAddKPI);
                break;
            case "KPI cross button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnCrossBtn);
                break;
            case "Submit add button":
                commonFunction.clickOn(AppraisalManagementAddGoalsLocators.btnGoalSubmit);
                break;
            case "export in add goals":
                commonFunction.clickOn(By.xpath("//*[@id=\"tblSelfGoalList_wrapper\"]/div[2]/a"));
                break;


            default:Assert.fail("button not found, not added in switch cases");
        }
        waitABit(1000);
    }

    @Step("Choose current financial yeas as {0} from dropdown")
    public void chooseCurrentFinancialYearAs(String year){
        List<WebElement> listItems = getDriver().findElements(AppraisalManagementAddGoalsLocators.listFinancialYear);
        for (WebElement ele :listItems){
            if(ele.getText().contains(year)){
                ele.click();
                break;
            }
        }

    }

    public void verifyTab() {
        String heading = $(By.tagName("h5")).getText();

        Assert.assertTrue(StringUtils.equals(heading, "Add My Goal/Team Goal"));
    }

    public void selectKPI(String value) {
        getDriver().switchTo().activeElement();
        selectMultipleItemsFromDropdown($(By.xpath("//*[@id='ddlDelivery0']")), "Defect Rate - x%");
    }

    public void enterValue(String value) {
        typeInto($(By.id("txtProject0")), value);
    }

    public void enterGoal(String goal) {
        typeInto($(By.id("txtGoalDescription0")), goal);
    }

    public void clickTab(String tab) {

            switch(tab){
                case "Engineering":
                    $(By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[2]/a/span")).click();
                    Assert.assertTrue("Clicked on engineering",true);
                    break;
                case "Delivery":
                    $(By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[1]/a/span")).click();
                    Assert.assertTrue("Clicked on delivery",true);


                    break;
                case "Behavioural":
                    $(By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[3]/a/span")).click();
                    Assert.assertTrue("Clicked on Behavioural",true);

                    break;
                case "Creative":
                    $(By.xpath("//*[@id=\"modalSelfGoal\"]/div/div/div[2]/div[2]/ul/li[4]/a/span")).click();
                    Assert.assertTrue("Clicked on creative",true);

                    break;
                default: Assert.fail("Failed to click on any options");

            }
        }



    public void verifyMessage(String message){
        switch (message){
            case "Success":
                $(By.xpath("/html/body/div[14]/p")).getText().equals("Request processed successfully");
                $(By.xpath("/html/body/div[14]/div[7]/div/button")).click();
                Assert.assertTrue("Success message verified!!",true);
                break;
            default:
                Assert.fail("Failed to click on the button");
        }
    }

    public void selectSkill(String value) {
        selectFromDropdown($(By.id("skillName")), value);

    }

    public void clickButton(String button) {
        switch (button) {
            case "add goals" : {
                clickOn($(By.xpath("//button[text()='Add/Update Goals']")));
                break;
            }
            case "draft" : {
                clickOn($(By.xpath("(//button[contains(text(), 'Draft')])[2]")));
                System.out.println("Draft clicked");
                break;
            }
            case "close" : {
                clickOn($(By.xpath("(//button[contains(text(), 'Close')])[6]")));
                break;
            }
            case "submit goal" : {
                clickOn($(By.id("btnSaveGoal")));
                clickOn($(By.xpath("//button[@class='confirm btn btn-lg btn-danger']")));
                clickOn($(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")));
                getDriver().close();
           }
            case "delete":
                clickOn($(By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr[1]/td[7]/div/button")));
                waitABit(3000);
        }
    }

    @Step("click on submit after deleting goal")
    public void clickOnSubmit(String remarkString){
        switch (remarkString){
            case "without remark":
                clickOn($(By.xpath("//*[@id=\"modalDeleteGoal\"]/div/div/div[3]/button[1]")));
                break;
            case "with some remark":
                $(By.id("remarks")).sendKeys("Some Remarks before deletion");
                Assert.assertTrue("Added remarks",true);
                clickOn($(By.xpath("//*[@id=\"modalDeleteGoal\"]/div/div/div[3]/button[1]")));
                break;
            default: Assert.fail("Failed in clicking on remark");
        }
    }

    @Step("Search on the add goal page")
    public void searchOnPage(String searchInput){
        $(By.xpath("//*[@id=\"tblSelfGoalList_filter\"]/label/input")).sendKeys(searchInput);
    }

    @Step("Error!! when empty remark")
    public void areErrorsInSubmission(){
        WebElement boxRemark = $(By.id("remarks"));
        if(boxRemark.getClass().equals("form-control validation-required error-validation")){
            Assert.assertTrue("There is no remark in the remark field!!",true);
        }
    }

    @Step("Verify Search result")
    public void verifySearchResult(String projName){
        try {
            $(By.xpath("//tr[@role='row']/td[4]")).getText().equals(projName);
            Assert.assertTrue("Project name verified!!",true);
        }catch (Exception e) {
            $(By.xpath("//*[@id=\"tblSelfGoalList\"]/tbody/tr/td")).getText().equals("No matching records found");
            Assert.assertTrue("Satisfied with invalid search queries!",true);
        }
    }



    @Step("Step to watch out the project name and description")
    public String verifyProjectAndGoalDescription(String projName,String desc){

        String xpathForDeleteButton;
        int rows;
        int col;
        if($(By.xpath("//tr[@role='row']")).isVisible()&& $(By.xpath("//tr[@role='row'][1]/td")).isVisible()    ){
            rows = getDriver().findElements(By.xpath("//tr[@role='row']")).size();

                col = getDriver().findElements(By.xpath("//tr[@role='row'][1]/td")).size();
                for(int i=1;i<=rows;i++){
                    for(int j = 1;j<=col;j++){
                        if($(By.xpath("//tr[@role='row']["+i+"]/td["+j+"]")).getText().equals(projName) && $(By.xpath("//tr[@role='row']["+i+"]/td["+(j+1)+"]")).getText().equals(desc)) {
                            xpathForDeleteButton = "//tr[@role='row'][1]/td[" + (j + 3) + "]";
                            return xpathForDeleteButton;
                        }
                    }
                }
            }
       else
           return "";
    }

    @Step("Verify current page title is not as gemini page title")
    public void verifyLinkOpenOnSameTab(){
        String currentTitle = getDriver().getTitle();
        int numberOfTabs = getDriver().getWindowHandles().size();
        if(numberOfTabs==1){
            if(!currentTitle.equals("MIS-Gemini")){
                System.out.println("PASS : link is open on same tab");
            }else{
                Assert.fail("link not open title is same");
            }
        }else{
            Assert.fail("link open on different tab");
        }


    }

    @Step("Select {0} from dropdown ou of four options available")
    public void selectFormGoalTypeDropdown(String optionName){
        WebElement ele =$(AppraisalManagementAddGoalsLocators.dropdownGoalType);
        selectFromDropdown(ele,optionName);

    }


    @Step("Click add or delete kpi row")
    public void addOrRemoveKPIRow(String optionName){
        switch (optionName){
            case "Add":
                clickOn($(By.id("btnAddPro7")));
                break;
            case "Delete":
                String numberOfElement = $(By.xpath("//*[@id=\"dynamicContant1701\"]/div[2]/div[4]/a")).getAttribute("data-attr-counter");
                int numOfElem = Integer.parseInt(numberOfElement);
                System.out.println(numOfElem);
                System.out.println("removeBtn"+numberOfElement);

                clickOn($(By.id("removeBtn"+numberOfElement)));
                break;
        }
    }

    @Step("Verify number of rows from lower left")
    public void verifyNumberOfRows(){
        String lowerLeftText = $(By.id("tblSelfGoalList_info")).getText();
        if(lowerLeftText.equals(lowerLeftText)){
            Assert.assertTrue("Entries are less than 10 so no change for now",true);
        }else if(!lowerLeftText.equals(lowerLeftText)){
            Assert.assertTrue("Entries are less than greater than 10 and less than or equal to 25",true);
        }
    }

    @Step("Verify number of pages")
    public int verifyNumberOfPages(){
        int numberOfPages = getDriver().findElements(By.xpath("//*[@id=\"tblSelfGoalList_paginate\"]/ul/li[2]")).size();
        return numberOfPages;
    }

    @Step("Verify functionality of next and prev buttons")
    public void verifyNextPrevButtons(int numOfPages){
        if(numOfPages == 1){
            boolean isNextClickable = $(By.id("tblSelfGoalList_next")).isClickable();
            boolean isPrevClickable = $(By.id("tblSelfGoalList_previous")).isClickable();
            Assert.assertTrue("Page is already on last page and Next and previous buttons are clickable" ,isNextClickable&isPrevClickable);
        }
        else{
            String infoOnFirstPage = $(By.id("tblSelfGoalList_info")).getText();
            $(By.id("tblSelfGoalList_next")).click();
            String infoOnSecondPage = $(By.id("tblSelfGoalList_info")).getText();
            boolean isSameInfo = infoOnSecondPage.equals(infoOnFirstPage);
            Assert.assertFalse("Successfully navigated to second page",isSameInfo);
            $(By.id("tblSelfGoalList_previous")).click();
            Assert.assertFalse("Successfully navigated back to first page",$(By.id("tblSelfGoalList_info")).getText().equals(infoOnFirstPage));
        }
    }



}







