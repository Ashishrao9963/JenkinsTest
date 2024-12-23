package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PracticeTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpDriver() {
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
	}
	
	@Test(dataProviderClass = PracticeTest.class,dataProvider = "pop")
	public void test3(Boolean cond) {
		Assert.assertTrue(cond);
	}
	
	@DataProvider(name = "pop")
	public Object[][] popeye(){
		return new Object[][] {
			{true},
			{true},
			{false}
		};
	}
	
	@AfterMethod
	public void tearDownDriver() {
		driver.quit();
	}
	
}
