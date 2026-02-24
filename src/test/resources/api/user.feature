@api
Feature: User API

  Scenario: Create and Get User
    When Send POST request to create user
    Then Response status code should be 200
    And Save created user id

    When Send GET request using created user id
    Then Response status code should be 200