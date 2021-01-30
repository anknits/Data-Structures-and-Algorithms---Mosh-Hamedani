package Heaps;

import java.util.Arrays;

public class MinHeap {
    private class Node {
        private int key;
        private String value;

        private Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[10];
    private int count;

    public MinHeap(int size) {
        array = new Node[size];
    }

    public void insert(int key, String value) {
        if (isFull())
            throw new IllegalStateException();
        array[count++] = new Node(key, value);
        bubbleUp();
    }

    public String remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = array[0];
        array[0] = array[--count];
        array[count] = null;
        bubbleDown();
        return root.value;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int min() {
        return array[0].key;
    }

    public String minValue() {
        return array[0].value;
    }

    private void bubbleDown() {
        int index = 0;
        while (index < count && !isValidParent(index)) {
            var smallerChildIndex = getSmallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void bubbleUp() {
        var index = count - 1;
        while (index > 0 && array[index].key < array[getParentIndex(index)].key) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < count;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < count;
    }

    private int getSmallerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return getLeftChildIndex(index);
        return (getLeftChildKey(index) < getRightChildKey(index)) ? getLeftChildIndex(index)
                : getRightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        var isValid = array[index].key <= getLeftChildKey(index);
        if (hasRightChild(index))
            isValid &= array[index].key <= getRightChildKey(index);
        return isValid;
    }

    private int getLeftChildKey(int index) {
        return array[getLeftChildIndex(index)].key;
    }

    private int getRightChildKey(int index) {
        return array[getRightChildIndex(index)].key;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
