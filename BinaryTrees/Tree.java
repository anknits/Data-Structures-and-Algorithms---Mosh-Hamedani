package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        var node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        var current = root;
        while (current != null) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    return;
                } else
                    current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    return;
                } else
                    current = current.rightChild;
            } else
                throw new IllegalStateException();
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traversePreOrder(root.leftChild);
        System.out.println(root.value);
        traversePreOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root))
            return root.value;
        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree tree) {
        if (tree == null)
            return false;
        return equals(root, tree.root);
    }

    private boolean equals(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 != null && root2 != null)
            return root1.value == root2.value && equals(root1.leftChild, root2.leftChild)
                    && equals(root1.rightChild, root2.rightChild);
        return false;
    }

    private boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        return root.value > min && root.value < max && isBST(root.leftChild, min, root.value)
                && isBST(root.rightChild, root.value, max);
    }

    public void swapLeftRight() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public ArrayList<Integer> getNodesAtDistanceK(int k) {
        if (root == null)
            throw new IllegalStateException();
        var list = new ArrayList<Integer>();
        getNodesAtDistanceK(root, k, list);
        return list;
    }

    private void getNodesAtDistanceK(Node root, int k, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (k == 0) {
            // System.out.println(root.value);
            list.add(root.value);
            return;
        }
        getNodesAtDistanceK(root.leftChild, k - 1, list);
        getNodesAtDistanceK(root.rightChild, k - 1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++)
            for (var value : getNodesAtDistanceK(i))
                System.out.println(value);
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;
        if (isLeaf(root))
            return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (isLeaf(root))
            return root.value;
        var left = max(root.leftChild);
        var right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSiblings(int a, int b) {
        return areSiblings(root, a, b);
    }

    private boolean areSiblings(Node root, int a, int b) {
        if (root == null)
            return false;
        if (root.leftChild == null || root.rightChild == null)
            return false;
        if (root.leftChild.value == a && root.rightChild.value == b)
            return true;
        if (root.leftChild.value == b && root.rightChild.value == a)
            return true;
        return areSiblings(root.leftChild, a, b) || areSiblings(root.rightChild, a, b);
    }

    public ArrayList<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        list.remove(list.indexOf(value));
        return list;
    }

    private void getAncestors(Node root, int value, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (contains(root, value))
            list.add(root.value);
        getAncestors(root.leftChild, value, list);
        getAncestors(root.rightChild, value, list);
    }

}

// BFS - 20,10,30,6,14,24,3,8,26
// DFS PreOrder root-left-right- 20,10,6,3,8,14,30,24,26
// DFS InOrder left-root-right- 3,6,8,10,14,20,24,26,30
// DFS PostOrder left-right-root- 3,8,6,14,10,26,24,30,20