package com.epam.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.epam.page.CalculatorLegacyPage;
import com.epm.webdriver.WebDriverFactory;

public class CalculatorLegacyPageTest {
	WebDriverFactory webDriverSingleton = new WebDriverFactory();
    WebDriver driver;
    CalculatorLegacyPage calculatorLegacyPage;

    @BeforeTest
	private void setWebDriver() {
		this.driver = webDriverSingleton.getWebDriver("chromedriver");
	}

    @Test
    public void testNumberOfInstances(){
        Assert.assertEquals(calculatorLegacyPage.launchCalculatorLegacyPage().addNumberOfInstances(),"4");
    }

    @Test(dependsOnMethods = "testNumberOfInstances")
    public void testOperatingSystemChoice(){
        Assert.assertEquals(calculatorLegacyPage.setOperatingSystems(),"Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)");
    }



    @Test(dependsOnMethods = "testOperatingSystemChoice")
    public void testProvisionalModelChoice(){
        Assert.assertEquals(calculatorLegacyPage.setProvisionalModel(),"Regular");
    }



    @Test(dependsOnMethods = "testProvisionalModelChoice")
    public void testSeries(){
        Assert.assertEquals(calculatorLegacyPage.setSeries(),"N1");
    }

    @Test(dependsOnMethods = "testSeries")
    public void testMachineType(){
        Assert.assertEquals(calculatorLegacyPage.setMachineType(),"n1-standard-8 (vCPUs: 8, RAM: 30GB)");

    }


    @Test(dependsOnMethods = "testMachineType")
    public void testGpuCheckBox(){
        Assert.assertTrue(calculatorLegacyPage.clickAddGPUsCheckbox());

    }

    @Test(dependsOnMethods = "testGpuCheckBox")
    public void testGpuType(){
        Assert.assertEquals(calculatorLegacyPage.setGpuType(),"NVIDIA Tesla V100");

    }


    @Test(dependsOnMethods = "testGpuType")
    public void testNumberOfGPU(){
        Assert.assertEquals(calculatorLegacyPage.setNumberOfGPUs(),"1");

    }

    @Test(dependsOnMethods = "testNumberOfGPU")
    public void testLocalSSD(){
        Assert.assertEquals(calculatorLegacyPage.setLocalSSD(),"2x375 GB");

    }

    @Test(dependsOnMethods = "testLocalSSD")
    public void testDataCenterLocation(){
        Assert.assertEquals(calculatorLegacyPage.setDataCenterLocation(),"Frankfurt (europe-west3)");

    }

    @Test(dependsOnMethods = "testDataCenterLocation")
    public void testCommitedUsage(){
        Assert.assertEquals(calculatorLegacyPage.setCommitedUsage(),"1 Year");
    }



    @Test(dependsOnMethods = "testCommitedUsage")
    public void testEstimatedValue(){
        Assert.assertEquals(calculatorLegacyPage.getEstimatedValue(),"Total Estimated Cost: USD 1,081.20 per 1 month");
    }

    @AfterTest
    public void closeWebDriver(){
        driver.quit();
        calculatorLegacyPage=null;
    }


}
