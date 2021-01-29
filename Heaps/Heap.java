package Heaps;

import java.util.Arrays;

public class Heap {
    private int[] array = new int[10];
    private int count;

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();
        array[count++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();
        var root = array[0];
        array[0] = array[--count];
        array[count] = 0;
        bubbleDown();
        return root;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int max() {
        return array[0];
    }

    private void bubbleDown() {
        int index = 0;
        while (index < count && !isValidParent(index)) {
            var largerChildIndex = getLargerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private void bubbleUp() {
        var index = count - 1;
        while (index > 0 && array[index] > array[getParentIndex(index)]) {
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

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return getLeftChildIndex(index);
        return (getLeftChild(index) > getRightChild(index)) ? getLeftChildIndex(index) : getRightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        var isValid = array[index] >= getLeftChild(index);
        if (hasRightChild(index))
            isValid &= array[index] >= getRightChild(index);
        return isValid;
    }

    private int getLeftChild(int index) {
        return array[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return array[getRightChildIndex(index)];
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
