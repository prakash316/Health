package com.testProject.Sentara.StepDefinition;

import java.util.List;

import com.testProject.Sentara.StepLibrary.LoginTestStepLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginTestSteps extends LoginTestStepLibrary {
	
	@Given("^user is on test2 web home page$")
	public void test2_home_page() throws Throwable {
		web_home_page();
	}
	
	@Given("^Verify user on Login Page$")
	public void verify_user_on_Login_Page() throws Throwable {
		validateUserOnLoginPage();	    
	}

	@Then("^Verify the components of Login Page$")
	public void verify_the_components_of_Login_Page(List<String> components) throws Throwable {
		verifyLoginPageComponents(components);	    
	}

	@Given("^user enter test2 id \"([^\"]*)\"$")
	public void user_enter_test2_id(String userId) throws Throwable {
		entertest2Id(userId);	    
	}

	@Given("^password \"([^\"]*)\"$")
	public void password(String password) throws Throwable {	    
		entertest2Password(password);
	}

	@Then("^click on the sign in button$")
	public void click_on_the_sign_in_button() throws Throwable {
		clickOnSigninButton();	    
	}

	@Then("^validate user on home page$")
	public void validate_user_on_home_page() throws Throwable {
		validateUserOnHomePage();	    
	}
	

	@Given("^user should be able to see Mytest2ID as input field$")
	public void user_should_be_able_to_see_Mytest2ID_as_input_field()
			throws Throwable {
		usernamefiled();
	}


}