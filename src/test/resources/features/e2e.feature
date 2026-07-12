@smoke
@e2e
Feature: Checkout E2E

  Scenario Outline: Login-search-add-cart-checkout-PLACED
    Given user is on the homepage
    When user clicks on Sign in button
    Then Login Page appeared
    When User inputs "bob" and her password
    And Click on Sign in
    When user searches for "Bag"
    Then product "Bag" should be displayed
    And Product API should return "Bag"
    When Clicked on first product
    And Clicked on add to cart
    And Click on checkout
    And Enter Address "123456789123456789"
    And Click on PlaceOrder
    Then Verify the Status is placed and address is "123456789123456789"
