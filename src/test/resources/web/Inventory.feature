@web
  Feature: Inventory functionality

    Background:
      Given User is logged in successfully

    Scenario: Add product to cart
      When User adds "Sauce Labs Backpack" to cart
      Then Cart badge should show 1 item

    Scenario: Filter product by price low to high
      When User selects filter "Price (low to high)"
      Then Products should be sorted by lowest price first

    Scenario: Filter product by name Z to A
      When User selects filter "Name (Z to A)"
      Then Products should be sorted in descending order

    Scenario: User Logout
      When User logs out from application
      Then User should be redirected to login page