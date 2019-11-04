package com.sample;

import java.util.Scanner;

/*
--input--
42
3.1415
Welcome to HackerRank's Java tutorials!

--output--
String: Welcome to HackerRank's Java tutorials!
Double: 3.1415
Int: 42
*/

public class StdInOutII {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s = scan.nextLine();
        s = scan.nextLine();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }

}
