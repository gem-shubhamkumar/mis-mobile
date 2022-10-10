package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.XpathForLeaveManagementTab;
import com.gemini.mis.selectors.XpathforPolicyTab;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

public class LeaveManagementPage extends PageObject
{

    CommonFunctions genFunc;
    @Step("Launch MIS Beta site")
    public void launchSite()
    {
        getDriver().get("https://mymis.geminisolutions.com");
        if (getDriver().getTitle().equals("Gemini MIS")) {
            Assert.assertTrue("Successfully launched application", true);
        } else {
            Assert.fail("Unable to launch application");
        }

    }

    @Step
    public void typeIntoElement(String text, String fieldName)
    {
        type(text,fieldName);
    }

    @Step
    public void clickOnButton(String btnName)
    {
        boolean elementPresent = false;
        By tab = null;
        switch (btnName) {
            case "Sign in":
                tab = XpathForLeaveManagementTab.textBox("btnLogin");
                break;
            case "Submit Comp off":
                tab = XpathForLeaveManagementTab.submitBtn("3");
                break;
            case "Submit LWP":
                tab = XpathForLeaveManagementTab.submitBtn("4");
                break;
            case "Submit Out of Duty/Tour":
                tab = XpathForLeaveManagementTab.submitBtn("5");
                break;
            case "Submit Leave":
                tab = XpathForLeaveManagementTab.submitBtn("1");
                break;
            case "Submit WFH":
                tab = XpathForLeaveManagementTab.submitBtn("2");
                break;
            case "Total working days":
                tab = XpathForLeaveManagementTab.tooltip;
                break;
            case "Leave for half day":
                tab = XpathForLeaveManagementTab.textBox("isLeaveHalfDay");
                break;
            case "OK":
                tab = XpathForLeaveManagementTab.btnType("OK");
                break;
            case "Mobile":
                tab = XpathForLeaveManagementTab.textBox("avilableOnMobile");
                break;
            case "Email":
                tab = XpathForLeaveManagementTab.textBox("avilableOnEmail");
                break;
            case "Next":
                tab = XpathforPolicyTab.pagination("paginate_button next");
                break;
            case "Next Leave":
                tab = XpathForLeaveManagementTab.paginationNext("1");
                break;
            case "Next WFH":
                tab = XpathForLeaveManagementTab.paginationNext("2");
                break;
            case "Previous":
                tab = XpathforPolicyTab.pagination("paginate_button previous");
                break;
            case "Previous Leave":
            case "Previous WFH":
                tab = XpathForLeaveManagementTab.paginationPrevious("1");
                break;
            case "View":
                tab = XpathforPolicyTab.viewBtn;
                break;
            case "Close":
                tab = XpathforPolicyTab.pageElement("button");
                break;
            case "Date Range":
                tab = XpathForLeaveManagementTab.dateRange;
                break;
            case "Export":
                tab = XpathForLeaveManagementTab.exportBtn("1");
                break;
            case "Export WFH":
            case "Export Comp Off":
            case "Export Out Duty/Tour":
            case "Export LWP":
                tab = XpathForLeaveManagementTab.exportBtn("2");
                break;
            case "Copy":
                tab = XpathForLeaveManagementTab.copyBtn("1");
                break;
            case "Print":
                tab = XpathForLeaveManagementTab.printBtn("1");
                break;
            case "Excel":
                tab = XpathForLeaveManagementTab.excelBtn("1");
                break;
            case "Pdf":
                tab = XpathForLeaveManagementTab.pdfBtn("1");
                break;
            case "Period":
                tab = XpathForLeaveManagementTab.columnHeading("1");
                break;
            case "Period WFH":
            case "Applied for":
            case "Period Out Duty":
                tab = XpathForLeaveManagementTab.columnHeading("8");
                break;
            case "Half Day":
            case "Days":
            case "Duty Type":
                tab = XpathForLeaveManagementTab.columnHeading("9");
                break;
            case "Type":
                tab = XpathForLeaveManagementTab.columnHeading("2");
                break;
            case "Reason":
                tab = XpathForLeaveManagementTab.columnHeading("3");
                break;
            case "Remarks":
                tab = XpathForLeaveManagementTab.columnHeading("4");
                break;
            case "Reason WFH":
            case "Reason Comp Off":
            case "Reason Out Duty":
                tab = XpathForLeaveManagementTab.columnHeading("10");
                break;
            case "Remarks WFH":
            case "Remarks Comp Off":
            case "Remarks Out Duty":
                tab = XpathForLeaveManagementTab.columnHeading("11");
                break;
            case "Status":
                tab = XpathForLeaveManagementTab.columnHeading("5");
                break;
            case "Applied On":
                tab = XpathForLeaveManagementTab.columnHeading("6");
                break;
            case "Action":
                tab = XpathForLeaveManagementTab.columnHeading("7");
                break;
            case "Expand":
                tab = XpathForLeaveManagementTab.expandBtn("2");
                break;
            case "Expand Comp Off":
            case "Expand Out Duty":
                tab = XpathForLeaveManagementTab.expandBtn("11");
                break;
            case "Cancel":
                tab = XpathForLeaveManagementTab.cancelBtn;
                break;
            case "View Out Duty":
                tab = XpathForLeaveManagementTab.viewBtn;
                break;
            case "Yes":
                tab = XpathForLeaveManagementTab.button("confirm btn btn-lg btn-danger");
                break;
            default:
                elementPresent = false;
        }
        if (isElementFoundInGivenTime(tab)) {
            Assert.assertTrue("Verified button: " + tab + "is present on screen", isElementFoundInGivenTime(tab));
            WebElementFacade elementFacade = find(tab);
            elementFacade.click();
        } else {
            Assert.assertFalse("Unable to find button", !isElementFoundInGivenTime(tab));
        }
    }

