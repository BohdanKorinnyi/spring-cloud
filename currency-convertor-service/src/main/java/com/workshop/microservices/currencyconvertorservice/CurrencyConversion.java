package com.workshop.microservices.currencyconvertorservice;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyConversion {
    private long id;
    private String from;
    private String to;
    private BigDecimal multiplier;
    private int port;
    private BigDecimal quantity;
    private BigDecimal calculatedAmount;
}
