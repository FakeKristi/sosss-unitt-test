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

}
