# one scenario is required "Currencies Feature" --> project requirement
@smoke
Feature: F03_currencies | Change currency
  Scenario: users could choose their currency successfully
    When  selects Euro currency from the currency dropdown list
    And   scrolls down to Featured products
    Then  The product-currency-sign should be changed