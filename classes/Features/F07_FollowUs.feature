# four scenarios are required "Follow Us Feature" --> project requirement  (third Scenario is not working)
@smoke
Feature:  F07_followUs | Opens Facebook Link
  Scenario:  user opens facebook link
    Given user openes facebook Link
    When user redirect to facebook page URL
    And user validate facebook link and close this tap
    Then user back to nopcommerce website and validate the url

  Scenario: user opens Twitter link
    Given user openes Twitter Link
    When user redirect to Twitter page URL
    And user validate Twitter link and close this tap
    Then user back to nopcommerce from twitter

  Scenario: user opens RSS link
    Given user openes RSS Link
    When user redirect to RSS page URL
    And user validate RSS link and close this tap
    Then user back to nopcommerce from RSS

  Scenario: user opens Youtube link
    Given user openes Youtube Link
    When user redirect to Youtube page URL
    And user validate Youtube link and close this tap
    Then user back to nopcommerce from Youtube