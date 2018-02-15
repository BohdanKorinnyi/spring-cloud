package com.workshop.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
        logger.info("Got the following request, from {} to {}", from, to);
        return currencyExchangeRepository.findByFromAndTo(from, to);
    }
}
