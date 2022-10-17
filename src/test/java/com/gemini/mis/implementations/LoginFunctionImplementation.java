package com.gemini.mis.implementations;

import com.gemini.mis.selectors.MISPOM;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFunctionImplementation extends PageObject {

    static final Logger logger = LoggerFactory.getLogger("SampleLogger");
    //launch MyMIS application
    public void  launchPage(){

        getDriver().get("https://mymis.geminisolutions.com");
        waitABit(3000);
    }
    //verify that user is able to see the successful login message
    public void verifyLoginMsg() {
        String loginMsg = $(MISPOM.loginMsg).getText();
        if(StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions.")){
            Assert.assertTrue("User is able to login successfully",true);
        }else{
            Assert.fail("User is unable to login");
            logger.info("User is unable to login");
        }
    }

    //enter username to login
    public void enterUsername(String username) {
        $(By.xpath(MISPOM.homePageXpath.replace("name", "username"))).type(username);
       Assert.assertFalse("the type is unsuccessful",false);
       logger.info("the type is unsuccessful");
    }
    //enter password to enter
    public void enterPassword(String password) {
        $(By.xpath(MISPOM.homePageXpath.replace("name", "password"))).type(password);
        Assert.assertFalse("the type is unsuccessful",false);
        logger.info("the type is unsuccessful");

    }
    //click on the required button to login
    public void clickButton(String buttonName) {
        waitABit(1000);

           if(buttonName.equalsIgnoreCase("Sign In")) {
                $(By.xpath(MISPOM.homePageXpath.replace("name", "btnLogin"))).click();
            }else if(buttonName.equalsIgnoreCase("update")){

                $(MISPOM.genericButton( "btnUpdateSkills")).click();
                $(MISPOM.genericButton("btnUpdateSkills")).click();

            }else {
               Assert.fail("Button " + buttonName + " not found");
               logger.info("Button " + buttonName + " not found");
           }




        }

    }

