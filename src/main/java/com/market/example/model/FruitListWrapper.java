package com.market.example.model;

import java.util.List;

public class FruitListWrapper {

    private List<Fruit> fruitList;

    public FruitListWrapper(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
}
