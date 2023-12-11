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
  @homepage
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

  @homepage
  Scenario Outline: validate send message with valid inputs
    Given send message section is open
    When enter name input as "<nameInpt>"
    And enter email input as "<emailInpt>"
    And enter message input as "<msgInpt>"
    Then display success message as "test"
    Then click on submit button
    Examples:
      | nameInpt | emailInpt        | msgInpt                                                                                                                                                                                                                                                                                                                          |
      | test     | test@gmail.com   | testmessage                                                                                                                                                                                                                                                                                                                      |
      | test2    | test@yopmail.com | dasdasasssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss |