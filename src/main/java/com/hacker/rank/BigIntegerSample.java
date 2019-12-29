package com.hacker.rank;

import java.math.BigInteger;
import java.util.Scanner;

/*
--input--
1234
20

--output--
1254
24680
*/

public class BigIntegerSample {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger first = scanner.nextBigInteger();
        BigInteger second = scanner.nextBigInteger();

        System.out.println(first.add(second));
        System.out.println(first.multiply(second));
    }

}
