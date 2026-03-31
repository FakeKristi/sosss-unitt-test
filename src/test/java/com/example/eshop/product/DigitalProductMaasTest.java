package com.example.eshop.product;

import org.junit.jupiter.api.Test;
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

    @Test
    void setDownloadUrlUpdatesValue() {
        DigitalProduct product = new DigitalProduct(
                "Ebook",
                "PDF file",
                BigDecimal.valueOf(9),
                "/products/ebook-v1.pdf"
        );

        product.setDownloadUrl("/products/ebook-v2.pdf");

        assertEquals("/products/ebook-v2.pdf", product.getDownloadUrl(), "Setter should update download url");
    }

    @Test
    void allowNullDownloadUrlInCurrentImplementation() {
        DigitalProduct product = new DigitalProduct(
                "Course",
                "Video course",
                BigDecimal.valueOf(49),
                null
        );

        assertAll("Current implementation keeps null values",
                () -> assertEquals(null, product.getDownloadUrl(), "Constructor should keep null download url"),
                () -> {
                    product.setDownloadUrl(null);
                    assertEquals(null, product.getDownloadUrl(), "Setter should keep null download url");
                }
        );
    }

}
