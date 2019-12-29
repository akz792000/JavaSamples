package com.hacker.rank;

import java.util.*;

/*
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type
that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
 */

public class DequeueSample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int interval = in.nextInt();

        // Pick starting point
        int max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = in.nextInt();
            deque.add(num);

            Integer val = map.get(num);
            if (val == null) {
                val = 0;
            }
            val++;
            map.put(num, val);

            if (deque.size() == interval) {
                int len = map.size();
                if (max < len) {
                    max = len;
                }

                val = deque.removeFirst();
                int cnt = map.get(val) - 1;
                if (cnt == 0) {
                    map.remove(val);
                } else {
                    map.put(val, cnt);
                }
            }
        }

        System.out.println(max);

        /*
                    Scanner in = new Scanner(System.in);
            int length = in.nextInt();
            int interval = in.nextInt();

            // Pick starting point
            int max = 0;

            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < length; i++) {
                int num = in.nextInt();
                deque.add(num);
                if (deque.size() == interval) {
                    Set<Integer> list = new HashSet<>();
                    for (Integer dequeItem : deque) {
                        list.add(dequeItem);
                    }
                    int len = list.size();
                    if (max < len) {
                        max = len;
                    }
                    deque.removeFirst();
                }
            }

            System.out.println(max);
         */
    }
}
