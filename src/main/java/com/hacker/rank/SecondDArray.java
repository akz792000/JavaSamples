package com.hacker.rank;

import java.util.Scanner;

/*
--input--
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

--output--
19
*/

public class SecondDArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        Integer result = null;
        for (int w = 0; w < 4; w++) {
            for (int k = 0; k < 4; k++) {
                int temp =
                        arr[w][k] + arr[w][k + 1] + arr[w][k + 2] +
                        arr[w + 1][k + 1] +
                        arr[w + 2][k] + arr[w + 2][k + 1] + arr[w + 2][k + 2];
                if (result == null || temp > result.intValue()) {
                    result = temp;
                }
            }
        }
        System.out.println(result);
    }

}
