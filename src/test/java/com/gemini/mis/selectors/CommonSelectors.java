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
}
