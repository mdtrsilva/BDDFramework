Feature: Customers

#  Scenario: Add A New Customer
#    Given launch the chrome browser
#    When open URL "https://admin-demo.nopcommerce.com"
#    And enter Email as "admin@yourstore.com" and Password as "admin"
#    And click login button
#    Then user can view dashboard
#    When click on customers menu
#    And click on customers menu item
#    And click on Add new button
#    Then user can vew Add new customer page
#    When enter customer info
#    And click on save button
#    Then user can view confirmation message "The new customer has been added successfully."
#    And close browser

    Scenario: Search Customer by EmailId
      Given launch the chrome browser
      When open URL "https://admin-demo.nopcommerce.com"
      And enter Email as "admin@yourstore.com" and Password as "admin"
      And click login button
      Then user can view dashboard
      When click on customers menu
      And click on customers menu item
      And enter customer email
      When click on search button
      Then user should be able to find the email in the search table
      And close browser
