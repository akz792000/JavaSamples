package com.sample;

import java.util.Scanner;

/*
--input--
Hello world
I am a file
Read me until end-of-file.

--output--
1 Hello world
2 I am a file
3 Read me until end-of-file.
*/

public class EndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int count = 1;

        while (s.hasNext()) {
            String ns = s.nextLine();
            System.out.println(count + " " + ns);
            count++;
        }
    }

}
