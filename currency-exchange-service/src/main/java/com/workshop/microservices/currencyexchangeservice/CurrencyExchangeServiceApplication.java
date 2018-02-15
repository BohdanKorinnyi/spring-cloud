package com.workshop.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@EnableDiscoveryClient //to registry in eureka
@SpringBootApplication
public class CurrencyExchangeServiceApplication {
    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    @Autowired
    public CurrencyExchangeServiceApplication(CurrencyExchangeRepository currencyExchangeRepository, Environment environment) {
        this.currencyExchangeRepository = currencyExchangeRepository;
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }

    @PostConstruct
    protected void init() {
        Integer port = Integer.valueOf(environment.getProperty("server.port"));
        currencyExchangeRepository.save(new CurrencyExchange("USD", "EUR", new BigDecimal(60), port));
        currencyExchangeRepository.save(new CurrencyExchange("USD", "INR", new BigDecimal(25), port));
        currencyExchangeRepository.save(new CurrencyExchange("USD", "USS", new BigDecimal(11), port));
        currencyExchangeRepository.save(new CurrencyExchange("USD", "SMA", new BigDecimal(23), port));
        currencyExchangeRepository.save(new CurrencyExchange("USD", "BAC", new BigDecimal(100), port));
    }
}
