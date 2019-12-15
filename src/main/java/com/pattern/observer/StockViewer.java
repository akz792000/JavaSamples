package com.pattern.observer;

import java.util.Map;

public class StockViewer implements StockBroker {

    public void update(Map<String, Double> stocks) {
        System.out.println("StockViewer: stockList is changed:");
        stocks.forEach((symbol, value) -> System.out.println(symbol + " - $" + value));
    }

}
