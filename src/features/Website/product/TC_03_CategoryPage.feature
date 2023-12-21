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

#  @category
#  Scenario Outline: validate category menu and its sub menu
#    Given home page is available "Ecommerce PHP"
#    When validate "<cat>" menu is present
#    And hover main menu as "<cat>"
#    Then validate main menu "<cat>" and its sub menu "<TopCat>"
#    Then validate main menu "<cat>" and its sub menu "<TopCat>" and sub menu as "<SubCat>"
#    Examples:
#    |cat|TopCat|SubCat|
#    |Men|Men Accessories|Multipacks#Other Accessories#Headwear#Watches#Belts#Sunglasses|
#    |Men|Men's Shoes    |Formal Shoes#Boots#Casual Shoes#Sandals#Sports Shoes          |
#    |Men|Bottoms        |Joggers#Shorts#Pants#Jeans                                    |
#    |Men|T-shirts & Shirts|T-shirts#Formal Shirts#Vests#Casual Shirts#Polo Shirts      |
#    |Women|Beauty Products|Lips#T-Shirt#Hair Care#Tops#Face Care#Eyes Care#Skincare#Fragrance#Gift Sets|
#    |Women|Accessories    |Jewellery#Scarves & Headwear#Bags#Multipacks#Other Accessories#Watches#Sunglasses|
#    |Women|Shoes          |Sneakers#Comfort Shoes#Slippers & Casual Shoes#Pumps#Flat Shoes#Boots#Sandals#Sports Shoes|
#    |Women|Clothing       |Dresses#Coats & Jackets#Pants & Leggings#Socks & Hosiery#Tops#Sportswear#T-Shirts & Vests#Hoodies#Plus Size Clothing|
#    |Kids |Clothing       |Boys#Girls|
#    | Kids|Shoes          |    Boys#Girls |
#    |Kids |Accessories    |    Boys#Girls |
#    |Electronics|Electronic Items| Headphones#Security and Surveillance#Television and Video#Home Audio#Cell Phone and Accessories#GPS and Navigation|
#    |  Electronics      |Computers       | External Components#Computer Components#Laptop Accessories#Networking Products#Computers and Tablets#Printer and Monitors|

#  @category
#  Scenario Outline: validate category and its related products
#    Given home page is available "Ecommerce PHP"
#    When user click on "<cat>" category
#    Then validate category product name as "<productnames>"
#    Examples:
#    |cat|productnames|
#    |Men|Men's Fleece Jogger Pant#Men's Ultra Cotton T-Shirt, Multipack#Men's Loose Fit Heavyweight Long-Sleeve Pocket T-Shirt#Men's Long Cuffed Jogger Yoga Sweat Pant#Amazfit GTS 3 Smart Watch for Android iPhone#Men's Soft Classic Sneaker#Under Armour Men's Sportstyle Left Chest Short Sleeve T-shirt |
#    |Women|Loose-fit One-Shoulder Cutout Rib Knit Maxi Dress#Women's Plus-Size Shirt Dress with Gold Hardware#Women's Thin Cotton Zip Up Hoodie Jacket#Women's Oversized Fleece Hoodie#Women's Tea Length Dress with Rosette Detail (Petite & Regular)#Women's Fuzzy Fleece Lapel Open Front Long Cardigan Coat#Gold Plated Leopard Print Crystal Big Round Hoop Earrings#Travelpro Laptop Carry-on Travel Tote Bag  |
#    |Kids |  Truck Boys Pajamas Toddler Sleepwear Clothes                                                                                                                                                                                                                                                                                                 |
#    |Electronics| Bose QuietComfort 45 Bluetooth Wireless Headphones#test Product#WD 5TB Elements Portable External Hard Drive HDD#Oculus Quest 2 - Advanced All-In-One Virtual Reality Headset#test product  |
#    |Health and Household|   Digital Infrared Thermometer for Adults and Kids |
#    |Child               |    No Product Found                                                                                                                                                                                                                                                                                |

#  @category
#  Scenario Outline: validate sub category and its related products
#    Given home page is available "Ecommerce PHP"
#    When user click on "<cat>" category and "<subcat>" sub category
#    Then validate category product name as "<productnames>"
#    Examples:
#    |cat|subcat|productnames|
#    |Men|Men Accessories|Amazfit GTS 3 Smart Watch for Android iPhone   |
#    |Men|Men's Shoes    | Men's Soft Classic Sneaker  |
#    |Men|Bottoms        |Men's Fleece Jogger Pant#Men's Long Cuffed Jogger Yoga Sweat Pant   |
#    |Men|T-shirts & Shirts|Men's Ultra Cotton T-Shirt, Multipack#Men's Loose Fit Heavyweight Long-Sleeve Pocket T-Shirt#Under Armour Men's Sportstyle Left Chest Short Sleeve T-shirt |
#    |Women|Beauty Products|No Product Found |
#    |Women|Accessories    |Gold Plated Leopard Print Crystal Big Round Hoop Earrings#Travelpro Laptop Carry-on Travel Tote Bag|
#    |Women|Shoes          |No Product Found |
#    |Women|Clothing       |Loose-fit One-Shoulder Cutout Rib Knit Maxi Dress#Women's Plus-Size Shirt Dress with Gold Hardware#Women's Thin Cotton Zip Up Hoodie Jacket#Women's Oversized Fleece Hoodie#Women's Tea Length Dress with Rosette Detail (Petite & Regular)#Women's Fuzzy Fleece Lapel Open Front Long Cardigan Coat |
#    |Kids |Clothing       |Truck Boys Pajamas Toddler Sleepwear Clothes |
#    | Kids|Shoes          |No Product Found|
#    |Kids |Accessories    | No Product Found|
#    |Electronics|Electronic Items|Bose QuietComfort 45 Bluetooth Wireless Headphones#Oculus Quest 2 - Advanced All-In-One Virtual Reality Headset|
#    |Electronics|Computers| test Product#WD 5TB Elements Portable External Hard Drive HDD#test product|

  @category
  Scenario Outline: validate sub category and its related products
    Given home page is available "Ecommerce PHP"
    When user click on "<cat>" category and "<subcat1>" sub category and "<subcat2>" sub category
    Then validate category product name as "<productname>"
    Examples:
    |cat|subcat1|subcat2|productname|
    | Men | Men Accessories |Multipacks | No Product Found |
    | Men | Men Accessories |Other Accessories | No Product Found |
#    | Men | Men Accessories |Headwear  | No Product Found |
    | Men | Men Accessories |Belts | No Product Found |
    | Men | Men Accessories |Sunglasses |No Product Found|
    | Men | Men Accessories |Watches |Amazfit GTS 3 Smart Watch for Android iPhone |