package com.market.example.discount;

import com.market.example.model.Fruit;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static com.market.example.constant.FruitEnum.APPLE;

/**
 * Implementation for the Apple discount
 */
@Component
public class AppleDiscount implements Discount{

    @Override
    public boolean isApplicableTo(Fruit fruit) {
        return Stream.of(fruit)
                .filter(f -> f.getName().equals(APPLE))
                .anyMatch(f -> f.getQuantity() >= 1);
    }

    @Override
    public BigDecimal price(Fruit fruit) {
        return fruit.getPrice().multiply(BigDecimal.valueOf(fruit.getQuantity() - fruit.getQuantity() / 2));
    }
}
