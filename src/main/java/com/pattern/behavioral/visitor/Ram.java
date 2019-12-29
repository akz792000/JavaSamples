package com.pattern.behavioral.visitor;

public class Ram implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }

}
