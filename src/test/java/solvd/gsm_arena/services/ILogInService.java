package solvd.gsm_arena.services;

import org.openqa.selenium.WebDriver;
import solvd.gsm_arena.HomePage;
import solvd.gsm_arena.LoginPage;

public interface ILogInService {
	String nickname = "TestAutomation";
	String email = "lfonseca@solvd.com";
	String password = "Automation";
	
	default HomePage goToLogin(WebDriver driver) {
		HomePage home = new HomePage(driver);
		home.clickLoginDropdown();
		return home;
	}
	
	default HomePage loginWithDefaults(WebDriver driver) {
		HomePage home = goToLogin(driver);
		home.fillLoginEmailField(email);
		home.fillLoginPasswordField(password);
		LoginPage login = home.clickLogInButton();
		return login.redirect();
	}
	
	default LoginPage invalidLogin(WebDriver driver) {
		HomePage home = goToLogin(driver);
		home.fillLoginEmailField(email);
		home.fillLoginPasswordField(password + "0");
		return home.clickLogInButton();
	}
	
	default HomePage emptyEmailLogin(WebDriver driver) {
		HomePage home = goToLogin(driver);
		home.fillLoginPasswordField(password);
		LoginPage login = home.clickLogInButton();
		return login.redirect();
	}
	
	default HomePage emptyPasswordLogin(WebDriver driver) {
		HomePage home = goToLogin(driver);
		home.fillLoginEmailField(email);
		LoginPage login = home.clickLogInButton();
		return login.redirect();
	}
}
