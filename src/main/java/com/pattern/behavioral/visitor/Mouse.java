package com.pattern.behavioral.visitor;

public class Mouse implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }

}
