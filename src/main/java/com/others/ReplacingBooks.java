package com.others;

import java.util.*;

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
        Node prev;
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

        int sum(int remain, boolean calcPrev) {
            int result = weight(), placement;

            // prev
            if (calcPrev) {
                if (remain > 0) {
                    if (prev == null) {
                        placement = start;
                        if (placement >= remain) {
                            result += remain;
                            remain -= remain;
                        } else {
                            result += placement;
                            remain -= placement;
                        }
                    } else {
                        placement = start - prev.end - 1;
                        if (placement >= remain) {
                            result += remain;
                            if (placement == remain) {
                                result += prev.weight();
                            }
                            remain -= remain;
                        } else {
                            remain -= placement;
                            result += placement + prev.weight();
                        }
                    }
                }
            }

            // next
            if (remain > 0) {
                if (next == null) {
                    placement = len - end - 1;
                    if (placement >= remain) {
                        result += remain;
                        remain -= remain;
                    } else {
                        result += placement;
                        remain -= placement;
                    }
                } else {
                    placement = next.start - end - 1;
                    if (placement >= remain) {
                        result += remain;
                        if (placement == remain) {
                            result += next.weight();
                        }
                        remain -= remain;
                    } else {
                        remain -= placement;
                        result += placement + next.sum(remain, false);
                    }
                }
            }

            return result;
        }
    }

    public static int solution(int[] A, int K) {
        len = A.length;
        int result = 0;
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Node node = nodes.get(A[i]);
            if (node == null) {
                node = new ReplacingBooks().new Node(i, i);
                nodes.put(A[i], node);
            } else {
                node = node.lastNode();
                if (i == node.end + 1) {
                    node.end++;
                } else {
                    node.next = new ReplacingBooks().new Node(i, i);
                    node.next.prev = node;
                }
            }
        }

        for (Map.Entry<Integer, Node> entrySet : nodes.entrySet()) {
            Node node = entrySet.getValue();
            int sum = 0;
            while (node != null) {
                sum = node.sum(K, true);
                if (result < sum) result = sum;
                node = node.next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 4, 3, 4, 1, 1}, 2)); // 4
        System.out.println(solution(new int[]{1}, 0)); // 1
        System.out.println(solution(new int[]{1, 1, 3, 4, 3, 3, 4}, 2)); // 5
        System.out.println(solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 0)); // 2
        System.out.println(solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 1));  // 4
        System.out.println(solution(new int[]{1, 2, 1, 2, 1, 2}, 1));  // 3
        System.out.println(solution(new int[]{1, 1, 3, 1}, 2)); // 4
        System.out.println(solution(new int[]{4, 5, 5, 4, 2, 2, 4}, 0)); // 2
        System.out.println(solution(new int[]{1, 3, 3, 2}, 2)); // 4

        /*
        int[] samples = new int[Integer.MAX_VALUE];
        for (int i = 0; i< Integer.MAX_VALUE; i++) {
            samples[i] = i;
        }
        System.out.println(solution(samples, 2)); // 4
        */
    }

}
