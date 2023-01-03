package com.gemini.mis.selectors;

import org.openqa.selenium.By;
public class XpathForLeaveManagementTab
{
    public static By textBox(String nameOfElement)
    {
        return By.xpath("//input[@id=\""+nameOfElement+"\"]");
    }
    public static By column(String nameOfElement)
    {
        return By.xpath("//th[contains(text(),\""+nameOfElement+"\")]");
    }
    public static By dropdown(String nameOfElement)
    {
        return By.xpath("//select[@id=\""+nameOfElement+"\"]");
    }
    public static By searchBox(String num)
    {
        return By.xpath("(//input[@type='search'])["+num+"]");
    }
    public static By nextBtn(String tabName)
    {
        return By.xpath("//a[@aria-controls=\""+tabName+"\"and contains(text(),'Next')]");
    }
    public static By previousBtn(String tabName)
    {
        return By.xpath("//a[@aria-controls=\""+tabName+"\"and contains(text(),'Previous')]");
    }
    public static By sideNav(String sideNav)
    {
        return By.xpath("//span[contains(text(),\""+sideNav+"\")]");
    }
    public static By dropdownOptions(String num)
    {
        return By.xpath("(//li[@class='magenta with-sub opened']/ul/li/a/span)["+num+"]");
    }
    public static By list(String tagName)
    {
        return By.xpath("//li[@role=\""+tagName+"\"]");
    }
    public static By inputItem(String type)
    {
        return By.xpath("//input[@placeholder=\""+type+"\"]");
    }
    public static By textArea(String id)
    {
        return By.xpath("//textarea[@id=\""+id+"\"]");
    }
    public static By successAlertPopup(String tag)
    {
        return By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
    }

    public static By requestAlertPopup(String tag)
    {
        return By.xpath("//div[@class='sweet-alert showSweetAlert visible ']/"+tag+"");
    }
    public static By calendarBtn(String id)
    {
        return By.xpath("//div[@id=\""+id+"\"]/div/span");
    }
    public static By labelText(String text)
    {
        return By.xpath("//label[contains(text(),\""+text+"\")]");
    }
    public static By halfDayOptions(String halfDayOption)
    {
        return By.xpath("//input[@id=\""+halfDayOption+"\"]/parent::label");
    }
    public static By btnType(String btnName)
    {
        return By.xpath("//button[contains(text(),\""+btnName+"\")]");
    }
    public static By isTabActive(String tabName)
    {
        return By.xpath("//span[contains(text(),\""+tabName+"\")]/parent::a");
    }
    public static By submitBtn(String num)
    {
      return By.xpath("(//input[@class='btn btn-success'])["+num+"]");

    }
    public static By button(String btnName)
    {
        return By.xpath("//button[@class=\""+btnName+"\"]");

    }
    public static By exportOptions(String btnName)
    {
        return By.xpath("//span[contains(text(),\""+btnName+"\")]");

    }
    public static By exportBtn(String num)
    {
        return By.xpath("(//a[@class='dt-button buttons-collection'])["+num+"]");
    }

    public static By copyBtn(String num)
    {
        return By.xpath("(//a[@class='dt-button buttons-copy buttons-html5'])["+num+"]");
    }
    public static By printBtn(String num)
    {
        return By.xpath("(//a[@class='dt-button buttons-print'])["+num+"]");
    }
    public static By excelBtn(String num)
    {
        return By.xpath("(//a[@class='dt-button buttons-excel buttons-html5'])["+num+"]");
    }
    public static By pdfBtn(String num)
    {
        return By.xpath("(//a[@class='dt-button buttons-pdf buttons-html5'])["+num+"]");
    }
    public static By dropdownNum(String num)
    {
        return By.xpath("(//div[@class='dataTables_length'])["+num+"]");
    }
    public static By expandBtn(String num)
    {
        return By.xpath("(//td[@tabindex='0'])["+num+"]");
    }
    public static By compOffDetails(String className)
    {
        return By.xpath("//li[@data.json-dt-row='0']/span[@class=\""+className+"\"]");
    }
    //li[@data.json-dt-row='0']/span[@class="dtr-title"]
    public static By columnHeading(String num)
    {
        return By.xpath("(//th[@tabindex='0'])["+num+"]");
    }
    public static By paginationNext(String num)
    {
        return By.xpath("(//li[@class='paginate_button next'])["+num+"]");
    }
    public static By paginationPrevious(String num)
    {
        return By.xpath("(//li[@class='paginate_button previous'])["+num+"]");
    }


    public static By heading = By.xpath("//h5");
    public static By newHeading = By.xpath("(//h4)[3]");
    public static By tab = By.xpath("//a[@role='tab']/span");
    public static By outingDate = By.xpath("(//td[@tabindex='0'])[21]");

    public static By tooltip = By.xpath("//a[@data-trigger='hover']");
    public static By dateRange =By.xpath("//span[@id='select2-financialYearScroll-container']");
    public static By copyToClipboard =By.xpath("//div[@id='datatables_buttons_info']/h2");

    public static By pages =By.xpath("//li/a[@tabindex='0']");
    public static By cancelBtn =By.xpath("(//button[@class='btn btn-sm btn-danger'])[2]");

    public static By viewBtn =By.xpath("(//button[@class='btn btn-sm btn-info'])[2]");
    public static By dateOnCalendar(String date)
    {
        return By.xpath("//td[contains(text(),\""+date+"\")]");
    }
    public static By nextCal = By.xpath("//th[@class='next']");
    public static By detailBox = By.xpath("//td[@class='child']");
    public static By calNext = By.xpath("//th[@class='next']");
    public static By dataIsPresent = By.xpath("(//tr[@role='row'])[13]");
    public static By leaveManagement = By.xpath("(//span[@class='lbl'])[7]");
    public static By leaveApply = By.xpath("//span[text()='Apply']");
    public static By popUp = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
    public static By popupMessage = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/p");

}
