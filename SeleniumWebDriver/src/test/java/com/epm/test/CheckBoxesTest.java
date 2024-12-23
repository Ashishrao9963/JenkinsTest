package com.epm.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epm.webdriver.WebDriverSingleton;

public class CheckBoxesTest {
	
	WebDriverSingleton webDriverSingleton;
	WebDriver webDriver;
	
	@BeforeClass
	public void createInstance() {
		webDriverSingleton = new WebDriverSingleton();
	}
	
	public WebDriver setWebDriver(String driver) {
		return webDriverSingleton.getWebDriver(driver);
	}

	@Test
	public void verifyCheckBoxes() throws InterruptedException {
		webDriver = setWebDriver("chromedriver");
		webDriver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
		webDriver.manage().window().maximize();
		WebElement webElement = webDriver.findElement(By.xpath("//*/input[@type=\"checkbox\"]"));
		webElement.click();
		webElement.isSelected();
		webDriver.close();
	}

}