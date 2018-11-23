package ru.mail;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java", tags = { "@MoveToSpam, @MoveFromSpam, @ComposeLetter, @SelectOperations" })
public class TestRunner extends AbstractTestNGCucumberTests {
}