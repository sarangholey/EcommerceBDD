package com.qa.automation.stepdefs;

import org.openqa.selenium.WebDriver;

public class TestContext {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


}
