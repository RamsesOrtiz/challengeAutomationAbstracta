package com.abstracta.defs;

import com.abstracta.config.ConfigPage;
import com.abstracta.process.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.abstracta.utils.PropertyManager.getProperty;

public class SignUpTest {

    @Given("a user visits the website to sign up")
    public void a_user_visits_the_website_to_sign_up() {
        ConfigPage.getUrl(getProperty("url"));
    }

    @When("access to sign up")
    public void access_to_sign_up() {
        SignUp.accessToSignUp();
    }

    @When("fill username and password")
    public void fill_username_and_password() {
        SignUp.fillData(getProperty("username"), getProperty("password"));
    }

    @Then("the system displays an alert confirmation about the sign up")
    public void the_system_displays_an_alert_confirmation_about_the_sign_up() {
        Assert.assertTrue(SignUp.isSignUpConfirmationDisplayed());
    }
}
