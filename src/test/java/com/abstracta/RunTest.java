package com.abstracta;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = "com.abstracta.defs",
        features = {"src/test/resources/features/productInfo.feature",
                "src/test/resources/features/signUp.feature",
                "src/test/resources/features/logIn.feature",
                "src/test/resources/features/purchase.feature"},
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunTest extends AbstractTestNGCucumberTests {
}
