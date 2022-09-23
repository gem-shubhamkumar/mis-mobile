package com.gemini.mis.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/MISLogin.feature",
        glue = "com/gemini/mis/stepDefinitions"
)

public class TestRunnerLoginPage {
}
