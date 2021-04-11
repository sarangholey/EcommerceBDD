package com.qa.automation.stepdefs;

import com.qa.automation.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StepDefs_Hooks {
    private static final Logger logger = LogManager.getLogger(Thread.getAllStackTraces().getClass().getName());
    TestContext testContext;
    Scenario scn;
    int implicitWait_timeout_in_sec = 20;
    int pageLoad_timeout_in_sec = 20;
    int setScript_timeout_in_sec = 20;
    int webDriver_wait_timeout_sec = 20;


    public StepDefs_Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setup(Scenario scn)
    {
        this.scn = scn;
    
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait_timeout_in_sec, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoad_timeout_in_sec, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(setScript_timeout_in_sec, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, webDriver_wait_timeout_sec);

        //Set web driver and webdriver wait object in test context so that they could be referenced in other step defs
        testContext.setDriver(driver);
        testContext.setWebDriverWait(wait);
        testContext.setScenario(scn);
        scn.log("Browser invoked"); 	// to log info in reports
        logger.info("Browser invoked");	// to log the info in application log file
    }

    @After(order=1)
    public void cleanUp() {
        testContext.getDriver().quit();
        scn.log("Browser closed");
        logger.info("Browser closed");
    }

    @After(order=2)
    public void takeScreenShot(Scenario s) {
        if (s.isFailed()) {
            TakesScreenshot scrnShot = (TakesScreenshot)testContext.getDriver();
            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
            scn.log("Step is failed");
            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
        }else{
            scn.log("Test case is passed, no screen shot captured");
        }
    }


}
