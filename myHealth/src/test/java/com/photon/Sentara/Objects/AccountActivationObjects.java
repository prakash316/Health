package com.test.test2.Objects;

import com.test.test2.Utilities.BaseStep;

public class AccountActivationObjects extends BaseStep {

	public final String Sign_Up_btn = objectProperty("//button[text()='Sign Up']~xpath", "", "");
	public final String Continue_Sign_Up_btn = objectProperty("//button[contains(text(),'CONTINUE SIGN')]~xpath", "", "");
	public final String Welcome_text = objectProperty("//myhealth-activationsetup//h1~xpath", "", "");
	public final String Welcome_page_text = objectProperty("//myhealth-activationsetup//p~xpath", "", "");
	public final String Sign_up_page_text = objectProperty("//myhealth-signupfornewaccount//p~xpath", "", "");
	public final String Sign_up_page_text_h2 = objectProperty("//myhealth-signupfornewaccount//h2~xpath", "", "");
	public final String Sign_up_page_text_button = objectProperty("//myhealth-signupfornewaccount//button~xpath", "", "");
	public final String Sign_up_page_text_a = objectProperty("//myhealth-signupfornewaccount/div/div/div/div[3]/a~xpath", "", "");
	public final String Sign_up_page_need_help = objectProperty("//myhealth-account/myhealth-header/header/div/div[2]/div/span/a~xpath", "", "");
	public final String Get_Started_btn = objectProperty("//*[@type='submit']~xpath", "", "");
	//public final String Welcom_Cancel_btn = objectProperty("//*[@type='button']~xpath", "", "");
	public final String Cancel_btn = objectProperty("//button[text()='CANCEL']~xpath", "", "");
	public final String Terms_form = objectProperty("//myhealth-terms/section/form/div/div[1]/div~xpath", "", "");
	public final String Req_One_Link = objectProperty("//myhealth-activationsetup//p/a~xpath", "", "");
	public final String Act_Req_One = objectProperty("//myhealth-activationcode//p[2]/a~xpath", "", "");
	public final String Why_do_we_need_Link = objectProperty("//myhealth-personal-information//div[6]/a~xpath", "", "");
	public final String D_month = objectProperty("//*[@formcontrolname='month']~xpath", "", "");
	public final String D_date = objectProperty("//*[@formcontrolname='date']~xpath", "", "");
	public final String D_year = objectProperty("//*[@formcontrolname='year']~xpath", "", "");
	public final String No_thanks_Link = objectProperty("", "", "");
	public final String Terms_Conditions = objectProperty("", "", "");
	public final String Activation_text = objectProperty("", "", "");
	public final String PersonalInformation_text = objectProperty("//myhealth-personal-information//myhealth-information/p~xpath", "", "");
	public final String PersonalInformation_fields = objectProperty("//myhealth-personal-information//label~xpath", "", "");
	public final String Username_h1_text = objectProperty("//myhealth-activate-username-password//h1~xpath", "", "");
	public final String Username_text = objectProperty("//myhealth-activate-username-password//myhealth-information/p~xpath", "", "");
	public final String Username_FieldLables = objectProperty("//myhealth-activate-username-password//div/label~xpath", "", "");
	public final String Username_HelpText_h1 = objectProperty("//myhealth-activate-username-password/section//div/div[1]/div[1]/div[2]/div/h3~xpath", "", "");
	public final String Username_HelpText = objectProperty("//myhealth-activate-username-password/section//div/div[1]/div[1]/div[2]/div/ul/li~xpath", "", "");
	public final String Password_HelpText_h1 = objectProperty("//myhealth-activate-username-password/section//div/div[1]/div[1]/div[2]/div/ul/li~xpath", "", "");
	public final String Password_HelpText = objectProperty("//myhealth-activate-username-password/section//div/div[1]/div[2]/div[2]/div/ul/li~xpath", "", "");
	public final String Password_eyeIcon = objectProperty("//*[contains(@class,'eye-icon')]~xpath", "", "");
	public final String Username_input = objectProperty("//*[@formcontrolname='userName']~xpath", "", "");
	public final String Password_input = objectProperty("//*[@formcontrolname='password']~xpath", "", "");
	public final String Confirm_Password_input = objectProperty("//*[@formcontrolname='confirmPassword']~xpath", "", "");
	public final String Password_Strength = objectProperty("//*[@id='strength']/span~xpath", "", "");
	public final String Password_Mismatch_error = objectProperty("//myhealth-activate-username-password//div[2]/div[1]/div[3]~xpath", "", "");
	public final String Finish_btn = objectProperty("//*[@type='submit']~xpath", "", "");
	public final String Weak_text = objectProperty("//myhealth-password-strength-bar/div[2]/div[1]~xpath", "", "");
	public final String Medium_text = objectProperty("//myhealth-password-strength-bar/div[2]/div[2]~xpath", "", "");
	public final String Strong_text = objectProperty("//myhealth-password-strength-bar/div[2]/div[3]~xpath", "", "");
	public final String Act_Login_btn = objectProperty("//myhealth-activationsuccess//button~xpath", "", "");
	public final String Act_Login_link = objectProperty("//myhealth-activationsuccess//a~xpath", "", "");
	public final String ActivationSuccess_text = objectProperty("//myhealth-activationsuccess/div/div[2]/h2~xpath", "", "");
	public final String NextStep_btn = objectProperty("//*[@type='submit']~xpath", "", "");
	public final String LoginTo_Your_Account_btn = objectProperty("", "", "");
	public final String ActivationCode_input = objectProperty("//*[@type='text']~xpath", "", "");
	public final String FirstName_input = objectProperty("//*[@formcontrolname='firstName']~xpath", "", "");
	public final String LastName_input = objectProperty("//*[@formcontrolname='lastName']~xpath", "", "");
	public final String DOB_input = objectProperty("//myhealth-personal-information//li[*]~xpath", "", "");
	public final String Email_input = objectProperty("//*[@formcontrolname='email']~xpath", "", "");
	public final String Confirm_Email_input = objectProperty("//*[@formcontrolname='confirmEmail']~xpath", "", "");
	public final String SSN_input = objectProperty("//*[@formcontrolname='ssn']~xpath", "", "");
	public final String Home_page = objectProperty("//myhealth-register/div/div/h2~xpath", "", "");
	public final String SignUpNewAccount_page = objectProperty("//myhealth-signupfornewaccount/div/div/h1~xpath", "", "");
	public final String WelcomeActivation_page = objectProperty("//myhealth-activationsetup/section/div/h1~xpath", "", "");
	public final String Terms_page = objectProperty("//myhealth-terms/section/form/div/h1~xpath", "", "");
	public final String ActivationCode_page = objectProperty("//myhealth-activationcode/section/form/div/h1~xpath", "", "");
	public final String Personal_page = objectProperty("//myhealth-personal-information/div/h1~xpath", "", "");
	public final String Username_page = objectProperty("//myhealth-activate-username-password/section/div/form/h1~xpath", "", "");
	public final String Security_page = objectProperty("//myhealth-security-questions/div/h1~xpath", "", "");
	
