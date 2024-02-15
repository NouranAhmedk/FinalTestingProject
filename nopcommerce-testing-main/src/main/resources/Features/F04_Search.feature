# Two scenarios are required "Search Feature" --> project requirement
@smoke
Feature: F04_Search | users could use Search functionality to find products
  Scenario Outline: user could search using product name
    When user enters "<product>" in homepage search bar
    And user clicks on the search button
    Then search results for "<product>" are displayed
    Examples:
      | product |
      | book    |
      | laptop  |
      | nike    |

  Scenario Outline: user could search for product using sku
    When user search for "<SKU>" in homepage search bar
    And user clicks on the search button
    Then the search results for "<SKU>" product are displayed successfully
    Examples:
      | SKU       |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |