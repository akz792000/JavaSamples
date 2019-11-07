package com.sample;

import java.util.Scanner;
import java.util.function.Function;

/*
--input--
4
5 3
0 0 0 0 0
6 5
0 0 0 1 1 1
6 3
0 0 1 1 1 0
3 1
0 1 0

--output--
YES
YES
NO
NO
*/

public class FirstDArrayPart2 {

    /*
    public static boolean canWin(int index, int leap, int[] game) {

        if (index + 1 == game.length || index + leap >= game.length) {
            return true;
        } else {
            int newIndex = index + leap;
            if (newIndex >= 0 && newIndex < game.length && newIndex != index) {
                if (game[newIndex] == 0) {
                    if (canWin(newIndex, leap, game)) return true;
                }
            }

            newIndex = index + 1;
            if (newIndex >= 0 && newIndex < game.length && newIndex != index) {
                if (game[newIndex] == 0) {
                    if (canWin(newIndex, leap, game)) return true;
                }
            }

            newIndex = index - 1;
            if (newIndex >= 0 && newIndex < game.length && newIndex != index) {
                if (game[newIndex] == 0) {
                    game[newIndex] = 1;
                    if (canWin(newIndex, leap, game)) return true;
                }
            }
            return false;
        }

    }*/


    public static boolean canWin(int index, int leap, int[] game) {
        if (index + 1 == game.length || index + leap >= game.length) {
            return true;
        } else {
            Function<Integer, Boolean> func = item -> {
                if (item >= 0 && item < game.length && item != index && game[item] == 0) {
                    game[item] = 1;
                    return canWin(item, leap, game);
                }
                return false;
            };

            int newIndex = index + leap;
            if (func.apply(newIndex)) return true;

            newIndex = index + 1;
            if (func.apply(newIndex)) return true;

            newIndex = index - 1;
            if (func.apply(newIndex)) return true;

            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(0, leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }

}
