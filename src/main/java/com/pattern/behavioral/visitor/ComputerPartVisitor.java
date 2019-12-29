package com.pattern.behavioral.visitor;

public interface ComputerPartVisitor {

    int getResult();

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);

    void visit(Mouse mouse);

    void visit(Computer computer);

    void visit(Ram ram);

}
