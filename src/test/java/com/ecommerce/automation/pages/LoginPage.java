package com.ecommerce.automation.pages;

import com.ecommerce.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        By username = By.id("user-name");
        By password = By.id("password");
        By loginBtn = By.id("login-button");

        public void login(String user, String pass) {
            WaitUtils.waitForElement(username).sendKeys(user);
            WaitUtils.waitForElement(password).sendKeys(pass);
            WaitUtils.waitForElement(loginBtn).click();
        }
    }

