package com.abstracta.defs;

import com.abstracta.process.Purchase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.abstracta.utils.PropertyManager.getProperty;

public class PurchaseTest {

    @Given("a user goes to cart")
    public void a_user_goes_to_cart() {
        Purchase.goToCart();
    }

    @When("select place order")
    public void select_place_order() {
        Purchase.selectPlaceOrder();
    }

    @When("fill the payment data")
    public void fill_the_payment_data() {
        Purchase.fillPaymentData(getProperty("name"), getProperty("country"), getProperty("city"),
                getProperty("creditCard"), getProperty("month"), getProperty("year"));
    }

    @Then("the system displays a message confirmation about the purchase")
    public void the_system_displays_a_message_confirmation_about_the_purchase() {
        Assert.assertTrue(Purchase.isPurchaseConfirmationDisplayed());
    }
}
