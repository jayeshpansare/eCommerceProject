#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate home page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate FAQ page
  As a user can validate FAQ page info
  @FAQ
  Scenario: validate FAQ info
    Given FAQ menu must be available as "FAQ"
    When user click on FAQ menu
    Then open FAQ page having page title as "FAQ"

    @FAQ
    Scenario Outline: validate FAQ accordion
      Given if faq title is available as "<title>" for index "<index>"
      When user click on title for index "<index>"
      Then display its description as "<desc>" for index "<index>"
      Examples:
      |title|index|desc|
      |Q: How to find an item?|1|We have a wide range of fabulous products to choose from.#If you want to explore a category of products|
      |Q: What is your return policy?|2|You have 15 days to make a refund request after your order has been delivered.        |
      |Q: I received a defective/damaged item, can I get a refund?|3|In case the item you received is damaged or defective#you could return an item in the same condition as you received it with the original box|
      |Q: When are ‘Returns’ not possible?                         |4|Return request is made outside the specified time frame, of 15 days from delivery.#Product is used, damaged, or is not in the same condition as you received it.#Products with tampered or missing serial numbers.|
      |Q: What are the items that cannot be returned?              |5|The items that can not be returned are:#Clearance items clearly marked as such and displaying a No-Return Policy#When the offer notes states so specifically are items that cannot be returned.                   |