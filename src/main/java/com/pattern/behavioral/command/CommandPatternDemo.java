package com.pattern.behavioral.command;

/*
    Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.
    This transformation lets you parameterize methods with different requests, delay or queue a request’s execution, and support undoable operations.
 */

public class CommandPatternDemo {

    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.init();
    }

}
