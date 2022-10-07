package com.gemini.mis.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
<<<<<<< HEAD
        tags = "MISAutomation"

=======
        tags = "@Rename"
>>>>>>> f7aeee926639e321abdc2e653eafa75ce9832045
)
public class MISAutomation {

}
