package com.market.example.service;

import com.market.example.discount.AppleDiscount;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static com.market.example.constant.FruitConstants.*;
import static com.market.example.constant.FruitEnum.*;

@Service
public class MarketService {

    @Autowired
    private AppleDiscount appleDiscount;

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    @Autowired
    private ItemToPricerService itemToPricer;

    public MarketService() {
    }

    public HashMap<String, BigDecimal> createMarket() {
        HashMap<String, BigDecimal> items = new HashMap<>();
        Fruit apple = new Fruit(APPLE, APPLE_PRICE, 0);
        Fruit orange = new Fruit(ORANGE, ORANGE_PRICE, 0);
        Fruit watermelon = new Fruit(WATERMELON, WATERMELON_PRICE, 0);
        items.put(apple.getName().name(), apple.getPrice());
        items.put(orange.getName().name(), orange.getPrice());
        items.put(watermelon.getName().name(), watermelon.getPrice());
        return items;
    }

    public HashMap<String, BigDecimal> discountCalculator(List<Fruit> items) {
        HashMap<String, BigDecimal> fruitTotal = new HashMap<>();
        for (Fruit fruit : items) {
            itemToPricer.findPricer(fruit);
            if (fruit.getName().equals("Apple")) {
                if (appleDiscount.isApplicableTo(fruit)) {
                    fruitTotal.put(fruit.getName().name(), appleDiscount.price(fruit));
                }
            }
            if (fruit.getName().equals("Watermelon")) {
                if (watermelonDiscount.isApplicableTo(fruit)) {
                    fruitTotal.put(fruit.getName().name(), watermelonDiscount.price(fruit));
                }
            }
        }
        return fruitTotal;
    }
}
