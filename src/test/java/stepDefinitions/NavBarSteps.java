package stepDefinitions;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.pages.AccountPortalPages;
import com.gemini.mis.pages.NavBarPages;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class NavBarSteps extends PageObject {
    @Steps
    commonMethods commonFunction;

    @Steps
    AccountPortalPages accountPortalPage;

    @Steps
    NavBarPages navPages;

    @Then("^Verify user is redirected to landing page$")
    public void VerifyNavigationToLandingPage(){
        navPages.verifyUserRedirectedToLandingPage();
    }

    @Then("^Verify \"(.*?)\" disappears form current screen$")
    public void verifySideNavigationBarDisappears(String eleName){
        commonFunction.verifyElementIsNotVisible(eleName);
    }
     @Then("^Verify navigation to landing page is successful after log in$")
    public void verifyNavigationToLandingPage(){
         accountPortalPage.verifyElementOnCurrentPage("Profile card");
         waitABit(1500);
     }

    @And("^Verify all menu items are present in the dropdown$")
    public void verifyAllMenuItemsArePresentInTheDropdown() {
       navPages.verifyElementsPresent();
    }

    @Then("^Select \"(.*?)\" from technology dropdown on add skills window$")
    public void selectFromTechnologyDropdownOnAddSkillsWindow(String itemToBeSelected) {
        navPages.selectValueFromDropdown(itemToBeSelected);
    }

    @Then("^Select \"(.*?)\" from \"(.*?)\" dropdown on add skills window$")
    public void selectFromProficiencyDropdownOnAddSkillsWindow(String option, String dropdownName) {
        navPages.selectDropdownOption(option,dropdownName);
    }
    @And("^Enter \"(.*?)\" in \"(.*?)\" text field$")
    public void verifyTextFieldAndEnterText(String textToType,String fieldName){
        navPages.enterTextInField(textToType,fieldName);
    }

}
