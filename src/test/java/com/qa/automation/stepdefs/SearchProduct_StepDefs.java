package com.qa.automation.stepdefs;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.automation.context.TestContext;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchProduct_StepDefs {
	
	private static final Logger logger = LogManager.getLogger(SearchProduct_StepDefs.class);

	WebDriver driver;
	TestContext testContext;
	WebDriverWait wait;
	String base_url = "http://automationpractice.com/";
	int implicitWait_timeout_in_sec = 20;
	int pageLoad_timeout_in_sec = 20;
	int setScript_timeout_in_sec = 20;
	int webDriver_wait_timeout_sec = 20;
	Scenario scn;;


	public SearchProduct_StepDefs(TestContext testContext){
		this.testContext = testContext;
		driver = testContext.getDriver();
		wait = testContext.getWebDriverWait();
	}
	
	
	@When("User search following product from search box and add into cart")
	public void user_search_following_product_from_search_box_and_add_into_cart(List<Map<String,String>> cartDataTable) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    // For other transformations you can register a DataTableType.
		for (int i=0; i<cartDataTable.size();i++) {
			searchAndAddProduct(cartDataTable, i);
		}	
	}
	
	public void searchAndAddProduct(List<Map<String,String>> data, int index) throws InterruptedException
	{
		String itemName = data.get(index).get("ITEM");
		String productName = data.get(index).get("PRODUCT_NAME");
        int productQuantity = Integer.parseInt(data.get(index).get("QUANTITY"));
        System.out.println("----------------------");
        System.out.println((index+1) + " Item Name : " + itemName + " Product Name : " + productName + " product quantity : " + productQuantity);
        System.out.println("----------------------");
        
	}
	
	@Then("User cart is updated with the products and quantity")
	public void user_cart_is_updated_with_the_products_and_quantity() {
	    // Yet to be implimented
	}

}
