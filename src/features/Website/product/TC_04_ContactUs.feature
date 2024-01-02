#Author: Jayesh
#Keywords Summary :
#Feature: home page
#Scenario: validate contact us page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate contact us page
  As a user can validate contact us page info

  @contactus @smoke
  Scenario: validate contact us page
    Given validate contact us menu must be available as "Contact Us"
    And click on contact us menu
    When validate contact us header as "Contact Us"
    Then validate contact form header as "Contact Form"
    And validate form label as "Name" and "Email Address" and "Phone Number" and "Message"
#    And validate address as "93 Simpson Avenue Harrisburg, PA"
#    And validate phone number as "+001 10 101 0010"
#    And validate email as "support@ecommercephp.com"

  @contactus @smoke
  Scenario Outline:
    Given contact us form must be available
    When click on send message button
    Then display message as "<msg>"
    Examples:
      | msg                                                                                                                 |
      | Please enter your name.#Please enter your phone number.#Please enter your email address.#Please enter your message. |

  @contactus @smoke
  Scenario Outline:
    Given contact us form must be available
    When user enter Name as "<nameinpt>"
    And user enter email addrress as "<emailinpt>"
    And user enter phone number as "<phonenumberinpt>"
    And user enter message as "<messageinpt>"
    And click on send message button
    Then display message as "<msg>"

    Examples:
      | nameinpt | emailinpt      | phonenumberinpt | messageinpt         | msg                                                       |
      | test     | test@gmail.com | 7841845869      | test test test test | Thank you for sending email. We will contact you shortly. |