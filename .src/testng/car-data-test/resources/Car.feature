Feature: Car

  Scenario: Get car price
    When Car created
    Then Car price should be 0.0

  Scenario: Get car year
    Then Car year should be 0

  Scenario: Get car model
    Then Car model should be test

  Scenario: Get car make
    Then Car make should be test
