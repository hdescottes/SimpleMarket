package com.market.example.model;

import com.market.example.constant.FruitEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Business representation of the fruit
 */
@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private int quantity;

    public Fruit() {
    }

    public Fruit(FruitEnum name, BigDecimal price, int quantity) {
        this.name = name.getName();
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
