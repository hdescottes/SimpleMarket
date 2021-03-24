package com.market.example.service;

import com.market.example.discount.AppleDiscount;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.model.Fruit;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.market.example.constant.FruitConstants.APPLE_PRICE;
import static com.market.example.constant.FruitConstants.ORANGE_PRICE;
import static com.market.example.constant.FruitConstants.WATERMELON_PRICE;
import static com.market.example.constant.FruitEnum.APPLE;
import static com.market.example.constant.FruitEnum.ORANGE;
import static com.market.example.constant.FruitEnum.WATERMELON;

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

    public List<Fruit> createMarket() {
         return new ArrayList<>(Arrays.asList(
                new Fruit(APPLE, APPLE_PRICE, 0),
                new Fruit(ORANGE, ORANGE_PRICE, 0),
                new Fruit(WATERMELON, WATERMELON_PRICE, 0)));
    }

    public Map<String, BigDecimal> discountCalculator(List<Fruit> items) {
        return items.stream()
                .map(f -> new ImmutablePair<>(f, itemToPricer.findPricer(f)))
                .filter(i -> i.getValue() != null)
                .filter(d -> d.getValue().isApplicableTo(d.getKey()))
                .collect(Collectors.toMap(p -> p.getKey().getName(), p -> p.getValue().price(p.getKey())));
    }

    //FIXME: Simplify this into the previous one
    public Map<String, BigDecimal> hasNoDiscount(List<Fruit> items) {
        return items.stream()
                .map(f -> new ImmutablePair<>(f, itemToPricer.findPricer(f)))
                .filter(i -> i.getValue() == null)
                .collect(Collectors.toMap(p -> p.getKey().getName(), p -> (p.getKey().getPrice().multiply(BigDecimal.valueOf(p.getKey().getQuantity())))));
    }
}
