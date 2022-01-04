package solvd.gsm_arena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
	//WEB ELEMENTS
	@FindBy(xpath = "//div[@class='normal-text res-error']//p")
	private ExtendedWebElement errorMessage;
	
	//METHODS
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage redirect() {
		return new HomePage(driver);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
