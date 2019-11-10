package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
--input--
3
uncle sam
99912222
tom
11122222
harry
12299933
uncle sam
uncle tom
harry

--output--
uncle sam=99912222
Not found
harry=12299933
*/

public class MapSample {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            map.put(name, phone);
            in.nextLine();
        }
        while (in.hasNext()) {
            String key = in.nextLine();
            Integer value = map.get(key);
            if (value == null) {
                System.out.println("Not found");
            } else {
                System.out.println(key + "=" + value);
            }
        }
    }

}
