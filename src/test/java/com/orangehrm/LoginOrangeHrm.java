package com.orangehrm;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.Assert;

import com.orangehrm.constants.Constants;
import com.orangehrm.utilities.ExcelReader;
import com.orangehrm.utilities.KeywordDriven;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrangeHrm {
	
	WebDriver driver;
	Logger logger;
	
	/**
	 * This Method is to open chrome browser
	 */
	public void openBrowser() {
		
		logger =  LogManager.getLogger(this.getClass());
		
		switch(ExcelReader.dataColumnName) {
		case Constants.CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case Constants.EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		logger.info("Browser opened");
		driver.manage().window().maximize();
		logger.info("Maximized window");
	}
	
	/**
	 * This Method is to launch orangehrm website url
	 * @throws Exception
	 */
	public void goToURL() {
		driver.get(ExcelReader.dataColumnName);
		logger.info("url launched");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method is to enter username
	 */
	public void enterText() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement text = driver.findElement(KeywordDriven.findLocators());
		text.sendKeys(ExcelReader.dataColumnName);
		logger.info(ExcelReader.dataColumnName + " sendkeys is done");
	}
	
	/**
	 * This Method is to click login button
	 * @throws Exception 
	 */
	public void click() throws Exception {
		Thread.sleep(2000);
		WebElement clickBtn = driver.findElement(KeywordDriven.findLocators());
		clickBtn.click();
		Thread.sleep(2000);
		logger.info("Clicking is done");
	}
	
	/**
	 * This Method is to perform assertion
	 */
	public void validation() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualValue = driver.findElement(KeywordDriven.findLocators()).getText();
		Assert.assertEquals(actualValue, ExcelReader.dataColumnName);
		logger.info("Assertion is done");
	}
	
	/**
	 * This Method is to close the browser
	 * @throws Exception
	 */
	public void closeBrowser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
		logger.info("Browser closed");
	}
}
