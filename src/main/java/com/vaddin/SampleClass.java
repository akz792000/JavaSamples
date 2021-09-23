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

    public static int sample(String s) {
        int div = s.length() / 2;
        int result = 0;
        int[] arr = new int[s.length()];
        for (int i = 0; i < div; i++) {
            boolean flag = false;
            for (int j = div; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && arr[j] == 0) {
                    flag = true;
                    arr[j] = 1;
                    break;
                }
            }
            if (!flag) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(sample(4950));
        //System.out.println(sample(-4095));
        System.out.println(sample("2133326615727117001540261141407327120031612260317493998987993857958996993904815918596499598790384428"));
    }

}
