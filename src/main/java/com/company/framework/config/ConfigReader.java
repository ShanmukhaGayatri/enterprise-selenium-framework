package com.company.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Static block runs ONCE when class is loaded
    static {
        try {
            FileInputStream fis = new FileInputStream(
                "src/main/resources/config.properties"
            );
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    // This is the method BrowserFactory is calling
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
