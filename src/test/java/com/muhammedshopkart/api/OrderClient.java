package com.muhammedshopkart.api;

import com.muhammedshopkart.config.Config;
import com.muhammedshopkart.support.ApiSpecBuilders;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class OrderClient {
    public Response place(String token, String cartId,String address) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .body(Map.of("cartId", cartId,"address", address))
                .when()
                .post("/orders");
    }

    public Response get(String token, String orderId) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .when()
                .get("/orders/{id}", orderId);
    }

    public Response cancel(String token, String orderId) {
        return given()
                .spec(ApiSpecBuilders.authSpec(token))
                .when()
                .post("/orders/{id}/cancel", orderId);
    }
}