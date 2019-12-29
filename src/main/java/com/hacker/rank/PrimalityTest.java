package com.hacker.rank;

import java.math.BigInteger;
import java.util.Scanner;

/*
--input--
13

--output--
prime
*/

public class PrimalityTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger number = scanner.nextBigInteger();

        System.out.println(number.isProbablePrime(1) ? "prime" : "not prime");

        scanner.close();
    }
}
