package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.implementations.FormPageImplementations;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormsPage {
    CommonFunctions utils;
    FormPageImplementations form;


    @Step("Navigate to tabs")
    public void navigateParentAndChildTab(String parentTab, String childTab) {
        form.navigateTabs(parentTab, childTab);
    }


    @Step("Close the application")
    public void closeApplication() {

        form.close();
    }

    @Step("Scroll to element")
    public void scroll(By element) {
        form.scroll(element);

    }

    @Step("Download and Delete a file")
    public void isFileDownloaded(String downloadPath, String fileName) {
        utils.isFileDownloaded(downloadPath, fileName);
    }

    @Step("Upload File")
    public void uploadFile(By Location, String fileLoc) {

        form.upload(Location,fileLoc);
    }

    @Step("Hover Over")
    public void hoverOver(By element) throws Exception {
        utils.hover((WebElement) element);

    }

}
