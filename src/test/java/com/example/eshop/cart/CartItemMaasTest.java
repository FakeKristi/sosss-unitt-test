package com.example.eshop.cart;

import com.example.eshop.product.DigitalProduct;
import com.example.eshop.product.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemMaasTest {

    private Product newProduct(BigDecimal price) {
        return new DigitalProduct("ebook", "test product", price, "https://example.com/download");
    }

    @Test
    void createProduct() {
        Product product = newProduct(BigDecimal.valueOf(120));

        CartItem item = new CartItem(product, 2);

        assertAll("CartItem should be created with expected values",
                () -> assertSame(product, item.getProduct(), "Product reference should match"),
                () -> assertEquals(2, item.getQuantity(), "Quantity should match constructor value"),
                () -> assertEquals(BigDecimal.valueOf(240), item.getTotalPrice(), "Total price should be price * quantity")
        );
    }

    @Test
    void createProductInvalidQuantity() {
        Product product = newProduct(BigDecimal.TEN);

        assertAll("Invalid constructor quantity should throw",
                () -> assertThrows(IllegalArgumentException.class, () -> new CartItem(product, 0)),
                () -> assertThrows(IllegalArgumentException.class, () -> new CartItem(product, -1))
        );

    }

    @Test
    void getters() {
        Product product = newProduct(BigDecimal.valueOf(50));
        CartItem item = new CartItem(product, 3);

        assertAll("Getters should return stored values",
                () -> assertSame(product, item.getProduct(), "getProduct should return assigned product"),
                () -> assertEquals(3, item.getQuantity(), "getQuantity should return assigned quantity"),
                () -> assertEquals(BigDecimal.valueOf(150), item.getTotalPrice(), "getTotalPrice should reflect quantity and price")
        );
    }

    @Test
    void setters() {
        CartItem item = new CartItem(newProduct(BigDecimal.valueOf(99)), 1);

        item.setQuantity(4);

        assertAll("Setter should update quantity and validate input",
                () -> assertEquals(4, item.getQuantity(), "Quantity should be updated by setter"),
                () -> assertEquals(BigDecimal.valueOf(396), item.getTotalPrice(), "Total price should use updated quantity"),
                () -> assertThrows(IllegalArgumentException.class, () -> item.setQuantity(0)),
                () -> assertThrows(IllegalArgumentException.class, () -> item.setQuantity(-3))
        );
    }
}
