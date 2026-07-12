package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;

import static com.codeborne.selenide.Condition.visible;

/**
 * This Cart page Contain all the method in the "/checkout" url page
 */
public class CheckOutPage {
    private static SelenideElement ADDRESS_INPUT = Xp.addressInput();
    private static SelenideElement PLACE_ORDER_BUTTON = Xp.placeOrderButton();
    /**
     * Add Address
     */
    public CheckOutPage addAddress(String address) {
        ADDRESS_INPUT.shouldBe(visible)
                .setValue(address);
        return this;
    }
    public OrderPage placeOrder() {
        PLACE_ORDER_BUTTON.click();
        return new OrderPage();
    }
}
