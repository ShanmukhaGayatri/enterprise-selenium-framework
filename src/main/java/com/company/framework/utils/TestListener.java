package com.company.framework.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        ScreenshotUtils.captureScreenshot(result.getName() + "_PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenshotUtils.captureScreenshot(result.getName() + "_FAIL");
    }
}