	public final String Security_text = objectProperty("//myhealth-security-questions//myhealth-information/p~xpath", "", "");
	public final String Question1_btn = objectProperty("//myhealth-security-questions//div[1]/div[1]/div[1]/div[1]~xpath", "", "");
	public final String Question2_btn = objectProperty("//myhealth-security-questions//div[1]/div[2]/div[1]/div[1]~xpath", "", "");
	public final String Question3_btn = objectProperty("//myhealth-security-questions//div[1]/div[3]/div[1]/div[1]~xpath", "", "");
	public final String Question4_btn = objectProperty("//myhealth-security-questions//div[1]/div[4]/div[1]/div[1]~xpath", "", "");
	public final String Question5_btn = objectProperty("//myhealth-security-questions//div[1]/div[5]/div[1]/div[1]~xpath", "", "");
	public final String Questions_btn = objectProperty("//myhealth-information/following-sibling::div/div[1]~xpath", "", "");
	public final String Answer1_text = objectProperty("//myhealth-security-questions//div[1]/div[1]/div[3]/input~xpath", "", "");
	public final String Answer2_text = objectProperty("//myhealth-security-questions//div[2]/div[1]/div[3]/input~xpath", "", "");
	public final String Answer3_text = objectProperty("//myhealth-security-questions//div[3]/div[1]/div[3]/input~xpath", "", "");
	public final String Answer4_text = objectProperty("//myhealth-security-questions//div[4]/div[1]/div[3]/input~xpath", "", "");
	public final String checkBox = objectProperty("//*[@id='tacCheckBox']~xpath", "", "");
	public final String Error_without_checkBoxCheck = objectProperty("//myhealth-terms//div[3]/span~xpath", "", "");
	public final String Error_without_ScrollDown = objectProperty("//myhealth-terms/section/form//div[3]/span~xpath", "", "");
	public final String toolTip = objectProperty("//myhealth-personal-information//div[6]//p~xpath", "", "");
	public final String Act_text1 = objectProperty("//myhealth-activationcode//p[1]~xpath", "", "");
	public final String Act_text2 = objectProperty("//myhealth-activationcode//p[2]~xpath", "", "");
	public final String PopUp_txt = objectProperty("//myhealth-signupfornewaccount/div/div/div/div[4]/div/p~xpath", "", "");

	
}
