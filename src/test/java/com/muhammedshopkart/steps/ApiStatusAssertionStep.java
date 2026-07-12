package com.muhammedshopkart.steps;

import com.muhammedshopkart.support.Report;
import com.muhammedshopkart.support.World;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Then;


public class ApiStatusAssertionStep {
    private final World world;

    public ApiStatusAssertionStep(World world) {
        Report.step("Api assertion steps initialized");
        this.world = world;
    }

    @Then("the response status is {int}")
    public void theResponseStatusIs(int statusCode) {
        Report.step("Verify API response status");
        assertEquals(statusCode, this.world.lastResponse.statusCode());
        Report.pass("Status Code verified");
    }
}