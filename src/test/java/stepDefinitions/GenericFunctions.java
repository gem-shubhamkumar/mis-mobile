package stepDefinitions;

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

import java.util.Iterator;
import java.util.Set;

public class GenericFunctions extends PageObject {
    @Steps
    CommonPage commonPages;
    GenericFunctionPages_Siddhanshi GenericPage;
    ReimbursementPages remb;
    //Launching my mis portal


    @Given("^MIS Beta is opened and verify application opens successfully$")
    public void misBetaIsOpenedAndVerifyApplicationOpensSuccesfully() {
        commonPages.launchPage();
        commonPages.verifyLoginMsg();

    }
    @When("^User logins into application with username \"(.*?)\" and password \"(.*?)\"$")
    public void enterUsername(String username, String password) {
        commonPages.enterUsername(username);
        commonPages.enterPassword(password);
        commonPages.clickButton("Sign In");
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


}
