package com.vaddin;

public class SampleClass {

    public static int sample(int num) {
        String str = String.valueOf(num);
        boolean plus = false;
        if (str.charAt(0) != '-') {
            str = '+' + str;
            plus = true;
        }
        String result = "";
        Boolean insert = false;
        for (int i = 1; i < str.length(); i++) {
            int n = Integer.parseInt(Character.toString(str.charAt(i)));
            if (!insert) {
                if (plus) {
                    if (5 >= n) {
                        result += "5";
                        insert = true;
                    }
                } else {
                    if (5 <= n) {
                        result += "5";
                        insert = true;
                    }
                }
            }
            result += n;
        }
        return plus ? Integer.parseInt(result) : -Integer.parseInt(result);
    }

    public static void main(String[] args) {
        System.out.println(sample(4950));
        System.out.println(sample(-4095));
    }

}
