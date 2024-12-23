package promptEngineered;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumExample {
    RemoteWebDriver driver;
    String hubURL = "http://10.71.160.110:4444/";
    
    @BeforeTest
    public void setUp() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("platform", "WINDOWS");
        options.setCapability("version", "23H2");
        options.setCapability("browserName", "MicrosoftEdge");
        options.setCapability("browserVersion", "122.0.2365.59");
        driver = new RemoteWebDriver(new URL(hubURL), options);
    }

    @Test
    public void testWebApplication() {
        driver.get("http://google.com");
    }

    @AfterTest
    public void tearDown() {
        if(driver!=null) {
            System.out.println("Completed Test, Closing Browser");
            driver.quit();
        }
    }
}