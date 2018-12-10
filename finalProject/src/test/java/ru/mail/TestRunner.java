package ru.mail;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/features")
public class TestRunner extends AbstractTestNGCucumberTests {
}