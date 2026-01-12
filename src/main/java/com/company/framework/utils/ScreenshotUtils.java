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

    private static final String SCREENSHOT_BASE_DIR =
            System.getProperty("user.dir") + File.separator + "test-output"
                    + File.separator + "screenshots";

    public static void captureScreenshot(String testName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver == null) {
                return;
            }

            File directory = new File(SCREENSHOT_BASE_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File source =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destination = new File(
                    SCREENSHOT_BASE_DIR + File.separator
                            + testName + "_" + timestamp + ".png"
            );

            FileUtils.copyFile(source, destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
