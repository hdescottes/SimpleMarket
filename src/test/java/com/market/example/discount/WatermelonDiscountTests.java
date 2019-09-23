package com.market.example.discount;

import com.market.example.ApplicationTest;
import com.market.example.model.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class WatermelonDiscountTests {

    @Autowired
    private WatermelonDiscount watermelonDiscount;

    @Test
    void isApplicableTo_ShouldSucceedForThreeWatermelon() {
        Fruit watermelon = new Fruit("Watermelon", 0.80, 3);
        assertThat(watermelonDiscount.isApplicableTo(watermelon)).isTrue();
    }

    @Test
    void isApplicableTo_ShouldFailCauzLessThanTwoWatermelon() {
        Fruit watermelon = new Fruit("Watermelon", 0.80, 1);
        assertThat(watermelonDiscount.isApplicableTo(watermelon)).isFalse();
    }
}
