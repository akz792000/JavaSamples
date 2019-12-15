package com.pattern.observer;

import java.util.HashMap;
import java.util.Map;

public class StockMarket extends AbstractStockMarket {

    private Map<String, Double> stockList = new HashMap<>();

    public void addStock(String stockSymbol, Double price) {
        stockList.put(stockSymbol, price);
    }

    public void update(String stockSymbol, Double price) {
        stockList.put(stockSymbol, price);
        notifyStockBroker(stockList);
    }

}
