package com.market.example.controller;

import com.market.example.ApplicationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ApplicationTest
class DisplayItemsControllerTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void retrieveMarketItems_ShouldSucceed() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("items"))
                .andExpect(view().name("marketList"));
    }

    @Test
    void retrieveBasketPrice_ShouldSucceed() throws Exception {
        this.mockMvc.perform(get("/basketList"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("map"))
                .andExpect(view().name("basketList"));
    }
}
