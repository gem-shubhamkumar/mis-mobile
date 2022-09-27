package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.pages.MySkillsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MySkillsSteps {

    @Steps
    MySkillsPage skillsPages;

    @Steps
    CommonPage commonPages;

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
        commonPages.verifyModal(modalTitle);
    }

    @Then("^User selects Proficiency Level \"(.*?)\"$")
    public void selectProficiencyLevel(String value) {
        commonPages.selectValue("ddlSkillLevelEdit", value, "id");
    }


    @Then("^User selects Skill Type \"(.*?)\"$")
    public void selectSkillType(String value) {
        commonPages.selectValue("ddlSkillTypeEdit", value, "id");
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
        commonFunctions.verifyForError(inputType);

    }

    @Then("^User clicks on \"(.*?)\" button on \"(.*?)\" card$")
    public void userClicksOnButton(String buttonName, String cardName) {
        commonFunctions.clickButton(buttonName, cardName);
    }

    @And("^Verify that \"(.*?)\" card is minimized$")
    public void verifyThatCardIsMinimized(String cardName) {
        commonFunctions.verifyCardMinimized(cardName);
    }

    @And("^Verify that \"(.*?)\" card is maximized$")
    public void verifyThatCardIsMaximized(String cardName) {
        commonFunctions.verifyCardMaximized(cardName);
    }


}
