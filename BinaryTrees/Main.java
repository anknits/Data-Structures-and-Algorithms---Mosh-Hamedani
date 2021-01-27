package BinaryTrees;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println("Equals: " + tree.equals(tree2));
        System.out.println("PreOrder");
        tree.traversePreOrder();
        System.out.println("InOrder");
        tree.traverseInOrder();
        System.out.println("PostOrder");
        tree.traversePostOrder();
        System.out.println("height: " + tree.height());
        System.out.println("min: " + tree.min());
        // tree.swapLeftRight();
        System.out.println("isBST: " + tree.isBST());
        System.out.println("getNodesAtDistance2: ");
        var nodes2 = tree.getNodesAtDistanceK(2);
        for (var node : nodes2) {
            System.out.println(node);
        }
        System.out.println("LevelOrder");
        tree.traverseLevelOrder();
        System.out.println("Size: " + tree.size());
        System.out.println("Leaves: " + tree.countLeaves());
        System.out.println("max: " + tree.max());
        System.out.println("contains 5: " + tree.contains(5));
        System.out.println("contains 6: " + tree.contains(6));
        System.out.println("areSiblings 8,6: " + tree.areSiblings(8, 6));
        System.out.println("areSiblings 9,4: " + tree.areSiblings(9, 4));
        var ancestors = tree.getAncestors(10);
        for (var node : ancestors) {
            System.out.println(node);
        }
    }
}