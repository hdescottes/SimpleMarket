package com.market.example.discount;

import com.market.example.model.Fruit;

public interface Discount {

    double percentage();

    boolean isApplicableTo(Fruit fruit);
}
