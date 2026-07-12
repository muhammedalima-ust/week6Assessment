package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;

import static com.codeborne.selenide.Condition.visible;

/**
 * This Login page Contain all the method in the "/loginpage" url page
 */
public class LoginPage {
    private final SelenideElement EMAIL_INPUT = Xp.emailInput();
    private final SelenideElement PASSWORD_INPUT = Xp.passwordInput();
    private final SelenideElement SIGN_BUTTON = Xp.signButton();

    /**
     * Input Email
     */
    public LoginPage enterEmail(String email) {

        EMAIL_INPUT.shouldBe(visible)
                .setValue(email);
        return this;
    }
    /**
     * Input Passowrd
     */
    public LoginPage enterPassword(String password) {
        PASSWORD_INPUT.shouldBe(visible)
                .setValue(password);
        return this;
    }
    /**
     * Input Passowrd
     */
    public Homepage signin() {
        SIGN_BUTTON.shouldBe(visible)
                .click();
        return new Homepage();
    }
}
