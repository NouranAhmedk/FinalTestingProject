package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * Suffix:
 * 1) Btn = Button.
 * 2) Txt = Text.
 */
public class P01_register extends pageBase {
    /*******************************************Constructor*******************************************/
    public P01_register(WebDriver driver){
        super(driver);
    }

    /*******************************************Elements*******************************************/
    @FindBy(xpath = "//li/a[@href='/register?returnUrl=%2F']")
    WebElement regPageBtn;
    @FindBy(id = "gender-female")
    WebElement genderSelect;
    @FindBy(id = "FirstName")
    WebElement firstNameTxt;
    @FindBy(id = "LastName")
    WebElement lastNameTxt;
    @FindBy(id = "Email")
    WebElement emailTxt;
    @FindBy(css ="select[name=DateOfBirthDay]" )
    WebElement DateOfBirthDay;
    @FindBy(css = "select[name=DateOfBirthMonth]")
    WebElement DateOfBirthMonth;
    @FindBy(css = "select[name=DateOfBirthYear]")
    WebElement DateOfBirthYear;
    @FindBy(id = "Password")
    WebElement passwordTxt;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxt;
    @FindBy(id = "register-button")
    WebElement regKeyBtn;
    @FindBy(css = "div.result")
    public WebElement regSuccessfully;
    /*******************************************Variables*****************************************/
    int min = 1;
    int max;
    int random_result;

    /*******************************************Methods*******************************************/
    // Method to navigate to the registration page
    public void enterRegPage() {
        clickElement(regPageBtn);
    }

    // Method to select gender
    public void selectGender() {
        clickElement(genderSelect);
    }

    // Method to enter first name
    public void enterFirstName(String firstName) {
        clickElement(firstNameTxt);
        writeTxt(firstNameTxt, firstName);
    }

    // Method to enter last name
    public void enterLastName(String lastName) {
        clickElement(lastNameTxt);
        writeTxt(lastNameTxt, lastName);
    }

    // Method to select an option from a dropdown by index
    private void selectDropdownByIndex(WebElement dropdown, int index) throws InterruptedException {
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByIndex(index);
        Thread.sleep(1000);
    }

    // Method to select a random day from the Day dropdown
    public void selectRandomDay() throws InterruptedException {
        max = 31;
        random_result = (int) Math.floor(Math.random() * (max - min + 1) + min);
        selectDropdownByIndex(DateOfBirthDay, random_result);
    }

    // Method to select a random month from the Month dropdown
    public void selectRandomMonth() throws InterruptedException {
        max = 12;
        random_result = (int) Math.floor(Math.random() * (max - min + 1) + min);
        selectDropdownByIndex(DateOfBirthMonth, random_result);
    }

    // Method to select a random year from the Year dropdown
    public void selectRandomYear() throws InterruptedException {
        max = 110;
        random_result = (int) Math.floor(Math.random() * (max - min + 1) + min);
        selectDropdownByIndex(DateOfBirthYear, random_result);
    }


    // Method to enter email
    public void enterEmail(String email) {
        clickElement(emailTxt);
        writeTxt(emailTxt, email);
    }

    // Method to enter password and confirm password
    public void enterPassword(String password) {
        clickElement(passwordTxt);
        writeTxt(passwordTxt, password);
        clickElement(confirmPasswordTxt);
        writeTxt(confirmPasswordTxt, password);
    }

    // Method to press the Register button
    public void pressOnRegisterBtn() {
        clickElement(regKeyBtn);
    }

    public void CheckRegisterBtn(){
        softAssert.assertTrue(regSuccessfully.getText().contains("Your registration completed"));
        String color = regSuccessfully.getCssValue("color");
        softAssert.assertEquals(color, "rgba(76, 177, 124, 1)");
    }

}