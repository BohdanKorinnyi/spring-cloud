package com.workshop.microservices.currencyconvertorservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service") //use without zuul
@FeignClient(name = "zuul-api-getaway-proxy")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeClient {
//    @GetMapping("/currency-exchange/{from}/to/{to}") //use without zuul
    @GetMapping("currency-exchange-service/currency-exchange/{from}/to/{to}")
    CurrencyConversion getCurrencyExchange(@PathVariable(name = "from") String from, @PathVariable(name = "to") String to);
}
