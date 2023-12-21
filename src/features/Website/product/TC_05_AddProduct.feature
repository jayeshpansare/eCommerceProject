#Author: Jayesh
#Keywords Summary :
#Feature: product page
#Scenario: validate product page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate add product page
  As a user can validate product info and add a product into cart

  @aboutUs
  Scenario Outline: validate product info and add product into cart
    Given open web site "https://wonske.com/anandtech/"
    And over on main menu "<mainmenu>"
    When click on sub menu "<submenu>"
    Then validate the product name "<productname>" and price "<price>"
    And validate product description as "<productDesc>"
    And validate feature description as "<featureDesc>"
    And validate condition description as "<conditionDesc>"
    And validate return policy description as "<policyDesc>"

    Examples:
      | mainmenu    | submenu               | productname  | price | productDesc  | featureDesc  | conditionDesc            | policyDesc   |  |
      | Electronics | Computers and Tablets | test product | 40    | test product | test product | test producttest product | test product |  |