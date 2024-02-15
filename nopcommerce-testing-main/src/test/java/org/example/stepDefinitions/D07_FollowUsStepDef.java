package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D07_FollowUsStepDef {
    P03_homePage hp = new P03_homePage(Hooks.driver);
    // Given user opens Facebook Link
    @Given("user openes facebook Link")
    public void user_openes_facebook_link() throws InterruptedException {hp.pressOnFollowUsOnFaceBook();}

    // When user redirects to Facebook page URL
    @When("user redirect to facebook page URL")
    public void user_redirect_to_facebook_page_url() throws InterruptedException {hp.handleSecondPage();}

    // And user validates Facebook link and closes this tab
    @And("user validate facebook link and close this tap")
    public void user_validate_facebook_link_and_close_this_tap() {hp.validateSocialMediaUrls();}

    // Then user goes back to nopCommerce website and validates the URL
    @Then("user back to nopcommerce website and validate the url")
    public void user_back_to_nopcommerce_website_and_validate_the_url() {hp.closeSecondOpenedPages();}

    // Given user opens Twitter Link
    @Given("user openes Twitter Link")
    public void user_openes_Twitter_link() throws InterruptedException {hp.pressOnFollowUsOnTwitter();}

    // When user redirects to Twitter page URL
    @When("user redirect to Twitter page URL")
    public void user_redirect_to_Twitter_page_url() throws InterruptedException {hp.handleSecondPage();}

    // And user validates Twitter link and closes this tab
    @And("user validate Twitter link and close this tap")
    public void user_validate_Twitter_link_and_close_this_tap() {hp.validateSocialMediaUrls();}

    // Then user goes back to nopCommerce from Twitter
    @Then("user back to nopcommerce from twitter")
    public void user_back_to_nopcommerce_from_twitter() {hp.closeSecondOpenedPages();}


    // Given user opens RSS Link
    @Given("user openes RSS Link")
    public void user_openes_RSS_link() throws InterruptedException {hp.pressOnFollowUsOnRss();}

    // When user redirects to RSS page URL
    @When("user redirect to RSS page URL")
    public void user_redirect_to_RSS_page_url() throws InterruptedException {hp.handleSecondPage();}

    // And user validates RSS link and closes this tab
    @And("user validate RSS link and close this tap")
    public void user_validate_RSS_link_and_close_this_tap() {hp.validateSocialMediaUrls();}

    // Then user goes back to nopCommerce from RSS
    @Then("user back to nopcommerce from RSS")
    public void user_back_to_nopcommerce_from_RSS() {hp.closeSecondOpenedPages();}


    // Given user opens Youtube Link
    @Given("user openes Youtube Link")
    public void user_openes_Youtube_link() throws InterruptedException {hp.pressOnFollowUsOnYouTube();}

    // When user redirects to YouTube page URL
    @When("user redirect to Youtube page URL")
    public void user_redirect_to_Youtube_page_url() throws InterruptedException {hp.handleSecondPage();}

    // And user validates YouTube link and closes this tab
    @And("user validate Youtube link and close this tap")
    public void user_validate_Youtube_link_and_close_this_tap() {hp.validateSocialMediaUrls();}

    // Then user goes back to nopCommerce from YouTube
    @Then("user back to nopcommerce from Youtube")
    public void user_back_to_nopcommerce_from_Youtube() {hp.closeSecondOpenedPages();}

}
