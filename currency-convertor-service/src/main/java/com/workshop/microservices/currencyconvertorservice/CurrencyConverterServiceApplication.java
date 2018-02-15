package com.workshop.microservices.currencyconvertorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyConverterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConverterServiceApplication.class, args);
    }
}
