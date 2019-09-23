package com.market.example.discount;

import com.market.example.model.Fruit;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class AppleDiscount implements Discount{

    @Override
    public double percentage() {
        return 0.50;
    }

    @Override
    public boolean isApplicableTo(Fruit fruit) {
        return Stream.of(fruit)
                .filter(f -> f.getName().equals("Apple"))
                .anyMatch(f -> f.getQuantity() >= 1);
    }
}
