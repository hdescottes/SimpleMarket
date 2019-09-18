package com.market.example.controller;

import com.market.example.model.FruitDto;
import com.market.example.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping(value = "/")
    public String sendBasket(RedirectAttributes redirectAttributes) {
        HashMap<String, Double> fruits = marketService.createMarket();
        redirectAttributes.addAllAttributes(fruits);

        return "redirect:/basketList";
    }

    @GetMapping(value = "/basketList")
    public String retrieveBasketPrice(@RequestParam HashMap<String, String> fruits, Model model) {
        final Map<String, Object> map = new HashMap<>();
        double quantity = 2.0;
        for(Map.Entry<String, String> fruit : fruits.entrySet()) {
            map.put(fruit.getKey(), Double.parseDouble(fruit.getValue()) * quantity);
        }
        model.addAttribute("map", map);
        return "basketList";
    }
}
