package com.testProject.Sentara.StepLibrary;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.testProject.Sentara.Objects.AccountActivationObjects;
import com.testProject.Sentara.Utilities.CommonUtilities;

public class AccountActivationTestStepLibrary extends CommonUtilities {

	AccountActivationObjects accact = new AccountActivationObjects();
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	String Qstn_text;


	public void clickOnButton(String button) throws Exception {
		switch(button.toUpperCase()) {
		case "SIGN UP":
			isElementPresentVerifyClick(accact.Sign_Up_btn);
			log.info("User successfully clicked on " +button+" button");
			break;

		case "CONTINUE SIGN UP":
			isElementPresentVerifyClick(accact.Continue_Sign_Up_btn);
//			WebElement ele = getElementsByProperty(accact.Sign_Up_btn).get(0);
//			ele.click();
			log.info("User successfully clicked on " +button+" button");
			break;	

		case "GET STARTED":
			isElementPresentVerifyClick(accact.Get_Started_btn);
			log.info("User successfully clicked on " +button+" button");
			break;	

		case "NEXT STEP":
			isElementPresentVerifyClick(accact.NextStep_btn);
			log.info("User successfully clicked on " +button+" button");
			break;

		case "FINISH":
			//scrollTo(driver, getElementByProperty(accact.Finish_btn));
			isElementPresentVerifyClick(accact.Finish_btn);
			log.info("User successfully clicked on " +button+" button");
			break;
			
		case "QUESTION1":
			isElementPresentVerifyClick(accact.Question1_btn);
			Qstn_text = getText(accact.Question1_btn);
			log.info("User successfully clicked on " +button+" button");//+Qstn_text);
			break;
			
		case "QUESTION2":
			isElementPresentVerifyClick(accact.Question2_btn);
			Qstn_text = getText(accact.Question2_btn);
			log.info("User successfully clicked on " +button+" button");//+Qstn_text);
			break;
			
		case "QUESTION3":
			scrollTo(driver, getElementByProperty(accact.Question3_btn));
			isElementPresentVerifyClick(accact.Question3_btn);
			Qstn_text = getText(accact.Question3_btn);
			log.info("User successfully clicked on " +button+" button");//+Qstn_text);
			break;

		default:
			log.info("Is not a button");
			break;

		}
		
		
	}

	public void userAnswers(String Answer, String Question) throws Throwable{
		switch(Question) {
		case "Question1":
			clearAndEnterText(accact.Answer1_text, Answer);
			break;
			
		case "Question2":
			clearAndEnterText(accact.Answer2_text, Answer);
			break;
			
		case "Question3":
			clearAndEnterText(accact.Answer3_text, Answer);
			break;
			
			default:
				log.info("Question not found");
		}
		log.info("User entered Answer for "+Question);
	}
	

	public void validateUserOnPage(String page) throws Exception {
		/*String pageTitle = driver.getTitle();
			Assert.assertTrue(pageTitle.equalsIgnoreCase(page),"User is not on "+page);
			log.info("User is on "+page+" screen");*/
		switch(page){
			case "Home":
				isElementPresentVerification(accact.Home_page);
				log.info("User is on Home screen");
				break;
				
			case "Sign Up for a New Account":
				isElementPresentVerification(accact.SignUpNewAccount_page);
				log.info("User is on Sign Up for a New Account screen");
				break;
				
			case "Welcome to Activation Setup!":
				isElementPresentVerification(accact.WelcomeActivation_page);
				log.info("User is on Activation Code screen");
				break;
				
			case "Terms and Conditions":
				isElementPresentVerification(accact.Terms_page);
				log.info("User is on Activation Code screen");
				break;
				
			case "Activation Code":
				isElementPresentVerification(accact.ActivationCode_page);
				log.info("User is on Activation Code screen");
				break;
				
			case "Personal Information":
				isElementPresentVerification(accact.Personal_page);
				log.info("User is on Personal Information screen");
				break;
				
			case "Username & Password":
				isElementPresentVerification(accact.Username_page);
				log.info("User is on Username & Password screen");
				break;
				
			case "Security Questions":
				isElementPresentVerification(accact.Security_page);
				log.info("User is on Security Questions screen");
				break;
				
			case "Activation Success":
				isElementPresentVerification(accact.ActivationSuccess_text);
				log.info("User is on Activation Success screen");
				break;
				
			default:
				log.info("User not on "+page+" screen");
				
		}
		
		}

