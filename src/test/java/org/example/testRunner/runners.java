package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/main/resources/Features",
            glue = {"org.example.stepDefinitions"},
            plugin = {"pretty",
                    "html:target/MyReport_cucumber.html",
                    "json:target/cucumber.json"
            },
            tags = "@smoke"
    )

    public class runners extends AbstractTestNGCucumberTests {
    }



