package solvd.gsm_arena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
	//WEB ELEMENTS
	@FindBy(xpath = "//a[@href='register.php3']")
	private ExtendedWebElement signUpButton;
	
	@FindBy(xpath = "//i[@class='head-icon icon-login']")
	private ExtendedWebElement loginDropdown;
	
	@FindBy(xpath = "//input[@id='email' and @type='email']")
	private ExtendedWebElement loginEmailField;
	
	@FindBy(xpath = "//input[@id='upass' and @type='password']")
	private ExtendedWebElement loginPasswordField;
	
	@FindBy(xpath = "//input[@id='nick-submit' and @type='submit']")
	private ExtendedWebElement logInButton;
	
	@FindBy(xpath = "//a[@href='logout.php3?rdr=MA%3D%3D' and @class='signup-icon no-margin-right']")
	private ExtendedWebElement logOutButton;
	
	@FindBy(xpath = "//input[@type='text' and @name='sSearch']")
	private ExtendedWebElement searchField;
	
	//METHODS
	public HomePage(WebDriver driver) {
		super(driver);
		open();
	}
	
	public SignUpPage clickSignUpButton() {
		signUpButton.clickIfPresent();
		return new SignUpPage(driver);
	}
	
	public void clickLoginDropdown() {
		loginDropdown.clickIfPresent();
	}
	
	public void fillLoginEmailField(String email) {
		loginEmailField.type(email);
	}
	
	public void fillLoginPasswordField(String password) {
		loginPasswordField.type(password);
	}
	
	public LoginPage clickLogInButton() {
		logInButton.clickIfPresent();
		return new LoginPage(driver);
	}
	
	public boolean isLogOutPresent() {
		return logOutButton.isElementPresent(5);
	}
	
	public void fillSearchField(String search) {
		searchField.type(search);
	}
	
	public SearchPage performSearch() {
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		return new SearchPage(driver);
	}
	
	
}
