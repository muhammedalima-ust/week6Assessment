package com.muhammedshopkart.ui.components;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;
import com.muhammedshopkart.ui.pages.ProductPage;
import org.openqa.selenium.WebElement;

/**
 * Product card is a reusable card in the PLP
 */
public class ProductCard {

     private final SelenideElement root;
     private final SelenideElement PRODUCT_NAME = Xp.productCardTitle();
     private final SelenideElement ADD_TO_CART_BUTTON = Xp.productCardButton();
    private final SelenideElement BUTTON = Xp.productImageButton();

    public ProductCard(SelenideElement root) {
        this.root = root;
    }

    public String getName() {
        return root.$x(Xp.productCardTitleLocator()).getText();
    }

    public WebElement getAddtocart() {
        return root.$x(Xp.productCardButtonLocator());
    }
    public ProductPage gotoDetailPage() {
        root.$x(Xp.productImageButtonLocator()).click();
        return new ProductPage();
    }
}