package org.example.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D06_HomeSlidersStepDef {
    P03_homePage hp = new P03_homePage(Hooks.driver);

    // Open the first slider from the home page
    @Given("open first slider from home page")
    public void open_first_slider_from_home_page() {
        hp.pressOnFirstSliderButton();
    }

    // Directs the user to the iPhone 14 Pro product details page
    @When("direct you to iphone14 pro product details page")
    public void direct_you_to_iphone14_pro_product_details_page() throws InterruptedException {hp.pressOnFirstSliderPage();}

    // Validate that the URL is correct
    @Then("validate the URL is right")
    public void validate_on_url_is_right() {hp.validateUrls();}

    // Open the second slider from the home page
    @Given("open second slider from home page")
    public void open_second_slider_from_home_page() {
        hp.pressOnSecondSliderButton();
    }

    // Directs the user to the S22Ultra product details page
    @When("direct you to S22Ultra product details page")
    public void direct_you_to_S22Ultra_product_details_page() throws InterruptedException {hp.pressOnSecondSliderPage();}

    // Validate that the URL is correct
    @Then("validate the URL")
    public void validate_on_url() {hp.validateUrls();}
}
