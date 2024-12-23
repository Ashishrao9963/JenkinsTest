package com.epam.test;

import com.epam.page.GoogleCloudPage;
import com.epm.webdriver.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

public class GoogleCloudPageTest {
	
	WebDriverFactory webDriverSingleton = new WebDriverFactory();
    WebDriver driver;
    GoogleCloudPage googleCloudPage;
    
    @BeforeTest
    public void setWebDriver(){
    	this.driver = webDriverSingleton.getWebDriver("chromedriver");
        googleCloudPage=new GoogleCloudPage(driver);

    }

    @Test
    public void testSearchIcon(){
        Assert.assertTrue(googleCloudPage.clickSearch());
    }


    @Test(dependsOnMethods = "testSearchIcon")
    public void testInputFeild(){
        Assert.assertEquals(googleCloudPage.giveSearchInput(),"Google Cloud Pricing Calculator");
    }



    @Test(dependsOnMethods = "testInputFeild")
    public void testCalculatorUrl(){

        Assert.assertEquals(googleCloudPage.navigateToSearchResults().searchCalculatorUrl(),"Google Cloud Pricing Calculator");
    }
}
