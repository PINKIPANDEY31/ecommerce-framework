package com.ecommerce.automation.tests.UI;

import com.ecommerce.automation.base.BaseTest;
import com.ecommerce.automation.pages.AddToCartPage;
import com.ecommerce.automation.pages.LoginPage;
import com.ecommerce.automation.utils.JsonDataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        // Step 1: login ONLY for this test
        LoginPage login = new LoginPage(driver);
        login.login(
                JsonDataReader.get("username"),
                JsonDataReader.get("password")
        );

        // Step 2: add to cart
        AddToCartPage cart = new AddToCartPage(driver);
        cart.addBackpackToCart();
        cart.openCart();

        // Step 3: validation
        Assert.assertTrue(
                driver.getPageSource().contains("Sauce Labs Backpack"),
                "Product not found in cart"
        );
    }
}