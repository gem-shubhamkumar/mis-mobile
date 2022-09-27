package com.gemini.mis.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public boolean validateText(String Act_Text, String Type, String Exp_Text) {
        switch(Type) {
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
                    log.info("Actual text contains the expected text");
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

}
