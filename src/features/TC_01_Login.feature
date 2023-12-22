#Author: Jayesh
#Keywords Summary :
#Feature: about us us pages
#Scenario: validate about us page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate login page
  As a user can enter email in forgot password input
  User can enter new user name and password
  Valid: User can enter email and new password
  Invalid: User can enter email and old password

#  @invalid
#  Scenario Outline: validate login with invalid inputs
#    Given open login page
#    When User enter email and password using "<email>" and "<password>"
#    Then Click on login button
#    Then display an error messages as  "<ErrorMsg>"
#
#    Examples:
#      | email          | password | ErrorMsg                     |
#      | Test@gmail.com | Sheet1   | Email Address does not match |
#      | Test@gmail.com | Test@123 | Email Address does not match |

  @valid
  Scenario Template:  validate login with valid inputs
    Given login page title as "Login"
    When User enter email and password using "<validemail>" and "<validpassword>"
    Then Click on login button
    Then display dashboard
    And validate dashboard page title as "Admin Panel"

    Examples:
      | validemail     | validpassword |  |
      | admin@mail.com | Password@123  |  |