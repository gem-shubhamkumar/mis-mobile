package com.gemini.mis.pages;

import com.gemini.mis.implementations.NavBarImplementation;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class NavBarPage extends PageObject {

    @Steps
    NavBarImplementation navBarImp;

   // verify user is directed to landing page of my MIS beta
   public void verifyUserRedirectedToLandingPage(){
       navBarImp.verifyUserRedirectedToLandingPage();
   }

    @Step("Click on technology dropdown and select dropdown was as {0}")
    public void selectValueFromDropdown(String optionName){
       navBarImp.selectValueFromDropdown(optionName);
    }

    @Step("Verify elements menu list dropdown")
    public void verifyElementsPresent(){
       navBarImp.verifyElementsPresent();
    }

   //select a value from dropdown
   public void selectDropdownOption(String option, String dropdownName){
       navBarImp.selectDropdownOption(option,dropdownName);
   }

    @Step("Enter {0} in {1} text field")
    public void enterTextInField(String textToEnter, String fieldName){
       navBarImp.enterTextInField( textToEnter,  fieldName);
    }

    @Step("Verify {0} is added in my skill card")
    public void verifySkillAdded(String skillName,String status, String expectedCondition){
       navBarImp.verifySkillAdded( skillName, status, expectedCondition);
    }

    //verify no duplicate skill is added
    public void verifyNoTwoSkillsArePresentWithSameName(String duplicateName){
       navBarImp.verifyNoTwoSkillsArePresentWithSameName(duplicateName);
    }

    //Verify error is indicated when invalid input is passed in text field
    public void verifyInvalidValuesAreNotAllowed(String value){
       navBarImp.verifyInvalidValuesAreNotAllowed(value);
    }

    @Step("Verify login page element")
    public void verifyRedirectedToLoginPage(){
       navBarImp.verifyRedirectedToLoginPage();
    }

    public void uncheckAndVerifyAllCheckBox(){
       navBarImp.uncheckAndVerifyAllCheckBox();
    }

    public void verifyNoCardIsShownOnTheDashboard(){
       navBarImp.verifyNoCardIsShownOnTheDashboard();
    }

    public void clickOnLink(String linkName){
       navBarImp.clickOnLink(linkName);
    }
    //select option from top right menu list on navbarr
    public void SelectFromMenuOptions(String optionName){
       navBarImp.SelectFromMenuOptions(optionName);
    }
    //open profile menu list on navBar
    public void openProfileMenuList(){
       navBarImp.openProfileMenuList();

    }
  public void checkAllCards(){
        navBarImp.checkAllCards();
    }
    //verify all cards are visible on dashboard
    public void verifyAllCardsAreShownOnDashboard(){
        navBarImp.verifyAllCardsAreShownOnDashboard();
    }








}
