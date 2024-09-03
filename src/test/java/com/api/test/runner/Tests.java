package com.api.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/*
    * This class is the test runner for the Cucumber tests
 */
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = {"com.api.test.steps"},
            plugin = {"pretty",
                    "html:target/cucumber.html",
                    "json:target/cucumber.json",
                    "junit:target/cucumber.xml",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
            monochrome = true
    )
    public class Tests {
    }

