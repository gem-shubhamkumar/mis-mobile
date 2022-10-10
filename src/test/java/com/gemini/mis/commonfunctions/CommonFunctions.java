package com.gemini.mis.commonfunctions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;



public class CommonFunctions extends PageObject {

    public  void launchUrl(String url) throws Exception {
        final String stepTtile = "Launch Url";
        try {
            getDriver().get(url);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  String getTitle(String url) throws Exception {
        final String stepTtile = "Get Title";
        String title = "";
        try {
            title = getDriver().getTitle();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return title;
    }

    public  void maximizeBrowser() throws Exception {
        final String stepTtile = "Maximize Browser";
        try {
            getDriver().manage().window().maximize();

        } catch (Exception e) {


            throw new Exception(e.getMessage());
        }

    }

    public  void minimizeBrowser() throws Exception {
        final String stepTtile = "Minimize Browser";
        try {
            getDriver().manage().window().minimize();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public  Dimension getBrowserSize() throws Exception {
        try {
            return getDriver().manage().window().getSize();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void setBrowserSize(int width, int height) throws Exception {
        final String stepTtile = "Set Browser Size";
        try {
            Dimension dimension = new Dimension(width, height);
            getDriver().manage().window().setSize(dimension);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public  void setBrowserPosition(int x, int y) throws Exception {
        final String stepTtile = "Set Browser Position";
        try {
            Point point = new Point(x, y);
            getDriver().manage().window().setPosition(point);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public  Point getBrowserLocation() throws Exception {
        try {
            Point p = getDriver().manage().window().getPosition();
            return p;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /***
     * TimeOuts Handling
     *
     * @throws Exception
     ***/

    public  void waitSec(long seconds) throws Exception {
        try {
            waitABit(seconds * 1000);
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    public  void setImplicitTimeOut(long seconds) throws Exception {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }

    }

    public  void setScriptTimeOut(long seconds) throws Exception {
        try {
            getDriver().manage().timeouts().scriptTimeout(Duration.ofSeconds(seconds));
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void setPageLoadTimeOut(long seconds) throws Exception {
        try {
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
    public  String getWindowHandle() throws Exception {
        try {
            return getDriver().getWindowHandle();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  Set<String> getWindowHandles() throws Exception {
        try {
            return getDriver().getWindowHandles();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * return Current Url
     *
     * @throws Exception
     ***/

    public  String getCurrentURL() throws Exception {
        try {
            return getDriver().getCurrentUrl();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    /**
     * return Page Source
     *
     * @throws Exception
     ***/
    public  String getPageSource() throws Exception {
        try {
            return getDriver().getPageSource();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    /**
     * WebDriver Switch Operations(Window/Frame(name/WebElement/index)
     *
     * @throws Exception
     ***/
    public  void switchToWindow(String nameOfHandle) throws Exception {
        try {
            getDriver().switchTo().window(nameOfHandle);
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void switchToFrame(int index) throws Exception {
        try {
            getDriver().switchTo().frame(index);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void switchToFrame(String nameOrId) throws Exception {
        try {
            getDriver().switchTo().frame(nameOrId);
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void switchToFrame(WebElement frameElement) throws Exception {
        try {
            getDriver().switchTo().frame(frameElement);
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void switchToParentFrame() throws Exception {
        try {
            getDriver().switchTo().parentFrame();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void switchToDefaultContent() throws Exception {
        try {
            getDriver().switchTo().defaultContent();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  WebElement switchToActiveElement() throws Exception {
        try {
            return getDriver().switchTo().activeElement();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    /**
     * WebDriver Alert Operations(Switch/Accept/Dismiss/Alert Input)
     *
     * @throws Exception
     ***/
    public  void switchToAlert() throws Exception {
        final String stepTtile = "Switch To Alert";
        try {
            getDriver().switchTo().alert();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void acceptAlert() throws Exception {
        final String stepTtile = "Accept Alert";
        try {
            getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void dismissAlert() throws Exception {
        final String stepTtile = "Dismiss Alert";
        try {
            getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void alertInput(String input) throws Exception {
        final String stepTtile = "SendKeys To Alert";


        try {
            getDriver().switchTo().alert().sendKeys(input);

        } catch (Exception e) {


            throw new Exception(e.getMessage());
        }

    }

    /****
     * WebElement Operations
     *
     * @throws Exception
     ***/

    public  List<WebElement> getElements(By locator) throws Exception {
        try {
            List<WebElement> elements = getDriver().findElements(locator);
            return elements;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }


    public  String getElementText(WebElement element) throws Exception {
        String elementText = "";
        try {
            elementText = element.getText();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
        return elementText;
    }

    public  List<String> getElementsText(By locator) throws Exception {
        List<String> elementsText = new ArrayList<String>();
        try {
            List<WebElement> elements = getElements(locator);

            for (WebElement element : elements) {
                elementsText.add(getElementText(element));
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
        return elementsText;
    }


    // close Driver or Current tab
    public  void closeCurrentTab() throws Exception {
        try {
            getDriver().close();
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    public  void fileUpload(WebElement elementType, String path) throws Exception {
        final String stepTtile = "File Upload";
        try {
            elementType.sendKeys(path);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public  void pageScroll(int X, int Y) throws Exception {


        final String stepTtile = "Scrolling";
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(+" + X + "," + Y + ")");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public  void scrollByPixels(String pixels) throws Exception{
        try {
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("scrollBy"+pixels);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    public  void scrollToElement(WebElement element) throws Exception {
        try {
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].scrollIntoView(true)", element);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }

    /***
     * Drag and Drop Operation
     *
     * @throws Exception
     ****/

    public  void dragAndDrop(WebElement elementTypeFrom, WebElement elementTypeTo, String fromElementLabel,
                             String toElementLabel) throws Exception {

        String steps = "Drag and Drop";

        try {
            withAction().dragAndDrop(elementTypeFrom, elementTypeTo).build().perform();

        } catch (Exception e) {


            throw new Exception(e.getMessage());
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

    public  void waitForAnElement(By xpath) throws Exception{
        try {
            waitFor(ExpectedConditions.presenceOfElementLocated(xpath));
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
    public boolean isElementFound(By loc) {
        boolean isFound;
        try {
            $(loc);
            isFound = true;
        } catch (Exception e) {
            isFound = false;
        }
        return isFound;
    }


    public void changeFocusOfElement(WebElement element) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].focus();", element);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
    public void clickOn(By elementLoc){
        if ($(elementLoc).isVisible()){
            waitABit(1500);
            $(elementLoc).click();
        }else{
            Assert.fail("Unable to click: by xpath > "+elementLoc);
        }
    }

    public  void copyPaste(String TextToCopy, WebElement PasteToElement) throws Exception {
        try {
            StringSelection stringSelection = new StringSelection(TextToCopy);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);         //copy
            PasteToElement.sendKeys(Keys.CONTROL + "V");      //paste

        }
        catch (Exception e) {
            e.getMessage();
        }
    }
    public String[] formatDate(String Pattern, String Date) throws Exception {
        try {
            //apply pattern according to first part of Date
            java.util.Date format = new SimpleDateFormat(Pattern).parse(Date);
            String[] formattedDate = format.toString().split(" ");
            return formattedDate;

        }
        catch (Exception e) {
            e.getMessage();
        }
        return new String[0];
    }
    public  void hover(WebElement element) throws Exception {
        try {
            withAction().moveToElement(element);
        }
        catch (Exception e) {
            e.getMessage();
        }
    }
    public String[] listOptionsInSelectDropdown(WebElement Element) throws Exception {
        try {
            Select dropdown = new Select(Element);
            List<WebElement> options = dropdown.getOptions();
            String[] optionTexts = new String[options.size()];
            for(int i=0; i<options.size() ; i++){
                optionTexts[i] = options.get(i).getText();
            }
            return optionTexts;


        }
        catch (Exception e) {
            e.getMessage();
        }
        return new String[0];
    }
}