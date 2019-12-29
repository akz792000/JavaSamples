package com.hacker.rank;

import java.util.Scanner;

/*
--input--
He is a very very good boy, isn't he?

--output--
10
He
is
a
very
very
good
boy
isn
t
he
*/

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String delims = "[ !,?.\\_'@]+";
        String[] tokens;
        if (s == null || s.equals("")) {
            System.out.println("0");
            return;
        } else if (s.length() > 400000) {
            return;
        } else {
            tokens = s.split(delims);
            System.out.println(tokens.length);
        }
        for (String word : tokens) {
            System.out.println(word);
        }
        scan.close();
    }
}
