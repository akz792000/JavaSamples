package com.pattern.behavioral.visitor;

public class SumPriceComputerPartVisitor implements ComputerPartVisitor {

    private int result;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visit(Keyboard keyboard) {
        result += 100;
    }

    @Override
    public void visit(Monitor monitor) {
        result += 200;
    }

    @Override
    public void visit(Mouse mouse) {
        result += 50;
    }

    @Override
    public void visit(Computer computer) {
        result += 0;
    }

    @Override
    public void visit(Ram ram) {
        result += 25;
    }
}
