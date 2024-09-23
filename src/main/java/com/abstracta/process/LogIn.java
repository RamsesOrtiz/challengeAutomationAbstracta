package com.abstracta.process;

import com.abstracta.config.ConfigPage;
import com.abstracta.config.LoggerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn extends ConfigPage {

    private static final By loginLink = By.id("login2");
    private static final By usernameInput = By.id("loginusername");
    private static final By passwordInput = By.id("loginpassword");
    private static final By loginBtn = By.cssSelector("button[onclick='logIn()']");
    private static final By welcomeMsg = By.id("nameofuser");

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public static void selectLogIn(){
        click(loginLink);
    }

    public static void fillUserData(String username, String password){
        waitElement(usernameInput, 10);
        if (isDisplayed(usernameInput)){
            type(usernameInput, username);
            type(passwordInput, password);
            LoggerPage.logEvent("LOGIN", "Login Data filled");
            click(loginBtn);
        }
    }

    public static boolean isLogged(String username){
        waitTime(3);
        if (getText(welcomeMsg).contentEquals("Welcome " + username)){
            LoggerPage.logEvent("LOGIN", "User " + username + " successfully logged");
            screenshot("Login User " + username);
            return true;
        } else {
            LoggerPage.logEvent("ERROR", "User " + username + " could not be logged");
            screenshot("Error in Login User " + username);
            return false;
        }
    }
}
