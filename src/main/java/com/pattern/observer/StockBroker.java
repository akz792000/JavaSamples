package com.pattern.observer;

import java.util.Map;

public interface StockBroker {

    void update(Map<String, Double> stockList);

}
