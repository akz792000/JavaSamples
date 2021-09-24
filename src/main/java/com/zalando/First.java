package com.zalando;

public class First {

    public static int solution(String S) {
        int result = 0;
        int length = S.length();
        if (length >= 2 && length <= 100) {
            for (int i = 0; i < S.length() - 1; i++) {
                int num = Integer.valueOf(S.substring(i, i + 2));
                if (num > result) {
                    result = num;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(solution("50552"));
    }
}
