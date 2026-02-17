package com.example.eshop.order;

import com.example.eshop.cart.CartItem;
import com.example.eshop.cart.Cart;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final List<CartItem> items;
    private final BigDecimal totalAmount;
    private final LocalDateTime orderDate;
    private OrderStatus status;

    public Order(Cart cart) {
        this.id = UUID.randomUUID();
        this.items = List.copyOf(cart.getItems()); // Create immutable copy
        this.totalAmount = cart.calculateTotal();
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
