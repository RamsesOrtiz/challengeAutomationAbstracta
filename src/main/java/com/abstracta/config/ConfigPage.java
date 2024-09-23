package com.abstracta.config;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ConfigPage {

    private static WebDriver driver;

    public ConfigPage(WebDriver driver) {
        ConfigPage.driver = driver;
    }

    public static void setup(String webBrowser) {
        switch (webBrowser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                LoggerPage.logEvent("CONFIG", "Web Browser not supported: " + webBrowser);
        }
        assert driver != null;
        driver.manage().window().maximize();
        LoggerPage.logEvent("START", "-------------------------------------");
        LoggerPage.logEvent("START", "Setup of " + webBrowser + " completed");
    }

    public static void getUrl(String url) {
        driver.get(url);
        LoggerPage.logEvent("URL", "URL visited: " + url);
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public static void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public static WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static WebElement findElementInElement(WebElement element, By locator) {
        return element.findElement(locator);
    }

    public static void waitElement(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void moveAndClick(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
        click(locator);
    }

    public static void click(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            Actions actions = new Actions(driver);
            WebElement element = driver.findElement(locator);
            actions.moveToElement(element).click(element).perform();
        } catch (Exception e) {
            LoggerPage.logEvent("ERROR", "Click Exception: " + locator.toString());
        }
    }

    public static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public static String getText(WebElement element) {
        return element.getText();
    }

    public static void type(By locator, String inputText) {
        click(locator);
        driver.findElement(locator).sendKeys(inputText);
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public static String getAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    public static List<WebElement> getList(By locator) {
        return driver.findElements(locator);
    }

    public static boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            LoggerPage.logEvent("ERROR", e.getMessage());
            return false;
        }
    }

    public static void waitTime(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            LoggerPage.logEvent("ERROR", e.getMessage());
        }
    }

    public static void quit() {
        if (driver != null) {
            LoggerPage.logEvent("FINISH", "Closing Webdriver");
            driver.quit();
        }
    }

    public static byte[] screenshot(String process) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scr, new File("screenshots/" + date + "/process-" + process + ".png"));
        } catch (IOException e) {
            LoggerPage.logEvent("ERROR", e.getMessage());
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
