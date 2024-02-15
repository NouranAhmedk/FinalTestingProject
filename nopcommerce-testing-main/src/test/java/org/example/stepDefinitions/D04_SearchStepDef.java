package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;


public class D04_SearchStepDef {
    P03_homePage hp = new P03_homePage(Hooks.driver);

    @When("user enters {string} in homepage search bar")
    public void user_enters_product_in_search_bar(String product) {
        hp.enterProductInSearchBar(product);
    }

    @And("user clicks on the search button")
    public void user_clicks_on_the_search_button() {
        hp.clickSearchButton();
    }
    @Then("search results for {string} are displayed")
    public void search_results_for_product_are_displayed(String product) {
        hp.searchResultsForSearchProduct(product);
    }

    @When("user search for {string} in homepage search bar")
    public void user_search_for_SKU(String SKU){
        hp.enterProductInSearchBar(SKU);
    }

    @Then("the search results for {string} product are displayed successfully")
    public void the_search_results_for_SKU_product_are_displayed_successfully(String SKU){
        hp.searchResultsForSKUProduct(SKU);
    }
}
