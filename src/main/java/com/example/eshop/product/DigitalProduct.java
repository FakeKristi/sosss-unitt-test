package com.example.eshop.product;

import java.math.BigDecimal;

public class DigitalProduct extends Product {
    private String downloadUrl;

    public DigitalProduct(String name, String description, BigDecimal price, String downloadUrl) {
        super(name, description, price);
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
