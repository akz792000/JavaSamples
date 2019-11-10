package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
--input--
5
12 0 1 78 12
2
Insert
5 23
Delete
0

--output--
0 1 78 12 23
*/

public class ListSample {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> items = new ArrayList();
        for (int i = 0; i < n; i++) {
            items.add(sc.nextInt());
        }

        int q = sc.nextInt(); // queries on the list
        for (int i = 0; i < q; i++) {
            sc.nextLine(); // go to the next line after read integer values
            String query = sc.nextLine();

            switch (query) {
                case "Insert":
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    items.add(x, y);
                    break;
                case "Delete":
                    items.remove(sc.nextInt());
                    break;
            }
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.print(items.get(i) + " ");
        }
    }

}
