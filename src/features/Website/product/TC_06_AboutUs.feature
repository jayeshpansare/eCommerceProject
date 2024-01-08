#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate home page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate aboutus page
  As a user can validate about us page info

  @Aboutus
  Scenario: validate about us info
    Given About Us menu must be available as "About Us"
    When user click on About Us menu
    Then open FAQ page having page title as "About Us"

  @Aboutus
  Scenario: validate the description on FAQ page
    Given about usp page must be available
    Then validate the about us description as ""
    And back to home page
