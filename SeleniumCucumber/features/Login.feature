Feature: Login Feature

  Scenario: Successfully login with valid credentials
    Given launch the chrome browser
    When open URL "https://admin-demo.nopcommerce.com"
    And enter Email as "admin@yourstore.com" and Password as "admin"
    And click login button
    Then the page title should be "Dashboard / nopCommerce administration"
    When click log out button
    Then the page title should be "Your store. Login"
    And close browser

    Scenario Outline: Login Data Driven
      Given launch the chrome browser
      When open URL "https://admin-demo.nopcommerce.com"
      And enter Email as "<email>" and Password as "<password>"
      And click login button
      Then the page title should be "Dashboard / nopCommerce administration"
      When click log out button
      Then the page title should be "Your store. Login"
      And close browser

      Examples:
      |email|password|
      |  admin@yourstore.com   |   admin     |
      |  admin1@yourstore.com   |   admin123     |