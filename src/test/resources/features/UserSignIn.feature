# Author: Sarang Holey | sarangholey@gmail.com
# This file contain scenario's to check login for different user into the application
# All test realed to smoke testing included in this feature file
@userlogin
Feature: E-commerce Project Web Site login user fuctionality

  @loginPositive @smoke
  Scenario Outline: User is able to login into the application
    Given User navigated to the home application url
    When User click on signin button from home page
    And User redirected to login page of the application where title us "Login - My Store"
    And User enters "<username>" and "<password>" and click on signin button
    Then User successfully redirected to "My account - My Store" page with user name displayed of the "<firstname>" and "<lastname>"

    Examples: 
      | username               | password | firstname | lastname |
      | dsfsfsdfds11@gmail.com |   123456 | Tom       | Peter    |
      | dsfsfsdfds12@gmail.com |   123456 | John      | Tyson    |
      | dsfsfsdfds13@gmail.com |   123456 | Steve     | Johnson  |

  @loginNegative @smoke
  Scenario Outline: User is unable to login into the application
    Given User navigated to the home application url
    When User click on signin button from home page
    And User redirected to login page of the application where title us "Login - My Store"
    And User enters "<username>" and "<password>" and click on signin button
    Then User is unable to login with an error message "Authentication failed."

    Examples: 
      | username            | password |
      | testuser1@gmail.com |   123456 |
      | testuser2@gmail.com |   123456 |
