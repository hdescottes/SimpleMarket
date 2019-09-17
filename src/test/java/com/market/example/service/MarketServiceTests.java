package com.market.example.service;

import com.market.example.ApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ApplicationTest
class MarketServiceTests {

    @Autowired
    private MarketService marketService;

    @Test
    void createMarket_ShouldSucceed() {
        HashMap<String, Double> items = marketService.createMarket();
        assertEquals(3, items.size());
        assertThat(items.containsKey("Apple")).isTrue();
        assertThat(items.containsKey("Orange")).isTrue();
        assertThat(items.containsKey("Watermelon")).isTrue();
    }
}
