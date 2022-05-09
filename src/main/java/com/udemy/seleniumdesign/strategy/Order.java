package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

    @FindBy(id = "buy")
    private WebElement buyNow;

    @FindBy(id = "ordernumber")
    private WebElement orderId;

    public Order(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String placeOrderAndGetOrderNumber() {
        this.buyNow.click();
        return this.orderId.getText();
    }
}
