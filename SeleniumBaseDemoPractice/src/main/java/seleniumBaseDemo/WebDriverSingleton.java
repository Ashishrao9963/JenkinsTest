package seleniumBaseDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import exception.NotADefaultBrowser;

public class WebDriverSingleton {
	
	private ChromeDriver chromeDriver;
	private EdgeDriver edgeDriver;
	private InternetExplorerDriver internetExplorerDriver;
	private FirefoxDriver firefoxDriver;
	private SafariDriver safariDriver;
	
	public WebDriver getWebDriver(String browser) {
		return switch(browser.toLowerCase()) {
		case "chromedriver" -> chromeDriver==null ? chromeDriver = new ChromeDriver(): chromeDriver;
		case "edgedriver" -> edgeDriver==null ? edgeDriver = new EdgeDriver():edgeDriver;
		case "internetexplorerdriver" -> internetExplorerDriver== null ? internetExplorerDriver = new InternetExplorerDriver():internetExplorerDriver;
		case "firefoxdriver" -> firefoxDriver == null ? firefoxDriver = new FirefoxDriver(): firefoxDriver;
		case "safaridriver" -> safariDriver == null ? safariDriver = new SafariDriver():safariDriver;
		default -> throw new NotADefaultBrowser("This is not one of the default browsers");
		};
	}
	
	
}