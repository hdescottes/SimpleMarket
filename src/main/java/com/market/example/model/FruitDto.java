package com.market.example.model;

/**
 * Business representation of the fruit
 */
public class FruitDto {

    private String name;

    private double price;

    public FruitDto(String name, double price) {
        this.name = name;
        this.price = price;
    }

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
