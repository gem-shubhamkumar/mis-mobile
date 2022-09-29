package com.gemini.mis.selectors;

import com.sun.xml.bind.WhiteSpaceProcessor;

public class FeedbackSelectors {

    public static String provideFeedbackButton = "//button[text()='Provide Feedback']";
    public static String submitButton = "(//button[contains(text(), 'Submit')])[2]";
    public static String tableRow = "//table[@id='ids']/tbody/tr";
    public static String search = "//input[@type='search']";
    public static String sortRow = "//th[@aria-controls='tblFeedback']";
    public static String viewButton = "(//td/div/button)[size]";
    public static String tooltip = "//div[@class='tooltip-inner']";
    public static String export = "//a/span[text()='name']";
    public static String exportOptions = "//div[@class='dt-button-collection']";
    public static String copyClipboard = "//div[@id='datatables_buttons_info']/h2";
}
