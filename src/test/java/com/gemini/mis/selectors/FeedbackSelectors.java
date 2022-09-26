package com.gemini.mis.selectors;

import com.sun.xml.bind.WhiteSpaceProcessor;

public class FeedbackSelectors {

    public static String provideFeedbackButton = "//button[text()='Provide Feedback']";
    public static String submitButton = "//button[contains(@onclick, 'submitFeedback')]";
    public static String tableRow = "//table[@id='ids']/tbody/tr";
    public static String search = "//input[@type='search']";
}
