package com.hacker.rank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/*
--input--
3
([A-Z])(.+)
[AZ[a-z](a-z)
batcatpat(nat

--output--
Valid
Invalid
Invalid
*/

public class PatternSyntaxChecker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String pattern = in.nextLine();
            testCases--;
            try {
                Pattern.compile(pattern);
            } catch (PatternSyntaxException exception) {
                System.out.println("Invalid");
                continue;
            }
            System.out.println("Valid");
        }
    }
}
