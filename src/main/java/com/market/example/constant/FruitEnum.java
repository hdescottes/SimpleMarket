package com.market.example.constant;

/**
 * Fruit Enum
 */
public enum FruitEnum {

    APPLE("Apple"),
    ORANGE("Orange"),
    WATERMELON("Watermelon");

    private String name;

    FruitEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
