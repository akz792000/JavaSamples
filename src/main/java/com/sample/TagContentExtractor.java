package com.sample;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
--input--
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

--output--
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>
*/

public class TagContentExtractor {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();

            int cnt = 0;
            Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
            Matcher m = r.matcher(line);
            while (m.find()) {
                if (m.group(2).length() != 0) {
                    System.out.println(m.group(2));
                    cnt++;
                }
            }
            if (cnt == 0) System.out.println("None");

            testCases--;
        }
    }
}
