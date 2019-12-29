package com.hacker.rank;

import java.util.Scanner;

/*
--input--
000.12.12.034
121.234.12.12
23.45.12.56
00.12.123.123123.123
122.23
Hello.IP

--output--
true
true
true
false
false
false
*/

public class Regex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

}

class MyRegex {
    String pattern = "^(([01]?\\d?\\d?|[2][0-4]\\d?|[2][5][0-5])\\.){3}(([01]?\\d?\\d?|[2][0-4]\\d?|[2][5][0-5]))$";
}
