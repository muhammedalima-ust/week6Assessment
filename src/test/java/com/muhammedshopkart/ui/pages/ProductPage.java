package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;


/**
 * This Class contain the functionality in the product detail page
 */
public class ProductPage {

    private static SelenideElement ADD_TO_CART_BUTTON = Xp.addToCart();
    /**
     * Add to cart
     */
    public CartPage addtoCart() {
        ADD_TO_CART_BUTTON.click();
        return new CartPage();
    }
}
