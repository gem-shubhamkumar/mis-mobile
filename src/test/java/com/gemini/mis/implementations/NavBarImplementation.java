package com.gemini.mis.implementations;

import com.gemini.mis.pages.AccountPortalPage;
import com.gemini.mis.selectors.AccountPortalSelectors;
import com.gemini.mis.selectors.LeaveBalanceSelectors;
import com.gemini.mis.selectors.NavBarSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;
import java.util.List;

public class NavBarImplementation extends PageObject {

    @Steps
    AccountPortalImplementation accountImp;
    @Steps
    AccountPortalPage accountPage;

    public void verifyUserRedirectedToLandingPage() {
        if (accountImp.isElementFound(LeaveBalanceSelectors.cardProfile)) {
            System.out.println("User successfully redirected to landing page");
        } else {
            Assert.fail("Failed to navigate to landing page");
        }
    }

    public void selectValueFromDropdown(String optionName){
        boolean flag = false;
        accountImp.clickOn(NavBarSelectors.dropdownTechnology);
        waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.listTechnologyDropdown));
        List<WebElement> dropdownItems = getDriver().findElements(NavBarSelectors.listTechnologyDropdown);
        for (WebElement ele : dropdownItems) {
            if (StringUtils.equals(optionName,ele.getText())) {
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

     //verify all elements form menu list dropdown
     public void verifyElementsPresent() {
         if (accountImp.isElementFound(NavBarSelectors.menuListProfile)) {
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
                if (accountImp.isElementFound(NavBarSelectors.dropDownProficiency)) {
                    accountImp.clickOn(NavBarSelectors.dropDownProficiency);
                    accountImp.clickOn(NavBarSelectors.optionsDropdown(option));
                } else {
                    Assert.fail("Proficiency dropdown not found");
                }
                break;
            case "Skill type":
                if (accountImp.isElementFound(NavBarSelectors.dropDownSkillType)) {
                    accountImp.clickOn(NavBarSelectors.dropDownSkillType);
                    accountImp.clickOn(NavBarSelectors.optionsDropdown(option));
                } else {
                    Assert.fail("Skill typ dropdown not found");
                }
                break;

            default:
                Assert.fail("dropdown not added in switch case");

        }
    }

    public void enterTextInField(String textToEnter, String fieldName){
        switch (fieldName){
            case "Experience":
                accountImp.verifyTextFieldAndEnterText(NavBarSelectors.textFieldExperience,textToEnter);
                break;

            default:Assert.fail("field not added in switch cases");
        }
    }

    //verify if the skill is added in skill card
    public void verifySkillAdded(String skillName,String status, String expectedCondition){
        getDriver().navigate().refresh();
        waitABit(1500);
        boolean flag =false;
        int count =0;
        List<WebElement> listMySkills = getDriver().findElements(NavBarSelectors.listMySkillCard);
        if(StringUtils.equals(status,"new") && StringUtils.equals(expectedCondition,"can be")){
            for (WebElement  ele : listMySkills){
                if(StringUtils.equals(ele.getText(),skillName)){
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

        }else if(StringUtils.equals(status,"duplicate") && StringUtils.equals(expectedCondition,"cannot be")){
            for (WebElement  ele : listMySkills){
                if(StringUtils.equals(ele.getText(),skillName)){
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

     //verify duplicate skills
     public void verifyNoTwoSkillsArePresentWithSameName(String duplicateName){
        getDriver().navigate().refresh();
        int count=0;
        waitABit(2000);
        List<WebElement> listItems =getDriver().findElements(NavBarSelectors.listMySkillCard);
        for(WebElement ele : listItems){
            if(StringUtils.equals(ele.getText(),duplicateName))
                count++;
        }
        if(count==1){
            System.out.println("No duplicate record found");
        }else if(count>1){
            Assert.fail("duplicate records are found");
        }
    }

    //verify text field turns red when invalid input is passed
    public void verifyInvalidValuesAreNotAllowed(String value){

        if(!isElementVisible(AccountPortalSelectors.textMessageBox)){
            String className = $(NavBarSelectors.textFieldExperience).getAttribute("class");
            if(StringUtils.contains(className,"error-validation")){
                System.out.println("Text field does not accept text as "+value);
            }else{
                Assert.fail();
            }

        }else {
            Assert.fail("record is saved and message box appeared, "+value+" is expected");
        }

    }
   //verify user is redirected to login page when click on log out
    public void verifyRedirectedToLoginPage(){
        waitABit(1000);
        if(
                accountImp.isElementFound(AccountPortalSelectors.textFieldMyMISUsername)&&
                accountImp.isElementFound(AccountPortalSelectors.textFieldMyMISPassword)&&
                accountImp.isElementFound(AccountPortalSelectors.logoGemini)){
            System.out.println("Logout successfully");
        }else{
            Assert.fail("Unable to verify login page element");
        }

    }

    //uncheck all boxes form dashboard setting
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

    //click on a link
    public void clickOnLink(String linkName){
        accountImp.clickOn(AccountPortalSelectors.linkNumberOfLeave(linkName));
    }

    //Select option from menu list on navbar
    public void SelectFromMenuOptions(String optionName){
        accountImp.clickOn(NavBarSelectors.listMenu(optionName));
    }

    public void openProfileMenuList(){
        waitFor(ExpectedConditions.presenceOfElementLocated(NavBarSelectors.btnProfileMenu));
        accountImp.clickOn(NavBarSelectors.btnProfileMenu);
    }






}
