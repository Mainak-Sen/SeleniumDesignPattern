package com.udemy.seleniumdesign.test.proxy;


import com.udemy.seleniumdesign.proxy.PaymentOptionFactory;
import com.udemy.seleniumdesign.proxy.PaymentsScreen;
import com.udemy.seleniumdesign.test.srp.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {

    private PaymentsScreen paymentsScreen;

    @BeforeTest
    public void setPaymentsScreen() {
        System.setProperty("env", "PROD");
        this.paymentsScreen = new PaymentsScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentsScreenTest(String option, Map<String, String> paymentDetails) {

        this.paymentsScreen.goTo();
        this.paymentsScreen.getUserInformation().enterDetails("Mainak", "Sen", "mainak.sen@automation.com");
        this.paymentsScreen.setPaymentOption(PaymentOptionFactory.getPaymentOption(option));//getting payment option from payment option factory
        this.paymentsScreen.pay(paymentDetails);
        String orderNumber = this.paymentsScreen.getOrder().placeOrderAndGetOrderNumber();
        System.out.println("Order Number is : " + orderNumber);
    }

    @DataProvider
    public Object[][] getData() {

        //there are three payment options
  /*      1.Creditcard
            2. NetBanking
            3. Paypal*/

        Map<String, String> creditCardDetails = Maps.newHashMap();
        creditCardDetails.put("cc", "Visa");
        creditCardDetails.put("year", "1991");
        creditCardDetails.put("cvv", "101");

        Map<String, String> netBankingDetails = Maps.newHashMap();
        netBankingDetails.put("bankName", "WELLS FARGO");
        netBankingDetails.put("accountNumber", "123456789");
        netBankingDetails.put("pin", "220");

        Map<String, String> payPalAccountDetails = Maps.newHashMap();
        payPalAccountDetails.put("paypalUsername", "mainakStoner");
        payPalAccountDetails.put("paypalPassword", "123456789");

        return new Object[][]
                {
                        {"CC", creditCardDetails},
                        {"NB", netBankingDetails},
                        {"PP", payPalAccountDetails}
                };
    }

}
