package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumBaseDemoTest {
	
	
	@Test
	public void validateTextBox() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://seleniumbase.io/demo_page/");
		driver.close();
		WebElement textBox = driver.findElement(By.xpath("//input[@id='myTextInput']"));
		textBox.sendKeys("abcde");
		System.out.println(Thread.currentThread().getId());
		Assert.assertEquals(textBox.getAttribute("value"),"abcde");
	}
//	
//	@Test
//	public void validateTextArea() throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement textBox = driver.findElement(By.xpath("//textarea"));
//		Thread.sleep(2000);
//		textBox.sendKeys("abcde");
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertEquals(textBox.getAttribute("value"),"abcde");
//		
//	}
//	
//	@Test
//	public void validatePreFilledTextField() throws InterruptedException {
//		WebDriver driver = new FirefoxDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement preFilledTextField = driver.findElement(By.xpath("//input[@type='text' and @value='Text...']"));
//		Thread.sleep(1000);
//		preFilledTextField.clear();
//		preFilledTextField.sendKeys("As334");
//		String value=preFilledTextField.getAttribute("value");
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertEquals(value,"As334");
//	}
//	
//	@Test
//	public void validateButton() {
//		WebDriver driver = new EdgeDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement button = driver.findElement(By.xpath("//button"));
//		button.click();
//		String style = button.getAttribute("style");
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertTrue(style.equals("color: purple;"));
//	}
//	
//	@Test
//	public void validatePlaceHolderTextField() {
//		WebDriver driver = new EdgeDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement textField = driver.findElement(By.xpath("//input[@id='placeholderText']"));
//		textField.sendKeys("Replaced Text");
//		String replacedText = textField.getAttribute("value");
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertEquals(replacedText,"Replaced Text");
//	}
//	
//	@Test
//	public void validateReadOnlyTextField() {
//		WebDriver driver = new EdgeDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement textField = driver.findElement(By.xpath("//input[@id='readOnlyText']"));
//		System.out.println(textField.getText());
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertTrue(textField.getAttribute("value").contains("The Color is"));
//	}
//	
//	@Test
//	public void validateProgressBar() {
//		WebDriver driver = new ChromeDriver();
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		WebElement progressBar = driver.findElement(By.xpath("//progress"));
//		int progress = Integer.parseInt(progressBar.getAttribute("value"));
//		System.out.println(Thread.currentThread().getId());
//		Assert.assertEquals(progress, 50);
//	}
//	
////	@Test
////	public void validateChangeInProgressBar() {
////		WebDriver driver = new ChromeDriver();
////		driver.navigate().to("https://seleniumbase.io/demo_page/");
////		WebElement progressBar = driver.findElement(By.xpath("//progress"));
////		progressBar
////		int progress = Integer.parseInt(progressBar.getAttribute("value"));
////		Assert.assertEquals(progress, 50);
////	}
//	
//	@Test
//	public void openNewWindow() {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
////		String windowToOpen = "window.open(\"https://seleniumbase.io/demo_page/\"),'_blank'";
////		((JavascriptExecutor)driver).executeScript(windowToOpen);
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.navigate().to("https://seleniumbase.io/demo_page/");
//		System.out.println(Thread.currentThread().getId());
//	}
//	
//	
//	
//	
	
}