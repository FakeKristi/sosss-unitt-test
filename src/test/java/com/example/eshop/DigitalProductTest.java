package com.example.eshop;

import com.example.eshop.product.DigitalProduct;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalProductTest {

    @Test
    void CreateNewDigitalProduct() {
        String name = "Banana";
        String description = "A fruit";
        BigDecimal price =  new BigDecimal(15);
        String downloadUrl = "/products/banana.html";

        DigitalProduct newDigitalProduct = new DigitalProduct(name, description, price, downloadUrl);

        assertAll("Verify product attributes",
                () -> assertEquals(name, newDigitalProduct.getName(), "name should match"),
                () -> assertEquals(description, newDigitalProduct.getDescription(), "Description should match"),
                () -> assertEquals(price, newDigitalProduct.getPrice(), "Price should match"),
                () -> assertEquals(downloadUrl, newDigitalProduct.getDownloadUrl(), "Download url should match")
        );
    }

    @Test
    void getDownloadUrl() {
        String name = "Banana";
        String description = "A fruit";
        BigDecimal price =  new BigDecimal(15);
        String downloadUrl = "/products/banana.html";

        DigitalProduct newDigitalProduct = new DigitalProduct(name, description, price, downloadUrl);

        assertAll(

        );
    }

}
