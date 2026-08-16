#@test1
Feature: Patient Login feature

    					##1.02.01 ACTIVATE MYCHART - Terms and Conditions##
  #@CA-281
  Scenario: ACT_TC_01-Verify whether the user is navigated to "Sign Up for a new Account" page when tapped on "Sign Up" button from Home page 
  Given User is on "Home" page
  And User taps on "Sign Up" button
  Then User should be navigated to "Sign Up for a New Account" page
  
  Scenario: ACT_TC_02-Verify whether the user is able to see the texts present on "Sign Up for a new Account" page 
  Given User is on "Sign Up for a New Account" page
  And User should see the below texts
	| Activate My Account |
	| I have an activation code and ready to create my account |
	| CONTINUE SIGN UP |
	| Request Activation Code |
	| I need an activation code so I can create my account |
	| REQUEST ACTIVATION CODE |
	| What is an activation code? |
	| Need Help? |
  
  Scenario: ACT_TC_03-Verify whether the user is able to see the links and buttons present on "Sign Up for a new Account" page 
  Given User is on "Sign Up for a New Account" page
  And User should see the below as buttons
	| CONTINUE SIGN UP |
	| REQUEST ACTIVATION CODE |
  And User should see the below as link-
	| What is an activation code? |
	| Need Help? |
	
  Scenario: ACT_TC_04-Verify whether the user is navigated to "MyChart" screen when tapped on "Request Activation Code" button of "Sign Up for a new Account" 
  Given User is on "Sign Up for a New Account" page
  When User taps on "Request Activation Code" button
  Then User should be navigated to "MyChart" page
  And User should see "MyChart" page opened in a new tab
  
  Scenario: ACT_TC_05-Verify whether the user is able to see a pop-up when tapped on "What is an activation code?" link from "Sign Up for a new account" page 
  Given User is on "MyChart" page
  When User taps on browser back button
  Then User should be navigated to "Sign Up for a new Account" page
  When User taps on "What is an activation code?" link
  Then User should see a pop-up with description
  When User taps on "OK" button in the popup
  Then User should be landed on "Sign Up for a new Account" page
  
  Scenario: ACT_TC_06-Verify whether the user is able to see "Welcome to Activation Setup" page when tapped on "Continue Sign Up" button from "Sign Up for a New Account" page 
  Given User is on "Sign Up for a New Account" page
  When User taps on "Continue Sign Up" button
  Then User should be navigated to "Welcome to Activation Setup" page
  
  Scenario: ACT_TC_07-Verify whether the user is able to see the contents of "Welcome to Activation Setup" page 
  Given User is on "Welcome to Activation Setup" page
  And User should see the below texts
	| Welcome to Activation Setup |
	| We�ll take you through 5 steps to activate your account |
	| You will need your activation code in order to activate your account |
	| Need an activation code? Request one now |
	| GET STARTED |
	| CANCEL |
  And User should see the below buttons
	| GET STARTED |
	| CANCEL |
  And User should see the below link
	| Request one now |
	
  Scenario: ACT_TC_08-Verify whether the user is navigated to "MyChart" screen when tapped on "Request one now" button of "Welcome to Activation Setup" page 
  Given User is on "Welcome to Activation Setup" page
  When User taps on "Request one now" link
  Then User should be navigated to "MyChart" page
  And User should see "MyChart" page opened in a new tab
  
  Scenario: ACT_TC_09-Verify whether the user is able to see the pop-up when tapped on "CANCEL" button from "Welcome to Activation Setup" page 
  Given User is on "MyChart" page
  When User taps on browser back button
  Then User should be navigated to "Welcome to Activation Setup" page
  When User taps on "CANCEL" button
  Then User should see a pop-up with the below text:
	| Are you sure you want to Cancel? |
	| Yes |
	| No |
  When User taps on "Yes" 
  Then User should be navigated to "Sign-Up or Activate" page
  When User taps on "No"
  Then User should be landed on "Welcome to Activation Setup" page
  
  Scenario: ACT_TC_10-Verify whether the user is navigated to "Terms and Conditions" page when tapped on "Get Started" button from "Welcome to Activation Setup" page 
  Given User is on "MyChart" page
  When User taps on "Get Started" button
  Then User should be navigated to "Terms and Conditions" page
  
  Scenario: ACT_TC_11-Verify whether the user is able to see the contents on "Terms and Conditions" page 
  Given User is on "Terms and conditions" page 
  And User should see the vertical scrollBar
  And User should see the details for Terms and Conditions 
  And User should see the text "Yes, I have read and agree to the Terms & Conditions"
  And User should see the below buttons
	| NEXT STEP |
	| CANCEL |
  And User should see the below link
	| Terms & Conditions |
	
  Scenario: ACT_TC_12-Verify whether the user is able to see error message when checked on the checkbox without scrolling down till the complete "Terms & Conditions" page 
  Given User is on "Terms and conditions" page 
  And User has NOT scrolled down till the complete Terms & Conditions
  When User Checks on the checkbox
  Then User should see an error
  
  Scenario: ACT_TC_13-Verify whether the user is able to see an error message when tapped on "NEXT STEP" button without checking on the checkbox 
  Given User is on "Terms and conditions" page
  And User should see the checkbox as unchecked
  When User taps on "NEXT STEP" button
  Then User should see an error as "Please agree to the terms and conditions to proceed."
  
  Scenario: ACT_TC_14-Verify whether the user is navigated to previous screen when tapped on "Cancel" button 
  Given User is on "Terms and conditions" page
  When User taps on "Cancel" button
  Then User should be navigated to previous page
  
  Scenario: ACT_TC_15-Verify whether the user is able to navigate to Step2 page without any error upon tapping on "NEXT STEP" button 
  Given User is on "Terms and conditions" page
  When User scrolls down till the end of Terms & Conditions
  And User Checks on the checkbox
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Activation Code"
  
  Scenario: ACT_TC_16-Verify whether the user is able to see the contents of "Activation Code" page 
  Given User is on "Activation Code" page
  And User should see the below steps tracker
	| "Terms & Conditions" verbiage with Step "1" FULL colored bubble |
	| "Activation code" verbiage with Step "2" OUTLINE colored bubble |
	| "Personal Information" verbiage with Step "3" NO colored bubble |
	| "Username & Password" verbiage with Step "4" NO colored bubble |
	| "Security Questions" verbiage with Step "5" NO colored bubble |
  And User should see the below texts:
	| Activation Code |
	| Enter one-time use Activation Code you received |
	| 15 Digit Activation Code |
	| Don't have an Activation Code? You can request one |
	| NEXT STEP |
	| CANCEL |
  And User should see the below link
	| Request one now |
  And User should see the below buttons
	| NEXT STEP |
	| CANCEL |
	
  Scenario: ACT_TC_17-Verify whether the user is able to see an error message for invalid activation code entered 
  Given User is on "Activation Code" page
  #invalid
  When User enters "11111-11111-11111" activation code 
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error message as "Please type a valid activation code"
  
  Scenario: ACT_TC_18-Verify whether the user is able to see an error message for expired activation code entered 
  Given User is on "Activation Code" page
  #expired
  When User enters "22222-22222-22222" activation code
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error message as "Your code has expired. To request a new code, go https://myhealth.test2.com� and request activation code"
   
  Scenario: ACT_TC_19-Verify whether the user is able to see the "NEXT STEP" button disabled for activation code less than 15 digits 
  Given User is on "Activation Code" page
  #less than 15 digits
  When User enters "22222-22" activation code 
  Then User should see "NEXT STEP" button disabled
  
  Scenario: ACT_TC_20-Verify whether the user is able to navigate to "MyChart Activation" screen after entering on "request one" link 
  Given User is on "Activation Code" page
  When User taps on "request one" link
  Then User should be navigated to "MyChart Activation" page
  
  Scenario: ACT_TC_21-Verify whether the user is able to see the pop-up when tapped on "CANCEL" button from "Activation Code" page 
  Given User is on "Activation Code" page
  When User taps on "Cancel" button
  Then User should see a popup with message
	| Are you sure you want to cancel your activation? |
	| Yes |
	| No |
  When User taps on "Yes"
  Then User should be navigated to "Home" page
  When User taps on "No"
  Then User should be landed on "Activation Code" page 
  
  Scenario: ACT_TC_22-Verify whether the user is able to navigate to "Personal Information" screen after entering a valid Activation Code and tapping on "NEXT STEP" button 
  Given User is on "Activation Code" page
  #valid
  When User enters "12345-12345-12345" activation code 
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Personal Information" page
  
  Scenario: ACT_TC_23-Verify whether the user is able to see the contents of "Personal Information" page 
  Given User is on "Personal Information" page
  And User should see the below steps tracker
	| "Terms & Conditions" verbiage with Step "1" FULL colored bubble |
	| "Activation code" verbiage with Step "2" FULL colored bubble |
	| "Personal Information" verbiage with Step "3" OUTLINE colored bubble |
	| "Username & Password" verbiage with Step "4" NO colored bubble |
	| "Security Questions" verbiage with Step "5" NO colored bubble |
  And User should see the below texts
	| Personal Information |
	| To create your test2 account and provide access to your personal health information, we need to verify your identity |
	| First Name: |
	| Last Name: |
	| Date of Birth: |
	| Email Address: |
	| Confirm Email Address: |
	| Last 4 of Social Security #: |
	| Why do we need this? |
	| NEXT STEP |
	| CANCEL |
  And User should see the below as link
	| Why do we need this? |
  And User should see the below as buttons
	| NEXT STEP |
	| CANCEL |
  
  Scenario: ACT_TC_24-Verify whether the user is able to see the tooltip when tapped on the link- "Why do we need this?" 
  Given User is on "Personal Information" page
  When User taps on "Why do we need this?" link
  Then User should see a tooltip with verbiage
  
  Scenario: ACT_TC_25-Verify whether the user is able to see "Date of Birth" error when entered with wrong format 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  #invalid DOB (DD/MM/YYYY)
  And User should enter "13/12/2017" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Date of Birth" field
  
  Scenario: ACT_TC_26-Verify whether the user is able to see "Date of Birth" error when entered with default/ current date 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  #Default/Current DOB
  And User should enter "Default date" in "Date of Birth" field
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Date of Birth" field	
  
  Scenario: ACT_TC_27-Verify whether the user is able to see "Date of Birth" error when entered with future date 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  #Future DOB
  And User should enter "Future date" in "Date of Birth" field
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Date of Birth" field
 
  Scenario: ACT_TC_28-Verify whether the user is able to see "Date of Birth" error when entered with 00/00/0000 (null) 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  #null DOB
  And User should enter "00/00/0000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Date of Birth" field
  
  Scenario: ACT_TC_29-Verify whether the user is able to see an error for entering wrong format in Email Address field 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  #invalid format in Email address field
  And User should enter "abc" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Email Address" field
  
  Scenario: ACT_TC_30-Verify whether the user is able to see an error for entering wrong format in Confirm email Address field 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field 
  #invalid format in Confirm Email Address
  And User should enter "abc" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for "Confirm Email Address" field
  
  Scenario: ACT_TC_31-Verify whether the user is able to see an error for mismatch in Email Address and Confirm Email Address field 
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  #mismatch in data in Email Address and Confirm Email Address
  And User should enter "xyz@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for mismatch in "Email Address" and "Confirm Email Address" field
  
  Scenario: ACT_TC_32-Verify whether the user is able to see an error for invalid SSN  
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  #invalid SSN
  And User should enter "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for invalid SSN field
  
  Scenario: ACT_TC_33-Verify whether the user is able to see an error for entering less than 4 digit SSN  
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  #less than 4 digit SSN
  And User should enter "12" in "Last 4 of Social Security" field 
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error for SSN field
  
  Scenario: ACT_TC_34-Verify whether the user is able to see the pop-up when tapped on "CANCEL" button from "Personal Information" page  
  Given User is on "Personal Information" page
  When User taps on browser back button
  Then User should be navigated to "Welcome to Activation Setup" page
  When User taps on "CANCEL" button
  Then User should see a pop-up with the below text:
	| Are you sure you want to Cancel? |
	| Yes |
	| No |
  When User taps on "Yes" 
  Then User should be navigated to "Home" page
  When User taps on "No"
  Then User should be landed on "Personal Information" page
  
  Scenario: ACT_TC_35-Verify whether user is navigated to "Username & Password" screen after entering valid data and tapping on "NEXT STEP" button  
  Given User is on "Personal Information" page
  When User should enter "FNAME" in "First Name" field
  And User should enter "LNAME" in "Last Name" field
  And User should enter "01/01/2000" in "Date of Birth" field 
  And User should enter "abc@gmail.com" in "Email Address" field
  And User should enter "abc@gmail.com" in "Confirm Email Address" field
  And User should enter "1234" in "Last 4 of Social Security" field 
  And User should see "****" (masked) value in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Username & Password" page
  
  Scenario: ACT_TC_36-Verify whether the user is able to see the contents of ""Username & Password"" page
  Given User is on "Username & Password" page
  And User should see the below steps tracker
	| "Terms & Conditions" verbiage with Step "1" FULL colored bubble |
	| "Activation code" verbiage with Step "2" FULL colored bubble |
	| "Personal Information" verbiage with Step "3" FULL colored bubble |
	| "Username & Password" verbiage with Step "4" OUTLINE colored bubble |
	| "Security Questions" verbiage with Step "5" NO colored bubble |
  And User should see the below texts
	| Create your Username & Password |
	| Create your username, password and security info |
	| Username: |
	| Password: |
	| Password Strength |
	| Weak |
	| Medium |
	| Strong (Recommended) |
	| Confirm Password |
	| NEXT STEP |
	| CANCEL |
  And User should see the help text
	| Username |
	| 5 - 20 characters in length |
	| Must begin with a letter |
	| Valid: letters (a-z), numbers (0-9) and underscore (_) |
	| Password |
	| 8 � 64 characters in length |
	| Cannot be a common term |
	| Cannot be same as Login ID |
	
  Scenario: ACT_TC_37-Verify whether the user is able to see an error message for username when entered with data "less than 5 characters"
  Given User is on "Username & Password" page