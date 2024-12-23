package com.epm.test;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.GoogleCloudPage;

public class SeleniumGridGCPTest {
	
	WebDriver driver;
	
//	@BeforeClass
//	public void setUp() {
//		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		options.setAcceptInsecureCerts(true);
//		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//		
////		DesiredCapabilities capabilities = new DesiredCapabilities();
////		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
////		options.merge(capabilities);
//		
//		driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://cloud.google.com/?hl=en");
//	}
	
	@BeforeClass
	public void setUpFirefox() {
		FirefoxOptions opt = new FirefoxOptions();
		opt.addArguments("--incognito");
		opt.setAcceptInsecureCerts(true);
		opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, opt);
//		opt.merge(cap);
		
		driver = new FirefoxDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://cloud.google.com/?hl=en");
	}
	
	@Test
	public void verifySearchButtonPresence() {
		GoogleCloudPage googleCloudPage = new GoogleCloudPage(driver);
		Assert.assertTrue(googleCloudPage.searchButton.isDisplayed());
	}
}