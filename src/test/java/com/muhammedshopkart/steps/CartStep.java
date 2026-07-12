package com.muhammedshopkart.steps;

import com.muhammedshopkart.api.CartClient;
import com.muhammedshopkart.data.builders.CustomerBuilder;
import com.muhammedshopkart.support.Report;
import com.muhammedshopkart.support.World;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartStep {
    private final World world;
    private  String cartId;
    private final CartClient cartClient = new CartClient();

    public CartStep(World world) {
        Report.step("Cart steps initialized");
        this.world = world;
    }

    @When("Clicked on first product")
    public void clickFirstProduct() {
        Report.step("Click first product");
        this.world.productPage = this.world.homepage.clickFirstProduct();
        Report.pass("First product selected");
    }

    @When("Clicked on add to cart")
    public void addToCart() {
        Report.step("Add product to cart");
        this.world.cartPage = this.world.productPage.addtoCart();
        Report.pass("Product added to cart");
    }

    @When("Click on checkout")
    public void clickOnCheckout() {
        Report.step("Proceed to checkout");
        this.world.checkOutPage = this.world.cartPage.checkout();
        Report.pass("Checkout page opened");
    }

    @When("Enter Address {string}")
    public void enterAddress(String address) {
        Report.step("Enter shipping address");
        Report.info("shippingAddress", address);
        this.world.checkOutPage.addAddress(address);
        Report.pass("Address entered");
    }


    @When("{string} adds {int} * {string} to a new cart")
    public void addsQuantityToNewCart(String name, int qty, String sku) {
        Report.step(name + " adds " + qty + " * " + sku + " to a new cart");
        String token = new CustomerBuilder().named(this.world.customer.name()).loginAndGetToken();
        this.cartId = cartClient.createCart(token).jsonPath().getString("cartId");
        this.world.lastResponse = cartClient.addItem(token, cartId, sku, qty);
        Report.info("cartId", cartId);
        Report.pass("Item added to new cart");
    }

    @And("she adds {int} x {string} \\({int} paise each\\) to her cart")
    public void addsQuantityWithPriceToCart(int qty, String sku, int pricePaise) {
        Report.step("Add " + qty + " x " + sku + " (" + pricePaise + " paise each) to cart");
        String name = this.world.customer.name();
        String token = new CustomerBuilder().named(this.world.customer.name()).loginAndGetToken();

        if (this.cartId == null) {
            this.cartId = cartClient.createCart(token).jsonPath().getString("cartId");
            Report.info("cartId", this.cartId);
        }
        this.world.lastResponse = cartClient.addItem(token, this.cartId, sku, qty);
        assertEquals(200, this.world.lastResponse.statusCode());
        Report.pass("Item added to cart successfully");
    }

    @Then("the cart total is {int} paise")
    public void verifyCartTotal(int expectedTotalPaise) {
        Report.step("Verify cart total paise");
        Report.info("expectedTotalPaise", expectedTotalPaise);
        String token = new CustomerBuilder().named(this.world.customer.name()).loginAndGetToken();
        Response cartResp = cartClient.getCart(token, this.cartId);
        Report.info("cartStatus", cartResp.statusCode());
        assertEquals(200, cartResp.statusCode());
        assertEquals(expectedTotalPaise, cartResp.jsonPath().getInt("totalPaise"));
        Report.pass("Cart total verified successfully");
    }
}
