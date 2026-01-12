package com.company.framework.driver;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.company.framework.config.ConfigReader;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        WebDriver driver;
        String executionMode = ConfigReader.getProperty("execution.mode");

        try {

            // ================= GRID / DOCKER EXECUTION =================
            if (executionMode.equalsIgnoreCase("grid")) {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");

                URL gridUrl = URI
                        .create(ConfigReader.getProperty("grid.url"))
                        .toURL();

                driver = new RemoteWebDriver(gridUrl, options);
            }

            // ================= LOCAL EXECUTION =================
            else {

                switch (browser.toLowerCase()) {

                    case "firefox":
                        driver = new FirefoxDriver();
                        break;

                    case "chrome":
                    default:
                        driver = new ChromeDriver();
                        break;
                }

                driver.manage().window().maximize();
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize WebDriver", e);
        }

        return driver;
    }
}
