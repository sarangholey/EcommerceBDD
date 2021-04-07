package com.qa.automation.stepdefs;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

/**
 * 
 * @author Sarang Holey
 * 
 */
public class SocialMedia_StepDefs {

	private static final Logger logger = LogManager.getLogger(SocialMedia_StepDefs.class);

	WebDriver driver;
	WebDriverWait wait;
	TestContext testContext;


	public SocialMedia_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
	}

	@When("User clicks on the facebook link from bottom of the landing page")
	public void user_clicks_on_the_facebook_link_from_bottom_of_the_landing_page() {
		WebElement facebookLinkElement = driver.findElement(By.xpath("//section[@id='social_block']//li[@class='facebook']"));
		facebookLinkElement.click();
	}

	@When("New tab opened with facebook url {string}")
	public void new_tab_opened_with_facebook_url(String newBrowserWindowUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		wait.until(ExpectedConditions.urlContains(newBrowserWindowUrl));
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.facebook.com"));

	}

	@Then("User able to see facebook group with name {string}")
	public void user_able_to_see_facebook_group_with_name(String facebookGroupName) {
		WebElement facebookGroupNameElement = driver.findElement(By.xpath("(//span[contains(text(),'Selenium Framework')])[1]"));
		wait.until(ExpectedConditions.visibilityOf(facebookGroupNameElement));
		Assert.assertEquals(facebookGroupName, facebookGroupNameElement.getText());
	}

	@When("User clicks on the twitter link from bottom of the landing page")
	public void user_clicks_on_the_twitter_link_from_bottom_of_the_landing_page() {
		WebElement twitterLinkElement = driver.findElement(By.xpath("//section[@id='social_block']//li[@class='twitter']"));
		twitterLinkElement.click();
	}

	@When("New tab opened with twitter url {string}")
	public void new_tab_opened_with_twitter_url(String newBrowserWindowUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		wait.until(ExpectedConditions.urlContains(newBrowserWindowUrl));
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://twitter.com"));
	}
	
	@Then("User able to see twitter account with name {string}")
	public void user_able_to_see_twitter_account_with_name(String twitterAccountName) {
		WebElement twitterAccountNameElement = driver.findElement(By.xpath("(//span[text()='Selenium Framework'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(twitterAccountNameElement));
		Assert.assertEquals(twitterAccountName, twitterAccountNameElement.getText());
	}
	
	@When("User clicks on the youtube link from bottom of the landing page")
	public void user_clicks_on_the_youtube_link_from_bottom_of_the_landing_page() {
		WebElement youtubeLinkElement = driver.findElement(By.xpath("//section[@id='social_block']//li[@class='youtube']"));
		youtubeLinkElement.click();
	}

	@When("New tab opened with youtube url {string}")
	public void new_tab_opened_with_youtube_url(String newBrowserWindowUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		wait.until(ExpectedConditions.urlContains(newBrowserWindowUrl));
		Assert.assertEquals(true, driver.getCurrentUrl().contains("https://www.youtube.com"));
	}
	
	@Then("User able to see youtube account with name {string}")
	public void user_able_to_see_youtube_account_with_name(String youtubeAccountName) {
		WebElement youtubeAccountNameElement = driver.findElement(By.xpath("//div[@id='text-container']/yt-formatted-string[@id='text' and text()='Selenium Framework']"));
		wait.until(ExpectedConditions.visibilityOf(youtubeAccountNameElement));
		Assert.assertEquals(youtubeAccountName, youtubeAccountNameElement.getText());
	}

}

