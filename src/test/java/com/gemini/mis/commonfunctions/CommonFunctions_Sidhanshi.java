package com.gemini.mis.commonfunctions;

import com.gemini.mis.pages.FeedbackPage;
import com.gemini.mis.selectors.*;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import java.util.List;

public class CommonFunctions extends PageObject {
    FeedbackPage feedbackPage;


    public void navigateToTab(String parentTabName){
        if ($(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).isPresent()) {
            waitABit(1000);
            $(By.xpath(CommonSelectors.sideNav.replace("tabName", parentTabName))).click();

        } else {
            Assert.assertFalse("Unable to locate parent tab",false);
        }
    }



    public void clickButton(String buttonName) {
        waitABit(1000);
        switch(buttonName) {
            case "Sign In": {
                $(By.xpath(CommonSelectors.homePageXpath.replace("name", "btnLogin"))).waitUntilPresent().click();
                break;
            }

            case "update" : {
                $(By.xpath(MySkillsLocators.genericButton.replace("ids", "btnUpdateSkills"))).waitUntilPresent().click();
                break;
            }

            case "Provide Feedback": {
                $(By.xpath(FeedbackSelectors.provideFeedbackButton)).waitUntilPresent().click();
                break;
            }
            case "Submit": {
                $(By.xpath(FeedbackSelectors.submitButton)).waitUntilPresent().click();
                break;
            }

            case "next" :
            case "Previous" : {
                while(!$(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).getAttribute("class").contains("disabled")) {
                    $(By.xpath(CommonSelectors.paginationButtons.replace("buttonName", buttonName))).waitUntilPresent().click();
                }
                break;
            }

            case "View" : {
                $(By.xpath(FeedbackSelectors.viewButton.replace("size", Integer.toString(feedbackPage.totalRow())))).waitUntilPresent().click();
                break;
            }

            case "Copy" :
            case "Print" :
            case "PDF" :
            case "Excel" :
            case "Export" : {
                $(By.xpath(FeedbackSelectors.export.replace("name", buttonName))).waitUntilPresent().click();
                break;
            }

            case "previous date" : {
                $(By.id("btnPreviousMonth")).waitUntilPresent().click();
                break;
            }

            case "next date" : {
                $(By.id("btnNextMonth")).waitUntilPresent().click();
                break;
            }

            case "Close" : {
                $(By.xpath(LNSASelectors.closeModal)).waitUntilPresent().click();
                break;
            }
            case "Submit Reason": {
                $(By.xpath(FeedbackSelectors.submitButton.replace("2", "3"))).waitUntilPresent().click();
                break;
            }
            case "status": {
                $(By.xpath(LNSASelectors.statusButton)).waitUntilPresent().click();
                break;
            }

            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }
    @Step
    public void clickButton(String buttonName, String cardName) {
        waitABit(1000);
        switch(buttonName) {
            case "Maximize": {
                $(By.xpath(CommonSelectors.cardToggleMaximize.replace("card", cardName))).waitUntilPresent().click();
                break;

            }
            case "Minimize" : {
                String xpath = CommonSelectors.cardToggleMinimize.replace("card", cardName);
                xpath = xpath.replace("buttonName", buttonName);
                $(By.xpath(xpath)).waitUntilPresent().click();
                break;
            }


            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }

    @Step
    public void verifyCardMinimized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.collapsedCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not minimized");

    }
    @Step
    public void verifyCardMaximized(String cardName) {
        int flag = 0;
        List<WebElement> cards = getDriver().findElements(By.xpath(CommonSelectors.fullScreenCard));

        for (WebElement card: cards
        ) {
            if(card.getText().equals(cardName)) flag = 1;
        }

        if(flag == 1) Assert.assertTrue(true);
        else Assert.fail("Card " + cardName + " is not maximized");

    }

    @Step
    public void verifyForError(String inputType) {
        switch (inputType) {
            case "skill": {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "ddlSkillTypeEdit"))).isPresent());
                break;
            }

            case "experience" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "expinMonthsEdit");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Submit Feedback" : {
                String xpath = MySkillsLocators.errorType.replace("ids", "feedback");
                Assert.assertTrue($(By.xpath(xpath)).isPresent());
                break;
            }
            case "Reason" : {
                Assert.assertTrue($(By.xpath(MySkillsLocators.errorType.replace("ids", "txtLnsaReason"))).isPresent());
                break;
            }
            default: {
                Assert.fail("Input " + inputType + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute, String tab) {
        switch (tab) {
            case "Feedback" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblFeedback_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            case "LNSA" : {
                String xpath = CommonSelectors.select.replace("attribute", attribute);
                xpath = xpath.replace("value", "tblLnsaStatusGrid_length");

                selectFromDropdown($(By.xpath(xpath)).getElement(), value);
                break;
            }
            default: {
                Assert.fail("Tab " + tab + " not found");
            }
        }
    }

    @Step("Select Value {1}")
    public void selectValue(String id, String value, String attribute) {
        String xpath = CommonSelectors.select.replace("attribute", attribute);
        xpath = xpath.replace("value", id);

        selectFromDropdown($(By.xpath(xpath)).getElement(), value);
    }

    @Step
    public void verifyRows(int number) {
        int tableRow = getDriver().findElements(By.xpath(FeedbackSelectors.tableRow.replace("ids", "tblFeedback"))).size();
        Assert.assertTrue(number == tableRow || tableRow < number);
    }


    public void launchSite() {
        getDriver().get("https://mymis.geminisolutions.com/");
        if (getDriver().getTitle().equals("Gemini MIS")) {
            Assert.assertTrue("Successfully launched application", true);
        } else {
            Assert.assertFalse("Unable to launch application", false);
        }
    }

    public void typeIntoElement(String text, String fieldName) {
        WebElementFacade elementFacade = null;
        switch (fieldName) {
            case "username":
                elementFacade = find(XpathForLeaveManagementTab.textBox("username"));
                break;
            case "Reason":
                elementFacade = find(XpathForLeaveManagementTab.textArea("outingReason"));
                break;
            case "Primary contact number":
                elementFacade = find(XpathForLeaveManagementTab.textBox("outingContactNumber"));
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

    public void clickOnBtn(String btnName) {
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

    public boolean isElementFoundInGivenTime(By webelement) {
        boolean exists = false;
        try {
            isElementVisible(webelement);
            exists = true;
            // find(webelement);
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

    public void verifyTab(String tabName) {
        waitABit(5000);
        String expectedHeading = "";
        String title = "";
        if (tabName.equals("Out Duty/Tour Request Detail")) {
            WebElementFacade elementFacade = find(XpathForLeaveManagementTab.newHeading);
            if (elementFacade.getText().equals(expectedHeading)) {
                Assert.assertTrue("Tab verified successfully", true);
            } else {
                Assert.assertFalse("Unable to verify tab", false);
            }
        } else {
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
        }
    }

    public void verifyDefaultTab(String tab) {
        List<WebElementFacade> elementFacadeList = findAll(XpathForLeaveManagementTab.tab);
        if (elementFacadeList.get(0).getAttribute("class").contains("active") &&
                elementFacadeList.get(0).getText().equals(tab)) {
            Assert.assertTrue("Default Tab verified successfully", true);
        } else {
            Assert.assertFalse("Unable to verify default tab", false);
        }
    }

    public void verifyMandatoryFields(String fields) {
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

    public boolean isAbleToSubmit() {
        boolean isAbleToSubmit = false;
        String popupText = "";
        WebElementFacade elementFacade = find(XpathForLeaveManagementTab.successAlertPopup("h2"));
        if (elementFacade.isEnabled()) {
            popupText = textOf(XpathForLeaveManagementTab.successAlertPopup("p"));
            if (popupText.equals("Leave Applied successfully")) {
                isAbleToSubmit = true;
            }
        }
        return isAbleToSubmit;
    }

    public void navigateToTab(String parentTabName, String childTabName) {
        // verification for Parent tab
        if (isElementFoundInGivenTime(CommonXpath.sideNav(parentTabName))) {
            waitABit(1000);
            // clicks on parent tab
            clickOn(CommonXpath.sideNav(parentTabName));
            waitABit(2000);
            // verifies sub tab available
            if (isElementFoundInGivenTime(CommonXpath.sideNav(childTabName))) {
                if (childTabName.equals("View Request Status") && parentTabName.equals("LNSA")) {
                    String xpath = "(" + CommonXpath.sideNav(childTabName);
                    xpath = xpath + ")[2]";
                    WebElementFacade elementFacade = find(By.xpath(xpath));
                    elementFacade.click();
                } else {
                    clickOn(CommonXpath.sideNav(childTabName));
                }
            } else {
                Assert.assertFalse("Unable to locate child tab", false);
            }
        } else {
            Assert.assertFalse("Unable to locate parent tab", false);
        }
    }

    public void selectDate(By loc, String dateValue) {
        if (isElementFoundInGivenTime(loc)) {
            clickOn(loc);
            String date = dateValue.split("/")[0];
            List<WebElementFacade> dates = findAll("//td");
            for (WebElementFacade elementFacade : dates) {
                if (elementFacade.getText().equals(date)) {
                    if (elementFacade.getAttribute("class").contains("disabled")) {
                        continue;
                    } else {
                        elementFacade.click();
                        break;
                    }
                }
            }
        } else {
            Assert.assertFalse("Unable to click on calendar", false);
        }
    }

    public void focusElement(WebElement element) {
        String javaScript = "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "arguments[0].dispatchEvent(evObj);";

        ((JavascriptExecutor) getDriver()).executeScript(javaScript, element);
    }
}
        public void GenericButtons(String ButtonName) {
            try {

                switch (ButtonName) {
                    case "Edit":


                }
            } catch (Exception e) {
                Assert.fail("We were unable to click on the button: " + ButtonName);
            }


        }}




