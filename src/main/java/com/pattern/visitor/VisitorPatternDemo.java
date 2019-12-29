package com.pattern.visitor;

/*
    The visitor design pattern is a behavioral design pattern and is a way of separating an algorithm from an object structure on which it operates.
    A practical result of this separation is the ability to add new operations to existing object structures without modifying the structures.
 */

public class VisitorPatternDemo {

    public static void main(String[] args) {

        SumPriceComputerPartVisitor sumPriceComputerPartVisitor = new SumPriceComputerPartVisitor();
        CountComputerPartVisitor countComputerPartVisitor = new CountComputerPartVisitor();

        Computer computer = new Computer();
        computer.addChild(new Keyboard());
        computer.addChild(new Mouse());
        computer.addChild(new Monitor());
        computer.addChild(new Ram());
        computer.addChild(new Ram());

        computer.accept(sumPriceComputerPartVisitor);
        computer.accept(countComputerPartVisitor);

        System.out.println(sumPriceComputerPartVisitor.getResult());
        System.out.println(countComputerPartVisitor.getResult());
    }

}
