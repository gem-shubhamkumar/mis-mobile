package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions_Sidhanshi;
import com.gemini.mis.selectors.GenericFunctionPOM;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CommonPage extends PageObject {

    CommonFunctions_Sidhanshi commonFunctions = new CommonFunctions_Sidhanshi();

    public void     launchPage(){

        getDriver().get("https://mymis.geminisolutions.com");
        waitABit(3000);
    }
    public void verifyLoginMsg() {
        String loginMsg = commonFunctions.getText(By.xpath(GenericFunctionPOM.loginMsg));
        Assert.assertTrue(StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions."));
    }


    public void enterUsername(String username) {
        commonFunctions.typeText(By.xpath(GenericFunctionPOM.homePageXpath.replace("name", "username")), username);
    }

    public void enterPassword(String password) {
        commonFunctions.typeText(By.xpath(GenericFunctionPOM.homePageXpath.replace("name", "password")), password);

    }

    public void clickButton(String buttonName) {
        commonFunctions.customWait(1000);
        switch(buttonName) {
            case "Sign In": {
                commonFunctions.click(By.xpath(GenericFunctionPOM.homePageXpath.replace("name", "btnLogin")));
                break;
            }

            case "update" : {
                commonFunctions.click(By.xpath(GenericFunctionPOM.genericButton.replace("ids", "btnUpdateSkills")));
                break;
            }

            default:
                Assert.fail("Button " + buttonName + " not found");

        }

    }
}
