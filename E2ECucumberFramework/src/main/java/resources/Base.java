package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import commonLibraries.UtilitiesLibrary;

public class Base {
	WebDriver driver;
	private String username;
	private String password;
	private String url;
	private String basePath = System.getProperty("user.dir");
	public WebDriver initializeDriver() throws IOException {
		String path = basePath + "\\src\\main\\java\\resources\\data.properties";
		FileInputStream file = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(file);
		String browser = prop.getProperty("browser");
		int impWait = Integer.parseInt(prop.getProperty("implicitWait"));
		
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		url = prop.getProperty("URL");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			Assert.assertTrue(false, "Unsupported browser, only chrome, firefox and edge are supported.");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(impWait));
		return driver;
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	
	public String getScreenshot(WebDriver driver, String testName) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = basePath + "\\screenshots\\"+testName+"screenshot_" + UtilitiesLibrary.getCurrentTimestamp() + ".png";
		FileUtils.copyFile(file, new File(path));
		return path;
	}
}
