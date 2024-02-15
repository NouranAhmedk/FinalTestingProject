package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Objects;

/**
 * Suffix:
 * 1) Btn = Button.
 * 2) Txt = Text.
 * 3) Msg = Message.
 */
public class P02_login extends pageBase {
    /*******************************************Constructor*******************************************/
    public P02_login(WebDriver driver){
        super(driver);
    }
    /*******************************************Elements*******************************************/
    @FindBy(xpath = "//li/a[@href='/login?returnUrl=%2F']")
    WebElement loginPageBtn;
    @FindBy(partialLinkText= "My account") // Alternative answer :   @FindBy(xpath = "//li/a[@class='ico-account']")
    public WebElement myAccountBtn;
    @FindBy(xpath = "//div/input[@class='email']")
    WebElement emailTxt;
    @FindBy(xpath = "//div/input[@class='password']")
    WebElement passwordTxt;
    @FindBy(xpath ="//div/input[@type='checkbox']" )
    WebElement rememberMeCheckBox;
    @FindBy(xpath = "//div/button[@type='submit']") // Alternative answer :   @FindBy(xpath = "//button[@class=\"button-1 login-button\")
    WebElement loginBtn;
    @FindBy(xpath = "//div/h1")
    public WebElement loginPageWelcomeMsg;
    @FindBy(css = "div[class='message-error validation-summary-errors']")
    public WebElement validationMsg;


    /*******************************************Methods*******************************************/
    // Method to navigate to the login page
    public void navigateToLoginPage() {
        clickElement(loginPageBtn);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
        softAssert.assertTrue(loginPageWelcomeMsg.getText().contains("Welcome, Please Sign In!"));
    }

    // Method to write email text
    public void writeEmailText(String emailData) {
        writeTxt(emailTxt, emailData);
    }

    // Method to write password text
    public void writePasswordText(String passData) {
        writeTxt(passwordTxt, passData);
    }

    // Method to click on remember me CheckBox --> Will not be tested
    public void pressOnRememberMe(){
        rememberMeCheckBox.click();
    }

    // Method to click the login button
    public void logInBtn() {
        waitEleByVisibility(loginBtn, 20);
        clickElement(loginBtn);
    }

    //------------------------> try again --------------------------->
    public void validationOfSuccessfulAccount() {
        Assert.assertEquals(myAccountBtn.getText(),"My account");
    }
    public void validationOfUnSuccessfulAccount() {
        Assert.assertTrue(validationMsg.getText().contains("Login was unsuccessful. Please correct the errors and try again."));
        String color = validationMsg.getCssValue("color");
        Assert.assertEquals(color,"rgba(228, 67, 75, 1)");  //output will be #e4434b
    }
}
