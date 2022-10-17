package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.FormsPage;
import com.gemini.mis.pages.LoginPage;
import com.gemini.mis.selectors.XpathForFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.WebElementFacade;
import com.gemini.mis.selectors.XpathForDashboardProfilePage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class MISForms extends PageObject{

    @Steps
    FormsPage form;
    @Steps
    LoginPage steps;
    Logger log= LoggerFactory.getLogger("SampleLogger");

    @Then("User closes application")
    public void userClosesApplication() {

        form.closeApplication();
    }


    @And("User click on field")
    public void userClickOnField() {
        steps.customWait(1000);
        steps.click(XpathForFormPage.departmentContainer);
        steps.customWait(2000);
    }

    @Then("User scroll to Element {string}")
    public void userScrollToElement(String arg0) {
        steps.customWait(1000);
        form.scroll(XpathForFormPage.elementAfterScroll(arg0));
        steps.customWait(2000);
    }

    @And("User selects the element {string}")
    public void userSelectsTheElement(String arg0) {
        steps.click(XpathForFormPage.elementAfterScroll(arg0));
        steps.customWait(1000);
    }

    @Then("User selects number of entries {string}")
    public void userSelectsNumberOfEntries(String arg0) {
        steps.click(XpathForFormPage.select());
        steps.click(XpathForFormPage.selectValue(arg0));
    }

    @Then("User verifies search field and enters value {string}")
    public void userVerifiesSearchFieldAndEntersValue(String value) {
        steps.isElementExist(XpathForFormPage.searchBox);
        steps.enterValues(XpathForFormPage.searchBox,value);
        steps.customWait(1000);
    }

    @Then("User clicks on eye button and view policy")
    public void userClicksOnEyeButtonAndViewPolicy() {
        steps.click(XpathForFormPage.eyeBtn);
        steps.customWait(3000);
        }


    @Then("User downloads file and deletes {string}")
    public void userDownloadsFileAndDeletes(String fileName) {
        steps.click(XpathForFormPage.downloadBtn);
        steps.customWait(6000);
        form.isFileDownloaded("C:\\Users\\ch.srivastava\\Downloads",fileName);


    }

    @Then("User Clicks on upload Btn")
    public void userClicksOnUploadBtn() {
        steps.click(XpathForFormPage.uploadBtn);
        steps.customWait(1000);
        
    }

    @And("And User uploads  file {string}")
    public void andUserUploadsFile(String fileLoc) throws InterruptedException {
        steps.customWait(2000);
        form.uploadFile(XpathForFormPage.chooseFile,fileLoc);
        steps.customWait(2000);

    }

    @And("User Selects form Type {string}")
    public void userSelectsFormType(String formType) {
        steps.customWait(1000);
        steps.click(XpathForFormPage.formsType);
        steps.click(XpathForFormPage.formType(formType));

    }

    @Then("User saves the file")
    public void userSavesTheFile() {
        steps.click(XpathForFormPage.saveBtn);
        steps.customWait(1000);
    }

    @Then("User hover over deactivate button and clicks it")
    public void userHoverOverDeactivateButtonAndClicksIt() throws Exception {
        WebElementFacade ele=$(XpathForFormPage.deactivateBtn);
        if (ele.isVisible()) {
            steps.customWait(1000);
            form.hoverOver(XpathForFormPage.deactivateBtn);
            steps.click(XpathForFormPage.deactivateBtn);
            steps.isElementExist(XpathForDashboardProfilePage.myElement("Are you sure you want to deactive this form?"));
            steps.click(XpathForFormPage.confirmYes);
            steps.isElementExist(XpathForDashboardProfilePage.myElement("Success"));
            steps.isElementExist(XpathForDashboardProfilePage.myElement("Sign In"));

        }
        else
        {
            log.info("Deactivate button is not present");
        }
    }
    @Then("User confirms deactivation")
    public void userConfirmsDeactivation() {

        steps.click(XpathForFormPage.confirmYes);
    }

    @Then("User verifies element {string} downloads file and deletes {string}")
    public void userVerifiesElementDownloadsFileAndDeletes(String coloumnName, String fileName) {
        WebElementFacade ele=$(XpathForDashboardProfilePage.myElement(coloumnName));
                if(ele.isVisible()){
                    steps.click(XpathForFormPage.downloadBtn);
                    steps.customWait(5000);
                    form.isFileDownloaded("C:\\Users\\ch.srivastava\\Downloads",fileName);

        }
                else{
                   log.info("Download button is not present");

                }

    }
}



