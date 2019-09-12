package com.test.example.service;

import com.test.example.model.FruitDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.test.example.constant.FruitConstants.*;

@Service
public class MarketService {

    private final FruitDto fruitDto;

    public MarketService(FruitDto fruitDto) {
        this.fruitDto = fruitDto;
    }

    public HashMap<String, Double> createMarket() {
        HashMap<String, Double> items = new HashMap<>();
        items.put(fruitDto.setName("Apple").getName(), fruitDto.setPrice(APPLE_PRICE).getPrice());
        items.put(fruitDto.setName("Orange").getName(), fruitDto.setPrice(ORANGE_PRICE).getPrice());
        items.put(fruitDto.setName("Watermelon").getName(), fruitDto.setPrice(WATERMELON_PRICE).getPrice());
        return items;
    }
}
