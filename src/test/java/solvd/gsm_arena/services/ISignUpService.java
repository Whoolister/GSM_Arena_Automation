package solvd.gsm_arena.services;

import org.openqa.selenium.WebDriver;
import solvd.gsm_arena.HomePage;
import solvd.gsm_arena.SignUpPage;

import java.util.Random;

public interface ISignUpService {
	default SignUpPage goToSignUp(WebDriver driver) {
		return new HomePage(driver).clickSignUpButton();
	}
	
	default SignUpPage invalidEmailSignUp(WebDriver driver) {
		SignUpPage signUp = goToSignUp(driver);
		signUp.fillNicknameField("Testing" + new Random().nextInt(999999999));
		signUp.fillEmailField("ABCDEF@g");
		signUp.fillPasswordField("Testing");
		signUp.checkDataStorageCheckbox();
		signUp.checkAgeMajorityCheckbox();
		signUp.clickSubmitButton();
		return signUp;
	}
	
	default SignUpPage emptyNicknameSignUp(WebDriver driver) {
		SignUpPage signUp = goToSignUp(driver);
		signUp.fillEmailField("ABCDEF@gmail.com");
		signUp.fillPasswordField("Testing");
		signUp.checkDataStorageCheckbox();
		signUp.checkAgeMajorityCheckbox();
		signUp.clickSubmitButton();
		return signUp;
	}
	
	default SignUpPage emptyEmailSignUp(WebDriver driver) {
		SignUpPage signUp = goToSignUp(driver);
		signUp.fillNicknameField("Testing" + new Random().nextInt(999999999));
		signUp.fillPasswordField("Testing");
		signUp.checkDataStorageCheckbox();
		signUp.checkAgeMajorityCheckbox();
		signUp.clickSubmitButton();
		return signUp;
	}
	
	default SignUpPage uncheckedBoxesSignUp(WebDriver driver) {
		SignUpPage signUp = goToSignUp(driver);
		signUp.fillNicknameField("Testing" + new Random().nextInt(999999999));
		signUp.fillEmailField("ABCDEF@g");
		signUp.fillPasswordField("Testing");
		signUp.clickSubmitButton();
		return signUp;
	}
}