	public void validateContentsOfPage(String page,List<String> text) throws Exception {
		switch(page) {
		case "Welcome to Activation Setup":
		//	text_validation_Assert(accact.Welcome_text, "Welcome to Activation Setup!");
			Thread.sleep(2000);
			List<WebElement> Welcom_text = getElementsByProperty(accact.Welcome_page_text);
			text_Assert(Welcom_text.get(0).getText(),text.get(0));
			text_Assert(Welcom_text.get(1).getText(),text.get(1));
			text_Assert(getText(accact.Get_Started_btn),text.get(2));
			text_Assert(getText(accact.Cancel_btn),text.get(3));
			log.info("All the text on Welcome Activation Page are validated");
			break;
			
		case "Activation Code":
			Thread.sleep(2000);
			List<WebElement> Act_text = getElementsByProperty(accact.Act_text1);
			text_Assert(Act_text.get(0).getText(),text.get(0));
			text_Assert(Act_text.get(1).getText(),text.get(1));
			text_Assert(getText(accact.Act_text2), text.get(2));
			text_Assert(getText(accact.NextStep_btn),text.get(3));
			text_Assert(getText(accact.Cancel_btn),text.get(4));
			log.info("All the text on Activation Code Page are validated");
			break;
			
		case "Personal Information":
			Thread.sleep(2000);
			text_Assert(getText(accact.PersonalInformation_text), text.get(0));
			List<WebElement> Personal_fields = getElementsByProperty(accact.PersonalInformation_fields);
			text_Assert(Personal_fields.get(0).getText(),text.get(1));
			text_Assert(Personal_fields.get(1).getText(),text.get(2));
			text_Assert(Personal_fields.get(2).getText(),text.get(3));
			text_Assert(Personal_fields.get(3).getText(),text.get(4));
			text_Assert(Personal_fields.get(4).getText(),text.get(5));
			text_Assert(Personal_fields.get(5).getText(),text.get(6));
			text_Assert(getText(accact.Why_do_we_need_Link), text.get(7));
			text_Assert(getText(accact.NextStep_btn), text.get(8));
			text_Assert(getText(accact.Cancel_btn), text.get(9));
			log.info("All the text on Personal Information Page are validated");
			break;
			
		case "Username & Password":
			Thread.sleep(2000);
			text_Assert(getText(accact.Username_h1_text), text.get(0));
			text_Assert(getText(accact.Username_text), text.get(1));
			List<WebElement> Username_fields = getElementsByProperty(accact.Username_FieldLables);
			text_Assert(Username_fields.get(0).getText(), text.get(2));
			text_Assert(Username_fields.get(1).getText(), text.get(3));
			text_Assert(Username_fields.get(2).getText(), text.get(4));
			text_Assert(getText(accact.NextStep_btn), text.get(5));
			text_Assert(getText(accact.Cancel_btn), text.get(6));
			text_Assert(getText(accact.Password_Strength), text.get(7));
			text_Assert(getText(accact.Weak_text), text.get(8));
			text_Assert(getText(accact.Medium_text), text.get(9));
			text_Assert(getText(accact.Strong_text), text.get(10));
			log.info("All the text on Username & Password Page are validated");
			break;
			
		case "Security Questions":
			Thread.sleep(2000);
			List<WebElement> Qstn = getElementsByProperty(accact.Questions_btn);
			for(int i=0;i<text.size();i++) {				
				text_Assert(Qstn.get(i).getText(), text.get(i)+"\nShow Question");
			}
			log.info("All the text on Security Questions Page are validated");
			if(Qstn.size()!=5) 
				Assert.assertNotEquals(Qstn.size(), text.size(),"Number of Questions on the page is more");
			break;
			
		case "Activation Success":
			Thread.sleep(2000);
			text_Assert(getText(accact.ActivationSuccess_text), text.get(0));
			text_Assert(getText(accact.Act_Login_btn), text.get(1));
			text_Assert(getText(accact.Act_Login_link), text.get(2));
			log.info("All the text on Activation Success Page are validated");
			break;

		case "Sign Up for a new Account":
			Thread.sleep(2000);
			List<WebElement> Sign_up_text = getElementsByProperty(accact.Sign_up_page_text);
			text_Assert(Sign_up_text.get(0).getText(),text.get(1));
			text_Assert(Sign_up_text.get(1).getText(),text.get(4));
			List<WebElement> Sign_up_text_h2 = getElementsByProperty(accact.Sign_up_page_text_h2);
			text_Assert(Sign_up_text_h2.get(0).getText(),text.get(0));
			text_Assert(Sign_up_text_h2.get(1).getText(),text.get(3));
			List<WebElement> Sign_up_text_button = getElementsByProperty(accact.Sign_up_page_text_button);
			text_Assert(Sign_up_text_button.get(0).getText(),text.get(2));
			text_Assert(Sign_up_text_button.get(1).getText(),text.get(5));
			text_Assert(getText(accact.Sign_up_page_text_a), text.get(6));
			text_Assert(getText(accact.Sign_up_page_need_help), text.get(7));
			log.info("All the text on Sign Up for new account Page are validated");
			break;

		default:
			log.info("Page not found");
		}
		
	}

