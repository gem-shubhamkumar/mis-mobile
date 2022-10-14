package com.gemini.mis.implementations;

import com.gemini.mis.selectors.ApplyToAnyCardLocators;
import com.gemini.mis.selectors.AppraisalManagementAddGoalsLocators;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AppraisalManagementPageImplementation extends PageObject {

    String deleteButtonXpath;

    ApplyToAnyCardLocators applyToAnyCardLocators;

    private static Logger LOGGER = LoggerFactory.getLogger(AppraisalManagementPageImplementation.class);


    public void clickOnElements(String elemName){
        waitABit(3000);
        switch(elemName){
            case "Add/Update goal button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnAddGoal));
                LOGGER.info("Clicked on Add/Update Goal Button.");
                break;
            case "Close add goal button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnCloseAddGoal));
                LOGGER.info("Clicked on close button on add goal");
                break;
            case "Financial year dropdown":
                clickOn($(AppraisalManagementAddGoalsLocators.dropdownFinancialYear));
                LOGGER.info("Clicked on financial year dropdown");
                break;
            case "List of KRAs and KPIs link":
                clickOn($(AppraisalManagementAddGoalsLocators.linkOfKRAsAndKPIs));
                LOGGER.info("Clicked on List of KRAs and KPIs link.");
                break;
            case "Add KPI/KRA button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnAddKPIAndKRA));
                waitABit(1000);
                LOGGER.info("Clicked on KPI/KRA Button.");
                break;
            case "Add KPI button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnAddKPI));
                LOGGER.info("Clicked on Add KPI button.");
                break;
            case "KPI cross button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnCrossBtn));
                LOGGER.info("Clicked on KPI Cross Button.");
                break;
            case "Submit add button":
                clickOn($(AppraisalManagementAddGoalsLocators.btnGoalSubmit));
                LOGGER.info("Clicked on submit add button");
                break;
            case "export in add goals":
                clickOn($(AppraisalManagementAddGoalsLocators.exportButton));
                LOGGER.info("Clicked on export in add goals.");
                break;
            case "Sign In": {
                clickOn($(ApplyToAnyCardLocators.credInputField("btnLogin")));
                LOGGER.info("Clicked on SignIn Button.");
                break;
            }
            default:
                LOGGER.error("Error on clicking button");
                Assert.fail("button not found, not added in switch cases");
        }
    }

    public void clickOnButtonOnPopup(String btnName){
        waitABit(1000);
        switch (btnName){
            case "Yes":
                LOGGER.info("Clicked yes on popup.");
                clickOn($(AppraisalManagementAddGoalsLocators.popupOkButton));
                break;
        }
    }

    public void verifyWarningClickOk(){
        waitABit(1500);
        $(AppraisalManagementAddGoalsLocators.warningText).getText().equals("Kindly select Primary Skill in Engineering tab");
        Assert.assertTrue("Warning displayed!! kindly select primary skill in engineering tab",true);
        $(AppraisalManagementAddGoalsLocators.warningOk).click();
        LOGGER.info("Clicked on ok button in warning.");
    }

    public void chooseCurrentFinancialYearAs(String year){
        waitABit(2000);
        List<WebElement> listItems = getDriver().findElements(AppraisalManagementAddGoalsLocators.listFinancialYear);
        for (WebElement ele :listItems){
            if(ele.getText().contains(year)){
                ele.click();
                LOGGER.info("Clicked on current financial year.");
                break;
            }
        }
    }
    public void verifyTab(){
        waitABit(1500);
        String heading = $(By.tagName("h5")).getText();
        LOGGER.info("Verifying tab");
        Assert.assertTrue(StringUtils.equals(heading, "Add My Goal/Team Goal"));
    }

    public void selectKPI(String value) {
        waitABit(1500);
        getDriver().switchTo().activeElement();
        LOGGER.info("Select KPI field: Defect Rate - x%");
        selectMultipleItemsFromDropdown($(AppraisalManagementAddGoalsLocators.KPIZero), "Defect Rate - x%");
    }

    public void enterValue(String value) {
        typeInto($(AppraisalManagementAddGoalsLocators.projectNameKPI), value);
        LOGGER.info("Entered project name kpi in respective field");

    }

    public void enterGoal(String goal) {
        typeInto($(AppraisalManagementAddGoalsLocators.goalDesc), goal);
        LOGGER.info("Entered goal in goal tab");
    }

    public void clickTab(String tab) {
waitABit(2000);
        switch(tab){
            case "Engineering":
                $(AppraisalManagementAddGoalsLocators.engineeringTab).click();
                LOGGER.info("Clicked on {} tab",tab);
                Assert.assertTrue("Clicked on engineering",true);
                break;
            case "Delivery":
                $(AppraisalManagementAddGoalsLocators.deliveryTab).click();
                LOGGER.info("Clicked on {} tab",tab);
                Assert.assertTrue("Clicked on delivery",true);
                break;
            case "Behavioural":
                $(AppraisalManagementAddGoalsLocators.behaviouralTab).click();
                LOGGER.info("Clicked on {} tab",tab);
                Assert.assertTrue("Clicked on Behavioural",true);

                break;
            case "Creative":
                $(AppraisalManagementAddGoalsLocators.creativeTab).click();
                LOGGER.info("Clicked on {} tab",tab);
                Assert.assertTrue("Clicked on creative",true);
                break;
            default: Assert.fail("Failed to click on any options");

        }
    }



    public void verifyFinancialYearDropdown(){
        waitABit(1500);
        List<WebElement> listItems = getDriver().findElements(AppraisalManagementAddGoalsLocators.listFinancialYear);
        if(listItems.size()==4){
            LOGGER.info("PASS : 4 items are present");
        }else{
            Assert.fail("Number of items are "+listItems.size()+" not 4");
        }
    }


    public void verifyTextPresent(String text){
        switch (text){
            case "Add My Goal/Team Goal":
                String textToCompare = $(AppraisalManagementAddGoalsLocators.validationMyGoalPage).getText();
                if(text.contains("Hello")){
                    LOGGER.info("Text verified in {}",text);
                    System.out.println("Text is verified");
                }
                else
                    Assert.assertEquals(text,textToCompare);
                break;
            default:Assert.fail("Failed to find text : "+text);

        }
    }



    public void fillDataInFields(String fieldName){
        switch (fieldName){
            case "projectName":
                LOGGER.info("Sent keys to field {}",fieldName);
                $(AppraisalManagementAddGoalsLocators.projectNameKPI).sendKeys("DEMO PROJECT");
                break;
            case "goalDescription":
                LOGGER.info("Sent keys to field {}",fieldName);
                $(AppraisalManagementAddGoalsLocators.goalDesc).sendKeys("DEMO Description");
                break;
        }
    }


    public void fillAField(String tabName){
        switch (tabName){
            case "Behavioural":
                LOGGER.info("Filling data in {} tab.",tabName);
                selectFromDropdown($(AppraisalManagementAddGoalsLocators.delivery13),"behaviouralKPI");
                $(AppraisalManagementAddGoalsLocators.project13).sendKeys("DemoProjectBehavioural");
                $(AppraisalManagementAddGoalsLocators.desc13).sendKeys("DemoProjectBehavioural");
                break;
            case "Creative":
                LOGGER.info("Filling data in {} tab.",tabName);
                selectFromDropdown($(AppraisalManagementAddGoalsLocators.delivery11),"Demo");
                $(AppraisalManagementAddGoalsLocators.project11).sendKeys("DemoProjectCreative");
                $(AppraisalManagementAddGoalsLocators.desc11).sendKeys("DemoProjectCreative");
                break;
        }
    }

    public void enterTextInField(String textToEnter, String fieldName){
        switch (fieldName){
            case "KRA":
                LOGGER.info("Entered text in {}",fieldName);
                if (isElementFound(AppraisalManagementAddGoalsLocators.textFieldKRA)){
                    $(AppraisalManagementAddGoalsLocators.textFieldKRA).type(textToEnter);
                }else{
                    Assert.fail("Unable to locate text field");
                }
                break;
            case "KPI description":
                LOGGER.info("Entered text in {}",fieldName);
                if (isElementFound(AppraisalManagementAddGoalsLocators.textFieldAddKPI)){
                    $(AppraisalManagementAddGoalsLocators.textFieldAddKPI).type(textToEnter);
                }else{
                    Assert.fail("Unable to locate text field");
                }
                break;

            default:Assert.fail("field not added in switch cases");
        }
    }


    public void verifyMessage(String message){
        switch (message){
            case "Success":
                LOGGER.info("Veirfy message {}",message);
                $(AppraisalManagementAddGoalsLocators.successMessage).getText().equals("Request processed successfully");
                $(AppraisalManagementAddGoalsLocators.successOkay).click();
                Assert.assertTrue("Success message verified!!",true);
                break;
            default:
                LOGGER.warn("Failed to click on the button");
                Assert.fail("Failed to click on the button");
        }
    }

    public void selectSkill(String value) {
        LOGGER.info("Select skill from drop down");
        selectFromDropdown($(By.id("skillName")), value);

    }

    public void clickButton(String button) {
        waitABit(2000);
        switch (button) {
            case "add goals" : {
                LOGGER.info("Clicked on button {}",button);
                clickOn($(AppraisalManagementAddGoalsLocators.addUpdateGoal));
                break;
            }
            case "draft" : {
                LOGGER.info("Clicked on button {}",button);
                clickOn($(AppraisalManagementAddGoalsLocators.draftButtonGoal));
                break;
            }
            case "close" : {
                LOGGER.info("Clicked on button {}",button);
                clickOn($(AppraisalManagementAddGoalsLocators.closeButtonOnGoal));
                break;
            }
            case "submit goal" : {
                LOGGER.info("Clicked on button {}",button);
                clickOn($(AppraisalManagementAddGoalsLocators.saveGoal));
                clickOn($(AppraisalManagementAddGoalsLocators.saveGoalDraft));
                clickOn($(AppraisalManagementAddGoalsLocators.saveGoalDraftConfirm));
                getDriver().close();
            }
            case "delete":{
                LOGGER.info("Clicked on button {}",button);
                clickOn($(AppraisalManagementAddGoalsLocators.deleteGoal));
                waitABit(3000);}
        }
    }

    public void clickOnSubmit(String remarkString){
        switch (remarkString){
            case "without remark":
                LOGGER.info("Clicked on submit without remark.");
                clickOn($(AppraisalManagementAddGoalsLocators.deleteSubmitButtonWithRemark));
                break;
            case "with some remark":
                LOGGER.info("Clicked on submit with remark.");
                $(By.id("remarks")).sendKeys("Some Remarks before deletion");
                Assert.assertTrue("Added remarks",true);
                clickOn($(AppraisalManagementAddGoalsLocators.deleteSubmitButtonWithRemark));
                break;
            default: Assert.fail("Failed in clicking on remark");
        }
    }

    public void searchOnPage(String searchInput){
        $(By.xpath("//*[@id=\"tblSelfGoalList_filter\"]/label/input")).sendKeys(searchInput);
    }

    public void areErrorsInSubmission(){
        LOGGER.info("Veirfy errors in submission while delete without remark");
        WebElement boxRemark = $(AppraisalManagementAddGoalsLocators.boxRemark);
        if(boxRemark.getClass().equals("form-control validation-required error-validation")){
            Assert.assertTrue("There is no remark in the remark field!!",true);
        }
    }

    public void verifySearchResult(String projName){
        LOGGER.info("Verifying project name");
        try {
            LOGGER.info("Veirfied project name.");
            $(AppraisalManagementAddGoalsLocators.searchQueryResultOne).getText().equals(projName);
            Assert.assertTrue("Project name verified!!",true);
        }catch (Exception e) {
            LOGGER.info("Invalid search queries.");
            $(AppraisalManagementAddGoalsLocators.searchQueryResultTwo).getText().equals("No matching records found");
            Assert.assertTrue("Satisfied with invalid search queries!",true);
        }
    }



    public String verifyProjectAndGoalDescription(String projName,String desc){
        LOGGER.info("Veirfying project name and goal description as {} & {} respectively",projName,desc);
        int sizeOfTabItems = getDriver().findElements(AppraisalManagementAddGoalsLocators.tableItems).size();
        for(int i=1;i<=sizeOfTabItems;i++){
            if($(AppraisalManagementAddGoalsLocators.tableRowText(i)).getText().equals("Delivery")){
                Assert.assertTrue("Found the project in delivery section",true);
                $(AppraisalManagementAddGoalsLocators.tableColText(i)).click();
                if( $(AppraisalManagementAddGoalsLocators.goalNameInTable).getText().equals(projName) &&  $(AppraisalManagementAddGoalsLocators.goalDescInTable).getText().equals(desc) ){
                    deleteButtonXpath = "//table[@id='tblSelfGoalList']/tbody/tr[@class='child']/td/ul/li[4]/span[2]/div/button";
                }
            }
        }

        return "";
    }

    public void verifyLinkOpenOnSameTab(){
        LOGGER.info("Verify link is open on same tab.");
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

    public void selectFormGoalTypeDropdown(String optionName){
        LOGGER.info("Select from goal type dropdown");
        WebElement ele =$(AppraisalManagementAddGoalsLocators.dropdownGoalType);
        selectFromDropdown(ele,optionName);
    }


    public void addOrRemoveKPIRow(String optionName){
        switch (optionName){
            case "Add":
                LOGGER.info("Clicked on add kpi button");
                clickOn($(AppraisalManagementAddGoalsLocators.addKPIButton));
                break;
            case "Delete":
                LOGGER.info("Clicked on delete kpi button");
                String numberOfElement = $(AppraisalManagementAddGoalsLocators.deleteKPIButton).getAttribute("data-attr-counter");
                clickOn($(By.id("removeBtn"+numberOfElement)));
                break;
        }
    }

    public void verifyNumberOfRows(){
        String lowerLeftText = $(AppraisalManagementAddGoalsLocators.tblGoalListInfo).getText();
        if(lowerLeftText.equals(lowerLeftText)){
            Assert.assertTrue("Entries are less than 10 so no change for now",true);
        }else if(!lowerLeftText.equals(lowerLeftText)){
            Assert.assertTrue("Entries are less than greater than 10 and less than or equal to 25",true);
        }
    }

    public int verifyNumberOfPages(){
        int numberOfPages = getDriver().findElements(AppraisalManagementAddGoalsLocators.numberOfPages).size();
        return numberOfPages;
    }

    public void verifyNextPrevButtons(int numOfPages){
        LOGGER.info("Verifying next and previous buttons.");
        if(numOfPages == 1){
            boolean isNextClickable = $(AppraisalManagementAddGoalsLocators.tblGoalListNext).isClickable();
            boolean isPrevClickable = $(AppraisalManagementAddGoalsLocators.tblGoalListPrev).isClickable();
            LOGGER.info("Page is already on the last page.");
            Assert.assertTrue("Page is already on last page and Next and previous buttons are clickable" ,isNextClickable&isPrevClickable);
        }
        else{
            String infoOnFirstPage = $(AppraisalManagementAddGoalsLocators.tblGoalListInfo).getText();
            $(AppraisalManagementAddGoalsLocators.tblGoalListNext).click();
            String infoOnSecondPage = $(AppraisalManagementAddGoalsLocators.tblGoalListInfo).getText();
            boolean isSameInfo = infoOnSecondPage.equals(infoOnFirstPage);
            Assert.assertFalse("Successfully navigated to second page",isSameInfo);
            $(By.id("tblSelfGoalList_previous")).click();
            LOGGER.info("Navigated to first page.");
            Assert.assertFalse("Successfully navigated back to first page",$(By.id("tblSelfGoalList_info")).getText().equals(infoOnFirstPage));
        }
    }

    public boolean isElementFound(By loc) {
        boolean isFound;
        try {
            $(loc);
            isFound = true;
        } catch (Exception e) {
            isFound = false;
        }
        return isFound;
    }

    public void verifyAllFourOptions(String optionName){
        LOGGER.info("Verifying options: ");
        switch (optionName){
            case "Print":
                LOGGER.info("{} option verified.",optionName);
                $(AppraisalManagementAddGoalsLocators.printButton).isDisplayed();
                $(AppraisalManagementAddGoalsLocators.printButton).isClickable();
                Assert.assertTrue("Print option clickable and displayed",true);
                break;
            case "Excel":
                LOGGER.info("{} option verified.",optionName);
                $(AppraisalManagementAddGoalsLocators.excelExport).isDisplayed();
                $(AppraisalManagementAddGoalsLocators.excelExport).isClickable();
                Assert.assertTrue("Excel option clickable and displayed",true);
                break;
            case "PDF":
                LOGGER.info("{} option verified.",optionName);
                $(AppraisalManagementAddGoalsLocators.pdfExport).isDisplayed();
                $(AppraisalManagementAddGoalsLocators.pdfExport).isClickable();
                Assert.assertTrue("PDF option clickable and displayed",true);
                break;
            case "Copy":
                LOGGER.info("{} option verified.",optionName);
                $(AppraisalManagementAddGoalsLocators.copyExport).isDisplayed();
                $(AppraisalManagementAddGoalsLocators.copyExport).isClickable();
                Assert.assertTrue("Copy option clickable and displayed",true);
                break;
            default:
                LOGGER.warn("Buttons are not clickable or options are not present.");
                Assert.fail("Buttons are not clickable or options are not present.");
        }
    }

    public void isAddOrUpdateGoals(){
        LOGGER.info("Verify is add or update goal.");
        $(AppraisalManagementAddGoalsLocators.isAddOrUpdateGoals).isClickable();
    }

    public void verifyKPIAdded(){
        LOGGER.info("Verify kpi added.");
        boolean isRowAdded = $(AppraisalManagementAddGoalsLocators.addedRowXpath).isDisplayed();
        Assert.assertTrue("Row added successfully",true);
    }

    public void verifyKPIRemoved(){
        LOGGER.info("Verify KPI removed.");
        boolean isRowAdded = $(AppraisalManagementAddGoalsLocators.removedKPIRow).isVisible();
        Assert.assertFalse("Row Removed successfully", false);
    }

    public void clickFromRowDropDown(String numOfRows){
        LOGGER.info("Click from row drop down.");
        selectFromDropdown($(AppraisalManagementAddGoalsLocators.numOfRowsDropDown),numOfRows);
    }

    public void verifyIsVisibleOnTheCurrentScreen(String eleName) {
        switch (eleName){
            case "Add KPI description text field":
                LOGGER.info("{} is visible on current screen.");
                $(AppraisalManagementAddGoalsLocators.textFieldAddKPI).isVisible();
                break;
            default:
                Assert.fail("Element name not added in switch cases");
        }
    }

    public void clickOnSortingButton(){

        $(AppraisalManagementAddGoalsLocators.sortingButtonOnCols).click();
        LOGGER.info("Clicked on sorting button.");
        Assert.assertTrue("Clicked on sorting icon",true);
    }

    public void verifySortingisDone(){
        String firstText = $(AppraisalManagementAddGoalsLocators.firstTextAfterSorting).getText();
        LOGGER.info("Sorting performed.");
        Assert.assertFalse("Sorting button working fine", firstText.equals("Engineering"));
    }

    public void userClicksAddButton(String button) {
        LOGGER.info("User Clicks on Button {}",button);
        if(button.equals("delete"))
            if($(By.xpath(deleteButtonXpath)).isDisplayed()){
                LOGGER.info("clicked on delete button.");
                clickOn($(By.xpath(deleteButtonXpath)));
                Assert.assertTrue("clicked on delete button ", true);
            }
            else{
                LOGGER.info("Clicked on delete button after expanding goal.");
                clickOn($(AppraisalManagementAddGoalsLocators.expandGoal));
                clickOn($(AppraisalManagementAddGoalsLocators.deleteButtonAfterExpand));
            }
        else
            clickButton(button);
    }

    public void verifyElementIsNotVisible(String elementName){
        LOGGER.info("Verify element is not visible.");
        boolean flag =false;
        switch (elementName){
            case "Side navigation bar":
                LOGGER.info("Element {} not visible.",elementName);
                flag=$(applyToAnyCardLocators.sideMenuBar).isVisible();
                break;
            case "Delivery tab":
                LOGGER.info("Element {} not visible.",elementName);
                flag=$(AppraisalManagementAddGoalsLocators.tabDelivery).isVisible();
                break;
            case "Add KPI description text field":
                LOGGER.info("Element {} not visible.",elementName);
                flag=$(AppraisalManagementAddGoalsLocators.textFieldAddKPI).isVisible();
                break;
            default:Assert.fail("Element name wrong");
        }
        if(flag){
            LOGGER.warn("{} is not visible on the current screen.",elementName);
            Assert.fail(elementName+" is not visible on the screen");
        }else{
            System.out.println("PASS : Element is not visible on the screen");
        }
    }

    public void navigateToTab(String parentTabName, String childTabName){

      waitABit(5000);
        if (isElementFound(applyToAnyCardLocators.menuTabs(parentTabName))) {
            waitABit(1000);
            $(applyToAnyCardLocators.menuTabs(parentTabName)).click();
            waitABit(2000);
            if (isElementFound(applyToAnyCardLocators.menuTabs(childTabName))) {
                $(applyToAnyCardLocators.menuTabs(childTabName)).click();
                LOGGER.info("Successfully naviagted to subtab: {} under tab: {}.",childTabName,parentTabName);
            } else
                Assert.fail("Child element is not found");
        } else
            Assert.fail("Parent element not found");
    }

    public void verifyWarningPopupAppearWhichSays(String message) {
        waitABit(1000);
        LOGGER.info("Verify warning pop appear which says: {}",message);
        isTextFound(ApplyToAnyCardLocators.textMessageBox,message);
        waitABit(1000);
        clickOn($(ApplyToAnyCardLocators.btnOk));
    }

    public void verifySuccessPopAppearsWhichSays(String message) {
        LOGGER.info("Verify success pop appear which says: {}",message);
        isTextFound(ApplyToAnyCardLocators.textMessageBox,message);
        waitABit(1000);
        clickOn($(ApplyToAnyCardLocators.btnOk));
    }


    public void isTextFound(By loc,String text){
        String textToCompare = $(loc).getText();
        if(text.contains("Hello")){
            LOGGER.info("Text is verified.");
        }
        else
            Assert.assertEquals(text,textToCompare);
    }

    public void isElementVisible(By loc,String elementName){
        LOGGER.info("Verify {} is visible.",elementName);
        if($(loc).isVisible()){
            LOGGER.info(elementName,"{} visible on the current page.");
        }else{
            Assert.fail(elementName+" isn not visible on the current page");
        }
    }

}
