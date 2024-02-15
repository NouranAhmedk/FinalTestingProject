package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    P01_register rp = new P01_register(Hooks.driver);

    // Step: User goes to the register page
    @Given("user go to register page")
    public void user_go_to_register_page() {
        rp.enterRegPage();
    }

    // Step: User selects gender type
    @And("user select gender type")
    public void user_select_gender_type() {
        rp.selectGender();
    }

    // Step: User enters first name and last name
    @And("user enter {string} and {string}")
    public void user_enter_first_name_and_last_name(String firstName, String lastName) {
        rp.enterFirstName(firstName);
        rp.enterLastName(lastName);
    }

    // Step: User enters date of birth
    @And("user enter date of birth")
    public void user_enter_date_of_birth() throws InterruptedException {
        rp.selectRandomDay();
        rp.selectRandomMonth();
        rp.selectRandomYear();
    }

    // Step: User enters email field
    @And("user enter {string} field")
    public void user_enter_email_field(String email) {
        rp.enterEmail(email);
    }

    // Step: User fills password fields
    @And("user fills Password fields {string}")
    public void user_fills_password_fields(String password) {
        rp.enterPassword(password);
    }

    // Step: User clicks on register button
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        rp.pressOnRegisterBtn();
    }

    // Step: Success message is displayed
    @Then("success message is displayed")
    public void success_message_is_displayed() {
        rp.CheckRegisterBtn();
    }
}