package com.muhammedshopkart.support;


import com.muhammedshopkart.steps.AuthStep;
import com.muhammedshopkart.steps.SearchStep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Base UI Test
 * This file contain all the ui tests
 * Including all the flows
 */
public class BaseUITest {

    @Test
    @DisplayName("Senario 1 UI Tests from searching a product to verifying the product")
    public void searchProduct(){
        World world = new World();
        AuthStep authStep = new AuthStep(world);
        authStep.openHome();
        SearchStep searchStep = new SearchStep(new World());
        searchStep.searchProduct("Bag");
    }
}