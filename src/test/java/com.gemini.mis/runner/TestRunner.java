package com.gemini.mis.runner;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature"
        ,glue = "stepDefinitions"
        ,tags ="@Test1"
)

public class TestRunner {
}
