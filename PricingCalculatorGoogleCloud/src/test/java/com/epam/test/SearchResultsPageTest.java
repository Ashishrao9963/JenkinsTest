package com.epam.test;

import com.epam.page.SearchResultsPage;
import com.epm.webdriver.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultsPageTest  {
	WebDriverFactory webDriverSingleton = new WebDriverFactory();
    SearchResultsPage searchResultsPage;
    WebDriver driver;
    @BeforeClass
    public void setSearchResultsPage() {
    	this.driver = webDriverSingleton.getWebDriver("chromedriver");
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testCalculatorUrl() {
        Assert.assertEquals(searchResultsPage.launchSearchResults().searchCalculatorUrl(), "Google Cloud Pricing Calculator");
    }
}
