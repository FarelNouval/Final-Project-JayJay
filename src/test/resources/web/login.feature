@web
  Feature: Login

    Scenario: Successful login with valid credentials
      Given User is on login page
      When User enters valid username and password
      And User clicks login button
      Then User should be redirected to homepage

    Scenario: Failed login with invalid credentials
      Given User is on login page
      When User enters invalid username and password
      And User clicks login button
      Then Error message should be displayed
