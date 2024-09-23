package com.abstracta.utils;

import com.abstracta.config.LoggerPage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFileText {

    public static boolean wasFileCreated = false;

    public static void saveInfo(String fileName, List<String[]> data) {
        String[] columnNames = new String[]{"Product Title", "Product Price", "Product Link"};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/outcomes/" + fileName))) {
            writer.write(String.join(",", columnNames));
            writer.newLine();

            for (String[] entry : data) {
                if (entry.length == 3) {
                    writer.write(String.join(",", entry));
                    writer.newLine();
                } else {
                    LoggerPage.logEvent("ERROR", "Entry quantity error: " + entry.length);
                    throw new IOException();
                }
            }
            wasFileCreated = true;
            LoggerPage.logEvent("PRODUCT_INFORMATION", "Product Information File successfully created");
        } catch (IOException e) {
            LoggerPage.logEvent("ERROR", "IO Exception " + e.getMessage());
        }
    }
}
