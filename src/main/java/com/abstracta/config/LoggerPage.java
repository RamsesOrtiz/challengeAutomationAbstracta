package com.abstracta.config;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LoggerPage {

    public static void logEvent(String tag, String event){
        LogManager.getLogger(LoggerPage.class).log(Level.forName(tag, 400), event);
    }
}
