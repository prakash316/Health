#Author : Monaliza.K.L
@web
Feature: Home (Post Login)
	
	@CA-354 @SmokeTest
  Scenario Outline: Log_TC_001 Verify user is able to login using valid credentials
    Given user is on test2 web home page
    And user should be able to see Mytest2ID as input field
    And user should be able to see Password as input field    
    When user enters the "<test2 ID>" in Mytest2ID input field under Current User Login widget
    And user enters the "<Password>" in Password input field under Current User Login widget
    And user clicks on "Sign In" button
    Then user should be able to navigate to test2 home page as a logged in user
		Examples:
		| test2 ID | Password |
		| user1	     | test123  |
		| user2      | test321  |
		| user3      | test231  |
		| user4      | test4    |