package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class DashboardAttendanceSelectors {

    //Selectors specific to Attendance Card of MIS DashboardAttendance page
    public By txtAttendanceMonth = By.xpath("//span[contains(@aria-labelledby,'selectduration')]");
    public By txtFirstDate_Attendance = By.xpath("(//table[@id='employeesAttendenceTable']//td)[1]");
    /*---------------------------------------------------------------------------------------------------*/

    //Selectors specific and common to MIS
    public By loader = By.xpath("//img[@class='loading-image-round']");

    //Selectors specific to MIS login page
    public By geminiLogo = By.xpath("(//img[contains(@src,'GeminiLogo')])[1]");
    public By loginMsg = By.xpath("//div[@class='loginMsgDiv']");
    public By loginForm = By.xpath("//form[contains(@class,'login-form')]");
    public By txtUsername = By.xpath("//input[@id='username']");
    public By txtPassword = By.xpath("//input[@id='password']");
    public By btnSignIn = By.xpath("//input[@value='Sign in']");

    //Selectors specific to MIS landing page
    public By sidebarToggle = By.xpath("//button[@id='show-hide-sidebar-toggle']");
    public By sidebarList = By.xpath("//ul[@class='side-menu-list']");
    public By btnChangePW = By.xpath("//a[text()='Change AD Password']");
    public By btnuser = By.xpath("//button[contains(@id,'user')]");
    public By dropdownMenu = By.xpath("//div[contains(@class,'dropdown-menu')]");

    //Selectors specific to many pages in MIS
    public By tableHeads = By.xpath("//table//th");
    public By tableData = By.xpath("//table//td");
    public By txtSearch = By.xpath("//input[@type='search']");
    public By successPopup = By.xpath("//div[contains(@class,'sweet-alert')]//h2[text()='Success']");
    public By successIcon = By.xpath("//div[contains(@class,'success animate')]");
    public By successMessage = By.xpath("//p[contains(text(),'successfully')]");
    public By btnOk = By.xpath("//button[text()='OK']");
    public By warningPopup = By.xpath("//div[contains(@class,'sweet-alert')]//h2[text()='Warning']");
    public By warningIcon = By.xpath("//div[contains(@class,'pulseWarning')]");
    public By warningMessage = By.xpath("//p[contains(@class,'text')]");
    public By confirmationPopup = By.xpath("//div[contains(@class,'sweet-alert')]//h2[text()='Are you sure?']");
    public By confirmationMessage = By.xpath("//p[contains(text(),'Are you sure')]");
    public By btnYes = By.xpath("//button[text()='Yes']");
    public By btnNo = By.xpath("//button[text()='No']");

}
