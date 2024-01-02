#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate home page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate login page
  As a user can validate login page info

  @login
  Scenario: validate login info
    Given home page is available "Ecommerce PHP"
    Then click on " Login" link
    And validate login page title as "Customer Login"

  @login
  Scenario Outline: validate login with invalid info
    Given login page must be available "Customer Login"
    When user enter email as "<username>" and password as "<password>"
    Then click on login submit button
    Then display an login error message as "<errormsg>"
    Examples:
      |username|password|errormsg|
      |        |        |Email and/or Password can not be empty.|
      |test@gmail.com|test |Passwords do not match.             |
      |test123@gmail.com    |test@123     |Email Address does not match.|