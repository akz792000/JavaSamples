package com.sample;

import java.util.Scanner;
/*
An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
For example, the word anagram can be rearranged into nag a ram, or the word binary into brainy or the word adobe into abode.
 */

/*
--input--
anagram
margana

--output--
Anagrams
*/

/*
--input--
anagramm
marganaa

--output--
Not Anagrams
*/

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            b = b.replaceFirst(a.substring(i, i + 1), "");
        }
        return b.equals("");
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

}
