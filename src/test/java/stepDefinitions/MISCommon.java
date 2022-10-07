package stepDefinitions;

import com.gemini.mis.pages.MISCommonFunc;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//stepDefinitions specific and common to MIS
public class MISCommon extends PageObject {

    //declarations
    private final MISCommonFunc mcf = new MISCommonFunc();
    /*----------------------------------------------------------------------------------------------------------*/

    @Given("Navigate to MIS Beta Application")
    public void launchMISBeta() {
        mcf.launchMISBeta();
    }

    @And("^Login to MIS with credentials \"(.*?)\" \"(.*?)\"$")
    public void loginToMIS(String Username, String Password) {
        mcf.loginToMIS(Username, Password);
    }

    @Then("Logout from MIS")
    public void logoutFromMIS() {
        mcf.optUserMenuAction("Logout");
    }

    @Then("^Open a settings page \"(.*?)\"$")
    public void openASettingsPage(String Page) {
        mcf.optUserMenuAction(Page);
    }

    @When("^Open \"(.*?)\" page")
    public void openAModule(String PageOption) {
        mcf.navigateToPage(PageOption);
    }

    @When("^Open \"(.*?)\" page of \"(.*?)\" module$")
    public void openAModulePage(String PageOption, String ModuleOption) {
        mcf.navigateToPage(PageOption, ModuleOption);
    }

    @And("^Verify \"(.*?)\" page of type \"(.*?)\"$")
    public void verifyPage(String Page, String PageType) {
        mcf.verifyPage(Page, PageType);
    }

    @And("Verify and accept success popup")
    public void verifyAndAcceptSuccess() {
        mcf.verifyAndAcceptSuccessPopup();
    }

    @Then("Verify and accept warning popup")
    public void verifyAndAcceptWarning() {
        mcf.verifyAndAcceptWarningPopup();
    }

    @Then("Verify and accept confirmation popup")
    public void verifyAndAcceptConfirmation() {
        mcf.verifyAndAcceptConfirmation();
    }

    @Then("Verify and reject confirmation popup")
    public void verifyAndRejectConfirmation() {
        mcf.verifyAndRejectConfirmation();
    }

}
