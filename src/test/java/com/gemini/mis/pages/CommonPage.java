package com.gemini.mis.pages;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.CommonSelectors;
import com.gemini.mis.selectors.FeedbackSelectors;
import com.gemini.mis.selectors.MySkillsLocators;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommonPage extends PageObject {

    @Steps
    CommonFunctions commonFunctions;

    @Step
    public void verifyLoginMsg() {
        String loginMsg = $(By.xpath(CommonSelectors.loginMsg)).getText();
        Assert.assertTrue(StringUtils.contains(loginMsg, "This website is to be used only for authorized business purposes by the employees of Gemini Solutions."));
    }

    @Step
    public void enterUsername(String username) {
        $(By.xpath(CommonSelectors.homePageXpath.replace("name", "username"))).type(username);
    }
    @Step
    public void enterPassword(String password) {
        $(By.xpath(CommonSelectors.homePageXpath.replace("name", "password"))).type(password);

    }

    @Step
    public void verifyDashboard() {
        waitABit(3000);
        Assert.assertTrue($(By.xpath(CommonSelectors.designation)).isPresent());
        Assert.assertTrue($(By.xpath(CommonSelectors.logo)).isPresent());

    }




}
