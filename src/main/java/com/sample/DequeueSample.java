package com.sample;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

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
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.push(num);
        }

        Integer temp = deque.poll();
        while (temp != null) {
            for (int i = 0; i < m - 1; i++) {
                //int deque.peek();
            }
        }

    }
}
