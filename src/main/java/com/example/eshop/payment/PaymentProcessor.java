package com.example.eshop.payment;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean processPayment(BigDecimal amount);
}
