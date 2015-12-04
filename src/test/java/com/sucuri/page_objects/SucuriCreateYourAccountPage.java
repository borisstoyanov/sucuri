package com.sucuri.page_objects;

import org.openqa.selenium.By;

import com.sucuri.browser.Browser;

import org.junit.Assert;

public class SucuriCreateYourAccountPage {
	/*
	 * A constructor that checks if the user is on the right page
	 */
	public SucuriCreateYourAccountPage(){
		Assert.assertTrue(isAtAccountCreatePage());
	}
	
	public boolean isAtAccountCreatePage() {
		return Browser.instance.getTitle().equalsIgnoreCase("Sucuri - Create Your Account");
	}
	
	/*
	 * A method that types email in the email field on the page
	 * 
	 * Usage: Simply call the method with an email string as argument
	 */
	public void enterEmail(String email) {
		Browser.instance.findElement(By.name("email1")).sendKeys(email);
	}

	
	/*
	 * A method that types pass in the pass field and the confirm pass field on the page
	 * 
	 * Usage: Simply call the method with a pass string as argument
	 */
	public void enterPass(String pass) {
		Browser.instance.findElement(By.name("passw1")).sendKeys(pass);
		Browser.instance.findElement(By.name("passw2")).sendKeys(pass);
	}

	/*
	 * A method that checks if user has already agreed with the terms, if not checks the chekbox, 
	 * so that the user can proceed to checkout
	 * 
	 * Usage: Simply call the method when on SucuriCreateYourAccountPage
	 */
	public void agreeTerms() {
		if (!Browser.instance.findElement(By.id("agree")).isSelected() )
		{
			Browser.instance.findElement(By.id("agree")).click();
		}
			
	}
	
	/*
	 * A method that clicks on the create account button
	 * 
	 * Usage: Simply call the method when on SucuriCreateYourAccountPage
	 * @returns SucuriCheckoutPage
	 */
	public SucuriCheckoutPage clickCreateAccount() {
		Browser.instance.findElement(By.name("Account")).click();
		return new SucuriCheckoutPage();
	}

}
