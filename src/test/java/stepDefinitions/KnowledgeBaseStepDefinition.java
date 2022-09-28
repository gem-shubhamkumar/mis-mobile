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

    @And("^Put \"(.*?)\" and click on \"(.*?)\"$")
    public void putInvalidFolderName(String folderName, String buttonName){

    }

    @Then("verify folder added")
    public void verifyFolderCreated(){

    }
    @And("create folder without name and click \"(.*?)\"")
    public void createFolderWithoutName(String buttonName){

    }

    @And("click on ok button from success window")
    public void clickOkFolderAdded(){

    }

    @Then("verify no folder added")
    public void verifyNoFolderCreated(){

    }
    @And("verify warning message is displayed")
    public void warningMessageDisplayed(){

    }

    @Then("verify duplicate folder created")
    public void isDuplicateFolder(){

    }


    @Then("^right click on \"(.*?)\"$")
    public void rightClick(String elemName){

    }

    @And("verify menu opens")
    public void isMenuOpen(){

    }

    @Then("verify that a popup window is displayed")
    public void isPopUpDisplay(){
    steps.isPopUpOpens();
    }


    @Then("Verify document is scrollable and not empty")
   public void isDocScrollable(){
    steps.isDocScrollable();
    }

    @Then("click on the sorting icon")
 public void clickOnSortingIcon(){

    }
    @And("Verify that \"(.*?)\" button is hidden")
    public void isButtonHidden(String buttonName){

    }
    @And("verify that \"(.*?)\" button is visible")
 public void isButtonVisible(String buttonName){

    }




}
