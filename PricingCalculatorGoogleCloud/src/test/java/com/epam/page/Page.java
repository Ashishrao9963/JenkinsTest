package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Page {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public Page(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public WebDriverWait getWait(){
        return this.wait;
    }

}
