package com.sample;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
--input--
5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1

--output--
0 0
1 0
1 1
1 2
*/

public class BitSetSample {

    public static void main(String[] args) {

/*
        int n = 12345;
        BitSet bs = BitSet.valueOf(new long[]{n});
        long l = bs.toLongArray()[0];
        System.out.println(l);

 */

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        BitSet[] b = new BitSet[2];
        b[0] = new BitSet();
        b[1] = new BitSet();

        int cnt = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            String operator = sc.next();
            int first = sc.nextInt();
            int second = sc.nextInt();
            switch (operator) {
                case "AND":
                    b[first - 1].and(b[second - 1]);
                    break;
                case "OR":
                    b[first - 1].or(b[second - 1]);
                    break;
                case "XOR":
                    b[first - 1].xor(b[second - 1]);
                    break;
                case "SET":
                    b[first - 1].set(second);
                    break;
                case "FLIP":
                    b[first - 1].flip(second);
                    break;
            }
            System.out.println(b[0].cardinality() + " " + b[1].cardinality());
        }

    }

}
