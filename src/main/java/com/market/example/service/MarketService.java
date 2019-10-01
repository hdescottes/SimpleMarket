package com.market.example.service;

import com.market.example.discount.AppleDiscount;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    //FIXME: les fruits sans discount ne sont pas dans la map /!\
    public Map<String, BigDecimal> discountCalculator(List<Fruit> items) {
        Map<String, BigDecimal> map = new HashMap<>();
        return items.stream()
                .map(f -> new Pair<>(f, itemToPricer.findPricer(f)))
                .filter(i -> i.getValue() != null)
                .filter(d -> d.getValue().isApplicableTo(d.getKey()))
                .collect(Collectors.toMap(p -> p.getKey().getName().name(), p -> p.getValue().price(p.getKey())));
    }
}
