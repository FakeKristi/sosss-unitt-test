package com.example.eshop.order;

import com.example.eshop.cart.Cart;
import com.example.eshop.payment.PaymentProcessor;

public class OrderService {
    private final PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public Order placeOrder(Cart cart) {
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot place an order with an empty cart");
        }

        Order order = new Order(cart);

        if (paymentProcessor.processPayment(order.getTotalAmount())) {
            order.setStatus(OrderStatus.PAID);
        } else {
            // Handle payment failure case (e.g., throw exception or set specific status)
            // For simplicity, we just leave it as PENDING or could cancel it
            order.setStatus(OrderStatus.CANCELLED);
        }

        cart.clear(); // Empty the cart after order is placed
        return order;
    }
}
