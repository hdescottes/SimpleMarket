package com.market.example.model;

import com.market.example.constant.FruitEnum;

import java.math.BigDecimal;

/**
 * Business representation of the fruit
 */
public class Fruit {

    private FruitEnum name;

    private BigDecimal price;

    private int quantity;

    public Fruit(FruitEnum name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public FruitEnum getName() {
        return name;
    }

    public Fruit setName(FruitEnum name) {
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
