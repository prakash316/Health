#@test1
Feature: Patient Login feature

    					##1.02.01 ACTIVATE MYCHART - Terms and Conditions##
  @CA-2778 @websmokeTest
  Scenario: ACT_TC_01-Verify whether the user is navigated to "Sign Up for a new Account" page when tapped on "Sign Up" button from Home page 
  Given User is on "Home" page
  When User taps on "Sign Up" button
  Then User should be navigated to "Sign Up for a New Account" page

  @CA-1541 @websmokeTest
  Scenario: ACT_TC_06-Verify whether the user is able to see the texts present on "Sign Up for a new Account" page
    Given User is on "Sign Up for a New Account" page
    And User should see the below texts on "Sign Up for a new Account" page
    | Activate My Account                                       |
    | I have an activation code and ready to create my account. |
    | CONTINUE SIGN UP                                          |
    | Request Activation Code                                   |
    | I need an activation code so I can create my account.     |
    | REQUEST ACTIVATION CODE                                   |
    | What is an activation code?                               |
    | Need Help?                                                |

  @CA-2882 @websmokeTest
  Scenario: ACT_TC_06-Verify whether the user is able to see a pop-up when tapped on "What is an activation code?" link from "Sign Up for a new account" page
    Given User is on "Sign Up for a New Account" page
    When User taps on "What is an activation code?" link
    Then User should see pop-up with description "test2 Portal activation code is a unique code created for each individual to activate their account. It consists of a combination of characters and numbers separated by hyphens. This code is essential in order to activate your product. Example ABCD-EF123-GH4TF"


  @CA-2779 @websmokeTest
  Scenario: ACT_TC_06-Verify whether the user is able to see "Welcome to Activation Setup!" page when tapped on "Continue Sign Up" button from "Sign Up for a New Account" page
  Given User is on "Sign Up for a New Account" page
  When User taps on "CONTINUE SIGN UP" button
  Then User should be navigated to "Welcome to Activation Setup!" page

  @CA-2780 @websmokeTest
  Scenario: ACT_TC_07-Verify whether the user is able to see the contents of "Welcome to Activation Setup!" page
  Given User is on "Welcome to Activation Setup!" page
  And User should see the below texts on "Welcome to Activation Setup!" page
	| We’ll take you through 5 steps to activate your account. You will need your activation code in order to activate your account. |
	| Need an activation code? Request one now |
	| GET STARTED |
	| CANCEL |
  And User should see the below buttons
	| GET STARTED |
	| CANCEL |
  And User should see the below links
	| Request one now |

  @CA-2781 @websmokeTest
  Scenario: ACT_TC_10-Verify whether the user is navigated to "Terms and Conditions" page when tapped on "Get Started" button from "Welcome to Activation Setup" page
  Given User is on "Welcome to Activation Setup!" page
  When User taps on "GET STARTED" button
  Then User should be navigated to "Terms and Conditions" page

  @CA-2782 @websmokeTest
  Scenario: ACT_TC_12-Verify whether the user is able to see error message when checked on the checkbox without scrolling down till the complete "Terms & Conditions" page
  Given User is on "Terms and conditions" page
  And User has NOT scrolled down till the complete Terms & Conditions
  When User Checks on the checkbox
  Then User should see an error as "Please review the Terms and Conditions, you must accept to continue." when not scrolled down

  @CA-2783 @websmokeTest
  Scenario: ACT_TC_13-Verify whether the user is able to see an error message when tapped on "NEXT STEP" button without checking on the checkbox
  Given User is on "Terms and conditions" page
  And User should see the checkbox as unchecked
  When User taps on "NEXT STEP" button
  Then User should see an error as "You must agree to the terms and conditions before you can enroll."

  @CA-2887 @websmokeTest
  Scenario: ACT_TC_15-Verify whether the user is able to navigate to "Activate Code" page without any error upon tapping on "NEXT STEP" button
  Given User is on "Terms and conditions" page
  When User scrolls down till the end of Terms & Conditions
  And User Checks on the checkbox
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Activation Code"

  @CA-2784 @websmokeTest
  Scenario: ACT_TC_16-Verify whether the user is able to see the contents of "Activation Code" page
  Given User is on "Activation Code" page
  And User should see the below texts on "Activation Code" page
	| Enter one-time use Activation Code you received. |
	| 15 Digit Activation Code |
	| Don't have an Activation Code? You can request one. |
	| NEXT STEP |
	| CANCEL |
  And User should see the below links
	| request one |
  And User should see the below buttons
	| NEXT STEP |
	| CANCEL |

  @CA-2785 @websmokeTest
  Scenario: ACT_TC_22-Verify whether the user is able to navigate to "Personal Information" screen after entering a valid Activation Code and tapping on "NEXT STEP" button
  Given User is on "Activation Code" page
  #valid
  When User enters "111112222233333" activation code
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Personal Information" page

  @CA-2786 @websmokeTest
  Scenario: ACT_TC_23-Verify whether the user is able to see the contents of "Personal Information" page
  Given User is on "Personal Information" page
  And User should see the below texts on "Personal Information" page
	| To create your test2 account and provide access to your personal health information, we need to verify your identity. |
	| First Name |
	| Last Name |
	| Date of Birth |
	| Email Address |
	| Confirm Email Address |
	| Last 4 of Social Security # |
	| Why do we need this? |
	| NEXT STEP |
	| CANCEL |
  And User should see the below links
	| Why do we need this? |
  And User should see the below buttons
	| NEXT STEP |
	| CANCEL |

  @CA-2787 @websmokeTest
  Scenario: ACT_TC_24-Verify whether the user is able to see the tooltip when tapped on the link- "Why do we need this?"
  Given User is on "Personal Information" page
  When User taps on "Why do we need this?" link
  Then User should see a tooltip with verbiage- "To create your test2 account and provide access to your personal health information, we need to verify your identity."

  @CA-2788 @websmokeTest
  Scenario: ACT_TC_35-Verify whether user is navigated to "Username & Password" screen after entering valid data and tapping on "NEXT STEP" button
  Given User is on "Personal Information" page
  When User enters "FNAME" in "First Name" field
  And User enters "LNAME" in "Last Name" field
  And User enters "01/01/2000" in "Date of Birth" field
  And User enters "abc@gmail.com" in "Email Address" field
  And User enters "abc@gmail.com" in "Confirm Email Address" field
  And User enters "1234" in "Last 4 of Social Security" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Username & Password" page

  @CA-2789 @websmokeTest
  Scenario: ACT_TC_36-Verify whether the user is able to see the contents of "Username & Password" page
  Given User is on "Username & Password" page
  And User should see the below texts on "Username & Password" page
	| Create your Username & Password |
	| Create your username, password and security info. |
	| Username |
	| Password |
	| Confirm Password |
	| NEXT STEP |
	| CANCEL |
	| Password Strength: |
	| Weak |
	| Medium |
	| Strong (Recommended) |
  And User should see the help text
	| Username |
	| 5 - 20 characters in length |
	| Must begin with a letter |
	| Valid: letters (a-z), numbers (0-9) and underscore (_) |
	| Password |
	| 8 - 64 characters in length |
	| Cannot be a common term |
	| Cannot be same as Login ID |


  @CA-2792 @websmokeTest_NotRequired
  Scenario: ACT_TC_48-Verify whether the user is able to see an error message for MISMATCH in "Password" and "Confirm Password" field
  Given User is on "Username & Password" page
  When User enters "Username" in "Username" field
  And User enters "a@!B1cdQWs2" in "Password" field
  When User taps on show icon in "Password" field
  Then User should see unmasked value in "Password" field
  And User enters "aaaaaaaaaa" in "Confirm Password" field
  Then User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should see an error as "Password and Confirmed Password does not match!" for password mismatch

  @CA-2793 @websmokeTest
  Scenario: ACT_TC_50-Verify whether user is navigated to "Security Questions" screen after entering valid data and tapping on "NEXT STEP" button
  Given User is on "Username & Password" page
  When User enters "uname" in "Username" field
  And User enters "a@!B1cdQWs2" in "Password" field
  #And User should see green check mark
  And User taps on show icon in "Password" field
  Then User should see unmasked value in "Password" field
  When User enters "a@!B1cdQWs2" in "Confirm Password" field
  #And User taps on show icon in "Confirm Password" field
  #Then User should see "a@!B1cdQWs2" in "Confirm Password" field
  And User should see "NEXT STEP" button enabled
  When User taps on "NEXT STEP" button
  Then User should be navigated to "Security Questions" page

  @CA-2794 @websmokeTest
  Scenario: ACT_TC_51-Verify whether the user is able to see the contents of "Security Questions" page
  Given User is on "Security Questions" page
  And User should see the below texts on "Security Questions" page
	| What was the last name of your first grade teacher? |
	| What was the model of your first car? |
	| Who was your childhood hero? |
	| What was your home street name when you were in second grade? |
	| What was the last name of your third grade teacher? |


  @CA-2795 @websmokeTest
  Scenario: ACT_TC_58-Verify whether user is navigated to "Activation Success" screen after entering valid data and tapping on "COMPLETE YOUR ACCOUNT" button
  Given User is on "Security Questions" page
  When User taps on "Question1" button
  And User enters "Answer1" for "Question1"
  When User taps on "Question2" button
  And User enters "Answer2" for "Question2"
  When User taps on "Question3" button
  And User enters "Answer3" for "Question3"
  When User taps on "FINISH" button
  Then User should be navigated to "Activation Success" page

  @CA-2796 @websmokeTest
  Scenario: ACT_TC_59-Verify whether the user is able to see the contents of "Activation Success" page
  Given User is on "Activation Success" page
  And User should see the below texts on "Activation Success" page
	| Success! Your account setup is now complete! |
	| LOGIN TO YOUR ACCOUNT |
	| No thanks, I’m Done |
  And User should see the below buttons
	| LOGIN TO YOUR ACCOUNT |
  And User should see the below links
	| No thanks, I’m Done |
	