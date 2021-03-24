package com.market.example.repository;

import com.market.example.model.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends CrudRepository<Fruit, Long> {

    List<Fruit> findByName(String name);
}
