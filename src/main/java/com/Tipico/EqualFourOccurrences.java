package com.Tipico;


public class EqualFourOccurrences {
    public static void main(String[] args) {
        int[] array1 = {2, -2, -3, 3};
        int[] array2 = {0, 0, 4, -4};

        int result = solution(array1, array2);
        System.out.println("Number of positions with equal sums: " + result);
    }

    public static int solution(int[] A, int[] B) {
        int occurrences = 0;
        int sumFA = 0, sumFB = 0;
        int sumLA, sumLB;

        for (int i = 0; i < A.length - 1; i++) {
            sumFA += A[i];
            sumFB += B[i];

            sumLA = 0;
            sumLB = 0;
            if (sumFA == sumFB) {
                for (int j = A.length - 1; j > i; j--) {
                    sumLA += A[j];
                    sumLB += B[j];
                }

                if (sumFA == sumLA && sumFB == sumLB) {
                    occurrences++;
                }
            }
        }

        return occurrences;
    }
}
