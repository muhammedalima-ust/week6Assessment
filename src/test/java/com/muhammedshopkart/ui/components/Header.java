package com.muhammedshopkart.ui.components;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;
import com.muhammedshopkart.ui.pages.LoginPage;


public class Header {
    private final SelenideElement root;
    private final SelenideElement SIGNINBUTTON = Xp.signInButton();
    private final SelenideElement HEADER = Xp.header();
    public Header() {
        this.root = HEADER;
    }

    public LoginPage signIn() {
        SIGNINBUTTON.click();
        return new LoginPage();
    }

}
