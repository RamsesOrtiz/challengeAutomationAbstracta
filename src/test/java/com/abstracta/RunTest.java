package com.abstracta;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.abstracta.defs",
        features = "src/test/resources/features/scenarios.feature",
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunTest extends AbstractTestNGCucumberTests {
}
