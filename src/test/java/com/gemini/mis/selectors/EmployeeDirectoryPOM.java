package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class EmployeeDirectoryPOM {
    public static By firstRow= By.xpath("(//tr[@class='even'][@role='row'])[1]");
    public static By mailBox=By.xpath("//span//a//i[@class='fa fa-envelope']");
    public static By firstEmployeeName=By.xpath("(//a[contains(@onclick,'showProfilePopup')])[1]");
    public static By ProfileWindow=By.xpath("(//div[@class='modal-body'])[1]");
}
