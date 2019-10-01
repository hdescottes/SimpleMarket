package com.market.example.service;

import com.market.example.constant.FruitEnum;
import com.market.example.discount.Discount;
import com.market.example.model.Fruit;

import java.util.HashMap;

/**
 * Service that price the fruit
 */
public class ItemToPricerService {

    private HashMap<FruitEnum, Discount> map = new HashMap<>();

    public ItemToPricerService() {
    }

    Discount findPricer(Fruit fruit) {
        return map.get(fruit.getName());
    }

    public ItemToPricerService addDiscount(FruitEnum fruit, Discount discount) {
        map.put(fruit, discount);
        return this;
    }
}
