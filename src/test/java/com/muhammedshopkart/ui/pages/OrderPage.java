package com.muhammedshopkart.ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.muhammedshopkart.ui.locators.Xp;


public class OrderPage {
    private static SelenideElement ORDER_STATUS = Xp.orderStatus();
    private static SelenideElement ADDRESS = Xp.deliveryAddress();
    private static SelenideElement HEADING = Xp.heading();

    public String getStatus(){
        return ORDER_STATUS.getText();
    }
    public String getAddress(){
        return ADDRESS.getText();
    }
    public String getHeading(){
        return HEADING.getText();
    }

}
