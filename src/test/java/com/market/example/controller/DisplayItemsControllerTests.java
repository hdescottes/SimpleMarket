package com.market.example.controller;

import com.market.example.ApplicationTest;
import com.market.example.model.Fruit;
import com.market.example.model.FruitListWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.market.example.constant.FruitConstants.APPLE_PRICE;
import static com.market.example.constant.FruitConstants.ORANGE_PRICE;
import static com.market.example.constant.FruitConstants.WATERMELON_PRICE;
import static com.market.example.constant.FruitEnum.APPLE;
import static com.market.example.constant.FruitEnum.ORANGE;
import static com.market.example.constant.FruitEnum.WATERMELON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ApplicationTest
class DisplayItemsControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void retrieveMarketItems_ShouldSucceed() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("wrapper"))
                .andExpect(view().name("marketList"));
    }

    @Test
    void sendBasket_ShouldSucceed() throws Exception {
        List<Fruit> fruitList = new ArrayList<>(Arrays.asList(
                new Fruit(APPLE, APPLE_PRICE, 0),
                new Fruit(ORANGE, ORANGE_PRICE, 0),
                new Fruit(WATERMELON, WATERMELON_PRICE, 0)));

        this.mockMvc.perform(post("/")
                .flashAttr("wrapper", new FruitListWrapper(fruitList)))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/basketList"));
    }

    @Test
    void retrieveBasketPrice_ShouldSucceed() throws Exception {
        this.mockMvc.perform(get("/basketList"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("map"))
                .andExpect(view().name("basketList"));
    }
}
