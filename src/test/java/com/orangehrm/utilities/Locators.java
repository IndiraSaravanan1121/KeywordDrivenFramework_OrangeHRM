package com.orangehrm.utilities;

import org.openqa.selenium.By;

public class Locators {

	/**
	 * This Method returns id attribute along with value
	 * @param locatorValue
	 * @return
	 */
	public static By getId(String locatorValue) {
		return By.id(locatorValue);
	}

	/**
	 * This Method returns name attribute along with value
	 * @param locatorValue
	 * @return
	 */
	public static By getName(String locatorValue) {
		return By.name(locatorValue);
	}
	
	/**
	 * This Method returns xpath attribute along with value
	 * @param locatorValue
	 * @return
	 */
	public static By getXpath(String locatorValue) {
		return By.xpath(locatorValue);
	}
	
	/**
	 * This Method returns classname attribute along with value
	 * @param locatorValue
	 * @return
	 */
	public static By getClassName(String locatorValue) {
		return By.className(locatorValue);
	}
}
