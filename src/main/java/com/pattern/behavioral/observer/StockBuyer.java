package com.pattern.behavioral.observer;

import java.util.Map;

public class StockBuyer implements StockBroker {

    public void update(Map<String, Double> stocks) {
        System.out.println("StockBuyer: stockList is changed:");
        stocks.forEach((symbol, value) -> System.out.println(symbol + " - $" + value));
    }

}
