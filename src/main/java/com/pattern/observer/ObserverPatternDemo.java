package com.pattern.observer;

/*
    Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects
    about any events that happen to the object they’re observing.
 */

public class ObserverPatternDemo {

    public static void main(String[] args) {
        AbstractStockMarket market = new StockMarket();

        market.addStockBroker(new StockBuyer());
        market.addStockBroker(new StockViewer());

        market.addStock("ORC", 12.23);
        market.addStock("MSC", 45.78);

        System.out.println("===== Updating ORC =====");
        market.update("ORC", 12.34);

        System.out.println("===== Updating MSC =====");
        market.update("MSC", 44.68);
    }

}
