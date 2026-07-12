package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;


/**
 * This Cart page Contain all the method in the "/cart" url page
 */
public class CartPage {
    private static SelenideElement CHECKOUT_BUTTON = Xp.checkoutButton();
    /**
     * Checkout to add address
     */
    public CheckOutPage checkout() {
        CHECKOUT_BUTTON.click();
        return new CheckOutPage();
    }
}
