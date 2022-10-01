package stepDefinitions;


import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.pages.CommonPage;
import com.gemini.mis.pages.GenericFunctionPages_Siddhanshi;
import com.gemini.mis.pages.ReimbursementPages;
import com.gemini.mis.selectors.GenericFunctionPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class CommonSteps {

    @Steps
    CommonPage commonPages;
    GenericFunctionPages_Siddhanshi GenericPage;
    ReimbursementPages remb;
    //Launching my mis portal

    @Steps
    MySkillsPage skillsPages;

    @Steps
    CommonFunctions commonFunctions;

    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() {
        commonPages.launchURL("https://mymis.geminisolutions.com/");
        commonPages.verifyLoginMsg();

    }

    @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {
        commonPages.enterUsername(username);
        commonPages.enterPassword(password);
        commonFunctions.clickOnBtn("Sign In");
    }

    @Then("^Verify Dashboard page opens$")
    public void verifyDashboardPageOpen() {
        commonPages.verifyDashboard();
    }

    @Then("^Click on \"(.*?)\" button$")
    public void clickOnButton(String buttonName) {
        commonFunctions.clickOnBtn(buttonName);
    }


    @When("^\"(.*?)\" card is present in dashboard$")
    public void cardIsPresentInDashboard(String cardName) {
        skillsPages.verifyIfCardIsPresent(cardName);
    }




    @And("^Clicks \"(.*?)\" Button$")
    public void clicksButton(String buttonName) {

        commonPages.clickButton(buttonName);
    }

   @Then("^Click on main screen \"(.*?)\" tab$")
    public void NavigateToTab(String parentTabName){
       GenericPage.navigateToTab(parentTabName);
   }
    @Then("^Click on \"(.*?)\" tab of \"(.*?)\" tab$")
    public void NavigateToMainScreenandSubscreen(String parentTabName, String childTabName){
//        if(parentTabName.equalsIgnoreCase("Other Portals")){
//            waitABit(2000);
////            JavascriptExecutor js = (JavascriptExecutor) getDriver();
////            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//            WebElementFacade element=$(By.xpath(GenericFunctionPOM.screenNavigation.replace("SCREENNAME",parentTabName)));
//            withAction().moveToElement(element);
//            withAction().sendKeys(Keys.ARROW_DOWN).build().perform();
//            GenericPage.navigateToTab(parentTabName,childTabName);
//        }else{
            GenericPage.navigateToTab(parentTabName,childTabName);


    }

    @Then("Verify if Button is visible")
    public void verifyIfButtonIsVisible() {
        remb.ButtonVisibility("Previous");
        remb.ButtonVisibility("Next");
    }

    LoginPage steps;
    FormsPage form;

    @Given("User opens MIS Beta page {string}")
    public void user_opens_mis_beta_page(String url)  {
        steps.navigateApplication(url);
    }
    @Given("User clicks on tab {string} and {string}")
    public void userClicksOnTabAnd(String parentTabName, String childTabName) {
        steps.Wait(3000);
        form.NavigateParentAndChildTab(parentTabName, childTabName);
        steps.Wait(5000);
    }


    @Then("User enters Username as {string}")
    public void user_enters_username_as(String username) {
        steps.enterValues(LocatorLoginPage.inputField("text"),username);

    }
    @And("User enters Password as {string}")
    public void user_enters_password_as(String password) {
        steps.enterValues(LocatorLoginPage.inputField("password"),password);

    }
    @Given("User clicks on sign in")
    public void user_clicks_on_sign_in() {
        steps.Wait(2000);
        steps.WaitTillElementIsVisible(LocatorLoginPage.inputField("button"));
        steps.click(LocatorLoginPage.inputField("button"));
    }

    @Then("User Verifies Landing Page")
    public void user_verifies_landing_page() {
        steps.WaitTillElementIsVisible(LocatorDashboardProfilePage.elementOnLandingPage);

}

}
