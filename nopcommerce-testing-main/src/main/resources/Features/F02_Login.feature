# Two scenarios are required "Login Feature" --> project requirement
@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario Outline: user could login with valid email and password
    Given  user go to login page valid
    When   user login with valid "<email>" and "<password>"
    And    user press on login button valid
    Then   user login to the system successfully
    Examples:
      | email              | password |
      | testtt@example.com | P@ssw0rd |

  Scenario Outline: user could login with invalid email and password
    Given  user go to login page invalid
    When   user login with invalid "<email>" and "<password>"
    And    user press on login button invalid
    Then   user could not login to the system
    Examples:
      | email             | password |
      | wrong@example.com | P@ssw0rd |