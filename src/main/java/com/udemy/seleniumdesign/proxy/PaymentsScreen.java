package com.udemy.seleniumdesign.proxy;

import com.udemy.seleniumdesign.strategy.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentsScreen {

    private WebDriver driver;

    private UserInformation userInformation;
    private PaymentOption paymentOption;
    private OrderComponent orderComponent;


    public PaymentsScreen(final WebDriver driver) {
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.orderComponent = new OrderComponentProxy(driver);
    }

    public OrderComponent getOrder() {
        return this.orderComponent;
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails) {
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}
