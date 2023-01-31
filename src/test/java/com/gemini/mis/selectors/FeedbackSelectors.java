package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class FeedbackSelectors {

    public static By provideFeedbackButton = By.xpath("//button[text()='Provide Feedback']");

    public static By submitButton(String number) {
        return By.xpath("(//button[@class='btn btn-success'])[" + number + "]");
    }

    public static By tableRow(String id) {
        return By.xpath("//table[@id='" + id + "']/tbody/tr");
    }

    public static By search = By.xpath("//input[@type='search']");
    public static By sortRow = By.xpath("//th[@aria-controls='tblFeedback']");

    public static By viewButton(String size) {
        return By.xpath("(//td/div/button)[" + size + "]");
    }

    public static By tooltip = By.xpath("//div[@class='tooltip-inner']");

    public static By export(String name) {
        return By.xpath("//a/span[text()='" + name + "']");
    }

    public static By exportOptions = By.xpath("//div[@class='dt-button-collection']");
    public static By copyClipboard = By.xpath("//div[@id='datatables_buttons_info']/h2");
}
