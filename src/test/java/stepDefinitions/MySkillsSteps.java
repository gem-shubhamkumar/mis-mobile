package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.pages.FeedbackPage;
import com.gemini.mis.pages.MySkillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MySkillsSteps {

    @Steps
    MySkillsPage skillsPages;

    @Steps
    FeedbackPage feedbackPage;

    @Steps
    CommonFunctions commonFunctions;


    @Then("^Verify card is not empty$")
    public void verifyCardIsNotEmpty() {
        skillsPages.verifyCardNotEmpty();
    }

    @And("^User clicks on \"(.*?)\" skill in My Skill card$")
    public void clickOnSkillInMySkillCard(String skill) {
        skillsPages.clickASkill(skill);
    }

    @When("^\"(.*?)\" Modal open$")
    public void modalOpen(String modalTitle) {
        skillsPages.verifyModal(modalTitle);
    }

    @Then("^User selects Proficiency Level \"(.*?)\"$")
    public void selectProficiencyLevel(String value) {
        feedbackPage.selectValue("ddlSkillLevelEdit", value, "id");
    }


    @Then("^User selects Skill Type \"(.*?)\"$")
    public void selectSkillType(String value) {
        feedbackPage.selectValue("ddlSkillTypeEdit", value, "id");
    }

    @And("^User enters experience (.*?)$")
    public void enterExperience(String value) {
        skillsPages.enterValue(value);
    }

    @Then("^Verify \"(.*?)\" Message$")
    public void verifySuccessMessage(String message) {
        skillsPages.verifySuccessMessage(message);
    }

    @And("^Verify skill \"(.*?)\" is updated for type \"(.*?)\" and experience \"(.*?)\"$")
    public void verifyDataIsUpdatedForSkill(String skill, String type, String experience) {
        skillsPages.verifyData(skill, type, experience);
    }

    @Then("^Verify \"(.*?)\" input select has error$")
    public void verifySkillTypeInputSelectHasError(String inputType) {
        feedbackPage.verifyForError(inputType);

    }

    @Then("^User clicks on \"(.*?)\" button on \"(.*?)\" card$")
    public void userClicksOnButton(String buttonName, String cardName) {
        feedbackPage.clickButton(buttonName, cardName);
    }

    @And("^Verify that \"(.*?)\" card is minimized$")
    public void verifyThatCardIsMinimized(String cardName) {
        feedbackPage.verifyCardMinimized(cardName);
    }

    @And("^Verify that \"(.*?)\" card is maximized$")
    public void verifyThatCardIsMaximized(String cardName) {
        feedbackPage.verifyCardMaximized(cardName);
    }



}
