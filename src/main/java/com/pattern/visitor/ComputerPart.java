package com.pattern.visitor;

public interface ComputerPart {

    void accept(ComputerPartVisitor visitor);

}
