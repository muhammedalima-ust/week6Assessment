package com.muhammedshopkart.steps;

import com.muhammedshopkart.api.OrderClient;
import com.muhammedshopkart.data.builders.CustomerBuilder;
import com.muhammedshopkart.data.builders.OrderBuilder;
import com.muhammedshopkart.data.models.Order;
import com.muhammedshopkart.support.Report;
import com.muhammedshopkart.support.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OrderStep {
    private final World world;
    private final OrderClient orderClient = new OrderClient();
    private Map<String, Order> ordersByUser = new HashMap<>();

    public OrderStep(World world) {
        Report.step("Order steps initialized");
        this.world = world;
    }

    @When("Click on PlaceOrder")
    public void placeOrder() {
        Report.step("Place order");
        this.world.orderPage = this.world.checkOutPage.placeOrder();
        Report.pass("Order placed");
    }

    @Then("Verify the Status is placed and address is {string}")
    public void verifyOrder(String address) {
        Report.step("Verify placed order details");
        Report.info("expectedAddress", address);
        assertAll(
                () -> assertEquals("PLACED", this.world.orderPage.getStatus()),
                () -> assertEquals(address, this.world.orderPage.getAddress()),
                () -> assertTrue(this.world.orderPage.getHeading().contains("Order confirmed"))
        );
        Report.pass("Order details verified");
    }

    @Given("{string} has a PLACED order")
    public void hasAPlacedOrder(String name) {
        Report.step("Create a placed order placeholder for " + name);
        Order order = OrderBuilder.anOrder()
                .name(name)
                .withSku("SKU-BAG")
                .withQty(1)
                .build();
        ordersByUser.put(name, order);
        Report.pass("Created placed order data for " + name);
    }

    @When("{string} cancels that order")
    public void cancelsThatOrder(String name) {
        Order order = ordersByUser.get(name);
        Report.step("Cancel order for " + name + " with id " + order.orderId());
        String token = new CustomerBuilder().named(name).loginAndGetToken();
        this.world.lastResponse = orderClient.cancel(token, order.orderId());
        Report.pass("Order cancel request sent");
    }

    @When("{string} cancels that order again")
    public void cancelsThatOrderAgain(String name) {
        Report.step("Cancel that order again for " + name);
        cancelsThatOrder(name);
    }

    @Then("the order status becomes {string}")
    public void orderStatusBecomes(String status) {
        Report.step("Verify order status becomes " + status);
        Report.info("expectedStatus", status);
        assertEquals(200, this.world.lastResponse.statusCode());
        assertEquals(status, this.world.lastResponse.jsonPath().getString("status"));
        Report.pass("Order status updated successfully");
    }

    @When("{string} requests GET Order")
    public void requestsGetOrder(String requestingUser) {
        Report.step(requestingUser + " requests GET Order");
        Order order = this.ordersByUser.values().stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No PLACED order set up for this scenario"));
        String token =  new CustomerBuilder().named(requestingUser).loginAndGetToken();
        this.world.lastResponse = orderClient.get(token, order.orderId());
        Report.pass("Order GET request executed");
    }
}
