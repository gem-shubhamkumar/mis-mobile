package com.gemini.mis.pages;

import com.gemini.mis.selectors.CommonXpaths;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import com.gemini.mis.selectors.AccountPortalSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class NavBarPages extends PageObject {

AccountPortalPages accountPage;

    public void verifyUserRedirectedToLandingPage() {
        if (accountPage.isElementFound(LeaveBalanceSelectors.cardProfile)) {
            System.out.println("User successfully redirected to landing page");
        } else {
            Assert.fail("Failed to navigate to landing page");
        }
    }

    @Step("Click on technology dropdown and select dropdown was as {0}")
    public void selectValueFromDropdown(String optionName) {
        boolean flag = false;
        accountPage.clickOn(NavBarSelectors.dropdownTechnology);
        waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.listTechnologyDropdown));
        List<WebElement> dropdownItems = getDriver().findElements(NavBarSelectors.listTechnologyDropdown);
        for (WebElement ele : dropdownItems) {
            if (optionName.equals(ele.getText())) {
                accountPage.clickOn(ele);
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
        if (accountPage.isElementFound(NavBarSelectors.menuListProfile)) {
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
            accountPage.compareListData(itemsOnPage, menuItemsList);
        } else {
            Assert.fail("Dropdown in not present/visible");
        }
    }

    public void selectDropdownOption(String option, String dropdownName) {
        switch (dropdownName) {
            case "Proficiency":
                if (accountPage.isElementFound(NavBarSelectors.dropDownProficiency)) {
                    accountPage.clickOn(NavBarSelectors.dropDownProficiency);
                    accountPage.clickOn(NavBarSelectors.optionsDropdown(option));
                } else {
                    Assert.fail("Proficiency dropdown not found");
                }
                break;
            case "Skill type":
                if (accountPage.isElementFound(NavBarSelectors.dropDownSkillType)) {
                    accountPage.clickOn(NavBarSelectors.dropDownSkillType);
                    accountPage.clickOn(NavBarSelectors.optionsDropdown(option));
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
                accountPage.verifyTextFieldAndEnterText(NavBarSelectors.textFieldExperience,textToEnter);
                break;

            default:Assert.fail("field not added in switch cases");
        }
    }

    @Step("Verify {0} is added in my skill card")
    public void verifySkillAdded(String skillName,String status, String expectedCondition){
        getDriver().navigate().refresh();
        waitABit(2000);
        boolean flag =false;
        int count =0;
        List<WebElement> listMySkills = getDriver().findElements(NavBarSelectors.listMySkillCard);
        if(status.equals("new") && expectedCondition.equals("can be")){
        for (WebElement  ele : listMySkills){
            if(ele.getText().equals(skillName)){
                flag=true;
                break;
            }else{
                flag=false;
            }
        }
     if(flag){
            System.out.println("Newly added skill is successfully added in my skill card ");
        }else{
            Assert.fail("Skill not added");
        }

         }else if(status.equals("duplicate")&&expectedCondition.equals("cannot be")){
            for (WebElement  ele : listMySkills){
                if(ele.getText().equals(skillName)){
                    count++;
                }
            }
            if(count==1){
                System.out.println("No duplicate record found");
            }else if(count>1){
                Assert.fail("Two record with same name are found");
            }
        }

    }

    public void verifyNoTwoSkillsArePresentWithSameName(String duplicateName){
        getDriver().navigate().refresh();
        int count=0;
        waitABit(2000);
        List<WebElement> listItems =getDriver().findElements(NavBarSelectors.listMySkillCard);
        for(WebElement ele : listItems){
            if(ele.getText().equals(duplicateName))
                count++;
        }
        if(count==1){
            System.out.println("No duplicate record found");
        }else if(count>1){
            Assert.fail("duplicate records are found");
        }
    }
     public void verifyInvalidValuesAreNotAllowed(String value){

        if(!isElementVisible(CommonXpaths.textMessageBox)){
            String className = $(NavBarSelectors.textFieldExperience).getAttribute("class");
            if(className.contains("error-validation")){
                System.out.println("Text field does not accept text as "+value);
            }else{
                Assert.fail();
            }

        }else {
            Assert.fail("record is saved and message box appeared, "+value+" is expected");
        }

    }

    @Step("Verify login page element")
    public void verifyRedirectedToLoginPage(){
        waitABit(2000);
        if(
        accountPage.isElementFound(AccountPortalSelectors.textFieldMyMISUsername)&&
        accountPage.isElementFound(AccountPortalSelectors.textFieldMyMISPassword)&&
        accountPage.isElementFound(AccountPortalSelectors.logoGemini)){
            System.out.println("Logout successfully");
        }else{
            Assert.fail("Unable to verify login page element");
        }

    }

    public void uncheckAndVerifyAllCheckBox(){
    List<WebElement> listCheckBox =getDriver().findElements(NavBarSelectors.checkboxTable);
    boolean flag=false;
    for (WebElement ele : listCheckBox){
        if(ele.isSelected()){
            clickOn(ele);
            flag=true;
        }
    }
        Assert.assertTrue("All are unchecked",flag);
    }

    public void verifyNoCardIsShownOnTheDashboard() {
        waitABit(5000);
        if(!$(NavBarSelectors.headingsDashboardCards).isVisible()){
            System.out.println("All cards are hidden");
        }else{
            Assert.fail("Cards are still visible on dashboard");
        }
    }









}
