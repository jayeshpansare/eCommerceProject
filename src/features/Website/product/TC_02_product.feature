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

  @AddProduct @smoke
  Scenario Outline: validate product according to its main and sub menu
    Given home page is available "Ecommerce PHP"
    And over on main menu "<mainmenu>"
    When click on sub menu "<submenu>"
    Then validate the product name "<productname>" and price "<price>"

    Examples:
      | mainmenu    | submenu               | productname | price |  |
      | Electronics | Computers and Tablets |test product |40     |  |

    @AddProduct @smoke
    Scenario Outline: validate add product page
      user can validate product name, description, product desc, feature, condition, return policy
      Given home page is available "Ecommerce PHP"
      When user click on "<cat>" category and "<subcat1>" sub category and "<subcat2>" sub category
      And Click on product name as "<productname>"
      Then validate the product information as "<productname>" and "<desc>" and "<productdesc>" and "<feature>" and "<condition>" and "<returnpolicy>"
      Examples:
      |cat|subcat1|subcat2|productname|desc|productdesc|feature|condition|returnpolicy|
      | Men | Men Accessories |Watches |Amazfit GTS 3 Smart Watch for Android iPhone | Alexa Built-in, GPS Fitness Sports Watch with 150 Sports Modes| test| test| test|test|

      @AddProduct @smoke
      Scenario: validate add product
      user can select size, color and quantity and add product in cart
        Given home page is available "Ecommerce PHP"
        When user select product size as "Free Size"
        And user select product color as "Black"
        And user enter product quantity as "3"
        Then click on Add to cart button
        Then display and success message as "Product is added to the cart successfully!"
