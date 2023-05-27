package com.foodics.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import  org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/com/foodics/resources/features"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"com.foodics.steps"}
)
public class UserAPIRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider
    public Object[][] scenarios(){
        return  super.scenarios();
    }
}

