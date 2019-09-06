package com.test.example.controller;

import com.test.example.model.FruitDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static com.test.example.constant.FruitConstants.*;

@RestController
public class DisplayItemsController {

    private final FruitDto fruitDto;

    public DisplayItemsController(FruitDto fruitDto) {
        this.fruitDto = fruitDto;
    }

    private HashMap<String, Double> market() {
        HashMap<String, Double> items = new HashMap<>();
        items.put(fruitDto.setName("Apple").getName(), fruitDto.setPrice(APPLE_PRICE).getPrice());
        items.put(fruitDto.setName("Orange").getName(), fruitDto.setPrice(ORANGE_PRICE).getPrice());
        items.put(fruitDto.setName("Watermelon").getName(), fruitDto.setPrice(WATERMELON_PRICE).getPrice());
        return items;
    }

    @GetMapping(value = "/")
    public String getItems(Model model) {
        model.addAttribute("items", market());
        return "marketList";
    }
}
