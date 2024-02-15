# one scenario is required "Hover Categories Feature" --> project requirement
@smoke
Feature: F05_hoverCategories | hover on main categories
  Scenario: hover on computers menu
    When user hover on computers menu in the homepage
    Then validate that list of sup categories appeared