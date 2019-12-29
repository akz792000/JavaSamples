package com.hacker.rank;

import java.util.Scanner;

/*
--input--
3 5
2 4
0 0
-1 -2
-1 3

--output--
243
16
java.lang.Exception: n and p should not be zero.
java.lang.Exception: n or p should not be negative.
java.lang.Exception: n or p should not be negative.
*/

class MyCalculatorClass {

    public long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) throw new Exception("n or p should not be negative.");
        if (n == 0 && p == 0) throw new Exception("n and p should not be zero.");
        return (long) Math.pow(n, p);
    }

}

public class ExceptionHandling {
    public static final MyCalculatorClass my_calculator = new MyCalculatorClass();
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}