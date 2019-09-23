package com.market.example.service;

import com.market.example.discount.AppleDiscount;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.market.example.constant.FruitConstants.*;

@Service
public class MarketService {

    @Autowired
    private AppleDiscount appleDiscount;

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    public MarketService() {
    }

    public HashMap<String, Double> createMarket() {
        HashMap<String, Double> items = new HashMap<>();
        Fruit apple = new Fruit("Apple", APPLE_PRICE, 0);
        Fruit orange = new Fruit("Orange", ORANGE_PRICE, 0);
        Fruit watermelon = new Fruit("Watermelon", WATERMELON_PRICE, 0);
        items.put(apple.getName(), apple.getPrice());
        items.put(orange.getName(), orange.getPrice());
        items.put(watermelon.getName(), watermelon.getPrice());
        return items;
    }

    public HashMap<String, Double> discountCalculator(List<Fruit> items) {
        HashMap<String, Double> fruitTotal = new HashMap<>();
        for (Fruit fruit : items) {
            if (fruit.getName().equals("Apple")) {
                if (appleDiscount.isApplicableTo(fruit)) {
                    fruit.setQuantity(fruit.getQuantity() * 2);
                    fruitTotal.put(fruit.getName(), fruit.getPrice() * fruit.getQuantity() * appleDiscount.percentage());
                };
            }
            if (fruit.getName().equals("Watermelon")) {
                if (watermelonDiscount.isApplicableTo(fruit)) {
                    fruitTotal.put(fruit.getName(), fruit.getPrice() * (fruit.getQuantity() - fruit.getQuantity() / 3));
                }
            }
        }
        return fruitTotal;
    }
}
