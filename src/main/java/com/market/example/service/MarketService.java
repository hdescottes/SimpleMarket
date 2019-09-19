package com.market.example.service;

import com.market.example.model.FruitDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.market.example.constant.FruitConstants.*;

@Service
public class MarketService {

    public MarketService() {
    }

    public HashMap<String, Double> createMarket() {
        HashMap<String, Double> items = new HashMap<>();
        FruitDto apple = new FruitDto("Apple", APPLE_PRICE);
        FruitDto orange = new FruitDto("Orange", ORANGE_PRICE);
        FruitDto watermelon = new FruitDto("Watermelon", WATERMELON_PRICE);
        items.put(apple.getName(), apple.getPrice());
        items.put(orange.getName(), orange.getPrice());
        items.put(watermelon.getName(), watermelon.getPrice());
        return items;
    }
}
