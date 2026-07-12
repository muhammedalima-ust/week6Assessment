@api @negative
Feature: Cancel transitions and repeat-cancel rejection

  Scenario: Cancelling a placed order succeeds
    Given "alice" has a PLACED order
    When "alice" cancels that order
    Then the order status becomes "CANCELLED"

  Scenario: Cancelling twice is rejected
    Given "alice" has a PLACED order
    And "alice" cancels that order
    When "alice" cancels that order again
    Then the response status is 409
