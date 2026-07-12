package com.muhammedshopkart.api;

import com.muhammedshopkart.config.Config;
import com.muhammedshopkart.support.ApiSpecBuilders;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CartClient {
    public Response createCart(String token) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .when()
                .post("/carts");
    }

    public Response addItem(String token, String cartId, String sku, int qty) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .body(Map.of("sku", sku, "qty", qty))
                .when()
                .post("/carts/{id}/items", cartId);
    }

    public Response getCart(String token, String cartId) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .when()
                .get("/carts/{id}", cartId);
    }
}