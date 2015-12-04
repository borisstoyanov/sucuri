package com.sucuri.bdd.steps_def;

import java.util.concurrent.TimeUnit;

import com.sucuri.browser.Browser;
import com.sucuri.page_objects.SucuriCheckoutPage;
import com.sucuri.page_objects.SucuriCreateYourAccountPage;
import com.sucuri.page_objects.SucuriSignupPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageTests {
	SucuriSignupPage signupPage;
	SucuriCheckoutPage checkoutPage;
	SucuriCreateYourAccountPage createAccountPage;

	@Before
	public void setUp() {
		Browser.init();
		Browser.instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Browser.instance.manage().window().maximize();
	}

	@Given("^I'm on the SignupPage$")
	public void im_on_the_signuppage() {
		signupPage = SucuriSignupPage.goTo();
	}

	@When("^I buy SucuriAntivirusSolution$")
	public void i_buy_SucuriAntivirusSolution() {
		createAccountPage = signupPage.buySucuryAntivirus();
	}

	@When("^I enter email:\"([^\"]*)\"$")
	public void i_enter_emailsomething(String email) {
		createAccountPage.enterEmail(email);
	}

	@When("^I select 3 websites$")
	public void i_select_3_websites() {
		i_select_websites_something("3");
	}

	@When("^I select websites: \"([^\"]*)\"$")
	public void i_select_websites_something(String numberOfSites) {
		signupPage.selectSites(numberOfSites);
	}

	@Then("^I should be at the CreateAccountPage$")
	public void i_should_be_at_the_createaccountpage() {
		createAccountPage.isAtAccountCreatePage();
	}

	@Then("^I shoud be on the checkout page$")
	public SucuriCheckoutPage i_shoud_be_on_the_checkout_page() {
		return new SucuriCheckoutPage();
	}

	@Then("^basic should be: \"([^\"]*)\"$")
	public void basic_should_besomething(String strArg1) {
		signupPage.verifyPrice("basic", strArg1);
	}

	@And("^I enter password:\"([^\"]*)\"$")
	public void i_enter_passwordsomething(String pass) {
		createAccountPage.enterPass(pass);
	}

	@And("^I agree with terms$")
	public void i_agree_with_terms() {
		createAccountPage.agreeTerms();
	}

	@And("^I click CreateAccount$")
	public void i_click_createaccount() {
		checkoutPage = createAccountPage.clickCreateAccount();
	}

	@And("^pro should be: \"([^\"]*)\"$")
	public void pro_should_be_something(String price) {
		signupPage.verifyPrice("active pro", price);
	}

	@And("^business: \"([^\"]*)\"$")
	public void business_something(String price) {
		signupPage.verifyPrice("business", price);
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}
