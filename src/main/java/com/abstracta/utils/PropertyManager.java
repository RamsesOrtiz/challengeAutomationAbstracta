package com.abstracta.utils;

import com.abstracta.config.LoggerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

    public static String getProperty(String property) {
        String prop = "";
        try {
            InputStream file = new FileInputStream("src/main/resources/application.properties");
            java.util.Properties properties = new java.util.Properties();
            properties.load(file);
            prop = properties.getProperty(property);
        } catch (FileNotFoundException e) {
            LoggerPage.logEvent("ERROR", "File not found: " + e);
        } catch (IOException e) {
            LoggerPage.logEvent("ERROR", "File error: " + e);
        }
        return prop;
    }
}
