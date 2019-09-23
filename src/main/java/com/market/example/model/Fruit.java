package com.market.example.model;

/**
 * Business representation of the fruit
 */
public class Fruit {

    private String name;

    private double price;

    private int quantity;

    public Fruit(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Fruit setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Fruit setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public Fruit setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
