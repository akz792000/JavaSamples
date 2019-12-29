package com.hacker.rank;

import java.util.*;

/*
--input--
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

--output--
24
40
15
*/

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }

}

abstract class TreeVis {

    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        // nop
    }

    public void visitLeaf(TreeLeaf leaf) {
        this.result += leaf.getValue();
    }

}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor().equals(Color.RED)) {
            result = result * node.getValue() % 1000000007;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.RED)) {
            result = result * leaf.getValue() % 1000000007;
        }
    }

}

class FancyVisitor extends TreeVis {

    private int leafSum = 0;
    private int nodeSum = 0;

    public int getResult() {
        return Math.abs(leafSum - nodeSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nodeSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor().equals(Color.GREEN)) {
            leafSum += leaf.getValue();
        }
    }

}

public class VisitorPattern {

    static int[] nodeValues;
    static Color[] nodeColors;
    static Map<Integer, Set<Integer>> map;

    static class MyTreeNode extends TreeNode {

        int id;

        public MyTreeNode(int id, int value, Color color, int depth) {
            super(value, color, depth);
            this.id = id;
        }

    }

    static class MyTreeLeaf extends TreeLeaf {

        int id;

        public MyTreeLeaf(int id, int value, Color color, int depth) {
            super(value, color, depth);
            this.id = id;
        }

    }

    public static void addChildren(Tree tree, Tree parent) {
        Set<Integer> children = map.get(((MyTreeNode) tree).id);
        for (Integer child : children) {
            if (parent == null || ((MyTreeNode) parent).id != child) {
                if (map.get(child).size() == 1) {
                    ((MyTreeNode) tree).addChild(new MyTreeLeaf(child, nodeValues[child], nodeColors[child], tree.getDepth() + 1));
                } else {
                    Tree childTree = new MyTreeNode(child, nodeValues[child], nodeColors[child], tree.getDepth() + 1);
                    ((MyTreeNode) tree).addChild(childTree);
                    addChildren(childTree, tree);
                }
            }
        }
    }

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function

        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt();
        nodeValues = new int[nodeCount + 1];
        nodeColors = new Color[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            nodeValues[i] = sc.nextInt();
        }
        for (int i = 1; i <= nodeCount; i++) {
            nodeColors[i] = sc.nextInt() == 1 ? Color.GREEN : Color.RED;
        }

        // prepare map
        map = new HashMap<>();
        for (int i = 0; i < nodeCount - 1; i++) {
            int key = sc.nextInt(), value = sc.nextInt();

            // forward
            Set<Integer> values = map.get(key);
            if (values == null) {
                values = new HashSet<>();
                map.put(key, values);
            }
            values.add(value);

            // backward
            values = map.get(value);
            if (values == null) {
                values = new HashSet<>();
                map.put(value, values);
            }
            values.add(key);
        }

        // prepare tree
        Tree tree = new MyTreeNode(1, nodeValues[1], nodeColors[1], 0);
        addChildren(tree, null);
        return tree;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

}

