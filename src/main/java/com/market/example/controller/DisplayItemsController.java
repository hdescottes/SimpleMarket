package com.market.example.controller;

import com.market.example.service.MarketService;
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
    public String retrieveMarketItems(Model model) {
        model.addAttribute("items", marketService.createMarket());
        return "marketList";
    }
}
