package com.gemini.mis.selectors;

<<<<<<< HEAD
=======
import org.openqa.selenium.By;
>>>>>>> f7aeee926639e321abdc2e653eafa75ce9832045

public class CommonSelectors {

    public static String loginMsg = "//div[@class='loginMsgDiv']";

    public static String homePageXpath = "//input[@id='name']";

    public static String logo = "//img[@id='GemLogo']";
    public static String designation = "//div[@id='designation']";

    public static String cardToggleMinimize = "//h3[text()='card']//parent::header/div/ul/li/a[@data-title='buttonName']";

    public static String cardToggleMaximize = "(//h3[text()='card']//parent::header/div/ul/li)[2]/a";

    public static String collapsedCard = "//section[contains(@class, 'panel-collapsed')]/header/h3";

    public static String fullScreenCard = "//section[contains(@class, 'panel-expanded')]/header/h3";

<<<<<<< HEAD

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
=======
    public static By menuTabs(String tabName){
        return By.xpath("//span[contains(text(),'"+tabName+"')]");
    }
    public static By linkNumberOfLeave(String leaveType){
        return By.xpath("//table[@class='tbl-typical text-left']/tbody/tr/td[text()='"+leaveType+"']//following-sibling::td/a");
    }

    public static By sideMenuBar= By.xpath("//div[@class='jspPane']/ul");
    public static By btnMenu =By.xpath("//button[@id='show-hide-sidebar-toggle']");
    public static By textMessageBox =By.xpath("//p[@class='lead text-muted ']");
    public static By btnOk = By.xpath("//button[text()='OK']");
    public static By btnLogout =By.xpath("(//a[@class='dropdown-item']/span)[4]");
    public static By btnClose =By.xpath("//button[@id='btnskillsClose']");



>>>>>>> f7aeee926639e321abdc2e653eafa75ce9832045
}
