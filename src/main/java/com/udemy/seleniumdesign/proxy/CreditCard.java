package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCard implements PaymentOption {

    @FindBy(id = "cc")
    private WebElement creditCardNumber;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {

        //the above map in the argument will provide us with the payment details
        this.creditCardNumber.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
