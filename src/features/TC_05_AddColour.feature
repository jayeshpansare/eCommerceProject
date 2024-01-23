#Author: Jayesh
#Keywords Summary :
#Feature: Dashboard page
#Scenario: validate  colour page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate colour page
  As a user can add/update/delete colour into admin and
  validate that colour on table view as well as on add product form
  @run
  Scenario: validate colour sections
    Given open view colour page
    And validate title will be "View Colors"
    When user click on Add new button
    Then validate form title as "Add Color"
    And validate colour form label as "Color Name *"

  @run
  Scenario Outline: validate add colour section with invalid inputs
    Given settion sub menu form must be open and title as "Add Color"
    When user enter colour name as "<colourName>"
    When click on submit button for setting form
    Then display and error message as "<successMsg>"
    Examples:
    |colourName| successMsg|
    |          | Color Name can not be empty |
    |testcolour|Color is added successfully.|

   @run
   Scenario: validate colour on table
     Given click on view all button
     Given validate title will be "View Colors"
     When validate the colour present into table "testcolour"
     Then click on edit button for colurname "testcolour"

    @run
   Scenario: validate update colour section with invalid inputs
     Given settion sub menu form must be open and title as "Edit Color"
     When user enter colour name as ""
     When click on update button for setting form
     Then display and error message as "Color Name can not be empty"

    @run
    Scenario Outline: validate update colour section with valid inputs
      Given settion sub menu form must be open and title as "Edit Color"
      When user enter colour name as "<colourName>"
      When click on update button for setting form
      Then display and error message as "<successMsg>"
      Examples:
        |colourName| successMsg|
        |testcolourupdate|Color is updated successfully.|

  @run
  Scenario: validate colour on table
    Given click on view all button
    And validate title will be "View Colors"
    When validate the colour present into table "testcolourupdate"
    Then click on edit button for colurname "testcolourupdate"

  @run
  Scenario: validate delete button on table
    Given click on view all button
    And validate title will be "View Colors"
    When validate the colour present into table "testcolourupdate"
    Then click on delete button for colour for colurname "testcolourupdate"
    And validate delete colour confirmation popup title as "Delete Confirmation"
    And validate delete colour confirmation popup description as "Are you sure want to delete this item?"
    And click on delete button on colour popup



