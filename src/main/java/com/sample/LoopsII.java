package com.sample;

import java.util.Scanner;

public class LoopsII {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int m = a;
            for (int j = 0; j < n; j++) {
                m = m + (int) Math.pow(2, j) * b;
                System.out.printf("%d ", m);
            }
            System.out.println();
        }
        in.close();
    }

}
