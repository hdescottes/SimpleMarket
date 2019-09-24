package com.market.example.discount;

import com.market.example.model.Fruit;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static com.market.example.constant.FruitEnum.WATERMELON;

/**
 * Implementation for the Watermelon discount
 */
@Component
public class WatermelonDiscount implements Discount {

    @Override
    public boolean isApplicableTo(Fruit fruit) {
        return Stream.of(fruit)
                .filter(f -> f.getName().equals(WATERMELON))
                .anyMatch(f -> f.getQuantity() >= 3);
    }

    @Override
    public BigDecimal price(Fruit fruit) {
        return fruit.getPrice().multiply(BigDecimal.valueOf(fruit.getQuantity() - fruit.getQuantity() / 3));
    }
}
