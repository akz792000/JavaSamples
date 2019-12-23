package com.pattern.observer;

/*
    behavioral pattern
    The Observer pattern, also known as the Publish-Subscriber pattern, is one of the behavioral design patterns
    that defines a one-to-many relationship between objects. For example, when the state of one object is
    modified, all its dependents are notified and updated automatically.
    Mainly, this pattern is used to implement distributed event handling systems.
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
