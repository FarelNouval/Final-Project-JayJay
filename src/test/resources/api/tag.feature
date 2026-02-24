@api
Feature: Tag API

  Scenario: Get list of tags
    When Send GET request to get list of tags
    Then Response status code should be 200