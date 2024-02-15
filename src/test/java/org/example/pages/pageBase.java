package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class pageBase {
    /*********************************************GLOBAL_VARIABLES*******************************************/
    protected WebDriver driver;
    private JavascriptExecutor js ;
    private  Select select;
    private WebDriverWait wait ;
    private Actions action ;
    SoftAssert softAssert = new SoftAssert();
    /*********************************************CONSTRUCTORS**********************************************/
    protected pageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /*********************************************COMMON_USER_ACTIONS**********************************************/
    protected void clickElement(WebElement ele){
        ele.click();
    }
    protected void writeTxt(WebElement ele, String text){
        ele.sendKeys(text);
    }

    /*********************************************EXPLICIT_WAIT**********************************************/
    protected void waitEleByVisibility(WebElement ele , int sec){
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    /*****************************************USER_ADVANCED_ACTIONS**********************************************/
    protected void hoverEle(WebElement ele){
        action = new Actions(driver);
        action.moveToElement(ele).perform();
    }
    /*********************************************JS_INJECTION**********************************************/
    protected void jsScrollToElement(WebElement ele){
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",ele);
    }
    /*********************************************SELECT**********************************************/
    protected void selectByVisibleText (WebElement ele , String visibleText) {
        select = new Select(ele);
        select.selectByVisibleText(visibleText);
    }

}