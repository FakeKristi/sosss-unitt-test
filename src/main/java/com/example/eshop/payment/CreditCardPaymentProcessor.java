package com.example.eshop.payment;

import java.math.BigDecimal;

public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(BigDecimal amount) {
        System.out.println("Processing credit card payment of $" + amount);
        return true;
    }
}