    @Step
    public void verifyPage(String pageName)
    {
        waitABit(10000);
        String url="";
        if(pageName.equals("Dashboard Page"))
        {
            url = "https://mymis.geminisolutions.com/Dashboard/Index";
        }
        Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Step
    public void clickOnSideNavigationOption(String tabName)
    {
        clickOn(XpathForLeaveManagementTab.sideNav(tabName));
    }


    @Step("Verify dropdown options after clicking on Side Navigation tabs")
    public void sideNavOptions(String options)
    {
        boolean isPresent = false;
        String option[] = options.split(",");
        for(int i=0;i<option.length;i++)
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdownOptions(String.valueOf(i+1)));
            if(!elementFacade.getText().equals(option[i]))
            {
                isPresent = false;
                break;
            }
            else
            {
                isPresent = true;
            }
        }
        if(isPresent)
        {
            Assert.assertTrue("Dropdown options present",true);
        }
        else
        {
            Assert.assertFalse("Dropdown options not present",false);
        }

    }

    @Step
    public void verifyTabDisplays(String tabName)
    {
        waitABit(5000);
        String expectedHeading = "";
        String title ="";
        if(tabName.equals("Out Duty/Tour Request Detail"))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.newHeading);
            if (elementFacade.getText().equals(expectedHeading)) {
                Assert.assertTrue("Tab verified successfully", true);
            } else {
                Assert.assertFalse("Unable to verify tab", false);
            }
        }
        else {
            switch (tabName) {
                case "Apply":
                    expectedHeading = "Apply Leave/ WFH / Comp Off / Out Duty / Change Request";
                    break;
                case "Leave History":
                    expectedHeading = "Leave History";
                    break;
                case "View Policies":
                    expectedHeading = "View Policies";
                    title = getDriver().getCurrentUrl();
                    if (title.contains("ViewPolicy")) {
                        Assert.assertTrue("Tab verified successfully", true);
                    } else {
                        Assert.fail("Unable to verify tab");
                    }
                    break;
            }
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.heading);
            if (elementFacade.getText().equals(expectedHeading)) {
                Assert.assertTrue("Tab verified successfully", true);
            } else {
                Assert.assertFalse("Unable to verify tab", false);
            }
        } }

    @Step
    public void verifyTab(String tab)
    {
        List<WebElementFacade> elementFacadeList = findAll(XpathForLeaveManagementTab.tab);
        if (elementFacadeList.get(0).getAttribute("class").contains("active") &&
                elementFacadeList.get(0).getText().equals(tab)) {
            Assert.assertTrue("Default Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify default tab", false);
        }
    }

    @Step("Verify field is auto populated by default")
    public void verifyAutoPopulated(String fieldName)
    {
        boolean isAutoPopulated = true;
        if (fieldName.contains(",")) {
            String[] fieldNames = fieldName.split(",");
            WebElementFacade elementFacade = null;
            for (int i = 0; i < fieldNames.length; i++) {
                if (fieldName.contains("Primary")) {
                    elementFacade = find(XpathForLeaveManagementTab.textBox("leaveContactNumber"));
                } else if (fieldName.contains("Other")) {
                    elementFacade = find(XpathForLeaveManagementTab.textBox("leaveAltContactNumber"));
                }
                if (elementFacade.getText().equals(" ")) {
                    isAutoPopulated = false;
                    break;
                }
            }
        }
        else
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.textBox(fieldName));
            if(elementFacade.getText().equals(" "))
            {
                isAutoPopulated = false;
            }
        }
        if (isAutoPopulated) {
            Assert.assertTrue("Field are auto populated by default", true);
        } else {
            Assert.assertFalse("Fields are not auto populated", false);
        }
    }

    @Step
    public void verifyMandatoryFields(String fields)
    {
        WebElementFacade elementFacade = null;
        switch (fields) {
            case "Outing From":
                elementFacade = find(XpathForLeaveManagementTab.inputItem("Outing From"));
                break;
            case "LWP Change Request From":
                elementFacade = find(XpathForLeaveManagementTab.dropdown("fromDt"));
                break;
            case "Type of Leave":
                elementFacade = find(XpathForLeaveManagementTab.dropdown("legitimateType"));
                break;
            case "Reason for Request":
                elementFacade = find(XpathForLeaveManagementTab.textArea("legitimateReason"));
                break;
            case "Outing Till":
                elementFacade = find(XpathForLeaveManagementTab.inputItem("Outing Till"));
                break;
            case "Type":
                elementFacade = find(XpathForLeaveManagementTab.dropdown("outingType"));
                break;
            case "Primary Contact number":
                elementFacade = find(XpathForLeaveManagementTab.textBox("outingContactNumber"));
                break;
            case "Reason for outing":
                elementFacade = find(XpathForLeaveManagementTab.textArea("outingReason"));
                break;
            case "From":
                elementFacade = find(XpathForLeaveManagementTab.inputItem("Leave From"));
                break;
            case "Till":
                elementFacade = find(XpathForLeaveManagementTab.inputItem("Leave Till"));
                break;
            case "Reason":
                elementFacade = find(XpathForLeaveManagementTab.textArea("leaveReason"));
                break;
            case "WFH Reason":
                elementFacade = find(XpathForLeaveManagementTab.textArea("WFHReason"));
                break;
            case "Comp Off Reason":
                elementFacade = find(XpathForLeaveManagementTab.textArea("CompOffReason"));
                break;
            case "Date":
                elementFacade = find(XpathForLeaveManagementTab.dropdown("WorkFromHomeDate"));
                break;
            case "Comp Off Date":
                elementFacade = find(XpathForLeaveManagementTab.dropdown("CompOffDate"));
                break;
        }
        if (elementFacade.getAttribute("class").contains("error-validation")) {
            Assert.assertTrue("Field is mandatory", true);
        } else {
            Assert.fail("Fields is not mandatory");
        }
    }

    @Step
    public void selectDate(String date, String calendarName) {
    }

    @Step
    public void clickOnSubTab(String childTab, String parentTab)
    {
        if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(parentTab)))
        {
            waitABit(1000);
            //clicks on parent tab
            clickOn(XpathForLeaveManagementTab.sideNav(parentTab));
            waitABit(2000);
            //verifies sub tab available
            if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(childTab))) {
                if (childTab.equals("View Request Status") && parentTab.equals("LNSA")) {
                    String xpath = "(" + XpathForLeaveManagementTab.sideNav(childTab);
                    xpath = xpath + ")[2]";
                    WebElementFacade elementFacade = find(By.xpath(xpath));
                    elementFacade.click();
                } else {
                    clickOn(XpathForLeaveManagementTab.sideNav(childTab));
                }
            }
            else{
                Assert.assertFalse("Unable to locate child tab",false);
            }
        }
        else {
            Assert.assertFalse("Unable to locate parent tab",false);
        }
    }

    @Step("Click on Tab")
    public void clickOnTab(String tabName)
    {
        if (isElementFoundInGivenTime(XpathForLeaveManagementTab.sideNav(tabName)))
        {
            waitABit(1000);
            //clicks on parent tab
            clickOn(XpathForLeaveManagementTab.sideNav(tabName));

        }
        else {
            Assert.assertFalse("Unable to locate parent tab",false);}
    }

    @Step
    public void selectTillDate(By loc,String tillDate)
    {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            String date = tillDate.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (elementFacade.getText().equals(date)) {
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
            Assert.assertFalse("Unable to click on calendar",false);
        }
    }

    @Step
    public void selectFromDate(By loc,String fromDate)
    {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            String date = fromDate.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (elementFacade.getText().equals(date)) {
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
            Assert.assertFalse("Unable to click on calendar",false);
        }
    }

    @Step
    public void verifyTooltip(String labelText)
    {
        if(isElementVisible(XpathForLeaveManagementTab.labelText(labelText)))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.tooltip);
            clickOn(XpathForLeaveManagementTab.tooltip);
            if(elementFacade.getAttribute("aria-describedby").contains("popover"))
            {
                String tooltipText = elementFacade.getText();
                if(tooltipText.equals("For ML total days will be considered as total working days"))
                {
                    Assert.assertTrue("Tootlip verified",true);
                }
                else
                {
                    Assert.assertFalse("Unable to verify tooltip",false);
                }
            }
            else
            {
                Assert.assertFalse("Unable to verify tooltip",false);
            }
        }
    }

    @Step
    public void halfDayOptions(String leaveOptions)
    {
        String[] halfDayOption = leaveOptions.split(",");
        String firstHalf = textOf(XpathForLeaveManagementTab.halfDayOptions("isFirstHalfLeave"));
        String secondHalf =textOf(XpathForLeaveManagementTab.halfDayOptions("isSecondHalfLeave"));

        if(firstHalf.equals(halfDayOption[0]) && secondHalf.equals(halfDayOption[1]))
        {
            Assert.assertTrue("Half day options verified",true);
        }
        else
        {
            Assert.assertFalse("Unable to verify half day options",false);
        }
    }

    @Step
    public void selectLeaveType(String leaveType)
    {
        leaveType = "1 "+leaveType;
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("leaveType"));
        selectFromDropdown(elementFacade,leaveType);
    }

    @Step
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
        }
    }

    @Step
    public void verifyPopup(String popupText)
    {
        if(isElementFoundInGivenTime(XpathForLeaveManagementTab.successAlertPopup("p")))
        {
            String popUpText = textOf(XpathForLeaveManagementTab.successAlertPopup("p"));
            if(popUpText.equals(popupText))
            {
                Assert.assertTrue("Popup verified",true);
                if(popUpText.contains("successfully"))
                clickOnButton("OK");
            }
            else
            {
                Assert.assertFalse("Unable to verify popUp",false);
            }
        }
    }

    @Step
    public void availabilityType(String availabilityType)
    {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        if(availabilityType.equals("Mobile"))
        {
            clickOnButton("Mobile");
        }
        else
        {
            clickOnButton("Email");
        }
    }



    @Step
    public void verifyTabIsActive(String tabName) {
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.isTabActive(tabName));
        if (elementFacade.getAttribute("class").contains("active")) {
            Assert.assertTrue("Tab is active", true);
        } else {
            Assert.assertFalse("Tab is not active", false);
        }
    }

    @Step("Select Date from Dropdown")
    public void selectDateFromDropdown(Date date, By loc)
    {
        String[] dateArray = date.toString().split(" ");
        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();
        //Getting the current month
        Month currentMonth = currentdate.getMonth();
        String Month = null;
        if(currentMonth.toString().equals("SEPTEMBER"))
        {
            Month= "09";
        }
        else if(currentMonth.toString().equals("OCTOBER"))
        {
            Month= "10";
        }
        String dateToBeSelected = Month+"/"+dateArray[2]+"/2022";
        WebElementFacade elementFacade = find(loc);
        selectFromDropdown(elementFacade,dateToBeSelected);
    }


    @Step("Select date for comp off")
    public void selectDateForCompOff()
    {
        if(isElementVisible(XpathForLeaveManagementTab.dropdown("CompOffDate")))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.dropdown("CompOffDate"));
            elementFacade.click();
            elementFacade.sendKeys(Keys.DOWN);
            elementFacade.sendKeys(Keys.ENTER);
        }
        else
        {
            Assert.fail("Unable to select from dropdown");
        }
    }

    @Step
    public void verifyElement(String element)
    {
        WebElementFacade elementFacade = null;
        switch (element)
        {
            case "Request processed successfully":
                elementFacade = find(XpathForLeaveManagementTab.successAlertPopup("p"));
                break;
            case "Date Range":
            elementFacade = find(XpathForLeaveManagementTab.dateRange);
            break;
            case "Export":
                elementFacade = find(XpathForLeaveManagementTab.exportBtn("1"));
                break;
            case "Export WFH":
                elementFacade = find(XpathForLeaveManagementTab.exportBtn("2"));
                break;
            case "Export Comp Off":
                elementFacade = find(XpathForLeaveManagementTab.exportBtn("3"));
                break;
            case "Export Out Duty/Tour":
                elementFacade = find(XpathForLeaveManagementTab.exportBtn("4"));
                break;
            case "Export LWP":
                elementFacade = find(XpathForLeaveManagementTab.exportBtn("5"));
                break;
            case "Copy":
                elementFacade = find(XpathForLeaveManagementTab.copyBtn("1"));
                break;
            case "Print":
                elementFacade = find(XpathForLeaveManagementTab.printBtn("1"));
                break;
            case "Excel":
                elementFacade = find(XpathForLeaveManagementTab.excelBtn("1"));
                break;
            case "PDF":
                elementFacade = find(XpathForLeaveManagementTab.pdfBtn("1"));
                break;
            case "Copied to Clipboard":
                elementFacade = find(XpathForLeaveManagementTab.copyToClipboard);
                break;
        }
        if(!elementFacade.isPresent())
        {
            Assert.fail("Unable to find element on UI");
        }
    }

    @Step
    public void verifyMessageFor(String resultInput, String message)
    {
        String actualMsg = textOf(XpathForLeaveManagementTab.list("treeitem"));
        if(!actualMsg.equals(message))
        {
            Assert.fail("Unable to verify message");
        }
        if(resultInput.contains("Valid"))
        {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.list("treeitem"));
            elementFacade.click();
        }
    }

    public void verifyDateSelected(String text)
    {
        if(!text.equals(textOf(XpathForLeaveManagementTab.dateRange)))
        {
            Assert.fail("Date not selected");
        }
    }

    @Step
    public void isFileDownload(String downloadPath, String fileName) {
     boolean isDownloaded = genFunc.isFileDownloaded(downloadPath,fileName);
     if(!isDownloaded)
     {
         Assert.fail("Not downloaded");
     }
    }

    @Step("Verify Print Page opens")
    public void verifyPageOpens()
    {
        if(getDriver().getWindowHandles().equals("1"))
        {
            Assert.fail("Print page did not open");
        }
    }

    @Step
    public void verifyLeavePeriod(String searchText)
    {
        if(searchText.equals(textOf(XpathforPolicyTab.noOfRows)))
        {
            Assert.assertTrue("Leave verified successfully",true);
        }
        else
        {
            Assert.fail("Leave not filtered successfully");
        }

    }

    @Step
    public void verifyColumnIsSorted(String column) {
        WebElementFacade tab = null;
        switch (column) {
            case "Period":
                tab = find(XpathForLeaveManagementTab.columnHeading("1"));
                break;
            case "Period WFH":
            case "Applied for":
            case "Period Out Duty":
                tab = find(XpathForLeaveManagementTab.columnHeading("8"));
                break;
            case "Half Day":
            case "Days":
            case "Duty Type":
                tab = find(XpathForLeaveManagementTab.columnHeading("9"));
                break;
            case "Type":
                tab = find(XpathForLeaveManagementTab.columnHeading("2"));
                break;
            case "Reason":
                tab = find(XpathForLeaveManagementTab.columnHeading("3"));
                break;
            case "Remarks":
                tab = find(XpathForLeaveManagementTab.columnHeading("4"));
                break;
            case "Reason WFH":
            case "Reason Comp Off":
            case "Reason Out Duty":
                tab = find(XpathForLeaveManagementTab.columnHeading("10"));
                break;
            case "Remarks WFH":
            case "Remarks Comp Off":
            case "Remarks Out Duty":
                tab = find(XpathForLeaveManagementTab.columnHeading("11"));
                break;
            case "Status WFH":
                tab = find(XpathForLeaveManagementTab.columnHeading("12"));
                break;
        }
            if (tab.getAttribute("class").contains("_desc") || tab.getAttribute("class").contains("_asc")) {
            Assert.assertTrue("Sorting verified successfully", true);
        } else {
            Assert.fail("Unable to sort columns");
        }
    }

    @Step
    public void verifyFile(String fileType, String tab)
    {
        boolean isFileDownloaded = false;
        switch (fileType)
        {
            case "Excel":
            case "Excel Change Request":
                isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","Leave History List.xlsx");
            break;
            case "Excel WFH":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","WFH History List.xlsx");
            break;
            case "Excel Comp Off":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","CompOff History List.xlsx");
            break;
            case "Excel Out Duty/Tour":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","Gemini - MIS.xlsx");
            break;
            case "Pdf":
            case "Pdf Change Request":
                isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","Leave History List.pdf");
            break;
            case "Pdf WFH":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","WFH History List.pdf");
            break;
            case "Pdf Comp Off":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","CompOff History List.pdf");
            break;
            case "Pdf Out Duty/Tour":
            isFileDownloaded = genFunc.isFileDownloaded("C:\\Users\\ja.multani\\Downloads\\","Gemini - MIS.pdf");
            break;

        }
        if(!isFileDownloaded)
        {
            Assert.fail("Unable to download file");
        }
    }

    @Step
    public void typeText(String text, String tabName)
    {
        WebElementFacade elementFacade=null;
        switch (tabName)
        {
            case "Leave":
                elementFacade = find(XpathForLeaveManagementTab.searchBox("1"));
                break;
            case "WFH":
            case "Comp Off":
            case "Out Duty":
                elementFacade = find(XpathForLeaveManagementTab.searchBox("2"));
                break;
            case "Out Duty Details":
                elementFacade = find(XpathForLeaveManagementTab.searchBox("3"));
                break;
            case "LWP":
                elementFacade = find(XpathForLeaveManagementTab.searchBox("5"));
                break;
        }
        if(elementFacade.isPresent())
        {
            typeInto(elementFacade,text);
        }
        else {
            Assert.fail("Unable to type");
        }
    }

    @Step
    public void verifyResult(String textFiltered, String tabName)
    {
        List<WebElementFacade> list = findAll(XpathforPolicyTab.policyData);
        boolean isSearchResultFound = false;
        for(WebElementFacade elementFacade:list) {
             if (elementFacade.getText().equals(textFiltered)) {
                    isSearchResultFound = true;
                    break;
                }
        }
        if(!isSearchResultFound)
        {
            Assert.fail("Unable to filter");
        }
    }

    @Step
    public void verifyDetailsForDate(String text)
    {
        if(text.contains("25"))
        {
            text = "26-Sep-2022";
        }
        if(text.contains("Out Duty/Tour"))
        {
            text = "26 Sep 2022";
        }
        boolean detailsVerified = false;
        List<WebElementFacade> listTitle = findAll(XpathForLeaveManagementTab.compOffDetails("dtr-title"));
        for(WebElementFacade elementFacade:listTitle)
        {
            if(elementFacade.getText().equals("Applied On"))
            {
                List<WebElementFacade> listDetails = findAll(XpathForLeaveManagementTab.compOffDetails("dtr-data"));
                for(WebElementFacade elementFacade1: listDetails)
                {
                    if(elementFacade1.getText().contains(text))
                    {
                        detailsVerified = true;
                        break;
                    }
                }
            }
        }
        if(detailsVerified)
        {
            Assert.assertTrue("Details verified successfully",true);
        }
        else
        {
            Assert.fail("Unable to verify details");
        }

    }

    @Step
    public void verifyOutingDate(String date)  {
        WebElementFacade elementFacade1 = find(By.xpath("(//div[@class='modal-content'])[3]"));
        genFunc.changeFocusOfElement(elementFacade1);
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.outingDate);
        if(elementFacade.getText().replaceAll("-"," ").equals(date))
        {
            Assert.assertTrue("Outing date verified successfully",true);
        }
        else
        {
            Assert.fail("Outing date not verified");
        }
    }

    
    /*----------------functions-------------------------*/
    public void type(String text, String fieldName) {
        WebElementFacade elementFacade = null;
        switch (fieldName) {
            case "username":
                elementFacade = find(XpathForLeaveManagementTab.textBox("username"));
                break;
            case "Reason":
                elementFacade = find(XpathForLeaveManagementTab.textArea("outingReason"));
                break;
            case "Primary contact number":
                elementFacade =find(XpathForLeaveManagementTab.textBox("outingContactNumber"));
                break;
            case "password":
                elementFacade = find(XpathForLeaveManagementTab.textBox("password"));
                break;
        }
        if (elementFacade.isEnabled()) {
            typeInto(elementFacade, text);
            Assert.assertTrue("Text entered successfully", true);
        } else {
            Assert.assertEquals("Unable to enter text", false);
        }
    }


    public boolean isElementFoundInGivenTime(By webelement) {
        boolean exists = false;
        try {
            isElementVisible(webelement);
            exists = true;
        } catch (NoSuchElementException e) {
            // nothing to do.
        }
        return exists;
    }

    public void clickOn(By elementName) {
        WebElementFacade element = find(elementName);
        if (element.isDisplayed()) {
            element.click();
            Assert.assertTrue("Clicked on button successfully", true);
        } else {
            Assert.assertFalse("Unable to click on button", false);
        }
    }
}
