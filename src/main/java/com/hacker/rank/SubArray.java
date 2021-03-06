package com.hacker.rank;

import java.util.Scanner;

/*
--input--
5
1 -2 4 -5 1

--output--
9
*/

public class SubArray {

    public static void main(String[] args) {

        //Input
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] items = new int[length];
        for (int i = 0; i < length; i++) {
            items[i] = sc.nextInt();
        }
        sc.close();

        // result
        int result = 0;

        /*

        // Pick starting point
        for (int i = 0; i < length; i++) {

            // Pick ending point
            for (int j = i; j < length; j++) {

                // Print subarray between current starting
                // and ending points
                for (int k = i; k <= j; k++)
                    System.out.print(items[k] + " ");

            }
        }

        */

        // size of array element
        for (int s = 0; s < length; s++) {

            // loop for first element
            for (int i = 0; i < length - s; i++) {
                int sum = items[i];

                // add other element
                for (int k = 1; k <= s; k++) {
                    sum += items[i + k];
                }

                if (sum < 0) {
                    result++;
                }
            }
        }

        System.out.println(result);

    }

}
