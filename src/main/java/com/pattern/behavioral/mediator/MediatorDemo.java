package com.pattern.behavioral.mediator;

/*
    Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects.
    The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.
 */

import javax.swing.*;

public class MediatorDemo {

    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }

}
