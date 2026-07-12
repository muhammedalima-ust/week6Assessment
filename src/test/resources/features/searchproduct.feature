@smoke
@ui
@api
Feature: Product Search

  Scenario: Verify product search
    Given user is on the homepage
    When user searches for "Bag"
    Then product "Bag" should be displayed
    And Product API should return "Bag"
