package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login lp = new P02_login(Hooks.driver);

    /*********************************************Valid-TestScenario**********************************************/
    // Step: User goes to the login page (valid)
    @Given("user go to login page valid")
    public void userGoToLoginPage() {
        lp.navigateToLoginPage();
    }

    // Step: User logs in with valid credentials
    @When("user login with valid {string} and {string}")
    public void user_login_valid_email(String email, String password) {
        lp.writeEmailText(email);
        lp.writePasswordText(password);
    }

    // Step: User presses the login button (valid)
    @And("user press on login button valid")
    public void user_press_on_loginButton() {
        lp.logInBtn();
    }

    // Step: User logs in to the system successfully
    @Then("user login to the system successfully")
    public void user_login_to_the_system_successfully() { lp.validationOfSuccessfulAccount();}

    /*********************************************invalid-TestScenario**********************************************/
    // Step: User goes to the login page (invalid)
    @Given("user go to login page invalid")
    public void user_go_to_login_page() {lp.navigateToLoginPage();}

    // Step: User logs in with invalid credentials
    @When("user login with invalid {string} and {string}")
    public void user_login_with_invalid_email(String email, String password) {
        lp.writeEmailText(email);
        lp.writePasswordText(password);
    }

    // Step: User presses the login button (invalid)
    @And("user press on login button invalid")
    public void user_press_on_login_button() {
        lp.logInBtn();
    }

    // Step: User could not Login to the system
    @Then("user could not login to the system")
    public void user_could_not_login_to_the_system() { lp.validationOfUnSuccessfulAccount();}
}

