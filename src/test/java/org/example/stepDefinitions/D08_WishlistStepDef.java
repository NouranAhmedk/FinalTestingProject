package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D08_WishlistStepDef {
    P03_homePage hp = new P03_homePage(Hooks.driver);

    // Given user scrolls on the homepage and presses on HTC M8 to add it to the wishlist
    @Given("user scroll in homepage and press on HTC M8 add to wishlist")
    public void user_scroll_in_homepage_and_press_on_htc_m8_add_to_wishlist() throws InterruptedException {
        hp.addHTCM8ToWishList();
    }

    // When successful message appears
    @When("successful message will appear")
    public void successful_message_will_appear() { hp.successfulMessageWillAppear();}

    // Then validate the background color of the message
    @Then("validate on background color of the message")
    public void validate_on_background_color_of_the_message() { hp.ValidationColor();}

    // Given user adds HTC M8 to the wishlist
    @Given("user add HTC M8 to wishlist")
    public void user_Add_htc_m8_add_to_wishlist() throws InterruptedException {hp.addToWishList();}

    // When user navigates to the wishlist page
    @When("user navigate to wishlist page")
    public void user_navigate_To_Wishlist_Page() {
        hp.navigateToWishListAndValidateQuantity();
    }

    // Then validate that the quantity of the product is more than zero
    @Then("validate that qty of the product not equal zero")
    public void validate_that_qty_More_Than_Zero() {hp.validateMoreProduct();}
}

