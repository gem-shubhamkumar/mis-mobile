package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;



public class FormsPage extends PageObject {
    CommonFunctions utils;

    @Step("Navigate to tabs")
    public void NavigateParentAndChildTab(String parentTab,String childTab){
        utils.navigateToTab(parentTab,childTab);
    }
    @Step("Close the application")
    public void closeApplication(){
        utils.closeApplication();
    }
    @Step("Scroll to element")
    public void scroll(By element){
        utils.scrollToElement(element);

    }
    @Step("Download and Delete a file")
    public void isFileDownloaded(String downloadPath, String fileName){
        utils.isFileDownloaded(downloadPath,fileName);
    }
    @Step("Upload File")
    public void uploadFile(By Location,String fileLoc) throws InterruptedException {
        utils.uploadFile(Location,fileLoc);
    }
    @Step("Hover Over")
    public void hoverOver(By element){
        utils.hoverOver(element);

    }
    }
