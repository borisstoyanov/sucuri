package com.sucuri.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.sucuri.browser.Browser;

public class SucuriCheckoutPage {
	/*
	 * A constructor that checks if the user is on the right page
	 */
	public SucuriCheckoutPage(){
		Assert.assertTrue(isAt());
	}

	public boolean isAt() {
		return Browser.instance.findElement(By.xpath("//h1[text()='Checkout']")).isDisplayed();
	}

}
