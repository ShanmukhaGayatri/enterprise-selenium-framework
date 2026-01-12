package com.company.framework.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    public static void capture(WebDriver driver, String testName) {

        try {
            // Create timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            // Take screenshot
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // Destination with timestamp
            File dest = new File(
                    "screenshots/" + testName + "_" + timestamp + ".png"
            );

            // Create directory if it does not exist
            dest.getParentFile().mkdirs();

            // Copy file
            FileHandler.copy(src, dest);

        } catch (Exception e) {
            // Intentionally ignored - screenshot failure should not fail test
        }
    }
}
