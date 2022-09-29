package com.gemini.mis.selectors;

public class LNSASelectors {
    public static String week = "(//input[@type='checkbox' and @class='selectAll'])[1]";

    public static String activeDays = "(//input[@type='checkbox' and @class='selectAll'])[1]//parent::div//following-sibling::div/div";
    public static String closeModal = "//button[@data-dismiss='modal']";
    public static String LNSARequest = "//span[contains(@class, 'nav-link-in')]";
    public static String sortRowLNSA = "//th[@aria-controls='tblLnsaStatusGrid']";

    public static String statusButton = "//td//a";
}
