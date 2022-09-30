package stepDefinitions;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.FormsPage;
import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.LocatorFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import com.gemini.mis.selectors.LocatorDashboardProfilePage;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.logging.Logger;

import static jxl.biff.FormatRecord.logger;

public class MISForms extends PageObject {
    FormsPage form;
    LoginPage steps;
    Logger log= Logger.getLogger(MISForms.class.getName());

    @Then("User closes application")
    public void user_closes_application() {

        form.closeApplication();
    }


    @And("User click on field")
    public void userClickOnField() {
        steps.Wait(1000);
        steps.click(LocatorFormPage.departmentContainer);
        steps.Wait(2000);
    }

    @Then("User scroll to Element {string}")
    public void userScrollToElement(String arg0) {
        steps.Wait(1000);
        form.scroll(LocatorFormPage.elementAfterScroll(arg0));
        steps.Wait(2000);
    }

    @And("User selects the element {string}")
    public void userSelectsTheElement(String arg0) {
        steps.click(LocatorFormPage.elementAfterScroll(arg0));
        steps.Wait(1000);
    }

    @Then("User selects number of entries {string}")
    public void userSelectsNumberOfEntries(String arg0) {
        steps.click(LocatorFormPage.select());
        steps.click(LocatorFormPage.selectValue(arg0));
    }

    @Then("User verifies search field and enters value {string}")
    public void userVerifiesSearchFieldAndEntersValue(String arg0) {
        steps.isElementExist(LocatorFormPage.searchBox);
        steps.enterValues(LocatorFormPage.searchBox,arg0);
        steps.Wait(1000);
    }

    @Then("User clicks on eye button and view policy")
    public void userClicksOnEyeButtonAndViewPolicy() {
        steps.click(LocatorFormPage.eyeBtn);
        /*steps.Wait(2000);
        steps.changeFocusToNewTab();
        steps.Wait(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");*/
        steps.Wait(4000);
    }


    @Then("User downloads file and deletes {string}")
    public void userDownloadsFileAndDeletes(String fileName) {
        steps.click(LocatorFormPage.downloadBtn);
        steps.Wait(6000);
        form.isFileDownloaded("C:\\Users\\ch.srivastava\\Downloads",fileName);


    }

    @Then("User Clicks on upload Btn")
    public void userClicksOnUploadBtn() {
        steps.click(LocatorFormPage.uploadBtn);
        steps.Wait(1000);
        
    }

    @And("And User uploads  file {string}")
    public void andUserUploadsFile(String fileLoc) throws InterruptedException {
        steps.Wait(2000);
        form.uploadFile(LocatorFormPage.chooseFile,fileLoc);
        steps.Wait(4000);

    }

    @And("User Selects form Type {string}")
    public void userSelectsFormType(String formtype) {
        steps.click(LocatorFormPage.formsType);
        steps.click(LocatorFormPage.formType(formtype));

    }

    @Then("User saves the file")
    public void userSavesTheFile() {
        steps.click(LocatorFormPage.saveBtn);
        steps.Wait(1000);
    }

    @Then("User hover over deactivate button and clicks it")
    public void userHoverOverDeactivateButtonAndClicksIt() {
        WebElementFacade ele=$(LocatorFormPage.deactivateBtn);
        if (ele.isVisible()) {
            steps.Wait(1000);
            form.hoverOver(LocatorFormPage.deactivateBtn);
            steps.click(LocatorFormPage.deactivateBtn);
            steps.isElementExist(LocatorDashboardProfilePage.myElement("Are you sure you want to deactive this form?"));
            steps.click(LocatorFormPage.confirmYes);
            steps.isElementExist(LocatorDashboardProfilePage.myElement("Success"));
            steps.isElementExist(LocatorDashboardProfilePage.myElement("Sign In"));

        }
        else
        {
            log.info("Deactivate button is not present");
        }
    }
    @Then("User confirms deactivation")
    public void userConfirmsDeactivation() {
        steps.click(LocatorFormPage.confirmYes);
    }

    @Then("User verifies element {string} downloads file and deletes {string}")
    public void userVerifiesElementDownloadsFileAndDeletes(String coloumnName, String fileName) {
        WebElementFacade ele=$(LocatorDashboardProfilePage.myElement(coloumnName));
                if(ele.isVisible()){
                    steps.click(LocatorFormPage.downloadBtn);
                    steps.Wait(6000);
                    form.isFileDownloaded("C:\\Users\\ch.srivastava\\Downloads",fileName);

        }
                else{
                   log.info("Download button is not present");

                }

    }
}



