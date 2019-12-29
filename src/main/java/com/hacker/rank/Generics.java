package com.hacker.rank;

import java.lang.reflect.Method;

// Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic methods.

/*
--input--

--output--
1
2
3
Hello
World
*/

class Printer {

    <T> void printArray(T objects[]) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }
}

public class Generics {

    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.equals("printArray"))
                count++;
        }

        if (count > 1) System.out.println("Method overloading is not allowed!");
    }
}
