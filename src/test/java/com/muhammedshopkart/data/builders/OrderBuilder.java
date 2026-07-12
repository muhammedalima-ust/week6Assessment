package com.muhammedshopkart.data.builders;

import com.muhammedshopkart.api.AuthClient;
import com.muhammedshopkart.api.CartClient;
import com.muhammedshopkart.api.OrderClient;
import com.muhammedshopkart.data.models.Order;
import com.muhammedshopkart.support.Report;
import io.restassured.response.Response;

/**
 * Place order using api and return the order
 */
public class OrderBuilder {
    private String name;
    private String sku;
    private int qty;
    private String address = "ADDRESS123456";

    public static OrderBuilder anOrder() {
        return new OrderBuilder();
    }

    public OrderBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OrderBuilder withSku(String sku) {
        this.sku = sku;
        return this;
    }
    public OrderBuilder withQty(int qty) {
        this.qty = qty;
        return this;
    }
    public OrderBuilder withAddress(String address) {
        this.address = address;
        return this;
    }


    public Order build() {
        String token = CustomerBuilder.aCustomer().named(name).loginAndGetToken();

        String cartId = new CartClient().createCart(token).jsonPath().getString("cartId");
        new CartClient().addItem(token, cartId, sku, qty);

        Response orderResp = new OrderClient().place(token, cartId, address);
        String orderId = orderResp.jsonPath().getString("orderId");

        return new Order(token, cartId, orderId);
    }
}