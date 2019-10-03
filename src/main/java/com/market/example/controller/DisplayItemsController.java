package com.market.example.controller;

import com.market.example.model.Fruit;
import com.market.example.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.market.example.constant.FruitConstants.*;
import static com.market.example.constant.FruitEnum.*;

@Controller
public class DisplayItemsController {

    private MarketService marketService;

    public DisplayItemsController(MarketService marketService) {
        this.marketService = marketService;
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/basketList").setViewName("basketList");
    }

    @GetMapping(value = "/")
    public String retrieveMarketItems(Model model) {
        model.addAttribute("items", marketService.createMarket());
        return "marketList";
    }


    //FIXME: Récupérer les valeurs depuis l'IHM
    @PostMapping(value = "/")
    public String sendBasket(RedirectAttributes redirectAttributes, Model model) {
        List<Fruit> fruitList = new ArrayList<>(Arrays.asList(
                new Fruit(APPLE, APPLE_PRICE, 5),
                new Fruit(ORANGE, ORANGE_PRICE, 3),
                new Fruit(WATERMELON, WATERMELON_PRICE, 3)));
        Map<String, Fruit> fruits = fruitList.stream()
                .collect(Collectors.toMap(f -> f.getName().name(), f -> f));
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
