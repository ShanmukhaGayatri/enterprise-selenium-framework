package com.company.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String capture(WebDriver driver, String testName) {

        if (driver == null) {
            return null;
        }

        try {
            // Create screenshots directory if it doesn't exist
            Path dirPath = Paths.get(SCREENSHOT_DIR);
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String screenshotPath =
                    SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

            File source =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Files.copy(source.toPath(), Paths.get(screenshotPath));

            return screenshotPath;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
