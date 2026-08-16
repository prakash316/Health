package com.test.test2.StepLibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.test.test2.Objects.LoginTestObjects;
import com.test.test2.Utilities.CommonUtilities;

public class LoginTestStepLibrary extends CommonUtilities {

	LoginTestObjects login = new LoginTestObjects();
	Logger log = Logger.getLogger(this.getClass().getSimpleName());

	public void validateUserOnLoginPage() throws Exception {
		isElementPresentVerification(login.test2_signin_button);
		log.info("User on Login Page");
	}

	public void web_home_page() throws Throwable {
		driver.get(config.getString("appUrl"));
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.equalsIgnoreCase("My test2"),
				"User is not navigated to test2 home page");
		log.info("Successfully navigated to test2 home page");
	}

	public void verifyLoginPageComponents(List<String> components)
			throws Exception {

		text_Validation(login.test2_logo, components.get(0));
		text_Validation(login.test2_id_field, components.get(1));
		text_Validation(login.test2_password_field, components.get(2));
		text_Validation(login.test2_signin_button, components.get(3));
		log.info("All the login components are validated");
	}

	public void entertest2Id(String userId) {
		clearAndEnterText(login.test2_id_field, userId);
		log.info("User ID Entered");
	}

	public void entertest2Password(String password) {
		clearAndEnterText(login.test2_password_field, password);
		log.info("User Password Entered");
	}

	public void clickOnSigninButton() {
		isElementPresentVerifyClick(login.test2_signin_button);
		log.info("Sign in Button Clicked");
	}

	public void validateUserOnHomePage() {
		Assert.assertEquals(true, false);
		log.info("Login functionality is not implemented");
	}

	public void usernamefiled() throws Throwable {
		inputFieldValidation(login.Mytest2ID);
		log.info("Username field is exists.");
	}
}