# one scenario is required "Registration Feature" --> project requirement
@smoke
  Feature: F01_Register | users could register with new account
    Scenario Outline: guest user could register with valid data successfully
      Given user go to register page
      And user select gender type
      And user enter "<firstName>" and "<lastName>"
      And  user enter date of birth
      And  user enter "<email>" field
      And  user fills Password fields "<password>"
      When  user clicks on register button
      Then success message is displayed
      Examples:
        | firstName  | lastName | email              | password |
        | automation | Tester   | testtt@example.com | P@ssw0rd |
