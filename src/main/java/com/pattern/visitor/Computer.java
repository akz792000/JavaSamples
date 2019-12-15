package com.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class Computer implements ComputerPart {

    private List<ComputerPart> parts = new ArrayList<>();

    public void addChild(ComputerPart part) {
        parts.add(part);
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }

}
