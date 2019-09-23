package com.market.example.service;

import com.market.example.ApplicationTest;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.market.example.constant.FruitConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ApplicationTest
class MarketServiceTests {

    @Autowired
    private MarketService marketService;

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    @Test
    void createMarket_ShouldSucceed() {
        HashMap<String, Double> items = marketService.createMarket();
        assertEquals(3, items.size());
        assertThat(items.containsKey("Apple")).isTrue();
        assertThat(items.containsKey("Orange")).isTrue();
        assertThat(items.containsKey("Watermelon")).isTrue();
    }

    @Test
    void discountCalculator_ShouldSucceed() {
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Apple", APPLE_PRICE, 3));
        fruitList.add(new Fruit("Orange", ORANGE_PRICE, 5));
        fruitList.add(new Fruit("Watermelon", WATERMELON_PRICE, 5));
        HashMap<String , Double> fruitDiscount = marketService.discountCalculator(fruitList);
        for(Map.Entry<String, Double> fruit : fruitDiscount.entrySet()) {
            if(fruit.getKey().equals("Apple"))
                assertThat(Math.round(fruit.getValue())).isEqualTo(Math.round(APPLE_PRICE * fruitList.get(0).getQuantity() / 2));
            if(fruit.getKey().equals("Watermelon"))
                assertThat(Math.round(fruit.getValue())).isEqualTo(Math.round(WATERMELON_PRICE * (fruitList.get(2).getQuantity() - (fruitList.get(2).getQuantity() / 3))));
        }
    }
}
