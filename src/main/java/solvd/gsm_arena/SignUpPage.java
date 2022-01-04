package solvd.gsm_arena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {
	//WEB ELEMENTS
	@FindBy(xpath = "//h1[@class='article-info-name']")
	private ExtendedWebElement welcomeMessage;
	
	@FindBy(xpath = "//input[@id='uname' and @type='text']")
	private ExtendedWebElement nicknameField;
	
	@FindBy(xpath = "(//input[@id='email' and @type='email'])[2]")
	private ExtendedWebElement emailField;
	
	@FindBy(xpath = "(//input[@id='upass' and @type='password'])[2]")
	private ExtendedWebElement passwordField;
	
	@FindBy(xpath = "//input[@id='iagree1' and @type='checkbox']")
	private ExtendedWebElement dataStorageCheckbox;
	
	@FindBy(xpath = "//input[@id='iagree2' and @type='checkbox']")
	private ExtendedWebElement ageMajorityCheckbox;
	
	@FindBy(xpath = "//input[@id='nick-submit' and @type='submit' and @class='button float-right']")
	private ExtendedWebElement submitButton;
	
	@FindBy(xpath = "//div[@class='normal-text res-error']//p")
	private ExtendedWebElement errorMessage;
	
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	//METHODS
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
	
	public void fillNicknameField(String nickname) {
		nicknameField.type(nickname);
	}
	
	public void fillEmailField(String email) {
		emailField.type(email);
	}
	
	public void fillPasswordField(String password) {
		passwordField.type(password);
	}
	
	public void checkDataStorageCheckbox() {
		dataStorageCheckbox.click();
	}
	
	public void checkAgeMajorityCheckbox() {
		ageMajorityCheckbox.click();
	}
	
	public void clickSubmitButton() {
		submitButton.clickIfPresent();
	}
	
	public String getSubmitStatus() {
		return submitButton.getAttribute("disabled");
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
