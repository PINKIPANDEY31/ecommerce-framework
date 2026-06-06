package com.ecommerce.automation.tests.UI;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.pages.LoginPage;
import com.ecommerce.automation.utils.JsonDataReader;
import com.ecommerce.automation.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger log =
            LogManager.getLogger(LoginTest.class);


    @Test(retryAnalyzer = com.ecommerce.automation.listeners.RetryAnalyzer.class)
    public void verifyValidLogin() {
        log.info("Application is logged in");
        LoginPage login = new LoginPage(driver);
        login.login(
                JsonDataReader.get("username"),
                JsonDataReader.get("password")
        );
        Assert.assertTrue(
                WaitUtils.waitForElement(
                        By.xpath("//span[text()='Products']")
                ).isDisplayed(),
                "Login failed"
        );


    }
}
