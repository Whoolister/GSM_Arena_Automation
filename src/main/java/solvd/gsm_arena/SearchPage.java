package solvd.gsm_arena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {
	//WEB ELEMENTS
	@FindBy(xpath = "//div[@id='news']//h3")
	private ExtendedWebElement errorMessage;
	
	//METHODS
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
