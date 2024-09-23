package com.abstracta.process;

import com.abstracta.config.ConfigPage;
import com.abstracta.config.LoggerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp extends ConfigPage {

    private static final By signUpLink = By.id("signin2");
    private static final By usernameInput = By.id("sign-username");
    private static final By passwordInput = By.id("sign-password");
    private static final By signUpBtn = By.cssSelector("button[onclick='register()']");

    public SignUp(WebDriver driver) {
        super(driver);
    }

    public static void accessToSignUp() {
        waitElement(signUpLink, 10);
        click(signUpLink);
        waitElement(usernameInput, 5);
        if (isDisplayed(usernameInput)) {
            LoggerPage.logEvent("SIGN_UP", "Sign Up successfully selected");
            screenshot("Sign Up selected");
        }
    }

    public static void fillData(String username, String password) {
        waitElement(usernameInput, 5);
        type(usernameInput, username);
        type(passwordInput, password);
        LoggerPage.logEvent("SIGN_UP", "Sign Up data successfully filled");
        screenshot("Sign Up data filled");
        click(signUpBtn);
    }

    public static boolean isSignUpConfirmationDisplayed() {
        if (isAlertPresent()) {
            LoggerPage.logEvent("SIGN_UP", "Sign Up process successfully confirmed");
            screenshot("Sign Up process confirmed");
            acceptAlert();
            return true;
        } else {
            LoggerPage.logEvent("SIGN_UP", "Sign Up process could not be confirmed");
            screenshot("Sign Up process error");
            return false;
        }
    }
}
