package com.market.example.service;

import com.market.example.ApplicationTest;
import com.market.example.config.PricerConfiguration;
import com.market.example.discount.AppleDiscount;
import com.market.example.model.Fruit;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.market.example.constant.FruitConstants.APPLE_PRICE;
import static com.market.example.constant.FruitEnum.APPLE;
import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
@ContextConfiguration(classes=PricerConfiguration.class)
public class ItemToPricerServiceTests {

    @Autowired
    private AppleDiscount appleDiscount;

    private ItemToPricerService itemToPricerService;

    @Test
    @Ignore("Figure out how to load config")
    public void findPricer_ShouldSucceed() {
        assertThat(itemToPricerService.findPricer(new Fruit(APPLE, APPLE_PRICE, 1))).isInstanceOf(AppleDiscount.class);
    }

    @Test
    public void addDiscount_ShouldSucceed() {
        ItemToPricerService itemToPricerService = new ItemToPricerService();
        assertThat(itemToPricerService.addDiscount(APPLE, appleDiscount)).isNotNull();
    }
}
