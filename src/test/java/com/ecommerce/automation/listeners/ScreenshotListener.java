package com.ecommerce.automation.listeners;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            Object testClass = result.getInstance();

            WebDriver driver =
                    ((BaseTest) testClass).getDriver();

            if (driver == null) {
                System.out.println("Driver is NULL - skipping screenshot");
                return;
            }

            byte[] screenshot =
                    ScreenshotUtils.captureScreenshot(driver);

            Allure.addAttachment(
                    "Failure Screenshot",
                    new ByteArrayInputStream(screenshot)
            );

        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}