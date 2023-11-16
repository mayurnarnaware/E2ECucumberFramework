package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibraries.TestContextSetup;
import commonLibraries.UtilitiesLibrary;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks{
	
	TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@Before
	public void before_Validation(){
		System.out.println("Hooks: before validation");
	}

	@After
	public void after_Validation(){
		System.out.println("Hooks: after Validation");
		testContextSetup.driver.quit();
	}
	
	@BeforeStep
	public void beforeStep_Validation(){
		System.out.println("Hooks: before Step Validation");
	}

	@AfterStep
	public void afterStep_addScreenshot(Scenario scenario) throws IOException{
		System.out.println("Hooks: after step Validation");
		if(scenario.isFailed()==true) {
			//code to capture screenshot
			File file = ((TakesScreenshot)testContextSetup.driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(file);
			scenario.attach(fileContent, "image/png", scenario.getName()+ "_" + UtilitiesLibrary.getCurrentTimestamp());
		}
	}
}
