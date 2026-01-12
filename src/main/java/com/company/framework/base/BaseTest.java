package com.company.framework.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.company.framework.driver.BrowserFactory;
import com.company.framework.driver.DriverManager;
import com.company.framework.utils.ScreenshotUtils;

public class BaseTest {

    protected WebDriver driver;

    // Logger for this class
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        log.info("===== Test Setup Started =====");

        log.info("Launching browser");
        driver = BrowserFactory.createDriver("chrome");
        DriverManager.setDriver(driver);

        log.info("Browser launched successfully");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            log.error("TEST FAILED: {}", result.getName());
            ScreenshotUtils.capture(
                    DriverManager.getDriver(),
                    result.getName()
            );
        } else if (ITestResult.SUCCESS == result.getStatus()) {
            log.info("TEST PASSED: {}", result.getName());
        } else {
            log.warn("TEST SKIPPED: {}", result.getName());
        }

        log.info("Closing browser");
        DriverManager.getDriver().quit();
        DriverManager.unload();

        log.info("===== Test Teardown Completed =====");
    }
}
