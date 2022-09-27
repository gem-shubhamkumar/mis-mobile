package stepDefinitions;

import com.gemini.mis.pages.KnowledgeBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class KnowledgeBaseStepDefinition {

    @Steps
    KnowledgeBasePage steps;

   @When("^Goto \"(.*?)\" and click on \"(.*?)\"$")
   public void clickOnMenuItem(String menuItem,String subItem){
       steps.gotoMenuItemAndSubItem( menuItem, subItem);
   }
    @Then("^verify no records added in the grid$")
    public void isEmptyGrid(){
        steps.isEmptyGrid();
    }
    @And("^click on \"(.*?)\" without entry$")
    public void clickOnElementWithEmptyEntry(String query){
        steps.clickOnButton(query);
    }

    @And("click on ok button on warning popup")
    public void clickOnOkOnWarningPopup(){
        steps.clickOnOk();
    }
    @Then("^click on \"(.*?)\"$")
    public void clickOnItem(String elemName){
        steps.clickOnElement(elemName);
    }

    @Then("^click on \"(.*?)\" button$")
    public void clickOnButton(String itemName){
       steps.clickOnButton(itemName);
    }

    @Then("click on refresh icon")
    public void clickReloadIcon(){
        steps.clickOnReloadButton();
    }


    @And("verify this is the last page")
    public void verifyThisIsLastPage(){
       steps.isLastPage();
    }

    //incomplete step definitions
    @And("^enter \"(.*?)\" tag name and click on \"(.*?)\"$")
    public void clickOnAddButtonAfterInput(String inputTagName, String buttonName){

    }

    @And("click ok on the popup in add new tag")
    public void clickOnPopupInAddNewTag(){

    }

    @And("^enter \"(.*?)\"$")

}
