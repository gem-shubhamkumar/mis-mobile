package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.LNSAPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.text.ParseException;

public class LNSASteps {

    @Steps
    CommonFunctions commonFunctions;

    @Steps
    LNSAPage lnsaPage;

    @When("^User clicks on \"(.*?)\" tab$")
    public void userClicksOnTab(String tabName) {
        commonFunctions.navigateToTab(tabName);
    }

    @Then("^Verify Apply LNSA tab opens$")
    public void verifyApplyLNSATabOpens() {
        lnsaPage.verifyApplyLNSATabOpen();
    }

    @Then("^Verify previous date data is populated$")
    public void verifyPreviousDateDataIsPopulated() throws ParseException {
        lnsaPage.verifyPreviousDateData();
    }

    @Then("^Verify next date data is populated$")
    public void verifyNextDateDataIsPopulated() throws ParseException {
        lnsaPage.verifyNextDateData();
    }

    @And("^Click on week checkbox$")
    public void clickOnWeekCheckbox() {
        lnsaPage.clickWeekCheckBox();
    }

    @Then("^Verify week is active$")
    public void verifyWeekIsActive() {
        lnsaPage.verifyWeekActive();
    }


    @When("^User enters reason \"(.*?)\"$")
    public void userEntersReason(String reason) {
        lnsaPage.enterReason(reason);
    }

    @Then("^Verify View Request Status tab opens$")
    public void verifyViewRequestStatusTabOpens() {
        lnsaPage.verifyViewRequestStatusTabOpen();
    }

    @When("^User clicks on \"(.*?)\" row$")
    public void userClicksOnRow(String row) {
        lnsaPage.clickRow(row);
    }

    @Then("^Verify \"(.*?)\" row is in \"(.*?)\" order$")
    public void verifyRowIsInOrder(String row, String order) {
        lnsaPage.verifyOrder(row, order);
    }

}
