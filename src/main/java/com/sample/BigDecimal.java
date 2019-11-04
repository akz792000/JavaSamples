package com.sample;

import java.util.Arrays;
import java.util.Scanner;

/*
--input--
9
-100
50
0
56.6
90
0.12
.12
02.34
000.000

--output--
90
56.6
50
02.34
0.12
.12
0
000.000
-100
*/

public class BigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here
        Arrays.sort(s, (o1, o2) -> {
                    if (o1 == null || o2 == null) {
                        return 0;
                    }
                    return (int) Math.floor(Double.parseDouble(o2) - Double.parseDouble(o1));
                }
        );

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
