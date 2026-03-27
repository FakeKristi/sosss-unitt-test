package com.example.eshop.cart;

import com.example.eshop.product.DigitalProduct;
import com.example.eshop.product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CartMaasTest {
    private Cart c;

    private Product newProduct() {
        String name = String.valueOf(UUID.randomUUID());
        String description = String.valueOf(UUID.randomUUID());
        BigDecimal price = BigDecimal.valueOf(System.currentTimeMillis());
        String downloadUrl = "https://www.web.com/" + String.valueOf(name);
        return new DigitalProduct(name, description, price, downloadUrl);
    }

    @Test
    void addProduct() {
        c = new Cart();

        Product p = newProduct();

        c.addItem(p, 1);

        List<Product> products = c.getItems().stream().map(c -> c.getProduct()).toList();

        assertAll("Verify item added",
                () -> assertTrue(products.contains(p), "Added item must be in cart")
        );
    }

    @Test
    void removeProduct() {
        c = new Cart();

        Product p = newProduct();

        c.addItem(p, 1);

        c.removeItem(p);

        List<Product> products = c.getItems().stream().map(c -> c.getProduct()).toList();

        assertAll("Verify item removed",
                () -> assertFalse(products.contains(p),"Item should be removed"));
    }

    @Test
    void addQuantityProduct() {
        c = new Cart();

        Product p = newProduct();

        c.addItem(p, 1);
        c.addItem(p, 1);

        assertAll("Verify item added",
                () -> assertEquals(2, c.getItems().stream()
                        .filter(
                                cartItem -> cartItem.getProduct().equals(p)
                        ).findFirst()
                        .get().getQuantity(), "Same items should be in one cart item")
        );
    }

    @Test
    void calculateTotal() {
        c = new Cart();

        c.addItem(newProduct(), 1);
        c.addItem(newProduct(), 1);

        BigDecimal total = c.getItems().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        assertAll("Verify item added",
                () -> assertEquals(total, c.calculateTotal(), "Total price should match")
        );
    }

    @Test
    void clearProducts() {
        c = new Cart();

        Product p = newProduct();

        c.addItem(p, 1);

        c.clear();
        assertAll("Verify item cleared",
                () -> assertTrue(c.getItems().isEmpty(), "Items should be empty")
        );
    }
}
