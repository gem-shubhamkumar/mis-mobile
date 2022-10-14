package com.gemini.mis.commonfunctions;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonFunctions extends PageObject {


    private final static Logger log = LoggerFactory.getLogger("SampleLogger");


    public  void hover(WebElement element) throws Exception {
        try {
            withAction().moveToElement(element);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
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
    public void scrollByPixels(String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("scrollBy" + pixels);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void dragAndDrop(WebElement FromElement, WebElement ToElement) {
        SerenityActions action = new SerenityActions(getDriver());
        action.clickAndHold(FromElement).moveToElement(ToElement).release(ToElement).build().perform();
    }



    public void copyPaste(String TextToCopy, WebElement PasteToElement) {
        StringSelection stringSelection = new StringSelection(TextToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);         //copy
        PasteToElement.sendKeys(Keys.CONTROL + "V");      //paste
    }

    public String[] formatDate(String Pattern, String Date) throws ParseException {
        //apply pattern according to first part of Date
        java.util.Date format = new SimpleDateFormat(Pattern).parse(Date);
        String[] formattedDate = format.toString().split(" ");
        return formattedDate;
    }

    //Defining validation type for validating text
    public enum ValidationType {
        EQUALS{
            @Override
            public boolean doProcessRequest(String actualText,String expectedText) {
                boolean conditionValidation = false;
                if (StringUtils.equalsIgnoreCase(actualText,expectedText)) {
                    conditionValidation = true;
                }
                return conditionValidation;
            }
        },
        CONTAINS{
            @Override
            public boolean doProcessRequest(String actualText,String expectedText) {
                boolean conditionValidation = false;
                if (StringUtils.containsIgnoreCase(actualText,expectedText)) {
                    conditionValidation = true;
                }
                return conditionValidation;
            }
        };
        public abstract boolean doProcessRequest(String actualText,String expectedText);
    }

    //Validating equals or contains text
    public boolean validateText(String ActualText, String Validation, String ExpectedText) {
        ValidationType command = ValidationType.valueOf(EnumUtils.toEnumLookupValue(Validation));
        if (null == command) {
            log.info("Unknown Request Type");
        }
        return command.doProcessRequest(ActualText,ExpectedText);
    }

}