package com.market.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.market.example"})
public class SimpleMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleMarketApplication.class, args);
    }

}
