package com.muhammedshopkart.ui.locators;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Xp {

    private static final String SEARCH_INPUT = "//input[@id='catalog-search']";
    private static final String SEARCH_BUTTON = "//button[text()='Search']";
    private static final String PRODUCT_CARD = "//div[contains(@class,'product-card')]";
    private static final String PRODUCT_CARD_TITLE = ".//h2//button";
    private static final String PRODUCT_CARD_BUTTON = "//button[contains(@class,'quick-add') and not(@disabled)]";
    private static final String PRODUCT_IMAGE_BUTTON = ".//button[contains(@class,'product-image')]";

    private static final String ADD_TO_CART = "//button[contains(., 'Add to cart')]";

    private static final String EMAIL_INPUT = "//input[@id='email']";
    private static final String PASSWORD_INPUT = "//input[@id='password']";
    private static final String SIGN_BUTTON = "//button[contains(@type, 'submit')]";

    private static final String HEADER = "//header[@class='top-bar']";
    private static final String SIGNBUTTON = "//button[contains(normalize-space(), 'Sign in')]";

    private static final String CHECKOUT_BUTTON = "//button[contains(., 'Checkout')]";

    private static final String ADDRESS_INPUT = "//textarea[@id='address']";
    private static final String PLACE_ORDER_BUTTON = "//button[contains(.,'Place order')]";

    private static final String ORDER_STATUS = "//dd[@data-field='order-status']";
    private static final String ADDRESS = "//dt[normalize-space()='Delivery address']/following-sibling::dd";
    private static final String HEADING = "//h1";

    public static SelenideElement searchInput() {
        return $x(SEARCH_INPUT);
    }

    public static SelenideElement searchButton() {
        return $x(SEARCH_BUTTON);
    }

    public static ElementsCollection productCards() {
        return $$x(PRODUCT_CARD);
    }

    public static SelenideElement productCardTitle() {
        return $x(PRODUCT_CARD_TITLE);
    }

    public static String productCardTitleLocator() {
        return PRODUCT_CARD_TITLE;
    }

    public static SelenideElement productCardButton() {
        return $x(PRODUCT_CARD_BUTTON);
    }

    public static String productCardButtonLocator() {
        return PRODUCT_CARD_BUTTON;
    }

    public static SelenideElement productImageButton() {
        return $x(PRODUCT_IMAGE_BUTTON);
    }

    public static String productImageButtonLocator() {
        return PRODUCT_IMAGE_BUTTON;
    }

    public static SelenideElement addToCart() {
        return $x(ADD_TO_CART);
    }

    public static SelenideElement emailInput() {
        return $x(EMAIL_INPUT);
    }

    public static SelenideElement passwordInput() {
        return $x(PASSWORD_INPUT);
    }

    public static SelenideElement signButton() {
        return $x(SIGN_BUTTON);
    }

    public static SelenideElement header() {
        return $x(HEADER);
    }

    public static SelenideElement signInButton() {
        return $x(SIGNBUTTON);
    }

    public static SelenideElement checkoutButton() {
        return $x(CHECKOUT_BUTTON);
    }

    public static SelenideElement addressInput() {
        return $x(ADDRESS_INPUT);
    }

    public static SelenideElement placeOrderButton() {
        return $x(PLACE_ORDER_BUTTON);
    }

    public static SelenideElement orderStatus() {
        return $x(ORDER_STATUS);
    }

    public static SelenideElement deliveryAddress() {
        return $x(ADDRESS);
    }

    public static SelenideElement heading() {
        return $x(HEADING);
    }
}
