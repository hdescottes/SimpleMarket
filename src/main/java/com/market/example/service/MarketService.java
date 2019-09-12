package com.market.example.service;

import com.market.example.constant.FruitConstants;
import com.market.example.model.FruitDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MarketService {

    private final FruitDto fruitDto;

    public MarketService(FruitDto fruitDto) {
        this.fruitDto = fruitDto;
    }

    public HashMap<String, Double> createMarket() {
        HashMap<String, Double> items = new HashMap<>();
        items.put(fruitDto.setName("Apple").getName(), fruitDto.setPrice(FruitConstants.APPLE_PRICE).getPrice());
        items.put(fruitDto.setName("Orange").getName(), fruitDto.setPrice(FruitConstants.ORANGE_PRICE).getPrice());
        items.put(fruitDto.setName("Watermelon").getName(), fruitDto.setPrice(FruitConstants.WATERMELON_PRICE).getPrice());
        return items;
    }
}
