package stepDefinitions;

import com.gemini.mis.commonFunctions.commonMethods;
import com.gemini.mis.pages.NavBarPages;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;;

public class NavBarSteps {
    @Steps
    commonMethods commonFunction;

    NavBarPages navPages;

    @Then("^Verify user is redirected to landing page$")
    public void VerfyNavigationToLandingPage(){
        navPages.verifyUserRedirectedToLandingPage();
    }

    @Then("^Verify \"(.*?)\" disappears form current screen$")
    public void verifySideNavigationBarDisappears(String eleName){
        commonFunction.verifyElementIsNotVisible(eleName);
    }
}
