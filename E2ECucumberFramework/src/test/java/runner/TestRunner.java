package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="C:\\MyFolder\\MyWorkspace\\E2ECucumberFramework\\src\\test\\java\\features",
		glue="stepDefinitions",
		plugin={"html:reports/cucumber.html"},
		tags="@smoke or @sanity")
public class TestRunner extends AbstractTestNGCucumberTests {

}
