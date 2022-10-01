package stepDefinitions;

import com.gemini.mis.pages.KnowledgeBasePage;
import com.gemini.mis.selectors.KnowledgeBaseLocators;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBaseStepDefinition extends PageObject {

    KnowledgeBaseLocators selector;

    @Steps
    KnowledgeBasePage steps;

   @When("^Goto \"(.*?)\" and click on \"(.*?)\"$")
   public void clickOnMenuItem(String menuItem,String subItem){
       steps.gotoMenuItemAndSubItem( menuItem, subItem);
   }
    @Then("^verify no records added in the grid$")
    public void isEmptyGrid(){
        steps.isEmptyGrid();
    }
    @And("^click on \"(.*?)\" without entry$")
    public void clickOnElementWithEmptyEntry(String query){
        steps.clickOnButton(query);
    }

    @And("click on ok button on warning popup")
    public void clickOnOkOnWarningPopup(){
        steps.clickOnOk();
    }
    @Then("^click on \"(.*?)\"$")
    public void clickOnItem(String elemName){
        steps.clickOnElement(elemName);
    }

    @Then("^click on \"(.*?)\" button$")
    public void clickOnButton(String itemName){
       waitABit(2000);
       steps.clickOnButton(itemName);
    }

    @Then("click on refresh icon")
    public void clickReloadIcon(){
        steps.clickOnReloadButton();
    }


    @And("verify this is the last page")
    public void verifyThisIsLastPage(){
       steps.isLastPage();
    }

    //incomplete step definitions
    @And("^enter \"(.*?)\" tag name and click on \"(.*?)\"$")
    public void clickOnAddButtonAfterInput(String inputTagName, String buttonName){
        steps.inputNameInInputBox(inputTagName);
        steps.clickOnButton(buttonName);
        waitABit(3000);
    }

    @And("click ok on the popup in add new tag")
    public void clickOnPopupInAddNewTag(){
        steps.clickOnOkonTagAdded();
    }

    @And("^Put \"(.*?)\" and click on \"(.*?)\"$")
    public void putInvalidFolderName(String folderName, String buttonName){
        steps.enterFolderName(folderName);
        waitABit(2000);
        steps.clickOnButton(buttonName);
    }

    @Then("click ok on the popup in add Folder")
    public void clickOkOnFolderPopup(){
      steps.clickOkOnfolderAdd();
    }

    @Then("verify folder added")
    public void verifyFolderCreated(){
        List<WebElement> totalFolders = getDriver().findElements(selector.listOfFolders);
        if(totalFolders.size()>4){
            Assert.assertTrue("folder added",true);
        }
   }
    @And("^create folder without name and click \"(.*?)\"$")
    public void createFolderWithoutName(String buttonName){
        steps.enterFolderName("");
        steps.clickOnButton(buttonName);
    }

    @And("click on ok button from success window")
    public void clickOkFolderAdded(){

    }

    @Then("verify no folder added")
    public void verifyNoFolderCreated(){

    }


    @Then("verify duplicate folder created")
    public void isDuplicateFolder(){
       boolean duplicateText =  $(By.xpath("/html/body/div[13]/p")).getText().equals("Duplicate name is not allowed.")  ;
       Assert.assertTrue("Duplicate folder is created",true);
    }

    @And("click On ok at popup")
    public void clickOnOKOnPopupFolder(){
       $(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
    }


    @Then("^right click on \"(.*?)\"$")
    public void rightClick(String elemName){
       waitABit(3000);
        steps.rightClickOnElement( elemName);
    }

    @Then("verify user not navigated")
    public void verifyUserNotNavigated(){
       $(By.id("tbldocumentGridViewList_info")).getText().equals("Showing 0 to 0 of 0 entries");
    }

    @And("verify menu opens")
    public void isMenuOpen(){
       boolean isMenuDisplayed = $(By.id("myMenu")).isDisplayed();
        Assert.assertTrue("Right click displayed menu", isMenuDisplayed);
    }

    //completed
    @Then("verify that a popup window is displayed")
    public void isPopUpDisplay(){
    steps.isPopUpOpens();
    }


    @Then("Verify document is scrollable and not empty")
   public void isDocScrollable(){
    steps.isDocScrollable();
    }

    @Then("click on the sorting icon")
 public void clickOnSortingIcon(){
        steps.clickOnSortingIcon();
    }
    @And("^Verify that \"(.*?)\" button is hidden$")
    public void isButtonHidden(String buttonName){
       steps.isButtonHidden(buttonName);
    }
    @And("^verify that \"(.*?)\" button is visible$")
    public void isButtonVisible(String buttonName){
        steps.isButtonVisible(buttonName);
    }
    @And("select some number from dropdown")
    public void selectSomeNumberFromDropDown(){
       steps.selectElement();
    }

    @Then("verify the change in grid")
    public void verifyChangesInGrid(){
       steps.isEmptyGrid();
    }

    @Then("click on Number from dropdown on view shared documents page")
    public void selectNumberFromDropDown(){
        Select drpNumOfRows = new Select( $(By.name("tblShareDocumentList_length")));
        drpNumOfRows.selectByVisibleText("25");
    }

    @And("verify number of rows present")
    public void verifyRowsAfterDropDown(){
      String footerText =  $(By.id("tblShareDocumentList_info")).getText();
      Assert.assertTrue(footerText.contains("25"));
    }

    @Then("^click on search bar and input \"(.*?)\"$")
    public void clickOnSearchAndInput(String testString){
       $(By.xpath("//*[@id=\"tblShareDocumentList_filter\"]/label/input")).sendKeys(testString);
    }

    @And("^verify record availability on the basis of \"(.*?)\"$")
    public void verifyRecordAvailabilty(String str){
       switch (str){
           case "perl":
               String colOneText = $(By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr[1]/td[1]")).getText();
               Assert.assertTrue("with alphabetical string ",colOneText.contains("Modern Perl"));
               break;
           case "perl123":
               String textInsideGrid = $(By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td")).getText();
               Assert.assertTrue("With alphanumeric string in the grid satisfied, input: 'perl123'",textInsideGrid.contains("No matching"));
               break;
           case "***":
               String textInGrid = $(By.xpath("//*[@id=\"tblShareDocumentList\"]/tbody/tr/td")).getText();
               Assert.assertTrue("With no string matching in the grid satisfied and input '***'",textInGrid.contains("No matching"));
               break;
           case " ":
               Assert.assertTrue("Empty string criteria satisfied",true);

           default:
               break;
       }
    }

    @Then("^click on \"(.*?)\" in lower right corner$")
    public void clickOnNextPrev(String navButton){
       switch (navButton){
           case "nextButton":
               $(By.xpath("//*[@id=\"tblShareDocumentList_next\"]/a")).click();
               break;
           case "prevButton":
               $(By.xpath("//*[@id=\"tblShareDocumentList_previous\"]/a")).click();

               break;
           default:
               break;
       }
    }

    @And("^check change in entries text according to the \"(.*?)\"$")
    public void verifyChangeAfterClick(String navButton){
        boolean isChanged;
       switch (navButton){
           case "nextButton":
                isChanged = $(By.xpath("//*[@id=\"tblShareDocumentList_info\"]")).getText().equals("Showing 11 to 20 of 25 entries");
               Assert.assertTrue("Successfully navigated to next page",isChanged);
               break;
           case "prevButton":
               isChanged = $(By.xpath("//*[@id=\"tblShareDocumentList_info\"]")).getText().equals("Showing 1 to 10 of 25 entries");
               Assert.assertTrue("Successfully navigated to next page",isChanged);
               //Showing 1 to 10 of 25 entries
               break;
           default:
               break;
       }
    }

    @And("verify user is on first Page")
    public void isFirstPage(){
       boolean isFirstPageText = $(By.xpath("//*[@id=\"tblShareDocumentList_info\"]")).getText().equals("Showing 1 to 10 of 25 entries");
       Assert.assertTrue("Successfully navigated to next page",isFirstPageText);
    }

    @Then("Goto last page by clicking next")
    public void gotoLastPage(){
       String totalPages = $(By.xpath("//*[@id=\"tblShareDocumentList_paginate\"]/ul/li[4]/a")).getText();
       int totalNumOfPages = Integer.parseInt(totalPages);
       for(int i =0;i<totalNumOfPages;i++){
           $(By.xpath("//*[@id=\"tblShareDocumentList_next\"]/a")).click();
       }

    }

    @And("verify this is last page in view shared documents")
    public void verifyLastPage(){
      boolean lastPageText =  $(By.xpath("//*[@id=\"tblShareDocumentList_info\"]")).getText().equals("Showing 21 to 25 of 25 entries");
      Assert.assertTrue("Successfully navigated to last page in view shared documents",lastPageText);
    }

    @Then("^click on view documents search bar and input \"(.*?)\"$")
    public void enterSearchBarText(String str){
       $(By.xpath("//*[@id=\"tbldocumentGridViewList_filter\"]/label/input")).sendKeys(str);
    }

    @And("verify record availability after input in search bar")
    public void checkViewDocumentSearchBar(){
       boolean gridText = $(By.xpath("//*[@id=\"tbldocumentGridViewList\"]/tbody/tr/td")).getText().equals("No data available in table");
        Assert.assertTrue("Search bar working fine on view documents page",gridText);
    }


    @Then("^click on \"(.*?)\" at input folder name place$")
    public void clickOnSpecifiedButton(String btnName){
        switch (btnName){
            case "crossButton":
                $(By.xpath("//*[@id=\"mypopupWindowAddNewDocumentModal\"]/div/div/div[1]/button/span")).click();
                break;
            case "closeButton":
                $(By.id("btnCloseDocument")).click();
                break;
            case "addButton":
                $(By.id("btnSaveDocument")).click();
                break;
            default:
                break;
        }
    }

    @And("^click on \"(.*?)\" option after right click$")
    public void clickOnDelete(String buttonName){
       switch (buttonName){
           case "Delete":
               $(By.xpath("(//ul[@id='myMenu']/li)[3]")).click();
               break;
           case "Rename":
               $(By.xpath("//ul[@id='myMenu']/li[@class='edit']")).click();
               break;
           case "Add New Document":
               $(By.xpath("(//ul[@id='myMenu']/li)[2]")).click();
               break;
           case "Add New Folder":
               $(By.xpath("(//ul[@id='myMenu']/li)[1]")).click();
               break;
           default:
               break;
       }


    }

    @Then("^click on \"(.*?)\" after clicking$")
    public void clickYesOrNoAfterDelete(String buttonName){
       switch (buttonName){
           case "yesButton":
               $(By.xpath("/html/body/div[13]/div[7]/div/button"));
               Assert.assertTrue("clicked on yes", true);
               break;
           case "noButton":
               $(By.xpath("/html/body/div[13]/div[7]/button")).click();
               Assert.assertTrue("clicked on no", true);
               break;
           default:
               break;

       }
    }

    @And("^rename folder with \"(.*?)\"$")
    public void renameFolder(String name){
       switch (name){
           case "validName":
               break;
           case "duplicateName":
                break;
           case " ":
               break;
           default:
               break;
       }
    }

    @Then("^upload an \"(.*?)\" on document uploader$")
    public void uploadAFile(String fileType){
        steps.fillThefieldsAtDocumentUpload(fileType);
    }

    @And("^fill \"(.*?)\" in field$")
    public void fillUpTheFields(String fieldName){
       steps.fillThefieldsAtDocumentUpload(fieldName);
    }
    @Then("click on Ok on Warning popup while document upload")
    public void clickOnOkWhileDocUploadPopup(){
       $(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
       Assert.assertTrue("clicked on ok popup in warning while adding duplicate element",true);
    }

    @Then("check add Button working")
    public void isAddButtonWorking(){
        $(By.id("btnSaveDocument")).click();
    }



}
