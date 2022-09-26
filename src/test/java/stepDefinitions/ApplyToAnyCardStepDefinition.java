package stepDefinitions;

import com.gemini.mis.pages.ApplyToAnyCardPages;
import com.gemini.mis.pages.CommonPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ApplyToAnyCardStepDefinition {

    @Steps
    ApplyToAnyCardPages skillsPages;

    @Steps
    CommonPages commonPages;


    @Then("^Verify card is not empty$")
    public void verifyCardIsNotEmpty() {
        skillsPages.verifyCardNotEmpty();
    }

    @And("^User clicks on \"(.*?)\" skill in My Skill card$")
    public void clickOnSkillInMySkillCard(String skill) {
        skillsPages.clickASkill(skill);
    }

    @When("^Manage Skills Modal open$")
    public void manageSkillsModalOpen() {
        skillsPages.verifySkillModal();
    }

    @Then("^User selects Proficiency Level \"(.*?)\"$")
    public void selectProficiencyLevel(String value) {
        skillsPages.selectValue("ddlSkillLevelEdit", value);
    }


    @Then("^User selects Skill Type \"(.*?)\"$")
    public void selectSkillType(String value) {
        skillsPages.selectValue("ddlSkillTypeEdit", value);
    }

    @And("^User enters experience (.*?)$")
    public void enterExperience(String value) {
        skillsPages.enterValue(value);
    }

    @Then("^Click OK on Success pop-up$")
    public void clickOKOnSuccessPopup() {
        skillsPages.clickOK();
    }

    @And("^Verify skill \"(.*?)\" is updated for type \"(.*?)\" and experience \"(.*?)\"$")
    public void verifyDataIsUpdatedForSkill(String skill, String type, String experience) {
        skillsPages.verifyData(skill, type, experience);
    }

    @Then("^Verify \"(.*?)\" input select has error$")
    public void verifySkillTypeInputSelectHasError(String inputType) {
        skillsPages.verifyForError(inputType);

    }

    @Then("^User clicks on \"(.*?)\" button on \"(.*?)\" card$")
    public void userClicksOnButton(String buttonName, String cardName) {
        commonPages.clickButton(buttonName, cardName);
    }

    @And("^Verify that \"(.*?)\" card is minimized$")
    public void verifyThatCardIsMinimized(String cardName) {
        commonPages.verifyCardMinimized(cardName);
    }

    @And("^Verify that \"(.*?)\" card is maximized$")
    public void verifyThatCardIsMaximized(String cardName) {
        commonPages.verifyCardMaximized(cardName);
    }


}
