package com.abstracta.defs;

import com.abstracta.config.ConfigPage;
import com.abstracta.process.Purchase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.abstracta.utils.PropertyManager.getProperty;

public class CartTest {

    @Given("a user visits the website to add a product")
    public void a_user_visits_the_website_to_add_a_product() {
        ConfigPage.getUrl(getProperty("url"));
    }

    @When("select a product")
    public void select_a_product() {
        Purchase.selectProduct();
    }

    @When("select add to cart")
    public void select_add_to_cart() {
        Purchase.selectAddToCart();
    }

    @Then("the system displays and alert confirmation")
    public void the_system_displays_and_alert_confirmation() {
        Assert.assertTrue(Purchase.isAddToCartConfirmationDisplayed());
    }
}
