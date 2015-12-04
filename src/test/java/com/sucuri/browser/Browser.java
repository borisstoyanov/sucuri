package com.sucuri.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser {
	/*
	 * A static reference of the instance. 
	 * 
	 * Usage: it should be directly called like: Browser.instance...
	 */
	public static WebDriver instance;

	/*
	 * A public method that initiates a Firefox browser
	 * 
	 * Usage: Usually used in the setUp() method of a test. 
	 * Simply call the method and the browser will be instantiated
	 */
	public static void init() {
		instance = new FirefoxDriver();
	}

	/*
	 * A public method that kills the browser
	 */
	public static void quit() {
		instance.quit();
	}
}
