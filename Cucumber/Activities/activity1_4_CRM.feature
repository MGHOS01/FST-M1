@activity1_4_CRM

Feature: To Add a product
 
  Scenario: Creating a product with example table
    Given The user is at welcome page to login
    And The User enters"<Username>"and"<Password>"
    When User navigates to All option
    And Select the Product option
    And Clicks on Create Product option
    And User  enters product name as"<ProductName>"
    And Enter other details as"<Price>"to Save the Product
    Then Navigates to the View Products Page 
    And Exit from browser

Examples:
    | Username | Password |ProductName |Price |
    | admin    | pa$$w0rd |Product2604 |Rs.422   |