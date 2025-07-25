package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAutomation {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement successMsg = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMsg.getText().contains("You logged into a secure area!"));

        // Logout
        driver.findElement(By.cssSelector("a.button.secondary.radius")).click();

        // Verify returned to login page
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

//    @Test(priority = 2)
//    public void loginWithInvalidCredentials() {
//        driver.findElement(By.id("username")).sendKeys("invalidUser");
//        driver.findElement(By.id("password")).sendKeys("invalidPass");
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//
//        WebElement errorMsg = driver.findElement(By.id("//div[@id='flash']"));
//        System.out.println(errorMsg.getText());
//        Assert.assertTrue(errorMsg.getText().contains("Your username is invalid!"));
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

