package com.others;

import java.util.*;

public class ReplacingBooks {

    public static int solution0(int[] A, int K) {
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

    //==================================================================================================================
    //==================================================================================================================
    //==================================================================================================================

    static int len = 0;

    enum Direction {BACKWARD, FORWARD}

    static class Remain {
        int val;

        Remain(int val) {
            this.val = val;
        }
    }

    static class Node {

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

        int sum(Remain remain, Direction direction) {
            int result = weight(), placement;
            Node node = direction.equals(Direction.FORWARD) ? next : prev;
            if (remain.val > 0) {
                if (node == null) {
                    placement = direction.equals(Direction.FORWARD) ? len - end - 1 : start;
                    if (placement >= remain.val) {
                        result += remain.val;
                        remain.val -= remain.val;
                    } else {
                        result += placement;
                        remain.val -= placement;
                    }
                } else {
                    placement = direction.equals(Direction.FORWARD) ? node.start - end - 1 : start - node.end - 1;
                    if (placement >= remain.val) {
                        result += remain.val;
                        if (placement == remain.val) {
                            result += node.weight();
                        }
                        remain.val -= remain.val;
                    } else {
                        remain.val -= placement;
                        result += placement + node.sum(remain, direction);
                    }
                }
            }
            return result;
        }

        int sum(int K) {
            int result = 0;
            Remain remain;
            Node node = this;
            while (node != null) {
                remain = new Remain(K);
                int sum = -node.weight();
                sum += node.sum(remain, Direction.BACKWARD);
                sum += node.sum(remain, Direction.FORWARD);
                if (result < sum) result = sum;
                node = node.next;
            }
            return result;
        }

    }

    public static int solution1(int[] A, int K) {
        len = A.length;
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Node node = nodes.get(A[i]);
            if (node == null) {
                node = new Node(i, i);
                nodes.put(A[i], node);
            } else {
                node = node.lastNode();
                if (i == node.end + 1) {
                    node.end++;
                } else {
                    node.next = new Node(i, i);
                    node.next.prev = node;
                }
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Node> entrySet : nodes.entrySet()) {
            Node node = entrySet.getValue();
            int sum = node.sum(K);
            if (result < sum) result = sum;
        }
        return result;
    }

    //==================================================================================================================
    //==================================================================================================================
    //==================================================================================================================

    public int solution2(int[] A, int K) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) numbers.add(A[i]);
        int res = 0;
        for (Integer number : numbers) {
            int sum = 0;
            int before = 0;
            int rem = K;
            Queue<Integer> pos = new LinkedList<>();
            for (int i = 0; i < A.length; i++) {
                if (A[i] != number) {
                    if (rem > 0) {
                        rem--;
                        sum++;
                    } else {
                        if (res < sum) res = sum;
                        if (K > 0) {
                            sum -= pos.isEmpty() ? 1 : pos.poll();
                            if (sum < 0) sum = 0;
                        } else {
                            sum = 0;
                        }
                    }
                    pos.add(before);
                    before = 0;
                } else {
                    sum++;
                    before++;
                }
            }
            if (res < sum) res = sum;
        }
        return res;
    }

    //==================================================================================================================
    //==================================================================================================================
    //==================================================================================================================

    static class LinkedNode {
        final int val;
        LinkedNode next;

        LinkedNode(int val) {
            this.val = val;
        }

        private LinkedNode last(LinkedNode linkedNode) {
            return linkedNode.next == null ? linkedNode : last(linkedNode.next);
        }

        LinkedNode lastNode() {
            return last(this);
        }

    }

    static class PositionQueue {

        LinkedNode node;

        boolean isEmpty() {
            return node == null;
        }

        void add(int val) {
            if (isEmpty()) {
                node = new LinkedNode(val);
            } else {
                LinkedNode temp = node.lastNode();
                temp.next = new LinkedNode(val);
            }
        }

        int poll() {
            int result = node.val;
            node = node.next;
            return result;
        }
    }

    public static int solution(int[] A, int K) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) numbers.add(A[i]);
        int res = 0;
        for (Integer number : numbers) {
            int sum = 0;
            int before = 0;
            int rem = K;
            PositionQueue position = new PositionQueue();
            for (int i = 0; i < A.length; i++) {
                if (A[i] != number) {
                    if (rem > 0) {
                        rem--;
                        sum++;
                    } else {
                        if (res < sum) res = sum;
                        if (K > 0) {
                            sum -= position.isEmpty() ? 1 : position.poll();
                            if (sum < 0) sum = 0;
                        } else {
                            sum = 0;
                        }
                    }
                    position.add(before);
                    before = 0;
                } else {
                    sum++;
                    before++;
                }
            }
            if (res < sum) res = sum;
        }
        return res;
    }

    //==================================================================================================================
    //==================================================================================================================
    //==================================================================================================================




    public static void main(String[] args) {
        System.out.println("13 " + solution(new int[]{1, 3, 3, 2, 2, 3, 3, 3}, 1) + " " + 4);

        System.out.println("1 " + solution(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2}, 0) + " " + 4);
        System.out.println("2 " + solution(new int[]{1, 1, 0, 1, 1, 0, 0, 0, 0}, 1) + " " + 5);
        System.out.println("3 " + solution(new int[]{1, 2, 3, 4, 5, 6, 7, 2, 1, 1, 1, 3, 1}, 5) + " " + 9);
        System.out.println("4 " + solution(new int[]{1, 1, 4, 3, 4, 1, 1}, 2) + " " + 4);
        System.out.println("5 " + solution(new int[]{1}, 0) + " " + 1);
        System.out.println("6 " + solution(new int[]{1, 1, 3, 4, 3, 3, 4}, 2) + " " + 5);
        System.out.println("7 " + solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 0) + " " + 2);
        System.out.println("8 " + solution(new int[]{1, 2, 1, 2, 2, 1, 2}, 1) + " " + 4);
        System.out.println("9 " + solution(new int[]{1, 2, 1, 2, 1, 2}, 1) + " " + 3);
        System.out.println("10 " + solution(new int[]{1, 1, 3, 1}, 2) + " " + 4);
        System.out.println("11 " + solution(new int[]{4, 5, 5, 4, 2, 2, 4}, 0) + " " + 2);
        System.out.println("12 " + solution(new int[]{1, 3, 3, 2}, 2) + " " + 4);
        System.out.println("13 " + solution(new int[]{1, 3, 3, 2, 2, 3, 3, 3}, 1) + " " + 4);

    }

}
