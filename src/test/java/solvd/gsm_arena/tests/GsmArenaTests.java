package solvd.gsm_arena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import solvd.gsm_arena.HomePage;
import solvd.gsm_arena.LoginPage;
import solvd.gsm_arena.SearchPage;
import solvd.gsm_arena.SignUpPage;
import solvd.gsm_arena.services.ILogInService;
import solvd.gsm_arena.services.ISearchService;
import solvd.gsm_arena.services.ISignUpService;

import java.util.concurrent.TimeUnit;

public class GsmArenaTests implements IAbstractTest, ISignUpService, ILogInService, ISearchService {
	@DataProvider(name = "brandQueries")
	public Object[][] brands() {
		return new Object[][]{{"Samsung"}, {"Apple"}, {"Microsoft"}, {"Google"}};
	}
	
	@DataProvider(name = "phoneQueries")
	public Object[][] phones() {
		return new Object[][]{{"A21s"}, {"iPhone 13 Pro Max"}, {"Surface Duo 2"}, {"Pixel 6 " + "Pro"}};
	}
	
	@Test
	public void verifySingUpWelcomeMessage() {
		SignUpPage signUp = goToSignUp(getDriver());
		Assert.assertEquals(signUp.getWelcomeMessage(), "Sign Up", "ERROR, NOT THE SAME");
	}
	
	@Test
	public void validateInvalidEmailSingUp() {
		SignUpPage signUp = invalidEmailSignUp(getDriver());
		Assert.assertTrue(signUp.getErrorMessage().contains("Reason: You need to provide valid " + "email."));
	}
	
	@Test
	public void validateEmptyNicknameSingUp() {
		SignUpPage signUp = emptyNicknameSignUp(getDriver());
		Assert.assertEquals(signUp.getErrorMessage(), "Reason: Your nickname should have between 2" + " and 20 symbols.", "ERROR, NOT THE SAME");
	}
	
	@Test
	public void validateEmptyEmailSignUp() {
		SignUpPage signUp = emptyEmailSignUp(getDriver());
		Assert.assertEquals(signUp.getSubmitStatus(), "true", "ERROR, NOT THE SAME");
	}
	
	@Test
	public void validateRequiredConditionsSignUp() {
		SignUpPage signUp = uncheckedBoxesSignUp(getDriver());
		Assert.assertEquals(signUp.getSubmitStatus(), "true", "ERROR, NOT THE SAME");
	}
	
	@Test
	public void validateSuccessfulLogin() {
		HomePage home = loginWithDefaults(getDriver());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(home.isLogOutPresent(), "ERROR, NOT PRESENT");
	}
	
	@Test
	public void validateInvalidLogin() {
		LoginPage login = invalidLogin(getDriver());
		Assert.assertEquals(login.getErrorMessage(), "Reason: Wrong password.", "ERROR, NOT THE " + "SAME");
	}
	
	@Test
	public void validateEmptyEmailLogin() {
		HomePage home = emptyEmailLogin(getDriver());
		Assert.assertFalse(home.isLogOutPresent(), "ERROR, YOU WERE LOGGED IN");
	}
	
	@Test
	public void validateEmptyPasswordLogin() {
		HomePage home = emptyPasswordLogin(getDriver());
		Assert.assertFalse(home.isLogOutPresent(), "ERROR, YOU WERE LOGGED IN");
	}
	
	@Test(dataProvider = "brandQueries")
	public void validateBrandSearch(String brand) {
		SearchPage search = goToSearch(getDriver(), brand);
		Assert.assertNotEquals(search.getErrorMessage(), "We're sorry, we found no results", "ERROR, NOT THE SAME");
	}
	
	@Test(dataProvider = "phoneQueries")
	public void validatePhoneSearch(String phone) {
		SearchPage search = goToSearch(getDriver(), phone);
		Assert.assertNotEquals(search.getErrorMessage(), "We're sorry, we found no results", "ERROR, NOT THE SAME");
	}
	
	@Test
	public void validateErrorMessage() {
		SearchPage search = goToSearch(getDriver(), "adkhabdhkawhdgwyawkhg");
		Assert.assertEquals(search.getErrorMessage(), "We're sorry, we found no results", "ERROR, NOT THE SAME");
	}
}