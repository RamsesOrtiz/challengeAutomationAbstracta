package com.abstracta.defs;

import com.abstracta.config.ConfigPage;
import com.abstracta.process.ProductInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.abstracta.utils.PropertyManager.getProperty;

public class ProductInfoTest {

    @Given("a visit to the website")
    public void a_visit_to_the_website() {
        ConfigPage.getUrl(getProperty("url"));
    }

    @When("the products information is displayed")
    public void the_products_information_is_displayed() {
        ProductInfo.getProductInformation();
    }

    @Then("a text file is generated with each product information")
    public void a_text_file_is_generated_with_each_product_information() {
        Assert.assertTrue(ProductInfo.isTextFileGenerated());
    }
}
