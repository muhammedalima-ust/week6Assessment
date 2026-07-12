package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.components.ProductCard;
import com.muhammedshopkart.ui.locators.Xp;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

import java.util.List;

/**
 * This Home page Contain all the method in the "/" url page
 */
public class Homepage {

    private final SelenideElement SEARCH_BUTTON = Xp.searchButton();
    private final SelenideElement SEARCH_INPUT = Xp.searchInput();
    private final ElementsCollection PRODUCT_CARDS = Xp.productCards();

    public Homepage homeOpen() {
        open("/");
        return this;
    }

    /**
     * Search a product
     */
    public Homepage search(String productName) {

        SEARCH_INPUT.shouldBe(visible)
                .setValue(productName);
        SEARCH_BUTTON.click();
        PRODUCT_CARDS.shouldHave(sizeGreaterThan(0));
        return this;
    }

    /**
     * Checking if the products
     * that are in the Product list
     * have the same name as search keyword
     */
    public void verifyProduct(String expectedProduct) {

        List<ProductCard> cards = PRODUCT_CARDS.asFixedIterable()
                .stream()
                .map(ProductCard::new)
                .toList();

        cards.stream()
                .map(ProductCard::getName)
                .anyMatch(name -> name.equalsIgnoreCase(expectedProduct));
    }

    /**
     * Checking if the products
     * that are in the Product list
     * have the same name as search keyword
     */
    public ProductPage clickFirstProduct() {

        return PRODUCT_CARDS.asFixedIterable()
                .stream()
                .map(ProductCard::new)
                .toList().getFirst().gotoDetailPage();

    }
}