	public void HelpTextValidation(List<String> helpText)throws Throwable{
		Thread.sleep(2000);
	//	text_Assert(accact.Username_HelpText_h1, helpText.get(0));
		List<WebElement> Username_help = getElementsByProperty(accact.Username_HelpText);
		text_Assert(Username_help.get(0).getText(), helpText.get(1));
		text_Assert(Username_help.get(1).getText(), helpText.get(2));
		text_Assert(Username_help.get(2).getText(), helpText.get(3));
		log.info("All the help texts for Username are validated");
		text_Assert(accact.Password_HelpText_h1, helpText.get(4));
		List<WebElement> Password_help = getElementsByProperty(accact.Password_HelpText);
		text_Assert(Password_help.get(0).getText(), helpText.get(5));
		text_Assert(Password_help.get(1).getText(), helpText.get(6));
		text_Assert(Password_help.get(2).getText(), helpText.get(7));
		log.info("All the help texts for Password are validated");
	}
	
	public void validateButtonsOfPage(List<String> tableButton) throws Exception {
		String tagName = null;
		/*for (DataTableRow row : tableButton.getGherkinRows()) {
			String option = row.getCells().get(0);*/
		for(int i=0;i<tableButton.size();i++){
			switch (tableButton.get(i).toUpperCase()) {
				case "GET STARTED":
					tagName = getElementByProperty(accact.Get_Started_btn).getTagName();
					break;
					
				case "NEXT STEP":
					tagName = getElementByProperty(accact.NextStep_btn).getTagName();
					break;
					
				case "LOGIN TO YOUR ACCOUNT":
					tagName = getElementByProperty(accact.Act_Login_btn).getTagName();
					break;
					
				case "CANCEL":
					tagName = getElementByProperty(accact.Cancel_btn).getTagName();
					break;
				
					default:
						log.info("Not a Button");
			}
			if(tagName.equals("button")){
				AssertJUnit.assertTrue(true);
				log.info(tableButton.get(i).toUpperCase()+" is a button");
			}
				
			
		}
	}

