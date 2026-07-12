package com.muhammedshopkart.steps;

import com.muhammedshopkart.support.Report;
import com.muhammedshopkart.support.World;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.*;

public class SearchStep {
    private final World world;

    public SearchStep(World world) {
        Report.step("Search steps initialized");
        this.world = world;
    }

    @When("user searches for {string}")
    public void searchProduct(String product) {
        Report.step("Search for product: " + product);
        Report.info("searchTerm", product);
        this.world.homepage.search(product);
        Report.pass("Search executed");
    }

    @Then("product {string} should be displayed")
    public void verifyProductUi(String product) {
        Report.step("Verify product display for: " + product);
        this.world.homepage.verifyProduct(product);
        Report.pass("Product displayed as expected");
    }

    @Then("Product API should return {string}")
    public void verifyProductApi(String product) {
        Report.step("Verify Product API response for: " + product);
        Response resp = this.world.productClient.search(product);
        Report.info("apiStatus", resp.statusCode());
        assertAll(
                () -> assertEquals(200, resp.statusCode()),
                () -> assertTrue(resp.jsonPath().getList("sku").stream()
                        .anyMatch(sku -> sku.toString().toLowerCase().contains(product.toLowerCase())))
        );
        Report.pass("Product API returned expected results");
    }
}
