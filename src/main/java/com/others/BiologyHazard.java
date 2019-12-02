package com.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
--input--
14
7
1
2
4
6
7
9
10
7
3
4
5
7
12
2
8

--output--
36
*/

public class BiologyHazard {

    public static void main(String[] args) {

        //Input
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        // affected
        int affectedLength = sc.nextInt();
        List<Integer> affected = new ArrayList<>();
        for (int i = 0; i < affectedLength; i++) {
            affected.add(sc.nextInt());
        }

        // poisonous
        int poisonousLength = sc.nextInt();
        List<Integer> poisonous = new ArrayList<>();
        for (int i = 0; i < poisonousLength; i++) {
            poisonous.add(sc.nextInt());
        }

        // items
        int[] items = new int[length];
        for (int i = 0; i < length; i++) {
            items[i] = i + 1;
        }
        sc.close();

        //=====================================================================
        //=====================================================================
        //=====================================================================

        long timeStart = System.currentTimeMillis();

        // result
        long result = length * (length + 1) / 2;

        long[] map = new long[length + 1];
        for (int a = 0; a < affectedLength; a++) {
            int start = affected.get(a), end = poisonous.get(a);
            if (start > end) {
                start = poisonous.get(a);
                end = affected.get(a);
            }

            while (start >= 1) {
                long num = map[start];
                if (num == 0) {
                    map[start] = end;
                } else {
                    if (end < num) {
                        map[start] = end;
                    }
                }
                start--;
            }
        }

        for (long item : map) {
            if (item != 0) {
                result -= (length - item + 1);
            }
        }

        System.out.println(result);
        System.out.println("Execution time (currentTimeMillis) = " + ((System.currentTimeMillis() - timeStart) / 1000F));

        /*
        // result
        int result = 0;

        // Pick starting point
        for (int i = 1; i <= length; i++) {

            // Pick ending point
            for (int j = i; j <= length; j++) {

                boolean flag = true;

                // Print subarray between current starting
                // and ending points

                if (i != j) {
                    for (int a = 0; a < affectedLength; a++) {
                        Integer affect = affected.get(a);
                        if (affect >= i && affect <= j) {
                            Integer poison = poisonous.get(a);
                            if (poison >= i && poison <= j) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }

                if (!flag) break;

                result++;
            }
        }

        System.out.println(result);
        */

    }


}
