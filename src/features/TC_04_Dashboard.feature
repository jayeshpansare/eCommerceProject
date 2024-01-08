#Author: Jayesh
#Keywords Summary :
#Feature: Dashboard page
#Scenario: validate Dashboard page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate Dashboard page
 As a user can validate the dashboard, User can validate all the sections and its count.

  @dashboard @run
  Scenario Outline: validate the dashboard sections
    Given Open dashboard sections
    When validate the dashboard title as "Dashboard"
    Then validate dashboard section title as "<sectionName>" and its count as "<count>"
    Examples:
    |sectionName|count|
    |Products   |20   |
    |Pending Orders|0 |
    |Completed Orders|4|
    |Completed Shipping|3|
    |Pending Shippings |1|
    |Active Customers  |11|
    |Subscriber        |6 |
    |Available Shippings|4|
    |Top Categories     |6|
    |Mid Categories     |15|
    |End Categories     |78|