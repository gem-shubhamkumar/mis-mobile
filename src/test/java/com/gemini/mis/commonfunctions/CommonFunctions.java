package com.gemini.mis.commonfunctions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class CommonFunctions extends PageObject {

    //declaration
    private final static Logger log = LoggerFactory.getLogger("SampleLogger");
    /*-------------------------------------------------------------------------------------------------------*/

    // added by shubham.kumar
    // create driver
    public WebDriver getMISDriver() {
        EnvironmentVariables objEnvVar = SystemEnvironmentVariables.createEnvironmentVariables();
        String driverType = objEnvVar.getProperty("webdriver.driver");
        System.out.println(driverType); // chrome | appium
        AndroidDriver appiumDriver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
        WebDriver webDriver = getDriver();
        return driverType.equalsIgnoreCase("appium") ? appiumDriver : webDriver;
    }

    // added by shubham.kumar
    public String getDriverType() {
        EnvironmentVariables objEnvVar = SystemEnvironmentVariables.createEnvironmentVariables();
        return objEnvVar.getProperty("webdriver.driver");
    }

    public void scrollToText() {
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView" +
//                "(text(\"" + text + "\"));"));

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "up",
                "percent", 0.75
        ));

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

    public void hoverOver(WebElement element) {
        SerenityActions action = new SerenityActions(getDriver());
        action.moveToElement(element).perform();
    }

    public void hover(WebElement element) throws Exception {
        try {
            withAction().moveToElement(element);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public String[] listOptionsInSelectDropdown(WebElement Element) {
        Select dropdown = new Select(Element);
        List<WebElement> options = dropdown.getOptions();
        String[] optionTexts = new String[options.size()];
        for (int i = 0; i < options.size(); i++) {
            optionTexts[i] = options.get(i).getText();
        }
        return optionTexts;
    }

    //Returns the last modified file
    public File getLastModifiedFile(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedFileTime = Long.MIN_VALUE;
        File choseFile = null;
        if (files != null) {
            for (File file : files) {
                if (file.lastModified() > lastModifiedFileTime) {
                    choseFile = file;
                    lastModifiedFileTime = file.lastModified();
                }
            }
        }
        return choseFile;
    }

    public void validateLastModifiedText(By export_button, By pdf_button, String FilePath, String comparingString) throws IOException {
        $(export_button).click();
        $(pdf_button).click();
        waitABit(9000);
        PDDocument document = PDDocument.load(getLastModifiedFile(FilePath));
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieve text from PDF document
        String text = pdfStripper.getText(document);
        //Close the document
        if (text.contains(comparingString)) {
            Assert.assertTrue("The pdf which is downloaded is correct", true);
        } else {
            Assert.fail("The pdf which is downloaded is not correct");
        }
        document.close();
    }

    //Defining validation type for validating text
    public enum ValidationType {
        EQUALS {
            @Override
            public boolean doProcessRequest(String actualText, String expectedText) {
                boolean conditionValidation = false;
                if (StringUtils.equalsIgnoreCase(actualText, expectedText)) {
                    conditionValidation = true;
                }
                return conditionValidation;
            }
        },
        CONTAINS {
            @Override
            public boolean doProcessRequest(String actualText, String expectedText) {
                boolean conditionValidation = false;
                if (StringUtils.containsIgnoreCase(actualText, expectedText)) {
                    conditionValidation = true;
                }
                return conditionValidation;
            }
        };

        public abstract boolean doProcessRequest(String actualText, String expectedText);
    }

    //Validating equals or contains text
    public boolean validateText(String ActualText, String Validation, String ExpectedText) {
        ValidationType command = ValidationType.valueOf(EnumUtils.toEnumLookupValue(Validation));
        if (null == command) {
            log.info("Unknown Request Type");
        }
        return command.doProcessRequest(ActualText, ExpectedText);
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

    public void changeFocusOfElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].focus();", element);
    }
}