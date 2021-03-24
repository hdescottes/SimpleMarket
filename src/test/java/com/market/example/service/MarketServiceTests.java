package com.market.example.service;

import com.market.example.ApplicationTest;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.market.example.constant.FruitConstants.APPLE_PRICE;
import static com.market.example.constant.FruitConstants.ORANGE_PRICE;
import static com.market.example.constant.FruitConstants.WATERMELON_PRICE;
import static com.market.example.constant.FruitEnum.APPLE;
import static com.market.example.constant.FruitEnum.ORANGE;
import static com.market.example.constant.FruitEnum.WATERMELON;
import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class MarketServiceTests {

    @Autowired
    private MarketService marketService;

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    @Test
    void discountCalculator_ShouldSucceed() {
        List<Fruit> fruitList = new ArrayList<>(Arrays.asList(
                new Fruit(APPLE, APPLE_PRICE, 3),
                new Fruit(ORANGE, ORANGE_PRICE, 5),
                new Fruit(WATERMELON, WATERMELON_PRICE, 5)));
        Map<String, BigDecimal> fruitDiscount = marketService.discountCalculator(fruitList);
        for(Map.Entry<String, BigDecimal> fruit : fruitDiscount.entrySet()) {
            if(fruit.getKey().equals(APPLE.getName()))
                assertThat(fruit.getValue()).isEqualTo(APPLE_PRICE.multiply(BigDecimal.valueOf(fruitList.get(0).getQuantity() / 2)));
            if(fruit.getKey().equals(WATERMELON.getName()))
                assertThat(fruit.getValue()).isEqualTo(WATERMELON_PRICE.multiply(BigDecimal.valueOf(fruitList.get(2).getQuantity() - (fruitList.get(2).getQuantity() / 3))));
        }
    }
}
