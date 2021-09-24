package com.zalando;

public class Third {

    public static int solution(int[] A) {
        int result = 0;
        int len = A.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 2; j < len; j++) {
                int temp = A[i] + A[j];
                if (result == 0 || result > temp) {
                    result = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(solution(new int[]{5, 2, 4, 6, 3, 7}));
    }
}
