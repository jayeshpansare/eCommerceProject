#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate home page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate category page
  As a user can validate category page info
  user can check each category and sub category is present or not.
  User can check each category present its own products

  @category
  Scenario Outline: validate category menu and its sub menu
    Given home page is available "Ecommerce PHP"
    When validate "<cat>" menu is present
    And hover main menu as "<cat>"
    Then validate main menu "<cat>" and its sub menu "<TopCat>"
    Then validate main menu "<cat>" and its sub menu "<TopCat>" and sub menu as "<SubCat>"
    Examples:
    |cat|TopCat|SubCat|
    |Men|Men Accessories|Multipacks#Other Accessories#Headwear#Watches#Belts#Sunglasses|
    |Men|Men's Shoes    |Formal Shoes#Boots#Casual Shoes#Sandals#Sports Shoes          |
    |Men|Bottoms        |Joggers#Shorts#Pants#Jeans                                    |
    |Men|T-shirts & Shirts|T-shirts#Formal Shirts#Vests#Casual Shirts#Polo Shirts      |
    |Women|Beauty Products|Lips#T-Shirt#Hair Care#Tops#Face Care#Eyes Care#Skincare#Fragrance#Gift Sets|
    |Women|Accessories    |Jewellery#Scarves & Headwear#Bags#Multipacks#Other Accessories#Watches#Sunglasses|
    |Women|Shoes          |Sneakers#Comfort Shoes#Slippers & Casual Shoes#Pumps#Flat Shoes#Boots#Sandals#Sports Shoes|
    |Women|Clothing       |Dresses#Coats & Jackets#Pants & Leggings#Socks & Hosiery#Tops#Sportswear#T-Shirts & Vests#Hoodies#Plus Size Clothing|
    |Kids |Clothing       |Boys#Girls|
    | Kids|Shoes          |    Boys#Girls |
    |Kids |Accessories    |    Boys#Girls |
    |Electronics|Electronic Items| Headphones#Security and Surveillance#Television and Video#Home Audio#Cell Phone and Accessories#GPS and Navigation|
    |  Electronics      |Computers       | External Components#Computer Components#Laptop Accessories#Networking Products#Computers and Tablets#Printer and Monitors|