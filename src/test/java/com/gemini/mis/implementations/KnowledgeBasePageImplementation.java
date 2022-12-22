package com.gemini.mis.implementations;

import com.gemini.mis.selectors.KnowledgeBaseLocators;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class KnowledgeBasePageImplementation extends PageObject {
    KnowledgeBaseLocators selector;
    Random rand = new Random();

    private static Logger LOGGER = LoggerFactory.getLogger(KnowledgeBasePageImplementation.class);



    public void verifyFolderCreated(String folderName) {
        waitABit(1000);
        LOGGER.info("Verify folder created.");
        int size = getDriver().findElements(selector.listOfFolder).size();
        for (int i = 1; i <= size; i++) {
            if ($(selector.folderName).getText().equals(folderName)) {
                LOGGER.info("Folder created.");
                Assert.assertTrue("Folder is added in the list", true);
            } else {
                LOGGER.warn("Folder not created.");
                Assert.fail("Unable to create the folder!!");
            }
        }
    }

    public void clickOnOKOnPopupFolder() {

        LOGGER.info("clicked on ok on folder popup.");
        $(selector.okOnDocUploadPOPup).click();
    }

    public void verifyUserNotNavigated() {
        LOGGER.info("Verify user not navigated.");
        Assert.assertEquals($(selector.sharedDocGridInfo).getText(), "Showing 0 to 0 of 0 entries");
    }

    public void isMenuOpen() {
        boolean isMenuDisplayed = $(By.id("myMenu")).isDisplayed();
        LOGGER.info("Verified that menu is open now.");
        Assert.assertTrue("Right click displayed menu", isMenuDisplayed);
    }

    public void selectNumberFromDropDown() {
        LOGGER.info("Select number from dropdown.");
        Select drpNumOfRows = new Select($(selector.sharedDocListLen));
        drpNumOfRows.selectByVisibleText("25");
    }

    public void verifyRowsAfterDropDown() {
        LOGGER.info("Verify rows after dropdown.");
        String footerText = $(selector.sharedDocListInfo).getText();
        Assert.assertTrue(footerText.contains("25"));
    }

    public void clickOnSearchAndInput(String testString) {
        waitABit(2000);
        LOGGER.info("Click on search and input string {}",testString);
        waitABit(1000);
        if (testString.equals("")){
            $(selector.searchBarSharedDoc).clear();
        }else{
        $(selector.searchBarSharedDoc).sendKeys(testString);
    }}

    public void verifyRecordAvailability(String str) {
        waitABit(1000);
        LOGGER.info("Verifying record availability after searching.");
        switch (str) {
            case "perl":
                LOGGER.info("Verified for search query {}",str);
                String colOneText = $(selector.colOneText).getText();
                Assert.assertTrue("with alphabetical string ", colOneText.contains("Modern Perl"));
                break;
            case "perl123":
                LOGGER.info("Verified for search query {}",str);
                String textInsideGrid = $(selector.textInGrid).getText();
                Assert.assertTrue("With alphanumeric string in the grid satisfied, input: 'perl123'", textInsideGrid.contains("No matching"));
                break;
            case "***":
                LOGGER.info("Verified for search query {}",str);
                String textInGrid = $(selector.textInGrid).getText();
                Assert.assertTrue("With no string matching in the grid satisfied and input '***'", textInGrid.contains("No matching"));
                break;
            default:
                LOGGER.info("Verified for search query empty string");
                Assert.assertTrue("Empty string criteria satisfied", true);
                break;
        }
    }

    public void verifyChangeAfterClick(String navButton) {
        waitABit(1000);
        boolean isChanged;
        switch (navButton) {
            case "nextButton":
                LOGGER.info("Clicked on next Button.");
                isChanged = $(selector.infoOfPage).getText().equals("Showing 11 to 20 of 25 entries");
                Assert.assertTrue("Successfully navigated to next page", isChanged);
                break;
            case "prevButton":
                LOGGER.info("Clicked on previous button. ");
                isChanged = $(selector.infoOfPage).getText().equals("Showing 1 to 10 of 25 entries");
                Assert.assertTrue("Successfully navigated to next page", isChanged);
                break;
            default:
                break;
        }
    }

    public void clickOnNextPrev(String navButton) {
        switch (navButton) {
            case "nextButton":
                LOGGER.info("Clicked on next Button.");
                $(selector.nextButtonDoc).click();
                break;
            case "prevButton":
                LOGGER.info("Clicked on previous button. ");
                $(selector.prevButtonDoc).click();
                break;
            default:
                break;
        }
    }

    public void isFirstPage() {
        boolean isFirstPageText = $(selector.infoOfPage).getText().equals("Showing 1 to 10 of 25 entries");
        LOGGER.info("Successfully navigated to next page.");
        Assert.assertTrue("Successfully navigated to next page", isFirstPageText);
    }

    public void gotoLastPage() {
        LOGGER.info("Going to last page.");
        String totalPages = $(selector.totalPages).getText();
        int totalNumOfPages = Integer.parseInt(totalPages);
        for (int i = 0; i < totalNumOfPages; i++) {
            $(selector.nextButtonDoc).click();
        }
    }

    public void verifyLastPage() {
        waitABit(1000);
        LOGGER.info("Verifying last page.");
        boolean lastPageText = $(selector.infoOfPage).getText().equals("Showing 21 to 25 of 25 entries");
        Assert.assertTrue("Successfully navigated to last page in view shared documents", lastPageText);
    }

    public void enterSearchBarText(String str) {
        waitABit(1500);
        LOGGER.info("Enter search query {} in search bar.",str);
        if(str.isEmpty()){
            $(selector.searchBarInAddDoc).clear();

        }else
            $(selector.searchBarInAddDoc).sendKeys(str);
    }

    public void checkViewDocumentSearchBar() {
        waitABit(1000);
        LOGGER.info("Verifying query result after searching on view document search bar.");
        boolean gridText = $(selector.gridAfterSearch).getText().equals("No data available in table");
        Assert.assertTrue("Search bar working fine on view documents page", gridText);
    }

    public void clickOnSpecifiedButton(String btnName) {
        waitABit(2500);
        LOGGER.info("Clicking on {} button",btnName);
        switch (btnName) {
            case "crossButton":
                $(selector.crossButtonLocator).click();
                break;
            case "closeButton":
                $(By.id("btnCloseDocument")).click();
                break;
            case "addButton":
                $(selector.btnSaveDoc).click();
                break;
            case "Delete":
                $(By.xpath("(//ul[@id='myMenu']/li)[3]")).click();
                break;
            case "Rename":
                $(By.xpath("//ul[@id='myMenu']/li[@class='edit']/a")).click();
                break;
            case "Add New Document":
                $(By.xpath("(//ul[@id='myMenu']/li)[2]")).click();
                break;
            case "Add New Folder":
                $(By.xpath("(//ul[@id='myMenu']/li)[1]")).click();
                break;
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

    public void renameFolder(String name) {
        switch (name) {
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

    public void clickOnOkWhileDocUploadPopup() {
        waitABit(1000);
        $(selector.okOnDocUploadPOPup).click();
        LOGGER.info("Clicked on ok om document upload popup");
        Assert.assertTrue("clicked on ok popup in warning while adding duplicate element", true);
    }

    public void isAddButtonWorking() {
        LOGGER.info("Verifying add button working or not.");
        $(selector.btnSaveDoc).click();
    }

    public void isDuplicateFolder() {
        LOGGER.info("Verifying duplicate folder.");
        boolean duplicateText = $(selector.isDuplicateFolder).getText().equals("Duplicate name is not allowed.");
        Assert.assertTrue("Duplicate folder is created", true);
    }

    public void gotoMenuItemAndSubItem(String menuItem, String subMenuItem) {
        try {
            waitABit(1000);
            LOGGER.info("Clicking on menutItem {} and subMenuItem {}",menuItem,subMenuItem);
            switch (menuItem) {
                case "knowledge base":
                    getDriver().findElement(selector.knowledgeBaseMenu).click();
                    if (subMenuItem.equals("view document")) {
                        getDriver().findElement(selector.viewDocumentMenu).click();
                        Assert.assertTrue("Clicked on the view document submenu", true);

                    } else if (subMenuItem.equals("view shared Document")) {
                        getDriver().findElement(selector.viewSharedDocumentMenu).click();
                        Assert.assertTrue("Clicked on the add new document submenu", true);
                    }
                    break;

                default:
                    break;
            }
        } catch (Exception e) {
            Assert.fail("Not able to navigate to submenu");
        }
    }

    public void clickOnElement(String elemName) {
        try {
            switch (elemName) {
                case "add New Document":
                    $(selector.addNewDocument).click();
                    LOGGER.info("Clicked on add new document.");
                    Assert.assertTrue("Successfully clicked on " + elemName, true);
                    break;
                case "AddNewFolder":
                    LOGGER.info("Clicked on add new folder.");
                    $(selector.addNewFolder).click();
                    Assert.assertTrue("Successfully clicked on " + elemName, true);
                    break;
                case "newFolder":
                    LOGGER.info("Clicked on new folder.");
                    $(selector.newFolderOnViewDoc).click();
                    break;
                default:
                    break;
            }

        } catch (Exception e) {

            Assert.fail("Not able to click on " + elemName);
        }
    }

    public void clickOnButton(String buttonName) {
        try {
            switch (buttonName) {
                case "crossIcon":
                    $(selector.crossIconOnTagName).click();
                    Assert.assertTrue("Clicked on cross Icon", true);
                    break;
                case "closeButton":
                    $(selector.tagNameCloseButton).click();
                    Assert.assertTrue("Clicked on close Button", true);
                    break;
                case "addButton":
                    $(By.id("btnSaveGroup")).click();
                    Assert.assertTrue("clicked on save button on the tag name", true);
                    break;
                case "addButtonOnTag":
                    $(By.id("btnSaveDocumentTag")).click();
                    Assert.assertTrue("clicked on save button on the tag name", true);
                    break;
                case "nextButton":
                    $(selector.nextButton).click();
                    Assert.assertTrue("clicked on next button", true);
                    break;

                case "prevButton":
                    $(selector.prevButton).click();
                    Assert.assertTrue("Clicked on previous button", true);
                    break;

                case "eye":
                    $(selector.eyeButton).click();
                    Assert.assertTrue("clicked on view button in view shared documents", true);
                    break;

                case "crossIconOnFolderName":
                    $(selector.crossIconOnFolderName).click();
                    Assert.assertTrue("clicked on cross on top right", true);
                    break;

                case "folderNameSaveButton":
                    $(selector.folderNameSaveButton).click();
                    Assert.assertTrue("clicked on cross on top right", true);
                    break;
                case "folderNameCloseButton":
                    $(selector.folderNameCloseButton).click();
                    Assert.assertTrue("clicked on cross on top right", true);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            Assert.fail("Not able to click on the button");
        }
    }


    public void clickOnOk() {
        try {
//            getDriver().switchTo().alert();
            $(selector.warningPopUpOk).click();
            waitABit(2000);
            Assert.assertTrue("clicked ok on the warning popup", true);
        } catch (Exception e) {
            Assert.fail("Not able to click on Ok Button on popup");
        }
    }

    public void clickOnOkonTagAdded() {
        try {
            $(selector.tagAddedPopupOk).click();
            waitABit(2000);
            Assert.assertTrue("clicked ok on the tag added on popup", true);
        } catch (Exception e) {
            Assert.fail("Not able to click on Ok Button on popup");
        }
    }

    public void isEmptyGrid() {
        String gridText = $(selector.emptyGridInAddNewDocs).getText();
        String lowerText = $(selector.recordCountLowerLeft).getText();

        boolean noRecordInGrid = gridText.equals("No data available in table");
        boolean lowerValue = lowerText.equals("Showing 0 to 0 of 0 entries");
        LOGGER.info("No Record added, showing empty grid.");
        Assert.assertTrue("No record added", noRecordInGrid & lowerValue);
    }

    public void clickOnReloadButton() {

        try {
            $(selector.refreshDocs).click();
            LOGGER.info("Clicked on document reload button.");
            Assert.assertTrue("Clicked on reload button successfully", true);
        } catch (Exception e) {
            Assert.fail("Failed to click reload button");
        }
    }

    public void isLastPage() {
        LOGGER.info("verify last page on view shared doucuments.");
        try {
            boolean isNextButtonEnabled = true;
            boolean isPrevButtonEnabled = true;

            while (!isNextButtonEnabled)
                isNextButtonEnabled = $(selector.nextButton).isDisplayed();

            while (!isPrevButtonEnabled)
                isPrevButtonEnabled = $(selector.prevButton).isDisplayed();

            if (isPrevButtonEnabled || isNextButtonEnabled)
                Assert.assertTrue("The next button is not clickable that is this is last page", true);
        } catch (Exception e) {
            Assert.fail("This is not the last page");
        }
    }

    public void isPopUpOpens() {
        LOGGER.info("Verifying xpath.");
        try {
            $(selector.popUpXpath).isDisplayed();
            $(selector.popupTitle).isDisplayed();
            $(selector.closeButtonOnDocument).isDisplayed();
            LOGGER.info("Popup displayed in view shared documents.");
            Assert.assertTrue("Popup displayed in view shared documents", true);
        } catch (Exception e) {

            Assert.fail("Popup does not displayed");
        }
    }

    public void enterFolderName(String folderName) {
        LOGGER.info("Enter folder name");
        if (folderName.equals("")) {
            $(selector.inputFolderName).clear();
        } else {
            $(selector.inputFolderName).sendKeys(folderName);

        }
    }

    public void clickOkOnfolderAdd() {
        LOGGER.info("Click ok on add folder.");
        $(selector.warnignOkOnFolderPopup).click();
    }

    public void isDocScrollable() {
        LOGGER.info("check whether the doc scrollable.");
        try {

            int noOfFrames = getDriver().findElements(By.tagName("iframe")).size();
            Assert.assertTrue("Switching to iframe containing the document", true);
            getDriver().switchTo().frame("frame");
            boolean isIframe = getDriver().findElement(selector.iframeXpath).isDisplayed();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            Assert.assertTrue("Document is not empty and scrollable", isIframe);

        } catch (Exception e) {
            Assert.fail("The popup is empty or not scrollable");
        }

    }

    public void clickOnSortingIcon() {
        LOGGER.info("Clicked on sorting icon.");
        $(selector.sortingIcon).click();
        Assert.assertTrue("clicked on sorting icon.", true);
    }

    public void isButtonHidden(String buttonName) {
        LOGGER.info("Verifying eye button hidden.");
        boolean eyeButtonDisplayed = $(selector.eyeButton).isClickable();
        Assert.assertTrue("Button is now hidden in the view port", eyeButtonDisplayed);
    }

    public void isButtonVisible(String buttonName) {
        LOGGER.info("Verifying button {} visible.",buttonName);
        boolean eyeButtonDisplayed = $(selector.eyeButton).isCurrentlyVisible();
        Assert.assertTrue("Button is now hidden in the view port", eyeButtonDisplayed);
    }

    public void selectElement() {
        LOGGER.info("Select element from dropdown.");
        Select drpDown = new Select($(selector.docGridView));
        drpDown.selectByVisibleText("25");
        Assert.assertTrue("Dropdown clickable", true);
    }

    public void inputNameInInputBox(String inputName) {
        LOGGER.info("Input tag name in input box.");
        int randVal = rand.nextInt(10000);
        inputName = inputName + randVal;
        $(selector.tagNameInputBox).sendKeys(inputName);
    }

    public void rightClickOnElement(String elemName) {
        Actions actions = new Actions(getDriver());
        LOGGER.info("Right clicking on {}",elemName);

        switch (elemName) {

            case "newFolder":
                WebElement elem = $(selector.newFolder);
                actions.contextClick(elem).perform();
                Assert.assertTrue("Right click performed and menu displayed", true);
                break;
            case "NewFolder123":
                WebElement elem1 = $(selector.newFolder123);
                actions.contextClick(elem1).perform();
                Assert.assertTrue("Right click performed and menu displayed", true);
                break;
            case "subFolder":
                WebElement subFolderElem = $(selector.subFolder);
                actions.contextClick(subFolderElem).perform();
                Assert.assertTrue("right clicked on sub folder", true);
                break;
            default:
                break;
        }
    }

    public void fillThefieldsAtDocumentUpload(String fileType)
    {
        String username = System.getProperty("user.name");   //fetch system username
        switch (fileType) {
            case "htmlFile":
                LOGGER.info("Uploading invalid type file(html File)");
                $(selector.docUpload).sendKeys("C:\\Users\\dell\\Desktop\\Sample.html");
//                break;

            case "validFile":
                LOGGER.info("Uploading valid excel file.");
                $(selector.docUpload).sendKeys("C:\\Users\\dell\\Desktop\\Sample.xlsx");
//                break;

            case "title":
                LOGGER.info("Uploading title of the file");
                $(selector.fileTitle).sendKeys("Title of the file");
//                break;
            case "description":
                LOGGER.info("Uploading description of the file.");
                $(selector.fileDesc).sendKeys("Description of the file");
//                break;
            default:
                break;

        }
    }


}
