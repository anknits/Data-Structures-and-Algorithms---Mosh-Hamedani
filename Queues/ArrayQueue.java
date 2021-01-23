package Queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] arr;
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public ArrayQueue(int capacity) {
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
        count++;
        arr[tail] = i;
        tail = (tail + 1) % arr.length;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();
        var first = arr[head];
        arr[head] = 0;
        head = (head + 1) % arr.length;
        count--;
        return first;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return arr[head];
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

}
