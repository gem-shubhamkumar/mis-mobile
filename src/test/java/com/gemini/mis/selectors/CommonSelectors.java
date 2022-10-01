package com.gemini.mis.selectors;


public class CommonSelectors {

    public static String loginMsg = "//div[@class='loginMsgDiv']";

    public static String homePageXpath = "//input[@id='name']";

    public static String logo = "//img[@id='GemLogo']";
    public static String designation = "//div[@id='designation']";

    public static String cardToggleMinimize = "//h3[text()='card']//parent::header/div/ul/li/a[@data-title='buttonName']";

    public static String cardToggleMaximize = "(//h3[text()='card']//parent::header/div/ul/li)[2]/a";

    public static String collapsedCard = "//section[contains(@class, 'panel-collapsed')]/header/h3";

    public static String fullScreenCard = "//section[contains(@class, 'panel-expanded')]/header/h3";


    public static String sideNav = "//span[@class='lbl' and text()='tabName']";


    public static String paginationButtons = "//li[contains(@class, 'paginate_button buttonName')]";
    public static String select = "//select[@attribute='value']";
    public static String genericButton = "//button[@id='ids']";
    public static String buttonPath= "//button[text()='BUTTONNAME']";
    public static String genericPath="//*[text()='VAR']";
    public static By enteriesNo=By.xpath("//select[contains(@name,'length')]");
    public static String OptionOfEntry="//select[contains(@name,'length')]//option[@Value='VAR']";
public static By searchBox=By.xpath("//input[@placeholder='Search']");
public static By saveButton=By.xpath("//button[@id='btnAddReferral']");
}
