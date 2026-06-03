package com.ecommerce.automation.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static final Logger log =
            LogManager.getLogger(DriverFactory.class);

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {

        log.info("Launching browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // ✅ CI/CD HEADLESS MODE (GitHub Actions, Jenkins)
            if (isCI()) {
                log.info("Running in CI mode - enabling headless Chrome");

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
            }

            driver.set(new ChromeDriver(options));

        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {

        log.info("Closing browser instance");

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    // ✅ Detect CI environment (GitHub Actions / Jenkins)
    private static boolean isCI() {

        String ci = System.getenv("CI");

        return ci != null && ci.equalsIgnoreCase("true");
    }
}