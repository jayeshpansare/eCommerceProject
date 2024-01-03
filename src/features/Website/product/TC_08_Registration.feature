#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate home page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate home page
  As a user can validate home page info

  @Registration
  Scenario: validate home info
    Given home page is available "Ecommerce PHP"
    Then click on " Register" link
    And validate login page title as "Customer Registration"

  @Registration
  Scenario Outline: validate registration with invalid info
    Given login page must be available "Customer Registration"
    When user enter fullname as "<fullname>"
    And user enter company name as "<companyName>"
    And user enter email address as "<Email>"
    And user enter phone number as "<PhoneNumber>" on registration form
    And user enter address as "<address>"
    And user select country as "<country>"
    And user enter city as "<city>"
    And user enter State as "<state>"
    And user enter zip code as "<zipcode>"
    And user enter password as "<password>"
    And user enter retry password as "<Repassword>"
    Then click on register submit button
    Then display an register error message as "<error>"
    Examples:
    |fullname|companyName|Email|PhoneNumber|address|country|city|state|zipcode|password|Repassword|error|
    |        |           |     |           |       | Albania      |    |     |       |        |          |Customer Name can not be empty.|
    |test    |test       |test@gmail.com|9999999999|Test address|Albania|test|test|test|test@123|test@123|Email Address Already Exists.  |