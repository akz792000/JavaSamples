package com.hacker.rank;

import java.util.Scanner;

/*
--input--
madam

--output--
Yes
*/

public class StringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();

        String reverse = "";
        for (int i = A.length() - 1; i >= 0; i--) {
            reverse = reverse + A.charAt(i);
        }
        System.out.println(A.equals(reverse) ? "Yes" : "No");

    }

}
