package com.company.framework.base;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.company.framework.driver.BrowserFactory;
import com.company.framework.driver.DriverManager;
import com.company.framework.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        log.info("===== Test Setup Started =====");
        driver = BrowserFactory.createDriver("chrome");
        DriverManager.setDriver(driver);
        log.info("Browser launched successfully");
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Test Teardown Started =====");
        DriverManager.getDriver().quit();
        DriverManager.unload();
        log.info("Browser closed successfully");
    }
}
