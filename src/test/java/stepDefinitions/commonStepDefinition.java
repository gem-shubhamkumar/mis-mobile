package stepDefinitions;

import com.gemini.mis.pages.LeaveManagementApplyPage;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class commonStepDefinition extends PageObject
{

    @Steps
    LeaveManagementApplyPage ApplyPage;
    @Given("^User is logged into MIS$")
    public void userIsLoggedIn()
    {
        ApplyPage.launchSite();
        ApplyPage.typeIntoElement("jasleen.multani","username");
        ApplyPage.typeIntoElement("Gemini@1234","password");
        waitABit(3000);
        ApplyPage.clickOnButton("Sign in");

    }
}
