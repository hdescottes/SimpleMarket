package com.market.example.service;

import com.market.example.ApplicationTest;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;

import static com.market.example.constant.FruitConstants.*;
import static com.market.example.constant.FruitEnum.*;
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
        Map<String, BigDecimal> items = marketService.createMarket();
        assertEquals(3, items.size());
        assertThat(items.containsKey(APPLE.toString())).isTrue();
        assertThat(items.containsKey(ORANGE.toString())).isTrue();
        assertThat(items.containsKey(WATERMELON.toString())).isTrue();
    }

    @Test
    void discountCalculator_ShouldSucceed() {
        List<Fruit> fruitList = new ArrayList<>(Arrays.asList(
                new Fruit(APPLE, APPLE_PRICE, 3),
                new Fruit(ORANGE, ORANGE_PRICE, 5),
                new Fruit(WATERMELON, WATERMELON_PRICE, 5)));
        Map<String , BigDecimal> fruitDiscount = marketService.discountCalculator(fruitList);
        for(Map.Entry<String, BigDecimal> fruit : fruitDiscount.entrySet()) {
            if(fruit.getKey().equals(APPLE.getName()))
                assertThat(fruit.getValue()).isEqualTo(APPLE_PRICE.multiply(BigDecimal.valueOf(fruitList.get(0).getQuantity() / 2)));
            if(fruit.getKey().equals(WATERMELON.getName()))
                assertThat(fruit.getValue()).isEqualTo(WATERMELON_PRICE.multiply(BigDecimal.valueOf(fruitList.get(2).getQuantity() - (fruitList.get(2).getQuantity() / 3))));
        }
    }
}
