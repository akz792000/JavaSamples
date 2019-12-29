package com.pattern.behavioral.visitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
