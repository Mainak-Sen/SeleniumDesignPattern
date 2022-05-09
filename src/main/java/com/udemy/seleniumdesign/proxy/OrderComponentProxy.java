package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {

    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGING", "PRE-PROD");
    private OrderComponent orderComponent;
    private static String currentEnv;

    public OrderComponentProxy(WebDriver driver) {
        currentEnv = System.getProperty("env");
        this.orderComponent = !EXCLUDED.contains(currentEnv) ? new OrderComponentReal(driver) : null;
    }

    @Override
    public String placeOrderAndGetOrderNumber() {
        //we want to skip clicking buyNow on EXCLUDED envs
        return Objects.nonNull(orderComponent)
                ? orderComponent.placeOrderAndGetOrderNumber()
                : "SKIPPED" + " in " + currentEnv + " environment";
    }
}
