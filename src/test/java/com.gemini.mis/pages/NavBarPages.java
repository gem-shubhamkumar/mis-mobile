package com.gemini.mis.pages;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class NavBarPages extends PageObject {
    @Steps
    commonMethods commonFunction;

    public void verifyUserRedirectedToLandingPage() {
        if (commonFunction.isElementFound(LeaveBalanceSelectors.cardProfile)) {
            System.out.println("User successfully redirected to landing page");
        } else {
            Assert.fail("Failed to navigate to landing page");
        }
    }

    @Step("Click on technology dropdown and select dropdown was as {0}")
    public void selectValueFromDropdown(String optionName) {
        boolean flag = false;
        commonFunction.clickOn(NavBarSelectors.dropdownTechnology);
        waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.listTechnologyDropdown));
        List<WebElement> dropdownItems = getDriver().findElements(NavBarSelectors.listTechnologyDropdown);
        for (WebElement ele : dropdownItems) {
            if (optionName.equals(ele.getText())) {
                commonFunction.clickOn(ele);
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("element selected successfully");
        else
            Assert.fail("unable to find element in dropdown");
    }

    @Step("Verify elements in dropdown")
    public void verifyElementsPresent() {
        if (commonFunction.isElementFound(NavBarSelectors.menuListProfile)) {
            String[] menuItems = {"Profile", "Dashboard Settings", "Skills", "Logout"};
            List<String> menuItemsList = new ArrayList<>();
            for (String s : menuItems) {
                menuItemsList.add(s);
            }
            List<String> itemsOnPage = new ArrayList<>();
            List<WebElement> menuListItems = getDriver().findElements(NavBarSelectors.textMenuListItems);
            for (WebElement ele : menuListItems) {
                itemsOnPage.add(ele.getText());
            }
            commonFunction.compareListData(itemsOnPage, menuItemsList);
        } else {
            Assert.fail("Dropdown in not present/visible");
        }
    }

    public void selectDropdownOption(String option, String dropdownName) {
        switch (dropdownName) {
            case "Proficiency":
                if (commonFunction.isElementFound(NavBarSelectors.dropDownProficiency)) {
                    commonFunction.clickOn(NavBarSelectors.dropDownProficiency);
                    commonFunction.clickOn(NavBarSelectors.optionsDropdown(option));
                } else {
                    Assert.fail("Proficiency dropdown not found");
                }
                break;
            case "Skill type":
                if (commonFunction.isElementFound(NavBarSelectors.dropDownSkillType)) {
                    commonFunction.clickOn(NavBarSelectors.dropDownSkillType);
                    commonFunction.clickOn(NavBarSelectors.optionsDropdown(option));
                } else {
                    Assert.fail("Skill typ dropdown not found");
                }
                break;

            default:
                Assert.fail("dropdown not added in switch case");

        }
    }

    @Step("Enter {0} in {1} text field")
    public void enterTextInField(String textToEnter, String fieldName){
        switch (fieldName){
            case "Experience":
                commonFunction.verifyTextFieldAndEnterText(NavBarSelectors.textFieldExperience,textToEnter);
                break;


        }
    }









}
