package stepDefinitions;

import com.gemini.mis.pages.OtherPortalPages;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Set;

public class OtherPortalStepDefinition extends PageObject {
@Steps
    OtherPortalPages Pages;

    //validation of other portal navigation
    @Then("^Verify If other Portal is able to navigate \"(.*?)\" to the required location$")
   public void ValidationForHyperlink(String subsScreen){
        Pages.validateOtherPortal(subsScreen);
    }
}
