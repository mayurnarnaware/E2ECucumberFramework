package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {
	WebDriver driver;
	//private By txtDashboardHeading = By.xpath("//h6[text()='Dashboard']");
	//private By txtloggedInUser = By.xpath("//img[@alt='profile picture']/following-sibling::p");
	//private By lnkLogout = By.linkText("Logout");
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement txtDashboardHeading;
	
	@FindBy(xpath="//img[@alt='profile picture']/following-sibling::p")
	private WebElement txtloggedInUser;
	
	@FindBy(linkText="Logout")
	private WebElement lnkLogout;
	
	
	public OrangeHRMHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOnHome() {
		boolean isOnHome = false;
		try {
			isOnHome = txtDashboardHeading.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOnHome;
	}
	
	public boolean getLoggedInUser() {
		String loggedInUser = txtloggedInUser.getText();
		System.out.println("loggedInUser: " + loggedInUser);
		if(loggedInUser.equals(null)==false && loggedInUser.equals("")==false) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void performLogout() {
		txtloggedInUser.click();
		lnkLogout.click();
	}
}
