package com.gemini.mis.selectors;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

//Selectors specific to MIS
public class GenericSelectors extends PageObject {

    public By loader = By.xpath("//img[@class='loading-image-round']");

    //login page
    public By geminiLogo = By.xpath("(//img[contains(@src,'GeminiLogo')])[1]");
    public By loginMsg = By.xpath("//div[@class='loginMsgDiv']");
    public By loginForm = By.xpath("//form[contains(@class,'login-form')]");
    public By txtUsername = By.xpath("//input[@id='username']");
    public By txtPassword = By.xpath("//input[@id='password']");
    public By btnSignIn = By.xpath("//input[@value='Sign in']");

    //landing page
    public By sidebarToggle = By.xpath("//button[@id='show-hide-sidebar-toggle']");
    public By sidebarList = By.xpath("//ul[@class='side-menu-list']");
    public By btnChangePW = By.xpath("//a[text()='Change AD Password']");
    public By btnuser = By.xpath("//button[contains(@id,'user')]");
    public By dropdownMenu = By.xpath("//div[contains(@class,'dropdown-menu')]");
    public By dialogWindowHeader = By.xpath("//div[@class='modal-header'])[17]");

}
