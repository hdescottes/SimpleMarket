package com.test.example.controller;

import com.test.example.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayItemsController {

    private MarketService marketService;

    public DisplayItemsController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping(value = "/")
    public String getItems(Model model) {
        model.addAttribute("items", marketService.createMarket());
        return "marketList";
    }
}
