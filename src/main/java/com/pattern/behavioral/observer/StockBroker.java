package com.pattern.behavioral.observer;

import java.util.Map;

public interface StockBroker {

    void update(Map<String, Double> stockList);

}
