package com.test.test2.StepDefinition;

import java.util.List;
import com.test.test2.StepLibrary.AccountActivationTestStepLibrary;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AccountActivationTestSteps extends AccountActivationTestStepLibrary {


    @And("^User taps on \"([^\"]*)\" button$")
    public void userTapsOnButton(String button) throws Exception {
        clickOnButton(button);
    }


    @Then("^User should be navigated to \"([^\"]*)\" page$")
    public void userShouldBeNavigatedToPage(String page) throws Exception {
    	validateUserOnPage(page);
    }

    @Given("^User is on \"([^\"]*)\" page$")
    public void userIsOnThePage(String page) throws Exception {
        validateUserOnPage(page);
    }

    @Given("^User should see the below texts on \"([^\"]*)\" page$")
    public void user_should_see_the_below_texts_on_page(String page, List<String> text) throws Throwable {
        validateContentsOfPage(page,text);
    }

    @And("^User should see the help text$")
    public void User_should_see_the_help_text(List<String> helpText)throws Throwable {
    	HelpTextValidation(helpText);
    }
    
    @And("^User should see the checkbox as unchecked$")
    public void User_should_see_the_checkbox_as_unchecked()throws Throwable {
    	CheckBox_unchecked();
    }

    @And("^User should see the below buttons$")
    public void userShouldSeeTheBelowButtons(List<String> tableButtons) throws Exception {
        validateButtonsOfPage(tableButtons);

    }

    @And("^User should see the below links$")
    public void userShouldSeeTheLink(List<String> tableLink) throws Exception {
        validateLinksOfPage(tableLink);
    }

    @And("^User should see a tooltip with verbiage- \"([^\"]*)\"$")
    public void userShouldSeeATooltip(String tooltip) throws Throwable {
        validateTooltip(tooltip);
    }
    
    @And("^User has NOT scrolled down till the complete Terms & Conditions$")
    public void userHasNOTScrolledDownTillTheCompleteTermsConditions() throws Throwable {
    	userScroll();
    }

    @When("^User Checks on the checkbox$")
    public void userChecksOnTheCheckbox() throws Throwable {
    	Checkbox_clicked();
    }

    @Then("^User should see an error$")
    public void userShouldSeeAnError() throws Throwable {

    }

   /* @And("^User sees the checkbox as unchecked$")
    public void userShouldSeeTheCheckboxAsUnchecked() throws Throwable {
    	CheckBox_status();
    }*/

    @Then("^User should see an error as \"([^\"]*)\" when not scrolled down$")
    public void userShouldSeeAnErrorForNoScroll(String error) throws Throwable {
    	ErrorField_noScroll(error);
    }
    
    @Then("^User should see an error as \"([^\"]*)\"$")
    public void userShouldSeeAnErrorAs(String error) throws Throwable {
    	ErrorField(error);
    }

    @When("^User scrolls down till the end of Terms & Conditions$")
    public void userScrollsDownTillTheEndOfTermsConditions() throws Throwable {
    	Terms_ConditionsScroll();
    }

    @Then("^User should be navigated to \"([^\"]*)\"$")
    public void userShouldBeNavigatedTo(String arg0) throws Throwable {

    }

    @When("^User enters \"([^\"]*)\" activation code$")
    public void userEntersActivationCode(String code) throws Throwable {
    	enterActivationCode(code);
    }
    
    @When("^User enters \"([^\"]*)\" for \"([^\"]*)\"$")
    public void userEnterAnswers(String Answer, String Question) throws Throwable {
    	userAnswers(Answer, Question);
    }

    @Then("^User should see \"([^\"]*)\" button enabled$")
    public void userShouldSeeButtonEnabled(String button) throws Throwable {
    	buttonStatus(button);
    }

    @Then("^User should see an error message as \"([^\"]*)\"$")
    public void userShouldSeeAnErrorMessageAs(String arg0) throws Throwable {

    }

    @And("^User should see the below steps tracker$")
    public void userShouldSeeTheBelowStepsTracker(List<String> tracker) throws Throwable {
    	StepsTracker(tracker);
    }

    @When("^User taps on \"([^\"]*)\" link$")
    public void userTapsOnLink(String Link) throws Throwable {
    	tapOnLink(Link);
    }

    @Then("^User should see a tooltip with verbiage \"([^\"]*)\"$")
    public void userShouldSeeATooltipWithVerbiage(String verbiage) throws Throwable {
    	toolTip(verbiage);
    }

    @When("^User enters \"([^\"]*)\" in \"([^\"]*)\" field$")
    public void userShouldEnterInField(String data, String field) throws Throwable {
    	enterInField(data,field);
    }
    
    @And("^User taps on show icon in \"([^\"]*)\" field$")
    public void userTapsOnShowIcon(String field) throws Throwable {
    	showIcon(field);
    }
    
    @Then("^User should see unmasked value in \"([^\"]*)\" field$")
    public void userShouldSeeMaskedValue(String field) throws Throwable {
    	MaskedField(field);
    }

    @Then("^User should see an error as \"([^\"]*)\" for password mismatch$")
    public void passwordMismatchError(String error)throws Throwable {
    	passwordMismatch(error);
    }

    @Then("^User should see pop-up with description \"([^\"]*)\"$")
    public void userShouldSeePopUpWithDescription(String desc) throws Throwable {
        verifyPopupText(desc);

    }
}
