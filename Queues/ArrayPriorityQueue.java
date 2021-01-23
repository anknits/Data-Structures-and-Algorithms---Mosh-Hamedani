package Queues;

import java.util.Arrays;

public class ArrayPriorityQueue {
    private int[] arr;
    private int count = 0;

    public ArrayPriorityQueue(int capacity) {
        arr = new int[capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == arr.length;
    }

    public void enqueue(int i) {
        if (isFull())
            throw new IllegalStateException();
        var index = shiftItemsToInsert(i);
        arr[index] = i;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        var first = arr[0];
        for (int i = 0; i < count; i++)
            arr[i] = arr[i + 1];
        arr[--count] = 0;
        return first;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (arr[i] > item)
                arr[i + 1] = arr[i];
            else
                break;
        }
        return i + 1;
    }
}
