package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginOrangeHrm {
	
	WebDriver driver;
	
	/**
	 * This Method is to open chrome browser
	 */
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method is to launch orangehrm website url
	 * @throws Exception
	 */
	public void goToURL() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	/**
	 * This Method is to enter username
	 */
	public void enterUsername() {
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
	}
	
	/**
	 * This Method is to enter password
	 */
	public void enterPassword() {
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
	}
	
	/**
	 * This Method is to click login button
	 */
	public void clickLoginButton() throws Exception {
		WebElement loginBtn = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		loginBtn.click();
	}
	
	/**
	 * This Method is to close the browser
	 * @throws Exception
	 */
	public void closeBrowser() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
