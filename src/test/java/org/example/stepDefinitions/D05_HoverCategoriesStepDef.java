package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;

public class D05_HoverCategoriesStepDef {
    P03_homePage hp = new P03_homePage(Hooks.driver);

    // Step: Hover on computers menu
    @When("user hover on computers menu in the homepage")
    public void user_hoover_on_computers_menu() {hp.hoverOnComputersMenu();}

    // Step: Validate that list of subcategories appeared
    @Then("validate that list of sup categories appeared")
    public void validate_that_list_of_sup_categories_appeared() {hp.validateExpectedResult();}
}
