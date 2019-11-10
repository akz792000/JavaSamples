package com.sample;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
--input--
5
john tom
john mary
john tom
mary anna
mary anna

--output--
1
2
2
3
3
*/

public class HashsetSample {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> sample = new HashSet<>();
        for (int i = 0; i < t; i++) {
            sample.add(pair_left[i] + "," + pair_right[i]);
            System.out.println(sample.size());
        }

    }
}
