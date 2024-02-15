package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;


public class D03_currenciesStepDef {
    P03_homePage hp =  new P03_homePage(Hooks.driver);

    @When("selects Euro currency from the currency dropdown list") // Select Currency From dropdown list
    public void select_euro_currency_from_the_dropdown_list() { hp.changeCurrency();}

    @And("scrolls down to Featured products") // Scroll to see the currency changed
    public void Scroll_down_to_See_Change() throws InterruptedException {hp.Scroll();}

    @Then("The product-currency-sign should be changed") // currency should be changed
    public void currency_should_be_changed_and_will_appear_beside_the_product_price() {hp.currency_changed();}
}
