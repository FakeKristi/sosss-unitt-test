package com.example.eshop.product;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhysicalProductMaasTest {
    @Test
    void CreateNewPhysicalProduct() {
        String name = "Banana";
        String description = "A fruit";
        BigDecimal price =  new BigDecimal(15);
        double weight = 20;
        BigDecimal shippingCost =  new BigDecimal(10);

        PhysicalProduct newProduct = new PhysicalProduct(name, description, price, weight, shippingCost);

        assertAll("Verify product attributes",
                () -> assertEquals(name, newProduct.getName(), "name should match"),
                () -> assertEquals(description, newProduct.getDescription(), "Description should match"),
                () -> assertEquals(price, newProduct.getPrice(), "Price should match"),
                () -> assertEquals(weight, newProduct.getWeight(), "Download url should match"),
                () -> assertEquals(shippingCost, newProduct.getShippingCost(), "Download url should match")
        );
    }

    @Test
    void setWeightAndShippingCostUpdatesValues() {
        PhysicalProduct product = new PhysicalProduct(
                "Book",
                "Hardcover",
                BigDecimal.valueOf(20),
                1.0,
                BigDecimal.valueOf(5)
        );

        product.setWeight(2.5);
        product.setShippingCost(BigDecimal.valueOf(8));

        assertAll("Setters should update physical-product specific fields",
                () -> assertEquals(2.5, product.getWeight(), "Weight should be updated"),
                () -> assertEquals(BigDecimal.valueOf(8), product.getShippingCost(), "Shipping cost should be updated")
        );
    }

    @Test
    void allowZeroAndNegativeWeightInCurrentImplementation() {
        PhysicalProduct zeroWeight = new PhysicalProduct(
                "Sticker",
                "Light product",
                BigDecimal.ONE,
                0.0,
                BigDecimal.ZERO
        );
        PhysicalProduct negativeWeight = new PhysicalProduct(
                "Sample",
                "Edge case",
                BigDecimal.ONE,
                -1.0,
                BigDecimal.ZERO
        );

        assertAll("Current implementation does not validate weight",
                () -> assertEquals(0.0, zeroWeight.getWeight(), "Zero weight is kept"),
                () -> assertEquals(-1.0, negativeWeight.getWeight(), "Negative weight is kept")
        );
    }

}
