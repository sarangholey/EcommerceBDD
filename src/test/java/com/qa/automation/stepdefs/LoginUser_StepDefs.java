package com.qa.automation.stepdefs;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUser_StepDefs {

	private static final Logger logger = LogManager.getLogger(LoginUser_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "http://automationpractice.com/";
	int implicitWait_timeout_in_sec = 20;
	int pageLoad_timeout_in_sec = 20;
	int setScript_timeout_in_sec = 20;
	int webDriver_wait_timeout_sec = 20;
	Scenario scn;;


	public LoginUser_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
	}

	@When("User click on signin button from home page")
	public void user_click_on_signin_button_from_home_page() {
		WebElement signinButtonElement = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		signinButtonElement.click();
	}

	@When("User redirected to login page of the application where title us {string}")
	public void user_redirected_to_login_page_of_the_application_where_title_us(String loginPageTitle) {
		String titleOfLoginPage = driver.getTitle();
		Assert.assertEquals(loginPageTitle, titleOfLoginPage);
	}

	@When("User enters {string} and {string} and click on signin button")
	public void user_enters_and_and_click_on_signin_button(String emailId, String password) {
		WebElement emailIdInputFieldElement = driver.findElement(By.xpath("//label[@for='email']/following-sibling::input[@id='email']"));
		emailIdInputFieldElement.sendKeys(emailId);
		WebElement passwordInputFieldElement = driver.findElement(By.xpath("//input[@id='passwd']"));
		passwordInputFieldElement.sendKeys(password);
		WebElement signInButtonElement = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		signInButtonElement.click();
	}

	@Then("User successfully redirected to {string} page with user name displayed of the {string} and {string}")
	public void user_successfully_redirected_to_page_with_user_name_displayed_of_the_and(String loggedInPageTitle, String firstname, String lastname) {
		Assert.assertEquals(loggedInPageTitle, driver.getTitle());

		WebElement userDetailsElement = driver.findElement(By.xpath("//a[@title='View my customer account']/span"));
		String[] username = userDetailsElement.getText().split(" ");
		String userFirstName = username[0];
		String userLastName = username[1];
		
		Assert.assertEquals(firstname+ " " +lastname, userFirstName+ " " +userLastName);
	}
}

