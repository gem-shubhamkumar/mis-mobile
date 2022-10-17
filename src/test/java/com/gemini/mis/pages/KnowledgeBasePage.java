package com.gemini.mis.pages;

import com.gemini.mis.implementations.KnowledgeBasePageImplementation;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class KnowledgeBasePage extends PageObject {


    KnowledgeBasePageImplementation knowledgeBasePageImplementation;


    @Step("Step to goto menu item and click on menu subItem")
    public void gotoMenuItemAndSubItem(String menuItem, String subMenuItem) {
        knowledgeBasePageImplementation.gotoMenuItemAndSubItem(menuItem, subMenuItem);
    }

    @Step("Click on element.")
    public void clickOnElement(String elemName) {
        knowledgeBasePageImplementation.clickOnElement(elemName);
    }


    @Step("Click on {0} Button")
    public void clickOnButton(String buttonName) {
        knowledgeBasePageImplementation.clickOnButton(buttonName);
    }

    @Step("click on ok on warning popup")
    public void clickOnOk() {
        knowledgeBasePageImplementation.clickOnOk();
    }

    @Step("click on ok on tag Added")
    public void clickOnOkonTagAdded() {
        knowledgeBasePageImplementation.clickOnOkonTagAdded();
    }

    @Step
    public void isEmptyGrid() {
        knowledgeBasePageImplementation.isEmptyGrid();
    }

    @Step("click reload button")
    public void clickOnReloadButton() {
        knowledgeBasePageImplementation.clickOnReloadButton();
    }

    @Step("Check whether this is last page")
    public void isLastPage() {
        knowledgeBasePageImplementation.isLastPage();
    }

    @Step("is popup open or not")
    public void isPopUpOpens() {
        knowledgeBasePageImplementation.isPopUpOpens();
    }

    @Step
    public void enterFolderName(String folderName) {
        knowledgeBasePageImplementation.enterFolderName(folderName);
    }

    @Step
    public void clickOkOnfolderAdd() {
        knowledgeBasePageImplementation.clickOkOnfolderAdd();
    }

    @Step("Check whether the popup is scrollable or not")
    public void isDocScrollable() {
        knowledgeBasePageImplementation.isDocScrollable();
    }

    @Step("Click on sorting icon")
    public void clickOnSortingIcon() {
        knowledgeBasePageImplementation.clickOnSortingIcon();
    }

    @Step
    public void isButtonHidden(String buttonName) {
        knowledgeBasePageImplementation.isButtonHidden(buttonName);
    }

    @Step
    public void isButtonVisible(String buttonName) {
        knowledgeBasePageImplementation.isButtonVisible(buttonName);
    }

    @Step
    public void selectElement() {
        knowledgeBasePageImplementation.selectElement();
    }

    @Step
    public void inputNameInInputBox(String inputName) {
        knowledgeBasePageImplementation.inputNameInInputBox(inputName);
    }


    @Step
    public void rightClickOnElement(String elemName) {
        knowledgeBasePageImplementation.rightClickOnElement(elemName);
    }

    @Step
    public void fillThefieldsAtDocumentUpload(String fileType) {
        knowledgeBasePageImplementation.fillThefieldsAtDocumentUpload(fileType);
    }

    @Step
    public void verifyFolderCreated(String folderName) {
        knowledgeBasePageImplementation.verifyFolderCreated(folderName);
    }

    @Step
    public void clickOnOKOnPopupFolder() {
        knowledgeBasePageImplementation.clickOnOKOnPopupFolder();
    }

    @Step
    public void verifyUserNotNavigated() {
        knowledgeBasePageImplementation.verifyUserNotNavigated();
    }

    @Step
    public void isMenuOpen() {
        knowledgeBasePageImplementation.isMenuOpen();
    }

    @Step
    public void selectNumberFromDropDown() {
        knowledgeBasePageImplementation.selectNumberFromDropDown();
    }

    @Step
    public void verifyRowsAfterDropDown() {
        knowledgeBasePageImplementation.verifyRowsAfterDropDown();
    }

    @Step
    public void clickOnSearchAndInput(String testString) {
        knowledgeBasePageImplementation.clickOnSearchAndInput(testString);
    }

    @Step
    public void verifyRecordAvailability(String str) {
        knowledgeBasePageImplementation.verifyRecordAvailability(str);
    }

    @Step
    public void verifyChangeAfterClick(String navButton) {
        knowledgeBasePageImplementation.verifyChangeAfterClick(navButton);
    }

    @Step
    public void clickOnNextPrev(String navButton) {
        knowledgeBasePageImplementation.clickOnNextPrev(navButton);
    }

    @Step
    public void isFirstPage() {
        knowledgeBasePageImplementation.isFirstPage();
    }

    @Step
    public void gotoLastPage() {
        knowledgeBasePageImplementation.gotoLastPage();
    }

    @Step
    public void verifyLastPage() {
        knowledgeBasePageImplementation.verifyLastPage();
    }

    @Step
    public void enterSearchBarText(String str) {
        knowledgeBasePageImplementation.enterSearchBarText(str);
    }

    @Step
    public void checkViewDocumentSearchBar() {
        knowledgeBasePageImplementation.checkViewDocumentSearchBar();
    }

    @Step
    public void clickOnSpecifiedButton(String btnName) {
        knowledgeBasePageImplementation.clickOnSpecifiedButton(btnName);
    }

    @Step
    public void renameFolder(String name) {
        knowledgeBasePageImplementation.renameFolder(name);
    }

    @Step
    public void clickOnOkWhileDocUploadPopup() {
        knowledgeBasePageImplementation.clickOnOkWhileDocUploadPopup();
    }

    @Step
    public void isAddButtonWorking() {
        knowledgeBasePageImplementation.isAddButtonWorking();
    }

    @Step
    public void isDuplicateFolder() {
        knowledgeBasePageImplementation.isDuplicateFolder();
    }
}
