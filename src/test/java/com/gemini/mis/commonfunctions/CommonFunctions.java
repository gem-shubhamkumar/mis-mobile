package com.gemini.mis.commonfunctions;

import java.io.File;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.*;

public class CommonFunctions extends PageObject {

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File folder = new File(downloadPath);
        File[] folderContent = folder.listFiles();

        for (int i = 0; i < folderContent.length; i++) {
            if (folderContent[i].getName().equals(fileName)) {
                folderContent[i].delete(); // File has been found, it can now be deleted:
                return true;
            }
        }
        return false;
    }
    public void changeFocusOfElement(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].focus();", element);
    }
}