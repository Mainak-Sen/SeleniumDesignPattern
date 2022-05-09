package com.udemy.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    private static final Supplier<PaymentOption> CC = () -> new CreditCard();
    private static final Supplier<PaymentOption> NB = () -> new NetBanking();
    private static final Supplier<PaymentOption> PP = () -> new PayPal();

    private static final Map<String, Supplier<PaymentOption>> map = new HashMap<>();

    static {
        map.put("CC", CC);
        map.put("NB", NB);
        map.put("PP", PP);
    }

    public static PaymentOption getPaymentOption(String option) {
        return map.get(option).get();
    }

}
