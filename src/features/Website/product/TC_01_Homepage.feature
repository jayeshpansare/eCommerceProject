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
  @homepage @DryRun
  Scenario: validate home info with its sliders
    Given open web site "https://wonske.com/anandtech/"
    When home page logo is available
#    Then validate home page logo
    Then " Login" and " Register" links are available
    Then click on " Login" link
    And validate login page title as "Customer Login"
    And back to home page
    And click on " Register" link
    And validate registartion page title as "Customer Registration"
    Then back to home page

  @homepage
  Scenario Outline: validate search with invalid data
  Given search input must be available
  When user enter invalid input as "<invalidInpt>"
  And click on search submit button
  Then display an search error message as "<error>"
  Examples:
  |invalidInpt|error|
  |test555       | No result found|
  |2312321    | No result found|

  @homepage
  Scenario Outline: validate search with valid data
    Given search input must be available
    When user enter valid input as "<productname>"
    And click on search submit button
    Then display product as "<displayproductname>"
    Then back to home page
    Examples:
      |productname|displayproductname|
      |Men's Soft Classic Sneaker|Men's Soft Classic Sneaker|
      |Men's|Men's Soft Classic Sneaker                     |
      |Men's|Men's Long Cuffed Jogger Yoga Sweat Pant    |

  @homepage
  Scenario Outline: validate feature products slider
  Given feature products section must be available "<featureTitle>"
  When fetaure products desc must be available "<featureDesc>"
  Then display list of products "<featureProdList>"
  Examples:
  |featureTitle|featureDesc|featureProdList|
  |FEATURED PRODUCTS|Our list on Top Featured Products|Amazfit GTS 3 Smart Watch for Android iPhone#Men's Loose Fit Heavyweight Long-Sleeve Pocket T-Shirt#Women's Tea Length Dress with Rosette Detail (Petite & Regular)|

  @homepage
  Scenario Outline: validate latest products slider
    Given latest products section must be available "<latestTitle>"
    When latest products desc must be available "<latestDesc>"
    Then display list of latest products as "<latestProdList>"
    Examples:
      |latestTitle|latestDesc|latestProdList|
      |LATEST PRODUCTS|Our list of recently added products|Women's Plus-Size Shirt Dress with Gold Hardware#Digital Infrared Thermometer for Adults and Kids#Men's Long Cuffed Jogger Yoga Sweat Pant|

  @homepage
  Scenario: validate send message UI part
    Given Send message section is available and title as " Send message "
    When Click on send message section
    Then validate description on send message section as "Please fill out the form below and we will get back to you as soon as possible."
    Then validate send message button as " Submit "

  @homepage
  Scenario Outline: validate send message with invalid inputs
    Given send message section is open
    When click on submit button
    Then display an name error message as "<nameErr>"
    Then display email error message as "<emailErr>"
    Then display message error message as "<messageErr>"
    Examples:
      | nameErr                   | emailErr | messageErr |  |
      | This field is required | This field is required | This field is required | |

  @homepage
  Scenario Outline: validate send message email input with invalid data
    Given send message section is open
    When enter email input as "<emailInpt>"
    Then display email error message as "<email>"
    Then click on submit button
    Examples:
      | emailInpt | email                  |
      | test      | Invalid email address. |
      | test@     | Invalid email address. |
      |test@gmail |Invalid email address.  |
      |157653152  | Invalid email address. |
      | test124@yopmail.com|  Invalid email address. |

  @homepage
  Scenario Outline: validate send message with valid inputs
    Given send message section is open
    When enter name input as "<nameInpt>"
    And enter email input as "<emailInpt>"
    And enter message input as "<msgInpt>"
    Then click on submit button
    And display send message success message as "Your message was sent successfully!"
    And click on send mesg submit button
    Examples:
      | nameInpt | emailInpt        | msgInpt                                                                                                                                                                                                                                                                                                                          |
      | test     | test124@gmail.com   | testmessage                                                                                                                                                                                                                                                                                                                      |
      | test2    | test124@gmail.com | dasdasasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss |