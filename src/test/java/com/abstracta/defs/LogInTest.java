package com.abstracta.defs;

import com.abstracta.config.ConfigPage;

import com.abstracta.process.LogIn;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.abstracta.utils.PropertyManager.getProperty;

public class LogInTest {

    @Given("a user visits the website")
    public void a_user_visits_the_website() {
        ConfigPage.getUrl(getProperty("url"));
    }

    @When("select log in")
    public void select_log_in() {
        LogIn.selectLogIn();
    }

    @When("fill a signed username and password")
    public void fill_a_signed_username_and_password() {
        LogIn.fillUserData(getProperty("username"), getProperty("password"));
    }

    @Then("the system displays welcome username in the website menu")
    public void the_system_displays_welcome_username_in_the_website_menu() {
        Assert.assertTrue(LogIn.isLogged(getProperty("username")));
    }
}
