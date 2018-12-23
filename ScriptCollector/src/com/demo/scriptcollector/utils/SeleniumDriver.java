package com.demo.scriptcollector.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author TAPU
 *
 */
public class SeleniumDriver {

	public static WebDriver driver;
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void setUpDriver(){
		System.setProperty(EnumUtils.chrmeDriver, EnumUtils.chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void IeDriver() {
		System.setProperty(EnumUtils.Iedriver, EnumUtils.IeDriverPath);
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}
	
	public static void closeDriver() {
		driver.close();
		driver.quit();
	}
}
