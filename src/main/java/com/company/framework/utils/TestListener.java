package com.company.framework.utils;

import com.company.framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtils.capture(driver, result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        ScreenshotUtils.capture(driver, result.getName());
    }
}
