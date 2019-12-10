package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
--input--
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5

--output--
74
52
37
ERROR!
ERROR!
*/

public class ArraylistSample {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt(); // denoting number of integers
            List items = new ArrayList();
            for (int j = 0; j < d; j++) {
                items.add(sc.nextInt());
            }
            list.add(items);
        }

        int q = sc.nextInt(); // denoting number of queries
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                System.out.println(list.get(x - 1).get(y - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
