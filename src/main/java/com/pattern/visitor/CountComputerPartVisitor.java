package com.pattern.visitor;

public class CountComputerPartVisitor implements ComputerPartVisitor {

    private int result;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visit(Keyboard keyboard) {
        result += 1;
    }

    @Override
    public void visit(Monitor monitor) {
        result += 1;
    }

    @Override
    public void visit(Mouse mouse) {
        result += 1;
    }

    @Override
    public void visit(Computer computer) {
        result += 0;
    }

    @Override
    public void visit(Ram ram) {
        result += 1;
    }
}
