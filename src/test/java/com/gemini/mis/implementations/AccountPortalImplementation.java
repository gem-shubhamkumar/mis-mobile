package com.gemini.mis.implementations;

import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class AccountPortalImplementation extends PageObject {


    //Login to mis beta with username as :priyanshu.prajapati and password as Gemini#123
    public void userLoginToMIS() {
        navigateToMIS();
        verifyCredentialsEnterInField("myMIS portal", "priyanshu.prajapati", "Gemini@123");
        clickOn(AccountPortalSelectors.btnSignIn);
        if (!isElementFound((AccountPortalSelectors.btnChangeADPassword))) {
            Assert.fail("Unable to verify successful login");
        }
        waitABit(5000);
    }

    public void verifyGreytHrlandingPageEle() {
        waitABit(3000);
        String[] array = {"Payslip", "IT Declaration", "POI", "Track"};
        List<WebElement> listItems =
                getDriver().findElements(AccountPortalSelectors.listLandingPageElements);
        List<String> compareItemText = new ArrayList<>();
        for (String names : array) {
            compareItemText.add(names);
        }
        List<String> list = new ArrayList<>();

        for (WebElement ele : listItems) {
            list.add(ele.getText());
        }
        System.out.println(list);
        System.out.println(compareItemText);
        if (list.equals(compareItemText)) {
            System.out.println("All element are present");
        } else {
            Assert.fail("All elements are not present");
        }
    }

    public void verifyEleAreAvailableOnViewMyInfo() {
        String[] array = {"Personal", "Accounts & Statutory", "Family", "Employment & Job", "Assets"};
        List<WebElement> listItems =
                getDriver().findElements(AccountPortalSelectors.listViewMyInfo);
        List<String> compareItemText = new ArrayList<>();
        for (String names : array) {
            compareItemText.add(names);
        }
        List<String> list = new ArrayList<>();

        for (WebElement ele : listItems) {
            list.add(ele.getText());
        }
        System.out.println(list);
        System.out.println(compareItemText);
        if (list.equals(compareItemText)) {
            System.out.println("All element are present");
        } else {
            Assert.fail("All elements are not present");
        }
    }

    //click
    public void clickOnElement(String eleName) {
        waitABit(1000);
        switch (eleName) {
            case "Profile button":
                clickOn(AccountPortalSelectors.account_portal);
                break;
            case "View My Info link":
                clickOn(AccountPortalSelectors.linkViewMyInfo);
                break;
            case "Accounts & Statutory":
                clickOn(AccountPortalSelectors.linkAccountAndStatutory);
                break;
            case "Settings link":
                clickOn(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
                clickOn(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "Close button":
                clickOn(LeaveBalanceSelectors.btnLeaveHistoryClose);
                break;
            case "Update button":
                clickOn(NavBarSelectors.btnUpdate);
                break;
            case "Gemini logo":
                clickOn(NavBarSelectors.logoGemini);
                break;
            case "Menu button":
                clickOn(AccountPortalSelectors.btnMenu);
                break;
            case "Change AD password button":
                clickOn(NavBarSelectors.btnChangeADpassword);
                break;
            case "Save button":
                clickOn(NavBarSelectors.btnAddSkillSave);
                break;
            case "Add skill close button":
                clickOn(AccountPortalSelectors.btnClose);
                break;


            default:
                Assert.fail("button not found, not added in switch cases");
        }
        waitABit(1000);
    }

    public void verifyNewWindowTabIsOpen(String newTabPageHeading) {
        waitABit(2000);
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs.get(1));
        System.out.println("*******************" + browserTabs.size());
        if (browserTabs.size() == 2) {
            Assert.assertTrue(StringUtils.contains(getDriver().getTitle(), newTabPageHeading));
        } else {
            Assert.fail("Only one tab is open");
        }
    }

    //
    public void verifyElementOnCurrentPage(String eleName) {
        switch (eleName) {
            case "Gemini logo":
                isElementFound(AccountPortalSelectors.logoGemini);
                break;
            case "greytHR logo":
                isElementFound(AccountPortalSelectors.logoGreytHR);
                break;
            case "greytHR username text field":
                isElementFound(AccountPortalSelectors.textFieldGreytHRUsername);
                break;
            case "gerytHR password text field":
                isElementFound(AccountPortalSelectors.textFieldGreytHRPassword);
                break;
            case "Settings link":
                isElementFound(AccountPortalSelectors.linkSettings);
                break;
            case "View login history link":
                isElementFound(AccountPortalSelectors.linkViewLoginHistory);
                break;
            case "Profile card":
                isElementFound(LeaveBalanceSelectors.cardProfile);
                break;
            case "Leave balance card":
                isElementFound(LeaveBalanceSelectors.cardLeaveBalance);
                break;
            case "Leave history window":
                isElementFound(LeaveBalanceSelectors.gridLeaveHistory);
                break;
            case "Employee directory table":
                isElementFound(NavBarSelectors.tableEmployeeDirectory);
                break;
            case "Side navigation bar":
                isElementFound(AccountPortalSelectors.sideMenuBar);
                break;


            default:
                Assert.fail("failed to locate element with " + eleName);
        }
    }

    //
    public void verifyTextPresent(String text) {
        switch (text) {
            case "Hello there!":
                isTextFound(AccountPortalSelectors.textHelloThere, text);
                break;
            case "Priyanshu":
                text = "Hi " + text;
                isTextFound(AccountPortalSelectors.textUsername, text);
                break;
            case "Yes Bank":
                isTextFound(AccountPortalSelectors.textBankNAme, text);
                break;
            case "Username and password is required.":
                isTextFound(AccountPortalSelectors.textIncorrectCredentials, text);
                break;


            default:
                Assert.fail("Failed to find text : " + text);


        }
    }

    //
    public void verifyHeaderElementsArePresent() {
        for (int i = 1; i < 4; i++) {
            if (isElementFound(AccountPortalSelectors.elementsLoginDetails(i))) {
                System.out.println($(AccountPortalSelectors.elementsLoginDetails(i))
                        .getText() + " element is found successfully");
            } else {
                Assert.fail
                        ("Unable to locate element " + $(AccountPortalSelectors.elementsLoginDetails(i)).getText());
            }
        }

    }

    //
    public void verifyCredentialsEnterInField(String portalName, String username, String password) {
        switch (portalName) {
            case "myMIS portal":
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldMyMISUsername));
                sendTextToField(AccountPortalSelectors.textFieldMyMISUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldMyMISPassword));
                sendTextToField(AccountPortalSelectors.textFieldMyMISPassword, password);
                break;

            case "greytHR portal":
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldGreytHRUsername));
                sendTextToField(AccountPortalSelectors.textFieldGreytHRUsername, username);
                waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.textFieldGreytHRPassword));
                sendTextToField(AccountPortalSelectors.textFieldGreytHRPassword, password);
                waitABit(2000);
                $(AccountPortalSelectors.btnLogIn).click();
                break;

            default:
                Assert.fail("unable to verify portal name");

        }
        waitABit(2000);


    }

    public void verifyLandingToMyMIS() {
        if (StringUtils.equals(getDriver().getTitle(), "greytHR")) {
            getDriver().close();
            if (getDriver().getTitle().equals("myMIS")) {
                System.out.println("successfully navigated to myMIS portal page/tab");
            } else {
                Assert.fail("failed to navigate MIS portal ");
            }
        } else {
            Assert.fail("failed to navigate greytHR portal");
        }


    }

    //check if the text is found
    public void isTextFound(By loc, String text) {
        String textToCompare = $(loc).getText();
        if (StringUtils.contains(text, "Hello")) {
            System.out.println("Text is verified");
        } else
            Assert.assertEquals(text, textToCompare);
    }

    //
    public void compareListData(List<String> list1, List<String> list2) {
        if (list1.size() == list2.size()) {
            if (list1.equals(list2)) {
                System.out.println("Both lists have same data");
            } else {
                Assert.fail("Data in lists are not same");
            }
        } else
            Assert.fail("Size of the lists are different");
    }


    //Navigate to parent tab > child tab
    public void navigateToTab(String childTabName, String parentTabName) {
        waitFor(ExpectedConditions.presenceOfElementLocated((AccountPortalSelectors.menuTabs(parentTabName))));
        if ($(AccountPortalSelectors.menuTabs(parentTabName)).isVisible()) {
            $(AccountPortalSelectors.menuTabs(parentTabName)).click();
            if ($(AccountPortalSelectors.menuTabs(childTabName)).isVisible()) {
                $((AccountPortalSelectors.menuTabs(childTabName))).click();
            } else {
                Assert.fail("Unable to locate child tab");
            }

        } else {
            Assert.fail("Unable to locate parent tab");
        }
    }

    //Navigate to parent tab
    public void navigateToTab(String parentTabName) {
        waitOnPage();
        //   waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.menuTabs(parentTabName)));
        if ($(AccountPortalSelectors.menuTabs(parentTabName)).isVisible()) {
            $((AccountPortalSelectors.menuTabs(parentTabName))).click();
        } else {
            Assert.fail("Unable to locate parent tab");
        }
    }

    public void verifyElementIsNotVisible(String elementName) {
        boolean flag = false;
        switch (elementName) {
            case "Side navigation bar":
                flag = $(AccountPortalSelectors.sideMenuBar).isVisible();
                break;
            case "Add skills window":
                flag = $(NavBarSelectors.windowAddSkills).isVisible();
                break;

            default:
                Assert.fail("Element name wrong");
        }
        if (flag) {
            Assert.fail(elementName + " is visible on the screen");
        } else {
            System.out.println("PASS : Element is not visible on the screen");
        }
    }

    //Navigate to myMIS on browser
    public void navigateToMIS() {
        getDriver().get("https://mymis.geminisolutions.com/");
        waitABit(2000);
        if (StringUtils.equals(getDriver().getCurrentUrl(), "https://mymis.geminisolutions.com/")) {
            System.out.println("URL is launched");
        } else {
            Assert.fail("Unable to launch URL");
        }
    }

    // verify popup message box appeared
    public void verifyMessageBoxAfterAddingRecord(String message) {
        String messageOnBox = "";
        boolean flag = false;
        if (isElementFound(AccountPortalSelectors.textMessageBox)) {
            messageOnBox = $(AccountPortalSelectors.textMessageBox).getText();
        }
        switch (message) {
            case "Success":
                if (StringUtils.contains(messageOnBox, "successfully")) {
                    flag = true;
                    System.out.println("Success message box appear");
                } else {
                    Assert.fail();
                }
                break;
            case "Duplicate":
                if (StringUtils.contains(messageOnBox, "Duplicate")) {
                    flag = true;
                    System.out.println("Warning/Duplicate message box appear");
                } else {
                    Assert.fail();
                }
                break;
        }
        if (flag) {
            waitFor(ExpectedConditions.presenceOfElementLocated(AccountPortalSelectors.btnOk));
            clickOn(AccountPortalSelectors.btnOk);
        } else {
            Assert.fail("Warning / Success box does not appear");
        }

    }

    /////////////////////////////////////////////////////////////common///////////////////////////////////////////////////

    //Check if the element is visible and then click on it
    public void clickOn(By elementLoc) {
        if ($(elementLoc).isVisible()) {
            waitABit(1500);
            $(elementLoc).click();
        } else {
            Assert.fail("Unable to click: by xpath > " + elementLoc);
        }
    }

    //verify page title
    public void verifyPageTitle(String title) {
        String currentTitle = getDriver().getTitle();
        if (StringUtils.contains(currentTitle, title)) {
            System.out.println("Title verify successfully");
        } else {
            Assert.fail("Title are not same, Expected : " + title + " ,Actual :" + currentTitle);
        }
    }

    //check if the element is found or not
    public boolean isElementFound(By loc) {
        boolean isFound;
        try {
            $(loc);
            isFound = true;
        } catch (Exception e) {
            isFound = false;
        }
        return isFound;
    }

    //Send a text to a text field
    public void sendTextToField(By loc, String text) {
        if (isElementFound(loc)) {
            waitFor(ExpectedConditions.presenceOfElementLocated(loc));
            $(loc).type(text);
        } else {
            Assert.fail("Text field not found");
        }
    }

    //Verify text field and enter text
    public void verifyTextFieldAndEnterText(By loc, String text) {
        if (isElementFound(loc)) {
            $(loc).type(text);
        } else {
            Assert.fail("Unable to locate text field");
        }
    }

    public void hitLogin() {
        clickOn(AccountPortalSelectors.btnLogIn);
    }


}