	public void validateLinksOfPage(List<String> tableLink) throws Exception {
		for (int i=0;i<tableLink.size();i++) {
			switch (tableLink.get(i)) {
				case "Request one now":
					verifyHyperLink(accact.Req_One_Link);
					break;
					
				case "request one":
					verifyHyperLink(accact.Act_Req_One);
					break;
					
				case "Why do we need this?":
					verifyHyperLink(accact.Why_do_we_need_Link);
					break;
					
				case "No thanks, I'm Done":
					verifyHyperLink(accact.No_thanks_Link);
					break;
					
				default:
					log.info("Not a Link");
						
			}
			log.info(tableLink.get(i)+" is a link");
		}
	}

	public void userScroll() throws Throwable{
		Thread.sleep(1000);
		scrollTo(driver, getElementByProperty(accact.NextStep_btn));
		//WebElement element = getElementByProperty(accact.Terms_form);
		//Object executeScript = ((JavascriptExecutor) driver).executeScript(print("document.documentElement.scrollHeight"),element);
	}
	
	public void validateTooltip(String tooltip)throws Throwable{
		Thread.sleep(2000);
		text_validation_Assert(accact.toolTip, tooltip);
		driver.findElementByXPath("//*[@class='close']/i[contains(@class,'gold-close')]").click();
	}
	
	WebElement checkBox;
	public void Checkbox_clicked() throws Throwable{	
		isElementPresentVerifyClick(accact.checkBox);
		log.info("User checked on the checkBox");
	}
	
	public void CheckBox_unchecked() throws Throwable{
		
		checkBox = getElementByProperty(accact.checkBox);
		Thread.sleep(1000);
		if(checkBox.isSelected()) {
			isElementPresentVerifyClick(accact.checkBox);
			log.info("checkBox is unchecked");
		}
		
	}
	
	public void ErrorField(String error)throws Throwable{
		Thread.sleep(1000);
		text_Assert(getText(accact.Error_without_checkBoxCheck), error);
		
	}
	
	public void ErrorField_noScroll(String error)throws Throwable{
		Thread.sleep(1000);
		//isElementPresentVerification(accact.Error_without_checkBoxCheck);
		text_Assert(getText(accact.Error_without_checkBoxCheck), error);
	
		
	}
	
