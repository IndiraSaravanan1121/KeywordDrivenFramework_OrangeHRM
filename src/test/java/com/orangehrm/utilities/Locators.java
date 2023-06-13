package com.orangehrm.utilities;

import org.openqa.selenium.By;

public class Locators {

	public By getId(String locatorValue) {
		return By.id(locatorValue);
	}

	public By getName(String locatorValue) {
		return By.name(locatorValue);
	}
	
	public By getXpath(String locatorValue) {
		return By.xpath(locatorValue);
	}
	
	public By getClassName(String locatorValue) {
		return By.className(locatorValue);
	}

}
