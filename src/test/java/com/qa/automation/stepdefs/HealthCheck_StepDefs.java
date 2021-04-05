package com.qa.automation.stepdefs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sarang Holey
 * 
 */
public class HealthCheck_StepDefs {

	private static final Logger logger = LogManager.getLogger(HealthCheck_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "http://automationpractice.com/";
	int implicitWait_timeout_in_sec = 20;
	int pageLoad_timeout_in_sec = 20;
	int setScript_timeout_in_sec = 20;
	int webDriver_wait_timeout_sec = 20;
	Scenario scn;

	public HealthCheck_StepDefs(TestContext testContext){
		this.testContext = testContext;
	}


	@Before
	public void setup(Scenario scn)
	{

		this.scn = scn; 				//Assign this to class variable, so that it can be used in all the step def methods
		driver = new ChromeDriver();
		testContext.setDriver(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(implicitWait_timeout_in_sec, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoad_timeout_in_sec, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(setScript_timeout_in_sec, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, webDriver_wait_timeout_sec);
		scn.log("Browser invoked"); 	// to log info in reports
		logger.info("Browser invoked");	// to log the info in application log file
	}

	@After(order=1)
	public void cleanUp() {
		driver.quit();
		scn.log("Browser closed");
		logger.info("Browser closed");
	}

	@After(order=2)
	public void takeScreenShot(Scenario s) {
		if (s.isFailed()) {
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.log("Step is failed");
			scn.attach(data, "image/png","Failed Step Name: " + s.getName());
		}else{
			scn.log("Test case is passed, no screen shot captured");
		}
	}

	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		driver.get(base_url);
		scn.log("Browser navigated to url :- " + base_url);
		logger.info("Browser navigated to url :- " + base_url);
	}

	@When("User is on application landing page")
	public void user_is_on_application_landing_page() {
		Assert.assertEquals(true, driver.getCurrentUrl().contains("automationpractice"));
		scn.log("Application url contains :- \"automationpractice\"");
		logger.info("Application url contains :- \"automationpractice\"");
	}

	@Then("Application url is redirected to {string}")
	public void application_url_is_redirected_to(String applicationExpectedUrl) {
		Assert.assertEquals(applicationExpectedUrl, driver.getCurrentUrl());
		scn.log("Application url is successfully redirected to :- " + driver.getCurrentUrl());
		logger.info("Application url is successfully redirected to :- " + driver.getCurrentUrl());
	}

	@Then("Application title is {string}")
	public void application_title_is(String applicationLandingPageTitle) {
		Assert.assertEquals(applicationLandingPageTitle, driver.getTitle());
		scn.log("Application title is found as :- " + driver.getTitle());
		logger.info("Application title is found as :- " + driver.getTitle());
	}

	@Then("Application logo is displayed")
	public void application_logo_is_displayed() {
		WebElement applicationLogo = driver.findElement(By.xpath("//div[@id='header_logo']//img[@alt='My Store']"));
		wait.until(ExpectedConditions.visibilityOf(applicationLogo));
		Assert.assertEquals(true, applicationLogo.isDisplayed());
		scn.log("Application logo display status is found :-  " + applicationLogo.isDisplayed());
		logger.info("Application logo display status is found :-  " + applicationLogo.isDisplayed());
	}

	@Then("Application logo height is {string}")
	public void application_logo_height_is(String applicationLogoHeight) {
		WebElement applicationLogoElement = driver.findElement(By.xpath("//div[@id='header_logo']//img[@alt='My Store']"));
		wait.until(ExpectedConditions.visibilityOf(applicationLogoElement));
		Assert.assertEquals(applicationLogoHeight, applicationLogoElement.getAttribute("height"));
		scn.log("Application logo height is found :-  " + applicationLogoElement.getAttribute("height"));
		logger.info("Application logo height is found :-  " + applicationLogoElement.getAttribute("height"));
	}

	@Then("Application logo width is {string}")
	public void application_logo_width_is(String applicationLogoWidth) {
		WebElement applicationLogoElement = driver.findElement(By.xpath("//div[@id='header_logo']//img[@alt='My Store']"));
		wait.until(ExpectedConditions.visibilityOf(applicationLogoElement));
		Assert.assertEquals(applicationLogoWidth, applicationLogoElement.getAttribute("width"));
		scn.log("Application logo width is found :-  " + applicationLogoElement.getAttribute("width"));
		logger.info("Application logo width is found :-  " + applicationLogoElement.getAttribute("width"));
	}

	@When("Search box is displayed")
	public void search_box_is_displayed() {
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		wait.until(ExpectedConditions.visibilityOf(searchBoxElement));
		Assert.assertEquals(true, searchBoxElement.isDisplayed());
		scn.log("Searchbox on landing page is displayed found as :-  " + searchBoxElement.isDisplayed());
		logger.info("Searchbox on landing page is displayed found as :-  " + searchBoxElement.isDisplayed());
	}

	@When("User search for {string}")
	public void user_search_for(String nameOfProduct) {
		WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='search_query_top']"));
		searchBoxElement.sendKeys(nameOfProduct);
		List<WebElement> searchResultList = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResultList));
		Assert.assertEquals(true, searchResultList.get(0).isDisplayed());
		scn.log("After searching for the product search result is displayed status :- " + searchBoxElement.isDisplayed());
		logger.info("After searching for the product search result is displayed status :- " + searchBoxElement.isDisplayed());
	}

	@Then("Search box shows result containing {string} as product more than {string}")
	public void search_box_shows_result_containing_as_product_more_than(String nameOfProduct, String noOfProductsConatainingName) {
		List<WebElement> searchResultList = driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResultList));

		int countOfProductsWithProductName = 0;

		for (int i = 0; i < searchResultList.size(); i++) {
			if (searchResultList.get(i).getText().contains("Dress")) 
			{
				countOfProductsWithProductName = countOfProductsWithProductName + 1;
			}
		}
		if (countOfProductsWithProductName == 5) {
			Assert.assertTrue(true);
			scn.log("Product search result displayed a list containing product name as :- " + nameOfProduct);
			logger.info("Product search result displayed a list containing product name as :- " + nameOfProduct);
		}
		else {
			Assert.fail();
			scn.log("Product search result unable to display a list containing product name as :-  " + nameOfProduct);
			logger.info("Product search result unable to display a list containing product name as :-  " + nameOfProduct);
		}
	}


}
