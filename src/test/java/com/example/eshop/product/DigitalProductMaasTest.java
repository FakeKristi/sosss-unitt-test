package com.example.eshop.product;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalProductMaasTest {


    @ParameterizedTest
    @ValueSource(strings = {"Banana", "Apple"})
    void CreateNewDigitalProduct(String name) {
        String description = "A fruit";
        BigDecimal price =  new BigDecimal(15);
        String downloadUrl = "/products/"+name+".html";

        DigitalProduct newDigitalProduct = new DigitalProduct(name, description, price, downloadUrl);

        assertAll("Verify product attributes",
                () -> assertEquals(name, newDigitalProduct.getName(), "name should match"),
                () -> assertEquals(description, newDigitalProduct.getDescription(), "Description should match"),
                () -> assertEquals(price, newDigitalProduct.getPrice(), "Price should match"),
                () -> assertEquals(downloadUrl, newDigitalProduct.getDownloadUrl(), "Download url should match")
        );
    }

}
