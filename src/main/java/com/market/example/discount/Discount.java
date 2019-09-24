package com.market.example.discount;

import com.market.example.model.Fruit;

import java.math.BigDecimal;

public interface Discount {

    boolean isApplicableTo(Fruit fruit);

    BigDecimal price(Fruit fruit);
}
