package com.gemini.mis.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features/" , glue = "com/gemini/mis/stepdefinitions" , tags = "@lunch"


)
public class TestSuiteRunner
{
}