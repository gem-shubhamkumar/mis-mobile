package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;

import java.util.*;

import java.time.LocalDate;
import java.time.Month;

public class LeaveImplementation extends PageObject {

    Logger log = LoggerFactory.getLogger("SampleLogger");
    //declaration
    WebDriver driver = getDriver();
    CommonFunctions genFunc;

    //This function is for launching site
    public void launchSite()
    {
        driver.get("https://mymis.geminisolutions.com");
        if (getDriver().getTitle().equals("Gemini MIS"))
        {
            Assert.assertTrue("Successfully launched application", true);
        } else
        {
            Assert.fail("Unable to launch application");
            log.info("Unable to launch application");
        }

    }

    //This function is to verify successful login
    public void verifySuccessfulLogin(String pageName)
    {
        waitABit(10000);
        String url="";
        if(pageName.equals("Dashboard Page"))
        {
            url = "https://mymis.geminisolutions.com/Dashboard/Index";
        }
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    //Function verifies tab headings
    public void verifyTabDisplays(String actualHeading)
    {
        waitABit(5000);
        waitABit(5000);
        String expectHeading = "";
        if(StringUtils.equals(actualHeading,"Out Duty/Tour Request Detail"))
        {
            expectHeading = textOf(XpathForLeaveManagementTab.newHeading);
        }
        else {
            expectHeading = textOf(XpathForLeaveManagementTab.heading);
        }
        if(StringUtils.equals(actualHeading,expectHeading))
        {
            Assert.assertTrue("Tab verified successfully", true);
        }
        else
        {
            Assert.fail("Unable to verify tab");
            log.info("Unable to verify tab");
        }
    }

    //Function verifies elements with existing value
    public void verifyAutoPopulated(String fieldName)
    {
        WebElementFacade elementFacade = null;
        boolean isAutoPopulated = true;
        if (StringUtils.contains(fieldName,(",")))
        {
            String[] fieldNames = fieldName.split(",");
            for (int i = 0; i < fieldNames.length; i++) {
                if(StringUtils.contains(fieldNames[i]," "))
                {
                    fieldNames[i]=fieldNames[i].replaceAll(" ","");
                }
                elementFacade = find(XpathForLeaveManagementTab.textBox(fieldNames[i]));
                if (StringUtils.equals(elementFacade.getText()," ")) {
                    isAutoPopulated = false;
                }
            }
            if (isAutoPopulated) {
                Assert.assertTrue("Field are auto populated by default", true);
            } else {
                Assert.fail("Fields are not auto populated");
                log.info("Fields are not auto populated");
            }
        }
        else{
            elementFacade = find(XpathForLeaveManagementTab.textBox(fieldName));
            if (StringUtils.equals(elementFacade.getText()," ")) {
                isAutoPopulated = false;
            }
        }
        if (isAutoPopulated) {
            Assert.assertTrue("Field are auto populated by default", true);
        } else {
            Assert.fail("Fields are not auto populated");
            log.info("Fields are not auto populated");
        }
    }


    //This function is for navigation for sub tabs
    public void navigateToTab(String childTab, String parentTab)
    {
        if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(parentTab)))
        {
            waitABit(5000);
            //clicks on parent tab
            clickOn(XpathForLeaveManagementTab.sideNav(parentTab));
            waitABit(2000);
            //verifies sub tab available
            if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(childTab))) {
                if (StringUtils.equals(childTab,"View Request Status") && StringUtils.equals(parentTab,"LNSA")) {
                    String xpath = "(" + XpathForLeaveManagementTab.sideNav(childTab);
                    xpath = xpath + ")[2]";
                    WebElementFacade elementFacade = find(By.xpath(xpath));
                    elementFacade.click();
                } else {
                    clickOn(XpathForLeaveManagementTab.sideNav(childTab));
                }
            }
            else{
                Assert.fail("Unable to locate child tab");
                log.info("Unable to locate child tab");
            }
        }
        else {
            Assert.fail("Unable to locate parent tab");
            log.info("Unable to locate parent tab");
        }
    }

    //This function is used to navigate tab
    public void navigateToTab(String tabName)
    {
        if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(tabName)))
        {
            waitABit(1000);
            //clicks on parent tab
            clickOn(XpathForLeaveManagementTab.sideNav(tabName));
        }
        else {
            Assert.fail("Unable to locate parent tab");
            log.info("Unable to locate parent tab");
        }
    }

    //This function to select till date
    public void selectTillDate(By loc,String tillDate)
    {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            String date = tillDate.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (StringUtils.equals(elementFacade.getText(),date)) {
                    if (elementFacade.getAttribute("class").contains("disabled"))
                    {
                        continue;
                    } else {
                        elementFacade.click();
                        break;
                    }
                }
            }
        }
        else
        {
            Assert.fail("Unable to click on calendar");
            log.info("Unable to click on calendar");
        }
    }

    //This function to select From date
    public void selectFromDate(By loc,String fromDate)
    {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            clickOn(XpathForLeaveManagementTab.calNext);
            String date = fromDate.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (StringUtils.equals(elementFacade.getText(),date)) {
                    if (elementFacade.getAttribute("class").contains("disabled"))
                    {
                        continue;
                    } else {
                        elementFacade.click();
                        break;
                    }
                }
            }
        }
        else
        {
            Assert.fail("Unable to click on calendar");
            log.info("Unable to click on calendar");
        }
    }

    //This function to verify tooltip
    public void verifyTooltip(String labelText)
    {
        if(isElementVisible(XpathForLeaveManagementTab.labelText(labelText)))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.tooltip);
            clickOn(XpathForLeaveManagementTab.tooltip);
            if(elementFacade.getAttribute("aria-describedby").contains("popover"))
            {
                String tooltipText = elementFacade.getText();
                if(StringUtils.equals(tooltipText,"For ML total days will be considered as total working days"))
                {
                    Assert.assertTrue("Tooltip verified",true);
                }
                else
                {
                    Assert.fail("Unable to verify tooltip");
                    log.info("Unable to verify tooltip");
                }
            }
            else
            {
                Assert.fail("Unable to verify tooltip");
                log.info("Unable to verify tooltip");

            }
        }
    }

    //This function to verify half day options
    public void halfDayOptions(String leaveOptions)
    {
        String[] halfDayOption = leaveOptions.split(",");
        String firstHalf = textOf(XpathForLeaveManagementTab.halfDayOptions("isFirstHalfLeave"));
        String secondHalf =textOf(XpathForLeaveManagementTab.halfDayOptions("isSecondHalfLeave"));
        if(StringUtils.equals(firstHalf,halfDayOption[0]) && StringUtils.equals(secondHalf,(halfDayOption[1])))
        {
            Assert.assertTrue("Half day options verified",true);
        }
        else
        {
            Assert.fail("Unable to verify half day options");
            log.info("Unable to verify half day options");
        }
    }

    //This function to select leave type
    public void selectLeaveType(String leaveType)
    {
        waitABit(5000);
        leaveType = "1 "+leaveType;
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("leaveType"));
        selectFromDropdown(elementFacade,leaveType);
    }

    //This function to enter Text to particular xpath
    public void enterText(By loc, String enterReason)
    {
        if(isElementFoundInGivenTime(loc))
        {
            WebElementFacade elementFacade= find(loc);
            typeInto(elementFacade,enterReason);
        }
        else
        {
            Assert.fail("Unable to type");
            log.info("Unable to type");
        }
    }

    //Function used to verify popup
    public void verifyPopup(String popupText)
    {
        if(isElementFoundInGivenTime(XpathForLeaveManagementTab.successAlertPopup("p")))
        {
            String popUpText = "";
            if(StringUtils.contains("Request processed successfully",popupText))
            {
                popUpText = textOf(XpathForLeaveManagementTab.requestAlertPopup("p"));
            }
            else {
                popUpText = textOf(XpathForLeaveManagementTab.successAlertPopup("p"));
            }
            if(StringUtils.equals(popUpText,popupText))
            {
                Assert.assertTrue("Popup verified",true);
                if(popUpText.contains("successfully"))
                    clickOn(XpathForLeaveManagementTab.btnType("OK"));
            }
            else
            {
                Assert.fail("Unable to verify popUp");
                log.info("Unable to verify popUp");

            }
        }
    }

    //This function to select availability type
    public void availabilityType(String availabilityType)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        if(StringUtils.equals(availabilityType,("Mobile")))
        {
            clickOn(XpathForLeaveManagementTab.textBox("avilableOnMobile"));
        }
        else
        {
            clickOn(XpathForLeaveManagementTab.textBox("avilableOnEmail"));
        }
    }



    //This function to verify Active tab
    public void verifyTabIsActive(String tabName) {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.isTabActive(tabName));
        if (elementFacade.getAttribute("class").contains("active")) {
            Assert.assertTrue("Tab is active", true);
        } else {
            Assert.fail("Tab is not active");
            log.info("Tab is not active");

        }
    }

    //This function to select date from dropdown
    public void selectDateFromDropdown(Date date, By loc)
    {
        String[] dateArray = date.toString().split(" ");
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        String Month = null;
        if(StringUtils.equals(dateArray[1],"Feb"))   //is used to assign numeric value to months
        {
            Month= "02";
        }
        else if(StringUtils.equals(dateArray[1],"Jan"))
        {
            Month= "01";
        }
        else if(StringUtils.equals(dateArray[1],"Mar"))
        {
            Month = "03";
        }
        else if(StringUtils.equals(dateArray[1],"Dec"))
        {
            Month = "12";
        }
        else if(StringUtils.equals(dateArray[1],"Sep"))
        {
            Month = "09";
        }
        else if(StringUtils.equals(dateArray[1],"Oct"))
        {
            Month = "10";
        }
        else if(StringUtils.equals(dateArray[1],"Nov"))
        {
            Month = "11";
        }
        else if(StringUtils.equals(dateArray[1],"Aug"))
        {
            Month = "08";
        }
        else if(StringUtils.equals(dateArray[1],"Jul"))
        {
            Month = "07";
        }
        else if(StringUtils.equals(dateArray[1],"Jun"))
        {
            Month = "06";
        }
        else if(StringUtils.equals(dateArray[1],"May"))
        {
            Month = "05";
        }
        else if(StringUtils.equals(dateArray[1],"Apr"))
        {
            Month = "04";
        }
        String dateToBeSelected = Month+"/"+dateArray[2]+"/2023";
        WebElementFacade elementFacade = find(loc);
        selectFromDropdown(elementFacade,dateToBeSelected);
    }


    //This function to select date for comp off
    //Sometimes date is not present in dropdown
    public void selectDateForCompOff()
    {
        if(isElementVisible(XpathForLeaveManagementTab.dropdown("CompOffDate")))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("CompOffDate"));
            elementFacade.click();
            elementFacade.sendKeys(Keys.DOWN);
            elementFacade.sendKeys(Keys.ENTER);
            if(StringUtils.equals(elementFacade.getText(),(" ")))
            {
                Assert.fail("No date present");
                log.info("No date present");
            }
        }
        else
        {
            Assert.fail("Unable to select from dropdown");
            log.info("Unable to select from dropdown");

        }
    }

    //This function to verify message
    public void verifyMessageFor(String resultInput, String message)
    {
        String actualMsg = textOf(XpathForLeaveManagementTab.list("treeitem"));
        if(!StringUtils.equals(actualMsg,(message)))
        {
            Assert.fail("Unable to verify message");
            log.info("Unable to verify message");
        }
        if(resultInput.contains("Valid"))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.list("treeitem"));
            elementFacade.click();
        }
    }

    //This function to select date
    public void verifyDateSelected(String text)
    {
        waitABit(10000);
        if(!StringUtils.equals(text,textOf(XpathForLeaveManagementTab.dateRange)))
        {
            Assert.fail("Date not selected");
            log.info("Date not selected");
        }
    }

    //This function to verify downloaded file
    public void isFileDownload(String downloadPath, String fileName) {
        boolean isDownloaded = genFunc.isFileDownloaded(downloadPath,fileName);
        if(!isDownloaded)
        {
            Assert.fail("Not downloaded");
            log.info("Not downloaded");
        }
    }

    //Function is verifies another tab
    public void verifyPageOpens()
    {
        if(StringUtils.equals(String.valueOf(getDriver().getWindowHandles()),"1"))
        {
            Assert.fail("Print page did not open");
            log.info("Print page did not open");
        }
    }

    //This function to verify result
    public void verifyResult(String textFiltered, String tabName)
    {
        List<WebElementFacade> list = findAll(XpathforPolicyTab.policyData);
        boolean isSearchResultFound = false;
        for(WebElementFacade elementFacade:list) {
            if (StringUtils.equals(elementFacade.getText(),textFiltered)) {
                isSearchResultFound = true;
                break;
            }
        }
        if(!isSearchResultFound)
        {
            Assert.fail("Unable to filter");
            log.info("Unable to filter");
        }
    }

    //This function to verify outing date
    public void verifyOutingDate(String date)  {
        WebElementFacade elementFacade1 = find(By.xpath("(//div[@class='modal-content'])[3]"));
        genFunc.changeFocusOfElement(elementFacade1);
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.outingDate);
        if(StringUtils.equals(elementFacade.getText().replaceAll("-"," "),date))
        {
            Assert.assertTrue("Outing date verified successfully",true);
        }
        else
        {
            Assert.fail("Outing date not verified");
            log.info("Outing date not verified");
        }
    }

    //This function to type into specific field
    public void type(String text, String fieldName) {
        if(fieldName.contains(" "))
        {
            fieldName=fieldName.replaceAll(" ","");
        }
        WebElementFacade elementFacade = $(XpathForLeaveManagementTab.textBox(fieldName));
        if (elementFacade.isEnabled()) {
            typeInto(elementFacade, text);
            Assert.assertTrue("Text entered successfully", true);
        } else {
            Assert.fail("Unable to enter text");
            log.info("Unable to enter text");
        }
    }

    //This function to verify element in given time
    public boolean isElementFoundInGivenTime(By webElement) {
        boolean exists = false;
        try {
            isElementVisible(webElement);
            exists = true;
        } catch (NoSuchElementException e) {
        }
        return exists;
    }

    //This function to click on element
    public void clickOn(By elementName) {
        waitABit(5000);
        WebElementFacade element = find(elementName);
        waitABit(3000);
        if (element.isDisplayed()) {
            element.click();
            Assert.assertTrue("Clicked on button successfully", true);
        } else {
            Assert.fail("Unable to click on button");
            log.info("Unable to click on button");
        }
    }

    //This function to click on login button
    public void clickOnLoginButton()
    {
        waitABit(5000);
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.textBox("btnLogin"));
        if(elementFacade.isEnabled())
        {
            elementFacade.click();
            Assert.assertTrue("Clicked on button successfully",true);
        }
        else
        {
            Assert.fail("Unable to Login");
            log.info("Unable to click on Login button");
        }
    }

    //This function to verify mandatory fields
    public void mandatoryTextField(String field)
    {
        if(field.contains(" "))
        {
            field = field.replaceAll(" ","");
        }
        WebElementFacade elementFacade= find(XpathForLeaveManagementTab.textArea(field));
        if (elementFacade.getAttribute("class").contains("error-validation"))
        {
            Assert.assertTrue("Field is mandatory", true);
        }
        else
        {
            Assert.fail("Field is not mandatory");
            log.info("Field not verified successfully");
        }
    }

    //This function to verify mandatory dropdown
    public void mandatoryDropdown(String field)
    {
        if(field.contains(" "))
        {
            if(StringUtils.equals(field,"from Date"))
            {
                field="from Dt";
            }
            field = field.replaceAll(" ","");
        }
        WebElementFacade elementFacade= find(XpathForLeaveManagementTab.dropdown(field));
        if (elementFacade.getAttribute("class").contains("error-validation"))
        {
            Assert.assertTrue("Field is mandatory", true);
        }
        else
        {
            Assert.fail("Field is not mandatory");
            log.info("Field not verified successfully");
        }
    }

    //This function to verify mandatory calendar
    public void mandatoryCalendar(String field) {
        waitABit(5000);
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.inputItem(field));
        if (elementFacade.getAttribute("class").contains("error-validation")) {
            Assert.assertTrue("Field is mandatory", true);
        } else {
            Assert.fail("Field is not mandatory");
            log.info("Field not verified successfully");
        }
    }

    public void typeIntoTextBox(String text, String fieldName)
    {
        if(fieldName.contains(" "))
        {
            fieldName=fieldName.replaceAll(" ","");
        }
        WebElementFacade elementFacade = $(XpathForLeaveManagementTab.textArea(fieldName));
        if (elementFacade.isEnabled()) {
            typeInto(elementFacade, text);
            Assert.assertTrue("Text entered successfully", true);
        } else {
            Assert.fail("Unable to enter text");
            log.info("Unable to enter text");
        }

    }

    //This function to verify element
    public void verifyElement(By loc)
    {
        WebElementFacade elementFacade = find(loc);
        if(!elementFacade.isPresent())
        {
            Assert.fail("Unable to find element on UI");
            log.info("Unable to find element on UI");
        }
    }

    public void verifyColumnIsSorted(By column)
    {
        WebElementFacade elementFacade = find(column);
        if (elementFacade.getAttribute("class").contains("_desc") || elementFacade.getAttribute("class").contains("_asc")) {
            Assert.assertTrue("Sorting verified successfully", true);
        } else {
            Assert.fail("Unable to sort columns");
            log.info("Unable to sort columns");
        }
    }

    //This function to sort and verify Reason and Remarks columns
    public void sortAndVerify(String columns)
    {
        if(columns.contains(","))
        {
            String[] column= columns.split(",");
            for (int i=0;i<column.length;i++)
            {
                if(StringUtils.equals(column[i],"Reason"))
                {
                    clickOn(XpathForLeaveManagementTab.columnHeading("10"));
                    verifyColumnIsSorted(XpathForLeaveManagementTab.columnHeading("10"));
                }
                else
                {
                    clickOn(XpathForLeaveManagementTab.columnHeading("11"));
                    verifyColumnIsSorted(XpathForLeaveManagementTab.columnHeading("11"));
                }
            }
        }
    }

    //This function to verify number of records
    public void verifyRecords()
    {
        waitABit(5000);
        List<WebElementFacade> noOfRecords = findAll(XpathforPolicyTab.noOfRows);
        if(noOfRecords.size()>0)
        {
            Assert.assertTrue("Number of Records verified",true);
        }
        else
        {
            Assert.fail("Number of Records not verified");
            log.info("Number of Records not verified");
        }
    }

    //This function to verify data
    public void verifyData()
    {
        if($(XpathForLeaveManagementTab.dataIsPresent).isDisplayed())
        {
            Assert.assertTrue("Data is present",true);
        }
        else {
            Assert.fail("Data is not present");
            log.info("Data is not present");
        }
    }

    //This function to enter date in Search box
    public void enterPeriod(String text, String tabName)
    {
        if(StringUtils.equals(tabName,"Leave"))
        {
            enterText(XpathForLeaveManagementTab.searchBox("1"), text);
        }
        else if(StringUtils.equals(tabName,"Out Duty Details"))
        {
            enterText(XpathForLeaveManagementTab.searchBox("3"), text);
        }
        else {
            enterText(XpathForLeaveManagementTab.searchBox("2"), text);
        }
    }

    //This function to select Date
    public void selectDate(String tab)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        String[] dateArray = tomorrow.toString().split(" ");
        if(StringUtils.equals(dateArray[0],"Sat")){
            calendar.add(Calendar.DAY_OF_YEAR, 2);
        }
        Date dateNow =  calendar.getTime();
        if(StringUtils.equals(tab,"Work From Home"))
            selectDateFromDropdown(dateNow, XpathForLeaveManagementTab.dropdown("WorkFromHomeDate"));
    }

    //Function verifies copy text
    public void verifyText()
    {
        WebElementFacade elementFacade=find(XpathForLeaveManagementTab.copyToClipboard);
        if(!elementFacade.isDisplayed())
        {
            Assert.fail("Unable to verify element");
            log.info("Unable to verify element");
        }

    }

    //This function to verify default tab
    public void verifyDefault(String tab)
    {
        List<WebElementFacade> elementFacadeList = findAll(XpathForLeaveManagementTab.tab);
        if (elementFacadeList.get(0).getAttribute("class").contains("active") &&
                elementFacadeList.get(0).getText().equals(tab)) {
            Assert.assertTrue("Default Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify default tab", false);
        }
    }

    //This function to select leave type
    public void selectType(String dropdownVal)
    {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("outingType"));
        selectFromDropdown(elementFacade,dropdownVal);
    }

    //This function to sort columns for Leave tab
    public void sortCols(String columns)
    {
        waitABit(3000);
        if(columns.contains(","))
        {
            String[] col = columns.split(",");
            for(int i=0;i<col.length;i++) {
                clickOn(XpathForLeaveManagementTab.column(col[i]));
                verifyColumnIsSorted(XpathForLeaveManagementTab.column(col[i]));
            }
        }
    }

    //This function to navigate to next pages
    public void navigateToAllPages(String tabName)
    {
        List<WebElementFacade> list = findAll(XpathForLeaveManagementTab.pages);
        if(list.size()>=4)
        {
            tabName = "tbl"+tabName.replaceAll(" ","");
            clickOn(XpathForLeaveManagementTab.nextBtn(tabName));
        }
    }

    //This function for clicking on Previous page
    public void clickOnPrevPage(String tabName)
    {
        List<WebElementFacade> list = findAll(XpathForLeaveManagementTab.pages);
        if(list.size()>=4)
        {
            tabName = "tbl"+tabName.replaceAll(" ","");;
            clickOn(XpathForLeaveManagementTab.previousBtn(tabName));
        }
    }

    //Function is for clicking sub tabs of Apply and View Request Status
    public void clickOnTab(String tabName)
    {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.sideNav(tabName));
        clickOn(elementFacade);
    }

    //Function verifies the number of leave entries
    public void numEntries(String number, String tab)
    {
        tab="tbl"+tab.replaceAll(" ","")+"_length";
        WebElementFacade elementFacade = find(XpathforPolicyTab.lengthPage(tab));
        selectFromDropdown(elementFacade,number);
    }
}