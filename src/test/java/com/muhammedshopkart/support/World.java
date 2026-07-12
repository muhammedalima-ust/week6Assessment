package com.muhammedshopkart.support;


import com.muhammedshopkart.api.OrderClient;
import com.muhammedshopkart.api.ProductClient;
import com.muhammedshopkart.data.builders.CustomerBuilder;
import com.muhammedshopkart.data.models.Customer;
import com.muhammedshopkart.ui.components.Header;
import com.muhammedshopkart.ui.pages.*;
import io.restassured.response.Response;

/**
 * World Class which contain all the pages and api client
 */
public class World {
    public Homepage homepage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public OrderPage orderPage;
    public String authToken;
    public OrderClient orderClient = new OrderClient();
    public ProductClient productClient = new ProductClient();
    public Customer customer;
    public String lastOrderId;
    public Response lastResponse;

    public Header header(){
        return new Header();
    }
}
