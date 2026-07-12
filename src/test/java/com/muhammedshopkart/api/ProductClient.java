package com.muhammedshopkart.api;


import com.muhammedshopkart.config.Config;
import com.muhammedshopkart.support.ApiSpecBuilders;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

    public class ProductClient {
        public Response search(String query) {
            return given()
                    .spec(ApiSpecBuilders.requestSpec())
                    .queryParam("q", query)
                    .when()
                    .get("/products");
        }
    }
