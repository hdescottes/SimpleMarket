package com.market.example.discount;

import com.market.example.ApplicationTest;
import com.market.example.model.Fruit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class AppleDiscountTests {

    @Autowired
    private AppleDiscount appleDiscount;

    @Test
    void isApplicableTo_ShouldSucceedForOneApple() {
        Fruit apple = new Fruit("Apple", 0.20, 1);
        assertThat(appleDiscount.isApplicableTo(apple)).isTrue();
    }

    @Test
    void isApplicableTo_ShouldFailCauzNoApple() {
        Fruit apple = new Fruit("Apple", 0.20, 0);
        assertThat(appleDiscount.isApplicableTo(apple)).isFalse();
    }
}
