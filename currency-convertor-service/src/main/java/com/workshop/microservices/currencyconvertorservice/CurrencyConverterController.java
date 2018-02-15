package com.workshop.microservices.currencyconvertorservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConverterController {
    private static final Logger logger = LoggerFactory.getLogger(CurrencyConverterController.class);
    @Autowired
    private CurrencyExchangeClient currencyExchangeClient;

    @GetMapping("convert-currency/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        logger.info("Got the following request, from {} to {}", from, to);
        CurrencyConversion currencyConversion = currencyExchangeClient.getCurrencyExchange(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setCalculatedAmount(quantity.multiply(currencyConversion.getMultiplier()));
        return currencyConversion;
    }
}
