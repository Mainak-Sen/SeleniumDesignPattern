package com.udemy.seleniumdesign.proxy;

import java.util.Map;

public interface PaymentOption {

    //by default interface methods are public static final
    void enterPaymentInformation(Map<String, String> paymentDetails);
}
