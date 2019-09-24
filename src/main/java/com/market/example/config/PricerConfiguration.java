package com.market.example.config;

import com.market.example.discount.AppleDiscount;
import com.market.example.discount.WatermelonDiscount;
import com.market.example.service.ItemToPricerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.market.example.constant.FruitEnum.APPLE;
import static com.market.example.constant.FruitEnum.WATERMELON;

/**
 * Config class to associate discount and fruit
 */
@Configuration
public class PricerConfiguration {

    @Autowired
    private AppleDiscount appleDiscount;

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    @Bean
    public ItemToPricerService pricerConfig() {
        return new ItemToPricerService()
                .addDiscount(APPLE, appleDiscount)
                .addDiscount(WATERMELON, watermelonDiscount);
    }
}
