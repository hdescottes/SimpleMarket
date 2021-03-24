package com.market.example.controller;

import com.market.example.model.Fruit;
import com.market.example.model.FruitListWrapper;
import com.market.example.repository.FruitRepository;
import com.market.example.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class DisplayItemsController {

    private MarketService marketService;

    private FruitRepository fruitRepository;

    public DisplayItemsController(MarketService marketService, FruitRepository fruitRepository) {
        this.marketService = marketService;
        this.fruitRepository = fruitRepository;

        List<Fruit> fruitList = marketService.createMarket();
        fruitList.forEach(fruitRepository::save);
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/basketList").setViewName("basketList");
    }

    @GetMapping(value = "/")
    public String retrieveMarketItems(Model model) {
        FruitListWrapper wrapper = new FruitListWrapper((List<Fruit>) fruitRepository.findAll());
        model.addAttribute("wrapper", wrapper);
        return "marketList";
    }


    @PostMapping(value = "/")
    public String sendBasket(@ModelAttribute FruitListWrapper wrapper, RedirectAttributes redirectAttributes, Model model) {
        Map<String, Fruit> fruits = wrapper.getFruitList().stream()
                .collect(Collectors.toMap(Fruit::getName, f -> f));
        redirectAttributes.addFlashAttribute("fruits", fruits);

        return "redirect:/basketList";
    }

    @GetMapping(value = "/basketList")
    public String retrieveBasketPrice(@ModelAttribute("fruits") HashMap<String, Fruit> fruits, Model model) {
        final List<Fruit> fruitList = new ArrayList<>();
        for(Map.Entry<String, Fruit> fruit : fruits.entrySet()) {
            fruitList.add(fruit.getValue());
        }
        Map<String, BigDecimal> map = marketService.discountCalculator(fruitList);
        map.putAll(marketService.hasNoDiscount(fruitList));
        model.addAttribute("map", map);
        return "basketList";
    }
}
