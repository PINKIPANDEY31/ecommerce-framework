package com.ecommerce.automation.base;

import com.ecommerce.automation.driver.DriverFactory;
import com.ecommerce.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static final Logger log =
            LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        log.info("Initializing browser");

        driver = DriverFactory.initDriver(
                ConfigReader.getProperty("browser")
        );

        driver.get(
                ConfigReader.getProperty("url")
        );
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}