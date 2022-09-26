package com.gemini.mis.pages;

import com.gemini.mis.selectors.KnowledgeBaseLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

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

                    }   else if(subMenuItem.equals("add New Document")){
                        getDriver().findElement(selector.addNewDocument).click();
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
                    System.out.println("switched to alert");
                    $(selector.crossIconOnTagName).click();
                    Assert.assertTrue("Clicked on cross Icon",true);
                    break;
                case "closeButton":
                    $(selector.tagNameCloseButton).click();
                    Assert.assertTrue("Clicked on close Button",true);
                    break;
                case "addButton":
                    $(selector.tagNameSaveButton).click();
                    Assert.assertTrue("clicked on save button on the tag name", true);
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

    @Step("Check that no record added in the grid")
    public void isEmptyGrid(){
        String gridText = $(selector.emptyGridInAddNewDocs).getText();
        String lowerText = $(selector.recordCountLowerLeft).getText();

        boolean noRecordInGrid = gridText.equals("No data available in table");
        boolean lowerValue = lowerText.equals("Showing 0 to 0 of 0 entries");
        Assert.assertTrue("No record added",noRecordInGrid & lowerValue);
    }




}
