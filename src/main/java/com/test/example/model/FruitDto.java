package com.test.example.model;

import org.springframework.stereotype.Component;

/**
 * Business representation of the fruit
 */
@Component
public class FruitDto {

    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public FruitDto setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public FruitDto setPrice(double price) {
        this.price = price;
        return this;
    }
}
