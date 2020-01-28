package com.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReplacingBooks {

    /*
    public static int solution(int[] A, int K) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) numbers.add(A[i]);
        int res = 0;
        for (Integer number : numbers) {
            int sum = 0;
            int rem = K;
            int pos = 0;
            for (int i = pos; i < A.length; i++) {
                if (A[i] != number) {
                    if (rem > 0) {
                        rem--;
                        sum++;
                    } else {
                        if (res < sum) res = sum;
                        sum = 0;
                        rem = K;
                        while (true) {
                            pos++;
                            if (pos == A.length || A[pos] != number) break;
                        }
                        i = pos;
                    }
                } else {
                    sum++;
                }
            }
            if (res < sum) res = sum;
        }
        return res;
    }
    */

    static int len = 0;

    class Node {
        Node next;
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private Node last(Node node) {
            return node.next == null ? node : last(node.next);
        }

        Node lastNode() {
            return last(this);
        }

        private int weight() {
            return end - start + 1;
        }

        int sum(Node node, int num) {
            if (node.next == null) {
                //return weight() + (num > len ? len : num);
            } else {
                int diff = node.next.start - node.end - 1;
                if (num > diff) {
                    return node.weight() + diff;
                } else {
                    return sum(node.next, num - diff);
                }
            }

        }

    }

    public static int solution(int[] A, int K) {
        len = A.length;

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            Node node = map.get(A[i]);
            if (node == null) {
                node = new ReplacingBooks().new Node(i, i);
                map.put(A[i], node);
            } else {
                node = node.lastNode();
                if (node.end + 1 == i) {
                    node.end++;
                } else {
                    node.next = new ReplacingBooks().new Node(i, i);
                }
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Node> entrySet : map.entrySet()) {
            Node node = entrySet.getValue();
            int sum = node.
            if (result < sum) result = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(solution(new int[]{1}, 0)); // 1
        System.out.println(solution(new int[]{1, 1, 3, 4, 3, 3, 4}, 2)); // 5
       // System.out.println(solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 0)); // 2
        //System.out.println(solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 1));  // 4
        //System.out.println(solution(new int[]{1, 2, 1, 2, 1, 2}, 1));  // 3
        //System.out.println(solution(new int[]{1, 1, 3, 1}, 2)); // 4
       // System.out.println(solution(new int[]{4, 5, 5, 4, 2, 2, 4}, 0)); // 2
       // System.out.println(solution(new int[]{1, 3, 3, 2}, 2)); // 4
    }

}
