package com.abstracta.process;

import com.abstracta.config.ConfigPage;
import com.abstracta.config.LoggerPage;
import com.abstracta.utils.CreateFileText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo extends ConfigPage {

    private static final List<String[]> productsInfo = new ArrayList<>();

    private static final By cardBlocks = By.cssSelector("div[class='card-block']");
    private static final By productTitle = By.cssSelector("a[class='hrefch']");
    private static final By productPrice = By.tagName("h5");
    private static final By nextBtn = By.id("next2");

    public ProductInfo(WebDriver driver) {
        super(driver);
    }

    private static void extractProductInformation(String productPage) {
        LoggerPage.logEvent("PRODUCT_INFO", "Extracting Product Information - Page: " + productPage);
        waitElement(cardBlocks, 10);
        List<WebElement> elements = getList(cardBlocks);
        for (WebElement element : elements) {
            String elementTitle = getText(findElementInElement(element, productTitle));
            String elementPrice = getText(findElementInElement(element, productPrice));
            String elementLink = getAttribute(findElementInElement(element, productTitle), "href");
            String[] elementInfo = {elementTitle, elementPrice, elementLink};
            productsInfo.add(elementInfo);
        }
    }

    public static void getProductInformation() {
        extractProductInformation("1");
        moveAndClick(nextBtn);
        waitTime(2);
        extractProductInformation("2");
        LoggerPage.logEvent("PRODUCT_INFORMATION", "Product Information successfully extracted");
    }

    public static boolean isTextFileGenerated() {
        CreateFileText.saveInfo("Products.txt", productsInfo);
        return CreateFileText.wasFileCreated;
    }
}
