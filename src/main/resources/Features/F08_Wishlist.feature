# Two  scenarios are required --> project requirement
@smoke
Feature:F08_Wishlist | add to Wishlist
  Scenario: add HTC One M8 Android L 5.0 Lollipop to wishlist
    Given   user scroll in homepage and press on HTC M8 add to wishlist
    When    successful message will appear
    Then    validate on background color of the message

  Scenario: validate product qty in wishlist page
    Given   user add HTC M8 to wishlist
    When    user navigate to wishlist page
    Then    validate that qty of the product not equal zero