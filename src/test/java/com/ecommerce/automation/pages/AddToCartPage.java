package com.ecommerce.automation.pages;
import com.ecommerce.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
        WebDriver driver;
        public AddToCartPage(WebDriver driver) {
            this.driver = driver;
        }

        By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
        By cartIcon = By.className("shopping_cart_link");

        public void addBackpackToCart() {
            WaitUtils.waitForElement(addToCartBtn).click();
        }

        public void openCart() {
            WaitUtils.waitForElement(cartIcon).click();
        }
    }

