package com.company.framework.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.company.framework.driver.DriverManager;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "target/screenshots/";

    public static String captureScreenshot(String testName) {

        try {
            WebDriver driver = DriverManager.getDriver();

            if (driver == null) {
                return null;
            }

            // Create directory if not exists
            File directory = new File(SCREENSHOT_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);

            FileUtils.copyFile(source, destination);

            return screenshotPath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
