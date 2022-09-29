package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FeedbackPage extends PageObject {


    @Step
    public void verifySubmitFeedbackTabOpen() {
        String heading = $(By.tagName("h5")).getText();

        Assert.assertTrue(StringUtils.equals(heading, "Submit Feedback"));
    }

    @Step
    public void enterFeedback(String value) {
        $(By.id("feedback")).type(value);
    }

    @Step
    public void verifyData( String data, String tab) {
        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback" : {
                 tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
                    break;
            }
            case "LNSA" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblLnsaStatusGrid")));
                    break;
            }
        }
        for (WebElement row: tableRow
        ) {
            if(row.getText().contains(data)) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) Assert.assertTrue("Record found", true);
        else Assert.fail("Record not found");
    }

    @Step("Verify No matching records found")
    public void verifyData(String tab) {
        int flag = 0;
        List<WebElement> tableRow = new ArrayList<>();
        switch (tab) {
            case "Feedback" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback")));
                break;
            }
            case "LNSA" : {
                tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblLnsaStatusGrid")));
                break;
            }
        }
        for (WebElement row: tableRow
        ) {
            if(row.getText().contains("No matching records found")) {
                flag = 1;
                break;
            }
        }
        if(flag == 1) Assert.assertTrue("Record not found", true);
        else Assert.fail("Record found");
    }

    @Step
    public void searchData(String dataToBeSearch) {
        $(By.xpath(FeedbackSelectors.search)).type(dataToBeSearch);
    }

    public void clickRow() {
        if($(By.xpath(FeedbackSelectors.sortRow)).getAttribute("aria-sort") == null){
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();
        }
        else {
            $(By.xpath(FeedbackSelectors.sortRow)).waitUntilPresent().click();

        }

    }

    public void verifyOrder(String order) {
        Assert.assertEquals($(By.xpath(FeedbackSelectors.sortRow)).getAttribute("aria-sort"), order);
    }

    public int totalRow() {
        return getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback"))).size();

    }

    public void hoverOverView() {

        moveTo(By.xpath(FeedbackSelectors.viewButton.replace("size", Integer.toString(totalRow()))));
    }

    public void tooltipText(String text) {
        Assert.assertEquals($(By.xpath(FeedbackSelectors.tooltip)).getText(), text);
    }

    public void verifyMessage(String message) {
        Assert.assertTrue($(By.id("feedbackMessage")).isDisabled());
        Assert.assertEquals($(By.id("feedbackMessage")).getAttribute("value"), message);
    }

    public void veifyExportOptions() {
        getDriver().switchTo().activeElement();
        Assert.assertTrue($(By.xpath(FeedbackSelectors.exportOptions)).isPresent());
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

    public void verifyFileDownloaded(String fileType) {
            waitABit(2000);
            switch (fileType) {
                case "excel" : {
                    File f = new File("C:\\Users\\ay.garg\\Downloads\\All Feedback List.xlsx");
                        Assert.assertTrue(f.exists());
                        break;
                }
                case "pdf" : {
                    File f = new File("C:\\Users\\ay.garg\\Downloads\\All Feedback List.pdf");
                    Assert.assertTrue(f.exists());
                    break;
                }
                default: {
                    Assert.fail("Unsupported file format " + fileType);

                }
            }

    }

    public void verifyPrintTab() {
        List<String> browserTabs = new ArrayList<String>(getDriver().getWindowHandles());
        System.out.println(browserTabs.get(0));
        System.out.println(browserTabs.get(1));
        System.out.println(browserTabs.get(2));
        getDriver().switchTo().window(browserTabs.get(1));
        System.out.println(getTitle());
        Assert.assertTrue(getTitle().contains("Gemini"));
        withAction().sendKeys(Keys.TAB).build().perform();
        withAction().sendKeys(Keys.ENTER).build().perform();
//        getDriver().close();
        getDriver().switchTo().window(browserTabs.get(0));
    }

    public void verifyCopy() {
        getDriver().switchTo().defaultContent();
        Assert.assertEquals($(By.xpath(FeedbackSelectors.copyClipboard)).getText(), "Copy to clipboard");
    }
}
