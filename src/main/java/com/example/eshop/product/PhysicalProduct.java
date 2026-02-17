package com.example.eshop.product;

import java.math.BigDecimal;

public class PhysicalProduct extends Product {
    private double weight;
    private BigDecimal shippingCost;

    public PhysicalProduct(String name, String description, BigDecimal price, double weight, BigDecimal shippingCost) {
        super(name, description, price);
        this.weight = weight;
        this.shippingCost = shippingCost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }
}
