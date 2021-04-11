# Author: Sarang Holey | sarangholey@gmail.com
# This file contain basic scenario's to check a status of application
# All test realed to smoke testing included in this feature file

@ui @healthckeck @smoke
Feature: E-commerce Project Web Site Health Check

  @appUrlRedirection @ui1
  Scenario: Validate application is redirecting to correct url
    Given User navigated to the home application url
    When User is on application landing page
    Then Application url is redirected to "http://automationpractice.com/index.php"

  @titleCheck
  Scenario: Validate application title is correct
    Given User navigated to the home application url
    When User is on application landing page
    Then Application title is "My Store"
    
  @searchFunction
  Scenario: Validate user is able to search a product from searchbox on landing page
  	Given User navigated to the home application url
    When Search box is displayed
    And User search for "Dress"
    Then Search box shows result containing "Dress" as product more than "5" 

