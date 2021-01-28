package AVLTrees;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
            height = 0;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }
        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        root.height = calculateHeight(root);

        return root = balance(root);
    }

    private int calculateHeight(AVLNode root) {
        return Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private int height(AVLNode root) {
        return (root == null) ? -1 : root.height;
    }

    private int balanceFactor(AVLNode root) {
        return (root == null) ? 0 : height(root.leftChild) - height(root.rightChild);
    }

    private boolean isLeftHeavy(AVLNode root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(AVLNode root) {
        return balanceFactor(root) < -1;
    }

    private AVLNode balance(AVLNode root) {
        var balanceFactor = height(root.leftChild) - height(root.rightChild);
        if (isLeftHeavy(root)) {
            System.out.println(root.value + " is left heavy. BF: " + balanceFactor);
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            root = rotateRight(root);
        }
        if (isRightHeavy(root)) {
            System.out.println(root.value + " is right heavy. BF: " + balanceFactor);
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            root = rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        root.height = calculateHeight(root);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }
}
