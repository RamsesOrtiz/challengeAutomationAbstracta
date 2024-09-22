package com.abstracta.process;

import com.abstracta.config.ConfigPage;
import com.abstracta.config.LoggerPage;
import org.openqa.selenium.WebDriver;

public class LogIn extends ConfigPage {

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public static void visitPage(String url){
        LoggerPage.logEvent("LOGIN", "Visiting " + url);
        getUrl(url);
    }
}
