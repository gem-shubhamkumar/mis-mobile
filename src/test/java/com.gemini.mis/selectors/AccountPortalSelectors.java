package com.gemini.mis.selectors;

import org.openqa.selenium.By;

public class AccountPortalSelectors {
public static By menuTabs(String tabName){
    return By.xpath("//span[contains(text(),'"+tabName+"')]");
}
public static By elementsLoginDetails(int index){
    return By.xpath("(//span[@class='text-secondary text-regular'])["+index+"]");

}
public static By btnSignIn = By.xpath("//input[@type='button' and @id='btnLogin']");
public static By logoGemini = By.xpath("//div[@class='image-container flex items-center text-left']/figure");
public static By logoGreytHR =By.xpath("//span[@class='gt-greytip-header-logo mb-4 block m-auto']");
public static By textFieldGreytHRUsername = By.xpath("//input[@name='username']");
public static By textFieldGreytHRPassword = By.xpath("//input[@name='password']");
public static By textHelloThere = By.xpath("//header[@class='mb-12 text-center']/div");
public static By textFieldMyMISUsername=By.xpath("//input[@type='text' and @placeholder='Username']");
public static By textFieldMyMISPassword=By.xpath("//input[@type='password' and @placeholder='Password']");
public static By btnChangeADPassword = By.xpath("//a[contains(text(),'Change AD Password')]");
//greytHR xpaths
public static By textUsername = By.xpath("(//div[@class='flex-1']/p)[1]");
public static By btnLogIn = By.xpath("//button[contains(text(),'Log in')]");
public static By linkViewLoginHistory = By.xpath("//a[contains(text(),' View Login History ')]");
public static By linkSettings =By.xpath("(//a[@routerlinkactive='is-active']/span)[1]");
public static By linkViewMyInfo = By.xpath("(//a[@class='text-5 text-primary-400 text-regular'])[1]");
public static By listViewMyInfo = By.xpath("//span[@class='info']");
public static By linkAccountAndStatutory = By.xpath("//span[contains(text(),'Accounts & Statutory')]");
public static By textBankNAme = By.xpath("(//span[@class='info ng-star-inserted'])[1]");
public static By textIncorrectCredentials = By.xpath("//div[@class='text-7gpx text-text-default-1 mb-2 font-body']");
public static By listLandingPageElements = By.xpath("//h4[@class='text-secondary-400 text-sm font-semibold my-0']");
public static By btnCross = By.xpath("//button[@type='button']/i");








}
