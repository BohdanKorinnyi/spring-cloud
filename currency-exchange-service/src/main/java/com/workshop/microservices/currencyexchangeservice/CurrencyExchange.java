package com.workshop.microservices.currencyexchangeservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "from_currency")
    private String from;
    @Column(name = "to_currency")
    private String to;
    private BigDecimal multiplier;
    private int port;

    public CurrencyExchange() {
    }

    public CurrencyExchange(String from, String to, BigDecimal multiplier, int port) {
        this.from = from;
        this.to = to;
        this.multiplier = multiplier;
        this.port = port;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", multiplier=" + multiplier +
                ", port=" + port +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
