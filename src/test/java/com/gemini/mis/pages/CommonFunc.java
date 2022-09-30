package com.gemini.mis.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//Common for any website
public class CommonFunc extends PageObject {

    //declarations
    private final static Logger log = Logger.getLogger(CommonFunc.class.getName());
    EnvironmentVariables conf = SystemEnvironmentVariables.createEnvironmentVariables();
    /*-----------------------------------------------------------------------------------------------------------*/

    public void scrollByPixels(String Pixels) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("scrollBy"+Pixels);
    }

    public void scrollToElement(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)", Element);
    }

    public void dragAndDrop(WebElement FromElement, WebElement ToElement) {
        Actions action = new Actions(getDriver());
        action.clickAndHold(FromElement).moveToElement(ToElement).release(ToElement).build().perform();
    }

    public void copyPaste(String TextToCopy, WebElement PasteToElement) {
        StringSelection stringSelection = new StringSelection(TextToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);         //copy
        PasteToElement.sendKeys(Keys.CONTROL + "V");      //paste
    }

    public boolean validateText(String Act_Text, String Validation, String Exp_Text) {
        switch(Validation) {
            case "equals":
                if (Act_Text.equalsIgnoreCase(Exp_Text)) {
                    log.info("Actual text is equal to the expected text");
                    return true;
                }else {
                    log.info("Actual text is not equal to the expected text. Actual: " + Act_Text + " Expected: " + Exp_Text);
                    return false;
                }
            case "contains":
                if(Act_Text.contains(Exp_Text)) {
                    log.info("Actual text contains the expected text. Actual text: " + Act_Text);
                    return true;
                }else {
                    log.info("Actual text does not contains the expected text. Actual: " + Act_Text + " Expected: " + Exp_Text);
                    return false;
                }
        }
        return false;
    }

    public String[] formatDate(String Pattern, String Date) throws ParseException {
        //apply pattern according to first part of Date
        Date format = new SimpleDateFormat(Pattern).parse(Date);
        String[] formattedDate = format.toString().split(" ");
        return formattedDate;
    }

    public void hoverOver(WebElement Element) {
        Actions action = new Actions(getDriver());
        action.moveToElement(Element).perform();
    }

    public String[] listOptionsInSelectDropdown(WebElement Element) {
        Select dropdown = new Select(Element);
        List<WebElement> options = dropdown.getOptions();
        String[] optionTexts = new String[options.size()];
        for(int i=0; i<options.size() ; i++){
            optionTexts[i] = options.get(i).getText();
        }
        return optionTexts;
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File folder = new File(downloadPath);
        File[] folderContent = folder.listFiles();
        //iterate through all the files to search the required file
        for (int i = 0; i < folderContent.length; i++) {
            if (folderContent[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteFileFromSystem(String downloadPath, String fileName) {
        File folder = new File(downloadPath);
        File[] folderContent = folder.listFiles();
        //iterate through all the files to search the required file
        for (int i = 0; i < folderContent.length; i++) {
            if (folderContent[i].getName().equals(fileName)) {
                folderContent[i].delete();
                log.info("File deleted successfully from the folder");
            }
        }
        Assert.fail("File not found in the folder");
    }
}
