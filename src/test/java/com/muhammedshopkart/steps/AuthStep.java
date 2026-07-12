package com.muhammedshopkart.steps;

import com.muhammedshopkart.data.builders.CustomerBuilder;
import com.muhammedshopkart.support.Report;
import com.muhammedshopkart.support.World;
import com.muhammedshopkart.ui.pages.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthStep {
    private final World world;

    public AuthStep(World world) {
        Report.step("Auth steps initialized");
        this.world = world;
    }

    @Given("user is on the homepage")
    public void openHome() {
        Report.step("Open homepage");
        this.world.homepage = new Homepage().homeOpen();
        Report.pass("Homepage opened");
    }

    @When("user clicks on Sign in button")
    public void clickOnLoginPage() {
        Report.step("Click Sign in button");
        this.world.loginPage = this.world.header().signIn();
        Report.pass("Login page opened");
    }

    @Then("Login Page appeared")
    public void loginPageVerification() {
        Report.step("Verify login page appeared");
        assertTrue(url().contains("login"));
        Report.pass("Login page appeared");
    }

    @When("User inputs {string} and her password")
    public void enterDetails(String name) {
        Report.step("Enter login credentials");
        this.world.customer = new CustomerBuilder().named(name).build();
        Report.info("userEmail", this.world.customer.email());
        this.world.loginPage.enterEmail(world.customer.email()).enterPassword(world.customer.password());
        Report.pass("Credentials entered");
    }

    @And("Click on Sign in")
    public void signIn() {
        Report.step("Submit sign in");
        this.world.homepage = this.world.loginPage.signin();
        this.world.authToken = new CustomerBuilder().named(this.world.customer.name()).loginAndGetToken();
        Report.pass("Signed in successfully");
    }

    @Given("{string} is logged in")
    public void userIsLoggedInApi(String name) {
        Report.step("Ensure user is logged in via API: " + name);
        this.world.customer = new CustomerBuilder().named(name).build();
        this.world.authToken = new CustomerBuilder().named(name).loginAndGetToken();
        Report.pass("User is logged in via API");
    }
}
