package com.hacker.rank;

import java.util.Scanner;

/*
--input--
5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000

--output--
-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long
*/

public class Datatypes {

    public static void main(String[] argh) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {

            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                // 8 (2^7,2^7 - 1)
                if (x >= -128 && x <= 127) System.out.println("* byte");
                // 16 (2^15,2^15 - 1)
                if (x >= -32768 && x <= 32767) System.out.println("* short");
                // 32 (2^31,2^31 - 1)
                if (x >= -2147483648 && x <= 2147483647l) System.out.println("* int");
                // 64 (2^63,-2^63 - 1)
                if (x >= -9223372036854775808l && x <= 9223372036854775807l) System.out.println("* long");
                //Complete the code
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}
