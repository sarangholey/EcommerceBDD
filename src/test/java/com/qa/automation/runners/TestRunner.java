package com.qa.automation.runners;
/**
 * 
 * @author Sarang Holey
 * 
 */
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",				// to tell cucumber where is the feature file
		glue = "com.qa.automation.stepdefs",			// to tell cucumber where is the step definition code
		tags = "",							// to tell which tagged feature file to execute
		plugin = {"pretty",								// to show console output as pretty with proper formatting
				"html:target/html/htmlreport.html", 	// to generate html report inside target folder
				"json:target/json/file.json",			// to generate json report inside target folder
				"junit:target/cucumberXML.xml",			// to generate cucumber xml report inside target folder
				"rerun:target/failedrerun.txt",			// to generate failed test scenarios data in failedrerun.txt file
		},
		publish = true,									// to publish cucumber online report
		monochrome = true,								// to print output on console with proper alignment and systematic way
		dryRun = false									// to tell whether to test run (true) or actual run (false)
		)

public class TestRunner {
	// Class will be empty
	// Nothing goes here
	// So do not get confused
}
