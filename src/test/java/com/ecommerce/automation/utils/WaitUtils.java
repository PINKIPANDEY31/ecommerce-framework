package com.ecommerce.automation.utils;

import com.ecommerce.automation.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElement(By locator) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverFactory.getDriver(),
                        Duration.ofSeconds(10));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }
}