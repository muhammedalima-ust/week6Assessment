@api @db
Feature: Cart totals equal sum of qty times price

  Scenario: Two-item cart totals correctly
    Given "alice" is logged in
    And she adds 2 x "SKU-BAG" (49900 paise each) to her cart
    Then the cart total is 99800 paise
