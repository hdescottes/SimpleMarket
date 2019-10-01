package com.market.example.controller;

import com.market.example.model.Fruit;
import com.market.example.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Fruit apple = new Fruit(APPLE, APPLE_PRICE, 5);
        Fruit orange = new Fruit(ORANGE, ORANGE_PRICE, 3);
        Fruit watermelon = new Fruit(WATERMELON, WATERMELON_PRICE, 3);
        HashMap<String, Fruit> fruits = new HashMap<>();
        fruits.put(apple.getName().name(), apple);
        fruits.put(orange.getName().name(), orange);
        fruits.put(watermelon.getName().name(), watermelon);
        redirectAttributes.addFlashAttribute("fruits", fruits);

        return "redirect:/basketList";
    }

    @GetMapping(value = "/basketList")
    public String retrieveBasketPrice(@ModelAttribute("fruits") HashMap<String, Fruit> fruits, Model model) {
        final List<Fruit> fruitList = new ArrayList<>();
        for(Map.Entry<String, Fruit> fruit : fruits.entrySet()) {
            fruitList.add(fruit.getValue());
        }
        model.addAttribute("map", marketService.discountCalculator(fruitList));
        return "basketList";
    }
}
