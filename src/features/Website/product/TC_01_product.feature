#Author: Jayesh
#Keywords Summary :
#Feature: product page
#Scenario: validate product page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate product page
  As a user we can validate multiple product according to sub menu.

  @aboutUs
  Scenario Outline: validate product according to its main and sub menu
    Given open web site "https://wonske.com/anandtech/"
    And over on main menu "<mainmenu>"
    When click on sub menu "<submenu>"
    Then validate the product name "<productname>" and price "<price>"

    Examples:
      | mainmenu    | submenu               | productname | price |  |
      | Electronics | Computers and Tablets |test product |40     |  |