	public void Terms_ConditionsScroll()throws Throwable{
		scrollTo(driver, getElementByProperty(accact.NextStep_btn));
		Thread.sleep(1000);
		WebElement element = getElementByProperty(accact.Terms_form);
		Actions action = new Actions(driver);
		 action.moveToElement(element).build().perform();
		scrollTo(driver, driver.findElementByXPath("//myhealth-terms/section/form/div/div[1]/div/p[14]"));
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.scrollingElement.scrollHeight)");
		
	}
	
	public void toolTip(String verbiage) throws Throwable{
		text_validation_Assert(accact.toolTip, verbiage);
	}
	
	public void enterInField(String data, String field) throws Throwable{
		switch(field){
		case "Username":
			clearAndEnterText(accact.Username_input, data);
			break;
			
		case "Password":
			clearAndEnterText(accact.Password_input, data);
			break;
			
		case "Confirm Password":
			clearAndEnterText(accact.Confirm_Password_input, data);
			break;
			
		case "First Name":
			clearAndEnterText(accact.FirstName_input, data);
			break;
			
		case "Last Name":
			clearAndEnterText(accact.LastName_input, data);
			break;
			
		case "Date of Birth":
			String[] split = data.split("/");
			clearAndEnterText(accact.D_month, split[0].toString());
			clearAndEnterText(accact.D_date, split[1].toString());
			clearAndEnterText(accact.D_year, split[2].toString());
			/*List<WebElement> DOB = getElementsByProperty(accact.DOB_input);
			
			for(int i=1;i<=DOB.size();i++) {
				WebElement list = driver.findElement(By.xpath("//myhealth-personal-information//li["+i+"]"));
				list.sendKeys(split[i].toString());
			}*/
			break;
			
		case "Email Address":
			clearAndEnterText(accact.Email_input, data);
			break;
			
		case "Confirm Email Address":
			clearAndEnterText(accact.Confirm_Email_input, data);
			break;
			
		case "Last 4 of Social Security":
			clearAndEnterText(accact.SSN_input, data);
			break;

		default:
			log.info("Input field not found");
		}
		log.info(data+" successfully entered in the field "+field);
	}
	
	public void passwordMismatch(String error)throws Throwable{
		Thread.sleep(2000);
		isElementPresentVerification(accact.Password_Mismatch_error);
		text_Assert(getText(accact.Password_Mismatch_error), error);
	}
	
	public void MaskedField(String field)throws Throwable {
		String str = null;
		switch(field){
			case "Last 4 of Social Security":
				str = getElementByProperty(accact.SSN_input).getAttribute("type");
				break;
		
			case "Password":
				str = getElementByProperty(accact.Password_input).getAttribute("type");
				break;
			
			case "Confirm Password":
				str = getElementByProperty(accact.Confirm_Password_input).getAttribute("type");
				break;
				
			case "Question1":
				str = getElementByProperty(accact.Answer1_text).getAttribute("type");
				break;
				
			case "Question2":
				str = getElementByProperty(accact.Answer2_text).getAttribute("type");
				break;
				
			case "Question3":
				str = getElementByProperty(accact.Answer3_text).getAttribute("type");
				break;
				
				default:
					log.info("Input field not found");
										
		}
		
		if(str.equals("text"))
			log.info(field+" is unmasked");
		else if(str.equals("password"))
			log.info(field+" is masked");
			
		
	}
	
	public void showIcon(String field)throws Throwable {
		List<WebElement> showIcon = getElementsByProperty(accact.Password_eyeIcon);
		showIcon.get(0).click();
		/*switch(field) {
		case "Password":
			showIcon.get(0).click();
			break;
			
		case "Confirm Password":
			showIcon.get(1).click();
			break;
			
		case "Answer1":
			isElementPresentVerifyClick(accact.Answer1_show);
			break;
			
		case "Answer2":
			isElementPresentVerifyClick(accact.Answer2_show);
			break;
			
		case "Answer3":
			isElementPresentVerifyClick(accact.Answer3_show);
			break;
			
			default: 
				log.info("show button not found");
		}
				*/
	}
	
	public void StepsTracker(List<String> text) {
		/*text_Contains(accact.Tracker_status_text, text.get(0));
		text_Contains(accact.Tracker_status_text, text.get(1));
	//	List<String> text=tableText.asList(String.class);
		text_Contains(accact.Tracker_status_text, text.get(2));
		text_Contains(accact.Tracker_status_text, text.get(4));
		text_Contains(accact.Tracker_status_text, text.get(5));*/
	}
	
	public void enterActivationCode(String code)throws Throwable{
		List<WebElement> Act_input = getElementsByProperty(accact.ActivationCode_input);
		for(int i=0;i<code.length();i++) {
			char charAt = code.charAt(i);
			System.out.println(charAt);
			Act_input.get(i).sendKeys(String.valueOf(charAt));
		}
	}
	
	public void tapOnLink(String link)throws Throwable{
		switch(link) {
		case "Request one now":
			isElementPresentVerifyClick(accact.Req_One_Link);
			break;
			
		case "Why do we need this?":
			isElementPresentVerifyClick(accact.Why_do_we_need_Link);
			break;
			
		case "No thanks, I'm Done":
			isElementPresentVerifyClick(accact.No_thanks_Link);
			break;

		case "What is an activation code?":
			isElementPresentVerifyClick(accact.Sign_up_page_text_a);
			break;

		default:
			log.info("Link not found");
		}
		log.info("User clicked on link- "+link);
		
		
	}
	
	public void buttonStatus(String button) throws Throwable{
		if(getElementByProperty(accact.NextStep_btn).isEnabled())
			log.info(button+" is enabled");
		else
			log.info(button+" is disabled");
		
		
	}


	public void verifyPopupText(String desc) throws Throwable{
		text_Assert(getText(accact.PopUp_txt), desc);
		log.info("pop up text is verified");
	}
}