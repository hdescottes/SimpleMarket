package com.market.example.discount;

import com.market.example.model.Fruit;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class WatermelonDiscount implements Discount {


    @Override
    public double percentage() {
        return 0.33;
    }

    @Override
    public boolean isApplicableTo(Fruit fruit) {
        return Stream.of(fruit)
                .filter(f -> f.getName().equals("Watermelon"))
                .anyMatch(f -> f.getQuantity() >= 3);
    }
}
