# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check social media handles redirection from the application
@socialMedia
Feature: E-commerce Project Web Site social media handle validation

	@facebook
  Scenario: Validate facebook social media handle
    Given User navigated to the home application url
    When User clicks on the facebook link from bottom of the landing page
    And New tab opened with facebook url "https://www.google.com"
    Then User able to see facebook group with name "Selenium Framework"

	@twitter
  Scenario: Validate twitter social media handle
  	Given User navigated to the home application url
  	When User clicks on the twitter link from bottom of the landing page
  	And New tab opened with twitter url "https://twitter.com"
  	Then User able to see twitter account with name "Selenium Framework"
  	
  @youtube
	Scenario: Validate youtube social media handle
		Given User navigated to the home application url
  	When User clicks on the youtube link from bottom of the landing page
  	And New tab opened with youtube url "https://www.youtube.com/"
  	Then User able to see youtube account with name "Selenium Framework"
