package stepDefinitions;

import com.gemini.mis.pages.GenericFunc;
import net.serenitybdd.core.pages.PageObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Generic extends PageObject {

    //declarations
    private final GenericFunc gf = new GenericFunc();
    /*----------------------------------------------------------------------------------------------------------*/

    @Given("Navigate to MIS Beta Application")
    public void launchMISBeta() {
        gf.launchMISBeta();
    }

    @And("^Login to MIS with credentials \"(.*?)\" \"(.*?)\"$")
    public void loginToMIS(String Username, String Password) {
        gf.loginToMIS(Username, Password);
    }

    @Then("Logout from MIS")
    public void logoutFromMIS() {
        gf.optUserMenuAction("Logout");
    }

    @Then("^Open a settings page \"(.*?)\"$")
    public void openASettingsPage(String Page) {
        gf.optUserMenuAction(Page);
    }

    @When("^Open \"(.*?)\" page")
    public void openAModule(String PageOption) {
        gf.navigateToPage(PageOption);
    }

    @When("^Open \"(.*?)\" page of \"(.*?)\" module$")
    public void openAModulePage(String PageOption, String ModuleOption) {
        gf.navigateToPage(PageOption, ModuleOption);
    }

    @And("^Verify \"(.*?)\" page of type \"(.*?)\"$")
    public void verifyPage(String Page, String PageType) {
        gf.verifyPage(Page, PageType);
    }

    @And("Verify and accept success popup")
    public void verifyAndAcceptSuccess() {
        gf.verifyAndAcceptSuccessPopup();
    }

    @Then("Verify and accept warning popup")
    public void verifyAndAcceptWarning() {
        gf.verifyAndAcceptWarningPopup();
    }

    @Then("Verify and accept confirmation popup")
    public void verifyAndAcceptConfirmation() {
        gf.verifyAndAcceptConfirmation();
    }

    @Then("Verify and reject confirmation popup")
    public void verifyAndRejectConfirmation() {
        gf.verifyAndRejectConfirmation();
    }

}
