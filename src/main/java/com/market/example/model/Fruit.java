package com.market.example.model;

import java.math.BigDecimal;

/**
 * Business representation of the fruit
 */
public class Fruit {

    private Enum name;

    private BigDecimal price;

    private int quantity;

    public Fruit(Enum name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Enum getName() {
        return name;
    }

    public Fruit setName(Enum name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Fruit setPrice(BigDecimal price) {
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
