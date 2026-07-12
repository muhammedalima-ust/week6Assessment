@api @negative
Feature: Adding more than available stock is rejected

  Scenario: Requesting quantity greater than stock fails
    Given "bob" is logged in
    When "bob" adds 1 * "SKU-CAP" to a new cart
    Then the response status is 409