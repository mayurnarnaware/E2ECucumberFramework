package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import commonLibraries.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepositories.OrangeHRMHomePage;
import objectRepositories.OrangeHRMLoginPage;
import resources.Base;

public class StepDefinition extends Base{
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	
	TestContextSetup testContextSetup;
	public StepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	//Given User is on login page
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
		testContextSetup.driver = initializeDriver();
		testContextSetup.driver.get(getUrl());
		lp = new OrangeHRMLoginPage(testContextSetup.driver);
		hp = new OrangeHRMHomePage(testContextSetup.driver);
		Assert.assertTrue(lp.isOnLogin(),"StepFail: User not on login page");
		System.out.println("StepPass: User is on login page");
		
	}
	
	@When("^User clicks on login by entering username as (.+) and password as (.+)$")
	public void user_clicks_on_login_by_entering_username_as_and_password_as(String username, String password) {
		if(username.contains("\"") || password.contains("\"")) {
			username = username.replace("\"", "");
			password = password.replace("\"", "");
		}
		lp.performLogin(username, password);
	}

	@Then("^login success is \"([^\"]*)\"$")
	public void login_success_is(String string) {
	    if(string.equals("true")) {
	    	//successful
	    	Assert.assertTrue(hp.isOnHome(), "StepFail: Login is unsuccessful");
			System.out.println("StepPass: Login is successful");
	    }
	    else {
	    	//unsuccessful
	    	Assert.assertTrue(lp.verifyInvalidCredentialsMsg(), "StepFail: Unable to verify unsuccessful login");
	    	System.out.println("StepFail: Unable to verify unsuccessful login");
	    }
	}
	
	@Given("chrome browser")
	public void chrome_browser() {
	    System.out.println("Background: chrome broweser");
	}

	@When("browser is launched")
	public void browser_is_launched() {
		System.out.println("Background: browser is launched");
	}

	@Then("verify browser is started")
	public void verify_browser_is_started() {
		System.out.println("Background: verify browser is started");
	}
}
