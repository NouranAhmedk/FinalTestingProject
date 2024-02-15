# one scenario is required "Hover Categories Feature" --> project requirement  (both not working)
@smoke
Feature: F06_homeSliders |
  Scenario: open first slider that will direct you to iphone 14 pro product
    Given   open first slider from home page
    When    direct you to iphone14 pro product details page
    Then    validate the URL is right

  Scenario: open second slider that will direct you to S22Ultra product
    Given   open second slider from home page
    When    direct you to S22Ultra product details page
    Then    validate the URL