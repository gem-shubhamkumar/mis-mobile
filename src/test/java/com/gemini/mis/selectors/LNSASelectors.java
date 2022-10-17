package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class LNSASelectors {
    public static By week = By.xpath("(//input[@type='checkbox' and @class='selectAll'])[6]");

    public static By activeDays = By.xpath("(//input[@type='checkbox' and @class='selectAll'])[1]//parent::div//following-sibling::div/div");
    public static By closeModal = By.xpath("//button[@data-dismiss='modal']");
    public static By LNSARequest = By.xpath("//span[contains(@class, 'nav-link-in')]");
    public static By sortRowLNSA = By.xpath("//th[@aria-controls='tblLnsaStatusGrid']");

    public static By statusButton = By.xpath("//td//a");

}
