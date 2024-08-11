package com.Tipico;


import java.util.stream.Collectors;
import java.util.stream.IntStream;




public class CharacterOdd {
    public static void main(String[] args) {
        int n = 4;
        String result = generateLettersStream(n);
        System.out.println("Result: " + result);
    }

    public static String generateLettersStream(int n) {
        return IntStream.rangeClosed('a', 'z')
                .mapToObj(ch -> String.valueOf((char) ch).repeat((ch - 'a' + 1) * 2 - 1))
                .filter(str -> !str.isEmpty())
                .flatMap(str -> str.chars().mapToObj(c -> String.valueOf((char) c)))
                .limit(n).collect(Collectors.joining());
    }
}
