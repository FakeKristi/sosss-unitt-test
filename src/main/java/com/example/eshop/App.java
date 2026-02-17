package com.example.eshop;

import com.example.eshop.cart.Cart;
import com.example.eshop.order.Order;
import com.example.eshop.order.OrderService;
import com.example.eshop.payment.CreditCardPaymentProcessor;
import com.example.eshop.product.DigitalProduct;
import com.example.eshop.product.PhysicalProduct;
import com.example.eshop.product.Product;

import java.math.BigDecimal;

/**
 * E-Shop Demo Application
 */
public class App {
    public static void main(String[] args) {
        System.out.println("--- E-Shop Demo Started ---");

        // 1. Create Products
        Product laptop = new PhysicalProduct(
                "Gaming Laptop",
                "High-end gaming laptop",
                new BigDecimal("1500.00"),
                2.5,
                new BigDecimal("20.00"));

        Product ebook = new DigitalProduct(
                "Java Mastery",
                "Advanced Java Programming E-book",
                new BigDecimal("29.99"),
                "https://example.com/download/java-mastery");

        System.out.println("Created Product: " + laptop.getName() + " - $" + laptop.getPrice());
        System.out.println("Created Product: " + ebook.getName() + " - $" + ebook.getPrice());

        // 2. Add to Cart
        Cart cart = new Cart();
        cart.addItem(laptop, 1);
        cart.addItem(ebook, 2);

        System.out.println("\nAdded items to cart. Total: $" + cart.calculateTotal());

        // 3. Place Order
        CreditCardPaymentProcessor paymentProcessor = new CreditCardPaymentProcessor();
        OrderService orderService = new OrderService(paymentProcessor);

        try {
            Order order = orderService.placeOrder(cart);
            System.out.println("\nOrder Placed Successfully!");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Order Status: " + order.getStatus());
            System.out.println("Order Amount: $" + order.getTotalAmount());
        } catch (Exception e) {
            System.err.println("Failed to place order: " + e.getMessage());
        }

        System.out.println("\n--- E-Shop Demo Finished ---");
    }
}
