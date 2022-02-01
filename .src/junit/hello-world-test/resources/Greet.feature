Feature: Greet

  Scenario: Get greeting
    When say
    Then greeting should be hello world
