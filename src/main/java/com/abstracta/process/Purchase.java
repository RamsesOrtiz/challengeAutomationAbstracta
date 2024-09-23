package com.abstracta.process;

import com.abstracta.config.ConfigPage;
import com.abstracta.config.LoggerPage;
import com.abstracta.utils.PropertyManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Purchase extends ConfigPage {

    private static final By productLink = By.cssSelector("a[href='prod.html?idp_=1'][class='hrefch']");
    private static final By productName = By.cssSelector("h2[class='name']");
    private static final By addToCartBtn = By.cssSelector("a[onclick='addToCart(1)']");
    private static final By cartLink = By.id("cartur");
    private static final By cartList = By.cssSelector("tr[class='success']");
    private static final By placeOrderBtn = By.cssSelector("button[class='btn btn-success']");
    private static final By totalOrder = By.id("totalm");
    private static final By nameInput = By.cssSelector("input[id='name']");
    private static final By countryInput = By.cssSelector("input[id='country']");
    private static final By cityInput = By.cssSelector("input[id='city']");
    private static final By creditCardInput = By.cssSelector("input[id='card']");
    private static final By monthInput = By.cssSelector("input[id='month']");
    private static final By yearInput = By.cssSelector("input[id='year']");
    private static final By purchaseBtn = By.cssSelector("button[onclick='purchaseOrder()']");
    private static final By confirmationMsg = By.cssSelector("div[class='sweet-alert  showSweetAlert visible']");
    private static final By greetingMsg = By.tagName("h2");

    public Purchase(WebDriver driver) {
        super(driver);
    }

    public static void selectProduct() {
        waitElement(productLink, 10);
        String productHref = getAttribute(productLink, "href");
        if (isDisplayed(productLink)) {
            click(productLink);
            waitElement(productName, 5);
            if (getCurrentUrl().contentEquals(productHref)) {
                LoggerPage.logEvent("PURCHASE", "Product successfully selected: " + getText(productName));
                screenshot("Purchase " + getText(productName));
            }
        }
    }

    public static void selectAddToCart() {
        waitElement(addToCartBtn, 5);
        if (isDisplayed(addToCartBtn)) {
            click(addToCartBtn);
            waitTime(2);
            if (isAlertPresent()) {
                LoggerPage.logEvent("PURCHASE", "Add to Cart successfully selected");
            }
        }
    }

    public static boolean isAddToCartConfirmationDisplayed() {
        if (isAlertPresent()) {
            LoggerPage.logEvent("PURCHASE", "Product Added Confirmation successfully displayed");
            screenshot("Purchase");
            acceptAlert();
            return true;
        } else {
            LoggerPage.logEvent("ERROR", "Product Added Confirmation could not be displayed");
            screenshot("Purchase Error");
            return false;
        }
    }

    /*
    Given a user goes to cart
    When select place order
    And fill the payment data
    Then the system displays a message confirmation about the purchase
     */
    public static void goToCart() {
        click(cartLink);
        waitElement(cartList, 5);
        LoggerPage.logEvent("PURCHASE", "Product successfully added to cart");
        screenshot("Product in Cart");
    }

    public static void selectPlaceOrder() {
        click(placeOrderBtn);
        waitElement(totalOrder, 5);
        LoggerPage.logEvent("PURCHASE", "Place Order successfully selected");
        screenshot("Place Order form");
    }

    public static void fillPaymentData(String name, String country, String city, String creditCard, String month, String year) {
        waitElement(nameInput, 5);
        type(nameInput, name);
        type(countryInput, country);
        type(cityInput, city);
        type(creditCardInput, creditCard);
        type(monthInput, month);
        type(yearInput, year);
        LoggerPage.logEvent("PURCHASE", "Purchase data successfully filled");
        screenshot("Purchase Data");
        click(purchaseBtn);
    }

    public static boolean isPurchaseConfirmationDisplayed() {
        waitElement(confirmationMsg, 10);
        WebElement confirmation = findElement(confirmationMsg);
        WebElement greeting = findElementInElement(confirmation, greetingMsg);
        String greetingExpected = PropertyManager.getProperty("confirmationMessage");
        if (getText(greeting).equals(greetingExpected)) {
            LoggerPage.logEvent("PURCHASE", "Purchase process successfully completed");
            screenshot("Purchase Confirmation");
            return true;
        } else {
            LoggerPage.logEvent("PURCHASE", "Purchase process could not be completed");
            screenshot("Purchase Error");
            return false;
        }
    }
}
