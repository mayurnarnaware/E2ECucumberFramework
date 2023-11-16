package objectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMResetPasswordPage {
	WebDriver driver;
	@FindBy(xpath="//h6[text()='Reset Password']")
	private WebElement txtResetPasswordHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(xpath="//button[normalize-space()='Reset Password']")
	private WebElement btnResetPassword;
	
	@FindBy(xpath="//h6[normalize-space()='Reset Password link sent successfully']")
	private WebElement txtResetPasswordRequestMessage;
	
	public OrangeHRMResetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isOnResetPassword() {
		return txtResetPasswordHeading.isDisplayed();
	}
	
	public void performResetPassword() {
		txtBoxUsername.sendKeys("admin");
		btnResetPassword.click();
	}
	
	public boolean isResetPasswordSuccessful() {
		return txtResetPasswordRequestMessage.isDisplayed();
	}
}
