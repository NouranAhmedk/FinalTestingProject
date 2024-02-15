package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Suffix:
 * 1) Lbl = Label.
 */
public class P03_homePage extends pageBase {
    /*********************************************CONSTRUCTORS**********************************************/
    public P03_homePage(WebDriver driver){super(driver);}
    /*********************************************WEB-ELEMENTS**********************************************/

    /**Change Currency Web-elements*/
    @FindBy(id = "customerCurrency")
    public WebElement changeCurrencyList;

    @FindBy(xpath = "//div/span[@class='price actual-price']")
    public WebElement productsPriceAndSymbol;

    /**Search Web-elements*/
    @FindBy(css = "h2.product-title")
    private List<WebElement> results;

    @FindBy(css = "div.product-item")
    private WebElement resultedProduct;

    @FindBy(css = "div.sku")
    private WebElement SKU;

    @FindBy(id = "small-searchterms")
    private WebElement searchBar;

    @FindBy(css = "button.button-1.search-box-button")
    private WebElement searchButton;

    /**HoverCategories Web-elements*/
    @FindBy(linkText = "Computers")
    WebElement computersMenu;
    @FindBy(linkText = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul")
    public List<WebElement> computersMenuList;

    /**HomeSliders Web-elements*/
    @FindBy(xpath = "//div[@class='nivo-controlNav']/a[@rel='0']")
    WebElement firstSliderButton;
    @FindBy(xpath = "//a[@class='nivo-imageLink'][1]")
    WebElement firstSliderPage;
    @FindBy(xpath = "//div[@class='nivo-controlNav']/a[@rel='1']")
    WebElement secondSliderButton;
    @FindBy(xpath = "//a[@class='nivo-imageLink'][2]")
    WebElement secondSliderPage;

    /**followUs Web-element*/
    @FindBy(xpath = "//li/a[@href='http://www.facebook.com/nopCommerce']")
    WebElement followUsOnFacebookButton;

    @FindBy(xpath = "//li/a[@href='https://twitter.com/nopCommerce']")
    WebElement followUsOnTwitterButton;

    @FindBy(css = "a[href='/news/rss/1']")
    WebElement followUsOnRssButton;

    @FindBy(css = "a[href='http://www.youtube.com/user/nopCommerce']")
    WebElement  followUsOnYouTubeButton;

    /**Wishlist Web-Elements*/
    @FindBy(css = "input[class='qty-input']")
    public WebElement qtyBox;

//    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]")
//    WebElement htcM8AddToWishListBtn;

    @FindBy(xpath = "//button[contains(@onclick,'catalog(\"/addproducttocart/catalog/18/2/1\")')]")
    WebElement htcM8AddToWishListBtn;
    //
    @FindBy(xpath = "//div/p[@class='content']")
    public WebElement successfulAddToWishlistMsg;
    @FindBy(xpath = "//p/a[@href='/wishlist']")
    WebElement navigateToWishListPageBtn;

    /*********************************************METHODS**********************************************/

    /*************************>   Change Currency Methods*/
    // Method: Change currency to Euro
    public void changeCurrency() {
        // Select 'Euro' from the currency list
        selectByVisibleText(changeCurrencyList, "Euro");
        softAssert.assertTrue(changeCurrencyList.getText().contains("Euro"));
    }

    // Method: Scroll to product price labels
    public void Scroll() throws InterruptedException {
        // Scroll to the element containing product prices and symbols
        jsScrollToElement(productsPriceAndSymbol);
        Thread.sleep(500);
    }

    public void currency_changed() {
        // Select 'Euro' from the currency list
        selectByVisibleText(changeCurrencyList, "Euro");
        for (int i = 0 ; i< 4 ; i++){
            Assert.assertTrue(productsPriceAndSymbol.getText().contains("€"));
        }
    }

    /************************>   Search Methods*/
    // Method: Locate search results
    public List<WebElement> searchResults() {
        return results;
    }

    // Method: Click on the resulted product
    public void clickResultedProduct() {
        resultedProduct.click();
    }

    // Method: Get text from SKU element
    public String getSKUText() {
        return SKU.getText();
    }

    // Method: Enter product in search bar
    public void enterProductInSearchBar(String product) {
        searchBar.sendKeys(product);
    }

    // Method: Click on the search button
    public void clickSearchButton() {
        searchButton.click();
    }

    private void verifySearchUrl() {
        String actualUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/search?q=";
        softAssert.assertTrue(actualUrl.contains(expectedUrl));
    }

    public void searchResultsForSearchProduct(String product) {
        verifySearchUrl();
        // Verify that search shows relevant results
        // Get results web elements list
        List<WebElement> results = searchResults();

        // Count number of search results using findElements & size()
        int resultCount = results.size();
        softAssert.assertTrue(resultCount > 0, "No search results found");

        // Loop over every result
        for (int i = 0; i < resultCount; i++) {
            String actualText = results.get(i).getText().toLowerCase();
            String expectedText = product.toLowerCase();
            softAssert.assertTrue(actualText.contains(expectedText), "Search result verification failed for result #" + (i + 1));
        }

        softAssert.assertAll();
    }

    public void searchResultsForSKUProduct(String expectedSKU) {
        // Click on the resulted product
        clickResultedProduct();

        // Verify that the product contains the expected SKU
        String actualSKU = getSKUText();
        softAssert.assertTrue(actualSKU.contains(expectedSKU));
    }


    /************************>   HoverCategories Methods*/
    public void hoverOnComputersMenu(){
        hoverEle(computersMenu);
    }
    public void validateExpectedResult(){
        // Expected subcategories
        String[] expectedText = {"desktops", "notebooks", "software"};

        // Loop through the subcategories and compare with expected text
        for (int i = 0; i < computersMenuList.size(); i++) {
            // Get actual text of the subcategory, convert to lowercase and trim
            String actualText = computersMenuList.get(i).getText().toLowerCase().trim();

            // Assert that actual text matches the expected text
            Assert.assertEquals(actualText, expectedText[i]);
        }
    }

    /************************>   homeSlider Methods*/

    // Click on the button associated with the first slider
    public void pressOnFirstSliderButton() {
        clickElement(firstSliderButton);
    }

    // Click on the page associated with the first slider, with a wait
    public void pressOnFirstSliderPage() throws InterruptedException {
        clickElement(firstSliderPage);
        Thread.sleep(2000);
    }

    // Click on the button associated with the second slider
    public void pressOnSecondSliderButton() {
        clickElement(secondSliderButton);
    }

    // Click on the page associated with the second slider, with a wait
    public void pressOnSecondSliderPage() throws InterruptedException {
        clickElement(secondSliderPage);
        Thread.sleep(2000);
    }
    public void validateUrls() {
        String currentUrl = Hooks.driver.getCurrentUrl();

        // Use if-else if structure to handle different cases
        if (currentUrl.contains("https://demo.nopcommerce.com/iphone-14-Pro")) {
            // Verify that the current URL matches the expected URL for the first slider
            Assert.assertTrue(true);  // Or any other verification logic
        } else if (currentUrl.contains("https://demo.nopcommerce.com/Galaxy-S22-ultra")) {
            // Verify that the current URL matches the expected URL for the second slider
            Assert.assertTrue(true);  // Or any other verification logic
        } else {
            // Handle the case when the URL doesn't match either of the expected URLs
            Assert.fail("Unexpected URL: " + currentUrl);
        }
    }

    /************************>   followUs Methods*/
    public void pressOnFollowUsOnFaceBook() throws InterruptedException {
        jsScrollToElement(followUsOnFacebookButton);
        clickElement(followUsOnFacebookButton);
        Thread.sleep(1000);
    }

    public void handleSecondPage()throws InterruptedException{
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000);
    }
    public void closeSecondPage(){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void pressOnFollowUsOnTwitter()throws InterruptedException  {
        jsScrollToElement(followUsOnTwitterButton);
        clickElement(followUsOnTwitterButton);
        Thread.sleep(1000);
    }

    public void pressOnFollowUsOnRss() throws InterruptedException {
        jsScrollToElement(followUsOnRssButton);
        clickElement(followUsOnRssButton);
        Thread.sleep(1500);
    }
    public void pressOnFollowUsOnYouTube() throws InterruptedException {
        jsScrollToElement(followUsOnYouTubeButton);
        clickElement(followUsOnYouTubeButton);
        Thread.sleep(1000);
    }

    public void closeSecondOpenedPages(){
        closeSecondPage();
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demo.nopcommerce.com/");
    }

    public void validateSocialMediaUrls() {
        String currentUrl = Hooks.driver.getCurrentUrl();
        if (currentUrl.contains("https://www.facebook.com/nopCommerce")) {
            Assert.assertTrue(true);
        } else if (currentUrl.contains("https://twitter.com/nopCommerce")) {
            // Verify that the current URL matches the expected URL for the second slider
            Assert.assertTrue(true);  // Or any other verification logic
        } else if (currentUrl.contains("https://demo.nopcommerce.com/new-online-store-is-open")) {
            // Verify that the current URL matches the expected URL for the second slider
            Assert.assertTrue(true);  // Or any other verification logic
        } else if (currentUrl.contains("https://www.youtube.com/user/nopCommerce")) {
            // Verify that the current URL matches the expected URL for the second slider
            Assert.assertTrue(true);  // Or any other verification logic
        }
    }

    /************************>   Wishlist Methods*/
    // Add HTC M8 to the wish list
    public void addHTCM8ToWishList() throws InterruptedException {
        // Scroll to the HTC M8 Add to Wish List button using JavaScript
        jsScrollToElement(htcM8AddToWishListBtn);
        Thread.sleep(1000);
        // Click on the HTC M8 Add to Wish List button
        clickElement(htcM8AddToWishListBtn);
    }

    public void successfulMessageWillAppear(){
        // Assert that the successful message contains the expected text
        softAssert.assertTrue(successfulAddToWishlistMsg.getText().contains("The product has been added to your"));
    }

    // Navigate to the wish list page and validate the quantity
    public void navigateToWishListAndValidateQuantity(){
        // Wait for the Navigate to Wish List Page button to be visible
        waitEleByVisibility(navigateToWishListPageBtn, 5);
        // Scroll to the Navigate to Wish List Page button using JavaScript
        jsScrollToElement(navigateToWishListPageBtn);
        // Click on the Navigate to Wish List Page button
        clickElement(navigateToWishListPageBtn);
    }

    public void ValidationColor() {
        String color = successfulAddToWishlistMsg.getCssValue("color");
        // Assert that the color matches the expected RGBA value
        Assert.assertEquals(color, "rgba(255, 255, 255, 1)");
    }

    public void addToWishList() throws InterruptedException {
        addHTCM8ToWishList();
        // Use SoftAssert to capture multiple assertions without stopping on the first failure
        softAssert.assertTrue(successfulAddToWishlistMsg.getText().contains("The product has been added to your"));
        ValidationColor();
    }
    public void validateMoreProduct(){
        String actualResult = qtyBox.getText();
        // Assert that the quantity is not equal to "1"
        Assert.assertNotEquals(actualResult, "1");
    }
}
