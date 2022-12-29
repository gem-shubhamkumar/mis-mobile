package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.KnowledgeBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;


public class KnowledgeBaseStepDefinition extends PageObject {

    @Steps
    KnowledgeBasePage steps;

    @When("^Goto \"(.*?)\" and click on \"(.*?)\"$")
    public void clickOnMenuItem(String menuItem, String subItem) {
        steps.gotoMenuItemAndSubItem(menuItem, subItem);
    }

    @Then("^verify no records added in the grid$")
    public void isEmptyGrid() {
        steps.isEmptyGrid();
    }

    @And("^click on \"(.*?)\" without entry$")
    public void clickOnElementWithEmptyEntry(String query) {
        steps.clickOnButton(query);
    }

    @And("click on ok button on warning popup")
    public void clickOnOkOnWarningPopup() {
        steps.clickOnOk();
    }

    @Then("^click on \"(.*?)\"$")
    public void clickOnItem(String elemName) {
        steps.clickOnElement(elemName);
    }

    @Then("^click on \"(.*?)\" button$")
    public void clickOnButton(String itemName) {
        waitABit(2000);
        steps.clickOnButton(itemName);
    }

    @Then("click on refresh icon")
    public void clickReloadIcon() {
        steps.clickOnReloadButton();
    }


    @And("verify this is the last page")
    public void verifyThisIsLastPage() {
        steps.isLastPage();
    }

    //incomplete step definitions
    @And("^enter \"(.*?)\" tag name and click on \"(.*?)\"$")
    public void clickOnAddButtonAfterInput(String inputTagName, String buttonName) {
        steps.inputNameInInputBox(inputTagName);
        steps.clickOnButton(buttonName);
        waitABit(3000);
    }

    @And("click ok on the popup in add new tag")
    public void clickOnPopupInAddNewTag() {
        steps.clickOnOkonTagAdded();
    }

    @And("^Put \"(.*?)\" and click on \"(.*?)\"$")
    public void putInvalidFolderName(String folderName, String buttonName) {
        steps.enterFolderName(folderName);
        waitABit(2000);
        steps.clickOnButton(buttonName);
    }

    @Then("click ok on the popup in add Folder")
    public void clickOkOnFolderPopup() {
        steps.clickOkOnfolderAdd();
    }

    @Then("^verify folder \"(.*?)\" added$")
    public void verifyFolderCreated(String folderName) {
        steps.verifyFolderCreated(folderName);
    }
//        if(totalFolders.size()>4){
//            Assert.assertTrue("folder added",true);
//        }

    @And("^create folder without name and click \"(.*?)\"$")
    public void createFolderWithoutName(String buttonName) {
        steps.enterFolderName("");
        steps.clickOnButton(buttonName);
    }

    @And("click on ok button from success window")
    public void clickOkFolderAdded() {

    }

    @Then("verify no folder added")
    public void verifyNoFolderCreated() {

    }


    @Then("verify duplicate folder created")
    public void isDuplicateFolder() {
        steps.isDuplicateFolder();
    }

    @And("click On ok at popup")
    public void clickOnOKOnPopupFolder() {
        steps.clickOnOKOnPopupFolder();
    }


    @Then("^right click on \"(.*?)\"$")
    public void rightClick(String elemName) {
        waitABit(4000);
        steps.rightClickOnElement(elemName);
    }

    @Then("verify user not navigated")
    public void verifyUserNotNavigated() {
        steps.verifyUserNotNavigated();
    }

    @And("verify menu opens")
    public void isMenuOpen() {
        steps.isMenuOpen();
    }

    //completed
    @Then("verify that a popup window is displayed")
    public void isPopUpDisplay() {
        steps.isPopUpOpens();
    }


    @Then("Verify document is scrollable and not empty")
    public void isDocScrollable() {
        steps.isDocScrollable();
    }

    @Then("click on the sorting icon")
    public void clickOnSortingIcon() {
        steps.clickOnSortingIcon();
    }

    @And("^Verify that \"(.*?)\" button is hidden$")
    public void isButtonHidden(String buttonName) {
        steps.isButtonHidden(buttonName);
    }

    @And("^verify that \"(.*?)\" button is visible$")
    public void isButtonVisible(String buttonName) {
        steps.isButtonVisible(buttonName);
    }

    @And("select some number from dropdown")
    public void selectSomeNumberFromDropDown() {
        steps.selectElement();
    }

    @Then("verify the change in grid")
    public void verifyChangesInGrid() {
        steps.isEmptyGrid();
    }

    @Then("click on Number from dropdown on view shared documents page")
    public void selectNumberFromDropDown() {
        steps.selectNumberFromDropDown();
    }

    @And("verify number of rows present")
    public void verifyRowsAfterDropDown() {
        steps.verifyRowsAfterDropDown();
    }

    @Then("^click on search bar and input \"(.*?)\"$")
    public void clickOnSearchAndInput(String testString) {
        steps.clickOnSearchAndInput(testString);
    }

    @And("^verify record availability on the basis of \"(.*?)\"$")
    public void verifyRecordAvailability(String str) {
        steps.verifyRecordAvailability(str);
    }

    @Then("^click on \"(.*?)\" in lower right corner$")
    public void clickOnNextPrev(String navButton) {
        steps.clickOnNextPrev(navButton);
    }

    @And("^check change in entries text according to the \"(.*?)\"$")
    public void verifyChangeAfterClick(String navButton) {
        steps.verifyChangeAfterClick(navButton);
    }

    @And("verify user is on first Page")
    public void isFirstPage() {
        steps.isFirstPage();
    }

    @Then("Goto last page by clicking next")
    public void gotoLastPage() {
        steps.gotoLastPage();
    }

    @And("verify this is last page in view shared documents")
    public void verifyLastPage() {
        steps.verifyLastPage();
    }

    @Then("^click on view documents search bar and input \"(.*?)\"$")
    public void enterSearchBarText(String str) {
        steps.enterSearchBarText(str);
    }

    @And("verify record availability after input in search bar")
    public void checkViewDocumentSearchBar() {
        steps.checkViewDocumentSearchBar();
    }


    @Then("^click on \"(.*?)\" at input folder name place$")
    public void clickOnSpecifiedButton(String btnName) {
        steps.clickOnSpecifiedButton(btnName);
    }

    @And("^click on \"(.*?)\" option after right click$")
    public void clickOnDelete(String buttonName) {
        steps.clickOnSpecifiedButton(buttonName);
    }

    @Then("^click on \"(.*?)\" after clicking$")
    public void clickYesOrNoAfterDelete(String buttonName) {
        steps.clickOnSpecifiedButton(buttonName);
    }

    @And("^rename folder with \"(.*?)\"$")
    public void renameFolder(String name) {
        steps.renameFolder(name);
    }

    @Then("^upload an \"(.*?)\" on document uploader$")
    public void uploadAFile(String fileType) {
        steps.fillThefieldsAtDocumentUpload(fileType);
    }

    @And("^fill \"(.*?)\" in field$")
    public void fillUpTheFields(String fieldName) {
        steps.fillThefieldsAtDocumentUpload(fieldName);
    }

    @Then("click on Ok on Warning popup while document upload")
    public void clickOnOkWhileDocUploadPopup() {
        steps.clickOnOkWhileDocUploadPopup();
    }

    @Then("check add Button working")
    public void isAddButtonWorking() {
        steps.isAddButtonWorking();
    }

}
