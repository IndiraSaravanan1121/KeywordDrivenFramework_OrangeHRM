package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.orangehrm.constants.Constants;
import com.orangehrm.utilities.ExcelReader;
import com.orangehrm.utilities.KeywordDriven;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOrangeHrm {
	
	WebDriver driver;
	
	/**
	 * This Method is to open chrome browser
	 */
	public void openBrowser() {
		
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
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method is to launch orangehrm website url
	 * @throws Exception
	 */
	public void goToURL() {
		driver.get(ExcelReader.dataColumnName);
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
	}
	
	/**
	 * This Method is to click login button
	 */
	public void click() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement clickBtn = driver.findElement(KeywordDriven.findLocators());
		clickBtn.click();
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
	}
}
