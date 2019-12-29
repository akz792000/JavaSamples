package com.hacker.rank;

import java.util.Scanner;

/*
--input--
10
3

--output--
3
*/

/*
--input--
10
Hello

--output--
java.util.InputMismatchException
*/

/*
--input--
10
0

--output--
java.lang.ArithmeticException: / by zero
*/

/*
--input--
23.323
0

--output--
java.util.InputMismatchException
*/

public class ExceptionHandlingTryCatch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();

        try {
            Integer numberX = Integer.parseInt(x);
            Integer numberY = Integer.parseInt(y);
            System.out.println(numberX / numberY);
        } catch (ArithmeticException ex) {
            System.out.println("java.lang.ArithmeticException: / by zero");
        } catch (NumberFormatException ex) {
            System.out.println("java.util.InputMismatchException");
        }


    }
}
