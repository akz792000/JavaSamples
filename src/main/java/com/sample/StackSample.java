package com.sample;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

/*
--input--
{}()
({()})
{}(
[]

--output--
true
true
false
true
*/

public class StackSample {

    public static boolean check(Stack<Character> stack) {
        int length = 3;
        int[] flag = new int[length];
        List<Character> chars = Arrays.asList('(', '[', '{', ')', ']', '}');
        while (!stack.empty()) {
            Character character = stack.pop();
            int index = chars.indexOf(character);
            if (index < length) {
                flag[index]++;
            } else {
                index = index % length;
                flag[index]--;
                if (flag[index] < 0) return false;
            }
        }
        return IntStream.of(flag).sum() == 0;
    }

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            char[] chars = input.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = chars.length - 1; i >= 0 ; i--) {
                stack.push(chars[i]);
            }
            System.out.println(check(stack));
        }
    }

}
