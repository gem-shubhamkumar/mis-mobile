package com.gemini.mis.pages;

import com.beust.ah.A;
import com.gemini.mis.selectors.KnowledgeBaseLocators;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.eo.Se;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class KnowledgeBasePage extends PageObject {

    KnowledgeBaseLocators selector;
    @Step("Step to goto menu item and click on menu subitem")
    public void gotoMenuItemAndSubItem(String menuItem, String subMenuItem){
        try{
            switch (menuItem){
                case "knowledge base":
                    getDriver().findElement(selector.knowledgeBaseMenu).click();
                    if (subMenuItem.equals("view document")){
                        getDriver().findElement(selector.viewDocumentMenu).click();
                        Assert.assertTrue("Clicked on the view document submenu",true);

                    }   else if(subMenuItem.equals("view shared Document")){
                        getDriver().findElement(selector.viewSharedDocumentMenu).click();
                        Assert.assertTrue("Clicked on the add new document submenu",true);
                    }
                    break;

                default:
                    break;
            }
        }catch (Exception e){
            Assert.fail("Not able to navigate to submenu");
            System.out.println(e.getMessage());
        }

    }

    @Step("Click on element.")
    public void clickOnElement(String elemName){
        try{
            switch (elemName){
                case "add New Document":
                    $(selector.addNewDocument).click();
                    Assert.assertTrue("Successfully clicked on "+elemName,true);
                    break;
                case "AddNewFolder":
                    $(selector.addNewFolder).click();
                    Assert.assertTrue("Successfully clicked on "+elemName,true);
                    break;
                case "newFolder":
                    $(By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/span/span[1]")).click();
                    break;
                default:
                    break;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

            Assert.fail("Not able to click on "+elemName);
        }
    }


    @Step("Click on {0} Button")
    public void clickOnButton(String buttonName){
        try{
            switch (buttonName){
                case "crossIcon":
//                    getDriver().switchTo().alert();
//                    System.out.println("switched to alert");
                    $(selector.crossIconOnTagName).click();
                    Assert.assertTrue("Clicked on cross Icon",true);
                    break;
                case "closeButton":
                    $(selector.tagNameCloseButton).click();
                    Assert.assertTrue("Clicked on close Button",true);
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
        }catch(Exception e){
            Assert.fail("Not able to click on the button");
            System.out.println(e.getMessage());
        }
    }

    @Step("click on ok on warning popup")
    public void clickOnOk(){
        try{
//            getDriver().switchTo().alert();
            $(selector.warningPopUpOk).click();
            waitABit(2000);
            Assert.assertTrue("clicked ok on the warning popup", true);
        }catch (Exception e){
            Assert.fail("Not able to click on Ok Button on popup");
        }
    }
    @Step("click on ok on tag Added")
    public void clickOnOkonTagAdded(){
        try{
//            getDriver().switchTo().alert();
            $(selector.tagAddedPopupOk).click();
            waitABit(2000);
            Assert.assertTrue("clicked ok on the tag added on popup", true);
        }catch (Exception e){
            Assert.fail("Not able to click on Ok Button on popup");
        }
    }

    @Step
    public void isEmptyGrid(){
        String gridText = $(selector.emptyGridInAddNewDocs).getText();
        String lowerText = $(selector.recordCountLowerLeft).getText();

        boolean noRecordInGrid = gridText.equals("No data available in table");
        boolean lowerValue = lowerText.equals("Showing 0 to 0 of 0 entries");
        Assert.assertTrue("No record added",noRecordInGrid & lowerValue);
    }

    @Step("click reload button")
    public void clickOnReloadButton(){
        try{
            $(selector.refreshDocs).click();
            Assert.assertTrue("Clicked on reload button successfully", true);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail("Failed to click reload button");
        }
    }

    @Step("Check whether this is last page")
    public void isLastPage(){
        try{
            boolean isNextButtonEnabled = true;
            boolean isPrevButtonEnabled = true;

            while(!isNextButtonEnabled)
                isNextButtonEnabled =  $(selector.nextButton).isDisplayed();

            while(!isPrevButtonEnabled)
                isPrevButtonEnabled =  $(selector.prevButton).isDisplayed();

            if (isPrevButtonEnabled || isNextButtonEnabled)
                 Assert.assertTrue("The next button is not clickable that is this is last page",true);
        }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail("This is not the last page");
        }
    }

    @Step("is popup open or not")
    public void isPopUpOpens(){
        try{
            $(selector.popUpXpath).isDisplayed();
            $(selector.popupTitle).isDisplayed();
            $(selector.closeButtonOnDocument).isDisplayed();
            Assert.assertTrue("Popup displayed in view shared documents",true);
        }catch (Exception e){

            System.out.println(e.getMessage());
            Assert.fail("Popup does not displayed");
        }
    }

    @Step
    public void enterFolderName(String folderName){
        if(folderName.equals("")){
            $(selector.inputFolderName).clear();
        }
        else{
            $(selector.inputFolderName).sendKeys(folderName);

        }
    }

    @Step
    public void clickOkOnfolderAdd(){
        $(selector.warnignOkOnFolderPopup).click();
    }
    @Step("Check whether the popup is scrollable or not")
    public void isDocScrollable(){
        try{

            int noOfFrames = getDriver().findElements(By.tagName("iframe")).size();
            Assert.assertTrue("Switching to iframe containing the document",true);
            getDriver().switchTo().frame("frame");
            boolean isIframe = getDriver().findElement(selector.iframeXpath).isDisplayed();
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0,1000)");
            Assert.assertTrue("Document is not empty and scrollable", isIframe);

       }catch (Exception e){
            System.out.println(e.getMessage());
            Assert.fail("The popup is empty or not scrollable");
        }


    }

    @Step("Click on sorting icon")
    public void clickOnSortingIcon(){
        $(selector.sortingIcon).click();
        Assert.assertTrue("clicked on sorting icon.",true);
    }
    @Step
    public void isButtonHidden(String buttonName){
        boolean eyeButtonDisplayed = $(selector.eyeButton).isClickable();
        Assert.assertTrue("Button is now hidden in the view port",eyeButtonDisplayed);
    }

    @Step
    public void isButtonVisible(String buttonName){
        boolean eyeButtonDisplayed = $(selector.eyeButton).isCurrentlyVisible();
        Assert.assertTrue("Button is now hidden in the view port",eyeButtonDisplayed);
    }

    @Step
    public void selectElement(){
        Select drpDown = new Select($(By.name("tbldocumentGridViewList_length")));
        drpDown.selectByVisibleText("25");
        Assert.assertTrue("Dropdown clickable",true);
            }
   @Step
    public void inputNameInInputBox(String inputName){
        $(selector.tagNameInputBox).sendKeys(inputName);
    }




    @Step
    public void rightClickOnElement(String elemName){
        Actions actions = new Actions(getDriver());

        switch (elemName){

            case "newFolder":
                WebElement elem = $(By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/span/span[1]"));
                actions.contextClick(elem).perform();
                Assert.assertTrue("Right click performed and menu displayed",true);
                break;
            case "NewFolder123":
                WebElement elem1 = $(By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[9]/span/a"));
                actions.contextClick(elem1).perform();
                Assert.assertTrue("Right click performed and menu displayed",true);
            case "subFolder":
                WebElement subFolderElem = $(By.xpath("//*[@id=\"DocumentGrouptree\"]/ul/li[2]/ul/li/span/span[1]"));
                actions.contextClick(subFolderElem).perform();
                Assert.assertTrue("right clicked on sub folder",true);
                break;
            default:
                break;
        }
    }

    @Step
    public void fillThefieldsAtDocumentUpload(String fileType){
        switch (fileType){
            case "htmlFile":
                $(By.id("DocumentToUpload")).sendKeys("C:\\Users\\ar.mishra\\Desktop\\MISAutomatio\\src\\test\\resources\\Result_2022_Aug_01_204842_970197.html");
                break;

            case "validFile":
                $(By.id("DocumentToUpload")).sendKeys("C:\\Users\\ar.mishra\\Desktop\\MISAutomatio\\src\\test\\resources\\EJ_Offshore_QA_exercises.xlsx");
                break;

            case "title":
                $(By.id("txtDescription")).sendKeys("Title of the file");
                break;
            case "description":
                $(By.id("txtFileDiscription")).sendKeys("Description of the file");
                break;
            default:
                break;

        }
    }






}
