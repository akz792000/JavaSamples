package com.sample;

import java.util.Scanner;

/*
--input--
Helloworld
3 7

--output--
lowo
*/

public class Substring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(S.substring(start, end));
    }
}
