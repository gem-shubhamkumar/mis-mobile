package com.gemini.mis.selectors;

import org.openqa.selenium.By;

import java.security.PublicKey;

public class LeaveBalanceSelectors {
    public static By cardProfile = By.xpath("//section[@class='widget-user']/div[@id='html-content-holder']");
    public static By cardLeaveBalance =By.xpath("//div[@class='col-xl-6 dashboard-column ui-sortable']/section[@id='LeaveBalance']");
    public static By gridLeaveHistory =By.xpath("//div[@class='modal-content']/div[@id='divLeave']");
    public static By btnLeaveHistoryClose =By.xpath("//button[@id='btnClose']");
    public static By textNumberOfEntries = By.xpath("//div[@id='tblLeaveGrid_info']");
}
