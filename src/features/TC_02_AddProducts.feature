#Author: Jayesh
#Keywords Summary :
#Feature: Add product page
#Scenario: validate product page on web site
#Given:
#When:
#Then:
#And,But:

Feature: Validate add product page
  As a user we can enter add product details, after that display those details into table format.
  User can update and delete those details.
  User can see those details into web site.
  Valid: Verify that User can enter valid inputs
  Invalid: Verify that user can enter invalid inputs

  Scenario: validate top level and Mid level category
    Given Open Add product management menu
    And Open Add product form
    When User can click on top level category input
    Then validate list of top level category

  Scenario Outline: validate add product form with invalid inputs
    Given add product form is open
    When Scroll to Add product button
    And Click on Add product button
    Then display an error message as "<errormessages>"

    Examples:
      | errormessages                                |
      | You must have to select a top level category |

  Scenario Outline: validate add product form with valid inputs
    Given add product form is open
    When user select top level cat as "<toplevelcat>"
    And user select mid level cat as "<midlevelcat>"
    And user select end level cat as "<endlevelcat>"
    And user enter product name as "<productName>"
    And user enter old price as "<oldprice>"
    And user enter new price as "<newprice>"
    And user enter quantity as "<quantity>"
    And user select size as "<size>"
    And user select colour as "<colour>"
    And user select feature photo as "<featurePhoto>"
    And user select other photo as "<otherPhoto>"
    And user enter description as "<description>"
    And user enter short description as "<shortDesc>"
    And user enter feature as "<features>"
    And user enter condition as "<condition>"
    And user enter return polity as "<returnpolicy>"
    And user select feature as "<isfeature>"
    And user select active as "<isactive>"
    When Scroll to Add product button
    And Click on Add product button only once
    Then display success message as "Product is added successfully."

    Examples:
      | toplevelcat | midlevelcat | endlevelcat           | productName  | oldprice | newprice | quantity | size | colour | featurePhoto | otherPhoto | description    | shortDesc     | features     | condition     | returnpolicy     | isfeature | isactive |
      | Electronics | Computers   | Computers and Tablets | test Product | 30       | 40       | 4        | S    | Red    | featureP     | OtherP     | description123 | shortDesc 123 | features 123 | condition 123 | returnpolicy 123 | Yes       | Yes      |

  Scenario Outline: validate product information with valid data
    Given click on view all button
    When open add product table
    Then validate product name as "<productName>"
#    Then validate old proce as "<oldprice>"
#    Then validate price as "<newprice>"
#    Then validate quantity as "<quantity>"
#    Then validate category as "<toplevelcat>" as "<midlevelcat>" as "<endlevelcat>"
    Examples:
      | toplevelcat | midlevelcat | endlevelcat           | productName  | oldprice | newprice | quantity |  |  |  |  |  |  |  |  |  |  |  |
      | Electronics | Computers   | Computers and Tablets | test Product | 30       | 40       | 4        |  |  |  |  |  |  |  |  |  |  |  |

  Scenario Outline: validate update product form with valid inputs
    Given update product form should be open
    When user select top level cat as "<toplevelcat>"
    And user select mid level cat as "<midlevelcat>"
    And user select end level cat as "<endlevelcat>"
    And user enter product name as "<productName>"
    And user enter old price as "<oldprice>"
    And user enter new price as "<newprice>"
    And user enter quantity as "<quantity>"
    And user select size as "<size>"
    And user select colour as "<colour>"
#    And user select feature photo as "<featurePhoto>"
#    And user select other photo as "<otherPhoto>"
    And user enter description as "<description>"
#    And user enter short description as "<shortDesc>"
    And user enter feature as "<features>"
    And user enter condition as "<condition>"
    And user enter return polity as "<returnpolicy>"
    And user select feature as "<isfeature>"
    And user select active as "<isactive>"
    When Scroll to update product button
    And Click on update product button only once
    Then display success message as "Product is updated successfully."

    Examples:
      | toplevelcat | midlevelcat | endlevelcat | productName         | oldprice | newprice | quantity | size | colour | featurePhoto | otherPhoto | description        | shortDesc        | features                    | condition        | returnpolicy  | isfeature | isactive |
      | Kids        | Clothing    | Boys        | update test Product | 40       | 45       | 5        | XL   | Green  | featureP     | OtherP     | update description | update shortDesc | update features description | update condition | update policy | No        | No       |

  Scenario: delete product form table
    Given click on view all button
    When open add product table
    Then click on delete button
    Then display delete confirmation form
    Then validate delete confirmation title as "Are you sure want to delete this item?"
    Then validate delete confirmation description as "Be careful! This product will be deleted from the order table, payment table, size table, color table and rating table also."
    Then Click on delete button for confirmation form