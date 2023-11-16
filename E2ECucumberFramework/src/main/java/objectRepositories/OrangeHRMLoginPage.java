package objectRepositories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
	WebDriver driver;
	
	//private By txtLoginHeading = By.xpath("//h5[text()='Login']");
	//private By txtBoxUsername = By.name("username");
	//private By txtBoxPassword = By.name("password");
	//private By btnLogin = By.xpath("//button[normalize-space()='Login']");
	
	@FindBy(xpath="//h5[text()='Login']")
	private WebElement txtLoginHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(name="password")
	private WebElement txtBoxPassword;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement txtInvalidCredentials;
	
	@FindBy(xpath="//p[normalize-space()='Forgot your password?']")
	private WebElement lnkForgotPassword;
	
	
	public OrangeHRMLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isOnLogin() {
		return txtLoginHeading.isDisplayed();
	}
	
	public void performLogin(String username, String password) {
		txtBoxUsername.sendKeys(username);
		txtBoxPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public boolean verifyInvalidCredentialsMsg() {
		return txtInvalidCredentials.isDisplayed();
	}
	
	public void clickForgotPassword() {
		lnkForgotPassword.click();
	}
	
	
	
}
