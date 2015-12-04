package com.sucuri.page_objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sucuri.browser.Browser;

public class SucuriSignupPage {

	/*
	 * A static method which opens the Sucury Signup page and verifies the title
	 * is as expected You can either call this method without a reference or use
	 * it to assign reference to the signup page for later usage
	 * 
	 * @return SucuriSignupPage
	 */
	public static SucuriSignupPage goTo() {
		Browser.instance.get("https://sucuri.net/website-antivirus/signup");
		Assert.assertTrue(isAt());
		return new SucuriSignupPage();
	}

	private static boolean isAt() {
		return Browser.instance.getTitle().equalsIgnoreCase(
				"Sucuri: Antivirus Signup | Malware Removal, Detection and Protection | WAF | Website Firewall | Complete Website Security");
	}

	/*
	 * This method clicks on the Buy Sucuri Antivirus button at the end of the page
	 * @returns SucuriCreateYourAccountPage
	 */
	public SucuriCreateYourAccountPage buySucuryAntivirus() {
		JavascriptExecutor jse = (JavascriptExecutor) Browser.instance;
		jse.executeScript("window.scrollBy(0,250)", "");
		Browser.instance.findElement(By.xpath("//a[@class='btn buy mp-bundle']")).click();

		return new SucuriCreateYourAccountPage();	
	}

	/*
	 * A public method that selects sites by given number
	 * Usage: call the method with a string for example "5" and it will select 5 sites from the dropdown
	 */
	public void selectSites(String numberOfSites) {
		Browser.instance.findElement(By.className("price-select")).click();
		new WebDriverWait(Browser.instance, 10).until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[@id='pricing-options-av']//li[@data-value='" + numberOfSites + "']")));
		Browser.instance
				.findElement(By.xpath("//ul[@id='pricing-options-av']//li[@data-value='" + numberOfSites + "']"))
				.click();
	}

	/*
	 * A method that verifies price changes by previously selected number of sites. 
	 * Usage: In order to use it 1st you need to know what will the price change to
	 * 2nd you need to css class of the plan for example: "basic", "active pro" or "business" 
	 * 
	 *Usage: You can simple call this method by passing this 2 arguments
	 */
	public void verifyPrice(String container, String price) {
		Assert.assertTrue(Browser.instance
				.findElement(By.xpath("//li[@class='" + container + "']//span[text()='" + price + "']")).isDisplayed());

	}

}
