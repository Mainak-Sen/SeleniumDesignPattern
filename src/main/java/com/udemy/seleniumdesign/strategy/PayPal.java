package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PayPal implements PaymentOption {

    @FindBy(id = "paypal_username")
    private WebElement paypalUsername;

    @FindBy(id = "paypal_password")
    private WebElement paypalPassword;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {

        this.paypalUsername.sendKeys(paymentDetails.get("paypalUsername"));
        this.paypalPassword.sendKeys(paymentDetails.get("paypalPassword"));
    }
}
