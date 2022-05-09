package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {

    @FindBy(id = "bank")
    private WebElement bankDropdown;

    @FindBy(id = "acc_number")
    private WebElement accountNumber;

    @FindBy(id = "pin")
    private WebElement pin;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {

        Select selectBank = new Select(this.bankDropdown);
        selectBank.selectByValue(paymentDetails.get("bankName"));

        this.accountNumber.sendKeys(paymentDetails.get("accountNumber"));
        this.pin.sendKeys(paymentDetails.get("pin"));
    }
}
