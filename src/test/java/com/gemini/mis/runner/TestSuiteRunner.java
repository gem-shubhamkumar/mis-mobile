package com.gemini.mis.runner;

import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/MySkills.feature"
        , glue = "com/gemini/mis/stepdefinitions"
//        ,tags = "@web_test_30"
//        , dryRun = true


)
public class TestSuiteRunner {
}