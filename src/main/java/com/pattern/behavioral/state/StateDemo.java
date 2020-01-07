package com.pattern.behavioral.state;

/*
    State is a behavioral design pattern that lets an object alter its behavior when its internal state changes.
    It appears as if the object changed its class.
 */

public class StateDemo {

    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }

}
